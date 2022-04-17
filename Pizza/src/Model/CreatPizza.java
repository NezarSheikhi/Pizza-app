/*
    Author: <Nezar Sheikhi>
*/

package Model;

public class CreatPizza extends FoodItem{


    @Override
    public String getDescriptionString() {
        return null;
    }

    @Override
    public String getDescriptionStringWithAlc() {
        return null;
    }
    public String getDescriptionOfPizzaString(){
        String out = "";
        out += getName()+":  ";
        out += getTopping1()+" ";
        out += getTopping2()+" ";
        out += getTopping3()+" ";
        out += getTopping4()+" ";
        out += getTopping5()+" ";
        out += getTopping6()+" ";
        out += getTopping7()+" ";
        out += getTopping8()+" ";
        out += getSpPrice()+" kr";
        return out;
    }
    public String getDescriptionOfPizzaStringWithAmount(){
        String out = "";
        out += getName()+":  ";
        out += getTopping1()+" ";
        out += getTopping2()+" ";
        out += getTopping3()+" ";
        out += getTopping4()+" ";
        out += getTopping5()+" ";
        out += getTopping6()+" ";
        out += getTopping7()+" ";
        out += getTopping8()+" ";
        out += getPrice()+" kr  Amount:";
        out += getAmount()+"pcs";
        return out;
    }

    @Override
    public String toString()
    {
        String str = String.format("%s ","");
        return str;
    }


    @Override
    public double getPricePizza() {
        return 0;
    }

    public double getPrice(){
        double out =getSpPrice();
        if (getAmount()>0){
            out*=getAmount();
        }
        return out;
    }

}
