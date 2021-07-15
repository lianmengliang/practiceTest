package com.server.qqclient.service;

import com.server.common.Message;
import com.server.common.MessageType;
import com.server.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/15 17:31
 * @Desc: 完成用户的验证和注册等功能
 */
public class UserClientService {
    /**
     * 属性：
     * 因为我们可能在其他地方使用到user信息，因此作为作为成员属性
     */
    private User user = new User();

    /**
     * 
     */
    private Socket socket;

    /**
     * 验证用户是否合法
     * @param userId
     * @param pwd
     * @return
     */
    public boolean checkUser(String userId,String pwd){
        boolean variable = false;

        //创建User对象
        user.setUserId(userId);
        user.setPasswoed(pwd);

        // 连接服务器，发送user对象
        try{
            socket= new Socket(InetAddress.getByName("127.0.0.1"),9999);
            // 得到Object的 OutputStream的对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            // 判断是否登录成功
            if (ms.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){

                // 创建一个服务器端保持通信的线程 -> 创建一个类 ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                // 启动客户端的线程
                ccst.start();
                // 为了后面客户端的扩展，我们将线程放入集合管理
                ManagerClientConnectServerThread.addClientConnectServerThreadToMap(userId,ccst);
                variable = true;
            }else {
                // 如果登录失败，不能启动和服务器通信的线程，关闭Socket
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return variable;
    }
}
