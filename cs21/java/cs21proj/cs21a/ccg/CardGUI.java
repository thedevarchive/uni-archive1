
/**
 * Write a description of class CardGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class CardGUI extends JFrame
{
    private JLabel play1; 
    private JLabel play2; 
    private JLabel choice; 
    private JLabel win1; 
    private JLabel win2; 

    private JLabel cName1;
    private JLabel cName2; 
    private JLabel cType1; 
    private JLabel cType2; 
    private JLabel cAt1; 
    private JLabel cAt2; 
    private JLabel cHp1; 
    private JLabel cHp2; 

    private JTextArea log; 

    private JTextField name1; 
    private JTextField name2; 

    private JButton start; 
    private JButton atk1;
    private JButton swap1;
    private JButton atk2; 
    private JButton swap2; 
    private JButton rd;
    private JButton custom; 

    private JPanel pan1; 
    private JPanel sg1; //subgrid 1
    private JPanel f1; //format 1
    private JPanel sg2; 
    private JPanel f2; 
    private JPanel sg3; 
    private JPanel sg4; 
    private JPanel pan2; 
    private JPanel sg5; 
    private JPanel sg6; 

    private JScrollPane scr; 

    // This is where I discovered adding the scroll bar
    // http://stackoverflow.com/questions/14914060/how-can-i-size-a-java-swing-jtextarea

    private static boolean indc = true; 

    //true = one's turn, false = two's turn

    private Player one; 
    private Player two; 
    private Arbiter ai; 

    private String win = ""; 

    public CardGUI()
    {
        setLayout(new BorderLayout());
        pan1 = new JPanel(); 
        pan1.setLayout(new GridLayout(4, 1)); //make a grid in the north

        sg1 = new JPanel(); 
        sg1.setLayout(new GridLayout(1, 4)); // make a grid for the player 1 name
        play1 = new JLabel("Player 1"); 
        sg1.add(play1); // add text field to subgrid
        win1 = new JLabel("");
        sg1.add(win1); 
        play2 = new JLabel("Player 2");
        sg1.add(play2); // add text field to subgrid
        win2 = new JLabel(""); 
        sg1.add(win2); 
        pan1.add(sg1); // add the subgrid to the main grid's first row 

        sg2 = new JPanel();
        sg2.setLayout(new GridLayout(1, 2)); 
        name1 = new JTextField(""); 
        sg2.add(name1); 
        name2 = new JTextField("");
        sg2.add(name2); 
        pan1.add(sg2); 

        sg3 = new JPanel(); 
        sg3.setLayout(new GridLayout(1, 4)); 
        atk1 = new JButton("Attack"); 
        swap1 = new JButton("Swap"); 
        atk2 = new JButton("Attack"); 
        swap2 = new JButton("Swap"); 
        sg3.add(atk1); 
        sg3.add(swap1);
        sg3.add(atk2); 
        sg3.add(swap2); 
        pan1.add(sg3); 

        sg4 = new JPanel(); 
        sg4.setLayout(new FlowLayout());
        start = new JButton("Start Game");
        sg4.add(start); 
        rd = new JButton("Random Deal"); 
        sg4.add(rd); 
        custom = new JButton("Start New Deck"); 
        sg4.add(custom); 
        pan1.add(sg4);
        add(pan1, BorderLayout.NORTH); //set main grid to north

        pan2 = new JPanel(); 
        //pan2.setBackground(Color.ORANGE); 
        pan2.setLayout(new GridLayout(2, 1)); 

        sg5 = new JPanel(); 
        sg5.setLayout(new GridLayout(2, 2)); 
        cName1 = new JLabel("");
        cType1 = new JLabel(""); 
        cAt1 = new JLabel(""); 
        cHp1 = new JLabel("");
        sg5.add(cName1); 
        sg5.add(cType1); 
        sg5.add(cAt1); 
        sg5.add(cHp1); 
        pan2.add(sg5); 

        sg6 = new JPanel(); 
        sg6.setLayout(new GridLayout(2, 2)); 
        cName2 = new JLabel(""); 
        cType2 = new JLabel(""); 
        cAt2 = new JLabel(""); 
        cHp2 = new JLabel("");
        sg6.add(cName2); 
        sg6.add(cType2); 
        sg6.add(cAt2); 
        sg6.add(cHp2); 
        pan2.add(sg6); 

        // I discovered textAreas, and learned how to not make them editable here.
        // http://codereview.stackexchange.com/questions/25461/simple-chat-room-swing-gui
        // This is where I learned to size a textArea.
        // http://stackoverflow.com/questions/14914060/how-can-i-size-a-java-swing-jtextarea

        log = new JTextArea(); 
        log.setEditable(false); 
        //log.setBackground(Color.WHITE); 
        scr = new JScrollPane(log); 
        pan2.add(scr); 
        add(pan2, BorderLayout.CENTER); 

        atk1.setEnabled(false); 
        atk2.setEnabled(false); 
        swap1.setEnabled(false); 
        swap2.setEnabled(false); 

        class gameStart implements ActionListener
        {
            public void actionPerformed(ActionEvent a)
            {
                log.setText(""); 
                String text1 = name1.getText(); 
                String text2 = name2.getText();
                one = new Player(text1); 
                two = new Player(text2); 
                ai = new Arbiter(one, two);
                String receive = "";

                for (int i = 0; i < 12; i++)
                {
                    receive = ai.dealCard(); 
                    log.append(receive); 
                }

                cName1.setText((one.getActiveCard()).getName()); 
                cType1.setText((one.getActiveCard()).getType());
                cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints()); 
                cName2.setText((two.getActiveCard()).getName()); 
                cType2.setText((two.getActiveCard()).getType());
                cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints()); 

                start.setEnabled(false);  
                atk1.setEnabled(true); 
                swap1.setEnabled(true); 
                rd.setEnabled(false); 
                custom.setEnabled(false); 
            }
        }
        start.addActionListener(new gameStart());

        class shuffle implements ActionListener
        {
            public void actionPerformed(ActionEvent d)
            {
                log.setText(""); 
                String text1 = name1.getText(); 
                String text2 = name2.getText();
                one = new Player(text1); 
                two = new Player(text2); 
                ai = new Arbiter(one, two);  
                ai.shuffleDeck(); 
                String receive = "";

                for (int i = 0; i < 12; i++)
                {
                    receive = ai.dealCard(); 
                    log.append(receive); 
                }

                cName1.setText("");
                cType1.setText(""); 
                cAt1.setText(""); 
                cHp1.setText("");
                cName2.setText(""); 
                cType2.setText(""); 
                cAt2.setText(""); 
                cHp2.setText(""); 

                if(one.getActiveCard() != null)
                {
                    cName1.setText((one.getActiveCard()).getName()); 
                    cType1.setText((one.getActiveCard()).getType());
                    cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                    cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints());  
                }
                if(two.getActiveCard() != null)
                {
                    cName2.setText((two.getActiveCard()).getName()); 
                    cType2.setText((two.getActiveCard()).getType());
                    cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                    cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints());
                }

                start.setEnabled(false);  
                atk1.setEnabled(true); 
                swap1.setEnabled(true); 
                rd.setEnabled(false); 
            }
        }
        rd.addActionListener(new shuffle()); 

        class newDeck implements ActionListener
        {
            public void actionPerformed(ActionEvent f)
            {
                log.setText(""); 
                String text1 = name1.getText(); 
                String text2 = name2.getText();
                one = new Player(text1); 
                two = new Player(text2); 
                ai = new Arbiter(one, two); 
                ai.assembleNewDeck();
                //ai.shuffleDeck(); 
                String receive = "";

                for (int i = 0; i < 12; i++)
                {
                    receive = ai.dealCard(); 
                    log.append(receive); 
                }

                cName1.setText("");
                cType1.setText(""); 
                cAt1.setText(""); 
                cHp1.setText("");
                cName2.setText(""); 
                cType2.setText(""); 
                cAt2.setText(""); 
                cHp2.setText(""); 

                if(one.getActiveCard() != null)
                {
                    cName1.setText((one.getActiveCard()).getName()); 
                    cType1.setText((one.getActiveCard()).getType());
                    cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                    cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints());  
                }
                if(two.getActiveCard() != null)
                {
                    cName2.setText((two.getActiveCard()).getName()); 
                    cType2.setText((two.getActiveCard()).getType());
                    cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                    cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints());
                }

                start.setEnabled(false);  
                atk1.setEnabled(true); 
                swap1.setEnabled(true); 
                rd.setEnabled(false); 
                custom.setEnabled(false); 
            }
        }
        custom.addActionListener(new newDeck());

        class choiceAtk1 implements ActionListener
        {
            public void actionPerformed(ActionEvent b)
            {
                String receive = ""; 
                receive = ai.play("attack");
                log.append("----\n"); 
                log.append(receive);  

                cName1.setText("");
                cType1.setText(""); 
                cAt1.setText(""); 
                cHp1.setText("");
                cName2.setText(""); 
                cType2.setText(""); 
                cAt2.setText(""); 
                cHp2.setText(""); 

                if(one.getActiveCard() != null)
                {
                    cName1.setText((one.getActiveCard()).getName()); 
                    cType1.setText((one.getActiveCard()).getType());
                    cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                    cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints());  
                }
                if(two.getActiveCard() != null)
                {
                    cName2.setText((two.getActiveCard()).getName()); 
                    cType2.setText((two.getActiveCard()).getType());
                    cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                    cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints());
                }
                atk1.setEnabled(false);
                swap1.setEnabled(false); 
                atk2.setEnabled(true); 
                swap2.setEnabled(true);
                win = ""; 
                for(int i = 0; i < one.getTokenCount(); i++)
                {
                    win = win + "*";
                }
                win1.setText(win); 
                if(ai.hasWinner())
                { 
                    start.setEnabled(true); 
                    atk1.setEnabled(false); 
                    atk2.setEnabled(false); 
                    swap1.setEnabled(false); 
                    swap2.setEnabled(false);
                    rd.setEnabled(true); 
                    custom.setEnabled(true); 
                } 
            }
        }
        atk1.addActionListener(new choiceAtk1()); 
        class choiceAtk2 implements ActionListener
        {
            public void actionPerformed(ActionEvent b)
            {
                String receive = ""; 
                receive = ai.play("attack");
                log.append("----\n"); 
                log.append(receive);  

                cName1.setText("");
                cType1.setText(""); 
                cAt1.setText(""); 
                cHp1.setText("");
                cName2.setText(""); 
                cType2.setText(""); 
                cAt2.setText(""); 
                cHp2.setText(""); 

                if(one.getActiveCard() != null)
                {
                    cName1.setText((one.getActiveCard()).getName()); 
                    cType1.setText((one.getActiveCard()).getType());
                    cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                    cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints());  
                }
                if(two.getActiveCard() != null)
                {
                    cName2.setText((two.getActiveCard()).getName()); 
                    cType2.setText((two.getActiveCard()).getType());
                    cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                    cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints());
                }
                atk2.setEnabled(false);
                swap2.setEnabled(false); 
                atk1.setEnabled(true); 
                swap1.setEnabled(true); 
                win = ""; 
                for(int i = 0; i < two.getTokenCount(); i++)
                {
                    win = win + "*";
                }
                win2.setText(win);
                if(ai.hasWinner())
                { 
                    start.setEnabled(true); 
                    atk1.setEnabled(false); 
                    atk2.setEnabled(false); 
                    swap1.setEnabled(false); 
                    swap2.setEnabled(false);
                    rd.setEnabled(true); 
                    custom.setEnabled(true); 
                } 
            }
        }
        atk2.addActionListener(new choiceAtk2());
        class choiceSwp1 implements ActionListener
        {
            public void actionPerformed(ActionEvent c)
            {
                String receive = ""; 
                receive = ai.play("swap");
                log.append("----\n"); 
                log.append(receive);

                cName1.setText("");
                cType1.setText(""); 
                cAt1.setText(""); 
                cHp1.setText("");
                cName2.setText(""); 
                cType2.setText(""); 
                cAt2.setText(""); 
                cHp2.setText(""); 

                if(one.getActiveCard() != null)
                {
                    cName1.setText((one.getActiveCard()).getName()); 
                    cType1.setText((one.getActiveCard()).getType());
                    cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                    cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints());  
                }
                if(two.getActiveCard() != null)
                {
                    cName2.setText((two.getActiveCard()).getName()); 
                    cType2.setText((two.getActiveCard()).getType());
                    cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                    cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints());
                }
                atk1.setEnabled(false);
                swap1.setEnabled(false); 
                atk2.setEnabled(true); 
                swap2.setEnabled(true);
            }
        }
        swap1.addActionListener(new choiceSwp1()); 
        class choiceSwp2 implements ActionListener
        {
            public void actionPerformed(ActionEvent c)
            {
                String receive = ""; 
                receive = ai.play("swap");
                log.append("----\n"); 
                log.append(receive);

                cName1.setText("");
                cType1.setText(""); 
                cAt1.setText(""); 
                cHp1.setText("");
                cName2.setText(""); 
                cType2.setText(""); 
                cAt2.setText(""); 
                cHp2.setText(""); 

                if(one.getActiveCard() != null)
                {
                    cName1.setText((one.getActiveCard()).getName()); 
                    cType1.setText((one.getActiveCard()).getType());
                    cAt1.setText("Atk: " + (one.getActiveCard()).getPower()); 
                    cHp1.setText("Hp: " + (one.getActiveCard()).getHitPoints());  
                }
                if(two.getActiveCard() != null)
                {
                    cName2.setText((two.getActiveCard()).getName()); 
                    cType2.setText((two.getActiveCard()).getType());
                    cAt2.setText("Atk: " + (two.getActiveCard()).getPower()); 
                    cHp2.setText("Hp: " + (two.getActiveCard()).getHitPoints());
                }
                atk2.setEnabled(false);
                swap2.setEnabled(false); 
                atk1.setEnabled(true); 
                swap1.setEnabled(true);
            }
        }
        swap2.addActionListener(new choiceSwp2()); 
    }
}
