package pathners.pathner.abasctracty.factory.pagamento.adapter;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.HttpMethod;
import com.mercadopago.net.MPRequest;
import com.mercadopago.net.MPResponse;
import com.mercadopago.serialization.Serializer;
import pathners.pathner.abasctracty.factory.pagamento.adapter.request.Address;
import pathners.pathner.abasctracty.factory.pagamento.adapter.request.BoletoPaymentRequest;
import pathners.pathner.abasctracty.factory.pagamento.adapter.request.Payer;
import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.PagamentoBuild;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.mercadopago.serialization.Serializer.deserializeFromJson;

public class MercadopagoClientAdapter extends MercadoPagoClient {

    public MercadopagoClientAdapter() {
        super(MercadoPagoConfig.getHttpClient());
        MercadoPagoConfig.setAccessToken("TEST-3070472608701511-110619-46cc8dd83c8394c236b931dc6ce796f8-658800087");
    }

    public Pagamento createBoleto(Transacao transacao) throws MPException, MPApiException {
        BoletoPaymentRequest request = new BoletoPaymentRequest();
        String firstName = transacao.getUsuario().getNome();
        String lastName = "*";

        if(transacao.getUsuario().getNome().contains(" ")){
            firstName = transacao.getUsuario().getNome().substring(0, transacao.getUsuario().getNome().indexOf(" "));
            lastName = transacao.getUsuario().getNome().substring(transacao.getUsuario().getNome().indexOf(" "), transacao.getUsuario().getNome().length());
        }

        request.setTransactionAmount(
                new BigDecimal(transacao.getValor()).setScale(2, RoundingMode.CEILING));
        request.setDescription(transacao.getNumeroPedido());
        request.setPaymentMethodId("bolbradesco");
        request.setPayer(
                new Payer(
                        transacao.getUsuario().getEmail(),
                        firstName,
                        lastName,
                        IdentificationRequest.builder()
                                .type(transacao.getUsuario().getTipoDocumento().name())
                                .number(transacao.getUsuario().getDocumento())
                                .build(),
                        new Address(transacao.getUsuario().getEndereco().getCep(),
                                transacao.getUsuario().getEndereco().getLogradouro(),
                                transacao.getUsuario().getEndereco().getNumero(),
                                transacao.getUsuario().getEndereco().getBairro(),
                                transacao.getUsuario().getEndereco().getCidade(),
                                transacao.getUsuario().getEndereco().getUf())));

        MPRequest mpRequest =
                MPRequest.builder()
                        .uri("/v1/payments")
                        .method(HttpMethod.POST)
                        .payload(Serializer.serializeToJson(request))
                        .build();

        MPResponse response = send(mpRequest);
        PaymentAdapter payment = deserializeFromJson(PaymentAdapter.class, response.getContent());
        payment.setResponse(response);

        return new PagamentoBuild()
                .create(
                        payment.getId(),
                        payment.getPaymentMethodId(),
                        payment.getStatus(),
                        payment.getStatusDetail(),
                        payment.getTransactionAmount())
                .setDatesTime(
                        payment.getDateCreated(),
                        payment.getDateApproved(),
                        payment.getDateLastUpdated())
                .setTransacao(transacao)
                .setBoletoDetalhes(
                        payment.getTransactionDetails().getExternalResourceUrl(),
                        payment.getBarcode().getContent(),
                        payment.getTransactionDetails().getTotalPaidAmount(),
                        payment.getDateOfExpiration())
                .build();
    }
}
