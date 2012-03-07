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
        
}
