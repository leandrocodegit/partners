package pathners.pathner.decorator;

public class Calabresa_4 extends RecheioDecorator_3{

    private Pao_1 pao;

    public Calabresa_4(Pao_1 pao) {
        this.pao = pao;
    }

    public String getNome(){
        return pao.getNome() + " calabresa R$ " + (pao.getValor() + 1);
    }
}
