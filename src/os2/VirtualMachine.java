package os2;

import java.util.ArrayList;

public class VirtualMachine {
    
    public ArrayList<Register> virtualRegisters = new ArrayList<Register>();
    
    public VirtualMachine(){
        virtualRegisters.add(new Register("IR", 2, new int[]{0, 0}));
        virtualRegisters.add(new Register("SF", 1, new int[]{0}));
        virtualRegisters.add(new Register("DF", 1, new int[]{0}));
        virtualRegisters.add(new Register("IP", 2, new int[]{0, 1}));
        virtualRegisters.add(new Register("R", 4, new int[]{0, 0, 0, 0}));
        virtualRegisters.add(new Register("SP", 2, new int[]{0, 0}));
    }
}