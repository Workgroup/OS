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
        RAM.words[address] = virtualRegisters.get(V_R).getValue();
        virtualRegisters.get(V_SP).setValue(virtualRegisters.get(V_SP).getValue());
    }
    
    public void pop(){
        
    }
    
    public void doAddition(){
        
    }
}
