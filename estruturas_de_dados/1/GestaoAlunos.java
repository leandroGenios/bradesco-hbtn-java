import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {

    private List<Aluno> alunos;

    public GestaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
        System.out.println("Aluno adicionado: " + nome);
    }

    public void excluirAluno(String nome) {
        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));

        if (removido) {
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado para remoção: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado na busca: " + nome);
    }

    public void listarAlunos() {
        System.out.println("\nLista de alunos cadastrados:");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static void main(String[] args) {

        GestaoAlunos gestao = new GestaoAlunos();

        // adicionando 3 alunos
        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Ana", 22);
        gestao.adicionarAluno("Carlos", 19);

        gestao.listarAlunos();

        gestao.buscarAluno("Ana");

        gestao.excluirAluno("Carlos");

        gestao.excluirAluno("Maria");

        gestao.buscarAluno("Carlos");
    }
}
