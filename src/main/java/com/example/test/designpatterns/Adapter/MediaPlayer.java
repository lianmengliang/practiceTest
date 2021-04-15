package com.example.test.designpatterns.Adapter;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 16:30
 * @Desc:
 */
public interface MediaPlayer {

    /**
     *
     * @param audioType
     * @param fileName
     */
    void play(String audioType, String fileName);
}
