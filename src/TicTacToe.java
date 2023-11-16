import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JLabel textLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton resetButton = new JButton("Reset");
    boolean isPlayerXTurn = true;
    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());


        textLabel.setBackground(new Color(25,25,25));
        textLabel.setForeground(new Color(25,225,0));
        textLabel.setFont(new Font("Arial",Font.BOLD,75));
        textLabel.setText("TIC TAC TOE");
        textLabel.setHorizontalAlignment(JLabel.CENTER);

        textLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(100,100,100));

        resetButton.addActionListener(this);
        resetButton.setFont(new Font("Arial",Font.PLAIN,20));
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(Color.lightGray);
        resetButton.setFocusable(false);

        for(int i = 0; i<9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setFont(new Font("Arial",Font.BOLD,120));
            buttonsPanel.add(buttons[i]);
        }

        titlePanel.add(textLabel);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonsPanel);
        frame.add(resetButton,BorderLayout.SOUTH);
        frame.setVisible(true);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton){
            firstTurn();
            for (int i = 0 ; i<buttons.length; i++){
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setBackground(Color.lightGray);
            }
        }
        for (int i = 0 ; i<buttons.length; i++){
            if(e.getSource() == buttons[i] && buttons[i].getText() == ""){
                if (isPlayerXTurn){
                    buttons[i].setText("X");
                    buttons[i].setForeground(Color.RED);
                    isPlayerXTurn = false;
                    textLabel.setText("Player O");
                    findWinner();
                } else {
                    buttons[i].setText("O");
                    buttons[i].setForeground(Color.BLUE);
                    isPlayerXTurn = true;
                    textLabel.setText("Player X");
                    findWinner();
                }
            }
            }
        }

    public void firstTurn(){
        int i = random.nextInt(2);
        if (i == 0){
            textLabel.setText("Player O");
            isPlayerXTurn = false;

        }else {
            textLabel.setText("Player X");
            isPlayerXTurn = true;


        }
    }

    public void findWinner(){

        if(buttons[0].getText() == buttons[1].getText() &&
                buttons[0].getText() == buttons[2].getText() &&
                buttons[0].getText() != ""){
                    wins(buttons[0].getText(),1,3,2);
        }
        if(buttons[3].getText() == buttons[4].getText() &&
                buttons[3].getText() == buttons[5].getText() &&
                buttons[3].getText() != ""){
            wins(buttons[3].getText(),4,3,5);
        }
        if(buttons[6].getText() == buttons[7].getText() &&
                buttons[6].getText() == buttons[8].getText() &&
                buttons[6].getText() != ""){
            wins(buttons[6].getText(),7,8,6);
        }
        if(buttons[0].getText() == buttons[3].getText() &&
                buttons[0].getText() == buttons[6].getText() &&
                buttons[0].getText() != ""){
            wins(buttons[0].getText(),0,3,6);
        }
        if(Objects.equals(buttons[1].getText(), buttons[4].getText()) &&
                buttons[1].getText() == buttons[7].getText() &&
                buttons[1].getText() != ""){
            wins(buttons[1].getText(),1,4,7);
        }
        if(buttons[2].getText() == buttons[5].getText() &&
                buttons[2].getText() == buttons[8].getText() &&
                buttons[2].getText() != ""){
            wins(buttons[2].getText(),2,5,8);
        }
        if(buttons[0].getText() == buttons[4].getText() &&
                buttons[0].getText() == buttons[8].getText() &&
                buttons[0].getText() != ""){
            wins(buttons[0].getText(),0,4,8);
        }
        if(buttons[2].getText() == buttons[4].getText() &&
                buttons[2].getText() == buttons[6].getText() &&
                buttons[2].getText() != ""){
            wins(buttons[2].getText(),2,4,6);
        }
    }
    public void wins(String buttonText, int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        if(buttonText.equals("X")){
            textLabel.setText("Payer X Won");
        } else if (buttonText.equals("O")) {
            textLabel.setText("Payer O Won");
        }
    }

}
