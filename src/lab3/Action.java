package lab3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Action implements ActionListener {
    static int row;
    static int col;


    public void actionPerformed(ActionEvent e) {
        String bigString = OperationHandler.getFirstMatrix().getText();
        if (bigString.length() != 0) {

            String[][] charFM = splitting(bigString);
            if (OperationHandler.getAddButton().isSelected() == true)
            {
                if ( ActionHandler.ms == true)
                {
                    ActionHandler.mtxF.Add(Integer.parseInt(charFM[0][0])-1,Integer.parseInt(charFM[0][1])-1);
                    if (WeightPanelHandler.weidth==true)
                    {
                        ActionWeight.mtxF.AddWeight(Integer.parseInt(charFM[0][0])-1 ,Integer.parseInt(charFM[0][1])-1, Integer.parseInt(charFM[0][2]));
                        ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                        for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                            fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrix(i),i ));
                        }
                        AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
                    }
                }
                if (ActionHandler.sr == true)
                {
                    ActionHandler.mtxF = new operation(ActionHandler.mtxF.AddSR(Integer.parseInt(charFM[0][0]),Integer.parseInt(charFM[0][1])),ActionHandler.mtxF.size()+1);
                    if (WeightPanelHandler.weidth==true)
                    {
                        ActionWeight.mtxF.AddWeight(Integer.parseInt(charFM[0][0])-1 ,Integer.parseInt(charFM[0][1])-1, Integer.parseInt(charFM[0][2]));
                        ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                        for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                            fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrixSR(i+1),i ));
                        }
                        AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
                    }
                }
                if (ActionHandler.ssr == true)
                {
                    ActionHandler.mtxF = new operation(ActionHandler.mtxF.AddSSR(Integer.parseInt(charFM[0][0]) -1 ,Integer.parseInt(charFM[0][1])),ActionHandler.mtxF.AddSSR(Integer.parseInt(charFM[0][0]) -1 ,Integer.parseInt(charFM[0][1])).size());
                    if (WeightPanelHandler.weidth==true)
                    {
                        ActionWeight.mtxF.AddWeight(Integer.parseInt(charFM[0][0])-1 ,Integer.parseInt(charFM[0][1])-1, Integer.parseInt(charFM[0][2]));
                        ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                        for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                            fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrixSSR(i),i ));
                        }
                        AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
                    }
                }
                AnswerHandler.getAnswerLabel().setText(ActionHandler.mtxF.mtx.toString());
            }

            if (OperationHandler.getDelButton().isSelected() == true){

                if (ActionHandler.ms == true)
                {
                    ActionHandler.mtxF.Del(Integer.parseInt(charFM[0][0])-1,Integer.parseInt(charFM[0][1])-1);
                    if (WeightPanelHandler.weidth==true)
                    {
                        ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                        for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                            fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrix(i),i ));
                        }
                        AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
                    }
                }
                if (ActionHandler.sr == true)
                {
                    ActionHandler.mtxF = new operation(ActionHandler.mtxF.DelSR(Integer.parseInt(charFM[0][0]),Integer.parseInt(charFM[0][1])),ActionHandler.mtxF.size()-1);
                    if (WeightPanelHandler.weidth==true)
                    {

                        ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                        for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                            fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrixSR(i+1),i ));
                        }
                        AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
                    }
                }
                if (ActionHandler.ssr == true)
                {
                    ActionHandler.mtxF = new operation(ActionHandler.mtxF.DelSSR(Integer.parseInt(charFM[0][0])-1,Integer.parseInt(charFM[0][1])),ActionHandler.mtxF.DelSSR(Integer.parseInt(charFM[0][0])-1,Integer.parseInt(charFM[0][1])).size());
                    if (WeightPanelHandler.weidth==true)
                    {
                        ArrayList<ArrayList<ArrayList<Integer>>> fillerMatrix = new ArrayList<>(ActionHandler.mtxF.mtx.size());
                        for (int i = 0; i < ActionHandler.mtxF.mtx.size(); i++) {
                            fillerMatrix.add(i, ActionWeight.mtxF.infoMatrixWeight(ActionHandler.mtxF.infoMatrixSSR(i),i ));
                        }
                        AnswerHandler.getAnswerLabel1().setText(fillerMatrix.toString());
                    }
                }
                AnswerHandler.getAnswerLabel().setText(ActionHandler.mtxF.mtx.toString());
            }



        }
    }

    private String[][] splitting(String bigString) {
        String[] strOne = bigString.split("\n");
        String[][] strTwo = new String[strOne.length][];
        for (int i = 0 ; i < strTwo.length; i++) strTwo[i] = strOne[i].split(" ");
        return strTwo;
    }


}