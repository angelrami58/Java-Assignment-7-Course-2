/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_assignment7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author angelramirez-rivera
 */
public class PropertyTaxGUI {
    private JFrame frame;
    private JLabel actualValueLabel, assessmentValueLabel, propertyTaxLabel;
    private JTextField actualValueTextField, assessmentValueTextField, propertyTaxTextField;
    private JButton calculateButton;

    public PropertyTaxGUI() {
        frame = new JFrame("Property Tax Calculator");
        frame.setLayout(new FlowLayout());

        actualValueLabel = new JLabel("Enter Actual Property Value:");
        actualValueTextField = new JTextField(10);

        assessmentValueLabel = new JLabel("Assessment Value:");
        assessmentValueTextField = new JTextField(10);
        assessmentValueTextField.setEditable(false);

        propertyTaxLabel = new JLabel("Property Tax:");
        propertyTaxTextField = new JTextField(10);
        propertyTaxTextField.setEditable(false);

        calculateButton = new JButton("Calculate");

        frame.add(actualValueLabel);
        frame.add(actualValueTextField);
        frame.add(assessmentValueLabel);
        frame.add(assessmentValueTextField);
        frame.add(propertyTaxLabel);
        frame.add(propertyTaxTextField);
        frame.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePropertyTax();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void calculatePropertyTax() {
        try {
            double actualValue = Double.parseDouble(actualValueTextField.getText());
            double assessmentValue = PropertyTaxCalculator.calculateAssessmentValue(actualValue);
            double propertyTax = PropertyTaxCalculator.calculatePropertyTax(assessmentValue);

            assessmentValueTextField.setText(PropertyTaxCalculator.formatDecimal(assessmentValue));
            propertyTaxTextField.setText(PropertyTaxCalculator.formatDecimal(propertyTax));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numerical value for Actual Property Value.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PropertyTaxGUI();
            }
        });
    }
}