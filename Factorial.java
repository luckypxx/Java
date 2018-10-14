public class Factorial{
    public long factorial(int num){
        long result = (long)num;
        boolean bool = (num > 1)&&((result *= factorial(num - 1))>0);
        return result;
    }
    public static void main(String []args){
        Factorial fac = new Factorial();
        System.out.println(fac.factorial(20));
    }
}
