
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Quiz extends JFrame implements ActionListener {

    // Builder Pattern: Store Question objects instead of 2D arrays
    private final List<Question> questions = new ArrayList<>();

    String useranswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, lifeline, submit;
    ButtonGroup groupoptions;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int score = 0;
    public static int count = 0;

    String name;

    Quiz(String name, int count) {
        this.name = name;
        Quiz.count = count;

        setBounds(0, 0, 1440, 800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("Icons/quiz.jpg")
        );

        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1400, 350);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 400, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(170, 440, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 480, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 520, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 560, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1000, 480, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(1000, 530, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 254));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1000, 580, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // Create questions using Builder Pattern
        loadQuestions();

        start(Quiz.count);

        setVisible(true);
    }

 
    private void loadQuestions() {

        questions.add(new QuestionBuilder()
                .setText("Which is used to find and fix bugs in the Java programs.?")
                .addOption("JVM")
                .addOption("JDB")
                .addOption("JDK")
                .addOption("JRE")
                .setCorrectAnswer("JDB")
                .build());

        questions.add(new QuestionBuilder()
                .setText("What is the return type of the hashCode() method in the Object class?")
                .addOption("int")
                .addOption("Object")
                .addOption("long")
                .addOption("void")
                .setCorrectAnswer("int")
                .build());

        questions.add(new QuestionBuilder()
                .setText("Which package contains the Random class?")
                .addOption("java.util package")
                .addOption("java.lang package")
                .addOption("java.awt package")
                .addOption("java.io package")
                .setCorrectAnswer("java.util package")
                .build());

        questions.add(new QuestionBuilder()
                .setText("An interface with no fields or methods is known as?")
                .addOption("Runnable Interface")
                .addOption("Abstract Interface")
                .addOption("Marker Interface")
                .addOption("CharSequence Interface")
                .setCorrectAnswer("Marker Interface")
                .build());

        questions.add(new QuestionBuilder()
                .setText("In which memory a String is stored, when we create a string using new operator?")
                .addOption("Stack")
                .addOption("String memory")
                .addOption("Random storage space")
                .addOption("Heap memory")
                .setCorrectAnswer("Heap memory")
                .build());

        questions.add(new QuestionBuilder()
                .setText("Which of the following is a marker interface?")
                .addOption("Runnable interface")
                .addOption("Remote interface")
                .addOption("Readable interface")
                .addOption("Result interface")
                .setCorrectAnswer("Remote interface")
                .build());

        questions.add(new QuestionBuilder()
                .setText("Which keyword is used for accessing the features of a package?")
                .addOption("import")
                .addOption("package")
                .addOption("extends")
                .addOption("export")
                .setCorrectAnswer("import")
                .build());

        questions.add(new QuestionBuilder()
                .setText("In java, jar stands for?")
                .addOption("Java Archive Runner")
                .addOption("Java Archive")
                .addOption("Java Application Resource")
                .addOption("Java Application Runner")
                .setCorrectAnswer("Java Archive")
                .build());

        questions.add(new QuestionBuilder()
                .setText("Which of the following is a mutable class in java?")
                .addOption("java.lang.StringBuilder")
                .addOption("java.lang.Short")
                .addOption("java.lang.Byte")
                .addOption("java.lang.String")
                .setCorrectAnswer("java.lang.StringBuilder")
                .build());

        questions.add(new QuestionBuilder()
                .setText("Which of the following option leads to the portability and security of Java?")
                .addOption("Bytecode is executed by JVM")
                .addOption("The applet makes the Java code secure and portable")
                .addOption("Use of exception handling")
                .addOption("Dynamic binding between objects")
                .setCorrectAnswer("Bytecode is executed by JVM")
                .build());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == next) {

            repaint();

            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;

            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] =
                        groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == lifeline) {

            if (count == 2 || count == 4 || count == 6
                    || count == 8 || count == 9) {

                opt2.setEnabled(false);
                opt3.setEnabled(false);

            } else {

                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }

            lifeline.setEnabled(false);

        } else if (ae.getSource() == submit) {

            ans_given = 1;

            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] =
                        groupoptions.getSelection().getActionCommand();
            }

            // Check answers using Question objects
            for (int i = 0; i < questions.size(); i++) {

                if (useranswers[i][0] != null
                        && useranswers[i][0].equals(
                                questions.get(i).getCorrectAnswer())) {

                    score += 10;
                }
            }

            setVisible(false);
            new Score(name, score);
        }
    }

    // Original paint() and Thread.sleep() approach retained
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left " + timer + " seconds";

        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1000, 450);
        } else {
            g.drawString("Times Up!", 1000, 450);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {

            timer = 15;

            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {

                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] =
                            groupoptions.getSelection().getActionCommand();
                }

                // Check answers using Question objects
                for (int i = 0; i < questions.size(); i++) {

                    if (useranswers[i][0] != null
                            && useranswers[i][0].equals(
                                    questions.get(i).getCorrectAnswer())) {

                        score += 10;
                    }
                }

                setVisible(false);
                new Score(name, score);

            } else {

                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] =
                            groupoptions.getSelection().getActionCommand();
                }

                count++;
                start(count);
            }
        }
    }

    // Display the current Question object
    public void start(int count) {

        Question current = questions.get(count);

        qno.setText("" + (count + 1) + ". ");
        question.setText(current.getText());

        String[] options = current.getOptions();

        opt1.setText(options[0]);
        opt1.setActionCommand(options[0]);

        opt2.setText(options[1]);
        opt2.setActionCommand(options[1]);

        opt3.setText(options[2]);
        opt3.setActionCommand(options[2]);

        opt4.setText(options[3]);
        opt4.setActionCommand(options[3]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User", 0);
    }
}
