package pathners.pathner.decorator;

public class Salame_4 extends RecheioDecorator_3{

    private Pao_1 pao;

    public Salame_4(Pao_1 pao) {
        this.pao = pao;
    }

    public String getNome(){
        return pao.getNome() + " salame R$ " + (pao.getValor() + 2);
    }

    @Override
    public double getValor() {
        return (pao.getValor() + 2);
    }
}
