package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    Score(){
        QuizSession session = QuizSession.getInstance();
        String name = session.getPlayerName();
        int score = session.getScore();

        setTitle("Score");
        setBounds(300,100,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel image = new JLabel(new ImageProxy("Icons/score.png", 300, 250, true));
        image.setBounds(0,200,300,250);
        add(image);

        JLabel heading = new JLabel("Thank U "+ name +" for Playing Simple Minds");
        heading .setBounds(45,30,700,30);
        heading .setFont(new Font("Tahoma",Font.PLAIN,26));
        add(heading );

        JLabel score1 = new JLabel("Your Score is "+ score);
        score1 .setBounds(350,200,300,30);
        score1 .setFont(new Font("Tahoma",Font.PLAIN,26));
        add(score1 );

        JButton submit = new JButton("Play Again");
        submit.setBounds(380,270,120,30);

        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }
    public static void main(String args[]){
        QuizSession.getInstance().setPlayerName("User");
        QuizSession.getInstance().addPoints(50);
        new Score();
    }
}
