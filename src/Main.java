
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10, "pain");
        tree.root = tree.insert(tree.root, 20, "dd");
        tree.root = tree.insert(tree.root, 30, "aa");
        tree.root = tree.insert(tree.root, 40, "paissn");
        tree.root = tree.insert(tree.root, 50, "hhh");
        tree.root = tree.insert(tree.root, 25, "jjjj");
    }
}