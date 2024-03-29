package com.example.utils.Name;

import java.util.Random;

/**
 * @Author ： Leo
 * @Date : 2020/11/23 15:30
 * @Desc: 自动生成姓名
 *
 * 姓 --- 性别 ---  名字
 */
public class GenerateNameUtil {
    //常见单姓
    private static String[] Surname = {"连", "宇文", "司徒","司空"};
    /*private static String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
            "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
            "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
            "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
            "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "连","欧阳", "端木", "上官", "司马", "东方", "独孤", "南宫","诸葛","公羊", "公孙", "慕容", "宇文", "司徒","司空"};
    */// 几乎所有复姓
    private static String[] COMPOUD_SURNAME ={"太史", "欧阳", "端木", "上官", "司马", "东方", "独孤", "南宫", "万俟", "闻人", "夏侯",
                "诸葛", "尉迟", "公羊", "赫连", "澹台", "皇甫", "宗政", "濮阳", "公冶", "太叔", "申屠", "公孙", "慕容", "仲孙", "钟离",
                "长孙", "宇文", "司徒", "鲜于", "司空", "闾丘", "子车", "亓官", "司寇", "巫马", "公西", "颛孙", "壤驷", "公良", "漆雕",
                "乐正", "宰父", "谷梁", "拓跋",};
    //常见复姓
    private static String[] USUAL_COMPOUND_SURNAME = {"欧阳", "端木", "上官", "司马", "东方", "独孤", "南宫","诸葛","公羊", "公孙", "慕容", "宇文", "司徒","司空"};

    //常见女姓名字
    private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";

    //常见男性名字
    private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    private static String LIAN = "连";

    private static Random random = new Random();
    /**
     * 根据比列 来生成姓名
     * @return
     */
    public static String getName() {
        //随机获取一个姓氏
        String name = getSurname();

        //可以根据这个数设置产生的男女比例
        int i = random.nextInt(3);
        if (i == 2) {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "女-"+ name + girl.substring(j, j + 2);
            } else {
                name = "女-"+ name + girl.substring(j, j + 1);
            }
        } else {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "男-"+ name + boy.substring(j, j + 2);
            } else {
                name = "男-"+ name + boy.substring(j, j + 1);
            }
        }
        return name;
    }

    /**
     * 通过性别 来生成复姓
     * @param gender  0: 女  ，1：男
     * @return
     */
    public static String getCompoundNameByGender(Integer gender) {
        //随机获取一个姓氏
        String name = getCompoundSurname();
        //可以根据这个数设置产生的男女比例
        if (gender == 0) {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "女--"+ name + girl.substring(j, j + 2);
            } else {
                name = "女--"+ name + girl.substring(j, j + 1);
            }
        } else {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "男--"+ name + boy.substring(j, j + 2);
            } else {
                name = "男--"+ name + boy.substring(j, j + 1);
            }
        }
        return name;

    }


    /**
     * 通过性别 来生成姓名
     * @param gender
     * @return
     */
    public static String getNameByGender(Integer gender) {
        //随机获取一个姓氏
        String name = getCompoundSurname();
        //可以根据这个数设置产生的男女比例
        if (gender == 0) {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "女--"+ name + girl.substring(j, j + 2);
            } else {
                name = "女--"+ name + girl.substring(j, j + 1);
            }
        } else {
            int j = random.nextInt(girl.length() - 2);
            if (j % 2 == 0) {
                name = "男--"+ name + boy.substring(j, j + 2);
            } else {
                name = "男--"+ name + boy.substring(j, j + 1);
            }
        }
        return name;

    }

    /**
     * 随机获取一个姓氏
     * @return
     */
    public static String getSurname(){
//        int index = random.nextInt(Surname.length - 1);
//        //获得一个随机的姓氏
//        String surname = Surname[index];
        return "连" ;
    }

    public static String getCompoundSurname(){
        /*int index = random.nextInt(USUAL_COMPOUND_SURNAME.length - 1);
        //获得一个随机的姓氏
        String surname = USUAL_COMPOUND_SURNAME[index];
        return surname ;*/
        return LIAN;
    }

    public static void main(String[] args) {
        String name = getName();
        System.out.println("按比例生成姓名："+ name);
        System.out.println("按性别生成姓名："+ getNameByGender(0));
        System.out.println("按性别生成女姓复姓："+  getCompoundNameByGender(0));
        System.out.println("按性别生成男性复姓："+  getCompoundNameByGender(1));
    }
}
