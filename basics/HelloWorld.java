// 练习目标：Java 程序的最小骨架 —— 类、main 方法、控制台输出
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int x=100;
        System.out.println(x);
        double y=3000;
        System.out.println(y);


        double d = 1.2;
        int num = (int)d;//损失精度
        System.out.println(num);
        System.out.println("disahdiuash" + 1 + 2);//12
        if(1>0){
            System.out.println("我爱你");//12
        }

        int x_crash=60;
        x_crash>>=4;
        System.out.println(x_crash);//12
        

        x=1&1;
        System.out.println(x);


        boolean marry=false;
        System.out.println(marry?"love":"hate");
    //1、准备Scanner类型的变量
        java.util.Scanner input = new java.util.Scanner(System.in);//System.in默认代表键盘输入
    
        int month;

        month =input.nextInt();
        switch(month){
            case 1:
            case 2:
            case 3:
            
                System.out.println("春季");
                break;

            case 4:
            case 5:
            case 6:
            
                System.out.println("summer");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("autumn");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("winter");
                break;
            
            default:
                System.out.println("motherfucker,your month dose not fucking exist");
                


        }



        

    }
}
