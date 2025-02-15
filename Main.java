import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declaração da lista que vai guardar os tokens
        ArrayList<String> tokens = new ArrayList<>();

        // Scanner para a leitura de dados
        Scanner scanner = new Scanner(System.in);

        // Leitura da string com números e operadores
        System.out.print("-> ");
        String numeros = scanner.nextLine();

        // Tranformação da string em tokens
        tokens = Tokenizador.tokenizar(numeros);
        
        // Lê os tolkens e faz os cálculos
        String resultado = Calculadora.ler(tokens);

        // Visualização dos resultados
        System.out.println("Resultado: " + resultado);
        
        scanner.close();
         
    }
}