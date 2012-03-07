package os2;

public class Register {
    
    private String name;
    private int size;
    private int[] value;
    private int[] defaultValue;
    
    public Register(String name, int size, int[] defaultValue){
        this.name = name;
        this.size = size;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }
    
    public void setDefaultValues(){
        this.value = this.defaultValue;
    }

    public int[] getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int[] defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
    
    public int getNumber(){
        int number;
        number = value[3]+(value[2]*256)+(value[1]*65536)+(value[0]*16777216);
        return number;
    }
    
    public void setNumber(int number){
        int i;
        i = number / 16777216;
        number = number - (i*16777216);
        value[0] = i;
        i = number / 65536;
        number = number -(i*65536);
        value[1] = i;
        i = number / 256;
        number = number - (i*256);
        value[2] = i;
        value[3] = number;
    }
}
