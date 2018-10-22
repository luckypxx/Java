import java.util.Scanner; //导入输入类
interface Computer{
    void printComputer();
}

class MacbookProComputer implements Computer{
    public void printComputer(){
        System.out.println("这是MacbookProComputer");
    }
}

class SurfacebookComputer implements Computer{
    public void printComputer(){
        System.out.println("这是SurfacebookComputer");
    }
}

class Factory{
    private Factory(){}
    public static Computer createComputer(String str){
        Computer computer = null;
        if(str.equals("mac")){
            computer = new MacbookProComputer();
            computer.printComputer();
        }else if(str.equals("surface")){
            computer = new SurfacebookComputer();
            computer.printComputer();
        }
        return computer;
    } 
}

class TestFactory{
     public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要的电脑：");
        String choice = scanner.nextLine();
        Computer computer = Factory.createComputer(choice);
    }
}
