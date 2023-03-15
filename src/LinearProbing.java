import java.util.ArrayList;

public class LinearProbing implements HashTable{

    enum Operation{INSERT, DELETE}
    private int tableSize;
    private int numNodes;
    private ArrayList<LPNode> nodeMap;
    private final double threshHoldUp = 0.75;
    private final double threshHoldDown = 0.25;

    public LinearProbing(){
        tableSize = 5;
        numNodes = 0;
        this.nodeMap = new ArrayList<>();

        for(int i = 0; i < tableSize; i++){nodeMap.add(new LPNode());}
    }

    private int indexing(String key){return Math.abs(hashing(key) % tableSize);}

    private double getLoadFactor(){return Double.valueOf(numNodes) / tableSize;}

    private void rehash(SeperateChaining.Operation op){

        if(op == SeperateChaining.Operation.INSERT){
            double loadFactor = getLoadFactor();
            if (getLoadFactor() < threshHoldUp) {return;}
            tableSize = tableSize * 2;
        }

        if(op == SeperateChaining.Operation.DELETE){
            if (getLoadFactor() > threshHoldDown){return;}
            tableSize = tableSize / 2;
        }

        ArrayList<LPNode> tmp = nodeMap;
        nodeMap = new ArrayList<>();
        numNodes = 0;

        for(int i = 0; i < tableSize; i++){nodeMap.add(new LPNode());}

        for(LPNode insertNode : tmp){
            if(insertNode.flag == LPNode.FLAGS.INUSE)
                insert(insertNode.key, insertNode.value);
        }
    }

    private int hashing(String key){
        if(key == null){return 0;}
        int hashCode = 0;
        final int hConst = 7;

        for(int i = 0; i < key.length() && i < 8; i++) {hashCode += Math.pow(hConst, i) * key.charAt(i);}

        return hashCode;
    }

    @Override
    public void insert(String key, int value) {
        int index = indexing(key);
        int hash = hashing(key);
        LPNode searchNode = nodeMap.get(index);

        while(searchNode.flag == LPNode.FLAGS.INUSE){
            index++;
            if(index >= tableSize){index = 0;}
            searchNode = nodeMap.get(index);
        }

        nodeMap.set(index, new LPNode(hash, key, value));
        numNodes++;
        rehash(SeperateChaining.Operation.INSERT);
    }

    private LPNode search(LPNode node, String key, int hash){
        while(node != null){
            if(node.key.equals(key) && node.hash == hash){return node;}
        }
        return node;
    }

    @Override
    public boolean search(String key) {
        int index = indexing(key);
        int hash = hashing(key);
        LPNode startNode = nodeMap.get(index);
        LPNode searchNode = search(startNode, key, hash);

        if(searchNode != null && searchNode.key.equals(key)){
            System.out.println("Key: " + key + " is located in the table.");
            return true;
        }
        System.out.println("Key: " + key + " is not located in the table.");

        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }

    @Override
    public void emptyTable() {

    }

    @Override
    public void printTable() {

    }

    @Override
    public String getTableType() {
        return null;
    }
}

class LPNode{
    enum FLAGS{EMPTY, INUSE, DELETED}
    protected FLAGS flag;
    protected final int hash;
    protected String key;
    protected int value;

    protected LPNode(){
        this.flag = FLAGS.EMPTY;
        this.hash = 0;
        this.key = "";
        this.value = 0;
    }
    protected LPNode(int hash, String key, int value){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.flag = FLAGS.INUSE;
    }
}