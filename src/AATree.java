public class AATree {
    private  AANode root;
    private static AANode delNode;
    private static AANode lastNode;
    private static final AANode nullNode;

    static {
        nullNode = new AANode(null);
        nullNode.level = 0;
        nullNode.leftChild = nullNode;
        nullNode.rightChild = nullNode;
    }

    AATree(){
        this.root = nullNode;
    }

    private AANode leftRotation(AANode node){
        AANode tmp = node.leftChild;
        node.leftChild = tmp.rightChild;
        tmp.rightChild = node;
        return tmp;
    }

    private AANode rightRotation(AANode node){
        AANode tmp = node.rightChild;
        node.rightChild = tmp.leftChild;
        tmp.leftChild = node;
        return tmp;
    }

    private AANode split(AANode node){
       if(node.rightChild.rightChild.level == node.level){
           node = rightRotation(node);
           node.level++;
       }
       return node;
    }

    private AANode skew(AANode node){
        if(node.leftChild.level == node.level){node = leftRotation(node);}

        return node;
    }

    public void insert(Comparable key){
        this.root = insert(key, root);
    }

    private AANode insert(Comparable key, AANode node){
        if(node == nullNode){node = new AANode(key, nullNode, nullNode);}
        else if(key.compareTo(node.key) < 0){node.leftChild = insert(key, node.leftChild);}
        else if (key.compareTo(node.key) > 0) {node.rightChild = insert(key, node.rightChild);}
        else {return node;}

        node = skew(node);
        node = split(node);
        return node;
    }

    public void delete(Comparable key){
        delNode = nullNode;
        root = delete(key, root);
    }

    private AANode delete(Comparable key, AANode node){
        if(node != nullNode) {
            lastNode = node;
            if (key.compareTo(node.key) < 0) {
                node.leftChild = delete(key, node.leftChild);
            } else {
                delNode = node;
                node.rightChild = delete(key, node.rightChild);
            }

            if (node == lastNode) {
                if (delNode == nullNode || key.compareTo(delNode.key) != 0) {
                    return node;
                }
                delNode.key = node.key;
                node = node.rightChild;
            } else {
                if (node.leftChild.level < node.level - 1 || node.rightChild.level < node.level - 1) {
                    if (node.rightChild.level > --node.level) {
                        node.rightChild.level = node.level;
                    }
                    node = skew(node);
                    node.rightChild = skew(node.rightChild);
                    node.rightChild.rightChild = skew(node.rightChild.rightChild);
                    node = split(node);
                    node.rightChild = split(node.rightChild);
                }
            }
        }
        return node;
    }

}
class AANode{
    Comparable key;
    int level;
    AANode leftChild;
    AANode rightChild;

    AANode(Comparable key){
        this(key, null, null);
    }

    AANode(Comparable key, AANode leftChild, AANode rightChild){
        this.key = key;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
        this.level = 1;
    }


}
