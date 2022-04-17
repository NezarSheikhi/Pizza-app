/*
    Author: <Nezar Sheikhi>
*/

package Model;

public interface IFoodItem {

    int getAmount();
    void setAmount(int amount);
    double getPricePizza();
    void setPricePizza(double pricePizza);
    double getPrice();
    void setSpPrice(double spPrice);
    double getSpPrice();
    void setAlcoholContent(double alcoholContent);
    double getAlcoholContent();
    void setName(String name);
    String getName();
    void setTopping1(String topping1);
    String getTopping1();
    void setTopping2(String topping2);
    String getTopping2();
    void setTopping3(String topping3);
    String getTopping3();
    void setTopping4(String topping4);
    String getTopping4();
    void setTopping5(String topping5);
    String getTopping5();
    void setTopping6(String topping6);
    String getTopping6();
    void setTopping7(String topping7);
    String getTopping7();
    void setTopping8(String topping8);
    String getTopping8();
    String getDescriptionString();
    String getDescriptionStringWithAlc();
    String getDescriptionOfPizzaString();


}

