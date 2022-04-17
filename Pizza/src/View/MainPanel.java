/*
    Author: <Nezar Sheikhi>
*/

package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    private Controller controller;
    private int width;
    private int height;



    private PanelNorth pnlNorth;
    private PanelWest pnlWest;
    private PanelSouth pnlSouth;
    BorderLayout layout;
    private PanelEast pnlEast;
    private PanelCustom pnlCustom;
    public MainPanel (Controller controller, int width, int height){
        this.controller = controller;
        this.width = width;
        this.height = height;

        setupPanel();
    }

    private void setupPanel(){
        layout = new BorderLayout();
        setLayout(layout);

        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(new CompoundBorder(border,margin));

        pnlNorth = new PanelNorth(controller);
        add(pnlNorth, BorderLayout.NORTH);
        pnlEast = new PanelEast(controller,6* width/10, 8*height/10, 6);
        add(pnlEast,BorderLayout.WEST);

        pnlWest = new PanelWest(controller,6* width/10, 8*height/10, 6);
        add(pnlWest, BorderLayout.EAST);

        pnlSouth = new PanelSouth(controller);
        add(pnlSouth, BorderLayout.SOUTH);

        pnlCustom = new PanelCustom(controller);

    }

    public PanelNorth getPnlNorth() {
        return pnlNorth;
    }

    public PanelCustom getPnlCustom(){return pnlCustom;}
    public PanelSouth getPnlSouth() {
        return pnlSouth;
    }

    public PanelEast getPnlEast() {
        return pnlEast;
    }

    public PanelWest getPnlWest() { return pnlWest;
    }
}
