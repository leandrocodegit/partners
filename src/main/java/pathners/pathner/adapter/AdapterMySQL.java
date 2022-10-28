package pathners.pathner.adapter;

public class AdapterMySQL extends SDKMysql implements Adapter{


    @Override
    public void insert() {
        super.insertMySQL();
    }
}
