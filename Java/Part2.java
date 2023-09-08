import java.io.*;

//声明Car类，具有int类型的变量有color_number,door_number,speed,void返回数据类型的函数名有break(),speedUp(),slowDown,backward()
class Car{

    int color_number;
    int door_number;
    int speed;
    void break1(){
        System.out.println("break");
    }
    void speedUp(){
        System.out.println("speedUp");
    }
    void slowDown(){
        System.out.println("slowDown");
    }
    void backward(){
        System.out.println("backward");
    }
    ////数组声明
    int a1[]={1,2,3};
    int a2[][]={{1,3,5},{2,4,5}};
    int a3[]=new int[6];;
    double b[][]=new double[4][7];

    void systemArraycopy() {//数组复制
        //System.arraycopy() method来进行数组的复制
        int[] myArray = {1, 2, 3, 4, 5, 6};
        int[] hold = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //复制所有的myArray数组元素到hold数组中 从第0个元素开始复制
        System.arraycopy(myArray, 0, hold, 0, myArray.length);
    }

    ////字符与字符串声明
    char ch;
    Character character = 'a';
    String color = "red";
    String color2 = new String("black");

    //运算符双等于号 ’==‘作用是判断是否前后的两个内容相同
    //虽然但是，根据笔者的经验，双等于号对于对象的判断，是判断两个对象的地址是否相同，而不是内容是否相同
    //所以，对于对象的判断，应该使用equals()方法
    static void doubleEqual(){
        //PPT的原代码
        Integer a1=new Integer(100);
        Integer a2=new Integer(100);
        System.out.println(a1==a2);
        //笔者的代码，对于String类型的判断，双等于号和equals()方法的不同点
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);//true
        System.out.println(a == c);//false
        System.out.println(a.equals(b));//true
        System.out.println(a.equals(c));//true

