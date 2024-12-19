package shorts.v1;

import java.util.Arrays;
import java.util.List;

class City {
    String name;
    int population;

    City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
}

public class AverageCityPopulation {
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                new City("Oslo", 634293),
                new City("Bergen", 278556),
                new City("Stavanger", 132102),
                new City("Trondheim", 194229)
        );

        double averagePopulation = cities.stream()
                .mapToInt(City::getPopulation)
                .average()
                .orElse(0.0);

        System.out.println("Average population of cities: " + averagePopulation);
    }
}
