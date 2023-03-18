import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void treeEffectivity(DefaultTree tree){
        tree.insert(7);
        tree.insert(1);
        tree.insert(5);
        tree.insert(89);
        tree.insert(560);
        tree.insert(47);
        tree.insert(89);
        tree.insert(77);
        tree.insert(483);
        tree.insert(963);
        tree.insert(1000);
        tree.insert(963);

        tree.search(7);
        tree.search(8);
        tree.search(1);
        tree.search(5);
        tree.search(89);
        tree.search(560);
        tree.search(999);
        tree.search(890);
        tree.search(9);
        tree.search(560);
        tree.search(47);
        tree.search(473);
        tree.search(10);
        tree.search(77);
        tree.search(483);
        tree.search(56871);
        tree.search(963);
        tree.search(1000);
        tree.search(22);
        tree.search(2);

        tree.delete(7);
        tree.delete(89);
        tree.delete(560);
        tree.delete(89);
        tree.delete(47);
        tree.delete(89);
        tree.delete(77);
        tree.delete(483);
        tree.delete(963);
        tree.delete(1000);
        tree.delete(963);

        tree.search(7);
        tree.search(1);
        tree.search(5);
        tree.search(89);
        tree.search(560);
        tree.search(89);
        tree.search(9);
        tree.search(560);
        tree.search(47);
        tree.search(89);
        tree.search(77);
        tree.search(483);
        tree.search(963);
        tree.search(1000);
        tree.search(963);

        tree.emptyTree();
    }
    public static void tableEffectivity(HashTable table){
        table.insert("pain", 5);
        table.insert("pian", 98);
        table.insert("adko matko", 25);
        table.insert("dusky horvath", 999);
        table.insert("slamor the boy without slam", 785);
        table.insert("denis mivan", 265);
        table.insert("jozo mrozo", 275);
        table.insert("zadok", 25);

        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("pain");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("pian");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("adko matko");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("naip");

        table.delete("dusky horvath");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("slamor the boy without slam");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("denis mivan");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("jozo mrozo");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("zadok");
        table.search("pain");
        table.search("pian");
        table.search("adko matko");
        table.search("naip");
        table.search("dusky horvath");
        table.search("slamor the boy without slam");
        table.search("denis mivan");
        table.search("jozo mrozo");
        table.search("zadok");
        table.search("naiggsczp");

        table.delete("naiggsczp");

        table.emptyTable();
    }
    public static void insertTest(DefaultTree tree, ArrayList<String> dataSet){
        //start inserting to
        for(int i = 0; i < dataSet.size(); i++){
            tree.insert(dataSet.get(i));
        }
    }

    public static void insertTest(HashTable table, ArrayList<String> dataSet, ArrayList<Integer> dataKey){
        //start inserting to
        for(int i = 0; i < dataSet.size(); i++){
            table.insert(dataSet.get(i), dataKey.get(i));
        }
    }

    public static void deleteTest(DefaultTree tree, ArrayList<String> dataSet){

        //start deleting
        for(int i = 0; i < dataSet.size(); i++){
            tree.delete(dataSet.get(i));
        }
    }

    public static void deleteTest(HashTable table, ArrayList<String> dataSet){

        //start deleting
        for(int i = 0; i < dataSet.size(); i++){
            table.delete(dataSet.get(i));
        }
    }

    public static void searchTest(DefaultTree tree, ArrayList<String> dataSet){
        //start search
        for(int i = 0; i < dataSet.size(); i++){
            tree.search(dataSet.get(i));
        }
    }

    public static void searchTest(HashTable table, ArrayList<String> dataSet){
        //start search
        for(int i = 0; i < dataSet.size(); i++){
            table.search(dataSet.get(i));
        }
    }

    public static void treeTest(DefaultTree tree,String dataPath, String fileName){
        try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        ) {
            Runtime rt = Runtime.getRuntime();
            File dir = new File(dataPath);
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File child : directoryListing) {
                    BufferedReader br = new BufferedReader(new FileReader(child));
                    String line = null;

                    //insert dataset to an array
                    ArrayList<String> dataSet = new ArrayList();
                    while ((line = br.readLine()) != null) {dataSet.add(line);}

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

    public static void tableTest(HashTable table,String pathKey, String pathValue,String fileName){
        try (PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        ) {
            Runtime rt = Runtime.getRuntime();
            File dirKey = new File(pathKey);
            File[] directoryKey = dirKey.listFiles();

            File dirValue = new File(pathValue);
            File[] directoryValue = dirValue.listFiles();

            int iteration = 0;
            if (directoryKey != null && directoryValue != null) {
                for (File child : directoryKey) {

                    File value = directoryValue[iteration];
                    BufferedReader br = new BufferedReader(new FileReader(child));
                    String line = null;

                    //insert key dataset to an array
                    ArrayList<String> dataSet = new ArrayList();
                    while ((line = br.readLine()) != null) {dataSet.add(line);}

                    //insert key dataset to an array
                    br = new BufferedReader(new FileReader(value));
                    ArrayList<Integer> dataSetInt = new ArrayList();
                    while ((line = br.readLine()) != null) {dataSetInt.add(Integer.valueOf(line));}


                    //INSERTION TESTING
                    //record start time and start memory usage
                    long start1 = System.nanoTime();
                    Runtime runTime = Runtime.getRuntime();
                    insertTest(table, dataSet, dataSetInt);
                    runTime.gc();
                    double memory =  runTime.totalMemory() - runTime.freeMemory();
                    long end1 = System.nanoTime();
                    double timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(table.getTableType() + " INSERTING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(table.getTableType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");

                    table.emptyTable();

                    //-INSERT - DELETE
                    start1 = System.nanoTime();

                    //start inserting to
                    insertTest(table, dataSet, dataSetInt);
                    runTime.gc();
                    memory =  runTime.totalMemory() - runTime.freeMemory();

                    //reorder the dataset for deletion
                    Collections.shuffle(dataSet);

                    //start deleting
                    deleteTest(table, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    end1 = System.nanoTime();
                    timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(table.getTableType() + " INSERTING DELETING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(table.getTableType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");

                    //-INSERT - SEARCH
                    start1 = System.nanoTime();

                    //start inserting to
                    insertTest(table, dataSet, dataSetInt);
                    runTime.gc();
                    memory =  runTime.totalMemory() - runTime.freeMemory();

                    //reorder the dataset for searching
                    Collections.shuffle(dataSet);

                    //start searching
                    searchTest(table, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    end1 = System.nanoTime();
                    timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(table.getTableType() + " INSERTING SEARCHING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(table.getTableType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");

                    table.emptyTable();

                    //-INSERT - SEARCH -DELETE
                    start1 = System.nanoTime();

                    //start inserting to
                    insertTest(table, dataSet, dataSetInt);
                    runTime.gc();
                    memory = (runTime.totalMemory() - runTime.freeMemory());

                    //reorder the dataset for searching
                    Collections.shuffle(dataSet);

                    //start searching
                    searchTest(table, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    //start deleting
                    deleteTest(table, dataSet);
                    runTime.gc();
                    memory = memory + (runTime.totalMemory() - runTime.freeMemory());

                    end1 = System.nanoTime();
                    timeSeconds = (end1 - start1) * Math.pow(10, -9);

                    System.out.println(table.getTableType() + " INSERTING SEARCHING DELETING TEST");
                    System.out.println("Data set used: " + dataSet.size());
                    System.out.println("Execution time: " + timeSeconds + " seconds");
                    System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
                    System.out.println("-----------------------------------------------------------");

                    file.println(table.getTableType() + " INSERTING TEST");
                    file.println("Data set used: " + dataSet.size());
                    file.println("Execution time: " + timeSeconds + " seconds");
                    file.println("Memory usage: " + memory/(1024*1024) + " MB");
                    file.println("-----------------------------------------------------------");
                    iteration++;
                }
            }
        } catch (IOException e) {e.printStackTrace();}
    }

    public static void main(String[] args){
        try {
            //path to the data set folder
            String dataPath = "C:\\Users\\pedro\\IdeaProjects\\DSA1\\dataSets\\String";
            String intDataPath = "C:\\Users\\pedro\\IdeaProjects\\DSA1\\dataSets\\Int";

            //AA Tree
            //create a AATree object
            AATree nimloth = new AATree();
            //send the AAtree as parameter to the effectivity function
            Test.treeEffectivity(nimloth);
            //test the tree on the given datasets
            Test.treeTest(nimloth, dataPath,"AATest.txt");

            //AVL tree
            //create a AvlTree object
            AVLTree ygdrasil = new AVLTree();
            //send the AAtree as parameter to the effectivity function
            Test.treeEffectivity(ygdrasil);
            //test the tree on the given datasets
            Test.treeTest(ygdrasil, dataPath,"AVLTest.txt");

            //Seperate Chaining
            SeperateChaining chain = new SeperateChaining();
            //send the LP hash table as parameter to the effectivity function
            Test.tableEffectivity(chain);
            //test the tree on the given datasets
            Test.tableTest(chain, dataPath, intDataPath, "SeperateChaining.txt");

            //Linear Probing
            LinearProbing probing = new LinearProbing();
            //send the LP hash table as parameter to the effectivity function
            Test.tableEffectivity(probing);
            //test the tree on the given datasets
            Test.tableTest(probing, dataPath, intDataPath, "LinearProbing.txt");

            /*String pathKey = "C:\\Users\\lordp\\OneDrive\\Documents\\AkademickaPoda\\2.LS\\DSA\\String\\Strings.txt";
            String pathValue = "C:\\Users\\lordp\\IdeaProjects\\DSA_Project_1\\dataSets\\6_int_10M.txt";

            BufferedReader br = new BufferedReader(new FileReader(pathKey));
            String line = null;
            ArrayList<String> dataSet = new ArrayList();
            while ((line = br.readLine()) != null) {dataSet.add(line);}

            br = new BufferedReader(new FileReader(pathValue));
            ArrayList<Integer> dataSetInt = new ArrayList();
            while ((line = br.readLine()) != null) {dataSetInt.add(Integer.valueOf(line));}

            //INSERTION TESTING
            //record start time and start memory usage
            long start1 = System.nanoTime();
            Runtime runTime = Runtime.getRuntime();
            //insertTest(tree, dataSet);
            for(int i = 0; i < dataSet.size(); i++){
                chain.insert(dataSet.get(i), dataSetInt.get(i));
            }
            runTime.gc();
            double memory =  runTime.totalMemory() - runTime.freeMemory();
            long end1 = System.nanoTime();
            double timeSeconds = (end1 - start1) * Math.pow(10, -9);

            //System.out.println(tree.getTreeType() + " INSERTING TEST");
            System.out.println("Data set used: " + dataSet.size());
            System.out.println("Execution time: " + timeSeconds + " seconds");
            System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
            System.out.println("-----------------------------------------------------------");*/



        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}