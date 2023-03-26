import java.util.ArrayList;
public class LinearProbing implements HashTable{

    enum Operation{INSERT, DELETE}
    private int tableSize;
    private int numNodes;
    private ArrayList<LPNode> nodeMap;
    private static final LPNode delNode;
    private final String tableType = "LinearProbing";

    static {
        delNode = new LPNode();
        delNode.flag = LPNode.FLAGS.DELETED;
    }

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
            if (getLoadFactor() < 0.75) {return;}
            System.out.println("Upscaling from " + tableSize + " to " + tableSize * 2);
            tableSize = tableSize * 2;
        }

        if(op == SeperateChaining.Operation.DELETE){
            if (getLoadFactor() > 0.25){return;}
            System.out.println("Downscaling from " + tableSize + " to " + tableSize / 2);
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

        if(searchNode.flag == LPNode.FLAGS.INUSE){
            System.out.println("Collision at index:" + index);
        }
        while(searchNode.flag == LPNode.FLAGS.INUSE){
            if(searchNode.key.equals(key)){
                System.out.println("The key: " + key + "is already inserted updating value to: " + value);
                searchNode.value = value;
                printTable();
                return;
            }
            index++;
            if(index >= tableSize){index = 0;}
            searchNode = nodeMap.get(index);
        }

        nodeMap.set(index, new LPNode(hash, key, value));
        numNodes++;
        rehash(SeperateChaining.Operation.INSERT);
        printTable();
    }

    private LPNode search(int index, String key){

        LPNode searchNode = nodeMap.get(index);
        if(!searchNode.key.equals(key)){
            while(searchNode.flag != LPNode.FLAGS.EMPTY){
                index++;
                if(index >= tableSize){index = 0;}
                searchNode = nodeMap.get(index);
                if(searchNode.key.equals(key)){return searchNode;}
            }
            searchNode = null;
        }
        return searchNode;
    }

    private int searchIndex(int index, String key){
        LPNode searchNode = nodeMap.get(index);
        if(!searchNode.key.equals(key)){
            while(searchNode.flag != LPNode.FLAGS.EMPTY){
                index++;
                if(index >= tableSize){index = 0;}
                searchNode = nodeMap.get(index);
                if(searchNode.key.equals(key)){return index;}
            }
            index = Integer.MIN_VALUE;
        }
        return index;
    }

    @Override
    public boolean search(String key) {
        int index = indexing(key);
        int hash = hashing(key);
        LPNode searchNode = search(index, key);

        if(searchNode != null && searchNode.key.equals(key)){
            System.out.println("Key: " + key + " is located in the table.");
            return true;
        }
        System.out.println("Key: " + key + " is not located in the table.");

        return false;
    }

    @Override
    public boolean delete(String key) {
        int index = indexing(key);
        int searchNodeIndex = searchIndex(index, key);

        if(searchNodeIndex == Integer.MIN_VALUE){
            System.out.println("The key: " + key + " is not in the table.");
            return false;
        }

        nodeMap.set(searchNodeIndex, delNode);
        numNodes--;
        rehash(SeperateChaining.Operation.DELETE);
        printTable();
        return false;
    }

    @Override
    public void emptyTable(){
        tableSize = 5;
        numNodes = 0;
        this.nodeMap = new ArrayList<>();

        for(int i = 0; i < tableSize; i++){nodeMap.add(new LPNode());}
    }

    @Override
    public void printTable(){
        for(int i = 0; i < tableSize; i++) {
            if(nodeMap.get(i).flag == LPNode.FLAGS.INUSE)
                System.out.println("Index: "+ i + " Key: " + nodeMap.get(i).key + " Value: " + nodeMap.get(i).value);
        }
        System.out.println();
    }

    @Override
    public String getTableType(){return tableType;}
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