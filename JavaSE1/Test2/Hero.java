public class Hero {
    /* 对象属性 */
    String name;      // 名字
    float hp;         // 血量
    float armor;      // 护甲
    int moveSpeed;    // 移动速度
    int money;        // 金钱数

    /* 对象方法 */
    // 获取护甲值 armor
    float getArmor() {
        return armor;
    }
    // 坑队友
    void keng() {
        System.out.println("坑队友");
    }
    // 增加移动速度
    void addMoveSpeed() {
        this.moveSpeed += 100;
    }
    // 回血
    void recovery(float blood) {
        this.hp += blood;
    }

    /* 类方法：程序入口 */
    public static void main(String[] args) {
        // 创建盖伦对象
        Hero galen = new Hero();    // 通过 new 关键字创建对象
        galen.name = "盖伦";        // 设置 hero 对象的各个属性
        galen.hp = 616.28F;
        galen.armor = 17.536F;
        galen.moveSpeed = 350;

        // 创建提莫对象
        Hero timor = new Hero();
        timor.name = "提莫";
        timor.hp = 383F;
        timor.armor = 14F;
        timor.moveSpeed = 330;

        // 调用对象方法
        System.out.println("盖伦的移动速度是：" + galen.moveSpeed);
        galen.addMoveSpeed();
        System.out.println("盖伦的移动速度是：" + galen.moveSpeed);
        System.out.println("--------------------" );
        System.out.println("盖伦的血量是：" + galen.hp);
        galen.recovery(100);
        System.out.println("盖伦的血量是：" + galen.hp);
        galen.keng();
        System.out.println("提莫的护甲值是：" + timor.getArmor());
    }
}