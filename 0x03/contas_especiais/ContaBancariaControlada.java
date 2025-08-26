import exceptions.OperacaoInvalidaException;

public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double tarifaMensal, double saldoMinimo, double valorPenalidade) {
        super(numeracao, tarifaMensal);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        // Aplica lógica da classe base (tarifa e juros)
        super.aplicarAtualizacaoMensal();

        // Aplica penalidade se saldo abaixo do mínimo
        if (getSaldo() < saldoMinimo) {
            try {
                sacar(valorPenalidade);
            } catch (OperacaoInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
    