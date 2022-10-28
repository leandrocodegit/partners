package pathners.pathner.adapter;

public class Comand implements Adapter {


    private Adapter adapter;

    public Comand(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void insert() {
        adapter.insert();
    }
}
