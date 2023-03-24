import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void treeEffectivity(DefaultTree tree){
        //test insertion and balancing
        tree.insert("Odysseus");
        tree.insert("Achilles");
        tree.insert("Hector");
        tree.insert("Odysseus"); //duplicate
        tree.insert("Menelaos");
        tree.insert("Achilles"); //duplicate
        tree.insert("Patroclus");
        tree.insert("Patroclus"); //duplicate
        tree.insert("Telemachus");
        tree.insert("Helen");
        tree.insert("Agamemnon");

        //search elements
        tree.search("Odysseus");
        tree.search("Achilles");
        tree.search("Hector");
        tree.search("Ares"); //not present
        tree.search("Menelaos");
        tree.search("Agamemnon");
        tree.search("Artemis");
        tree.search("Athena"); //not present
        tree.search("Patroclus");
        tree.search("Apollo"); //not present
        tree.search("Telemachus");
        tree.search("Helen");

        //delete elements
        tree.delete("Patroclus");
        tree.delete("Ares"); //not present
        tree.delete("Hector");
        tree.delete("Athena"); //not present
        tree.delete("Achilles");
        tree.delete("Agamemnon ");

        //search if deleted elements were deleted
        tree.search("Odysseus");
        tree.search("Achilles");
        tree.search("Hector");
        tree.search("Ares"); //not present
        tree.search("Menelaos");
        tree.search("Athena"); //not present
        tree.search("Patroclus");
        tree.search("Agamemnon ");
        tree.search("Apollo"); //not present
        tree.search("Telemachus");
        tree.search("Helen");

        tree.emptyTree();
    }
    public static void tableEffectivity(HashTable table){
        //test insertion and balancing
        table.insert("Odysseus", 5);
        table.insert("Achilles", 8);
        table.insert("Hector", 3345);
        table.insert("Odysseus", 95); //duplicate but with different value
        table.insert("Menelaos", 95234);
        table.insert("Achilles", 8); //duplicate
        table.insert("Patroclus", 55);
        table.insert("Patroclus", 55); //duplicate
        table.insert("Telemachus", 95);
        table.insert("Helen", 95);

        //search elements
        table.search("Odysseus");
        table.search("Achilles");
        table.search("Hector");
        table.search("Areas"); //not present
        table.search("Menelaos");
        table.search("Athena"); //not present
        table.search("Patroclus");
        table.search("Apollo"); //not present
        table.search("Telemachus");
        table.search("Helen");

        //delete elements
        table.delete("Patroclus");
        table.delete("Areas"); //not present
        table.delete("Hector");
        table.delete("Athena"); //not present
        table.delete("Achilles");

        //search if deleted elements were deleted
        table.search("Odysseus");
        table.search("Achilles");
        table.search("Hector");
        table.search("Areas"); //not present
        table.search("Menelaos");
        table.search("Athena"); //not present
        table.search("Patroclus");
        table.search("Apollo"); //not present
        table.search("Telemachus");
        table.search("Helen");

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

                    tree.emptyTree();
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

                    table.emptyTable();
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
            String dataPath = "C:\\Users\\lordp\\IdeaProjects\\DSA_Project_1\\dataSets\\String";
            String intDataPath = "C:\\Users\\lordp\\IdeaProjects\\DSA_Project_1\\dataSets\\Int";



            //AVL tree
            //create a AvlTree object
            AVLTree ygdrasil = new AVLTree();
            //send the AVLtree as parameter to the effectivity function
            Test.treeEffectivity(ygdrasil);
            //test the tree on the given datasets
            Test.treeTest(ygdrasil, dataPath,"AVLTest.txt");

            //AA Tree
            //create a AATree object
            AATree nimloth = new AATree();
            //send the AAtree as parameter to the effectivity function
            Test.treeEffectivity(nimloth);
            //test the tree on the given datasets
            Test.treeTest(nimloth, dataPath,"AATest.txt");

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

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}