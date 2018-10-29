package top.bingoxin.test;

public class Singleton {
    private static final Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton(){
        return singleton;
    }
}

class TestSingleton{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        try {
            System.out.print(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
