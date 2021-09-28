package me.raymart.dev.frame;

import javax.swing.*;
import java.text.DecimalFormat;

public class Calculator {
    private JPanel Calculator;
    private JTextField textDisplay;
    private JButton buttonEquals;
    private JButton buttonMultiply;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFive;
    private JButton buttonEight;
    private JButton buttonPeriod;
    private JButton buttonAdd;
    private JButton buttonSix;
    private JButton buttonNine;
    private JButton buttonClear;
    private JButton buttonMinus;
    private JButton buttonDivide;
    private JButton buttonOne;
    private JButton buttonFour;
    private JButton buttonSeven;
    private JButton buttonZero;
    private double firstNumber = 0;
    private int lastOperator = -1;

    public Calculator() {
        buttonOne.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonOne.getText());
        });
        buttonTwo.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonTwo.getText());
        });
        buttonThree.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonThree.getText());
        });
        buttonFour.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonFour.getText());
        });
        buttonFive.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonFive.getText());
        });
        buttonSix.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonSix.getText());
        });
        buttonSeven.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonSeven.getText());
        });
        buttonEight.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonEight.getText());
        });
        buttonNine.addActionListener(e -> {
            textDisplay.setText(textDisplay.getText() + buttonNine.getText());
        });
        buttonZero.addActionListener(e -> {
            if(textDisplay.getText().isEmpty()) {
                return;
            }
            textDisplay.setText(textDisplay.getText() + buttonZero.getText());
        });
        buttonClear.addActionListener(e -> {
            firstNumber = 0;
            lastOperator = -1;
            if(textDisplay.getText().isEmpty()) {
                return;
            }
            textDisplay.setText("");
        });
        buttonPeriod.addActionListener(e -> {
            if(textDisplay.getText().isEmpty()) {
                textDisplay.setText(buttonZero.getText() + buttonPeriod.getText());
                return;
            }
            if(textDisplay.getText().contains(".")) {
                return;
            }
            textDisplay.setText(textDisplay.getText() + ".");
        });


        // operators
        buttonAdd.addActionListener(e -> {

            if(textDisplay.getText().isEmpty())
                return;

            if(firstNumber == 0) {
                firstNumber = Double.parseDouble(textDisplay.getText());
                textDisplay.setText("");
                lastOperator = 0;
                return;
            }

            double answer = firstNumber + Double.parseDouble(textDisplay.getText());
            DecimalFormat df = new DecimalFormat("#.##");
            textDisplay.setText(df.format(answer));
            firstNumber = 0;
        });

        buttonMinus.addActionListener(e -> {

            if(textDisplay.getText().isEmpty())
                return;

            if(firstNumber == 0) {
                firstNumber = Double.parseDouble(textDisplay.getText());
                textDisplay.setText("");
                lastOperator = 1;
                return;
            }

            double answer = firstNumber - Double.parseDouble(textDisplay.getText());
            DecimalFormat df = new DecimalFormat("#.##");
            textDisplay.setText(df.format(answer));
            firstNumber = 0;
        });

        buttonMultiply.addActionListener(e -> {

            if(textDisplay.getText().isEmpty())
                return;

            if(firstNumber == 0) {
                firstNumber = Double.parseDouble(textDisplay.getText());
                textDisplay.setText("");
                lastOperator = 2;
                return;
            }

            double answer = firstNumber * Double.parseDouble(textDisplay.getText());
            DecimalFormat df = new DecimalFormat("#.##");
            textDisplay.setText(df.format(answer));
            firstNumber = 0;
        });

        buttonDivide.addActionListener(e -> {

            if(textDisplay.getText().isEmpty())
                return;

            if(firstNumber == 0) {
                firstNumber = Double.parseDouble(textDisplay.getText());
                textDisplay.setText("");
                lastOperator = 3;
                return;
            }

            double answer = firstNumber / Double.parseDouble(textDisplay.getText());
            DecimalFormat df = new DecimalFormat("#.##");
            textDisplay.setText(df.format(answer));
            firstNumber = 0;
        });

        buttonEquals.addActionListener(e -> {

            if(textDisplay.getText().isEmpty())
                return;

            System.out.println(lastOperator);
            if(firstNumber == 0) {
                return;
            }
            DecimalFormat df = new DecimalFormat("#.##");
            switch (lastOperator) {
                case 0:
                    textDisplay.setText(df.format(firstNumber + Double.parseDouble(textDisplay.getText())));
                    break;
                case 1:
                    textDisplay.setText(df.format(firstNumber - Double.parseDouble(textDisplay.getText())));
                    break;
                case 2:
                    textDisplay.setText(df.format(firstNumber * Double.parseDouble(textDisplay.getText())));
                    break;
                case 3:
                    textDisplay.setText(df.format(firstNumber / Double.parseDouble(textDisplay.getText())));
                    break;
                default:
                    break;
            }
            firstNumber = 0;
            lastOperator = -1;
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Calculator");
        jFrame.setContentPane(new Calculator().Calculator);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
