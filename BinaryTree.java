public class BinaryTree{

    private BSTnode root;

    public BinaryTree(){}

    //inserts an int into the binary tree
    public void insert(int num){
        if(root == null){
            root = new BSTnode(null, num);
        }
        else{
            root.insertChild(num);
        }
    }

    //finds the int with the lowest value from the called on node
    public int findMinimum(){
        return (root.findMin()).getNum();
    }

    //deletes one instance of a given int
    public void deleteNum(int num){//if multiple, delete one of them
        root.deleteNum(num);
    }

    public Integer getRoot(){
        if(root == null){
            return null;
        }
        return root.getNum();
    }

    //finds the node one larger. If multiple of same value, higher in the tree = greater
    public BSTnode successor(BSTnode node){
        return node.successor();
    }

    //returns a string of the tree in order
    public String printWalk(){
        String out = "";
        BSTnode node = root.findMin();
        while(node != null){
            out += node.getNum() + " ";
            node = node.successor();
        }
        return out;
    }

    //returns the distance from root to the "deepest" node
    public int depth(){ //Written by Mr. Kuzmaul
        return root.depth();
    }

}