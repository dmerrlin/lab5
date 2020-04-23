package lab3;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;

public class WeightPanelHandler extends JPanel
{
    private JButton equalsButton;
    public static JTextArea firstMatrix;
    private ActionListener actionListener = new ActionWeight();
    private static JPanel matrixFT;
    private JCheckBox italicBox = new JCheckBox("Граф взвешенный?");
  public static boolean weidth;
     public WeightPanelHandler()
     { super();

     GridBagLayout layoutGB = new GridBagLayout();
     layoutGB.columnWidths = new int[]
             {200,100,200}; layoutGB.rowHeights = new int[]{300};
             this.setLayout(layoutGB); this.setBorder(new EmptyBorder(10,10,10,10));
          firstMatrix = new JTextArea(8, 40);
             firstMatrix.setFont(firstMatrix.getFont().deriveFont(14f));
             matrixFT = new JPanel();
             matrixFT.setLayout(new BorderLayout());
             matrixFT.add(firstMatrix, BorderLayout.CENTER);
             JPanel matrixST = new JPanel();
    matrixST.setLayout(new BorderLayout());

    equalsButton = new JButton("Принять");
    JPanel choicePanel = new JPanel();
         italicBox.addItemListener(new ItemListener() {
             public void itemStateChanged(ItemEvent e) {
                 if(!weidth)
                 weidth = true; else
                     weidth = false;
             }
         });
         choicePanel.add(italicBox);
    choicePanel.setLayout(new BoxLayout(choicePanel,BoxLayout.Y_AXIS));
    choicePanel.add(new Box.Filler(new Dimension(75,75),new Dimension(75,75),new Dimension(75,75)));
    choicePanel.add(equalsButton);

    equalsButton.setAlignmentX(LEFT_ALIGNMENT);

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH; constraints.gridx = 0;
    constraints.gridy = 0; this.add(matrixFT,constraints);
    constraints.fill = GridBagConstraints.BOTH; constraints.gridx = 1;
    constraints.gridy = 0; this.add(choicePanel,constraints);
    constraints.fill = GridBagConstraints.BOTH; constraints.gridx = 2;
    constraints.gridy = 0; this.add(matrixST,constraints);


    equalsButton.addActionListener(actionListener);
     }

    public static JPanel getButton() {
        return matrixFT;
    }
    public static JTextArea getFirstMatrix() {
         return firstMatrix;
     }




}