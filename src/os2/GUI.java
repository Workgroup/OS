package os2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class GUI extends MouseAdapter implements ActionListener {
    
    private OS2 os2;
    private JLabel registersL, controlsL, virtualMachinesL, virtualRegistersL,
            inputL, outputL, ramL, virtualRamL;
    private JButton loadProgramB, newVirtualMachineB, deleteVirtualMachineB,
            doAllB, makeStepB;
    private JTextArea registersTA, virtualRegistersTA, inputTA, outputTA;
    private JFrame mainWindow;
    private JPanel mainUp, mainDown, mainUpFirst, mainUpSecond, mainUpThird,
            mainUpFourth, mainUpFifth, mainDownFirst, mainDownSecond,
            mainUpSecondUp, mainUpSecondDown, mainUpFifthUp, mainUpFifthDown,
            ramTablePanel;
    private JList virtualMachinesJList;
    private JTable ramTable, virtualRamTable;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int height = screenSize.height;
    private int width = screenSize.width;
    
    public GUI(final OS2 os2){
        this.os2 = os2;
        registersL = new JLabel("Registers");
        controlsL = new JLabel("  Controls");
        virtualMachinesL = new JLabel("Virtual Machines");
        virtualRegistersL = new JLabel("Virtual Registers");
        inputL = new JLabel("Input");
        outputL = new JLabel("Output");
        ramL = new JLabel("RAM");
        virtualRamL = new JLabel("     Virtual RAM");
        virtualMachinesJList = new JList();
        registersTA = new JTextArea();
        virtualRegistersTA = new JTextArea();
        inputTA = new JTextArea(1, 15);
        outputTA = new JTextArea();
        
        Object[][] ramTableData;
        ramTableData = new Object[32][17];
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < 17; j++){
                if(j==0){
                    ramTableData[i][j] = Integer.toString(i);
                } else {
                    ramTableData[i][j] = OS2.ram.getStringValueAt(i, j-1);
                } 
            }
        }
        
        String[] ramTableColNames = {"","0","1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15"};
                    
        ramTable = new JTable(ramTableData, ramTableColNames);
        virtualRamTable = new JTable(17, 9);
        
        inputL.setPreferredSize(new Dimension(430, 20));
        outputL.setPreferredSize(new Dimension(430, 20));
        registersL.setPreferredSize(new Dimension(145, 20));
        virtualMachinesL.setPreferredSize(new Dimension(145, 20));
        controlsL.setPreferredSize(new Dimension(140, 20));
        virtualRegistersL.setPreferredSize(new Dimension(145, 20));
        registersTA.setPreferredSize(new Dimension(145, 210));
        ramL.setPreferredSize(new Dimension(640, 20));
        virtualRamL.setPreferredSize(new Dimension(390, 20));
        registersTA.setBackground(new Color(238, 238, 238));
        registersTA.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        virtualMachinesJList.setPreferredSize(new Dimension(145, 210));
        virtualMachinesJList.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        virtualRegistersTA.setPreferredSize(new Dimension(145, 210));
        virtualRegistersTA.setBackground(new Color(238, 238, 238));
        virtualRegistersTA.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        inputTA.setPreferredSize(new Dimension(430, 20));
        Font myFont = new Font("Verdana", Font.BOLD, 12);
        inputTA.setFont(myFont);
        inputTA.setForeground(Color.WHITE);
        inputTA.setBackground(Color.BLACK);
        outputTA.setPreferredSize(new Dimension(430, 150));
        outputTA.setFont(myFont);
        outputTA.setForeground(Color.WHITE);
        outputTA.setBackground(Color.BLACK);
        
        ramTable.setSize(new Dimension(640, 450));
        JScrollPane ramTableScrollPane = new JScrollPane(ramTable);
        ramTableScrollPane.setPreferredSize(new Dimension(640, 370));
        JTableHeader header = ramTable.getTableHeader();
        header.setBackground(Color.yellow);
        TableColumn column = null;        
        column = ramTable.getColumnModel().getColumn(0);
        ramTable.setFillsViewportHeight(true);
        ramTable.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        
        virtualRamTable.setPreferredSize(new Dimension(365, 272));
        virtualRamTable.setBorder(new LineBorder(new Color(0, 0, 0), 1));
        for(int i = 0; i <16; i++){
            virtualRamTable.setValueAt(i, i+1, 0);
        }
        
        loadProgramB = new JButton("Load Program");
        loadProgramB.setPreferredSize(new Dimension(130, 25));
        newVirtualMachineB = new JButton("New VM");
        newVirtualMachineB.setPreferredSize(new Dimension(130, 25));
        deleteVirtualMachineB = new JButton("Delete VM");
        deleteVirtualMachineB.setPreferredSize(new Dimension(130, 25));
        doAllB = new JButton("Do All");
        doAllB.setPreferredSize(new Dimension(130, 25));
        makeStepB = new JButton("Make Step");
        makeStepB.setPreferredSize(new Dimension(130, 25));
        
        //--- MAIN DOWN SECOND PANEL ---
        mainDownSecond = new JPanel();
        mainDownSecond.setPreferredSize(new Dimension(400, 350));
        mainDownSecond.add(virtualRamL, BorderLayout.PAGE_START);
        mainDownSecond.add(virtualRamTable, BorderLayout.PAGE_END);
        
        //--- MAIN DOWN FIRST PANEL ---
        mainDownFirst = new JPanel();
        mainDownFirst.setPreferredSize(new Dimension(680, 400));
        mainDownFirst.add(ramL, BorderLayout.PAGE_START);
        mainDownFirst.add(ramTableScrollPane, BorderLayout.PAGE_END);
        
         //--- MAIN UP FIFTH DOWN PANEL ---
        mainUpFifthDown = new JPanel();
        mainUpFifthDown.setPreferredSize(new Dimension(440, 190));
        mainUpFifthDown.add(outputL, BorderLayout.PAGE_START);
        mainUpFifthDown.add(outputTA, BorderLayout.PAGE_START);
        
        //--- MAIN UP FIFTH UP PANEL ---
        mainUpFifthUp = new JPanel();
        mainUpFifthUp.setPreferredSize(new Dimension(440, 50));
        mainUpFifthUp.add(inputL, BorderLayout.PAGE_START);
        mainUpFifthUp.add(inputTA, BorderLayout.PAGE_START);
        
        //--- MAIN UP FIFTH PANEL ---
        mainUpFifth = new JPanel();
        mainUpFifth.setPreferredSize(new Dimension(450, 335));
        mainUpFifth.add(mainUpFifthUp, BorderLayout.PAGE_START);
        mainUpFifth.add(mainUpFifthDown, BorderLayout.PAGE_END);
        
        //--- MAIN UP FOURTH PANEL ---
        mainUpFourth = new JPanel();
        mainUpFourth.setPreferredSize(new Dimension(150, 335));
        mainUpFourth.add(virtualRegistersL, BorderLayout.PAGE_START);
        mainUpFourth.add(virtualRegistersTA, BorderLayout.PAGE_END);
        
        //--- MAIN UP THIRD PANEL ---
        mainUpThird = new JPanel();
        mainUpThird.setPreferredSize(new Dimension(150, 335));
        mainUpThird.add(virtualMachinesL, BorderLayout.PAGE_START);
        mainUpThird.add(virtualMachinesJList, BorderLayout.PAGE_END);
        
        //--- MAIN UP SECOND UP PANEL ---
        mainUpSecondUp = new JPanel();
        mainUpSecondUp.setPreferredSize(new Dimension(140, 145));
        mainUpSecondUp.add(loadProgramB, BorderLayout.PAGE_START);
        mainUpSecondUp.add(doAllB);
        mainUpSecondUp.add(makeStepB, BorderLayout.PAGE_END);
        
        //--- MAIN UP SECOND DOWN PANEL ---
        mainUpSecondDown = new JPanel();
        mainUpSecondDown.setPreferredSize(new Dimension(140, 125));
        mainUpSecondDown.add(newVirtualMachineB, BorderLayout.PAGE_START);
        mainUpSecondDown.add(deleteVirtualMachineB, BorderLayout.PAGE_END);
        
        //--- MAIN UP SECOND PANEL ---
        mainUpSecond = new JPanel();
        mainUpSecond.setPreferredSize(new Dimension(150, 335));
        mainUpSecond.add(controlsL, BorderLayout.PAGE_START);
        mainUpSecond.add(mainUpSecondUp);
        mainUpSecond.add(mainUpSecondDown, BorderLayout.PAGE_END);
        
        //--- MAIN UP FIRST PANEL ---
        mainUpFirst = new JPanel();
        mainUpFirst.setPreferredSize(new Dimension(150, 335));
        mainUpFirst.add(registersL, BorderLayout.PAGE_START);
        mainUpFirst.add(registersTA, BorderLayout.PAGE_END);
        
        //---  MAIN UP PANEL ---
        mainUp = new JPanel();
        mainUp.setPreferredSize(new Dimension(1090, 245));
        mainUp.add(mainUpFirst);
        mainUp.add(mainUpSecond);
        mainUp.add(mainUpThird);
        mainUp.add(mainUpFourth);
        mainUp.add(mainUpFifth);
        
        //--- MAIN DOWN PANEL ---
        mainDown = new JPanel();
        mainDown.setPreferredSize(new Dimension(1090, 420));
        mainDown.add(mainDownFirst);
        mainDown.add(mainDownSecond);
         
        //--- MAIN FRAME WINDOW ---
        mainWindow = new JFrame("Real/Virtual machine");       
        mainWindow.setLocation((width/2)-(1100/2), (height/2)-(730/2));
        mainWindow.add(mainUp, BorderLayout.PAGE_START);
        mainWindow.add(mainDown, BorderLayout.PAGE_END);
        mainWindow.setResizable(false); 
        mainWindow.setPreferredSize(new Dimension(1100, 700));
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
        
    }
        
    public void actionPerformed(ActionEvent e) {
        
    };
    
     
}
