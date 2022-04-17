/*
    Author: <Nezar Sheikhi>
*/

package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PanelCustom extends JPanel {


    private double price;
    private int amount;
    private Controller controller;
    public PanelCustom(Controller controller) {
    this.controller= controller;
    }
    /**
     *  Read the new pizza metod läser information för att skapa en pizza av användaren med JOption Pan
     *   Det har en textfield som handlar namn av pizza och 8 checkbox kan man välja vad som helst för att
     *    bygga sin egen pizza.
     */

    public void readTheNewPizza() {

        price=100;
        amount =0;
        JTextField pizzaName = new JTextField(5);
        JCheckBox chTopping1 = new JCheckBox("Pepperoni 10kr");
        JCheckBox chTopping2 = new JCheckBox("Salami 12kr");
        JCheckBox chTopping3 = new JCheckBox("Spinach 6kr");
        JCheckBox chTopping4 = new JCheckBox("Beef 13kr");
        JCheckBox chTopping5 = new JCheckBox("Oregano 3kr");
        JCheckBox chTopping6 = new JCheckBox("Parmigiana 8kr");
        JCheckBox chTopping7 = new JCheckBox("Chicken 10kr");
        JCheckBox chTopping8 = new JCheckBox("Pineapple 5kr");

        JPanel myPanel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel =new JPanel();

        panel2.add(new JLabel("Give your special pizza a name "));
        panel2.add(pizzaName);
        panel2.add(new JLabel("Your pizza without additions will cost you "+price+"kr"));
        panel.add(chTopping1);
        panel.add(chTopping2);
        panel.add(chTopping3);
        panel.add(chTopping4);
        panel.add(chTopping5);
        panel.add(chTopping6);
        panel.add(chTopping7);
        panel.add(chTopping8);
        myPanel.setLayout(new BorderLayout());
        myPanel.add(panel2,BorderLayout.NORTH);
        myPanel.add(panel,BorderLayout.SOUTH);

        Font font = new Font("Consolas",Font.PLAIN,14);
        chTopping1.setFont(font);
        chTopping2.setFont(font);
        chTopping3.setFont(font);
        chTopping4.setFont(font);
        chTopping5.setFont(font);
        chTopping6.setFont(font);
        chTopping7.setFont(font);
        chTopping8.setFont(font);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Select your delicious addition for special Pizza",JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION){

            String name = pizzaName.getText();
            controller.setName(name);
            if (pizzaName.getText().isEmpty()){
                controller.setName("No name");
            }

            if (chTopping1.isSelected()){
                controller.setTopping1("Pepperoni");
                price+=10;
            }else if(!chTopping1.isSelected()){
                controller.setTopping1("");
            }

            if (chTopping2.isSelected()){
                controller.setTopping2("Salami");
                price+=12;
            }else if(!chTopping2.isSelected()){
                controller.setTopping2("");
            }

            if (chTopping3.isSelected()){
                controller.setTopping3("Spinach");
                price+=6;
            }else if(!chTopping3.isSelected()){
                controller.setTopping3("");
            }


            if (chTopping4.isSelected()){
                controller.setTopping4("Beef");
                price+=13;
            }else if(!chTopping4.isSelected()){
                controller.setTopping4("");
            }

            if (chTopping5.isSelected()){
                controller.setTopping5("Oregano");
                price+=3;
            }else if(!chTopping5.isSelected()){
                controller.setTopping5("");
            }

            if (chTopping6.isSelected()){
                controller.setTopping6("Parmigiana");
                price+=8;
            }else if(!chTopping6.isSelected()){
                controller.setTopping6("");
            }

            if (chTopping7.isSelected()){
                controller.setTopping7("Chicken");
                price+=10;
            }else if(!chTopping7.isSelected()){
                controller.setTopping7("");
            }

            if (chTopping8.isSelected()){
                controller.setTopping8("Pineapple");
                price+=5;
            }else if(!chTopping8.isSelected()){
                controller.setTopping8("");
            }
            if (chTopping1.isSelected()||chTopping2.isSelected()||chTopping3.isSelected()||chTopping4.isSelected()||
            chTopping5.isSelected()||chTopping6.isSelected()||chTopping7.isSelected()||chTopping8.isSelected()){
                double spPrice = price;

                controller.setSpPrice(spPrice);
            }else {
                JOptionPane.showMessageDialog(null, "You have chosen a Pizza without special additions ");
                controller.setName("Original Pizza");
                controller.setTopping1("Mozzarella,  ");
                controller.setTopping2("Tomato sauce,  ");
                controller.setTopping3("Paprika,   ");
                controller.setTopping4("Olives  ");
                controller.setSpPrice(price);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Have you changed your mind? It is Ok ");
            controller.setName("We hope you come back and create your special Pizza");
            controller.setTopping1("");
            controller.setTopping2("");
            controller.setTopping3("");
            controller.setTopping4("");
            controller.setTopping5("");
            controller.setTopping6("");
            controller.setTopping7("");
            controller.setTopping8("");
            controller.setSpPrice(0);
        }

    }

    /**
     *  Read alcohol metoden kontrollerar  ålder och kontrollerar  alkohol lista att visa eller inte beror på ålder
     *   det kopplat med tiden som finns på nätet  och räkna upp hur gammal är hen. Sen ge användaren möjlighet att
     *    beställa något från lista.
     */

    public void readAlcohol(){

        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField zField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Year:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Month:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Day:"));
        myPanel.add(zField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Insert your age", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION){
            if (!xField.getText().isEmpty()){
                int year=0;
                int month=0;
                int day=0;
                String txt1 = xField.getText();
                String txt2 = yField.getText();
                String txt3 = zField.getText();

                if (!txt1.isEmpty() || !txt2.isEmpty()||!txt3.isEmpty()){
                    year = Integer.parseInt(txt1);
                    month = Integer.parseInt(txt2);
                    day = Integer.parseInt(txt3);
                }


                if ((month > 12 )&&( month<0 )|| (day > 31)&&(day<0)){
                    JOptionPane.showMessageDialog(null, "Please insert correct age");

                } else{

                    LocalDate today = LocalDate.now();

                    LocalDate birthday = LocalDate.of(year,month, day);
                    long p2 = ChronoUnit.DAYS.between(birthday, today);
                    Period p = Period.between(birthday, today);

                    if((p.getYears()<0&&xField.getText().isEmpty())||(p.getMonths()<0&&yField.getText().isEmpty())||(p.getDays()<0&&zField.getText().isEmpty())){
                        JOptionPane.showMessageDialog(null, "Please insert correct age");
                    }else
                    if (p.getYears()>=18){
                        JOptionPane.showMessageDialog(null, "You are over 18 years,  your age is "+ p.getYears() + " years, " + p.getMonths() +
                                " months, and " + p.getDays() +
                                " days old.");
                        controller.alcoholList();

                    }else {
                        JOptionPane.showMessageDialog(null, "You are under 18 years,  your age is "+ p.getYears() + " years, " + p.getMonths() +
                                " months, and " + p.getDays() +
                                " days old.");
                    }

                }
            }else{
                JOptionPane.showMessageDialog(null, "Sorry you can't access to Alcohol if you haven't confirmed yor age");
            }


        }else {
            JOptionPane.showMessageDialog(null, "You can't shop alcohol if you haven't confirmed your age");
        }
    }

}
