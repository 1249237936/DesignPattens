package com.jason.designpattens.adapter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("C:/Develop/Intelij_project/trackerslist/trackers_all.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
