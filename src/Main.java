
public class Main {
    public static void main(String[] args) {
        AVLTree ygdrasil = new AVLTree();

        ygdrasil.insert(9, "pain");
        ygdrasil.insert(5, "dd");
        ygdrasil.insert(10, "aa");
        ygdrasil.insert(0, "paissn");
        ygdrasil.insert(6, "hhh");
        ygdrasil.insert(11, "jjjj");
        ygdrasil.insert(1, "jjjj");
        ygdrasil.insert(2, "jjjj");

        ygdrasil.delete(10);
        System.out.println("oh please go help me");

        ygdrasil.search(5);
        ygdrasil.search(9);
        ygdrasil.search(10);
        ygdrasil.search(1000);
        ygdrasil.search(12);
        ygdrasil.search(11);
        ygdrasil.search(2);
        ygdrasil.search(6);
        ygdrasil.search(0);
    }
}