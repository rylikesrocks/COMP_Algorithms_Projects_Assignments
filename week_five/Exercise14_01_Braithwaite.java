import java.util.Scanner;

public class Exercise14_01_Braithwaite {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Enter number for Operand 1 (Integer): ");
       int operandOne = 0;
       String nextLine = input.next();
       try {
        operandOne = Integer.parseInt(nextLine);
       } catch (IllegalArgumentException exOne) {
            System.out.println("Error! Wrong Input for operand 1. Check if value is an integer");
            System.exit(1);
       } catch (ArithmeticException exTwo){
            System.out.println("Error! Amount exceeds Integer limits!");
            System.exit(1);
       }
       System.out.println("Enter number for Operand 2 (Integer): ");
       int operandTwo = 0;
       String afterLine = input.next();
       try {
        operandTwo = Integer.parseInt(afterLine);
       } catch (IllegalArgumentException exOne) {
            System.out.println("Error! Wrong Input for operand 2. Check if value entered is an integer");
            System.exit(1);
       } catch (ArithmeticException exTwo){
            System.out.println("Error! Amount exceeds Integer bounds!");
            System.exit(1);
       }
       System.out.println("Enter operator for the two operands: ");
       String operator = input.next();
       int totalOrSum = 0;
       switch (operator){
        case "+":
            totalOrSum = operandOne + operandTwo;
            System.out.println(operandOne + " " + operator + " " + operandTwo + " = " + totalOrSum);
            break;
        case "-":
            totalOrSum = operandOne - operandTwo;
            System.out.println(operandOne + " " + operator + " " + operandTwo + " = " + totalOrSum);
            break;
        case "*":
            totalOrSum = operandOne * operandTwo;
            System.out.println(operandOne + " " + operator + " " + operandTwo + " = " + totalOrSum);
            break;
        case "/":
            try{
                double totalDouble;
                totalDouble = operandOne / operandTwo;
                System.out.println(operandOne + " " + operator + " " + operandTwo + " = " + totalDouble);
            }catch(ArithmeticException e){
                System.out.println("Error! Cannot Divide by Zero!");
                System.exit(1);
            }
            break;
        default:
            if (!operator.equals("+") || !operator.equals("-") || !operator.equals("*") || !operator.equals("/")){
                System.out.println("Error! Unknown operator entered!");
                System.exit(1);
            }
       }
   } 
}

//Output for operandOne = 10, operandTwo = 5, operator = +:
// 10 + 5 = 15

//Output for operandOne = 20, operandTwo = p, operator = /:
// Error! Wrong Input for operand 2. Check if value entered is an integer
