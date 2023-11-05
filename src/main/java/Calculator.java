import org.apache.commons.lang.*;

import java.util.*;

public class Calculator {

    private static final String ANSWER = "Ответ = ";
    private static final String WRONG_WORD = "Вы ввели неправильное слово";
    private static final String WRONG_NUMBER = "Нжно ввести цифру от 1 до 4";
    private static final String CALCULATOR_IS_CLOSE = "Калькулятор закрыт";
    private static final String STOP = "STOP";
    private static final String ENTER_FIRST_NUMBER = "Введите первое число: ";
    private static final String ENTER_SECOND_NUMBER = "Введите второе число: ";
    private static final String SUM = "Нажмите [1] для суммирования";
    private static final String MULTIPLICATION = "Нажмите [2] для умножения";
    private static final String DIVISION = "Нажмите [3] для деления";
    private static final String MINUS = "Нажмите [4] для вычетания";

    static Scanner sc = new Scanner(System.in);
    static int intFirstNumber = 0;
    static int intSecondNumber = 0;
    static int actionNumber = 0;
    static boolean isCorrect = true;

    public static void main(String[] args) {
        calculate();
    }

    private static void calculate() {
        while (true) {
            intFirstNumber = enterNumber(isCorrect, ENTER_FIRST_NUMBER, sc, intFirstNumber);
            intSecondNumber = enterNumber(isCorrect, ENTER_SECOND_NUMBER, sc, intSecondNumber);
            actionNumber = enterActionNumber(isCorrect, sc, intSecondNumber);

            count(actionNumber, intFirstNumber, intSecondNumber);
        }
    }

    private static int enterActionNumber(boolean isCorrect, final Scanner sc, int number) {
            while (isCorrect) {

                System.out.println(SUM);
                System.out.println(MULTIPLICATION);
                System.out.println(DIVISION);
                System.out.println(MINUS);

                String stringChooseAction = sc.nextLine();
                if (stringChooseAction.equalsIgnoreCase(STOP)) {
                    System.out.println(CALCULATOR_IS_CLOSE);
                    System.exit(0);
                } else if (StringUtils.isNumeric(stringChooseAction)) {
                    number = Integer.parseInt(stringChooseAction);
                    for (int i = 1; i <= 4; i++) {
                        if (number == i) {
                            isCorrect = false;
                            break;
                        }
                    }
                    System.out.println(WRONG_NUMBER);
                } else {
                    System.out.println(WRONG_NUMBER);
                }
            }
        return number;
    }

    private static int enterNumber(boolean isCorrect, final String message, final Scanner sc, int number) {
        while (isCorrect) {

            System.out.print(message);
            String string = sc.nextLine();

            if (string.equalsIgnoreCase(STOP)) {
                System.out.println(CALCULATOR_IS_CLOSE);
                System.exit(0);
//            } else if (StringUtils.isNumeric(string)) {
            } else if (isNumber(string)) {
                number = Integer.parseInt(string);
                isCorrect = false;
            } else {
                System.out.println(WRONG_WORD);
            }
        }
        return number;
    }

    private static boolean isNumber(String string) {
        return string.matches("-?\\d+");
    }

    private static void count(final int actionNumber, final int firstNumber, final int secondNumber) {
        if (actionNumber == 1) {
            System.out.println(ANSWER + addition(firstNumber, secondNumber));
        }
        if (actionNumber == 2) {
            System.out.println(ANSWER + multiplication(firstNumber, secondNumber));
        }
        if (actionNumber == 3) {
            System.out.println(ANSWER + division(firstNumber, secondNumber));
        }
        if (actionNumber == 4) {
            System.out.println(ANSWER + subtraction(firstNumber, secondNumber));
        }
    }

    private static int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    private static double division(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;
    }

    private static int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}