package com.example.test.designpatterns.memento.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 11:56
 * @Desc:
 */
public class GameRole {

    // 攻击力
    private int vit;

    // 防御力
    private int def;

    /**
     * 创建Memento，即根据当前的状态得到
     *
     * @return
     */
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    /**
     * 从备忘录独享，恢复GameRole的状态
     *
     * @param memento
     */
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }



    /**
     * 显示当前的游戏角色的状态
     */
    public void display() {
        System.out.println("该游戏角色的攻击力为：" + this.vit + ",防御力为：" + this.def);
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
