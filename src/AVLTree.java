import org.jetbrains.annotations.NotNull;

public class AVLTree {
    private AvlNode root;

    private int getTreeHeight(AvlNode node){ return node != null ? node.height : 0;}
    private AvlNode rightRotation(@NotNull AvlNode node){
        AvlNode firstNode = node.leftChild;
        AvlNode secondNode = firstNode.rightChild;

        firstNode.rightChild = node;
        node.leftChild = secondNode;

        node.height = Math.max(getTreeHeight(node.leftChild), getTreeHeight(node.rightChild)) + 1;
        firstNode.height = Math.max(getTreeHeight(firstNode.leftChild), getTreeHeight(firstNode.rightChild)) + 1;
        return firstNode;
    }

    private AvlNode leftRotation(@NotNull AvlNode node){
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

    public void insert(int key, String value){this.root = insert(this.root, key, value);}
    private AvlNode insert(AvlNode node, int key, String value){
        if (node == null) return (new AvlNode(key, value));

        if(key == node.key) return node;

        if (key < node.key) node.leftChild = insert(node.leftChild, key, value);
        else node.rightChild = insert(node.rightChild, key, value);

        node.height = 1 + Math.max(getTreeHeight(node.leftChild), getTreeHeight(node.rightChild));

        int treeBalance = balance(node);

        if(treeBalance > 1 && key > node.leftChild.key) return  rightRotation(node);

        if(treeBalance < -1 && key > node.rightChild.key) return leftRotation(node);

        if (treeBalance > 1 && key > node.leftChild.key){
            node.leftChild = leftRotation(node.rightChild);
            return rightRotation(node);
        }

        if(treeBalance < -1 && key < node.rightChild.key){
            node.rightChild = rightRotation(node.rightChild);
            return leftRotation(node);
        }

        return node;
    }
}

class AvlNode{
    protected  int key;
    protected int height;
    protected String value;
    protected AvlNode leftChild;
    protected AvlNode rightChild;

    AvlNode(int key, String value){
        this.key = key;
        this.value = value;
        this.height = 1;
    }
}


