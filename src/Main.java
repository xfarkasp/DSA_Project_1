import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        AVLTree ygdrasil = new AVLTree();

       /* ygdrasil.insert("pain");
        ygdrasil.insert("dd");
        ygdrasil.insert("aa");
        ygdrasil.insert("cc");
        ygdrasil.insert("pais");
        ygdrasil.insert("pain");
        ygdrasil.insert("p");
        ygdrasil.insert("abcd");*/

        ygdrasil.insert(1);
        ygdrasil.insert(1);
        ygdrasil.insert(5);
        ygdrasil.insert(89);
        ygdrasil.insert(56);
        ygdrasil.insert(9);

        ygdrasil.delete(9);
        ygdrasil.delete(56);

        ygdrasil.printTree();

        /*ygdrasil.search("pain");
        ygdrasil.search("dd");
        ygdrasil.search("aa");
        ygdrasil.search("pais");
        ygdrasil.search("p");
        ygdrasil.search("abcd");*/

        //AVL tree testing
        Runtime rt = Runtime.getRuntime();
        long preMem;
        long postMem;

        String dataPath = "C:\\Users\\lordp\\IdeaProjects\\DSA_Project_1\\dataSets";
        File dir = new File(dataPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                BufferedReader br = new BufferedReader(new FileReader(child));
                String line = null;

                //insert dataset to an array
                ArrayList<Integer> dataSet = new ArrayList();
                while ((line = br.readLine()) != null) {dataSet.add(Integer.valueOf(line));}

                //record start time and start memory usage
                long start1 = System.nanoTime();
                Runtime runTime = Runtime.getRuntime();

                //start inserting to
                System.out.println("starting inserting");
                for(int i = 0; i < dataSet.size(); i++){
                    ygdrasil.insert(dataSet.get(i));
                }
                runTime.gc();
                double memory =  runTime.totalMemory() - runTime.freeMemory();

                long end1 = System.nanoTime();
                double timeSeconds = (end1 - start1) * Math.pow(10, -9);

                System.out.println("Data set used: " + child);
                System.out.println("Execution time: " + timeSeconds + " seconds");
                System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
            }
        }

        AATree nimloth = new AATree();

        nimloth.insert(6);
        nimloth.insert(7);
        nimloth.insert(34);
        nimloth.insert(22);
        nimloth.insert(4);

        nimloth.search(6);
        nimloth.search(7);
        nimloth.search(34);
        nimloth.search(22);
        nimloth.search(4);

        nimloth.delete(22);
        nimloth.delete(7);

        nimloth.search(6);
        nimloth.search(7);
        nimloth.search(34);
        nimloth.search(22);
        nimloth.search(4);

        if (directoryListing != null) {
            for (File child : directoryListing) {
                BufferedReader br = new BufferedReader(new FileReader(child));
                String line = null;

                //insert dataset to an array
                ArrayList<Integer> dataSet = new ArrayList();
                while ((line = br.readLine()) != null) {dataSet.add(Integer.valueOf(line));}

                //record start time and start memory usage
                long start1 = System.nanoTime();
                Runtime runTime = Runtime.getRuntime();

                //start inserting to
                System.out.println("starting inserting");
                for(int i = 0; i < dataSet.size(); i++){
                    nimloth.insert(dataSet.get(i));
                }
                runTime.gc();
                double memory =  runTime.totalMemory() - runTime.freeMemory();

                long end1 = System.nanoTime();
                double timeSeconds = (end1 - start1) * Math.pow(10, -9);

                System.out.println("Data set used: " + child);
                System.out.println("Execution time: " + timeSeconds + " seconds");
                System.out.println("Memory usage: " + memory/(1024*1024) + " MB");
            }
        }
    }
}