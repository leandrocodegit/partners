package pathners.pathner.abasctracty.factory.pagamento.cobranca;

import pathners.pathner.abasctracty.factory.pagamento.pagamento.PagamentoBoleto;

public class CobrancaBoleto implements CobrancaFactory{


    @Override
    public Cobranca processar() {
        System.out.println("Criado cobrancao com cartao");
        return new PagamentoBoleto();
    }
}
