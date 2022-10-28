package pathners.pathner.abasctracty.factory.factory;

import pathners.pathner.abasctracty.factory.material.*;

public class FabricacaoTipo2_3 implements ProdutoFactory_1 {


    @Override
    public Plastico_2 criarProdutoPlastico() { return new ImplementePlasticoPVC_2();
    }

    @Override
    public Vidro_2 criarProdutoVidro() {
        return new ImplementeVidro_2();
    }
}
