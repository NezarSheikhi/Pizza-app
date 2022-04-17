/*
    Author: <Nezar Sheikhi>
*/

package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSouth extends JPanel{
    private Controller controller;

    JButton btnDrink , btnAlcohol,btnCreatePizza,btnAddToOrder,ntnNuOfOrder,btnExit;

    public PanelSouth(Controller controller){
        this.controller = controller;


        creatComponents();

    }

    private void creatComponents(){
        JPanel pnlButtons = new JPanel();
        Dimension dim = new Dimension(50,50);

        btnDrink= new JButton("Add to Order");
        btnDrink.setSize(dim);
        add(btnDrink);

        btnAlcohol = new JButton("Add to Order");
        btnAlcohol.setSize(dim);
        add(btnAlcohol);

        btnCreatePizza = new JButton("Create a Pizza");
        btnCreatePizza.setSize(dim);
        add(btnCreatePizza);

        btnAddToOrder = new JButton("Add to Order");
        btnAddToOrder.setSize(dim);
        add(btnAddToOrder);

        ntnNuOfOrder = new JButton("Done");
        ntnNuOfOrder.setSize(dim);
        add(ntnNuOfOrder);

        btnExit = new JButton("Exit");
        btnExit.setSize(dim);
        add(btnExit);

        pnlButtons.add(btnDrink);
        pnlButtons.add(btnAlcohol);
        pnlButtons.add(btnCreatePizza);
        pnlButtons.add(ntnNuOfOrder);
        pnlButtons.add(btnExit);

        btnAlcohol.setVisible(false);
        btnCreatePizza.setVisible(false);
        add(pnlButtons);
        addListener();

    }
    private void addListener(){
        ActionListener listener = new ButtonActionListener();
        btnDrink.addActionListener(listener);
        btnCreatePizza.addActionListener(listener);
        btnAlcohol.addActionListener(listener);
        btnAddToOrder.addActionListener(listener);
        ntnNuOfOrder.addActionListener(listener);
        btnExit.addActionListener(listener);
    }



    class ButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
             if (e.getSource()== btnDrink)
            {
                controller.buttonPressed(ButtonType.Drink);
            }else if (e.getSource() == btnAlcohol)
            {
                controller.buttonPressed(ButtonType.Alcohol);
            }else if (e.getSource()==btnCreatePizza )
            {
                controller.buttonPressed(ButtonType.CreatePizza);
            }else if (e.getSource() ==btnAddToOrder){
                controller.buttonPressed((ButtonType.AddToOrder));
            }
            else  if (e.getSource() ==ntnNuOfOrder){
                 controller.buttonPressed((ButtonType.NuOfOrder));
             }
            else if (e.getSource() == btnExit)
                controller.buttonPressed(ButtonType.Exit);

        }
    }
}
