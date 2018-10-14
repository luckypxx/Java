public class  MultiplicationTable{
    public void multiplicationTable(){
        int left = 1;
        int right = 1;
        for(right = 1;right<10;right++){
            for(left = 1;left <= right;left++){
                System.out.print(left+"*"+right+"="+left*right+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String []args){
        new MultiplicationTable().multiplicationTable();
    }
}