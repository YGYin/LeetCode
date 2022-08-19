package javase.abstract_.template;

public class JobB extends Template {
    @Override
    public void job() {
        long num = 0;
        for (int i = 0; i < 10000; i++)
            num *= i;
    }
}
