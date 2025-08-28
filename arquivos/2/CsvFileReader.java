import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] dados = linha.split(",");

                if (primeiraLinha) {
                    System.out.printf("Funcionário: %s%n", dados[0]);
                    System.out.printf("Idade: %s%n", dados[1]);
                    System.out.printf("Departamento: %s%n", dados[2]);
                    System.out.printf("Salarial: %s%n", dados[3]);
                    System.out.println("------------------------");
                    primeiraLinha = false;
                    continue;
                }

                System.out.printf("Funcionário: %s%n", dados[0]);
                System.out.printf("Idade: %s%n", dados[1]);
                System.out.printf("Departamento: %s%n", dados[2]);
                System.out.printf("Salarial: %s%n", dados[3]);
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");

        } catch (IOException e) {
            System.out.printf("Erro ao ler o arquivo: %s%n", e.getMessage());
        }
    }
}