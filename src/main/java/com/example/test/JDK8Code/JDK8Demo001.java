package com.example.test.JDK8Code;

import com.example.domain.User;
import com.rabbitmq.client.BlockedCallback;
import com.rabbitmq.client.UnblockedCallback;
import org.springframework.util.StopWatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.stream.Collectors;

/**
 * @Author ： Leo
 * @Date : 2020/8/11 17:49
 * @Desc:
 */
public class JDK8Demo001 {


    /**
     * 筛选 苹果
     * @param appleList
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> appleList){

// appleList.stream().forEach(Apple ->Apple.getColor().equals("green") && Apple.getWeight()>150);

        return appleList.stream().filter(apple -> apple.getWeight() > 150 && apple.getColor().equals("green")).collect(Collectors.toList());

    }

    public static void Demo001(){

      new ImplClass() {
            @Override
            public List<String> getListResult() {

                return null;
            }
        };

      // lambda 表达式
      new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("button clicked");
            }
        };

        Consumer<ActionEvent> button_clicked = (ActionEvent event) -> System.out.println("button clicked");

        /**
         * 所示的 Lambda 表达式不包含参数，
         * 使用空括号 () 表示没有参数。
         * 该 Lambda 表达式 实现了 Runnable 接口，
         * 该接口也只有一个 run 方法，没有参数，且返回类型为 void
         */
        Runnable run = () -> System.out.println("hello java");

        /**
         * -> 将参数和 Lambda 表达式 的主体分开，而主体是用户点击按钮时会运行的一些代码。
         */
        ActionListener listener =  event -> System.out.println("button clicked");


        /**
         * Lambda 表达式的主体不仅可以是一个表达式，而且也可以是一段代码块，
         * 使用大括号 （{}）将代码块括起来，如➌所示。
         * 该代码块和普通方法遵循的规则别无二致，可以用返 回或抛出异常来退出。
         * 只有一行代码的 Lambda 表达式也可使用大括号，
         * 用以明确 Lambda 表达式从何处开始、到哪里结束
         */
        UnblockedCallback unblockedCallback = () -> {
            System.out.println("123");
            System.out.println("1456");
        };

        /**
         * Lambda 表达式也可以表示包含多个参数的方法，
         * 这时就有必要思考怎样去阅 读该 Lambda 表达式。
         * 这行代码并不是将两个数字相加，而是创建了一个函数，
         * 用来计算 两个数字相加的结果。变量 add 的类型是 BinaryOperator<Long>，
         * 它不是两个数字的和， 而是将两个数字相加的那行代码。
         */
        LongBinaryOperator comparator = (x, y) -> x + y;
//        BinaryOperator<Long> comparator1 = (x, y) -> x + y;

        /**
         * 到目前为止，
         * 所有 Lambda 表达式中的参数类型都是由编译器推断得出的。
         * 这当然不错， 但有时最好也可以显式声明参数类型，
         * 此时就需要使用小括号将参数括起来，多个参数的 情况也是如此。
         */
        BinaryOperator<Long> comparator2 = (Long x, Long y) -> x + y;


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();



        stopWatch.stop();


    }


    public static  void getResult(){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < 1000; i++) {

            System.out.println("皮卡丘");
        }


        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());




        String deviceid = "123,456,789,125,126";

        String[] split = deviceid.split(",");

        List<User> userList = new ArrayList<>();
        for (String s : split) {
            User user = new User();
            user.setPassWord(s);
            userList.add(user);
        }


    }





    public static void main(String[] args) {
        getResult();
    }
}
