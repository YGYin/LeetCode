package javase.interface_;

public class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("Camera is working.");
    }

    @Override
    public void stop() {
        System.out.println("Camera is stop working.");
    }
}
