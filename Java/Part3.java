import java.util.ArrayList;

//面向对象的程序设计
//3.1 类的封装(encapsulation)
class Time {
    public int hour; //0-23
    public int minute; //0-59
    public int second; //0-59
    public String toString(){
    {
        return (hour + ":" +
                (minute < 10 ? "0" : "") + minute + ":" +
                (second < 10 ? "0" : "") + second );
    }
}
    public static void main(String[] args){
        Time mytime=new Time();
        mytime.hour=200;
        mytime.minute=210;
    }
}

 class Time2 {
    private int hour; //0-23
    private int minute; //0-59
    private int second; //0-59
    public Time2( ) { setTime(0,0,0); }
    public void setTime(int hh, int mm, int ss) {
        hour = ((hh >= 0 && hh <24) ? hh : 0);
        minute = ((mm >= 0 && mm < 60) ? mm : 0);
        second = ((ss >= 0 && ss < 60) ? ss : 0);
    }
    public String toString( )
    {
        return (hour + ":" +
                (minute < 10 ? "0" : "") + minute + ":" +
                (second < 10 ? "0" : "") + second );
    }
}

//引入外部的类 这里不分文件，所以就import将注释掉了
//import Time;
class MyTime
{
    public static void main(String args[])
    {
        Time2 time=new Time2();
        time.setTime(11,22,33);
        System.out.println("获取的时间=" + time.toString());
    }
}


//根据上面的这些代码，我们可以看出当public和private方法同时存在时，要注意private定义的变量，如果想要进行调用时，最好使用Getter和Setter方法
//比如像idea一样，在代码->Generate中可以生成Getter和Setter方法，非常的好用！！！！


//3.1.2 类的构造方法
//构造方法的作用是初始化对象，构造方法的名字必须和类名相同，构造方法没有返回值，也不能定义void类型，构造方法可以重载，但是不能重写
class Time3 {
    private int hour; //0-23
    private int minute; //0-59
    private int second; //0-59

    public Time3() {//缺省构造方法
        hour = 0;
        minute = 0;
        second = 0;
    } //如果不定义则初始化能否调用

    public Time3(int hh, int mm, int ss) {//加入参数的构造方法
        hour = hh;
        minute = mm;
        second = ss;
    }

    public Time3(int hh) {//加入参数的构造方法2
        hour = hh;
        minute = 0;
        second = 0;
    }
}

//Static 静态函数和变量的定义 ： 分配的地址是固定不变的，不会随着对象的不同而不同
//Static的变量或方法在程序初始化之前分配空间，而其他的变量或方法在程序运行中动态的分配空间。
//public static void main(String[] args)是一个静态方法，因为它是程序的入口，它在程序运行之前就已经存在了。
//虚拟机需要找到整个程序的入口点。如果因为main所在的class没有生成对象，导致main无效,那程序就无法启动了。

//判断Static的方法和变量是否属于某个对象的样例代码，表明i变量可以被所有的对象所公用，并且可以被所有的对象修改
class StaticClass{
    static int i=100;
    int j=20;
}
class StaticTest{
    public static void main(String[] args) {
        StaticClass sc1=new StaticClass();
        StaticClass sc2=new StaticClass();
        System.out.println("sc1.i="+sc1.i+";\nsc1.j="+sc1.j);
        System.out.println("sc2.i="+sc2.i+";\nsc2.j="+sc2.j);
        sc2.i++;
        sc2.j++;
        System.out.println("sc1.i="+sc1.i+";\nsc1.j="+sc1.j);
        System.out.println("sc2.i="+sc2.i+";\nsc2.j="+sc2.j);
    }
}


//TimeTest.java

class TimeTest1
{
    Time mytime=new Time();
}
//SET CLASSPATH=.;c:\jdk1.3\lib\tools.jar;c:\myjava
//TimeTest.java
//import testpkg.Time;
class TimeTest3
{
    Time mytime=new Time();
}

//this和cpp里面差不太多，就是指向当前的对象的变量
class Time4 {
    private int hour; //0-23
    private int minute; //0-59
    private int second; //0-59

    public Time4() {
        setTime(0, 0, 0);
    }

    private void setTime(int i, int i1, int i2) {
    }


