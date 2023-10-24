import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private LinearEquation linearEquation;
    public void start() {
        introduction();
        getInfo();
        repeat();
    }
    public LinearEquationLogic() {
        linearEquation = null;
        scan = new Scanner(System.in);
    }

    private void introduction() {
        System.out.println("Welcome to the Linear Equation Calculator!");
    }
    private void getInfo() {
        System.out.print("Enter coordinate 1: ");
        String input = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String input2 = scan.nextLine();
        String xValue = input.substring(1, input.indexOf(","));
        int xAsInt = Integer.parseInt(xValue);
        String yValue = input.substring(input.indexOf(",") + 2, input.length() - 1);
        int yAsInt = Integer.parseInt(yValue);
        String xValue2 = input2.substring(1, input2.indexOf(","));
        int xAsInt2 = Integer.parseInt(xValue2);
        String yValue2 = input2.substring(input2.indexOf(",") + 2, input2.length() - 1);
        int yAsInt2 = Integer.parseInt(yValue2);
        System.out.println();
        linearEquation = new LinearEquation(xAsInt, yAsInt, xAsInt2, yAsInt2);
        System.out.println(linearEquation.lineInfo());
        if (xAsInt != xAsInt2) {
            newXValue();
        } else {
            System.out.println();
        }

    }
    private void newXValue() {
        System.out.println();
        System.out.print("Enter a value for x: ");
        double newX = scan.nextDouble();
        scan.nextLine();
        System.out.println("The point on the line is " + linearEquation.coordinateForX(newX));
        System.out.println();
    }

    private void repeat() {
        System.out.print("Would you like to enter another pair of coordinates? Yes / No: ");
        String inputYOrN = scan.nextLine();
        while (!inputYOrN.equals("No")) {
            getInfo();
            System.out.print("Would you like to enter another pair of coordinates? Yes / No: ");
            inputYOrN = scan.nextLine();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }

}
