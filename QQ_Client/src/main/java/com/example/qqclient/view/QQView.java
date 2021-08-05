package com.example.qqclient.view;

import com.example.qqclient.service.FileClientService;
import com.example.qqclient.service.MessageClientService;
import com.example.qqclient.service.UserClientService;
import com.example.utils.InputControlUtil;

import java.io.File;
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
    /**
     * 提供和消息相关的服务
     */
    private MessageClientService messageClientService = new MessageClientService();

    /**
     * 发送文件的服务
     */
    private FileClientService fileClientService = new FileClientService();

    /*** 主菜单展示*/
    private void mainMenu() throws IOException {
        while (loop) {
            // 显示一级菜单
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 2 注册系统");
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
                    if (userClientService.signInOrResgister(userId, pwd, 1)) {
                        //显示二级菜单
                        System.out.println("=============欢迎（用户-" + userId + "-登录成功）=============");
                        //获取离线消息
                        messageClientService.getOfflineMessage(userId);
                        while (loop) {
                            System.out.println("=============网络通信系统二级菜单（用户" + userId + "）=============");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 5 发送离线消息/文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = InputControlUtil.readString(1);
                            switch (key) {
                                case "1":
                                    // 获取在线用户列表
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入群发的消息:");
                                    String massMessasge = InputControlUtil.readString(100);
                                    messageClientService.sendMessageToAll(userId, massMessasge);
                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户id(在线):");
                                    String getter = InputControlUtil.readString(50);
                                    System.out.println("请输入想说的话:");
                                    String contentToOne = InputControlUtil.readString(100);
                                    messageClientService.sendMessageToOne(userId, contentToOne, getter);
                                    break;
                                case "4":
                                    System.out.println("请输入接收文件的用户id(在线):");
                                    getter = InputControlUtil.readString(50);

                                    System.out.println("请输入发送文件的路径(格式:d:\\xx.jpg)");
                                    String src = InputControlUtil.readString(100);
                                    File file = new File(src);
                                    while (!file.isFile()) {
                                        System.out.println("该文件不存在！！！");
                                        System.out.println("请重新输入发送文件的路径(格式:d:\\xx.jpg):");
                                        src = InputControlUtil.readString(100);
                                        file = new File(src);
                                    }
                                    System.out.println("请输入接收文件的路径(格式:d:\\xx.jpg)");
                                    String dest = InputControlUtil.readString(100);
                                    fileClientService.sendOnlineOrOfflineFileToOne(userId,src, null,getter,1);
                                    break;
                                case "5":
                                    System.out.println("请输入接收离线消息/文件的用户id(离线):");
                                    getter = InputControlUtil.readString(50);
                                    while (true){
                                        System.out.println("请输入文件发送的类型：1-消息，2-文件");
                                        String type = InputControlUtil.readString(1);
                                        if (type.equals("1")){
                                            System.out.println("请输入想留言的话:");
                                            String offlineMessage = InputControlUtil.readString(100);
                                            messageClientService.sendOfflineMessageToOne(userId,offlineMessage,getter);
                                            break;
                                        }else if (type.equals("2")){
                                            System.out.println("请输入离线文件的路径(格式:d:\\xx.jpg)");
                                            src = InputControlUtil.readString(100);
                                            System.out.println("请输入接收离线文件的路径(格式:d:\\xx.jpg)");
                                            dest = InputControlUtil.readString(100);
                                            fileClientService.sendOnlineOrOfflineFileToOne(userId,src,dest,getter,0);
                                            break;
                                        }else {
                                            System.out.println("输入数字有误，请重新输入");
                                        }
                                    }
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
                case "2":
                    //注册新用户 逻辑
                    System.out.print("请输入新用户ID：");
                    String newUserId = InputControlUtil.readString(50);
                    System.out.print("请输入新用户密码：");
                    String newPwd = InputControlUtil.readString(50);
                    if (userClientService.signInOrResgister(newUserId, newPwd, 2)) {
                        System.out.println("=======>注册成功<======");
                    } else {
                        System.out.println("=======>注册失败<======");
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
