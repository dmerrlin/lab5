
package lab3;

        import java.awt.*;
        import javax.swing.*;


public class GUIHadler implements Runnable
{
    private JFrame mainFrame;
    @Override public void run()
    {
        mainFrame = new JFrame("Работа с графом");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setPreferredSize(new Dimension(500,250));
        mainFrame.setBounds(dimension.width/2-250,dimension.height/2-125,500,250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fillerPanel = new MainPanelHandler();
       JPanel answerPanel = new AnswerHandler();
        JPanel WeightPanel = new WeightPanelHandler();
        JPanel operationPanel = new OperationHandler();
        JTabbedPane mainPane = new JTabbedPane();
        JTabbedPane weightPanel = new JTabbedPane();
       mainPane.addTab("Заполнение",fillerPanel);
        mainPane.addTab("Вес",WeightPanel);
       mainPane.addTab("Операции",operationPanel);
        mainPane.addTab("Ответ",answerPanel);

        mainFrame.getContentPane().add(mainPane);
        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }
}