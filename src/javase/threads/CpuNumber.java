package javase.threads;

public class CpuNumber {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNum = runtime.availableProcessors();
        System.out.println("CPU Numbers: " + cpuNum);
    }
}
