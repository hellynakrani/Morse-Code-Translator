import java.util.*;

public class MorseCodeTranslator {
    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    static {
        textToMorse.put('A', ".-");
        textToMorse.put('B', "-...");
        textToMorse.put('C', "-.-.");
        textToMorse.put('D', "-..");
        textToMorse.put('E', ".");
        textToMorse.put('F', "..-.");
        textToMorse.put('G', "--.");
        textToMorse.put('H', "....");
        textToMorse.put('I', "..");
        textToMorse.put('J', ".---");
        textToMorse.put('K', "-.-");
        textToMorse.put('L', ".-..");
        textToMorse.put('M', "--");
        textToMorse.put('N', "-.");
        textToMorse.put('O', "---");
        textToMorse.put('P', ".--.");
        textToMorse.put('Q', "--.-");
        textToMorse.put('R', ".-.");
        textToMorse.put('S', "...");
        textToMorse.put('T', "-");
        textToMorse.put('U', "..-");
        textToMorse.put('V', "...-");
        textToMorse.put('W', ".--");
        textToMorse.put('X', "-..-");
        textToMorse.put('Y', "-.--");
        textToMorse.put('Z', "--..");
        textToMorse.put('0', "-----");
        textToMorse.put('1', ".----");
        textToMorse.put('2', "..---");
        textToMorse.put('3', "...--");
        textToMorse.put('4', "....-");
        textToMorse.put('5', ".....");
        textToMorse.put('6', "-....");
        textToMorse.put('7', "--...");
        textToMorse.put('8', "---..");
        textToMorse.put('9', "----.");

        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) {
            morseToText.put(entry.getValue(), entry.getKey());
        }
    }

    public static String toMorse(String input) {
        StringBuilder morse = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            if (c == ' ') {
                morse.append(" / ");
            } else if (textToMorse.containsKey(c)) {
                morse.append(textToMorse.get(c)).append(" ");
            }
        }
        return morse.toString().trim();
    }

    public static String toText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split(" / ");
        for (String word : words) {
            String[] letters = word.trim().split(" ");
            for (String letter : letters) {
                if (morseToText.containsKey(letter)) {
                    text.append(morseToText.get(letter));
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==== Morse Code Translator ====");
            System.out.println("1. Text to Morse");
            System.out.println("2. Morse to Text");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    String morse = toMorse(text);
                    System.out.println("Morse Code: " + morse);
                    break;
                case 2:
                    System.out.print("Enter Morse Code: ");
                    String code = sc.nextLine();
                    String result = toText(code);
                    System.out.println("Text: " + result);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}
