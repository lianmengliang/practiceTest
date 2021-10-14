package com.example.test.designpatterns.adapter;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 16:34
 * @Desc:
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // 啥也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name:"+fileName);
    }
}
