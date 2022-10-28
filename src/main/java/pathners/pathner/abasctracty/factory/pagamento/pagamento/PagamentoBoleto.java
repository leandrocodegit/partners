package pathners.pathner.abasctracty.factory.pagamento.pagamento;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import pathners.pathner.abasctracty.factory.pagamento.adapter.MercadoPagoAdapter;
import pathners.pathner.abasctracty.factory.pagamento.adapter.MercadopagoClientAdapter;
import pathners.pathner.abasctracty.factory.pagamento.cobranca.Cobranca;
import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;

public class PagamentoBoleto implements Cobranca {
    @Override
    public Pagamento criarCobranca(Transacao transacao) {
        MercadopagoClientAdapter pay = new MercadopagoClientAdapter();
        try {
            return pay.createBoleto(transacao);
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
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
