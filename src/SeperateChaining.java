import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SeperateChaining {
    private int tableSize;
    private int buckets;
    private ArrayList<SCNode> bucketList;
    private final double threshHold = 0.75;

    public int getTableSize(){return tableSize;}

    private double getLoadFactor(){return Double.valueOf(tableSize) / buckets;}

    public SeperateChaining(){
        this.tableSize = 0;
        this.buckets = 5;
        this.bucketList = new ArrayList<>();

        for(int i = 0; i < this.buckets; i++){this.bucketList.add(null);}
    }

    private int hashing(@NotNull String key){
        int hashCode = 0;
        final int hConst = 7;

        for(int i = 0; i < key.length() && i < 8; i++) {hashCode += Math.pow(hConst, i) * key.charAt(i);}

        return hashCode;
    }

    private int indexing(String key){return Math.abs(hashing(key) % buckets);}

    private boolean updateValue(SCNode node, String key, int value, int hash){
        while(node != null){
            if(node.key.equals(key) && node.hash == hash){
                node.value = value;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private void rehash(){

        if (getLoadFactor() < 0.75){return;}

        ArrayList<SCNode> tmp = bucketList;
        bucketList = new ArrayList<>();
        buckets = buckets * 2;
        tableSize = 0;

        for(int i = 0; i < buckets; i++){bucketList.add(null);}

        for(SCNode startNode : tmp){
            while(startNode != null){
                insert(startNode.key, startNode.value);
                startNode = startNode.next;
            }
        }
    }

    public void insert(String key, int value){
        int index = indexing(key);
        int hash = hashing(key);
        SCNode startNode = bucketList.get(index);

        if(updateValue(startNode, key, value, hash)){
            System.out.println("key " + key + " already inserted, updateing it's value to: " + value);
            return;
        }

        startNode = bucketList.get(index);
        SCNode insertNode = new SCNode(hash, key, value);
        insertNode.next = startNode;
        bucketList.set(index, insertNode);
        tableSize++;
        rehash();
    }

}

class SCNode{
    protected final int hash;
    protected String key;
    protected int value;
    protected SCNode next;
    protected SCNode(int hash, String key, int value){
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

}
