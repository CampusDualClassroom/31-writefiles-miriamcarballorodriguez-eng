package com.campusdual.classroom;

import com.campusdual.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Exercise {

    public static void main(String[] args) {
        String input = generateStringToSave(null);
        printToFile(input);

    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;
        }
        return generateUserInputToSave();
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }
    public static void printToFile(String string) {
        Path path = Paths.get("src/main/resources/data.txt");
        try{
            Files.createDirectories(path.getParent());
            Files.write(path, string.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribie en fichero", e);
        }
    }
}