package os2;

public class OS2 {
    
    public static RAM ram;
    public static CPU cpu;
    public static ChannelingDevice channelingDevice;
    public static HDD hdd;
    public static PagesDevice pagesDevice;
    public static Input input;
    public static Output output;
    
    public static void main(String[] args) {
        ram = new RAM();
        cpu = new CPU();
        channelingDevice = new ChannelingDevice();
        hdd = new HDD();
        pagesDevice = new PagesDevice();
        input = new Input();
        output = new Output();
    }
}
