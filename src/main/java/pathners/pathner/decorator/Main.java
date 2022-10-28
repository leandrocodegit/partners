package pathners.pathner.decorator;

public class Main {

    public static void main(String[] args) {

        Salame_4 lanche = new Salame_4(new Baguete_2());
        System.out.println( lanche.getNome());
        lanche = new Salame_4(new Frances_2());
        System.out.println( lanche.getNome());

    }
}
