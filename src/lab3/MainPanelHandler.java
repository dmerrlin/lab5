package lab3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

public class MainPanelHandler extends JPanel
{
    private JButton equalsButton;
    private static JTextArea firstMatrix;
    private static JRadioButton Button;
    private static JRadioButton srButton;
    private static JRadioButton ssrButton;
    private ActionListener actionListener = new ActionHandler();
     public MainPanelHandler()
     { super();

     GridBagLayout layoutGB = new GridBagLayout();
     layoutGB.columnWidths = new int[]
             {200,100,200-15}; layoutGB.rowHeights = new int[]{300-50};
             this.setLayout(layoutGB); this.setBorder(new EmptyBorder(10,10,10,10));
             firstMatrix = new JTextArea();
             firstMatrix.setFont(firstMatrix.getFont().deriveFont(14f));
             JPanel matrixFT = new JPanel();
             matrixFT.setLayout(new BorderLayout());
             matrixFT.add(firstMatrix, BorderLayout.CENTER); JPanel matrixST = new JPanel();

    matrixST.setLayout(new BorderLayout());

    Button = new JRadioButton("Матрица смежности");
    srButton = new JRadioButton("Список ребер");
    ssrButton = new JRadioButton("Список смежности вершин");
   Button.setSelected(true);
    equalsButton = new JButton("Принять");
    ButtonGroup group = new ButtonGroup();
    group.add(Button);
    group.add( srButton);
    group.add(ssrButton);
    JPanel choicePanel = new JPanel();
    choicePanel.setLayout(new BoxLayout(choicePanel,BoxLayout.Y_AXIS));
    choicePanel.add(Button); Button.setAlignmentX(LEFT_ALIGNMENT);
    choicePanel.add(srButton);
    srButton.setAlignmentX(LEFT_ALIGNMENT);
    choicePanel.add(ssrButton);
    ssrButton.setAlignmentX(LEFT_ALIGNMENT);
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


    public static JTextArea getFirstMatrix() {
         return firstMatrix;
     }



    public static JRadioButton getButton() {
        return Button;
    }
    public static JRadioButton getsrButton() {
         return  srButton;
     }
    public static JRadioButton getssrButton() {
         return ssrButton;
     }
}