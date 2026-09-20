//polymorphic
public class main{
    public static void main(String[] args) {
       Income[] incomes = new Income[3];
         incomes[0] = new Income(10000);
         incomes[1] = new Salary(120000);
         incomes[2] = new StateCouncilSpecialAllowance(10000);
            for (Income income : incomes) {
                System.out.println(income.getTax());
            }
    }
}

class Income{
    protected double income;
    public Income(double income){
        this.income=income;
    }
    public double getTax(){
        return income*0.1;   
    }

}
class Salary extends Income{
    public Salary(double income){
        super(income);//call the super class's constructor,
    }
    @Override//override the super class's method,to meet different needs in real life
    public double getTax(){
        if(income<=5000){
            return 0;
    }
    return (income-5000)*0.2;
    }
}
class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}


//final class cannot be inherited
//final method cannot be overridden
//final variable cannot be reassigned
// final修饰的方法可以阻止被覆写；
// final修饰的class可以阻止被继承；
// final修饰的field必须在创建对象时初始化，随后不可修改。

//abstract class cannot be instantiated, but can be inherited
//absract is used to create a standard for the subclass to implement, and the subclass must implement the abstract method
//abstact function has nothing in it, it is just a standard for the subclass to implement
//abstract provides a model,any subclass can implement the abstract method, but the subclass must implement and write different contents according to the needs of the subclass
