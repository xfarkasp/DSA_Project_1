package com.vinrithi.main;

import java.io.*;
import java.util.Random;

public class dataSetGenerator {
    public static void main(String[] args) {
        Random ran = new Random();
        int number = 0;
        try (PrintWriter file = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("int10M.txt")));
        ) {

            for (int i = 1; i <= 10000000; i++) {
                number = ran.nextInt(9999999) + 1;
                file.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File test1.txt has been created!");
    }
}