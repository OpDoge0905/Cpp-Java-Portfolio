package Calculator;
import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean inputLoop = true;
        boolean contiLoop = true;
        double num1=0, num2=0;
        char op1=' ';

        System.out.println("=== Calculator v1.0 ===");
        while(contiLoop){
            while(inputLoop){
                System.out.println("=== Give me a number! ===");
                if(scanner.hasNextDouble()){
                    num1 = scanner.nextDouble();
                    inputLoop = false;
                }
                else{
                    System.out.println("!!! ERROR !!!");
                    scanner.next();
                }
            }
            inputLoop = true;
            while(inputLoop){
                System.out.println("=== Give me a operator! (+ - * / %)===");
                String opTempStr = scanner.next();
                char opTemp = opTempStr.charAt(0);
                if(opTemp=='+'||opTemp=='-'||opTemp=='*'||opTemp=='/'||opTemp=='%'){
                    op1 = opTemp;
                    inputLoop = false;
                }
                else{
                    System.out.println("!!! ERROR !!!");
                }
            }
            inputLoop = true;
            while(inputLoop){
                System.out.println("=== Give me another number! ===");
                if(scanner.hasNextDouble()){
                    num2 = scanner.nextDouble();
                    if((op1=='/'||op1=='%')&&num2==0){
                        System.out.println("!!! NUM2 CANNOT BE 0 !!!");
                    }
                    else{
                        inputLoop = false;
                    }
                }
                else{
                    System.out.println("!!! ERROR !!!");
                    scanner.next();
                }
            }
            inputLoop = true;

            System.out.println("=== Operating! ===");
            double ans = calC(num1, num2, op1);
            System.out.println("=== Answer : "+ num1+" "+op1+" "+num2 + " = " + ans + " ===");
            boolean askAgain = true;
            System.out.println("=== Continue?(y/n) ===");
            String contiIn = scanner.next();
            while(askAgain){
                if((contiIn.charAt(0)=='n'||contiIn.charAt(0)=='N')){
                    contiLoop = false;
                    askAgain = false;
                    System.out.println("=== Calculator Closed ===");
                }
                else if(contiIn.charAt(0)=='y'||contiIn.charAt(0)=='Y'){
                    askAgain = false;
                }
                else{
                    System.out.println("!!! ONLY y or n !!!");
                    contiIn = scanner.next();
                }
            }
        }
    }

    public static double calC(double num1, double num2, char operator1){
        switch (operator1) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '%':
                return num1 % num2;
        }
        return 0;
    }
}