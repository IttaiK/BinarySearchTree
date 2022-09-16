public class BSTnode{//Binary Search Tree Node

    private BSTnode Parent;
    private int myNum;
    private BSTnode Bchild; //Big child
    private BSTnode Schild; //Small child

    public BSTnode(BSTnode parent, int num){
        this.Parent = parent;
        this.myNum = num;
    }

    public void setBchild(BSTnode node){
        Bchild = node;
    }

    //returns the depth of the tree from the called upon node down
    public int depth(){ //Written by Mr. Kuzmaul
        if(!hasChild()) return 0;
        else if(Schild == null){
            return Bchild.depth()+1;
        }
        else if(Bchild == null){
            return Schild.depth()+1;
        }
        else{
            return Math.max(Schild.depth(),Bchild.depth())+1;
        }
    }
    
    public BSTnode getSchild(){
        return Schild;
    }

    public BSTnode getBchild(){
        return Bchild;
    }

    public BSTnode getParent(){
        return Parent;
    }

    public void setParent(BSTnode p){
        Parent = p;
    }

    public void setSchild(BSTnode node){
        Schild = node;
    }

    public int getNum(){
        return myNum;
    }

    //inserts a node into the tree
    public void insertChild(int num){
        if(num > myNum){//right side
            if(Bchild != null){
                Bchild.insertChild(num);
            }else{
                Bchild = new BSTnode(this, num);
            }
        }else{//left side
            if(Schild != null){
                Schild.insertChild(num);
            }else{
                Schild = new BSTnode(this, num);
            }
        }
    } 

    //finds minimum from this to all following children
    public BSTnode findMin(){
        if (Schild == null){
            return this;
        }
        return Schild.findMin();
    }

    //changes child pointer. Used in Splice
    public void changeChild(int childNum, BSTnode node){
        if(childNum > myNum){
            Bchild = node;
        }else{
            Schild = node;
        }
    }

    //deletes a node of given int value from the tree
    public void deleteNum(int delNum){
        if(delNum == myNum){//num found
            if(!hasChild()){//no children
                scrub();
            }else if(Bchild != null && Schild != null){//two children
                rotate();
            }
            else{//one child
                splice();
            }
        } else if(hasChild()){//move on to the next one
            if(delNum < myNum){
                Schild.deleteNum(delNum);
            }else{
                Bchild.deleteNum(delNum);
            }
        } else{
            throw new RuntimeException("NumberToDeleteNotFound");
        }
    }

    //wipes node from tree
    public void scrub(){
        //wipe from parent:
        Parent.changeChild(myNum, null);
        //delete self:
        Parent = null;
        Bchild = null;
        Schild = null;
    }

    //deletes node and connects child to parent
    public void splice(){
        //wipe from parent and connect the gap
        if(Schild != null){
            Parent.changeChild(myNum, Schild);
            Schild.setParent(Parent);
        }else{
            Parent.changeChild(myNum, Bchild);
            Bchild.setParent(Parent);
        }
        //delete self
        Parent = null;
        Bchild = null;
        Schild = null;
    }

    //deletes node, puts the smallest big child extended into its spot, and then cleans up loose ends
    public void rotate(){ 
        BSTnode BigMin = Bchild.findMin();//find replacment and call BigMin

        //set left child of replacment to the deleted nodes left child
        BigMin.setSchild(Schild);
        Schild.setParent(BigMin);

        if(!BigMin.hasChild()){//replacment has no children
            //set big child of replacment to the deleted nodes big child
            BigMin.setBchild(Bchild);
            Bchild.setParent(BigMin);
            BigMin.getParent().setSchild(null);
        } else if(BigMin != Bchild){
            //splices the old big child
            BigMin.getBchild().setParent(BigMin.getParent());
            BigMin.getParent().changeChild(BigMin.getNum(), BigMin.getBchild());
        }

        //set replacments parent properly
        BigMin.setParent(Parent);
        Parent.changeChild(myNum, BigMin);
    }

    public boolean hasChild(){
        return(Schild != null || Bchild != null);
    }

    //finds the node one larger. If multiple of same value, higher in the tree = greater
    public BSTnode successor(){ //Written together with Zev Meyers
        if(Bchild != null){
            return Bchild.findMin();
        }
        //node is root with no right child (king)
        if(Parent == null){
            return null;
        }
        //return parent when you are a left child for the first time
        else{
            BSTnode ladderParent = Parent;
            BSTnode ladderMe = this;
            while(ladderParent != null && ladderParent.getSchild()!=ladderMe){
                ladderMe = ladderParent;
                ladderParent = ladderParent.getParent();
            }
            return ladderParent; 
            // ^^ works even if right most node is king, because 
                //ladderParent will become null, break the loop and return null
        }
    }
}