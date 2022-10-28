package pathners.pathner.abasctracty.factory.pagamento.cobranca;

import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;

public interface Cobranca {

    public Pagamento criarCobranca(Transacao transacao);
    public Pagamento cancelarCobranca(Pagamento pagamento);
    public Pagamento estornarCobranca(Pagamento pagamento);
    public Pagamento buscarCobranca(Long id);
}
