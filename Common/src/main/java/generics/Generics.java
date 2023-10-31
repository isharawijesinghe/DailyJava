package generics;


import java.util.Arrays;
import java.util.List;

class Building {
    void paint() {
        System.out.println("wierd, but painting a building man..");
    }
}

class House extends Building {

    @Override
    void paint() {
        System.out.println("Painting the damn house");
    }
}

class Office extends Building {

    @Override
    void paint() {
        System.out.println("Painting the damn office building");
    }
}


class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
}

public class Generics {

    public <T extends Building> void paintAllBuildings(List<T> buildings) {
        buildings.forEach(Building::paint);
    }

    public void paintModern(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    /**
     * Will only work if the type is house or super type of house,
     * and we are not sure that all the super classes would contain a certain method on a lower bound scenario
     * @param buildings
     */
    public void repair(List<? super Building> buildings) {
        buildings.add(new Building());
    }

    /**
     * above two methods are same.
     * the real use of T comes when you use it inside the method
     * @param args
     */
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Building> houseList = Arrays.asList(new House(), new Office());
        List<Building> buildings = Arrays.asList(new Building());

        System.out.println("=============== Print all buildings ============");
        generics.paintAllBuildings(houseList);
        System.out.println("=============== Print modern buildings ============");
        generics.paintModern(houseList);
        System.out.println("=============== Repair building ============");
        generics.repair(buildings);


        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Double, String> pair2 = new Pair<>(3.14, "Pi");
    }
}