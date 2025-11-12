public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // ✅ Implementação do método com Complexidade O(1)
    public String pesquisaTempoConstante(int id) {

        if (id < 0 || id >= nomes.length) {
            throw new IllegalArgumentException(
                    "O array de nomes possui " + nomes.length + " nomes."
            );
        }

        return "Nome pesquisado é " + nomes[id] + " que está na posição " + id;
    }
}
