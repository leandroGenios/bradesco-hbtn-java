public class PersonagemGame {

	private int saudeAtual;
	private String nome;
	private String status;
	
	
	
	public PersonagemGame(int saudeAtual, String nome) {
		super();
		this.setSaudeAtual(saudeAtual);
		this.setNome(nome);
	}
	public int getSaudeAtual() {
		return saudeAtual;
	}
	public void setSaudeAtual(int saudeAtual) {
		this.saudeAtual = saudeAtual;
		if(this.saudeAtual > 0) {
			this.status = "vivo";
		}else {
			this.status = "morto";
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && !nome.equals("")) {
			this.nome = nome;			
		}
	}
	
	public void tomarDano (int quantidadeDeDano) {
		setSaudeAtual(getSaudeAtual() - quantidadeDeDano);
		
		if(getSaudeAtual() < 0) {
			setSaudeAtual(0);
		}
	}
	
	public void receberCura (int quantidadeDeCura) {
		setSaudeAtual(getSaudeAtual() + quantidadeDeCura);
		
		if(getSaudeAtual() > 100) {
			setSaudeAtual(100);
		}
	}
	
	public String getStatus() {
		return status;
	}
}
