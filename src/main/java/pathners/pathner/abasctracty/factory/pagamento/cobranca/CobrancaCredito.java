package pathners.pathner.abasctracty.factory.pagamento.cobranca;

import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;
import pathners.pathner.abasctracty.factory.pagamento.pagamento.PagamentoCredito;

public class CobrancaCredito implements CobrancaFactory{


    @Override
    public Cobranca processar() {
        System.out.println("Criado cobrancao com cartao");
        return new PagamentoCredito();
    }
}
