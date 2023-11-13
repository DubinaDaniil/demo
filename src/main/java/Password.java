import java.util.*;

public class Password {

    private static final String ENTER_PASSWORD_LENGTH = "Enter password length: ";
    private static final String SELECT_PASSWORD_COMPLEXITY_FROM_1_TO_3 = "Select password complexity from 1 to 3: ";

    private static final char[] smallAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] alphabetWithNumbers = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "+", "-", "/", "@", "!", "\\", "?", "*"};

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rd = new Random();
    private static final StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) {
        System.out.print(ENTER_PASSWORD_LENGTH);
        int length = sc.nextInt();
        System.out.print(SELECT_PASSWORD_COMPLEXITY_FROM_1_TO_3);
        int diff = sc.nextInt();
        if (diff == 1) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(smallAlphabet[rd.nextInt(0, 25)]);
            }
        } else if (diff == 2) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(alphabet[rd.nextInt(0, 51)]);
            }
        } else if (diff == 3) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(alphabetWithNumbers[rd.nextInt(0, 69)]);
            }
        }
        System.out.println(stringBuilder);
    }
}