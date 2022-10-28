package pathners.pathner.abasctracty.factory.pagamento.model;

//import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Pagamento {

    private Long id;
//    @JsonProperty("data_criacao")
    private OffsetDateTime dataCriacao;
//    @JsonProperty("data_aprovacao")
    private OffsetDateTime dataAprovacao;
//    @JsonProperty("ultima_atualizacao")
    private OffsetDateTime ultimaAtualizacao;
//    @JsonProperty("data_expiracao")
    private OffsetDateTime dataExpiracao;
//    @JsonProperty("tipo_operacao")
    private OffsetDateTime dataEstorno;
    //    @JsonProperty("tipo_operacao")
    private String tipoOperacao;
//    @JsonProperty("issuer_id")
    private String issuerId;
//    @JsonProperty("metodo_pagamento")
    private String metodoPagamento;
//    @JsonProperty("status")
    private String status;
//    @JsonProperty("detalhes")
    private String detalhes;
//    @JsonProperty("valor")
    private BigDecimal valor;
//    @JsonProperty("total")
    private BigDecimal total;
//    @JsonProperty("valor_parcela")
    private BigDecimal valorParcela;
//    @JsonProperty("parcelas")
    private int parcelas;
//    @JsonProperty("quatro_digitos_cartao")
    private String quatroDigitosCartao;
//    @JsonProperty("qr_code_base64")
    //@Column(length = 8048)
    private String qrCodeBase64;
    //@Column(length = 1048)
    private String qrCode;
    private String url;
    private String barcode;

    private Transacao transacao;

    public Pagamento(Long id, String metodoPagamento, String status, String detalhes, BigDecimal valor) {
        this.id = id;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.detalhes = detalhes;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public OffsetDateTime getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(OffsetDateTime dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public OffsetDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(OffsetDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public OffsetDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(OffsetDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public OffsetDateTime getDataEstorno() {
        return dataEstorno;
    }

    public void setDataEstorno(OffsetDateTime dataEstorno) {
        this.dataEstorno = dataEstorno;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getQuatroDigitosCartao() {
        return quatroDigitosCartao;
    }

    public void setQuatroDigitosCartao(String quatroDigitosCartao) {
        this.quatroDigitosCartao = quatroDigitosCartao;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

