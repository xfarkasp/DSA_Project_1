

public class AVLTree implements DefaultTree{
    private AvlNode root;

    private String treeType = "AVL Tree";

    public String getTreeType() {
        return treeType;
    }
    private int getTreeHeight(AvlNode node){ return node != null ? node.height : 0;}
    private AvlNode rightRotation(AvlNode node){
        AvlNode firstNode = node.leftChild;
        AvlNode secondNode = firstNode.rightChild;

        firstNode.rightChild = node;
        node.leftChild = secondNode;

        node.height = Math.max(getTreeHeight(node.leftChild), getTreeHeight(node.rightChild)) + 1;
        firstNode.height = Math.max(getTreeHeight(firstNode.leftChild), getTreeHeight(firstNode.rightChild)) + 1;
        return firstNode;
    }

    private AvlNode leftRotation(AvlNode node){
        AvlNode firstNode = node.rightChild;
        AvlNode secondNode = firstNode.leftChild;

        firstNode.leftChild = node;
        node.rightChild = secondNode;

        node.height = Math.max(getTreeHeight(node.leftChild), getTreeHeight(node.rightChild)) + 1;
        firstNode.height = Math.max(getTreeHeight(firstNode.leftChild), getTreeHeight(firstNode.rightChild)) + 1;
        return firstNode;
    }

    private int balance(AvlNode node){
        if (node == null)
            return 0;

        return getTreeHeight(node.leftChild) - getTreeHeight(node.rightChild);
        }

    public void insert(Comparable key){
        System.out.println("Inserting key: " + key + " to AVL tree.");
        this.root = insert(this.root, key);
        printTree();
    }
    private AvlNode insert(AvlNode node, Comparable key){
        if (node == null) return (new AvlNode(key));

        if (key.compareTo(node.key) < 0) node.leftChild = insert(node.leftChild, key);
        else if(key.compareTo(node.key) > 0) node.rightChild = insert(node.rightChild, key);
        else{
            System.out.println("Can not add " + key +" to the tree, the key is already inserted!");
            return node;
        }

        node.height = 1 + Math.max(getTreeHeight(node.leftChild), getTreeHeight(node.rightChild));

        int treeBalance = balance(node);

        if(treeBalance > 1 && key.compareTo(node.leftChild.key) < 0) return  rightRotation(node);

        if(treeBalance < -1 && key.compareTo(node.rightChild.key) > 0) return leftRotation(node);

        if (treeBalance > 1 && key.compareTo(node.leftChild.key) > 0){
            node.leftChild = leftRotation(node.leftChild);
            return rightRotation(node);
        }

        if(treeBalance < -1 && key.compareTo(node.rightChild.key) < 0){
            node.rightChild = rightRotation(node.rightChild);
            return leftRotation(node);
        }

        return node;
    }

    public void delete(Comparable key){
        this.root = delete(this.root, key);
    }
    AvlNode delete(AvlNode node, Comparable key){
        if(node == null) return node;

        if(key.compareTo(node.key) < 0){node.leftChild = delete(node.leftChild, key);}

        else if (key.compareTo(node.key) > 0){node.rightChild = delete(node.rightChild, key);}

        else{
            if((node.leftChild == null) || (node.rightChild == null)){
                AvlNode tmp = null;
                if(tmp == node.leftChild){tmp = node.rightChild;}
                else{tmp = node.leftChild;}

                if(tmp == null){
                    tmp = node;
                    node = null;
                }else{node = tmp;}
            }
            else{
                AvlNode tmp = minNode(node.rightChild);
                node.key = tmp.key;
                node.rightChild = delete(node.rightChild, tmp.key);
            }
        }

        if(node == null){return node;}

        node.height = Math.max(getTreeHeight(node.leftChild), getTreeHeight(node.rightChild)) + 1;

        int balance = balance(node);

        if(balance > 1 && balance(node.leftChild) >= 0){return rightRotation(node);}
        if(balance > 1 && balance(node.leftChild) < 0){
            node.leftChild = leftRotation(node.leftChild);
            return rightRotation(node);
        }
        if(balance < -1 && balance(node.rightChild) <= 0){return leftRotation(node);}
        if(balance < -1 && balance(node.rightChild) > 0){
            node.rightChild = rightRotation(node.rightChild);
            return leftRotation(node);
        }
        return node;
    }

    private AvlNode minNode(AvlNode node){
        AvlNode current = node;
        while (current.leftChild != null){current = current.leftChild;}
        return current;
    }

    public boolean search(Comparable key){
        AvlNode tmp = this.root;
        while (tmp != null){
            if(tmp.key.compareTo(key) == 0){
                //System.out.println(key + " is located in the AVL tree");
                return true;
            }

            if(tmp.key.compareTo(key) < 0)
                tmp = tmp.rightChild;
            else
                tmp = tmp.leftChild;
        }
        //System.out.println(key + " is not located in the AVL tree");
        return false;
    }

    //preorder
    public void printTree(){
        System.out.println("AVL Tree Preorder:");
        printTree(this.root);
        System.out.println(" ");
    }

    void printTree(AvlNode node){
        if(node == null){return;}
        System.out.print(node.key + " ");
        printTree(node.leftChild);
        printTree(node.rightChild);
    }

    public void emptyTree(){this.root = null;}


}

class AvlNode{
    protected  Comparable key;
    protected int height;
    protected String value;
    protected AvlNode leftChild;
    protected AvlNode rightChild;

    AvlNode(int key, String value){
        this.key = key;
        this.value = value;
        this.height = 1;
    }

    AvlNode(Comparable key){
        this.key = key;
        this.height = 1;
    }

}


