package pathners.pathner.abasctracty.factory.pagamento.adapter;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.payment.PaymentRefund;
import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.PagamentoBuild;
import pathners.pathner.abasctracty.factory.pagamento.model.Transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class MercadoPagoAdapter extends PaymentClient {

    public MercadoPagoAdapter() {
        MercadoPagoConfig.setAccessToken("TEST-3070472608701511-110619-46cc8dd83c8394c236b931dc6ce796f8-658800087");
    }

    public Pagamento gerarCobrancaCartao(Transacao transacao) {
        try {
            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(transacao.getValor()))
                            .token(transacao.getToken())
                            .description(transacao.getNumeroPedido())
                            .installments(transacao.getParcelas())
                            .paymentMethodId(transacao.getMetodoPagamento())
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(transacao.getUsuario().getEmail())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(transacao.getUsuario().getTipoDocumento().name())
                                                            .number(transacao.getUsuario().getDocumento())
                                                            .build())
                                            .build())
                            .build();
            Payment payment = super.create(paymentCreateRequest);
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
                    .setCardDetalhes(
                            payment.getCard().getLastFourDigits(),
                            payment.getIssuerId(),
                            payment.getTransactionDetails().getInstallmentAmount(),
                            payment.getTransactionDetails().getInstallmentAmount(),
                            payment.getInstallments())
                    .build();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Pagamento gerarCobrancaPix(Transacao transacao) {
        try {
            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(transacao.getValor()))
                            .description(transacao.getNumeroPedido())
                            .paymentMethodId("pix")
                            .dateOfExpiration(OffsetDateTime.now().plusMinutes(30))
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(transacao.getUsuario().getEmail())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(transacao.getUsuario().getTipoDocumento().name())
                                                            .number(transacao.getUsuario().getDocumento())
                                                            .build())
                                            .build())
                            .build();
            Payment payment = super.create(paymentCreateRequest);
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
                    .setPixDetalhes(
                            payment.getPointOfInteraction().getTransactionData().getQrCode(),
                            payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                            payment.getDateOfExpiration())
                    .build();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Pagamento cancelarCobranca(Pagamento pagamento) {
        try {
            if (pagamento.getTransacao().getMetodoPagamento().equals("pix")) {
                Payment payment = super.cancel(pagamento.getId());
                System.out.println("Cancelando " + pagamento.getId());
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
                        .build();
            } else throw new RuntimeException("Error");
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }


    public Pagamento estornarCobranca(Pagamento pagamento) {
        try {
            if (pagamento.getTransacao().getMetodoPagamento().equals("pix")) {
                PaymentRefund payment = super.refund(pagamento.getId());
                return new PagamentoBuild()
                        .create(payment.getId(), payment.getReason(), payment.getStatus(), payment.getRefundMode(), payment.getAmount())
                        .setEstorno(payment.getDateCreated())
                        .build();
            } else throw new RuntimeException("Error");
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Pagamento buscarCobranca(Long id) {
        try {
            Payment payment = super.get(id);
            PagamentoBuild pagamento = new PagamentoBuild()
                    .create(
                            payment.getId(),
                            payment.getPaymentMethodId(),
                            payment.getStatus(),
                            payment.getStatusDetail(),
                            payment.getTransactionAmount())
                    .setDatesTime(
                            payment.getDateCreated(),
                            payment.getDateApproved(),
                            payment.getDateLastUpdated());

            if (payment.getPaymentMethodId().equals("pix"))
                pagamento.setPixDetalhes(
                                payment.getPointOfInteraction().getTransactionData().getQrCode(),
                                payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                                payment.getDateOfExpiration())
                        .build();
            else if (payment.getPaymentMethodId().equals("credit_card"))
                pagamento.setCardDetalhes(
                        payment.getCard().getLastFourDigits(),
                        payment.getIssuerId(),
                        payment.getTransactionDetails().getInstallmentAmount(),
                        payment.getTransactionDetails().getInstallmentAmount(),
                        payment.getInstallments())
                        .setDatesTime(
                                payment.getDateCreated(),
                                payment.getDateApproved(),
                                payment.getDateLastUpdated());
            return pagamento.build();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }
}
