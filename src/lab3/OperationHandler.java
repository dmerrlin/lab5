package lab3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class OperationHandler extends JPanel
{
    private JButton equalsButton;
    private static JTextArea firstMatrix;
    private static JRadioButton AddButton;
    private static JRadioButton DelButton;
    private static JPanel matrixFT;

    private ActionListener actionListener = new Action();

    public OperationHandler()
    { super();
        GridBagLayout layoutGB = new GridBagLayout();
        layoutGB.columnWidths = new int[]
                {200-15,100,200-15}; layoutGB.rowHeights = new int[]{300-50};
        this.setLayout(layoutGB); this.setBorder(new EmptyBorder(10,10,10,10));
        firstMatrix = new JTextArea("2 3");
        firstMatrix.setFont(firstMatrix.getFont().deriveFont(14f));
        matrixFT = new JPanel();
        matrixFT.setLayout(new BorderLayout());
        matrixFT.add(firstMatrix, BorderLayout.CENTER);
        JPanel matrixST = new JPanel();
        matrixST.setLayout(new BorderLayout());

        AddButton = new JRadioButton("Добавить связь");
        DelButton = new JRadioButton("Удалить связь");

        AddButton.setSelected(true);
        equalsButton = new JButton("Принять");
        ButtonGroup group = new ButtonGroup();
        group.add(AddButton);
        group.add(DelButton);
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel,BoxLayout.Y_AXIS));
        choicePanel.add(AddButton);
        AddButton.setAlignmentX(LEFT_ALIGNMENT);
        choicePanel.add( DelButton);  DelButton.setAlignmentX(LEFT_ALIGNMENT);

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

    public static JRadioButton getAddButton() {
        return AddButton;
    }
    public static JRadioButton getDelButton() {
        return  DelButton;
    }

}