package lab3;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class AnswerHandler extends JPanel
{
    private static JLabel answerLabel;
    private static JLabel answerLabel1;

    AnswerHandler() {
        super();
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10,10,10,10));
        answerLabel = new JLabel("<html>Answer:<br> Size: 0x0 </html>");
        choicePanel.add(answerLabel,BorderLayout.NORTH);
        answerLabel1 = new JLabel("<html>AnswerWeight:<br> Size: 0x0 </html>");
        choicePanel.add(answerLabel1,BorderLayout.NORTH);
        this.add(choicePanel);
    }

        public static JLabel getAnswerLabel() {
        return answerLabel;
    }
    public static JLabel getAnswerLabel1() {
        return answerLabel1;
    }

}