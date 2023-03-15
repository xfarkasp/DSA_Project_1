public interface HashTable {
    void insert(String key, int value);
    boolean search(String key);
    boolean delete(String key);
    void emptyTable();
    void printTable();
    String getTableType();
}
