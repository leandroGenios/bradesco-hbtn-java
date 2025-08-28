import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private String arquivoCsv;

    public Estoque(String arquivoCsv) {
        this.arquivoCsv = arquivoCsv;
        this.produtos = new ArrayList<>();
        carregarEstoque();
    }

    // Carrega os produtos do arquivo CSV
    private void carregarEstoque() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCsv))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue; // ignora linhas vazias
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                int quantidade = Integer.parseInt(campos[2]);
                double preco = Double.parseDouble(campos[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Um novo será criado ao salvar.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Salva os produtos no arquivo CSV
    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCsv))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    // Gera um novo ID único
    private int gerarNovoId() {
        int maiorId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maiorId) {
                maiorId = p.getId();
            }
        }
        return maiorId + 1;
    }

    // Adiciona produto
    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
        System.out.println("Produto adicionado com sucesso: " + novoProduto);
    }

    // Excluir produto por ID
    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarEstoque();
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    // Exibir estoque
    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    // Atualizar quantidade
    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarEstoque();
                System.out.println("Quantidade atualizada com sucesso.");
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }
}