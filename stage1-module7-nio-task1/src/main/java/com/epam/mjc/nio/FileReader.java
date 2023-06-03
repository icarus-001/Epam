package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static Profile getDataFromFile(File file) {
        Path path = Paths.get(file.toURI());
        String name;
        Integer age;
        String email;
        Long phone;
        String[] parts = new String[4];
        try (BufferedReader bf = new BufferedReader(new java.io.FileReader(file))){
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i++) {
                parts[i] = lines.get(i).split(": ")[1];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        name = parts[0];
        age = Integer.parseInt(parts[1]);
        email = parts[2];
        phone = Long.parseLong(parts[3]);
        return new Profile(name, age, email, phone);
    }
}