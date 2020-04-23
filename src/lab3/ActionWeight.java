package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionWeight implements ActionListener {
    static operation mtxF;


    public void actionPerformed(ActionEvent e) {
        String bigString = WeightPanelHandler.getFirstMatrix().getText();

        if (bigString.length() != 0 &&  WeightPanelHandler.weidth == true) {
            String[][] charFM = splitting(bigString);
            ArrayList<Integer> fillerMas;
            ArrayList<ArrayList<Integer>> fillerMat = new ArrayList<>(ActionHandler.n);

            for (int i = 0; i < ActionHandler.n; i++) {
                fillerMas = new ArrayList<>(ActionHandler.n);
                for (int j = 0; j < ActionHandler.n; j++) {
                        fillerMas.add(j, -1);
                }
                fillerMat.add(i, fillerMas);
            }
            mtxF = new operation(fillerMat);
            for (int i = 0; i < ActionHandler.col; i++){
                mtxF.mtx_weight.get(Integer.parseInt(charFM[i][0])-1).set(Integer.parseInt(charFM[i][1])-1,Integer.parseInt(charFM[i][2]));
            }
            if (ActionHandler.ms==true) {
                ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                    fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrix(i),i ));
                }
                AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
            }
            if (ActionHandler.sr==true) {
                ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                    fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrixSR(i+1),i ));
                }
                AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
            }
            if (ActionHandler.ssr==true) {
                ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                    fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrixSSR(i),i ));
                }
                AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
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


}