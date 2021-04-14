package com.example.test.DesignPatterns.memento.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:47
 * @Desc: 游戏角色
 */
public class Memento {
    // 攻击力
    private int vit;

    // 防御力
    private int def;

    // 血量
    // private Long blood;

    public Memento(int vit, int def) {
        this.vit = vit;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}

