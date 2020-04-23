package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionHandler implements ActionListener {
    static operation mtxF;
    static boolean ms;
    static boolean sr;
    static boolean ssr;
    static int col;
    static int n;
    public void actionPerformed(ActionEvent e) {
        String bigString = MainPanelHandler.getFirstMatrix().getText();
        if (bigString.length() != 0) {
            WeightPanelHandler.firstMatrix.setText(null);
            String[][] charFM = splitting(bigString);
            col = 0;
            n = Integer.parseInt(charFM[0][0]);
            if (MainPanelHandler.getButton().isSelected() == true)
            {
                mtxF = new operation(fill(charFM, Integer.parseInt(charFM[0][0])),Integer.parseInt(charFM[0][0]));
                ms = true;
                sr = false;
                ssr = false;
                AnswerHandler.getAnswerLabel().setText(mtxF.mtx.toString());
                JTextArea firstMatrix = new JTextArea("");
                for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                    for (int j = 0; j < ActionHandler.mtxF.mtx.size(); j++) {
                        if (ActionHandler.mtxF.mtx.get(i).get(j) == 1) {
                            String charFF = String.valueOf(i + 1) + " " + String.valueOf(j + 1) + "\n";
                            col++;
                            WeightPanelHandler.firstMatrix.append(charFF);
                        }


                    }
                }


            }

            if (MainPanelHandler.getsrButton().isSelected() == true){
                mtxF = new operation(fillsr(charFM, Integer.parseInt(charFM[0][0])),Integer.parseInt(charFM[0][0]));
                ms = false;
                sr = true;
                ssr = false;
                AnswerHandler.getAnswerLabel().setText(mtxF.mtx.toString());
                for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++)
                {
                    col++;
                    String charFF = String.valueOf(ActionHandler.mtxF.mtx.get(i).get(0)) + " " + String.valueOf(ActionHandler.mtxF.mtx.get(i).get(1)) + "\n";
                    WeightPanelHandler.firstMatrix.append(charFF);
                }
            }

            if (MainPanelHandler.getssrButton().isSelected() == true) {
                mtxF = new operation(fillssr(charFM, Integer.parseInt(charFM[0][0])),Integer.parseInt(charFM[0][0]));
                ms = false;
                sr = false;
                ssr = true;
                AnswerHandler.getAnswerLabel().setText(mtxF.mtx.toString());
                for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++)
                {
                    for (int j = 0; j < ActionHandler.mtxF.mtx.get(i).size(); j++) {
                        col++;
                        String charFF = String.valueOf(i+1) + " " + String.valueOf(ActionHandler.mtxF.mtx.get(i).get(j)) + "\n";
                        WeightPanelHandler.firstMatrix.append(charFF);
                    }

                }
            }



        }
    }

    private String[][] splitting(String bigString) {
        String[] strOne = bigString.split("\n");
        String[][] strTwo = new String[strOne.length][];
        for (int i = 0 ; i < strTwo.length; i++) strTwo[i] = strOne[i].split(" ");
        return strTwo;
    }

    private  ArrayList<ArrayList<Integer>> fill(String [][] stringMatrix, int n) {

        ArrayList<Integer> fillerMassive;
        ArrayList<ArrayList<Integer>> fillerMatrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            fillerMassive = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                fillerMassive.add(j, Integer.parseInt(stringMatrix[i+1][j]));
            }
            fillerMatrix.add(i, fillerMassive);
        }

        return fillerMatrix;
    }
    private  ArrayList<ArrayList<Integer>> fillsr(String [][] stringMatrix, int n) {
        ArrayList<Integer> fillerMassive;
        ArrayList<ArrayList<Integer>> fillerMatrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            fillerMassive = new ArrayList<>(2);

            for (int j = 0; j < 2; j++) {
                fillerMassive.add(j, Integer.parseInt(stringMatrix[i+1][j]));
            }
            fillerMatrix.add(i, fillerMassive);
        }
        return fillerMatrix;
    }
    private  ArrayList<ArrayList<Integer>> fillssr(String [][] stringMatrix, int n) {
        ArrayList<Integer> fillerMassive;
        ArrayList<ArrayList<Integer>> fillerMatrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            fillerMassive = new ArrayList<>(n);
            int num = 0;
            int col = 0;
            for (int j = 0; j < n; j++) {
                if ( Integer.parseInt(stringMatrix[i+1][j])==0) break;
                col++;
                fillerMassive.add(j,  Integer.parseInt(stringMatrix[i+1][j]));
            }
            ArrayList<Integer> fillerMassive3 = new ArrayList<>(col);
            for (int j = 0; j < col; j++) {
                fillerMassive3.add(j, fillerMassive.get(j) );
            }
            fillerMatrix.add(i, fillerMassive3);
        }

        return fillerMatrix;
    }

}