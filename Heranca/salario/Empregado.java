public class Empregado {
	
	private double salarioFixo;
	
	public Empregado(double salarioFixo) {
		super();
		this.salarioFixo = salarioFixo;
	}
	
	public double calcularBonus(Departamento departamento) {
		if (departamento.alcancouMeta()) {
            return salarioFixo * 0.10;
        }
        return 0.0;
	}
	
	public double calcularSalarioTotal(Departamento departamento) {
		return salarioFixo + calcularBonus(departamento);
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}
	
	

}
