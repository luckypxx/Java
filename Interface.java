package homework;

/**1.说出下面程序的执行结果:
 *interface InterfaceA {
 * String S = "good ";
 * void f();
 * }
 *
 * abstract class ClassA {
 * abstract void g();
 * }
 *
 * class ClassB extends ClassA implements InterfaceA {
 * void g() {
 * System.out.print(S);
 * }
 *
 * public void f() {
 * System.out.print(" "+ S);
 * }
 * }
 * public class Test {
 * public static void main(String[] args) {
 * ClassA a = new ClassB();
 * InterfaceA b = new ClassB();
 * a.g();
 * b.f();
 * }
 * }
 * 输出结果为：good  good
 * */

/**
 * 2.编程题:
 *  * 利用接口做参数，写个计算器，能完成加减乘除运算。
 *  * （1）定义一个接口Compute含有一个方法int computer(int n, int m)。
 *  * （2）设计四个类分别实现此接口，完成加减乘除运算。
 *  * （3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
 *  * （4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。
 *  **/
interface Compute{
    int computer(int n, int m);
}

class Add implements Compute{
    public int computer(int n, int m){
        return n+m;
    }
}

class Sub implements Compute{
    public int computer(int n, int m){
        return n-m;
    }
}

class Mul implements Compute{
    public int computer(int n, int m){
        return n*m;
    }
}

class Div implements Compute{
    @Override
    public int computer(int n, int m){
        return n/m;
    }
}

class UseCompute{
    public void useCom(Compute com, int one, int two){
        System.out.println(com.computer(one,two));
    }
}

/**
 *  3.按如下要求编写Java程序：
 *  * （1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
 *  * （2）定义接口B，里面包含抽象方法void setColor(String c)。
 *  * （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
 *  * （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
 *  * 圆柱体的高height、颜色color。
 *  * （5）创建主类来测试类Cylinder。*/
interface A{
    public static final double PI = 3.14;
    double area();
}

interface B{
    void setColor(String c);
}

interface C extends A ,B{
    void volume();
}
class Cylinder implements C{
    public double radius;
    public double height;
    public String color;

    @Override
    public double area() {
        return (2*radius*radius*PI+2*PI*radius*height);
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void volume() {

    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void setColor(String c) {
        color = c;
    }
}

/**
 * 4.(附加题-算法)
 *  * 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数。*/
class Number{
    public int count;
    public Number(int c){
        count = c;
        int sum = 0;
        for(int i = 1;i < count;++i){
            if(count%i == 0){
                sum += i;
            }
        }
        if(sum == count){
            System.out.println(count);
        }
    }
}
public class Interface {
    public static void main(String[] args) {
        UseCompute useCompute = new UseCompute();
        Compute add = new Add();
        useCompute.useCom(add,1,3);
        C cylinder = new Cylinder();
        cylinder.setColor("blue");
        System.out.println(((Cylinder) cylinder).color);
        for(int i = 1;i < 1000;++i){
            new Number(i);
        }
    }
}



