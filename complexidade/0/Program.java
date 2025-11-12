public class Program {

    public static void main(String[] args) {

        PessoasArray p = new PessoasArray();

        System.out.println(p.pesquisaTempoConstante(2));
        System.out.println(p.pesquisaTempoConstante(7));
        System.out.println(p.pesquisaTempoConstante(25)); // aqui deve lançar exceção
    }
}
