package shorts.patterns.creational.abstractfactory;

// product
interface Burger {
    void prepare();
}

// concrete implementation
class ItaianBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Italian preparing a burger");
    }
}

// creator
abstract class Restaurant {
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    abstract Burger createBurger();
}

//concrete creator
class ItalianRestaurant extends Restaurant {

    @Override
    Burger createBurger() {
        return new ItaianBurger();
    }
}

public class AbstractFactory {

    public static void main(String[] args) {
        Restaurant restaurant = new ItalianRestaurant();
        restaurant.orderBurger();
    }

}
