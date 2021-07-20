package com.test.qqclient.view;

import com.example.utils.InputControlUtil;
import com.test.qqclient.service.UserClientService;

import java.io.IOException;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:29
 * @Desc: 客户端的菜单界面
 */
public class QQView {
    /**
     * 控制是否展示
     */
    private boolean loop = true;
    /**
     * 用户输入的内容
     */
    private String key = "";
    /**
     * 用于登录服务器
     */
    private UserClientService userClientService = new UserClientService();

    /*** 主菜单展示*/
    private void mainMenu() throws IOException {
        while (loop) {
            // 显示一级菜单
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的数字：");

            key = InputControlUtil.readString(1);

            //根据用户的输入内容，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户ID：");
                    String userId = InputControlUtil.readString(50);
                    System.out.print("请输入用户密码：");
                    String pwd = InputControlUtil.readString(50);
                    // 这里需要构建用户对象，并且验证用户是否合法
                    // 编写一个类UserClientService[用户登录验证]
                    // ...................

                    //假如 合法
                    if (userClientService.checkUser(userId, pwd)) {
                        //显示二级菜单
                        System.out.println("=============欢迎（用户-" + userId + "-登录成功）=============");

                        while (loop) {
                            System.out.println("=============网络通信系统二级菜单（用户" + userId + "）=============");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = InputControlUtil.readString(1);
                            switch (key) {
                                case "1":
                                    //这里写一个方法获取在线用户列表
//                                    System.out.println("显示在线用户列表");
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;

                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    // 调用一个方法，给服务器发送一个退出线程的message
                                    userClientService.logout();
                                    loop = false;
                                    System.out.println("退出系统...");
                                    break;
                            }
                        }
                    } else { // 登录服务器失败
                        System.out.println("======>登录失败<========");
                    }
                    break;
                case "9":
                    loop = false;
                    System.out.println("退出系统...");
                    break;
            }
        }
    }


    /**
     * 主方法 测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new QQView().mainMenu();
    }

}
