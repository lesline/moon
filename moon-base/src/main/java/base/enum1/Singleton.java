package base.enum1;

public enum Singleton {

    INSTANCE("test", 1);
    private final int id;
    private final String name;

    Singleton(String n, int i) {
        id = i;
        name = n;
    }

    public void leaveTheBuilding() {
        System.out.println("name:" + name + " id:" + id);
        ;
    }

    public Singleton getInstance() {
        return INSTANCE;
    }
}