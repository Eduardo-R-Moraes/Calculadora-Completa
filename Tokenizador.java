import java.util.ArrayList;

public class Tokenizador {
    // Método que verifica se um número target está 
    // dentro de um array char[]
    public static boolean in(char[] arr, char target) {
        for(char car: arr) {
            if (car == target) {
                return true;
            }
        }
        return false;
    }

    // Método que tranforma uma string em uma lista de tokens
    public static ArrayList<String> tokenizar(String string) {
        ArrayList<String> tokens = new ArrayList<>();
        char[] numeros = {'0','1','2','3','4','5','6','7','8','9','.'};
        char[] operacoes = {'+','-','*','/'};

        // Variável que vai formar os clusters de números que depois
        // serão armazenados como tokens
        String buffer = "";

        // Inicializa a leitura dos caracteres da string
        for(int i = 0; i < string.length(); i++) {

            // Se for número
            if (in(numeros, string.charAt(i))) {

                // Adiciona no buffer
                buffer += Character.toString(string.charAt(i));

                // Caso seja o último index, como não vai entrar no else if,
                // Adiciona no tokens agora
                if (i == string.length() - 1) {
                    tokens.add(buffer);
                }

            }

            // Se o caracter for uma operação + ou -
            else if (in(operacoes, string.charAt(i))) {
                
                // Adiciona o cluster de números formados
                tokens.add(buffer);

                // Limpa o buffer
                buffer = "";

                // Adiciona a operação
                tokens.add(Character.toString(string.charAt(i)));
            }
        }

        return tokens;
    }
}
