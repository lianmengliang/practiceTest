package com.example.test.DesignPatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:20
 * @Desc:
 */
public class HomeTheaterFacade {
    // 定义各个子系统的对象

    private TheaterLight light;

    private Popcorn popcorn;

    private Stereo stereo;

    private Projector projector;

    private Screen screen;

    private DVDPlayer player;

    /**
     * 构造器
     */
    public HomeTheaterFacade() {
        this.light = TheaterLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.player = DVDPlayer.getInstance();
    }

    public static void main(String[] args) {

    }

    // 操作分成4步

    // 准备阶段
    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        player.on();
        light.dim();
    }

    // 播放期间
    public void play(){
        player.play();
    }

    // 暂停
    public void pause(){
        player.pause();
    }

    // 观影结束
    public void end(){
        popcorn.off();
        light.bright();
        screen.up();
        projector.off();
        stereo.off();
        player.off();
    }

}
