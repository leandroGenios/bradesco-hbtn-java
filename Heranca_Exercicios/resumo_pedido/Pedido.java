import produtos.Produto;

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
    
    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;
        double desconto = 0.0;

        for (ItemPedido item : itens) {
            Produto p = item.getProduto();
            double totalItem = p.obterPrecoLiquido() * item.getQuantidade();
            totalProdutos += totalItem;
            desconto += totalItem * percentualDesconto / 100;

            // Tipo da classe (Livro ou Dvd)
            String tipo = p.getClass().getSimpleName();

            System.out.printf(
                "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                tipo,
                p.getTitulo(),
                p.obterPrecoLiquido(),
                item.getQuantidade(),
                totalItem
            );
        }

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f%n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", (totalProdutos - desconto));
        System.out.println("----------------------------");
    }

}
