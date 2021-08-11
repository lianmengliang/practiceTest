package com.example.test.interview;

/**
 * @Author ： Leo
 * @Date : 2021/8/11 12:26
 * @Desc: 关于String类型的面试题
 * String并不是基本数据类型，而是一个对象。字符串为对象，那么在初始化之前，它的值为null，到这里就有必要提下
 * ""、null、new String() 三者的区别。null 表示string还没有new ，也就是说对象的引用还没有创建，也没有分配内存空间* 给他，而 ""、new String()则说明了已经new了，只不过内部为空，但是它创建了对象的引用，是需要分配内存空间的。
 * <p>
 * java的虚拟机在内存中开辟出一块单独的区域，用来存储字符串对象，这块内存区域被称为字符串缓冲池
 * <p>
 * 对于三者使用的总结：
 * 1.如果要操作少量的数据用 String
 * 2.单线程操作字符串缓冲区 下操作大量数据  StringBuilder
 * 3.多线程操作字符串缓冲区 下操作大量数据  StringBuffer
 * <p>
 */
@SuppressWarnings("all")
public class StringInterview {


    /**
     * 对于空值的比较
     */
    public static void nullTest() {

        //1. null表示string还没有new,也就是说对象的引用还没有创建，也没有分配内存空间
        //2. ""、new String()则说明了已经new了，只不过内部为空，但是它创建了对象的引用，是需要分配内存空间的
        String a = "";
        String b = null;
        String c = new String();

        System.out.println("a==b :" + (a == b));  //false b对象的引用还没有创建，也没有分配内存空间
        System.out.println("a==c :" + (a == c));  //false a 和 c两个对象的内存地址不一致，而两个值是一样的
        System.out.println("b==c :" + (b == c));  //false b对象的引用还没有创建，也没有分配内存空间

        System.out.println("a.equals(b) :" + a.equals(b)); //false b对象的引用还没有创建，也没有分配内存空间
        System.out.println("a.equals(c) :" + a.equals(c)); //true  因为new String()的初始值引用的对象为"",源码：this.value = "".value;
        System.out.println("c.equals(b) :" + c.equals(b)); //false  b对象的引用还没有创建，也没有分配内存空间

    }

    /**
     * String对象的创建 和 创建几个对象
     */
    public static void strObject() {
        /**
         * 创建字符串的时候先查找字符串缓冲池中有没有相同的对象，
         * 如果有相同的对象就直接返回该对象的引用，如果没有相同的对象就在字符串缓冲池中创建该对象，然后将该对象的应用返回。
         * 对于这一步而言，缓冲池中没有abc这个字符串对象，所以首先创建一个字符串对象，然后将对象引用返回给a。
         */
        String a = "abc";   // 创建了 1 个对象
        /**
         * 想要创建一个对象引用变量b使其指向abc这一对象。
         * 这时，首先查找字符串缓冲池，发现abc这个对象已经有了，这是就直接将这个对象的引用返回给b，此时a和b就共用了一个对象abc，
         * 不过不用担心，a改变了字符串不会影响b，因为字符串都是常量，一旦创建就没办法修改了，除非创建一个新的对象
         */
        // 没有创建对象
        String b = "abc";

        /**
         * 查找字符串缓冲池发现没有xyz这个字符串对象，于是就在字符串缓冲池中创建了一个xyz对象然后再将引用返回。
         */
        // 创建了 2 个对象(首先在字符串缓冲池创建一个xyz的对象,其次在内存中(不是缓冲池中)又创建了一个新的字符串对象)
        String c = new String("xyz");

        /**
         * 从上边的分析可以看出，当new一个字符串时并不一定是创建了一个新的对象，有可能是与别的引用变量共同使用了同一个对象
         */
        // 创建了 1 个对象(字符串缓冲池中已有该xyz字符串对象,在内存中创建一个新的字符串对象)
        String d = new String("xyz");

        // 创建了 1 个对象, 由于常量的值在编译的时候就被确定,等价于 String e = "abcd"
        String e = "ab" + "cd";

        /**
         *1、String a = "abc"；这一句由于缓冲池中没有abc这个字符串对象，所以会创建一个对象；
         *
         *2、String b = "abc"；由于缓冲池中已经有了abc这个对象，所以不会再创建新的对象；
         *
         *3、String c = new String("xyz")；由于没有xyz这个字符串对象，所以会首先创建一个xyz的对象，
         *  然后这个字符串对象由作为String的构造方法，在内存中（不是缓冲池中）又创建了一个新的字符串对象，所以一共创建了两个对象；
         *
         *4、String d = new String("xyz")；缓冲池中已有该字符串对象，则缓冲池中不再创建该对象，
         *  然后会在内存中创建一个新的字符串对象，所以只创建了一个对象；
         *
         *5、String e = "ab" + "cd"；由于常量的值在编译的时候就被确定了。
         *  所以这一句等价于String e = "abcd";所以创建了一个对象；
         */
    }


