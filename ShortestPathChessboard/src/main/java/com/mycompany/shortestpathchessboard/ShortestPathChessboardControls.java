
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    JLabel output;
    JTextArea textArea, toNode;
    JButton resetbtn;
    ArrayPos currentFigurePos, currentTargetPos;
    ArrayPos defaultFigurePos = new ArrayPos(0, 0);
    String inputFigurePosStr;

    int moves = 0;

    LinkedList<ArrayPos> newList = new LinkedList<ArrayPos>();
    ArrayList<LinkedList> levelListsCollector = new ArrayList<LinkedList>();

    ArrayPos temp;

    String failure = "Node is not found!";

    ChessBoardPos root;
    ChessBoardPos tar;

    LinkedList<ArrayPos> visitedNodes = new LinkedList<ArrayPos>();

    ImageIcon figure = new ImageIcon("horse.jpg");
    ImageIcon target = new ImageIcon("target.jpg");
    private boolean foundInFirstTry = false;

    public ShortestPathChessboardControls() {
        super("Shortest Path Chessboard");

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        createChessBoardPane();
        createInputPane();

        //size of window
        setSize(500, 500);
        setResizable(false);
        setVisible(rootPaneCheckingEnabled);
        setFigurePos(defaultFigurePos);
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

    private void setFigurePos(ArrayPos pos) {
        if (currentFigurePos != null)
        {
            System.out.println("Previous x= " + currentFigurePos.getX() + " Previous y= " + currentFigurePos.getY());
            squares[currentFigurePos.getX()][currentFigurePos.getY()].setIcon(null);
        }
        figure = resizeIcon(figure, squares[pos.getX()][pos.getY()].getWidth(), squares[pos.getX()][pos.getY()].getHeight());
        System.out.println("New x= " + pos.getX() + " New y= " + pos.getY());
        squares[pos.getX()][pos.getY()].setIcon(figure);
        currentFigurePos = pos;
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
                        squares[currentTargetPos.getX()][currentTargetPos.getY()].setIcon(null);
                    }
                    fromNode.setText("");
                    toNode.setText("");
                    textArea.setText("");
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

    private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private boolean isSquareOnBoard(ArrayPos a) {
        if ((a.getX() >= 0 && a.getX() <= 7) && (a.getY() >= 0 && a.getY() <= 7))
        {
            return true;
        }
        return false;
    }

    private void setTargetPos(ArrayPos aPos) {
        if (currentFigurePos != null)
        {
            if (currentTargetPos != null)
            {
                //System.out.println("aPos.x= " + aPos.getX() + " aPos.y= " + aPos.getY());

                if (aPos.equals(currentFigurePos))
                {
                    //alert to select new target and null the target
                    System.out.println("CurrentTargetPos is equal to CurrentFigurePos");
                    //delete the previous target icon
                    squares[currentTargetPos.getX()][currentTargetPos.getY()].setIcon(null);
                    toNode.setText(null);

                } else
                {
                    System.out.println("CurrentTargetPos is NOT null");
                    squares[currentTargetPos.getX()][currentTargetPos.getY()].setIcon(null);
                    //System.out.println("Previous TargetPos.x= " + currentTargetPos.getX() + " Previous TargetPos.y= " + currentTargetPos.getY());
                    //System.out.println("CurrentFigurePos.x= " + currentFigurePos.getX() + " CurrentFigurePos.y= " + currentFigurePos.getY());
                    target = resizeIcon(target, squares[aPos.getX()][aPos.getY()].getWidth(), squares[aPos.getX()][aPos.getY()].getHeight());
                    squares[aPos.getX()][aPos.getY()].setIcon(target);
                    currentTargetPos = aPos;
                    ChessBoardPos currentChessPos = getChessBoardPos(currentTargetPos);
                    toNode.setText(currentChessPos.getLetter() + String.valueOf(currentChessPos.getNumber()));
                    //first level list - list of root node
                    LinkedList<ArrayPos> firstLevelList = calcHorsePossibleNextNodes(currentFigurePos);
                    StringBuilder sb = new StringBuilder("");
                    root = getChessBoardPos(currentFigurePos);
                    tar = getChessBoardPos(currentTargetPos);

                    calculateShortestPath(firstLevelList);
                    if (isTargetNodeFoundYet())
                    {

                        System.out.println("Visited path nodes: ");

                        if (visitedNodes.size() > 0)
                        {
                            sb.append(root.toString()).append("->");
                            for (ArrayPos node : visitedNodes)
                            {
                                sb.append(String.valueOf(getChessBoardPos(node).toString() + "->"));
                                //textArea.
                            }
                            sb.append(tar.toString());
                            System.out.println(sb.toString());
                            textArea.setText(sb.toString());
                        }
                    } else
                    {
                        if (foundInFirstTry)
                        {
                            sb.append(root.toString()).append("->").append(tar.toString());
                            textArea.setText(sb.toString());
                            System.out.println(sb.toString());
                        } else
                        {
                            textArea.setText(failure);
                        }
                    }

                }

            } else
            {
                System.out.println("CurrentTargetPos is NULL!");
                target = resizeIcon(target, squares[aPos.getX()][aPos.getY()].getWidth(), squares[aPos.getX()][aPos.getY()].getHeight());
                squares[aPos.getX()][aPos.getY()].setIcon(target);
                currentTargetPos = aPos;
                ChessBoardPos currentChessPos = getChessBoardPos(currentTargetPos);
                toNode.setText(currentChessPos.getLetter() + String.valueOf(currentChessPos.getNumber()));
                //first level list - list of root node
                LinkedList<ArrayPos> firstLevelList = calcHorsePossibleNextNodes(currentFigurePos);
                StringBuilder sb = new StringBuilder("");
                root = getChessBoardPos(currentFigurePos);
                tar = getChessBoardPos(currentTargetPos);
                calculateShortestPath(firstLevelList);

                if (isTargetNodeFoundYet())
                {
                    root = getChessBoardPos(currentFigurePos);
                    tar = getChessBoardPos(currentTargetPos);
                    System.out.println("Visited path nodes: ");

                    if (visitedNodes.size() > 0)
                    {
                        sb.append(root.toString()).append("->");
                        for (ArrayPos node : visitedNodes)
                        {
                            sb.append(String.valueOf(getChessBoardPos(node).toString() + "->"));
                            //textArea.
                        }
                        sb.append(tar.toString());
                        System.out.println(sb.toString());
                        textArea.setText(sb.toString());
                    }
                } else
                {
                    if (foundInFirstTry)
                    {
                        sb.append(root.toString()).append("->").append(tar.toString());
                        textArea.setText(sb.toString());
                        System.out.println(sb.toString());
                    } else
                    {
                        textArea.setText(failure);
                    }
                }
            }
        }

    }

    //method that calculates the s
    private void calculateShortestPath(LinkedList<ArrayPos> list) {
        LinkedList<ArrayPos> notVisitedPossibleNodes = new LinkedList<ArrayPos>();

        if (moves < 3)
        {
            System.out.println("Searching for node: ( " + currentTargetPos.getX() + "," + currentTargetPos.getY() + " ) --> ( " + getChessBoardPos(currentTargetPos) + " )");

            if (list.contains(currentTargetPos))
            {
                visitedNodes.add(currentTargetPos);
                System.out.println("Node found in " + moves + " moves!");
                foundInFirstTry = true;
                return;
            } else
            {
                System.out.println("Possible moves to nodes: ");
                System.out.println("List size= " + list.size());

                for (int count = 0; count < list.size(); count++)
                {

                    ArrayPos temp = list.get(count);

                    //add every node we visit in visited nodes list in order not to visit it again               
                    visitedNodes.add(temp);

                    System.out.println("Iteration: " + moves + " Node= ( " + temp.getX() + "," + temp.getY() + " )");
                    notVisitedPossibleNodes = calcHorsePossibleNextNodes(temp);

                    System.out.println("notVisitedPossibleNodes.size():  " + notVisitedPossibleNodes.size());

                    if (!(notVisitedPossibleNodes.isEmpty()))
                    {
                        System.out.println("notVisitedPossibleNodes is not empty!");
                        levelListsCollector.add(notVisitedPossibleNodes);
                        moves++;
                    }
                }
                calculateShortestPath(notVisitedPossibleNodes);
            }
        }
    }

    private boolean isTargetNodeFoundYet() {

        System.out.println("levelListsCollector.size()= " + levelListsCollector.size());

        for (LinkedList l : levelListsCollector)
        {
            if (l.contains(currentTargetPos))
            {
                System.out.println("currentTargetPos is FOUND in " + moves + " moves!");
                return true;
            }
        }
        System.out.println("currentTargetPos is NOT FOUND in " + moves + " moves.");
        return false;
    }

    private LinkedList<ArrayPos> calcHorsePossibleNextNodes(ArrayPos a) {

        int row = a.getX();
        int col = a.getY();
        ArrayPos[] nodes = new ArrayPos[8];
        //List to contain all possible nodesArrayPos
        LinkedList<ArrayPos> possibleSquares = new LinkedList<ArrayPos>();

        //all possible next squares for horse figure based on horse moves pattern
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
            //add only valid squares that are on board and has not been visited
            if (isSquareOnBoard(nodes[j]) && !nodes[j].equals(currentFigurePos) && !visitedNodes.contains(nodes[j]))
            {
                System.out.println("calcHorsePossibleNextNodes: Node to be added: ( " + nodes[j].getX() + "," + nodes[j].getY() + " )");
                possibleSquares.add(nodes[j]);
            }
        }
        return possibleSquares;
    }

    private void validateInputAndSetFigurePos() {

        inputFigurePosStr = fromNode.getText().trim();

        //sets the figure to the selected position!
        if (!inputFigurePosStr.equals("") && (inputFigurePosStr.length() == 2) && inputFigurePosStr.matches("[a-hA-H][1-8]"))
        {
            char letter = inputFigurePosStr.charAt(0);
            int number = Character.getNumericValue(inputFigurePosStr.charAt(1));

            //System.out.println("The input String is valid and is: " + inputFigurePosStr);
            //in case the input letter is in lower case, make it upper case
            if (Character.isLowerCase(letter))
            {
                letter = Character.toUpperCase(letter);
            }

            ChessBoardPos inputChessPos = new ChessBoardPos(letter, number);

            ArrayPos inputPos = getArrayPos(inputChessPos);

            //change the figure position to inputted position value 
            if (currentTargetPos != null)
            {
                squares[currentTargetPos.getX()][currentTargetPos.getY()].setIcon(null);
            }
            toNode.setText(null);

            //since the figure position is changed, there are not any visited nodes or list of nodes
            visitedNodes.clear();
            levelListsCollector.clear();
            moves = 0;

            setFigurePos(inputPos);

        } //if there is no input for desired figure porisition, set figure to default position (0,0)
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid square coordinates");
            fromNode.setText(null);
        }
    }

    private ChessBoardPos getChessBoardPos(ArrayPos arPos) {

        ChessBoardPos result = new ChessBoardPos('\u0000', 0);

        switch (arPos.getY())
        {
            case 0:
                result.setLetter('A');
                break;
            case 1:
                result.setLetter('B');
                break;
            case 2:
                result.setLetter('C');
                break;
            case 3:
                result.setLetter('D');
                break;
            case 4:
                result.setLetter('E');
                break;
            case 5:
                result.setLetter('F');
                break;
            case 6:
                result.setLetter('G');
                break;
            case 7:
                result.setLetter('H');
                break;
            default:

        }
        switch (arPos.getX())
        {
            case 0:
                result.setNumber(8);
                break;
            case 1:
                result.setNumber(7);
                break;
            case 2:
                result.setNumber(6);
                break;
            case 3:
                result.setNumber(5);
                break;
            case 4:
                result.setNumber(4);
                break;
            case 5:
                result.setNumber(3);
                break;
            case 6:
                result.setNumber(2);
                break;
            case 7:
                result.setNumber(1);
                break;
            default:

        }
        return result;
    }

    private ArrayPos getArrayPos(ChessBoardPos chessPos) {

        ArrayPos result = new ArrayPos(0, 0);

        switch (chessPos.getLetter())
        {
            case 'A':
                result.setY(0);
                break;
            case 'B':
                result.setY(1);
                break;
            case 'C':
                result.setY(2);
                break;
            case 'D':
                result.setY(3);
                break;
            case 'E':
                result.setY(4);
                break;
            case 'F':
                result.setY(5);
                break;
            case 'G':
                result.setY(6);
                break;
            case 'H':
                result.setY(7);
                break;
            default:

        }
        switch (chessPos.getNumber())
        {
            case 8:
                result.setX(0);
                break;
            case 7:
                result.setX(1);
                break;
            case 6:
                result.setX(2);
                break;
            case 5:
                result.setX(3);
                break;
            case 4:
                result.setX(4);
                break;
            case 3:
                result.setX(5);
                break;
            case 2:
                result.setX(6);
                break;
            case 1:
                result.setX(7);
                break;
            default:

        }
        return result;
    }
}
