package com.example.test.DesignPatterns.bridge;

import com.example.test.DesignPatterns.Adapter.MediaPlayer;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 15:45
 * @Desc:
 */
public interface Brand {

    void open();

    void close();

    void call();

}
