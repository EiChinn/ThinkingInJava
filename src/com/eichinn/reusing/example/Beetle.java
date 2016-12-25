package com.eichinn.reusing.example;

/**
 * Created by ei_chinn on 2016/12/19.
 * 1、static成员变量是否也是先赋默认值，然后才初始化的？（是）
 * 顺序是不是先赋默认值给static成员变量，然后继续向下扫描处理static成员变量和static方法？（变量（包括static和非static）定义的先后顺序决定了初始化的先后顺序，
 * 即使变量定义散布于方法定义之间，他们仍旧会在任何方法（包括构造方法）被调用之前得到初始化。）
 * 2、static成员变量的初始化和static{}里面的语句是不是按照声明顺序执行？（是）
 * 3、非static成员变量是否和static成员变量在类加载时赋默认值？（不是，static成员变量的默认初始化是在类加载时，而非static成员变量的默认初始化是在创建对象时：
 * 当用new 创建对象时，首先在堆上为该对象分配足够的存储空间，然后这块存储空间会被清零，这就自动的将对象中的所有基本类型数据都设成了默认值，而应用则被设成了null）
 * 4、非static成员变量的初始化和{}里面的语句是不是按照声明顺序执行 （是）
 * 5、本身的非static变量赋默认值还在调用父构造方法之前？（是，所有的变量都会在任何方法（包括构造方法）被调用之前得到初始化）
 *
 */
//2、加载过程中发现Beetle类具有父类Insect，加载Insect类
public class Beetle extends Insect{
    //12、父类构造方法执行完毕后，按照声明顺序进行本身的非static初始化
    {
        System.out.println("non-static block1");
    }
    private int k = printInit("Beetle.k initialized");
    {
        System.out.println("non-static block2");
    }
    //8、执行本身的构造方法前先调用父类的构造方法
    //13、本身的非static初始化结束才执行本身的构造方法
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    static {
        System.out.println("static block 1");
    }

    //5、父类Insect的static初始化完毕后，进行本身的static初始化
    private static int x2 = printInit("static Beetle.x2 initialized");

    static {
        System.out.println("static block 2");
    }

    //1、main方法是入口，Beetle类加载
    public static void main(String[] args) {
        //6、本身的static初始化完毕后，执行main方法
        System.out.println("Beetle constructor");
        //7、要创建对象，先调用构造方法
        Beetle beetle = new Beetle();
        System.out.println("-----------第二次创建对象无static语句输出，证明类只加载一次----------");
        Beetle beetle1 = new Beetle();//无static语句输出，证明类只加载一次
    }


}

//3、如果Object类没有被加载，这里应该继续加载父类Object，并进行static初始化
class Insect{
    //10、父类的构造方法执行完毕后，按声明顺序进行非static初始化
    private int i = 9;
    protected int j;
    //9、执行本身的构造方法前先调用父类（即Object）的构造方法，并进行Object类的非static初始化
    //11、本身非static初始化结束后才执行本身的构造方法
    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    //4、父类Object的static初始化完毕后，进行本身的static初始化
    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}
