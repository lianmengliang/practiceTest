package com.example.test.DesignPatterns.ocp.improve;


/**
 * @Author ： Leo
 * @Date : 2021/3/17 14:46
 * @Desc:
 */
public class Ocp1 {
    public static void main(String[] args) {

        //
        GraphicEditor editor = new GraphicEditor();

        editor.drawShape(new Rectangle());
        editor.drawShape(new Circle());
        editor.drawShape(new Triangle());
        editor.drawShape(new OtherGraphic());
    }
}

//这是一个用于绘图的类 ---【使用方】
class GraphicEditor {
    //接收Shape对象，然后根据type，来绘制不同的图
    public void drawShape(Shape s) {
        s.draw();
    }
}

/**
 * 抽象类 抽象方法
 */
abstract class Shape {
    int m_type;

    abstract void draw();
}

class Rectangle extends Shape {

    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形。。。");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形。。。");
    }
}

// 新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形。。。");
    }
}

// 新增一个图形
class OtherGraphic extends Shape {

    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println("绘制其他图形。。。");
    }
}