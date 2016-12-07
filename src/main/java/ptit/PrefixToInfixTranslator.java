package ptit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sarath on 7/12/16.
 */
public class PrefixToInfixTranslator {

    private static final Map<Character, Character> PREFIX_TO_INFIX_MAP = new HashMap<>();

    private static int index = 0;
    private static String input = null;

    static {
        PREFIX_TO_INFIX_MAP.put('N', '-');
        PREFIX_TO_INFIX_MAP.put('A', 'v');
        PREFIX_TO_INFIX_MAP.put('C', '>');
        PREFIX_TO_INFIX_MAP.put('E', '=');
        PREFIX_TO_INFIX_MAP.put('K', '&');
    }

    public static void main(String[] args) {
        do {
            System.out.print("Formula :");
            Scanner scanner = new Scanner(System.in);
            input = null;
            index = 0;
            input = scanner.nextLine();
            readAndConvert();
            System.out.println();
        } while (!"exit".equals(input.trim()));
        System.out.println("Good Bye :)");
    }

    private static void readAndConvert() {
        if(index >= input.length()){
            return;
        }

        char c = input.charAt(index);
        switch (c) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                System.out.print(c);
                break;

            case 'N':
                System.out.print(PREFIX_TO_INFIX_MAP.get(c));
                index++;
                readAndConvert();
                break;

            case 'A':
            case 'C':
            case 'E':
            case 'K':
                index++;
                readAndConvert();
                System.out.print(" " + PREFIX_TO_INFIX_MAP.get(c) + " ");
                index++;
                readAndConvert();
                break;

            default:
                index++;
                readAndConvert();
                break;
        }
    }
}
