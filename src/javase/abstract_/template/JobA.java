package javase.abstract_.template;

public class JobA extends Template {
    @Override
    public void job() {
        long num = 0;
        for (int i = 1; i < 100000; i++)
            num += i;
    }
}
