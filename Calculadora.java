import java.util.ArrayList;

public class Calculadora {
    // Ainda em andamento
    // Função que lê os tokens e realiza as operações
    public static String ler(ArrayList<String> tokens) {
        String[] buffer = new String[3];

        // percorre resolvendo todas as operações especiais
        for(int i = tokens.size() - 2; i < tokens.size(); i -= 2) {
            if((tokens.get(i).equals("*") || tokens.get(i).equals("/"))) {
                // Coloca no buffer as variáveis a serem calculadas
                buffer[0] = tokens.get(i-1);
                buffer[1] = tokens.get(i);
                buffer[2] = tokens.get(i+1);

                // Armazena o resultado na variável antes do sinal.
                tokens.set(i-1, operacao(buffer));

                // Remove o sinal e o que vem depois
                tokens.remove(i+1);
                tokens.remove(i);
            }
        }

        // O buffer tem a função de armazenar os 3
        // caracteres a serem processados
        buffer[0] = tokens.get(0);
        buffer[1] = tokens.get(1);
        buffer[2] = tokens.get(2);

        // Armazena sempre no primeiro índice
        // o valor da soma para formar uma pilha de soma
        buffer[0] = operacao(buffer);

        // Se houver mais de 2 números, entra no loop
        // para processar todos
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
            return somar(Float.parseFloat(numeros[0]), Float.parseFloat(numeros[2]));
        }
        else if (numeros[1].equals("-")) {
            return subtrair(Integer.parseInt(numeros[0]), Integer.parseInt(numeros[2]));
        }
        else if (numeros[1].equals("*")) {
            return multiplicar(Integer.parseInt(numeros[0]), Integer.parseInt(numeros[2]));
        }
        else if (numeros[1].equals("/")) {
            return dividir(Integer.parseInt(numeros[0]), Integer.parseInt(numeros[2]));
        }
        return "";
    }

    public static String somar(float num, float num2) {
        return Float.toString(num + num2);
    }

    public static String subtrair(float num, float num2) {
        return Float.toString(num - num2);
    }

    public static String multiplicar(float num, float num2) {
        return Float.toString(num * num2);
    }

    public static String dividir(float num, float num2) {
        return Float.toString(num / num2);
    }

}
