package javase.abstract_.template;

abstract public class Template {
    public abstract void job();

    public void calTimes() {
        long start = System.currentTimeMillis();
        job();  // 动态绑定，调用方法时会和该对象的内存地址（运行类型）绑定
        long end = System.currentTimeMillis();
        System.out.println("Time consuming: " + (end - start));
    }
}
