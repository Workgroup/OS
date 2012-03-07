package os2;

import java.util.ArrayList;

public class CPU {
    static final int PTR = 0;
    static final int PTT = 1;
    static final int IR = 2;
    static final int SF = 3;
    static final int DF = 4;
    static final int IP = 5;
    static final int R = 6;
    static final int SP = 7;
    static final int MODE = 8;
    static final int PI = 9;
    static final int SI = 10;
    static final int TI = 11;
    static final int TIME = 12;
        
    static final int INTERUPT_TYPE = 3;
    static final int PROGRAM_INT = 0;
    static final int SYSTEM_INT = 1;
    static final int TIMER_INT = 2;
    
    static final int INTERUPT_CASE = 4;
    static final int NON_EXIST_CODE = 0;
    static final int NON_EXIST_ADDRESS = 1;
    static final int NULL_DIVISION = 2;
    static final int BAD_OPERAND = 3;
    static final int INPUT_ERR = 0;
    static final int OUTPUT_ERR = 1;
    static final int HDD_ERR = 2;
    static final int OUT_OF_TIME = 0;
    
    public static ArrayList<Register> registers = new ArrayList<Register>();    
    public ChannelingDevice channelingDevice = new ChannelingDevice();
    
    public CPU(){    
        registers.add(new Register("PTR", 2, new int[]{18, 1}));
        registers.add(new Register("PTT", 2, new int[]{19, 1}));
        registers.add(new Register("IR", 2, new int[]{0, 0}));
        registers.add(new Register("SF", 1, new int[]{0}));
        registers.add(new Register("DF", 1, new int[]{0}));
        registers.add(new Register("IP", 2, new int[]{0, 1}));
        registers.add(new Register("R", 4, new int[]{0, 0, 0, 0}));
        registers.add(new Register("SP", 2, new int[]{0, 0}));
        registers.add(new Register("MODE", 1, new int[]{83}));
        registers.add(new Register("PI", 1, new int[]{0}));
        registers.add(new Register("SI", 1, new int[]{0}));
        registers.add(new Register("TI", 1, new int[]{0}));
        registers.add(new Register("TIME", 1, new int[]{10}));
        
        channelingDevice.setChannel(0);
    }
    
    public ArrayList<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(ArrayList<Register> registers) {
        this.registers = registers;
    }
    
    public void selectChannel(int x){
        channelingDevice.setChannel(x);
    }
    
    public void getValue(){
        registers.get(R).setValue(channelingDevice.read());
    }
    
    public void getValue(int x, int y){
        registers.get(R).setValue(channelingDevice.read(x, y));
    }
    
    public void sendValue(){
        channelingDevice.write(registers.get(R).getValue());
    }
    
     public void sendValue(int x, int y){
        channelingDevice.write(registers.get(R).getValue(), x, y);
    }
     
    public void saveRegisters(){
        channelingDevice.write(registers.get(PI).getValue(), 16, 0);
        channelingDevice.write(registers.get(SI).getValue(), 16, 1);
        channelingDevice.write(registers.get(TI).getValue(), 16, 2);
        channelingDevice.write(registers.get(TIME).getValue(), 16, 3);
        channelingDevice.write(registers.get(IR).getValue(), 16, 4);
        channelingDevice.write(registers.get(IP).getValue(), 16, 5);
        channelingDevice.write(registers.get(PTR).getValue(), 16, 6);
        channelingDevice.write(registers.get(DF).getValue(), 16, 7);
        channelingDevice.write(registers.get(SF).getValue(), 16, 8);
        channelingDevice.write(registers.get(R).getValue(), 16, 9);
        channelingDevice.write(registers.get(SP).getValue(), 16, 10);
        channelingDevice.write(registers.get(PTT).getValue(), 16, 11);
    }
    
    public void loadRegisters(){
        registers.get(PI).setValue(channelingDevice.read(16, 0));
        registers.get(SI).setValue(channelingDevice.read(16, 1));
        registers.get(TI).setValue(channelingDevice.read(16, 2));
        registers.get(TIME).setValue(channelingDevice.read(16, 3));
        registers.get(IR).setValue(channelingDevice.read(16, 4));
        registers.get(IP).setValue(channelingDevice.read(16, 5));
        registers.get(PTR).setValue(channelingDevice.read(16, 6));
        registers.get(DF).setValue(channelingDevice.read(16, 7));
        registers.get(SF).setValue(channelingDevice.read(16, 8));
        registers.get(R).setValue(channelingDevice.read(16, 9));
        registers.get(SP).setValue(channelingDevice.read(16, 10));
        registers.get(PTT).setValue(channelingDevice.read(16, 11));
    }
    
    public void nullRegisters(){
        registers.get(PI).setValue(registers.get(PI).getDefaultValue());
        registers.get(SI).setValue(registers.get(SI).getDefaultValue());
        registers.get(TI).setValue(registers.get(TI).getDefaultValue());
        registers.get(TIME).setValue(registers.get(TIME).getDefaultValue());
        registers.get(IR).setValue(registers.get(IR).getDefaultValue());
        registers.get(IP).setValue(registers.get(IP).getDefaultValue());
        registers.get(PTR).setValue(registers.get(PTR).getDefaultValue());
        registers.get(DF).setValue(registers.get(DF).getDefaultValue());
        registers.get(SF).setValue(registers.get(SF).getDefaultValue());
        registers.get(R).setValue(registers.get(R).getDefaultValue());
        registers.get(SP).setValue(registers.get(SP).getDefaultValue());
        registers.get(PTT).setValue(registers.get(PTT).getDefaultValue());
    }
<<<<<<< HEAD

=======
>>>>>>> ecf81ee1382aa22775d073f826670128554d5790
}