package top.bingoxin.practice;

public class TestSplit {
    public static void main(String[] args) {
        String str = "Lisa:18|Tom:20";
        String[] result = str.split("\\|");
        for(String temp:result){
            String name = temp.split(":")[0];
            String age = temp.split(":")[1];
            System.out.println("姓名："+name);
            System.out.println("年龄:"+age);
        }
    }
}
