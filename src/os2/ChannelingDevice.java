package os2;

public class ChannelingDevice {
    Register ch = new Register("CH", 1, new int[]{0});
    RAM ram = new RAM();
    HDD hdd = new HDD();
    boolean[][] interupt;
    
    ChannelingDevice() {
        interupt = new boolean[CPU.INTERUPT_TYPE][CPU.INTERUPT_CASE];        
        interupt[CPU.PROGRAM_INT][CPU.NON_EXIST_CODE] = false;
        interupt[CPU.PROGRAM_INT][CPU.NON_EXIST_ADDRESS] = false;
        interupt[CPU.PROGRAM_INT][CPU.NULL_DIVISION] = false;
        interupt[CPU.PROGRAM_INT][CPU.BAD_OPERAND] = false;
        interupt[CPU.SYSTEM_INT][CPU.INPUT_ERR] = false;
        interupt[CPU.SYSTEM_INT][CPU.OUTPUT_ERR] = false;
        interupt[CPU.SYSTEM_INT][CPU.HDD_ERR] = false;
        interupt[CPU.TIMER_INT][CPU.OUT_OF_TIME] = false;
    }
    
    public void write(int[] value) {
        switch (getChannel()){
/*Output*/   case 2:  {
                break;
            }
            default: {
                interupt[CPU.PROGRAM_INT][CPU.NON_EXIST_CODE] = true;
            }
        }   
    }

    public void write(int[] value, int x, int y) {
        switch (getChannel()){
/*HDD*/     case 3: {
                hdd.words[x * 16 + y] = value;
                break;
            }
/*RAM*/     case 4: {
                ram.words[x * 16 + y] = value;
                break;
            }
            default: {
                interupt[CPU.PROGRAM_INT][CPU.NON_EXIST_CODE] = true;
            }
        }
    }
    
    public int[] read(){
        switch (getChannel()){
/*Input*/   case 1: {
                return new int[]{0, 0, 0, 0};
            }
            default: {
                interupt[CPU.PROGRAM_INT][CPU.NON_EXIST_CODE] = true;
                return CPU.registers.get(CPU.R).getValue();
            }
        }
    }
    
    public int[] read(int x, int y){
        switch (getChannel()){
/*HDD*/     case 3: {
                return hdd.words[x * 16 + y];
            }
/*RAM*/     case 4: {
                return ram.words[x * 16 + y];
            }
            default: {
                interupt[CPU.PROGRAM_INT][CPU.NON_EXIST_CODE] = true;
               return CPU.registers.get(CPU.R).getValue();
            }
        }     
    }
    
    public void setChannel(int ch) {
       this.ch.setValue(new int[]{0});
    }

    public int getChannel() {
       return ch.getValue()[0];
    }
    
}
