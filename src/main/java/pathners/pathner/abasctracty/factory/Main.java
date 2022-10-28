package pathners.pathner.abasctracty.factory;

import pathners.pathner.abasctracty.factory.factory.FabricacaoTipo1_3;
import pathners.pathner.abasctracty.factory.factory.FabricacaoTipo2_3;
import pathners.pathner.abasctracty.factory.factory.ProdutoFactory_1;
import pathners.pathner.abasctracty.factory.material.ImplementePlasticoPP_2;
import pathners.pathner.abasctracty.factory.material.ImplementeVidro_2;

public class Main {

    public static void main(String[] args) {
        ProdutoFactory_1 AX = new FabricacaoTipo1_3();
        ProdutoFactory_1 AY = new FabricacaoTipo2_3();

         AX.criarProdutoPlastico().GerarPlastico();
         AY.criarProdutoVidro().GerarVidro();




    }
}