    public Time4(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}

//Wrapper Classes包装类
//基本数据类型它们不是类，所以它们也没有对应的方法和变量，也就没有各种各样的功能。更主要的一点，在一些场景当中，我们是不能使用基本数据类型只能使用对象的。比如一些容器，像是ArrayList、HashMap只能接受一个对象，再比如我们提供了一个方法，但是调用方有可能传入一个空值。如果我们使用基本数据类型，null会引发报错。
//所以包装类正是为了解决这个问题而产生的。
//其实说穿了很简单，这八种基本数据类型都有对应的包装类，名称差不多，略有差别：
//Short, Integer, Long, Float, Double, Character, Byte, Boolean。
//除了char与int变成了Character与Integer之外，其他的都一样，只是首字母换成了大写。
//包装类和一般的类有些不太一样，稍微有些特殊，最特殊的地方就在于他们初始化的时候，既可以使用类的形式通过new来创建实例，也可以像是它们的基本数据类型那样，直接赋值：
//这两种方法都是可以的，不过IDE推荐使用第一种。


class SwitchWrapperTest {
    public static void main(String[] args) {
        Integer a = 10;
        switch (a) {
            case 1:
                System.out.println("print 1");
                break;
            case 10:
                System.out.println("print 10");
        }
    }
}
//运行证明，确实可以认为a被正确赋值为10，switch支持Wrapper Class

//支持的Wrapper Class类型
// char、byte、short、int
// Character、Byte、Short、Integer
// String

// 不支持Double、Float、Long、Boolean
//switch语句最终会被编译为tableswitch和lookupswitch两个指令，这两个指令只支持int类型的数据。因此，long、double、float这三种类型无法转换为int，所以不能用在switch中。
//boolean类型的数据只有两个可能的值，true和false，用switch语句来处理它们没有必要，直接用if-else语句就可以了。
//float和double类型的数据在表示上有一定的不精确性，如果用它们来做精确的比较，可能会出现意想不到的结果2。例如，1.1这个数值在float和double中都不能精确地表示，所以用它们来做case条件可能会导致匹配失败。


class SwitchWrapperTest2 {
    public static void main(String[] args) {
        switch (getInt( )) {
            case 1:
                System.out.println("print 1");
                break;
        }
    }
    static Integer getInt(){
        return null;
    }
}//Exception in thread "main" java.lang.NullPointerException

class Singleton {
    private static Singleton instance;
    private static Object Lock = new Object(); private Singleton() { }
    public static Singleton getInstance() {
        if (instance == null) {
            synthorized(Lock);
            {

                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    private static void synthorized(Object lock) {
    }
}
//这段代码是用Java语言实现的双重检查锁（double checked locking）模式，用于创建一个单例（singleton）类的对象。单例类是一种只能有一个实例的类，通常用于全局资源的管理。双重检查锁的目的是在多线程环境下，保证单例对象的唯一性和线程安全性，同时避免每次调用getInstance()方法时都进行同步，提高性能。具体来说，这段代码的逻辑如下：
//
//定义一个静态变量instance，用于存储单例对象的引用。
//定义一个静态变量Lock，用于作为同步锁的对象。
//定义一个私有的构造方法，防止外部通过new关键字创建对象。
//定义一个公共的静态方法getInstance()，用于获取单例对象。
//在getInstance()方法中，先判断instance是否为null，如果为null，说明还没有创建对象，需要进入同步块。
//在同步块中，再次判断instance是否为null，如果为null，说明确实没有创建对象，需要调用构造方法创建一个新的对象，并赋值给instance变量。
//如果instance不为null，说明已经有对象被创建，直接返回instance变量即可。




//3.2 类的继承(inheritance)


//最基础的类的定义
class Date{}
class Employee {
    public String name = "";
    public double salary;
    public Date birthDate;

    public String getDetails() {
        return null;
    }
}
class Manager {
    public String name = "";
    public double salary;
    public Date birthDate;
    public String department;
    public String getDetails(){
        return null;
    };

}

//继承方法的类的定义
class Employee1 {
    public String name = "";
    public double salary;
    public Date birthDate;
    public String getDetails(){
        return null;
    };
}
class Manager1 extends Employee1
{
    public String department = "";
}

//测试私有成员 ，构造函数 ，protected变量是否能被继承
class ClassClass{
    private int i;
    private void f(){System.out.println("hi"+i);}
    public ClassClass(int i){ setI(i); }
    public ClassClass(){  }
    public int getI(){ return i; }
    public void setI(int i){ this.i=i; }
}
class PrivateTest extends ClassClass{
    public PrivateTest(int i){
//        setI(i); //?
//        f(); this.i=i; //?
    }
    public static void main(String[] args) {
//        PrivateTest pt=new PrivateTest(100);
//        pt.i=10; pt.f(); //?
//        pt.setI(10); //?
//        System.out.println(pt.getI()); //?
    }
}// f()报错，证明私有函数无法被继承
//this.i报错，证明私有变量无法被继承
//PrivateTest报错，证明构造函数无法被继承，但是填了空的构造函数后，又可以使用了，有点晕

//父类的构造方法不能被继承。
//父类的private成员变量和成员方法不能
//被子类继承。(实际上是无法直接访问）
//注意pt.setI(10); 这句话
//protected成员可以被子类访问。
//super表示“父类的”

class ClassClass1{
    protected int i;
    protected void f(){System.out.println("hi"+i);}
    public ClassClass1(int i){ setI(i); }
    public int getI(){ return i; }
    public void setI(int i){ this.i=i; }
}
class PrivateTest1 extends ClassClass1{
    public PrivateTest1(int i){
        super(i);
        setI(i); //protected 所以可以用了
        f(); this.i=i; //?
    }
    public static void main(String[] args) {
        PrivateTest1 pt=new PrivateTest1(100);
        pt.i=10; //?
        pt.f(); //?
        pt.setI(10); //?
    }
}
//上例可以看出，protected成员可以“显式”的继承。而private成员只能被“隐式”继承。
//super(i);可以继承父类的构造函数，实现构造方法

class Employee2 {
    protected String name;
    protected double salary;
    protected Date birthDate;
    public String getDetails() {
        return "Name:"+ name +"\n "+"Salary: " + salary;
    }
}
class Manager2 extends Employee2 {
    protected String department;
    public String getDetails() {
        return "Name:"+ name +"\n "+"Salary: " + salary + "\n"
                +"Manager of:"+ department;
    }
}
//讲人话：儿子不仅可以继承爹，还能创造一个和爹的函数一样名字的函数，优先级比继承到的函数优先级要高

class Equals
{
    public static void main(String[] args)
    {
        Integer n1=new Integer(100);
        Integer n2=new Integer(100);
        System.out.println(n1==n2);
        System.out.println(n1.equals(n2));
    }
}
//通常”==“比较类的时候，都是比较类的地址，即使两个类的value都相同，但他们地址不同，所以双等于号无效
//是不是很眼熟，关于死去的cpp指针知识又突然攻击我这件事


class Integer2{
    private int i;
    public Integer2(int i){
        this.i=i;
    }
}
class Equals2
{
    public static void main(String[] args)
    {
        Integer2 n1=new Integer2(100);
        Integer2 n2=new Integer2(100);
        System.out.println(n1==n2);
        System.out.println(n1.equals(n2));
    }
}
//equals（）方法的默认行为是比较对象的句柄.
// 如果是自定义的类,需要override equals()方法.


class ToStringClass{
    int i;
    public String toString(){
        return "i="+i;
    }
}
class ToStringTest{
    public static void main(String[] args) {
        ToStringClass tsc=new ToStringClass();
        tsc.i=100;
        System.out.println(tsc.i);
        System.out.println(tsc.toString());
        System.out.println(tsc);
    }
}
//100
//i=100
//i=100
//可以多搞一些类的成员变量，这样理解的更清楚
class ToStringClass1{
    int i;
    String s;
    ArrayList<Integer> al=new ArrayList<Integer>();
//    public String toString(){
//        return "i="+i+" s="+s+" al="+al;
//    }
}
class ToStringTest1{
    public static void main(String[] args) {
        ToStringClass1 tsc=new ToStringClass1();
        tsc.i=100;
        tsc.s="hello";
        tsc.al.add(100);
        tsc.al.add(200);
        System.out.println(tsc.i);
        System.out.println(tsc.s);
        System.out.println(tsc.al);
        System.out.println(tsc);
    }
}
//100
//hello
//[100, 200]
//ToStringClass1@1b6d3586
//可以看出，如果没有重写toString()方法，那么输出的是类的地址

class FinalClassTest
{
    private final static int a = 0;
    private final int b=0;//必须给初始值，不然报错，不知道为啥老师那PPT没有给初始值
    private final int c=0;
}
//FinalTest.java
class FinalTest{
    static class Integer1 {
        public static int i=10;
        public final static int j=20;
    }
    private final static Integer1 a = new Integer1();
    public static void main(String[] args){
        a.i = 100;
        a.i = 200;
//        a.j = 300;
//        a.j = 400;
        System.out.println(a.i);
    }
}
//100
//final修饰的变量，只能被赋值一次，但是可以被修改
//final修饰的类，不能被继承
//final修饰的方法，不能被重写
//final修饰的变量，必须在定义时或者构造函数中初始化
//你会发现a.i还是可以被无限赋值，但是a.j只能被赋值一次，这是因为final修饰的变量，只能被赋值一次，但是可以被修改
//这和a是不是final没有关系

class Season{
    public static final int SPRING=0;
    public static final int SUMMER=1;
    public static final int AUTUMN=2;
    public static final int WINTER=3;
    private int season;
    public Season(int season){
        if(season<0||season>3){
            throw new IllegalArgumentException("season should be 0-3");
        }
        this.season=season;
    }
}



class TestSeason {
    public static void main(String[] args) {
        Season spring=new Season(Season.SPRING);
        Season wrong=new Season(100);
    }
}
//上面是int enum is not type-safe
//Exception in thread "main" java.lang.IllegalArgumentException: season should be 0-3


class Season2 {
    private final String name;
    private Season2(String name) {
        this.name = name;
    }
    public static final Season2 SPRING = new Season2("spring");
    public static final Season2 SUMMER = new Season2("summer");
    public static final Season2 AUTUMN = new Season2("autumn");
    public static final Season2 WINTER = new Season2("winter");
}
//上面是String enum is type-safe




//3.3 类的多态(polymorphism)

//一个类可以继承另一个类的特征和行为，从而拥有更多的功能和灵活性。
// 例如，Manager类是Employee类的子类，它可以使用Employee类中定义的方法，
// 比如计算工资、打卡等。但是，Manager类也有自己的方法，比如分配任务、评估绩效等。
// 这样，Manager类就具有了多种形式，既是一个员工，又是一个管理者。
// • 一个对象只有一种形式，就是它所属的类。例如，一个Manager对象就是一个Manager类的实例，
// 它不能变成其他类的对象。
// • 一个引用变量可以指向不同形式的对象，只要它们之间有继承关系。
// 例如，Employee类型的变量可以指向Employee对象或Manager对象，
// 因为Manager是Employee的子类。但是，Manager类型的变量不能指向Employee对象，
// 因为Employee不是Manager的子类。

class Polymorphism{
    void Polymorphism(){
        Employee3 employee3 = new Manager3(); //legal //因为Manager3是Employee3的子类
// Illegal attempt to assign Manager attribute
//        employee3.department = "Sales"; //无法使用department属性，因为employee3是Employee3类型的,本身没有属性department
// the variable is declared as a Employee type,
// even though the Manager object has that attribute
    }


    public TaxRate findTaxRate(Employee3 e) {
        return null;
    }
    // Meanwhile, elsewhere in the application class
    Manager3 m = new Manager3();
    TaxRate t = findTaxRate(m);//这里可以使用的原因是：Manager3是Employee3的子类，所以本身Manager3也是Employee3的一种，传给函数的参数是Employee3类型的，所以可以传Manager3类型的


}
//创建Employee和Manager，要求Manager继承Employee类
//Employee类中有属性：name，salary，hireDay
//Manager类中有属性：name，salary，hireDay，department
class Employee3{
    String name;
    double salary;
    String hireDay;
}
class Manager3 extends Employee3{
    String department;
}
class TaxRate{
    double taxRate;
}

//Homogenous Collections 同类集合，就像下面这些代码一样，只能保存相同的类的对象
//MyDate[] dates = new MyDate[2];
//dates[0] = new MyDate(22, 12, 1964);
//dates[1] = new MyDate(22, 7, 1964); Northeastern University

//Heterogeneous Collections 异类集合，就像下面这些代码一样，可以保存不同类的对象
//Employee [] staff = new Employee[1024];
//staff[0] = new Manager();
//staff[1] = new Employee();
//staff[2] = new Engineer();
//原理应该和上面的多态一样，只是这里是数组，上面是变量

//主要体现：方法的override
//对多态的利用:上溯造型（Upcasting）
//①典型的upcasting。
//②进行upcasting的原因。
//③upcasting的实例。


//向上转型是指将子类类型的对象赋值给父类类型的变量，
// 从而实现多态（polymorphism）。多态是指同一个变量或方法可以根据不同的对象类型而表现出不同的行为。
// 向上转型的优点是可以提高代码的复用性和灵活性，使得父类类型的变量或方法可以接受任何子类类型的对象作为参数或返回值。
// 向上转型的缺点是会丢失子类类型的特有功能，只能使用父类类型中定义的功能。

//Upcastingtest.java
class Upper{
    public void f(){System.out.println("Upper.f()");}
}
class Down extends Upper{
    public void f(){System.out.println("Down.f()");}
}
class Upcastingtest{
    public static void Doit(Upper u){ u.f(); }
    public static void main(String[] args) {
        Down down=new Down();
        Doit(down);
    }
}//Down.f()
//上面的例子中，Doit方法的参数是Upper类型的，但是传入的是Down类型的，这就是向上转型

class Upper2{
    public void f(){System.out.println("Upper.f()");}
}
class Down2 extends Upper2{
    public void f(){System.out.println("Down.f()");}
}
class Upcastingtest2{
    public static void Doit(Down2 d){ d.f(); }
    public static void main(String[] args) {
        Down2 down2=new Down2();
        Doit(down2);
    }
}//Down.f()
//上面的例子中，Doit方法的参数是Down2类型的，传入的也是Down2类型的，这就是正常的调用

class Upper3{
    public void f(){System.out.println("Upper.f()");}
}
class Down3 extends Upper3{
    public void f(){System.out.println("Down.f()");}
}
class Down13 extends Upper3{
    public void f(){System.out.println("Down1.f()");}
}
class Down23 extends Upper3{
    public void f(){System.out.println("Down2.f()");}
}
class Upcastingtest3{
    public static void Doit(Down3 d){ d.f(); }
    public static void main(String[] args) {
        Down3 down3=new Down3();
        Doit(down3);
    }
}//Down.f()
//上面的例子中，Doit方法的参数是Down3类型的，传入的是Down3类型的，这就是正常的调用

class Upper4{
    public void f(){System.out.println("Upper.f()");}
}
class Down4 extends Upper4{
    public void f(){System.out.println("Down.f()");}
}
class Down14 extends Upper4{
    public void f(){System.out.println("Down1.f()");}
}
class Down24 extends Upper4{
    public void f(){System.out.println("Down2.f()");}
}
class Upcastingtest4{
    public static void Doit(Upper4 u){ u.f(); }
    public static void main(String[] args) {
        Down4 down4=new Down4();
        Doit(down4);}




}//Down.f()
//这块应该老师还要额外再拿其他的例子来说明，这里的Down4是Upper4的子类，但是传入的是Down4类型的，这就是向上转型

//public void doSomething(Employee e) {
//        if (e instanceof Manager) {
//// Process a Manager
//        } else if (e instanceof Engineer) {
//// Process an Engineer
//        } else {
//// Process any other type of Employee
//        }
//    }
//这里的instanceof是用来判断一个对象是否是一个类的实例，或者是这个类的子类的实例
//这里的e是Employee类型的，但是传入的是Manager类型的，所以e instanceof Manager是true

//public void doSomething(Employee e) {
//        if(e instanceof Manager){
//            Manager m=(Manager)e;
//            System.out.println("This is the manager
//                    of"+m.getDepartment());
//        }
////rest of operation
//    }

//该方法接受一个Employee类型的参数e。该方法的功能是判断参数e是否是Manager类型的对象，如果是，就将e强制转换为Manager类型，并打印出该经理所管理的部门的名称。如果不是，就不执行任何操作。



//3.4 抽象类，内部类，接口
//3.5 例外处理(exception)
//3.6 面向对象的综合应用：克隆
