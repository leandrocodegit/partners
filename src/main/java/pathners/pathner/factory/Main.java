package pathners.pathner.factory;

public class Main {

    public static void main(String[] args) {
        ConcreteCreator_4 concreteCreator =  new ConcreteCreator_4();
        Product_1 product = concreteCreator.factoryMethod();
        product.printDetail();
    }
}
