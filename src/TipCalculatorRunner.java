import java.util.Scanner;
import java.text.DecimalFormat;
public class TipCalculatorRunner {
    public static void main(String[] args) {
        //initializes scanner and decimal format
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        //prints the introduction and asks for the amount of people
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group? ");
        int peopleInGroup = scan.nextInt();
        scan.nextLine();

        //asks for the tip percentage
        System.out.print("What's the tip percentage? (0 - 100) : ");
        double tipPercentage = scan.nextDouble();
        scan.nextLine();

        //creates the tipCalc object
        TipCalculator tipCalc = new TipCalculator(peopleInGroup, tipPercentage);

        //while loop to add as many meals as needed
        double currentInput = 0;
        while (currentInput != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end) : ");
            currentInput = scan.nextDouble();
            scan.nextLine();
            tipCalc.addMeal(currentInput);
        }

        //adds back the lost dollar from the -1
        tipCalc.addMeal(1);

        //prints out all the information using the TipCalculator's methods
        System.out.println("----------------------");
        System.out.println("Total Bill Before Tip: " + formatter.format(tipCalc.getTotalBillBeforeTip()));
        System.out.println("Tip Percentage: " + (int)tipCalc.getTipPercentage());
        System.out.println("Total Tip: " + formatter.format(tipCalc.tipAmount()));
        System.out.println("Total Bill With Tip: " + formatter.format(tipCalc.totalBill()));
        System.out.println("Per Person Cost Before Tip: " + formatter.format(tipCalc.perPersonCostBeforeTip()));
        System.out.println("Tip Per Person: " + formatter.format(tipCalc.perPersonTipAmount()));
        System.out.println("Total Cost Per Person: " + formatter.format(tipCalc.perPersonTotalCost()));
    }
}
