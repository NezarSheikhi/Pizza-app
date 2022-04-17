/*
    Author: <Nezar Sheikhi>
*/

package View;

import Controller.Controller;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;



public class PanelEast extends JPanel {

    private JList<String> drinkList;

    private Controller controller;

    public PanelEast(Controller controller, int width, int height, int margin)
    {
        this.controller = controller;

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));
         //data has type Object[]

        Font font = new Font("New Times Roman", Font.PLAIN, 14);
        setBorder(BorderFactory.createTitledBorder("Drink"));



        drinkList = new JList<>();
        drinkList.setFont(font);


        JScrollPane s = new JScrollPane(drinkList);


        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(600-margin, height-2*margin));


        drinkList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        add(s);

    }


    public int getListIndex()
    {
        return drinkList.getSelectedIndex();
    }


    public void updateDrinkMenu(String[] stringList)
    {
        drinkList.setListData(stringList);
    }


    public String getInfo() {
        return drinkList.getSelectedValue();
    }
}

