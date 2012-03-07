package os2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;

public class GUI extends MouseAdapter implements ActionListener {
    
    private OS2 os2;
    private JLabel registersL, ramL;
    
    public GUI(final OS2 os2){
        this.os2 = os2;
        
    }
        
    public void actionPerformed(ActionEvent e) {
        
    };
    
     
}
