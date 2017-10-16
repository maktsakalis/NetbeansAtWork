
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author makis
 */
public class ShortestPathChessboardControls extends JFrame {
    
    private JPanel topPanel, chessBoardPane, controlsPane;
    private JButton[][] squares = new JButton[8][8];
    
    JLabel from = new JLabel("Path from node:");
    JTextField fromNode = new JTextField(2);
    JLabel to;
    //JTextField toNode;
    JLabel output;
    JTextArea textArea, toNode;
    JButton resetbtn;
    ArrayPos currentFigurePos, currentTargetPos;
    ArrayPos defaultFigurePos = new ArrayPos(0, 0);
    String inputFigurePosStr;
    
    LinkedHashMap<ArrayPos, ChessBoardPos> ArrayNumToChessNumMap = new LinkedHashMap<ArrayPos, ChessBoardPos>();
    
    int row = 0;
    int column = 0;
    static int iterations = 0;
    ImageIcon figure = new ImageIcon("horse.jpg");
    ImageIcon target = new ImageIcon("target.jpg");
    
    public ShortestPathChessboardControls() {
        super("Shortest Path Chessboard");
        
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        createChessBoardPane();
        createInputPane();

        //System.out.println(ArrayNumToChessNumMap);
        for (Map.Entry<ArrayPos, ChessBoardPos> entry : ArrayNumToChessNumMap.entrySet())
        {
            ArrayPos key = entry.getKey();
            ChessBoardPos b = entry.getValue();

            //System.out.println(key.x + "," + key.y + " == " + b.letter + "," + b.number);
        }
        //size of window
        setSize(500, 500);
        setResizable(false);
        setVisible(rootPaneCheckingEnabled);
        
        currentFigurePos = defaultFigurePos;
        setFigurePos(currentFigurePos);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void createChessBoardPane() {
        chessBoardPane = new JPanel();
        chessBoardPane.setLayout(new GridLayout(8, 8));
        
        char let = 'H';
        short num = 8;
        JLabel numbers;//= new JLabel(" to node:");
        JLabel letters;//= new JLabel(" Output: ");

        for (int i = 0; i < 8; i++)
        {
            //numbers = new JLabel(String.valueOf(num--));
            //chessBoardPane.add(numbers);

            for (int j = 0; j < 8; j++)
            {
                squares[i][j] = new JButton();
                
                ArrayPos arrayPos = new ArrayPos(i, j);

                //returns an object of chess kind!
                ChessBoardPos chessPos = getChessBoardPos(arrayPos);
                
                squares[i][j].addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        setTargetPos(arrayPos);
                    }
                });

                //mapper from i,j to chess position codes
                ArrayNumToChessNumMap.put(arrayPos, chessPos);
                
                if ((i + j) % 2 != 0)
                {
                    squares[i][j].setBackground(java.awt.Color.GREEN);
                } else
                {
                    squares[i][j].setBackground(java.awt.Color.GRAY);
                }
                chessBoardPane.add(squares[i][j]);
                
            }

