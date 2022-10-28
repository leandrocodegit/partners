package pathners.pathner.builder;

import java.util.ArrayList;

public class PedidoBuilder_3 {

    private Pedido_1 instance;

    public PedidoBuilder_3(Long numeroPedido) {
        this.instance = new Pedido_1(numeroPedido);
    }

    public PedidoBuilder_3 setLoja(String nome, String categoria){
        Loja_2 loja = new Loja_2();
        loja.setNome(nome);
        loja.setCategoria(categoria);
        instance.setLoja(loja);
        return this;
    }

    public PedidoBuilder_3 setVendedor(Long codigo, String nome){
        Vendedor_2 vendedor = new Vendedor_2();
        vendedor.setCogido(codigo);
        vendedor.setNome(nome);
        instance.setVendedor(vendedor);
        return this;
    }

    public PedidoBuilder_3 setProduto(Long codigo, String descricao, Double valor){
        Produto_2 produto = new Produto_2();
        produto.setCodigo(codigo);
        produto.setDescricao(descricao);
        produto.setValor(valor);

        if(instance.getProdutos() == null)
            instance.setProdutos(new ArrayList<Produto_2>());

        instance.getProdutos().add(produto);
        return this;
    }

    public Pedido_1 builder(){
        return instance;
    }

}
