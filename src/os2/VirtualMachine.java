package os2;

import java.util.ArrayList;

public class VirtualMachine {
    
    static final int V_IR = 0;
    static final int V_SF = 1;
    static final int V_DF = 2;
    static final int V_IP = 3;
    static final int V_R = 4;
    static final int V_SP = 5;
    
    public ArrayList<Register> virtualRegisters = new ArrayList<Register>();
    
    public VirtualMachine(){
        virtualRegisters.add(new Register("IR", 2, new int[]{0, 0}));
        virtualRegisters.add(new Register("SF", 1, new int[]{0}));
        virtualRegisters.add(new Register("DF", 1, new int[]{0}));
        virtualRegisters.add(new Register("IP", 2, new int[]{0, 1}));
        virtualRegisters.add(new Register("R", 4, new int[]{0, 0, 0, 0}));
        virtualRegisters.add(new Register("SP", 2, new int[]{0, 0}));
    }
    
    public void push(){
        int address = ((virtualRegisters.get(V_SP).getValue()[0])*16)+ virtualRegisters.get(V_SP).getValue()[1];
        OS2.ram.words[address] = virtualRegisters.get(V_R).getValue();
        virtualRegisters.get(V_SP).setNumber(virtualRegisters.get(V_SP).getNumber()+1);
    }
    
    public void pop(){
        int address = ((virtualRegisters.get(V_SP).getValue()[0])*16)+ virtualRegisters.get(V_SP).getValue()[1];
        virtualRegisters.get(V_R).setValue(OS2.ram.words[address]);
        virtualRegisters.get(V_SP).setNumber(virtualRegisters.get(V_SP).getNumber()-1);
    }
    
    public void doAddition(){
        int address = ((virtualRegisters.get(V_SP).getValue()[0])*16)+ virtualRegisters.get(V_SP).getValue()[1];
        int x = toNumber(OS2.ram.words[address]);
        int y = toNumber(OS2.ram.words[address-1]);
        OS2.ram.words[address-1] = toArray(x+y);
        virtualRegisters.get(V_SP).setNumber(virtualRegisters.get(V_SP).getNumber()-1);        
    }
    
    public int toNumber(int[] x){
        int number;
        number = x[3]+(x[2]*256)+(x[1]*65536)+(x[0]*16777216);
        return number;
    }
    
    public int[] toArray(int x){
        int i;
        int[] value;
        value = new int[4];
        i = x / 16777216;
        x = x - (i*16777216);
        value[0] = i;
        i = x / 65536;
        x = x -(i*65536);
        value[1] = i;
        i = x / 256;
        x = x - (i*256);
        value[2] = i;
        value[3] = x;
        return value;
    }
}
