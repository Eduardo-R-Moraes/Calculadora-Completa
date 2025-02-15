import java.util.ArrayList;

public class Calculadora {
    public static String ler(ArrayList<String> tokens) {
        int j = 0;
        while (j < tokens.size()) {
            if(tokens.get(j).equals("*") || tokens.get(j).equals("/")) {
                tokens.set(j-1, operacao(tokens.get(j-1), tokens.get(j), tokens.get(j+1)));

                tokens.remove(j+1);
                tokens.remove(j);
            }

            else {
                j++;
            }
        }

        while (tokens.size() > 1) {
            tokens.set(0, juntar(Float.parseFloat(tokens.get(0)), Float.parseFloat(tokens.get(1))));
            tokens.remove(1);
        }

        return tokens.get(0);
    }

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
