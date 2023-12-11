/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_assignment7;
 import java.text.DecimalFormat;
/**
 *
 * @author angelramirez-rivera
 */
public class PropertyTaxCalculator {
   
    public static double calculateAssessmentValue(double actualValue) {
        return actualValue * 0.6;
    }

    public static double calculatePropertyTax(double assessmentValue) {
        return (assessmentValue / 100) * 0.64;
    }

    public static String formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }
}
