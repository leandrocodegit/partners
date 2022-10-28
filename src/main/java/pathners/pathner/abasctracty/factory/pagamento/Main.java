package pathners.pathner.abasctracty.factory.pagamento;


import pathners.pathner.abasctracty.factory.pagamento.cobranca.CobrancaBoleto;
import pathners.pathner.abasctracty.factory.pagamento.cobranca.CobrancaPix;
import pathners.pathner.abasctracty.factory.pagamento.model.Pagamento;
import pathners.pathner.abasctracty.factory.pagamento.model.TipoDocumento;
import pathners.pathner.abasctracty.factory.pagamento.model.TransacaoBuilder;


public class Main {

    public static void main(String[] args) {

//        Pagamento pagamento = new CobrancaPix().processar().criarCobranca(new TransacaoBuilder()
//                .setPix(100.0,"100.22")
//                .setUsuario("lpoliveira.ti@gmail.com","Leandro", TipoDocumento.CPF,"08987782638")
//                .builder());
//        System.err.println(pagamento.getQrCode());
//
//        pagamento = new CobrancaPix().processar().cancelarCobranca(pagamento);
//        System.err.println(pagamento.getStatus());

        Pagamento pagamento = new CobrancaBoleto().processar().criarCobranca(new TransacaoBuilder()
                .setBoleto(100.99,"8005442")
                .setUsuario("lpoliveira.ti@gmail.com","Leandro", TipoDocumento.CPF,"08987782638")
                .setEndereco("09855340","Serra da prata","09","Cantareira","Sao Bernardo do campo","SP")
                .builder());

        System.err.println("Url " + pagamento.getUrl());
        System.err.println("Codigo barras " + pagamento.getBarcode());


    }
}























//        new CobrancaCredito().criarCobranca().gerarCobranca(new TransacaoBuilder()
//                .setTransacao(10.0,"100",1,"sad4445asd","credit_card")
//                .setUsuario("lpoliveira.ti@gmail.com","Leandro", TipoDocumento.CPF,"08987782638")
//                .builder());
//        new CobrancaDebito().criarCobranca().gerarCobranca(new TransacaoBuilder()
//                .setTransacao(10.0,"100",1,"sad4445asd","credit_card")
//                .setUsuario("lpoliveira.ti@gmail.com","Leandro", TipoDocumento.CPF,"08987782638")
//                .builder());
