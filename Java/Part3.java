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








//3.3 类的多态(polymorphism)
//3.4 抽象类，内部类，接口
//3.5 例外处理(exception)
//3.6 面向对象的综合应用：克隆
