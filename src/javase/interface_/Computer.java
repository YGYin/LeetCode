package javase.interface_;


public class Computer {
    // Computer has usb plugin
    public void work(UsbInterface usbInterface) {
        // To invoke the method by using interface
        usbInterface.start();
        usbInterface.stop();
    }
}
