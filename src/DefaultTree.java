public interface DefaultTree {
    void insert(Comparable key);
    void delete(Comparable key);
    boolean search(Comparable key);
    void emptyTree();
    void printTree();
    String getTreeType();

}
