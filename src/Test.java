import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void insertTest(DefaultTree tree, ArrayList<Integer> dataSet){
        //start inserting to
        for(int i = 0; i < dataSet.size(); i++){
            tree.insert(dataSet.get(i));
        }
    }

    public static void deleteTest(DefaultTree tree, ArrayList<Integer> dataSet){

        //start deleting
        for(int i = 0; i < dataSet.size(); i++){
            tree.delete(dataSet.get(i));
        }
    }

    public static void searchTest(DefaultTree tree, ArrayList<Integer> dataSet){
        //start search
        for(int i = 0; i < dataSet.size(); i++){
            tree.search(dataSet.get(i));
        }
    }

    public static void treeTest(DefaultTree tree, String fileName){
        try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        ) {
            Runtime rt = Runtime.getRuntime();

            String dataPath = "dataSets";
            File dir = new File(dataPath);
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File child : directoryListing) {
                    BufferedReader br = new BufferedReader(new FileReader(child));
                    String line = null;

                    //insert dataset to an array
                    ArrayList<Integer> dataSet = new ArrayList();
                    while ((line = br.readLine()) != null) {dataSet.add(Integer.valueOf(line));}

                    //INSERTION TESTING
                    //record start time and start memory usage
                    long start1 = System.nanoTime();
                    Runtime runTime = Runtime.getRuntime();
                    insertTest(tree, dataSet);
                    runTime.gc();
                    double memory =  runTime.totalMemory() - runTime.freeMemory();
                    long end1 = System.nanoTime();
                    double timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(tree.getTreeType() + " INSERTING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(tree.getTreeType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");

                    tree.emptyTree();

                    //-INSERT - DELETE
                    start1 = System.nanoTime();

                    //start inserting to
                    insertTest(tree, dataSet);
                    runTime.gc();
                    memory =  runTime.totalMemory() - runTime.freeMemory();

                    //reorder the dataset for deletion
                    Collections.shuffle(dataSet);

                    //start deleting
                    deleteTest(tree, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    end1 = System.nanoTime();
                    timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(tree.getTreeType() + " INSERTING DELETING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(tree.getTreeType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");

                    //-INSERT - SEARCH
                    start1 = System.nanoTime();

                    //start inserting to
                    insertTest(tree, dataSet);
                    runTime.gc();
                    memory =  runTime.totalMemory() - runTime.freeMemory();

                    //reorder the dataset for searching
                    Collections.shuffle(dataSet);

                    //start searching
                    searchTest(tree, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    end1 = System.nanoTime();
                    timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(tree.getTreeType() + " INSERTING SEARCHING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(tree.getTreeType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");

                    tree.emptyTree();

                    //-INSERT - SEARCH -DELETE
                    start1 = System.nanoTime();

                    //start inserting to
                    insertTest(tree, dataSet);
                    runTime.gc();
                    memory = (runTime.totalMemory() - runTime.freeMemory());

                    //reorder the dataset for searching
                    Collections.shuffle(dataSet);

                    //start searching
                    searchTest(tree, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    //start deleting
                    deleteTest(tree, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    end1 = System.nanoTime();
                    timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(tree.getTreeType() + " INSERTING SEARCHING DELETING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(tree.getTreeType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");
                }
            }
       } catch (IOException e) {e.printStackTrace();}
    }
    public static void main(String[] args){
        try {
            SeperateChaining chain = new SeperateChaining();
            chain.insert("pain", 5);
            chain.insert("pian", 98);
            chain.insert("naip", 25);
            chain.insert("naip", 999);
            chain.insert("naipfffgs", 785);
            chain.insert("nafdgsdfgip", 265);
            chain.insert("nhhjbcaip", 275);
            chain.insert("naiggsczp", 25);

            chain.delete("pain");
            chain.delete("pian");
            chain.delete("naip");
            chain.delete("naip");
            chain.delete("naipfffgs");
            chain.delete("nafdgsdfgip");
            chain.delete("nhhjbcaip");
            chain.delete("naiggsczp");



            AVLTree ygdrasil = new AVLTree();
            ygdrasil.insert(7);
            ygdrasil.insert(1);
            ygdrasil.insert(5);
            ygdrasil.insert(89);
            ygdrasil.insert(560);
            ygdrasil.insert(89);
            ygdrasil.insert(9);
            ygdrasil.insert(560);
            ygdrasil.insert(47);
            ygdrasil.insert(89);
            ygdrasil.insert(77);
            ygdrasil.insert(483);
            ygdrasil.insert(963);
            ygdrasil.insert(1000);
            ygdrasil.insert(963);

        /*ygdrasil.search(7);
        ygdrasil.search(8);
        ygdrasil.search(1);
        ygdrasil.search(5);
        ygdrasil.search(89);
        ygdrasil.search(560);
        ygdrasil.search(999);
        ygdrasil.search(890);
        ygdrasil.search(9);
        ygdrasil.search(560);
        ygdrasil.search(47);
        ygdrasil.search(473);
        ygdrasil.search(10);
        ygdrasil.search(77);
        ygdrasil.search(483);
        ygdrasil.search(56871);
        ygdrasil.search(963);
        ygdrasil.search(1000);
        ygdrasil.search(22);
        ygdrasil.search(2);*/

            ygdrasil.delete(7);
            ygdrasil.delete(89);
            ygdrasil.delete(560);
            ygdrasil.delete(89);
            ygdrasil.delete(47);
            ygdrasil.delete(89);
            ygdrasil.delete(77);
            ygdrasil.delete(483);
            ygdrasil.delete(963);
            ygdrasil.delete(1000);
            ygdrasil.delete(963);

            ygdrasil.search(7);
            ygdrasil.search(1);
            ygdrasil.search(5);
            ygdrasil.search(89);
            ygdrasil.search(560);
            ygdrasil.search(89);
            ygdrasil.search(9);
            ygdrasil.search(560);
            ygdrasil.search(47);
            ygdrasil.search(89);
            ygdrasil.search(77);
            ygdrasil.search(483);
            ygdrasil.search(963);
            ygdrasil.search(1000);
            ygdrasil.search(963);


            Test.treeTest(ygdrasil, "AVLTest.txt");

            AATree nimloth = new AATree();
            Test.treeTest(nimloth, "AATest.txt");

       /* ygdrasil.insert("pain");
        ygdrasil.insert("dd");
        ygdrasil.insert("aa");
        ygdrasil.insert("cc");
        ygdrasil.insert("pais");
        ygdrasil.insert("pain");
        ygdrasil.insert("p");
        ygdrasil.insert("abcd");*/

//        ygdrasil.insert(1);
//        ygdrasil.insert(1);
//        ygdrasil.insert(5);
//        ygdrasil.insert(89);
//        ygdrasil.insert(56);
//        ygdrasil.insert(9);
//
//        ygdrasil.search(1);
//        ygdrasil.search(1);
//        ygdrasil.search(5);
//        ygdrasil.search(89);
//        ygdrasil.search(56);
//        ygdrasil.search(9);
//
//        ygdrasil.delete(9);
//        ygdrasil.delete(56);
//
//        ygdrasil.search(1);
//        ygdrasil.search(1);
//        ygdrasil.search(5);
//        ygdrasil.search(89);
//        ygdrasil.search(56);
//        ygdrasil.search(9);
//
//        ygdrasil.printTree();

            //Test.treeTest(ygdrasil);


        /*ygdrasil.search("pain");
        ygdrasil.search("dd");
        ygdrasil.search("aa");
        ygdrasil.search("pais");
        ygdrasil.search("p");
        ygdrasil.search("abcd");*/


//        AATree nimloth = new AATree();
//        Test.treeTest(nimloth);
//
//        nimloth.insert(1);
//        nimloth.insert(1);
//        nimloth.insert(5);
//        nimloth.insert(89);
//        nimloth.insert(56);
//        nimloth.insert(9);
//
//        nimloth.search(1);
//        nimloth.search(1);
//        nimloth.search(5);
//        nimloth.search(89);
//        nimloth.search(56);
//        nimloth.search(9);
//
//        nimloth.delete(9);
//        nimloth.delete(56);
//
//        nimloth.search(1);
//        nimloth.search(1);
//        nimloth.search(5);
//        nimloth.search(89);
//        nimloth.search(56);
//        nimloth.search(9);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}