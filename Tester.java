public class Tester{

    public static void main(String[] args){

        int testCases = 0;
        int testCasesPassed = 0;

        //test for empty tree
        testCases++;
        BinaryTree t0 = new BinaryTree();
        if(t0.getRoot() == null){
            testCasesPassed++;
        }

        //set BinaryTree for next testCases
        BinaryTree t1 = new BinaryTree();
        
        //test insert for just the root
        testCases++;
        t1.insert(3);
        if(t1.getRoot() == 3){
            testCasesPassed++;
        }

        //test findMinimum with only the root
        testCases++;
        if(t1.findMinimum() == 3){
            testCasesPassed++;
        }

        //test insert for a "normal" number
        testCases++;
        t1.insert(5);
        testCasesPassed++;

        //test insert for an equal number
        testCases++;
        t1.insert(3);
        testCasesPassed++;

        //test insert for a smaller number
        testCases++;
        t1.insert(2);
        testCasesPassed++;

        //test insert for a larger number
        testCases++;
        t1.insert(15);
        testCasesPassed++;

        //test insert for a negative number
        testCases++;
        t1.insert(-9);
        testCasesPassed++;

        //test insert for zero
        testCases++;
        t1.insert(0);
        testCasesPassed++;

        //test insert for a large large child
        testCases++;
        t1.insert(18);
        testCasesPassed++;

        //test insert for a large small child
        testCases++;
        t1.insert(7);
        testCasesPassed++;

        //test insert for a small small child
        testCases++;
        t1.insert(1);
        testCasesPassed++;

        //test insert for a small large child
        testCases++;
        t1.insert(4);
        testCasesPassed++;

        //test order of inserts
        testCases++;
        if(t1.printWalk().equals("-9 0 1 2 3 3 4 5 7 15 18 ")){
            testCasesPassed++;
        }

        //test findMinimum
        testCases++;
        if(t1.findMinimum() == -9){
            testCasesPassed++;
        }

        //test scrub delete
        testCases++;
        t1.deleteNum(4);
        if(t1.printWalk().equals("-9 0 1 2 3 3 5 7 15 18 ")){
            testCasesPassed++;
        }

        //test splice1 delete
        testCases++;
        t1.deleteNum(2);
        if(t1.printWalk().equals("-9 0 1 3 3 5 7 15 18 ")){
            testCasesPassed++;
        }

        //test splice2 delete
        t1.insert(22);
        t1.insert(100);
        testCases++;
        t1.deleteNum(22);
        if(t1.printWalk().equals("-9 0 1 3 3 5 7 15 18 100 ")){
            testCasesPassed++;
        }

        //test rotate1 delete
        t1.insert(6);
        testCases++;
        t1.deleteNum(15);
        if(t1.printWalk().equals("-9 0 1 3 3 5 6 7 18 100 ")){
            testCasesPassed++;
        }

        //test rotate2 delete
        t1.insert(-6);
        t1.insert(2);
        t1.insert(3);
        t1.insert(0);
        t1.insert(2);
        t1.insert(1);
        t1.insert(0);
        t1.insert(-1);
        testCases++;
        t1.deleteNum(2);
        if(t1.printWalk().equals("-9 -6 -1 0 0 0 1 1 2 3 3 3 5 6 7 18 100 ")){
            testCasesPassed++;
        }

         //test rotate3 delete
         t1.insert(120);
         t1.insert(80);
         testCases++;
         t1.deleteNum(100);
         if(t1.printWalk().equals("-9 -6 -1 0 0 0 1 1 2 3 3 3 5 6 7 18 80 120 ")){
             testCasesPassed++;
         }

        //test depth
        testCases++;
        if(t1.depth() == 7);
        testCasesPassed++;

        System.out.println("Passed: " + testCasesPassed + "/" + testCases);
    }
}