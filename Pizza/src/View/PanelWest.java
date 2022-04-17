/*
    Author: <Nezar Sheikhi>
*/

package View;

import Controller.Controller;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;


public class PanelWest extends JPanel {

    private JList<String> orderList;

    private Controller controller;


    public PanelWest(Controller controller, int width, int height, int margin) {
        this.controller = controller;

        Border border = this.getBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(margin, margin, margin, margin);
        setBorder(new CompoundBorder(border, emptyBorder));
        //data has type Object[]

        Font font = new Font("New Times Roman", Font.PLAIN, 12);

        setBorder(BorderFactory.createTitledBorder("Order"));


        orderList = new JList<>();
        orderList.setFont(font);
        JScrollPane s = new JScrollPane(orderList);

        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(600-margin, height-2*margin));



        orderList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        add(s);


    }

    public void updatePriceLabel(int order ,double price) {
        setBorder(BorderFactory.createTitledBorder("Order"+order+"  Price: "+(price)));
    }
    public void updateOrderMenu(String[] drinkInfo) {
        orderList.setListData(drinkInfo);
    }
    public int getOrderIndex()
    {
        return orderList.getSelectedIndex();
    }
}