class person{

    private int age;
    private String name;
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public person(String name,int age){
        this.age=age;
        this.name=name;

    }
}
public class Main {
    public static void main(String[] args) {
        // TODO: 给Person增加构造方法:
        person ming = new person("小明", 12);
        System.out.println(ming.getName());
        System.out.println(ming.getAge());
    }
}
