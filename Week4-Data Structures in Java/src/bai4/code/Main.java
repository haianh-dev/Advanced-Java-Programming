package bai4.code;

interface IData {
    void show();
}

class DataManager implements IData {
    @Override
     public void show() {
        System.out.println("Show Data");
    }
}


public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.show();
    }
}
