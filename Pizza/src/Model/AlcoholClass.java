/*
    Author: <Nezar Sheikhi>
*/

package Model;

public class AlcoholClass extends DrinkClass{


    public AlcoholClass(String name, double alcoholContent ,double drPrice){
        super(name, alcoholContent ,drPrice);
    }
    public String getDescriptionStringWithAlcWithoutAmount(){
        String out = "";
        out += getName()+"         Alcohol concentrations is: ";
        out += getAlcoholContent()+" %             ";
        out += getDrPriceWithAmount()+" kr ";
        return out;
    }

    public String getDescriptionStringWithAlc(){
        String out = "";
        out += getName()+":        Alcohol concentrations is: ";
        out += getAlcoholContent()+" %             ";
        out += getDrPriceWithAmount()+" kr      ";
        out += getAmount()+"pcs";
        return out;
    }

    public  double getDrPriceWithAmount(){
        double out = getDrPrice();
        if (super.getAmount()>0){
            out*=super.getAmount();
        }
        return out;
    }

}
