package top.bingoxin.homework;

/**1.创建一个Test类，包含有一个public权限的int型成员变量与一个char类型的成员变量，观察在main方法中的初始值。*/
class Test{
	public int i;
	public char c;
}

/**2.编写一个程序，展示无论你创建了某个特定类的多少个对象，这个类的某个特定的static成员变量只有一个属性。*/
class TestStatic{
	static int i = 1;
}

/**3.一个斐波那契数列是由数字1、1、2、3、5、8、13、21、34等等组成的，其中每一个数字(从第三个数字起)都是前两个数字的和。创建一个方法，接受一个整数参数，并显示从第一个元素开始总共由该参数指定的个数所构成的所有斐波那契数字。例如，如果运行 java Fibonacci 5(Fibonacci为类名)，那么输出应该是1、1、2、3、5。*/
class Fibonacci{
	
	public int fibonacci(int n) {
		int result = 1;
		int first =1;
		int second = 1;
		
		if(n == 1) {
			System.out.print(n + " ");
			return 1;
		}else {
			n -= 2;
			System.out.print("1 1" + " ");
		}
		
		//用于计算第三以后每一位的值
		while(n > 0) {
			result = first + second;
			first = second;
			second = result;
			System.out.print(result + " ");
			n--;
			}
		return result;
	}
}

/**4.创建一个带默认构造方法（即无参构造）的类，在构造方法中打印一条消息"Hello Constructor";再为这个类添加一个重载构造方法，令其接收一个字符串参数，并在这个有参构造方法中把"Hello Constructor"和接收的参数一起打印出来。*/
class PrintString{
	PrintString(){
		System.out.println("Hello Constructor");
	}
	PrintString(String s){
		System.out.println("Hello Constructor" + s);
	}
}

public class Day2 {
	public static void main(String[] args) {
		//测试1 
		Test t = new Test();
		System.out.println("c="+t.c);
		System.out.println(t.i);
		
		//测试2
		TestStatic s1 = new TestStatic();
		TestStatic s2 = new TestStatic();
		System.out.println(s1.i++);
		System.out.println(s2.i++);
		
		//测试3
		new Fibonacci().fibonacci(1);
		
		//测试4
		new PrintString("!");
	}

}
