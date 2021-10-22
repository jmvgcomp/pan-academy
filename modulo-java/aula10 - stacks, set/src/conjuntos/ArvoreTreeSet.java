package conjuntos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class ArvoreTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(63);
        treeSet.add(34);
        treeSet.add(45);

        Iterator<Integer> iterator = treeSet.iterator();
        System.out.println("Tree set data: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println();

        HashSet<Integer> dset = new HashSet<>();
        dset.add(2);
        dset.add(12);
        dset.add(63);
        dset.add(34);
        System.out.println("hashSet");
        Iterator<Integer> iteratorHashset = dset.iterator();
        System.out.println("HashSet data: ");
        while (iteratorHashset.hasNext()) {
            System.out.println(iteratorHashset.next() + " ");
        }
    }
}
