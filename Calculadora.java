import java.util.ArrayList;

public class Calculadora {
    // Ainda em andamento
    // Função que lê os tokens e realiza as operações
    public static String ler(ArrayList<String> tokens) {
        String[] buffer = {tokens.get(0), tokens.get(1), tokens.get(2)};

        buffer[0] = operacao(buffer);

        if (tokens.size() > 3) {
            for(int i = 3; i < tokens.size(); i += 2) {
                buffer[1] = tokens.get(i);
                buffer[2] = tokens.get(i + 1);

                buffer[0] = operacao(buffer);
            }
        }

        return buffer[0];
    }

    // Recebe um array de Strings de tamanho 3
    // e realiza as operações nele descrito. 
    // Retona um número em String para ser usado na
    // a função ler.
    public static String operacao(String[] numeros) {
        if (numeros[1].equals("+")) {
            return somar(Integer.parseInt(numeros[0]), Integer.parseInt(numeros[2]));
        }
        else if (numeros[1].equals("-")) {
            return subtrair(Integer.parseInt(numeros[0]), Integer.parseInt(numeros[2]));
        }
        return "";
    }

    public static String somar(int num, int num2) {
        return Integer.toString(num + num2);
    }

    public static String subtrair(int num, int num2) {
        return Integer.toString(num - num2);
    }
}
