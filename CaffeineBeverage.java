import java.util.Scanner; //导入输入类

abstract class CaffeineBeverage{
    //准备饮料
    public final void prepareRecipe(){
        boilWater();//烧开水
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
        System.out.println();
    }
    public final void boilWater(){
        System.out.println("正在烧水");
    }
    public abstract void brew();
    public final void pourInCup(){
        System.out.println("把饮料倒进杯子里");
    }
    public abstract void addCondiments();
    public boolean customerWantsCondiments(){
        return true;
    } 

    public static void main(String []args){
        CaffeineBeverage caff = new Coffee();
        caff.prepareRecipe();
        CaffeineBeverage caff1 = new Tea();
        caff1.prepareRecipe();
    }
}

class Coffee extends CaffeineBeverage{
     public void brew(){
         System.out.println("冲泡咖啡");
     }
     public void addCondiments(){
         System.out.println("加入牛奶和糖");
     }
     
     public boolean customerWantsCondiments(){
        System.out.println("是否要加东西？y/n");
        String answer = null;
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        if(answer.equals("y")){
            return true;
        }else{
            return false;
        }
    } 
}

class Tea extends CaffeineBeverage{
    public void brew(){
        System.out.println("浸泡茶包");
    }
    public void addCondiments(){
        System.out.println("加入柠檬");
    }
}

