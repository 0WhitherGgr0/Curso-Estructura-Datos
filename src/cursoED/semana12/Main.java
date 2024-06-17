package cursoED.semana12;

public class Main {
    public static void main(String[] args) {
        BTree tree = new BTree(3);

        System.out.println("After inserting 1 and 2");
        tree.insert(1);
        tree.insert(2);
        System.out.println(tree.display());

        System.out.println("After inserting 5 and 6");
        tree.insert(5);
        tree.insert(6);
        System.out.println(tree.display());

        System.out.println("After inserting 3 and 4");
        tree.insert(3);
        tree.insert(4);
        System.out.println(tree.display());

        System.out.println("Search for 3: " + (tree.search(3) != null ? "Found" : "Not Found"));
        System.out.println("Search for 7: " + (tree.search(7) != null ? "Found" : "Not Found"));
    }
}
