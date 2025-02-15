import java.util.ArrayList;

public class Tokenizador {
    // Função que recebe um array e um target e retorna
    // se o target está no array.
    public static boolean in(char[] arr, char target) {
        
        for(char car: arr) {
            if (car == target) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> tokenizar(String string) {
        // Inicialização da lista dos tokens.
        ArrayList<String> tokens = new ArrayList<>();

        // Caracteres válidos para salvar no buffer.
        char[] numeros = {'0','1','2','3','4','5','6','7','8','9','.'};

        // Variável que vai armazenar cluster de números na string.
        // Se houver o número 123, vai armazenar um por um e depois
        // Vai ser adicionado ao tokens.
        String buffer = "";

        // Percorrendo a string.
        for(int i = 0; i < string.length(); i++) {

            // Independente do caractere do começo da string, o armazene.
            // Nota: a string não pode vir com o * e / como iniciais, senão dá erro.
            if (i == 0) {
                buffer += Character.toString(string.charAt(i));
            }

            // Verifica se o caractere na posição i é válido.
            else if (in(numeros, string.charAt(i))) {

                // Se for número ou . adiciona no buffer.
                buffer += Character.toString(string.charAt(i));

                // Se a string acabar e não se deparar com um operador,
                // ela não vai salvar o último número no tokens.
                // Ou seja, se tivesse 1 + 2 + 3 seria armazenado [1, +2] e o +3 não.
                if (i == string.length() - 1) {
                    tokens.add(buffer);
                }

            }

            // Caso de ser operador + ou -
            else if (string.charAt(i) == '+' || string.charAt(i) == '-') {
                // Se o tamanho do buffer for maior que 0 armazena o buffer.
                // Se isso não acontecesse, toda vez que encontrasse um sinal,
                // seria armazenado um token vazio. Ficaria: [-1, +3, *, , -1]
                if (buffer.length() > 0) {
                    tokens.add(buffer);
                }

                // Se o tamanho do buffer for igual a 0, armazena o sinal no buffer.
                // Isso indica que o valor vindo antes do caractere i era um * ou /.
                buffer = Character.toString(string.charAt(i));
            }
            
            // Caso seja * ou /
            else if (string.charAt(i) == '*' || string.charAt(i) == '/') {
                
                // Adiciona o buffer nos tokens.
                tokens.add(buffer);

                // Adiciona sinal de * ou / separado do número.
                // * ou / se torna um token a parte, sendo armazenado nesse exemplo: [+1, /, -2, *, 3]
                tokens.add(Character.toString(string.charAt(i)));

                // Reseta o buffer.
                buffer = "";
            }
        }

        // Entrega os tokens.
        return tokens;
    }
}