    /**
     * String对象的比较
     * 1. equals()比较的是两个字符串的 “值” 是否相等，
     * 2. == 比较的是两个对象的 “内存地址” 是否相等
     */
    public static void strEquals() {

        /**
         * 第一组
         */
        String a1 = "Monday";   // 新创建 1 个对象
        String a2 = "Monday";   // 没有创建对象。因为该对象，字符串缓冲池中已经有了
        //打印
        System.out.println("a1==a2：" + (a1 == a2));   // true
        System.out.println("a1.equals(a2)：" + (a1.equals(a2))); //true


        /**
         *第二组
         */
        String b1 = "Sunday";
        String b2 = new String("Sunday");
        //打印
        System.out.println("b1==b2：" + (b1 == b2)); //false:两个对象的 “内存地址”
        System.out.println("b1.equals(b2：" + (b1.equals(b2))); //true:两个对象的值相等

        /**
         *第三组
         */
        String c1 = "Happy";
        String c2 = new String("Happy");
        c2 = c2.intern();

        System.out.println("c1==c2：" + (c1 == c2)); //true
        /*分析：
        先来说说intern()这个方法的作用是返回在字符串缓冲池中的对象的引用，
        所以c2指向的也是字符串缓冲池中的地址，和c1是相等的。
        */
        System.out.println("c1.equals(c2)：" + (c1.equals(c2))); //true: 值相等


        /**
         *第四组
         */
        String d1 = "DateTime";
        String d2 = "Date";
        String d3 = "Time";
        // 因为两者都是常量,相当于 "Happy" = "Ha"+"ppy"
        System.out.println("d1 == \"Date\" + \"Time\"：" + (d1 == "Date" + "Time"));  //true
        // 假如：d3变量被 fianl关键字修饰话， 下面比较即为 true （如第五组的例子）
        System.out.println("d1 == \"Date\" + d3：" + (d1 == "Date" + d3)); // false

        System.out.println("d1 == d1 + d3：" + (d1 == d1 + d3)); //false


        /**
         *第五组
         */
        String e1 = "Football";
        String e2 = "Foot";
        final String e3 = "ball";
        System.out.println("e1 == \"Foot\"+\"ball\"：" + (e1 == "Foot" + "ball")); // true

        // e3对象加上final后day也变成了常量
        System.out.println("e1 == \"Foot\"+e3：" + (e1 == "Foot" + e3)); // true

        System.out.println("e1 == (e2+e3)：" + (e1 == (e2 + e3))); // true


    }

    /**
     * 测试：StringBuild 和 StringBuffer的区别
     * <p>
     * StringBuilder类在Java 5中被提出,它和StringBuffer之间的最大不同在于 StringBuilder的方法不是线程安全的（不能同步访问）
     * 由于 StringBuilder相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
     * 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
     */
    public static void testStringBuildAndStringBuffer() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("builder");
        /**
         * StringBuilder的append()方法源码：
         * public StringBuilder append(String str) {
         *    super.append(str);
         *    return this;
         * }
         */

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("buffer");
        /**
         * StringBuffer的append()方法源码：
         * public synchronized StringBuffer append(String str) {
         *     toStringCache = null;
         *     super.append(str);
         *     return this;
         * }
         */
        /**
         *  * 对于三者使用的总结：
         *  * 1.如果要操作少量的数据用 String
         *  * 2.单线程操作字符串缓冲区 下操作大量数据  StringBuilder
         *  * 3.多线程操作字符串缓冲区 下操作大量数据  StringBuffer
         */
    }

    /**
     * 主方法：用于测试
     *
     * @param args
     */
    public static void main(String[] args) {

        strEquals();
    }
}
