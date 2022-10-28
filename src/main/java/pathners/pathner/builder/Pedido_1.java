package pathners.pathner.builder;

import java.util.List;

public class Pedido_1 {

    private Long numeroPedido;
    private Loja_2 loja;
    private Vendedor_2 vendedor;
    private List<Produto_2> produtos;

    public Pedido_1() {}
    public Pedido_1(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Loja_2 getLoja() {
        return loja;
    }

    public void setLoja(Loja_2 loja) {
        this.loja = loja;
    }

    public Vendedor_2 getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor_2 vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto_2> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto_2> produtos) {
        this.produtos = produtos;
    }

    public void printPedido() {
        System.out.println(
                "Pedido: " + numeroPedido +
                        "\nLoja: " + loja.getNome() +
                        "\nVendedor: " + vendedor.getNome() + "(" + vendedor.getCogido() + ")" +
                        "\nProdutos: " + produtos);
    }
}
