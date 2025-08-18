public class Video {
	
	private String nome;
	private FormatoVideo formato;
	
	
	
	public Video(String nome, FormatoVideo formato) {
		super();
		this.nome = nome;
		this.formato = formato;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public FormatoVideo getFormato() {
		return formato;
	}
	public void setFormato(FormatoVideo formato) {
		this.formato = formato;
	}
	
	

}
