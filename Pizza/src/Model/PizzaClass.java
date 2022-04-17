/*
    Author: <Nezar Sheikhi>
*/

package Model;

public class PizzaClass extends FoodItem{




    public PizzaClass (String name, String topping1, String topping2, String topping3, String topping4,double pricePizza){
        super(name,topping1,topping2,topping3,topping4,pricePizza);
    }



    public String getDescriptionString(){
        String out = "";
        out += getName()+"  ";
        out += getTopping1()+"  ";
        out += getTopping2()+"  ";
        out += getTopping3()+"  ";
        out += getTopping4()+"  ";
        out += getPricePizza()+" kr ";
        return out;
    }
    public String getDescriptionStringWithAmount(){
        String out = "";
        out += getName()+"  ";
        out += getTopping1()+"  ";
        out += getTopping2()+"  ";
        out += getTopping3()+"  ";
        out += getTopping4()+"  ";
        out += getPriceWithAmount()+" kr  Amount: ";
        out += getAmount()+"pcs";
        return out;
    }

    @Override
    public String getDescriptionStringWithAlc() {
        return null;
    }

    @Override
    public String getDescriptionOfPizzaString() {
        return null;
    }


    public double getPriceWithAmount(){
        double out = getPricePizza();
        if (super.getAmount()>0){
            out*=super.getAmount();
        }
        return out;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s %s %s %s",getName(),getTopping1(),getTopping2(),getTopping3(),getTopping4(),getPricePizza());
    }

}
