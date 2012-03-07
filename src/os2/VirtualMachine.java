package os2;

import java.util.ArrayList;

public class VirtualMachine {
    
    static final int V_IR = 0;
    static final int V_SF = 1;
    static final int V_DF = 2;
    static final int V_IP = 3;
    static final int V_R = 4;
    static final int V_SP = 5;
    
    public ArrayList<Register> vRegisters = new ArrayList<Register>();
    
    public VirtualMachine(){
        vRegisters.add(new Register("IR", 2, new int[]{0, 0}));
        vRegisters.add(new Register("SF", 1, new int[]{0}));
        vRegisters.add(new Register("DF", 1, new int[]{0}));
        vRegisters.add(new Register("IP", 2, new int[]{0, 1}));
        vRegisters.add(new Register("R", 4, new int[]{0, 0, 0, 0}));
        vRegisters.add(new Register("SP", 2, new int[]{0, 0}));
    }
    
    public void push(){
        int address = ((vRegisters.get(V_SP).getValue()[0])*16)+ vRegisters.get(V_SP).getValue()[1];
        OS2.ram.words[address] = vRegisters.get(V_R).getValue();
        vRegisters.get(V_SP).setNumber(vRegisters.get(V_SP).getNumber()+1);
    }
    
    public void pop(){
        int address = ((vRegisters.get(V_SP).getValue()[0])*16)+ vRegisters.get(V_SP).getValue()[1];
        vRegisters.get(V_R).setValue(OS2.ram.words[address]);
        vRegisters.get(V_SP).setNumber(vRegisters.get(V_SP).getNumber()-1);
    }
    
    public void doAddition(){
        int address = ((vRegisters.get(V_SP).getValue()[0])*16)+ vRegisters.get(V_SP).getValue()[1];
        int x = toNumber(OS2.ram.words[address]);
        int y = toNumber(OS2.ram.words[address-1]);
        OS2.ram.words[address-1] = toArray(y+x);
        vRegisters.get(V_SP).setNumber(vRegisters.get(V_SP).getNumber()-1);        
    }
    
    public void doSubtraction(){
        int address = ((vRegisters.get(V_SP).getValue()[0])*16)+ vRegisters.get(V_SP).getValue()[1];
        int x = toNumber(OS2.ram.words[address]);
        int y = toNumber(OS2.ram.words[address-1]);
        OS2.ram.words[address-1] = toArray(y-x);
        vRegisters.get(V_SP).setNumber(vRegisters.get(V_SP).getNumber()-1);        
    }
    
    public void doMultiplication(){
        int address = ((vRegisters.get(V_SP).getValue()[0])*16)+ vRegisters.get(V_SP).getValue()[1];
        int x = toNumber(OS2.ram.words[address]);
        int y = toNumber(OS2.ram.words[address-1]);
        OS2.ram.words[address-1] = toArray(y*x);
        vRegisters.get(V_SP).setNumber(vRegisters.get(V_SP).getNumber()-1);        
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
