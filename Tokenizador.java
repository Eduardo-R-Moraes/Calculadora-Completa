import java.util.ArrayList;

public class Tokenizador {
    public static boolean in(char[] arr, char target) {
        for(char car: arr) {
            if (car == target) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> tokenizar(String string) {
        ArrayList<String> tokens = new ArrayList<>();

        char[] numeros = {'0','1','2','3','4','5','6','7','8','9','.'};

        String buffer = "";

        for(int i = 0; i < string.length(); i++) {

            if (i == 0) {
                buffer += Character.toString(string.charAt(i));
            }

            else if (in(numeros, string.charAt(i))) {

                buffer += Character.toString(string.charAt(i));

                if (i == string.length() - 1) {
                    tokens.add(buffer);
                }

            }

            else if (string.charAt(i) == '+' || string.charAt(i) == '-') {
                if (buffer.length() != 0) {
                    tokens.add(buffer);
                }
                buffer = Character.toString(string.charAt(i));
            }
            
            else if (string.charAt(i) == '*' || string.charAt(i) == '/') {
                
                tokens.add(buffer);
                tokens.add(Character.toString(string.charAt(i)));

                buffer = "";
            }
        }

        return tokens;
    }
}
