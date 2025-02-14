import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String numeros;

        ArrayList<String> tokens = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("-> ");
        numeros = scanner.nextLine();

        tokens = Tokenizador.tokenizar(numeros);
        System.out.println(tokens);

        String resultado = Calculadora.ler(tokens);

        System.out.println("Resultado: " + resultado);
    }
}