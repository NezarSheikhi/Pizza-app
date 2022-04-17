/*
    Author: <Nezar Sheikhi>
*/

package View;

import javax.swing.*;
import Controller.Controller;

public class MainFrame extends JFrame{

    private int width = 1600;
    private int height= 600;

    Controller controller;
    MainPanel panel;
    public MainFrame(Controller controller){
        this.controller = controller;
        setupFrame();


    }
    public void setupFrame(){

        final int offsetX = width/5;
        final int offsetY = height/5;
        setSize(width,height);
        setTitle("Pizzas Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(offsetX,offsetY);

        panel = new MainPanel(controller,width,height);
        setContentPane(panel);
        setResizable(false);
        pack();
        setVisible(true);

    }

    public void updateList(String[] stringList) {
        panel.getPnlEast().updateDrinkMenu(stringList);
    }


    public int getListIndex() {
        return panel.getPnlEast().getListIndex();
    }

    public int getOrderIndex() {
        return panel.getPnlWest().getOrderIndex();
    }

    public void updateOrderList(String[] drinkInfo) {
        panel.getPnlWest().updateOrderMenu(drinkInfo);
    }

    public String getLestText() {
        return panel.getPnlEast().getInfo();
    }

    public void updatePrice(int order, double price) {
        panel.getPnlWest().updatePriceLabel(order,price);
    }

    public void btnHideDrink() {
        panel.getPnlSouth().btnDrink.setVisible(false);
    }

    public void btnShowDrink() {
        panel.getPnlSouth().btnDrink.setVisible(true);
    }

    public void btnHideAlcohol() { panel.getPnlSouth().btnAlcohol.setVisible(false); }

    public void btnShowAlcohol() { panel.getPnlSouth().btnAlcohol.setVisible(true); }

    public void btnHideCreatePizza() { panel.getPnlSouth().btnCreatePizza.setVisible(false); }

    public void ShowCreatePizza() { panel.getPnlSouth().btnCreatePizza.setVisible(true); }

    public void btnShowAddToOrder() { panel.getPnlSouth().btnAddToOrder.setVisible(true);}

    public void btnHideAddToOrder() { panel.getPnlSouth().btnAddToOrder.setVisible(false);}

    public void borderChangeNamePizza() {
        panel.getPnlEast().setBorder(BorderFactory.createTitledBorder("Pizza"));
    }

    public void borderChangeNameDrink() {
        panel.getPnlEast().setBorder(BorderFactory.createTitledBorder("Drink"));
    }


    public void borderChangeNameAlcohol() {
        panel.getPnlEast().setBorder(BorderFactory.createTitledBorder("Alcohol"));
    }

    public void readTheNewPizza() {
        panel.getPnlCustom().readTheNewPizza();
    }

    public void readAlcohol() {
        panel.getPnlCustom().readAlcohol();
    }


}
