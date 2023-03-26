public class AATree implements DefaultTree{
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

    private String treeType = "AA Tree";

    public String getTreeType() {
        return treeType;
    }

    AATree(){
        this.root = nullNode;
    }

    private AANode rightRotation(AANode node){
        AANode tmp = node.leftChild;
        node.leftChild = tmp.rightChild;
        tmp.rightChild = node;
        System.out.println("Right rotation.");
        return tmp;
    }

    private AANode leftRotation(AANode node){
        AANode tmp = node.rightChild;
        node.rightChild = tmp.leftChild;
        tmp.leftChild = node;
        System.out.println("Left rotation.");
        return tmp;
    }

    private AANode split(AANode node){
       if(node.rightChild.rightChild.level == node.level){
           System.out.println("Two consecutive horizontal links: Splitting tree.");
           node = leftRotation(node);
           node.level++;
       }
       return node;
    }

    private AANode skew(AANode node){
        if(node.leftChild.level == node.level){
            System.out.println("Left insertion not allowed: Skewing tree.");
            node = rightRotation(node);
        }
        return node;
    }

    public void insert(Comparable key){
        //we start from the root and recursively interate throug the nodes until we find a null node
        //after inserting and rebalancing
        System.out.println("Insering: " + key);
        this.root = insert(key, root);
        printTree();
    }

    private AANode insert(Comparable key, AANode node){
        if(node == nullNode){node = new AANode(key, nullNode, nullNode);}
        else if (key.compareTo(node.key) < 0){node.leftChild = insert(key, node.leftChild);}
        else if (key.compareTo(node.key) > 0){node.rightChild = insert(key, node.rightChild);}
        else {
            System.out.println("Key " + key + " is already inserted.");
            return node;
        }
        node = skew(node);
        node = split(node);
        return node;
    }

    public void delete(Comparable key){
        System.out.println("Deleting: " + key);
        delNode = nullNode;
        root = delete(key, root);
        printTree();
    }

    private AANode delete(Comparable key, AANode node){
        if(node != nullNode){
            lastNode = node;
            if (key.compareTo(node.key) < 0) {
                node.leftChild = delete(key, node.leftChild);
            } else {
                delNode = node;
                node.rightChild = delete(key, node.rightChild);
            }

            if (node == lastNode) {
                if (delNode == nullNode || key.compareTo(delNode.key) != 0) {
                    System.out.println(key + " is not located in the AA tree.");
                    return node;
                }
                delNode.key = node.key;
                node = node.rightChild;
            } else {
                if (node.leftChild.level < node.level - 1 || node.rightChild.level < node.level - 1) {
                    node.level = node.level - 1;
                    if (node.rightChild.level > node.level) {
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
    public boolean search(Comparable key){
        AANode tmp = search(this.root, key);
        if(tmp.key != null && tmp.key.compareTo(key) == 0){
            System.out.println(key + " is located in the AATree.");
            return true;
        }
        System.out.println(key + " is not located in the AATree.");
        return false;
    }

    private AANode search(AANode node, Comparable key){
        if(node == nullNode || node.key == null) return node;
        if(key.compareTo(node.key) < 0){
            node = search(node.leftChild, key);
            if(node.leftChild != null && node.leftChild.key == key) {return node.leftChild;}
        } else if (key.compareTo(node.key) > 0) {
            node = search(node.rightChild, key);
            if(node.rightChild != null && node.rightChild.key == key) {return node.rightChild;}
        }
        return node;
    }
    //preorder
    public void printTree(){
        System.out.println("AATree preorder: ");
        printTree(this.root);
        System.out.println(" ");
    }

    void printTree(AANode node){
        if(node == nullNode){return;}
        System.out.print(node.key + " ");
        printTree(node.leftChild);
        printTree(node.rightChild);
    }

    public void emptyTree(){
        this.root = nullNode;
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
