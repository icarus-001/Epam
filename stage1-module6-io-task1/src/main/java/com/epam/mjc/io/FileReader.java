package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        String input = "";
        try (java.io.FileReader fr = new java.io.FileReader(file); BufferedReader br = new BufferedReader(fr))
        {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }


            input = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] inputs = input.split("Email: |Age: |Name: |Phone: ");
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = inputs[i].trim();
        }


        return new Profile(inputs[1], Integer.parseInt(inputs[2]), inputs[3], Long.parseLong(inputs[4]));
    }
}