            //System.out.println(let--);
        }
        
        topPanel.add(chessBoardPane, BorderLayout.CENTER);
    }
    
    private void setFigurePos(ArrayPos arrayPos) {
        squares[currentFigurePos.x][currentFigurePos.y].setIcon(null);
        System.out.println(squares[arrayPos.x][arrayPos.y].getWidth());
        System.out.println(squares[arrayPos.x][arrayPos.y].getHeight());
        
        figure = resizeIcon(figure, squares[arrayPos.x][arrayPos.y].getWidth(), squares[arrayPos.x][arrayPos.y].getHeight());
        squares[arrayPos.x][arrayPos.y].setIcon(figure);
        
        currentFigurePos = arrayPos;
    }
    
    public void createInputPane() {
        
        controlsPane = new JPanel();
        controlsPane.setLayout(new BorderLayout());
        
        JPanel inputs = new JPanel();
        inputs.setLayout(new FlowLayout());
        
        from = new JLabel("Path from node:");
        fromNode = new JTextField(2);
        fromNode.setEditable(true);
        
        fromNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateInputAndSetFigurePos();
            }
        });
        
        to = new JLabel(" to node:");
        toNode = new JTextArea(1, 2);
        toNode.setEditable(false);
        output = new JLabel(" Output: ");
        textArea = new JTextArea(1, 10);
        resetbtn = new JButton("Reset");
        
        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (e.getSource() == resetbtn)
                {
                    //set figure position to default node
                    setFigurePos(defaultFigurePos);

                    //delete any target nodes
                    if (currentTargetPos != null)
                    {
                        squares[currentTargetPos.x][currentTargetPos.y].setIcon(null);
                    }
                    fromNode.setText("");
                    toNode.setText("");
                    textArea.setText("");
                    //default title and icon
                }
            }
        });
        
        textArea.setEditable(false);
        //resetbtn.setActionCommand("Reset");

        inputs.add(from);
        inputs.add(fromNode);
        inputs.add(to);
        inputs.add(toNode);
        inputs.add(output);
        inputs.add(textArea);
        
        controlsPane.add(inputs, BorderLayout.LINE_START);
        controlsPane.add(resetbtn, BorderLayout.LINE_END);
        
        topPanel.add(controlsPane, BorderLayout.PAGE_END);
    }

    //method that calculates the s
    private void /*LinkedList<ArrayPos>*/ calculateShortestPath(ArrayPos figurePos) {
        
        int row = figurePos.x;
        int col = figurePos.y;
        int i = 0;
        
        ArrayPos[] nodes = new ArrayPos[8];
        //List to contain all possible nodes
        LinkedList<ArrayPos> possibleSquares = new LinkedList<ArrayPos>();
        
        if ((row >= 0 && row <= 7) && (col >= 0 && col <= 7))
        {
            nodes[0] = new ArrayPos(row - 2, col - 1);
            nodes[1] = new ArrayPos(row - 1, col - 2);
            nodes[2] = new ArrayPos(row - 2, col + 1);
            nodes[3] = new ArrayPos(row - 1, col + 2);
            nodes[4] = new ArrayPos(row + 1, col - 2);
            nodes[5] = new ArrayPos(row + 2, col - 1);
            nodes[6] = new ArrayPos(row + 1, col + 2);
            nodes[7] = new ArrayPos(row + 2, col + 1);
            
            for (int j = 0; j < nodes.length; j++)
            {
                //add only valid squares that are on board
                if (isSquareOnBoard(nodes[j]))
                {
                    possibleSquares.add(nodes[j]);
                }
            }
            for (ArrayPos a : possibleSquares)
            {
                System.out.println("Possible moves to nodes" + a.x + "," + a.y);
            }
            System.out.println("Does list contain target= " + possibleSquares.contains(currentTargetPos));
/*            
            while (!possibleSquares.contains(currentTargetPos))
            {
                for (ArrayPos a : possibleSquares)
                {
                    calculateShortestPath(a);
                }
                
            }
*/
        }

        //chessPos = getChessBoardPos(arrayPos);        
        //textArea.setText("Button: " + chessPos.letter + chessPos.number);
    }
    
    private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    
    private boolean isSquareOnBoard(ArrayPos a) {
        if ((a.x >= 0 && a.x <= 7) && (a.y >= 0 && a.y <= 7))
        {
            return true;
        }
        return false;
    }
    
    private void setTargetPos(ArrayPos arrayPos) {
        if (currentFigurePos != null)
        {
            if (currentTargetPos != null)
            {
                System.out.println("arrayPos.x= " + arrayPos.x + " arrayPos.y= " + arrayPos.y);
                System.out.println("currentFigurePos.x= " + arrayPos.x + " currentFigurePos.y= " + arrayPos.y);
                
                if (arrayPos.equals(currentFigurePos))
                {
                    //alert to select new target and null the target
                    System.out.println("CurrentTargetPos is equal to CurrentFigurePos");
                    //delete the previous target icon
                    squares[currentTargetPos.x][currentTargetPos.y].setIcon(null);
                    
                } else
                {
                    System.out.println("CurrentTargetPos is NOT null");
                    squares[currentTargetPos.x][currentTargetPos.y].setIcon(null);
                    System.out.println("CurrentTargetPos.x= " + currentTargetPos.x + " CurrentTargetPos.y= " + currentTargetPos.y);
                    System.out.println("CurrentFigurePos.x= " + currentFigurePos.x + " CurrentFigurePos.y= " + currentFigurePos.y);
                    target = resizeIcon(target, squares[arrayPos.x][arrayPos.y].getWidth(), squares[arrayPos.x][arrayPos.y].getHeight());
                    squares[arrayPos.x][arrayPos.y].setIcon(target);
                    currentTargetPos = arrayPos;
                    ChessBoardPos currentChessPos = getChessBoardPos(currentTargetPos);
                    toNode.setText(currentChessPos.letter + String.valueOf(currentChessPos.number));
                    calculateShortestPath(currentFigurePos);
                }
                
            } else
            {
                System.out.println("CurrentTargetPos is NULL!");
                target = resizeIcon(target, squares[arrayPos.x][arrayPos.y].getWidth(), squares[arrayPos.x][arrayPos.y].getHeight());
                squares[arrayPos.x][arrayPos.y].setIcon(target);
                currentTargetPos = arrayPos;
                ChessBoardPos currentChessPos = getChessBoardPos(currentTargetPos);
                toNode.setText(currentChessPos.letter + String.valueOf(currentChessPos.number));
                calculateShortestPath(currentFigurePos);
            }
        }
        
    }
    
    private void validateInputAndSetFigurePos() {
        
        inputFigurePosStr = fromNode.getText().trim();

        //sets the figure to the selected position!
        if (!inputFigurePosStr.equals("") && (inputFigurePosStr.length() == 2) && inputFigurePosStr.matches("[a-hA-H][1-8]"))
        {
            char letter = inputFigurePosStr.charAt(0);
            int number = Character.getNumericValue(inputFigurePosStr.charAt(1));
            
            System.out.println("The input String is valid and is: " + inputFigurePosStr);

            //in case the input letter is in lower case, make it upper case
            if (Character.isLowerCase(letter))
            {
                letter = Character.toUpperCase(letter);
            }
            
            ChessBoardPos inputChessPos = new ChessBoardPos(letter, number);
            System.out.println("inputChessPos.letter= " + inputChessPos.letter + " inputChessPos.number= " + inputChessPos.number);
            
            ArrayPos inputPos = getArrayPos(inputChessPos);
            System.out.println("inputPos.x= " + inputPos.x + " inputPos.y= " + inputPos.y);
            
            squares[currentTargetPos.x][currentTargetPos.y].setIcon(null);
            //change the figure position to inputted position value 
            setFigurePos(inputPos);
            
            
        } //if there is no input for desired figure porisition, set figure to default position (0,0)
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid square coordinates");
            fromNode.setText(null);
            currentFigurePos = defaultFigurePos;
        }
    }
    
    private ChessBoardPos getChessBoardPos(ArrayPos arrayPos) {
        
        ChessBoardPos result = new ChessBoardPos('\u0000', 0);
        
        switch (arrayPos.y)
        {
            case 0:
                result.letter = 'A';
                break;
            case 1:
                result.letter = 'B';
                break;
            case 2:
                result.letter = 'C';
                break;
            case 3:
                result.letter = 'D';
                break;
            case 4:
                result.letter = 'E';
                break;
            case 5:
                result.letter = 'F';
                break;
            case 6:
                result.letter = 'G';
                break;
            case 7:
                result.letter = 'H';
                break;
            default:
            
        }
        switch (arrayPos.x)
        {
            case 0:
                result.number = 8;
                break;
            case 1:
                result.number = 7;
                break;
            case 2:
                result.number = 6;
                break;
            case 3:
                result.number = 5;
                break;
            case 4:
                result.number = 4;
                break;
            case 5:
                result.number = 3;
                break;
            case 6:
                result.number = 2;
                break;
            case 7:
                result.number = 1;
                break;
            default:
            
        }
        return result;
    }
    
    private ArrayPos getArrayPos(ChessBoardPos chessPos) {
        
        ArrayPos result = new ArrayPos(0, 0);
        
        switch (chessPos.letter)
        {
            case 'A':
                result.y = 0;
                break;
            case 'B':
                result.y = 1;
                break;
            case 'C':
                result.y = 2;
                break;
            case 'D':
                result.y = 3;
                break;
            case 'E':
                result.y = 4;
                break;
            case 'F':
                result.y = 5;
                break;
            case 'G':
                result.y = 6;
                break;
            case 'H':
                result.y = 7;
                break;
            default:
            
        }
        switch (chessPos.number)
        {
            case 8:
                result.x = 0;
                break;
            case 7:
                result.x = 1;
                break;
            case 6:
                result.x = 2;
                break;
            case 5:
                result.x = 3;
                break;
            case 4:
                result.x = 4;
                break;
            case 3:
                result.x = 5;
                break;
            case 2:
                result.x = 6;
                break;
            case 1:
                result.x = 7;
                break;
            default:
            
        }
        return result;
    }
}
