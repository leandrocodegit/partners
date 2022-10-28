package pathners.pathner.builder;

public class Main {

    public static void main(String[] args) {

        Pedido_1 pedido_1 = new PedidoBuilder_3(10000L)
                .setLoja("Decoratem", "Decoração para o lar")
                .setVendedor(10L, "Leandro")
                .setProduto(8890L,"Chocolate branco", 9.90)
                .setProduto(9090L, "Barra de cereal", 18.5)
                .builder();

        pedido_1.printPedido();
    }
}
