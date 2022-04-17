/*
    Author: <Nezar Sheikhi>
*/

package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelNorth extends JPanel {

    private Controller controller;
    private JRadioButton rbtnDrink;
    private JRadioButton rbtnPizza;
    private JRadioButton rbtnAlcohol;
    private JRadioButton rbtnCreatePizza;

    public PanelNorth(Controller controller){
        this.controller = controller;


        rbtnDrink = new JRadioButton("Drink");
        rbtnPizza = new JRadioButton("Pizza");
        rbtnAlcohol= new JRadioButton("Alcohol");
        rbtnCreatePizza= new JRadioButton("Create a Pizza");
        rbtnPizza.setSelected(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtnDrink);
        buttonGroup.add(rbtnPizza);
        buttonGroup.add(rbtnAlcohol);
        buttonGroup.add(rbtnCreatePizza);


        add(rbtnPizza);
        add(rbtnDrink);
        add(rbtnAlcohol);
        addListener();

    }
    private void addListener() {
        ActionListener listener = new ButtonActionListener();
        rbtnDrink.addActionListener(listener);
        rbtnPizza.addActionListener(listener);
        rbtnAlcohol.addActionListener(listener);
        rbtnCreatePizza.addActionListener(listener);
    }

    class ButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e)

        {

            if (e.getSource() == rbtnDrink){

                controller.buttonRadioPressed(ButtonType.Drink);

            }

            else if (e.getSource()== rbtnPizza)
            {

                controller.buttonRadioPressed(ButtonType.Pizza);

            }else if (e.getSource()== rbtnAlcohol)
            {
                controller.buttonRadioPressed(ButtonType.Alcohol);
            }
        }
    }
}
