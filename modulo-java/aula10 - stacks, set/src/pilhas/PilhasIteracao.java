package pilhas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PilhasIteracao {
    public static void main(String[] args) {

        Stack<Integer> pilhasList = new Stack<>();
        pilhasList.push(68);
        pilhasList.push(118);
        pilhasList.push(90);
        pilhasList.push(720);
        pilhasList.pop();

        ArrayList<String> listArray = new ArrayList<>();
        listArray.add("Array 1");
        listArray.add("Array 2");

        List<String> listList = new ArrayList<>();
        listList.add("Lista 1");
        listList.add("Lista 2");

        System.out.println("Iterar pilha");
        Iterator<Integer> iterPilha = pilhasList.iterator();
        while (iterPilha.hasNext()){
            Integer iterado = iterPilha.next();
            System.out.println(iterado);
        }

        System.out.println("Iterar ArrayList");
        Iterator<String> ArrayList = listArray.iterator();
        while (ArrayList.hasNext()){
            String iterado = ArrayList.next();
            System.out.println(iterado);
        }

        System.out.println("Iterar lista");
        Iterator<String> iterList = listList.iterator();
        while (iterList.hasNext()){
            String iterado = iterList.next();
            System.out.println(iterado);
        }


        /*

        pilhasList.forEach(System.out::println);
        listList.forEach(System.out::println);
        listList.forEach(System.out::println);
       */

    }
}
