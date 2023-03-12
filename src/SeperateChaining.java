import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SeperateChaining {

    enum Operation{INSERT, DELETE}
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

    private void rehash(Operation op){

        if(op == Operation.INSERT){
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
        else{
            double loadFactor = getLoadFactor();
            if (getLoadFactor() > 0.25){return;}

            ArrayList<SCNode> tmp = bucketList;
            bucketList = new ArrayList<>();
            buckets = buckets / 2;
            tableSize = 0;

            for(int i = 0; i < buckets; i++){bucketList.add(null);}

            for(SCNode startNode : tmp){
                while(startNode != null){
                    insert(startNode.key, startNode.value);
                    startNode = startNode.next;
                }
            }
        }
    }

    public void insert(String key, int value){

        int index = indexing(key);
        int hash = hashing(key);
        SCNode startNode = bucketList.get(index);
        SCNode searchNode = search(startNode, key, hash);

        if(searchNode != null){
            System.out.println("key " + key + " already inserted, updateing it's value to: " + value);
            startNode.value = value;
            return;
        }

        SCNode insertNode = new SCNode(hash, key, value);
        insertNode.next = startNode;
        bucketList.set(index, insertNode);
        tableSize++;
        rehash(Operation.INSERT);
    }

    public boolean search(String key){
        int index = indexing(key);
        int hash = hashing(key);
        SCNode startNode = bucketList.get(index);
        SCNode searchNode = search(startNode, key, hash);

        if(searchNode != null && searchNode.key.equals(key)){
            System.out.println("Key: " + key + " is located in the table.");
            return true;
        }
        System.out.println("Key: " + key + " is not located in the table.");
        return false;
    }

    private SCNode search(SCNode node, String key, int hash){
        while(node != null){
            if(node.key.equals(key) && node.hash == hash){return node;}
            node = node.next;
        }
        return node;
    }


    public boolean delete(String key){
        int index = indexing(key);
        int hash = hashing(key);
        SCNode startNode = bucketList.get(index);
        SCNode prevNode = null;

        while(startNode != null){
            if(startNode.key.equals(key) && startNode.hash == hash){break;}
            prevNode = startNode;
            startNode = startNode.next;
        }

        if(startNode == null){return false;}


        if(prevNode != null){prevNode.next = startNode.next;}
        else{bucketList.set(index, startNode.next);}
        tableSize--;
        rehash(Operation.DELETE);
        return true;
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
