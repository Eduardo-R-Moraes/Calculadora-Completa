import java.util.ArrayList;

public class Calculadora {
    public static String ler(ArrayList<String> tokens) {
        int j = 0;
        while (j < tokens.size()) {

            // Anda caractere por caracter dos tokens até encontrar a posição de um * ou /.
            // Realiza a operação com o valor j-1 e j+1 (j é a posição do operador).
            // Por fim, armazena na posição j-1 do próprio tokens e remove o j e j+1
            if(tokens.get(j).equals("*") || tokens.get(j).equals("/")) {

                // Faz a operação e atualiza o valor de j-1
                tokens.set(j-1, operacao(tokens.get(j-1), tokens.get(j), tokens.get(j+1)));

                // Remove j+1 e j
                tokens.remove(j+1);
                tokens.remove(j);
            }

            // Anda uma posição se for um número.
            else {
                j++;
            }
        }

        // Essa é a parte que lida com a soma.
        // Enquanto token.size() for maior que 1, o valor da posição 0 vai ser juntado
        // ao valor da posição 1 e vai ser armazenado em 0.
        // Depois, o valor 1 vai ser excluido, repitindo até terminar as somas.
        while (tokens.size() > 1) {
            // Soma e armazena na posição 0
            tokens.set(0, juntar(Float.parseFloat(tokens.get(0)), Float.parseFloat(tokens.get(1))));

            // Remove o 1
            tokens.remove(1);
        }

        // Por fim, o valor armazenado na posição 0 é o resultado da soma.
        return tokens.get(0);
    }

    // Função usada para controlar fluxo de código
    // entre divisão e multiplicação
    public static String operacao(String... numeros) {
        float num1 = Float.parseFloat(numeros[0]);
        float num2 = Float.parseFloat(numeros[2]);

        if (numeros[1].equals("*")) {
            return multiplicar(num1, num2);
        }
        else if (numeros[1].equals("/")) {
            return dividir(num1, num2);
        }

        return "Opção inválida!";
    }

    // Não foi preciso implementar um método somar e subtrair,
    // porque o próprio número já tem a informação.
    // Os tokens são armazenados assim: ["1", "-2", "+3"]
    // então basta juntar 1 com -2 sem precisar especificar a operação.
    public static String juntar(float num, float num2) {
        return Float.toString(num + num2);
    }

    public static String multiplicar(float num, float num2) {
        return Float.toString(num * num2);
    }

    public static String dividir(float num, float num2) {
        return Float.toString(num / num2);
    }

}
