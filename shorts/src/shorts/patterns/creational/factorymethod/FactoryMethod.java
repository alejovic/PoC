package shorts.patterns.creational.factorymethod;

// product
interface Burger {
    void prepare();
}

// concrete implementation
class ItalianBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Italian preparing a burger");
    }
}

// product
interface Pizza {
    void prepare();
}

// concrete implementation
class ItalianPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Italian preparing a Pizza");
    }
}

// creator
abstract class  Restaurant {
    abstract Pizza createPizza();
    abstract Burger createBurger();
}

//concrete creator
class ItalianRestaurant extends Restaurant {

    @Override
    public Pizza createPizza() {
        return new ItalianPizza();
    }

    @Override
    Burger createBurger() {
        return new ItalianBurger();
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        Restaurant restaurant = new ItalianRestaurant();
        restaurant.createBurger().prepare();
        restaurant.createPizza().prepare();
    }

}
