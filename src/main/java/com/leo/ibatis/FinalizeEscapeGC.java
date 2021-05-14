package com.leo.ibatis;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/04/01
 * @description
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC instance;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FinalizeEscapeGC{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("方法进入finalize");
        instance = this;
    }

    public void alive() {
        System.out.println("我还活着" + this.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        instance = new FinalizeEscapeGC();
        instance.setName("jjjjjj");
        System.out.println("创建测试对象" + instance.toString());

        instance = null;
        System.gc();
//        TimeUnit.SECONDS.sleep(5);
        if (instance == null) {
            System.out.println("我被回收了");
        } else {
            instance.alive();
        }

        System.out.println("............第二次赴死");
        instance = null;
        System.gc();
//        TimeUnit.SECONDS.sleep(5);
        if (instance == null) {
            System.out.println("我被回收了");
        } else {
            instance.alive();
        }
    }
}
