package demo08.ConstructorMethodReference;
/*
    类的构造器(类的构造方法)的引用
 */
public class Demo {
    //定义一个方法,参数传递姓名和PersonBuilder接口,方法中通过姓名创建Person对象
    public static void printName(String name, PersonBuiler pb) {
        Person person = pb.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        //调用printName方法,方法的参数PersonBuilder是一个函数式接口,可以传递Lambda表达式
       /* printName("迪丽热巴",(name)->{
            return new Person(name);
        });*/
       /*
         使用方法引用优化Lambda表达式
         构造方法new Person(String name)已知
         创建对象已知 new
         就可使用Person引用new
        */
        printName("迪丽热巴",Person::new);//因为有参数传递进来,所以调用Person的带参构造方法
    }
}
