package homework;

/**
 * 1.复习课件，总结String、Object、包装类的常用方法以及注意点，更新到博客，把更新后的地址写到作业里。
/**2.编程题:
        * 要求:
        * 1).Person类有name,age,salary属性，要求实现至少两个构造方法，并且属性私有，提供对应的getter、setter。
        * 2).覆写toString方法，要求在System.out.println()函数中传递Person对象能打印出三个属性值而不是对象地址。
        * 3).覆写equals方法，要求两个Person类对象的值相同时返回true。
        */

class Person{
    private String name;
    private int age;
    private int salary;

    public Person() {
    }

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"年龄："+this.age+"薪资:"+this.salary;
    }

    @Override
    public boolean equals(Object obj) {
        Person per = (Person)obj;
        return (this.salary == per.salary)&&(this.age == per.age)&&(this.name == per.name);
    }
}

/* 3.说出下列程序的执行结果，并说明原因:
        * Integer a = 55;
        * Integer b = 55;
        * System.out.println(a==b); //true
        * System.out.println(a==new Integer(55));//false
        * System.out.println(a.equals(new Integer(55)));//true
        * Integer c = 129;
        * Integer d = 129;
        * System.out.println(c==d);//false
        */
/**4.写出懒汉式单例模式*/
class Singleton{
    private static Singleton singleton = new Singleton();
    private Singleton(){}

    public static Singleton getSingleton() {
        return singleton;
    }
}

/** 5.编程:
 * 1).定义一个MulException类继承Exception类，要求两数相乘等于100报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。
 * 2).定义一个DivException类继承RuntimeException类，要求两数相除等于2报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。
 **/
class MulException extends Exception{
    public MulException(String str){
        super(str);
    }
}

class DivException extends RuntimeException{
    public DivException(String str){
        super(str);
    }
}

/* 6.(算法)
* 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个
第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。*/

public class PracticeString{

    public static void main(String[]args){
        int peach = 1;
        for(int i = 1;i< 10;++i){
            peach = (peach + 1)*2;
        }

//        Singleton singleton = Singleton.getSingleton();
//        System.out.println(singleton);
    //    System.out.println(new Person("张恒",20,40));
    //    Person per1 = new Person("张恒",20,40);
    //    Person per2 = new Person("张恒",20,40);
    //    System.out.println(per1.equals(per2));
//            try{
//                test();
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        test1();
    }
    public static void test() throws Exception{
        int i = 10;
        int j = 10;
        if(i*j == 100){
            throw new MulException("两数相乘等于100");
        }
    }

    public static void test1(){
        int x = 10;
        int y = 5;
        if(x/y == 2){
            throw new DivException("两数相除不能等于2");
        }
    }
}

