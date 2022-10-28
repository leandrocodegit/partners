package pathners.pathner.abasctracty.factory.pagamento.cobranca;

import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;
import pathners.pathner.abasctracty.factory.pagamento.pagamento.PagamentoPix;

public class CobrancaPix implements CobrancaFactory{


    @Override
    public Cobranca processar() {
        System.out.println("Criado cobrancao com pix");
        return new PagamentoPix();
    }
}