        //PPT的原代码
        Integer a12=100;
        Integer a22=100;
        Integer a32=200;
        Integer a42=200;
        System.out.println(a12==a22);
        System.out.println(a32==a42);
    }

    //通过Integer的构造方法创建Integer对象时，并不会跟IntegerCache扯上关系，
    // 也就是说创建多少个都是新对象，比较的话都是false，因为他们的地址值都不一样；
    // parseInt方法返回的是int基本类型，所以跟IntegerCache也没有关系；
    // 我们再来看一下valueOf方法，在给定的IntegerCache的阈值范围内，
    // Integer对象都是从cache数组中取到的，而内部类都是懒加载，在使用时加载内部类，
    // 并且创建阈值之内的所有Integer对象并存入cache中，cache是静态常量数组，
    // 由常量池维护着，cache被所有的Integer对象共享，
    // 所以只要是比较cache阈值之内的两个Integer的结果都是true，
    // 因为本身他们就是同一个对象。(ps:Integer a = 1; 默认调用的是valueOf方法)。

    public  Integer valueOf(int i) {//想要运行这段代码，需要使用1.8版本以下，比如1.7的java版本，因为到了1.8版本后，就会发现，IntegerCache这个类已经北设置成了私有的，所以无法调用
//        if (i >= IntegerCache.low && i <= java.lang.Integer.IntegerCache.high)
//
//            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    //IntegerCache在类加载时缓存[-128, 127]之间的值，valueOf方法会尝试从缓存里取值，如果在这个范围内


    //字符串的创建
    String s1 = "hello";
    String s2 = "hello";
    String s3 = new String("hello");
    String s4 = new String("hello");
    //s1和s2是同一个对象，s3和s4是两个不同的对象

    //请使用if语句，实现样例“短路现象”
    static void shortCircuit(){
        int a = 1;
        int b = 2;
        if (a > 0 && b++ > 1) {
            System.out.println("a > 0 && b++ > 1");
        }
        System.out.println("a = " + a + ", b = " + b);
        //a = 1, b = 2
        //a > 0 && b++ > 1
    }

    //简单while语句 for语句 switch语句样例
    static void whileForSwitch(){
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }
        int k = 0;
        switch (k) {
            case 0:
                System.out.println("k = 0");
                break;
            case 1:
                System.out.println("k = 1");
                break;
            default:
                System.out.println("k = " + k);
        }
    }


    //简单break语句 continue语句样例
    static void breakContinue(){
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }
    }

    //简单return样例
    static int returnTest(){
        int i = 0;
        while (i < 10) {
            if (i == 5) {
                return i;
            }
            i++;
        }
        return i;
    }

    //简单throw语句和try语句样例
    static void throwTry(){
        try {
            throw new Exception("throw exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //简单synchroized语句样例
    static void synchroizedTest(){
        synchronized (Car.class) {
            System.out.println("synchronized");
        }
    }

    //Switch出现的问题
    static void SwicthProblem() {
        //当default在中间时,且看输出是什么？
        int a = 1;
        switch (a) {
            case 2:
                System.out.println("print 2");
            case 1:
                System.out.println("print 1");
            default:
                System.out.println("first default print");
            case 3:
                System.out.println("print 3");
        }


        //当switch括号内的变量为String类型的外部参数时,且看输出是什么？
        String param = null;//会提示报错：java.lang.NullPointerException
        switch (param) {
            case "param":
                System.out.println("print param");
                break;
            case "String":
                System.out.println("print String");
                break;
            case "null":
                System.out.println("print null");
                break;
            default:
                System.out.println("second default print");
        }
    }

    //Using the Enhanced for Loop 使用增强型for循环
    static void EnhancedForLoop(){

        String[] sa = {"one", "two", "three", "four"};

        for (int i = 0; i < sa.length; i++)//普通for循环
        {
            System.out.println(sa[i]);
        }

        for (String str : sa)//增强型for循环
        {
            System.out.println(str);
        }

    }

    //讨厌输入输出流，一个个的名字都贼长-_-
    //文件字符输入FileReader或者InputStreamReader对象
    static void FileReaderTest() throws IOException {
        //使用FileReader读取文件
        FileReader fr = new FileReader("src/test.txt");
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();

        //使用InputStreamReader读取文件
        FileInputStream fis = new FileInputStream("src/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        int ch1 = 0;
        while ((ch1 = isr.read()) != -1) {
            System.out.print((char) ch1);
        }
        isr.close();

        //InputStreamReader要与BufferedReader对象
        //的readLine()方法配合进行键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            System.out.println(line.toUpperCase());
        }
        br.close();


    }

    //字符串转换为其他的类型 主要格式就是当前那你想要转换的数据类型加上parseXXX，例外是parseBoolean
    static void StringToOther(){
        String s = "123";
        boolean b=new Boolean(s).booleanValue();
        int i=Integer.parseInt(s);
        long l=Long.parseLong(s);
        float f=Float.parseFloat(s);
        double d=Double.parseDouble(s);
    }

    //使用OutputStreamWriter对象写入文件，配合BufferedWriter对象
    static void OutputStreamWriterTest() throws IOException {
        //使用OutputStreamWriter写入文件
        FileOutputStream fos = new FileOutputStream("src/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("hello");
        osw.close();

        //使用BufferedWriter写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/test.txt"));
        bw.write("hello");
        bw.close();
    }


    //打印数据流 PrintStream和PrintWriter PrintStream是字节流，PrintWriter是字符流
    static void PrintStreamTest() throws IOException {
        //使用PrintStream打印数据
        PrintStream ps = new PrintStream("src/test.txt");
        ps.print("hello");
        ps.close();

        //使用PrintWriter打印数据
        PrintWriter pw = new PrintWriter(new FileWriter("src/test.txt"));
        pw.print("hello cxk");
        pw.close();
    }

    //取半函数CallByValue
    static void half(int n)
    {
        n = n / 2;
        System.out.println("n= " + n);
    }
    static void halfTest()
    {
        int m = Integer.parseInt(String.valueOf(10));
        System.out.println("调用half前 m= " + m);
        half(m);
        System.out.println("调用half后 m= " + m);
    }

    //数组内容加倍函数 CallByRef
    static String show(int b[]) {
        String result="";
        for (int i=0; i<b.length; i++)
            result=result+b[i]+" ";
        return result;
    }
    static void passArray(int c[]) {
        for (int i=0; i<c.length; i++) c[i] = c[i] * 2;
    }
    static void passArrayTest() {
        int a[] = {1, 2, 3};
        System.out.println("调用前: "+show(a));
        passArray(a);
        System.out.println("调用后: "+show(a));
    }


    //Overload重载 重载的方法必须有不同的参数列表
    static int square(int n){return n*n;}
    static double square (double x){return x*x;}
    static void squareTest(String[] args) {
        int n=Integer.parseInt(args[0]);
        double x=Double.parseDouble(args[1]);
        System.out.println(n+"*"+n+" = "+square(n));
                System.out.println(x+"*"+x+" = "+square(x));
    }

    //Logical – boolean
    //布尔数据类型有两个字面值true和false。例如，语句：boolean truth = true;声明变量truth为布尔类型，并将其赋值为true。
    //Textual – char and String
    //char • Represents a 16-bit Unicode character • Uses the following notations:'a' The letter a '\t' A tab 'u????' A specific Unicode character, ????, is replaced with exactly four  hexadecimaldigits(for example, ’\u03A6’ is the Greek letter phi Ф)
    //char类型的数据用单引号括起来，例如：char letter = 'A';声明变量letter为char类型，并将其赋值为A。
    //String类型的数据用双引号括起来，例如：String name = "John";声明变量name为String类型，并将其赋值为John。
    //Integral – byte, short, int, and long
    //二进制  十进制  十六进制
    //Floating Point – float and double
    //默认浮点数是double型，浮点数类型有两种：float和double。float类型的数据用f或F后缀表示，例如：float pi = 3.14f;声明变量pi为float类型，并将其赋值为3.14。


    //Ascii转int型
    static void AsciiToInt(){
        char symbol = '8';
        System.out.println((int) symbol);
    }



    public static void main(String[] args) throws IOException {
        //想要使用哪个函数，就可以写在这里，虽然但是有些函数，需要额外添加static
        //例如：FileReaderTest();
        passArrayTest();
    }
}

