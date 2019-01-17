import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * BMIWindow is has everything related to the BMI calculator.
 * 
 * @author      Anu Malm <anu.m.malm(at)gmail.com>
 * @version     2019.0111
 * @since       1.0
 */
public class BMIWindow extends JFrame {

    private JButton clearButton;
    private JButton resultButton;
    private JTextField kgText;
    private JTextField heightText;
    private JTextArea resultText;
    private JLabel titleText;

    /**
     * Constructor for the BMIWindow.
     * 
     * @param title     title of the window
     * @param width     width of the window
     * @param height    height of the window
     */
    public BMIWindow(String title, int width, int height) {
        super(title);

        setSize(width, height);

        setLayout(new GridLayout(0, 1, 10, 5));

        titleText = new JLabel("BMI Calculator", SwingConstants.CENTER);
        kgText = new JTextField("Replace this with your weight in kilograms");
        heightText = new JTextField("Replace this with your height in centimeters");
        resultText = new JTextArea("Press \"Result\"-button to see your BMI!");

        resultButton = new JButton("Result");
        clearButton = new JButton("Clear");

        //make sure that the user can't cheat and change the resultText
        resultText.setEditable(false);

        addEverythingToWindow();

        clearButton.addActionListener(this::clearButtonClicked);
        resultButton.addActionListener(this::resultButtonClicked);

        setVisible(true);

        // Ends the program when user closes the window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Adds all the texts and buttons to the window.
     */
    private void addEverythingToWindow() {
        add(titleText);
        add(kgText);
        add(heightText);
        add(resultText);
        add(resultButton);
        add(clearButton);
    }

    /**
     * Sets texts back to how they were in the start.
     * 
     * @param e     ActionEvent for button
     */
    public void clearButtonClicked(ActionEvent e) { 
        kgText.setText("Replace this with your weight in kilograms");
        heightText.setText("Replace this with your height in centimeters");
        resultText.setText("Result is shown here.");
        resultText.setForeground(Color.BLACK);
    }

    /**
     * Calculates the BMI from user's values and shows the result.
     * 
     * @param e     ActionEvent for button
     */
    public void resultButtonClicked(ActionEvent e) {
        try {
            double kg = Double.parseDouble(kgText.getText());
            double height = Double.parseDouble(heightText.getText());
            // Change centimeters into meters
            height = height / 100;

            //double result = Calculate.bmiOldFormula(kg, height);
            double result = Calculate.bmiNewFormula(kg, height);
            resultText.setText("Your BMI is " + result + ". This is considered " + resultText(result));
        } catch (NumberFormatException n) {
            resultText.setText("Please replace the texts above with your own values\nand use period for decimals! Press then Result-button for your result.");
            resultText.setForeground(Color.RED);
        }
    }

    /**
     * Displays different texts and resultText effects depending on the BMI value.
     * 
     * @param result    calculated BMI
     * @return          text for the resultText
     */
    public String resultText(double result) {
        String resultString = "";
        if(result < 18.5f) {
            resultString = "underweight!";
            resultText.setForeground(Color.RED);
        } else if (result >= 18.5f && result <= 24.9f) {
            resultString = "normal weight.";
            resultText.setForeground(Color.GREEN.darker());
        } else if (result > 25f && result <= 29.9f) {
            resultString = "slightly overweight...";
            resultText.setForeground(Color.ORANGE.darker());
        } else if (result > 30f) {
            resultString = "obese!";
            resultText.setForeground(Color.RED);
        }
        return resultString;
    }
}