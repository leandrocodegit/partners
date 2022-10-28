package pathners.pathner.abasctracty.factory.pagamento.pagamento;

import pathners.pathner.abasctracty.factory.pagamento.adapter.MercadoPagoAdapter;
import pathners.pathner.abasctracty.factory.pagamento.cobranca.Cobranca;
import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;

public class PagamentoCredito implements Cobranca {


    @Override
    public Pagamento criarCobranca(Transacao transacao) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.gerarCobrancaCartao(transacao);
    }

    @Override
    public Pagamento cancelarCobranca(Pagamento pagamento) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.cancelarCobranca(pagamento);
    }

    @Override
    public Pagamento estornarCobranca(Pagamento pagamento) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.estornarCobranca(pagamento);
    }

    @Override
    public Pagamento buscarCobranca(Long id) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.buscarCobranca(id);
    }
}
