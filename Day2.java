package top.bingoxin.homework;

/**1.����һ��Test�࣬������һ��publicȨ�޵�int�ͳ�Ա������һ��char���͵ĳ�Ա�������۲���main�����еĳ�ʼֵ��*/
class Test{
	public int i;
	public char c;
}

/**2.��дһ������չʾ�����㴴����ĳ���ض���Ķ��ٸ�����������ĳ���ض���static��Ա����ֻ��һ�����ԡ�*/
class TestStatic{
	static int i = 1;
}

/**3.һ��쳲�����������������1��1��2��3��5��8��13��21��34�ȵ���ɵģ�����ÿһ������(�ӵ�����������)����ǰ�������ֵĺ͡�����һ������������һ����������������ʾ�ӵ�һ��Ԫ�ؿ�ʼ�ܹ��ɸò���ָ���ĸ��������ɵ�����쳲��������֡����磬������� java Fibonacci 5(FibonacciΪ����)����ô���Ӧ����1��1��2��3��5��*/
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
		
		//���ڼ�������Ժ�ÿһλ��ֵ
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

/**4.����һ����Ĭ�Ϲ��췽�������޲ι��죩���࣬�ڹ��췽���д�ӡһ����Ϣ"Hello Constructor";��Ϊ��������һ�����ع��췽�����������һ���ַ�����������������вι��췽���а�"Hello Constructor"�ͽ��յĲ���һ���ӡ������*/
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
		//����1 
		Test t = new Test();
		System.out.println("c="+t.c);
		System.out.println(t.i);
		
		//����2
		TestStatic s1 = new TestStatic();
		TestStatic s2 = new TestStatic();
		System.out.println(s1.i++);
		System.out.println(s2.i++);
		
		//����3
		new Fibonacci().fibonacci(1);
		
		//����4
		new PrintString("!");
	}

}
