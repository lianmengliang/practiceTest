package com.example.test.DesignPatterns.inversion.expand;

import com.lowagie.text.pdf.PdfSmartCopy;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 18:46
 * @Desc: 依赖关系的三种方式
 * （也是依赖注入的三种方式）
 */
public class DependecyInversion3 {
    public static void main(String[] args) {

        TCL tcl = new TCL();

        // 1.通过接口 进行依赖传递
        /*OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(tcl);
*/
        // 2.通过构造器 进行依赖传递
        OpenAndClose openAndClose = new OpenAndClose(tcl);
        openAndClose.open();

        // 3.通过setter方法 进行依赖传递
        /*OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(tcl);
        openAndClose.open();*/
    }
}


/**
 * 方式1：
 *  * 通过接口传递实现依赖
 */
/*
interface IOpenAndClose{
    void open(ITV tv);
}

//实现接口
class OpenAndClose implements IOpenAndClose{
    @Override
    public void open(ITV tv) {
        tv.play();
    }
}

interface ITV{
    void play();
}

class TCL implements ITV{
    @Override
    public void play() {
        System.out.println("TCL王牌电视机，打开");
    }

}
*/
/**方式2：
 * 通过构造器进行依赖传递
 */

interface IOpenAndClose{
    void open();
}

//实现接口
class OpenAndClose implements IOpenAndClose{
    private ITV tv;

/**
 * 构造器
 * @param tv
 */
    public OpenAndClose(ITV tv){
        this.tv = tv;
    }

    @Override
    public void open() {
       tv.play();
    }
}

interface ITV{
    void play();
}

class TCL implements ITV{
    @Override
    public void play() {
        System.out.println("TCL王牌电视机，打开");
    }
}


/**方式 3：
 * 通过setter方法进行依赖传递
 */

/*
interface IOpenAndClose {

    void open();

    void setTv(ITV tv);
}

//实现接口
class OpenAndClose implements IOpenAndClose {
    private ITV tv;

    @Override
    public void setTv(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void open() {
        tv.play();
    }


}

interface ITV {
    void play();
}

class TCL implements ITV {
    @Override
    public void play() {
        System.out.println("TCL王牌电视机，打开");
    }
}
*/
