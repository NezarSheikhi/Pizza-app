/*
    Author: <Nezar Sheikhi>
*/

package Model;

public class DrinkClass extends FoodItem{

    public DrinkClass(String name ,double drPrice){
        super(name ,drPrice);
    }
    public DrinkClass(String name, double alcoholContent ,double drPrice){
        super(name, alcoholContent ,drPrice);
    }

    public String getDescriptionString(){
        String out = "";
        out += getName()+"                                   ";
        out += getDrPrice()+" kr ";
        return out;
    }
    public String getDescriptionStringWithAlc(){

        return null;
    }

    @Override
    public String getDescriptionOfPizzaString() {
        return null;
    }


    public String getDescriptionStringWithAmount() {
        String out = "";
        out += getName()+"                                      ";
        out += getDrPriceWithAmount()+" kr            Amount: ";
        out += getAmount()+" Pcs";
        return out;
    }

    @Override
    public double getPricePizza() {
        return 0;
    }


    public  double getDrPriceWithAmount(){
        double out = getDrPrice();
        if (super.getAmount()>0){
            out*=super.getAmount();
        }
        return out;
    }

    @Override
    public String toString(){
        return String.format("%s %s ",getName(),getDrPrice());
    }
}
