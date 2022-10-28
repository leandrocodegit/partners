package pathners.pathner.adapter;

public class AdapterOracle extends SDKOracle implements Adapter{


    @Override
    public void insert() {
        super.insertMySQL();
    }
}
