package pathners.pathner.abasctracty.factory.factory;

import pathners.pathner.abasctracty.factory.material.ImplementePlasticoPP_2;
import pathners.pathner.abasctracty.factory.material.ImplementeVidro_2;
import pathners.pathner.abasctracty.factory.material.Plastico_2;
import pathners.pathner.abasctracty.factory.material.Vidro_2;

public class FabricacaoTipo1_3 implements ProdutoFactory_1 {


    @Override
    public Plastico_2 criarProdutoPlastico() { return new ImplementePlasticoPP_2();
    }

    @Override
    public Vidro_2 criarProdutoVidro() {
        return new ImplementeVidro_2();
    }
}
