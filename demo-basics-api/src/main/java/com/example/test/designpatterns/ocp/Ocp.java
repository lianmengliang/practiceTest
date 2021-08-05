package com.example.test.designpatterns.ocp;

/**
 * @Author ： Leo
 * @Date : 2021/3/17 14:46
 * @Desc:
 */
public class Ocp {
    public static void main(String[] args) {

        //
        GraphicEditor editor = new GraphicEditor();

        editor.drawShape(new Rectangle());
        editor.drawShape(new Circle());
        editor.drawShape(new Triangle());

    }
}

//这是一个用于绘图的类 --- 【使用方】
class GraphicEditor {

    //接收Shape对象，然后根据type，来绘制不同的图

    public void drawShape(Shape s) {
        if (s.m_type==1){
            drawRectangle(s);
        }else if(s.m_type==2){
            drawCircle(s);
        }else if(s.m_type==3){
            drawTriangle(s);
        }else{
            System.out.println("啥都不画");
        }
    }

    private void drawRectangle(Shape s) {
        System.out.println("绘制矩形。。。");
    }

    private void drawCircle(Shape s) {
        System.out.println("绘制圆形。。。");
    }

    private void drawTriangle(Shape s) {
        System.out.println("绘制三角形。。。");
    }

}


class Shape {
    int m_type;
}

class Rectangle extends Shape {

    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}