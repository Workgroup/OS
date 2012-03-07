package os2;

public class Input {
    int memorySize = 1;
    int wordSize = 4;
    int[][] words;
    
    public Input(){
        words = new int[memorySize][wordSize];
        for (int i = 0; i<=memorySize-1; i++){
                words[i] = new int[]{0, 0, 0, 0};
        }
    }
    
    public void setWord(int x, int y, int[] value) {
       words[x * 16 + y] = value;
    }
    
    public int[] getWord(int x, int y) {
       return words[x * 16 + y];
    }
}