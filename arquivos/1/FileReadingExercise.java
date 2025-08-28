import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt";

        System.out.printf("Conteúdo do arquivo '%s':%n%n", fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha); 
            }
            System.out.printf("%nLeitura do arquivo concluída.%n");
        } catch (IOException e) {
            System.out.printf("Erro ao ler o arquivo: %s%n", e.getMessage());
        }
    }
}