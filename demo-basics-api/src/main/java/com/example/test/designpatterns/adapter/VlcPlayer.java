package com.example.test.designpatterns.adapter;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 16:33
 * @Desc:
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name:"+fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //啥也不做
    }
}
