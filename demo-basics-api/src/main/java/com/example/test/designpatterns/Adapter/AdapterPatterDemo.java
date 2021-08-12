package com.example.test.designpatterns.Adapter;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 16:44
 * @Desc:
 */
public class AdapterPatterDemo {

    public static void main(String[] args) {


        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
