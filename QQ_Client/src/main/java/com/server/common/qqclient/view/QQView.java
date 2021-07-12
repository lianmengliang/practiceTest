package com.server.common.qqclient.view;

import com.example.utils.InputControlUtil;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:29
 * @Desc:
 * 客户端的菜单界面
 */
public class QQView {
    /**
     *控制是否展示
     */
    private boolean loop = true ;
    /**
     *
     */
    private String key = "";

    /**
     * 主菜单展示
     */
    private void mainMenu(){
        while (loop){
            // 显示一级菜单
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的数字：");

            key = InputControlUtil.readString(1);

            //根据用户的输入内容，来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户ID：");
                    String userId = InputControlUtil.readString(50);
                    System.out.print("请输入用户密码：");
                    String pwd = InputControlUtil.readString(50);
                    // 这里需要构建用户对象，并且验证用户是否合法
                    // ...................

                    //假如 合法
                    if (true){
                        //显示二级菜单
                        System.out.println("=============网络通信系统二级菜单（用户"+userId+"+"+"）=============");
                        System.out.println("\t\t 1 登录系统");
                        System.out.println("\t\t 9 退出系统");
                        System.out.print("请输入你的数字：");
                    }else{

                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }


    /**
     * 主方法 测试
     * @param args
     */
    public static void main(String[] args) {
        new QQView().mainMenu();
    }

}
