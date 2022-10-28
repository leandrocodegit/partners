package pathners.pathner.adapter;

public class Main {

    public static void main(String[] args) {

        Comand comand = new Comand(new AdapterMySQL());
        comand.insert();
        comand = new Comand(new AdapterOracle());
        comand.insert();
    }
}
