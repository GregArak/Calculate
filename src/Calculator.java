import java.util.Scanner;

public class Calculator {
    private static boolean its_an_arabic_numbers = true;

    static String[] pars(String input) {
        String[] parsed_input = input.split(" ");
        if (parsed_input.length != 3) {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Invalid Format");
            input = input_a_value_again.nextLine();
            return pars(input);
        } else {
            return parsed_input;
        }
    }


    public static void main(String[] args) {

        Scanner input_a_value = new Scanner(System.in);
        System.out.print("Input Term ");
        String input = input_a_value.nextLine();
        while (!input.isEmpty()) {
            String[] parsed_input = Calculator.pars(input);
            String operation = parsed_input[1];
            Number values;
            int value1 = 0;
            int value2 = 0;
            // cast to int
            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);

            } catch (NumberFormatException e) {
                its_an_arabic_numbers = false;
                System.out.println("Input Roman");

            }

            if (its_an_arabic_numbers) {
                values = new Arabic(value1, value2);
            } else {
                values = new Romes(parsed_input[0], parsed_input[2]);
            }

            if (operation.equals("+")) {
                values.sum();
            } else if (operation.equals("-")) {
                values.sub();
            } else if (operation.equals("/") || operation.equals(":")) {
                values.div();
            } else if (operation.equals("*") || operation.equals("x")) {
                values.multi();
            }

            if (its_an_arabic_numbers) {
                System.out.println("answer: " + values.getResult());
            } else {
                System.out.println("answer: " + values.getStringResult());
            }
            System.out.println();
            System.out.print("next term: ");
            input = input_a_value.nextLine();
        }
        System.out.println("Output");

    }
}