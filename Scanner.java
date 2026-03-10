import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

enum TokenType {
    NUMBER, TERM, INVALID
}

class Token {
    TokenType type;
    String value;

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type.toString().toLowerCase() + ": \"" + value + "\"";
    }
}

public class Scanner {
    private final String input;
    private int position;
    private static final List<Character> symbols = Arrays.asList('+', '-', '=');

    public Scanner(String input) {
        this.input = input;
        this.position = 0;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isSymbol(char ch) {
        return symbols.contains(ch);
    }

    private char current() {
        if (position >= input.length()) return '\0'; // End of input marker
        return input.charAt(position);
    }

    private char next() {
        if (position >= input.length()) return '\0'; // Avoid out of bounds
        return input.charAt(position++);
    }

    private void skipWhitespace() {
        while (current() == ' ' || current() == '\n' || current() == '\t') {
            next();
        }
    }

    public Token getToken() {
        skipWhitespace();
        char currentChar = current();

        if (currentChar == '\0') return null; // End of input

        if (isDigit(currentChar)) {
            return new Token(TokenType.NUMBER, String.valueOf(next()));
        }

        if (isSymbol(currentChar)) {
            return new Token(TokenType.TERM, String.valueOf(next()));
        }

        return new Token(TokenType.INVALID, String.valueOf(next()));
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Scanner <file-path>");
            System.exit(1);
        }

        String filePath = args[0];

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath))); // ✅ Read file content
            Scanner scanner = new Scanner(content); // ✅ Pass the content, not the file path

            Token token;
            while ((token = scanner.getToken()) != null) {
                System.out.println(token.toString());
            }
        } catch (IOException e) { // ✅ Catch file reading errors
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
