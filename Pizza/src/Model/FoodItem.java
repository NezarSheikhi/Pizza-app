/*
    Author: <Nezar Sheikhi>
*/

package Model;

public abstract class FoodItem  implements IFoodItem{


    private double price;
    private String name;
    private String topping1;
    private String topping2;
    private String topping3;
    private String topping4;
    private String topping5;
    private String topping6;
    private String topping7;
    private String topping8;
    private int amount;
    private double spPrice;
    private double pricePizza;
    private double drPrice;
    private double alcoholContent;
    public FoodItem() {

    }
    public FoodItem(String name ,double drPrice) {
        setName(name);
        setDrPrice(drPrice);
    }
    public FoodItem(String name,double alcoholContent ,double drPrice){
        setName(name);
        setAlcoholContent(alcoholContent);
        setDrPrice(drPrice);
    }
    public FoodItem (String name, String topping1, String topping2, String topping3, String topping4,double pricePizza){
        setName(name);
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.topping4 = topping4;
        setPricePizza(pricePizza);
    }

//<editor-fold desc="getters and setters">


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopping1() {
        return topping1;
    }

    public void setTopping1(String topping1) {
        this.topping1 = topping1;
    }

    public String getTopping2() {
        return topping2;
    }

    public void setTopping2(String topping2) {
        this.topping2 = topping2;
    }

    public String getTopping3() {
        return topping3;
    }

    public void setTopping3(String topping3) {
        this.topping3 = topping3;
    }

    public String getTopping4() {
        return topping4;
    }

    public void setTopping4(String topping4) {
        this.topping4 = topping4;
    }

    public String getTopping5() {
        return topping5;
    }

    public void setTopping5(String topping5) {
        this.topping5 = topping5;
    }

    public String getTopping6() {
        return topping6;
    }

    public void setTopping6(String topping6) {
        this.topping6 = topping6;
    }

    public String getTopping7() {
        return topping7;
    }

    public void setTopping7(String topping7) {
        this.topping7 = topping7;
    }

    public String getTopping8() {
        return topping8;
    }

    public void setTopping8(String topping8) {
        this.topping8 = topping8;
    }

    public double getSpPrice() {
        return spPrice;
    }

    public void setSpPrice(double spPrice) {
        this.spPrice = spPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPricePizza(double pricePizza) {
        this.pricePizza = pricePizza;
    }
    public double getPricePizza(){
        return pricePizza;
    }

    public double getDrPrice() {
        return drPrice;
    }

    public void setDrPrice(double drPrice) {
        this.drPrice = drPrice;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public int getAmount(){return  amount;};

    public void setAmount(int amount){ this.amount = amount;}

    //</editor-fold>

    public abstract String getDescriptionString();
    public abstract String getDescriptionStringWithAlc();

    public abstract String getDescriptionOfPizzaString();


}
