/*
    Author: <Nezar Sheikhi>
*/

package Controller;
import View.*;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class Controller {
    MainFrame view;
    private int orderNu;
    private double totalPris;
    private PizzaClass pizzaClass1=null;
    private PizzaClass pizzaClass2=null;
    private PizzaClass pizzaClass3=null;
    private PizzaClass pizzaClass4=null;
    private PizzaClass pizzaClass5=null;
    private CreatPizza creatPizza =null;
    private DrinkClass drinkClass1=null;
    private DrinkClass drinkClass2=null;
    private DrinkClass drinkClass3=null;
    private DrinkClass drinkClass4=null;
    private DrinkClass drinkClass5=null;
    private AlcoholClass alcoholClass1 = null;
    private AlcoholClass alcoholClass2 = null;
    private AlcoholClass alcoholClass3 = null;
    private AlcoholClass alcoholClass4 = null;
    private int amount;
    public Controller() {
        view = new MainFrame(this);
        double spPrice=0.0;
        setSpPrice(spPrice);
        setAmount(amount);
        buttonRadioPressed(ButtonType.Pizza);
        orderNu=1;
        totalPris=0.0;

    }

    ArrayList<String>pizza = new ArrayList<>();
    ArrayList<String>drink = new ArrayList<>();
    ArrayList<String>alcohol = new ArrayList<>();
    ArrayList<String>price = new ArrayList<>();
    ArrayList<String>order =new ArrayList<>();

    /**
     *  Tre radio button byter mellan  tre listor. En lista av pizza och en för dricker och en för alkohol
     *   for varje tryck radera knappen gamla listan och skriva ut den nya och samtidigt byter namn för
     *    border och byter  knappen som skulle kontrollerar add to order listan.
     */
    public Component buttonRadioPressed(ButtonType buttonType) {

        switch (buttonType) {

            case Pizza:

                pizza.clear();

                pizzaClass1 = new PizzaClass("Vegetarian: ","Mozzarella","Tomato souse","Paprika","Spinach             ",100);
                pizzaClass2 = new PizzaClass("Chicken:      ","Parmesan","Tomato souse","Mushroom","Chicken slice ",120);
                pizzaClass3 = new PizzaClass("Beef:            ","Mozzarella","Tomato souse","Olive","Beef slice                ",125);
                pizzaClass4 = new PizzaClass("Sea Food:    ","Cheddar","Tomato souse","Olive","Shrimp                       ",115);
                pizzaClass5 = new PizzaClass("Kebab:         ","Mozzarella","Tomato souse","Mushroom","Kebab           ",110);
                pizza.add(0,pizzaClass1.getDescriptionString());
                pizza.add(1,pizzaClass2.getDescriptionString());
                pizza.add(2,pizzaClass3.getDescriptionString());
                pizza.add(3,pizzaClass4.getDescriptionString());
                pizza.add(4,pizzaClass5.getDescriptionString());
                pizza.add(5,creatPizza.toString());

                view.updateList(pizza.toArray(new String[0]));
                view.btnHideDrink();
                view.btnHideAlcohol();
                view.btnShowAddToOrder();
                view.ShowCreatePizza();
                view.borderChangeNamePizza();
                break;

            case Drink:

                drink.clear();
                drinkClass1 = new DrinkClass("Juice- Fresh:                                      ",25);
                drinkClass2 = new DrinkClass("Water- Ramlosa:                               ",15);
                drinkClass3 = new DrinkClass("Coca-Cola Zero:                               ",18);
                drinkClass4 = new DrinkClass("Fanta- Orange:                                 ",20);
                drinkClass5 = new DrinkClass("Lemon- Fresh:                                  ",33);
                drink.add(0,drinkClass1.getDescriptionString());
                drink.add(1,drinkClass2.getDescriptionString());
                drink.add(2,drinkClass3.getDescriptionString());
                drink.add(3,drinkClass4.getDescriptionString());
                drink.add(4,drinkClass5.getDescriptionString());

                view.updateList(drink.toArray(new String[0]));
                view.btnShowDrink();
                view.btnHideAlcohol();
                view.btnHideAddToOrder();
                view.btnHideCreatePizza();
                view.borderChangeNameDrink();
                break;


            case Alcohol:
                alcohol.clear();
                drink.clear();
                pizza.clear();
                view.borderChangeNameAlcohol();
                view.updateList(alcohol.toArray(new String[0]));
                view.btnHideDrink();
                view.btnShowAlcohol();
                view.btnHideAddToOrder();
                view.btnHideCreatePizza();
                view.readAlcohol();

                break;

        }
        return null;
    }


    /**
     *  Skapar multi knappar för att skapa objektet av pizza, dricker, alkohol samt skapa en special pizza och
     *   sparas dem i en ArrayLista. Varje typ skulle sparas i sin lista genom att klicka
     *    på knappen. Samtidigt förbereda  listan priset genom index av item.
     */
    public Component buttonPressed(ButtonType button){

        int index1=0;
        int index = view.getListIndex();
        switch (button){

            case CreatePizza:

                view.readTheNewPizza();
                pizza.set(5,creatPizza.getDescriptionOfPizzaString());
                view.updateList(pizza.toArray(new String[0]));
                view.btnShowAddToOrder();
                break;

            case AddToOrder:

                JTextField amountCount = new JTextField(5);
                JPanel panel = new JPanel();
                panel.add(new JLabel("How many pizza you want to order"));
                panel.add(amountCount);
                int result1 = JOptionPane.showConfirmDialog(null,panel ,
                        "Select quantity of Pizzas items", JOptionPane.OK_CANCEL_OPTION);
                if (result1 == JOptionPane.OK_OPTION &&!(amountCount.getText().isEmpty())){

                        amount= Integer.parseInt(amountCount.getText());
                        pizzaClass1.setAmount(amount);
                        pizzaClass2.setAmount(amount);
                        pizzaClass3.setAmount(amount);
                        pizzaClass4.setAmount(amount);
                        pizzaClass5.setAmount(amount);
                        creatPizza.setAmount(amount);

                    index1=0;
                    if (validateIndexOfPizza(index)){
                        if (index==0){
                            order.add(pizzaClass1.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(pizzaClass1.getPriceWithAmount()));

                        }else if (index==1){
                            order.add(pizzaClass2.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(pizzaClass2.getPriceWithAmount()));
                        }else if (index==2){
                            order.add(pizzaClass3.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(pizzaClass3.getPriceWithAmount()));
                        }else if (index==3){
                            order.add(pizzaClass4.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(pizzaClass4.getPriceWithAmount()));
                        }else if (index==4){
                            order.add(pizzaClass5.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(pizzaClass5.getPriceWithAmount()));
                        }else if (index==5){
                            order.add(creatPizza.getDescriptionOfPizzaStringWithAmount());
                            price.add(index1, String.valueOf(creatPizza.getPrice()));
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "No order confirmed");
                }

            break;

            case Drink:
                JTextField amountCount1 = new JTextField(5);
                JPanel panel1 = new JPanel();
                panel1.add(new JLabel("How many drinker you want to order"));
                panel1.add(amountCount1);
                int result2 = JOptionPane.showConfirmDialog(null,panel1 ,
                        "Select quantity of drinks items", JOptionPane.OK_CANCEL_OPTION);
                if (result2 == JOptionPane.OK_OPTION &&!(amountCount1.getText().isEmpty())){

                    amount= Integer.parseInt(amountCount1.getText());
                    drinkClass1.setAmount(amount);
                    drinkClass2.setAmount(amount);
                    drinkClass3.setAmount(amount);
                    drinkClass4.setAmount(amount);
                    drinkClass5.setAmount(amount);

                    index1=0;

                    if (validateIndexOfDrink(index)){
                        if (index==0){
                            order.add(drinkClass1.getDescriptionStringWithAmount());
                            price.add(index, String.valueOf(drinkClass1.getDrPriceWithAmount()));
                        }else if (index==1){
                            order.add(drinkClass2.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(drinkClass2.getDrPriceWithAmount()));
                        }else if (index==2){
                            order.add(drinkClass3.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(drinkClass3.getDrPriceWithAmount()));
                        }else if (index==3){
                            order.add(drinkClass4.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(drinkClass4.getDrPriceWithAmount()));
                        }if (index==4){
                            order.add(drinkClass5.getDescriptionStringWithAmount());
                            price.add(index1, String.valueOf(drinkClass5.getDrPriceWithAmount()));
                        }
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "No order confirmed");
                }

                break;
            case Alcohol:
                JTextField amountCount2 = new JTextField(5);
                JPanel panel2 = new JPanel();
                panel2.add(new JLabel("How many alcohol you want to order"));
                panel2.add(amountCount2);
                int result3 = JOptionPane.showConfirmDialog(null,panel2 ,
                        "Select quantity of alcohol items", JOptionPane.OK_CANCEL_OPTION);
                if (result3 == JOptionPane.OK_OPTION &&!(amountCount2.getText().isEmpty())&&validateIndexOfAlcohol(index)){

                    amount= Integer.parseInt(amountCount2.getText());
                    alcoholClass1.setAmount(amount);
                    alcoholClass2.setAmount(amount);
                    alcoholClass3.setAmount(amount);
                    alcoholClass4.setAmount(amount);

                    index1=0;

                    if (validateIndexOfAlcohol(index)){
                        if (index==0){
                            order.add(alcoholClass1.getDescriptionStringWithAlc());
                            price.add(index, String.valueOf(alcoholClass1.getDrPriceWithAmount()));
                        }else if (index==1){
                            order.add(alcoholClass2.getDescriptionStringWithAlc());
                            price.add(index1, String.valueOf(alcoholClass2.getDrPriceWithAmount()));
                        }else if (index==2){
                            order.add(alcoholClass3.getDescriptionStringWithAlc());
                            price.add(index1, String.valueOf(alcoholClass3.getDrPriceWithAmount()));
                        }else if (index==3){
                            order.add(alcoholClass4.getDescriptionStringWithAlc());
                            price.add(index1, String.valueOf(alcoholClass4.getDrPriceWithAmount()));
                        }
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "No order confirmed");
                }

                break;
            case NuOfOrder:
                order.add("The total price of Order "+orderNu+" is "+totalPris);
                orderNu =orderNu+1;
                price.clear();
                break;
            case Exit:
                int option = JOptionPane.showConfirmDialog(null,"Exit, Are you sure");
                if (option ==0)
                    System.exit(0);
                break;
        }

        totalPris = price.stream().mapToDouble(s ->Double.parseDouble(s)).sum();
        view.updateOrderList(order.toArray(new String[order.size()]));
        view.updatePrice(orderNu, totalPris);
        return null;
    }




    /**
     *  AlcoholList metoden skapar en list av Alkohol.Det anropar av alkohol radio button och man bevisa sin
     *   ålder att hen är över 18 år. Det listan flyttar till PanelCustom som där metoden kontrollerar  det.
     *    Jag har skapat det har för att view känner inte modelen.
     */
    public void alcoholList(){
        alcohol.clear();
        alcoholClass1 = new AlcoholClass("Beer:             ",3.50,30);
        alcoholClass2 = new AlcoholClass("Whisky:         ",12.0,180);
        alcoholClass3 = new AlcoholClass("Champagne:",4.00,230);
        alcoholClass4 = new AlcoholClass("Wine:             ",6.80,150);

        alcohol.add(0,alcoholClass1.getDescriptionStringWithAlcWithoutAmount());
        alcohol.add(1,alcoholClass2.getDescriptionStringWithAlcWithoutAmount());
        alcohol.add(2,alcoholClass3.getDescriptionStringWithAlcWithoutAmount());
        alcohol.add(3,alcoholClass4.getDescriptionStringWithAlcWithoutAmount());

        view.updateList(alcohol.toArray(new String[0]));
        view.borderChangeNameAlcohol();
    }


    /**
     *  Tre boolean metoder för validateIndex, varje  en är ansvarig för att ge index nummer
     *   for pizza eller dricker eller alkohol som vi välja  och returnerar  en int av index och returnerar också om
     *    är det stämmer att vi har valt  en sak av listan eller inte.
     */

    private boolean validateIndexOfPizza(int index) {
        boolean ok = true;
        if  ( (index < 0) || (index >= pizza.size()) )
        {
            JOptionPane.showMessageDialog(null, "Select an item in the list!");
            ok = false;
        }
        return ok;
    }

    private boolean validateIndexOfDrink(int index)
    {
        boolean ok = true;
        if  ( (index < 0) || (index >= drink.size()) )
        {
            JOptionPane.showMessageDialog(null, "Select an item in the list!");
            ok = false;
        }
        return ok;
    }

    private boolean validateIndexOfAlcohol(int index)
    {
        boolean ok = true;
        if  ( (index < 0) || (index >= alcohol.size()) )
        {
            JOptionPane.showMessageDialog(null, "Select an item in the list!");
            ok = false;
        }
        return ok;
    }


    /**
     *  Setter metoder skickar information  från view till modelen  creat pizza class genom kontrollen.
     *   Alla setter metoden använder för att skapa en pizza av användaren 9 av de stringa som handlar namn
     *   och topping och en double för priset.
     */
//<editor-fold desc="getters and setters">

    public void setName(String name) {

        creatPizza.setName(name);
    }


    public void setTopping1(String topping1) {

        creatPizza.setTopping1(topping1);
    }


    public void setTopping2(String topping2) {

        creatPizza.setTopping2(topping2);
    }


    public void setTopping3(String topping3) {

        creatPizza.setTopping3(topping3);
    }


    public void setTopping4(String topping4) {

        creatPizza.setTopping4(topping4);
    }


    public void setTopping5(String topping5) {

        creatPizza.setTopping5(topping5);
    }


    public void setTopping6(String topping6) {

        creatPizza.setTopping6(topping6);
    }


    public void setTopping7(String topping7) {

        creatPizza.setTopping7(topping7);
    }


    public void setTopping8(String topping8) {

        creatPizza.setTopping8(topping8);
    }


    public void setSpPrice(double spPrice) {
        if(creatPizza == null)
            creatPizza = new CreatPizza();
        creatPizza.setSpPrice(spPrice);
    }

    public void setAmount(int amount) {

        this.amount= amount;

    }

    public double getTotalPris() {
        return totalPris;
    }

    public void setTotalPris(double totalPris) {
        this.totalPris = totalPris;
    }
    //</editor-fold>
}


