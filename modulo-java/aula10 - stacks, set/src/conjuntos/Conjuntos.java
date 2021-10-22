package conjuntos;

import java.util.HashSet;

public class Conjuntos {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<>();
        cars.add("Gol");
        cars.add("Fox");
        cars.add("Gol");
        cars.add("BMW");
        cars.add("Eco");

        cars.forEach(System.out::println);
        System.out.println();
        //cars.stream().filter(res -> res.contains("Eco")).forEach(System.out::println);
        //ou
        for (String i : cars){
            if(i.contains("Eco"))
                System.out.println(i);
        }


    }
}
