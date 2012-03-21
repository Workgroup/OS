package os2;

import java.util.ArrayList;

public class RAM {
    
    int supervisorMemorySize = 256;
    int userMemorySize = 256;
    int wordSize = 4;
    int[][] words;
    
    public RAM(){
        int allMemorySize = supervisorMemorySize + userMemorySize;
        words = new int[allMemorySize][wordSize];
        for (int i = 0; i<allMemorySize; i++){
                words[i] = new int[]{0, 0, 0, 0};
        }
    }
    
    public void setWord(int x, int y, int[] value) {
       words[x * 16 + y] = value;
    }
    
    public int[] getWord(int x, int y) {
       return words[x * 16 + y];
    }
    
    public String getStringValueAt(int x, int y){
        String s = null;
        s = Integer.toString(words[x * 16 + y][0]) + Integer.toString(words[x * 16 + y][1]) +
            Integer.toString(words[x * 16 + y][2]) + Integer.toString(words[x * 16 + y][3]);
        return s;
    }
}
