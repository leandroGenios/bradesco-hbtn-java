public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public double calcularTotal() {
        double total = 0;
        if (itens != null) {
            for (ItemPedido item : itens) {
                total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
            }
        }
        total -= total * (percentualDesconto / 100.0);
        return total;
    }

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
		super();
		this.percentualDesconto = percentualDesconto;
		this.itens = itens;
	}

	// Getters e Setters
    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }
}
