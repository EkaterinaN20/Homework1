package com.geekbrains.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {
    JLabel jlabPrompt, jlabContents;
    JButton jbtnRev;
    JTextField jtf;
    JTextArea text;
    String resStr;
    public Form() {
        setTitle("Простой чат с ботом");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        //JButton[] jButtons = new JButton[2];

        //for (int i = 0; i < jButtons.length; i++) {
           // jButtons[i] = new JButton("#" + i);
            //jButtons[i].addActionListener(actionEvent -> System.out.println("button pressed"));
           // add(jButtons[i]);
      //  }

        // BorderLayout
        //setLayout(new FlowLayout());
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//jButtons[0].setPreferredSize(new Dimension(300,300));
        //add(jButtons[0], BorderLayout.SOUTH);
       // add(jButtons[1], BorderLayout.WEST);
        jtf = new JTextField(12);
        jtf.setActionCommand("MyTF");
        jtf.setEditable(true);
        jbtnRev = new JButton("Написать");
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);
        text = new JTextArea(40, 10);
        text.setEditable(false);
        jlabPrompt = new JLabel("Введите сообщение: ");
       jlabContents = new JLabel("");
        add(text);
        add(jlabPrompt);
        add(jtf);
        add(jbtnRev);
        add(jlabContents);


        setVisible(true);
    }
        public void actionPerformed (ActionEvent ae){
        String [] BBPhrases = {"Чаво?", "Не хами!", "Привет, привет!", "Ага! Попался!", "Представься, пожалуйста!"};
        if
                (ae.getActionCommand().equals("Написать")) {
                String orgStr = jtf.getText();
                for (int i = orgStr.length() - 1; i >= 0; i--) {
                    resStr += orgStr.charAt(i);
                }
                resStr += "\r\n"+ BBPhrases[(int)(Math.random()*5)]+ "\r\n";
                text.setText(resStr);
                text.setText(resStr);
            }
        }
    }

class AppStart {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
        Form form = new Form();
    }
});
    }
}
