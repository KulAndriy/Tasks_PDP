package io;

import main.EmployeeCollection;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOEmployeeDataToFile {
    EmployeeCollection employeeCollection = new EmployeeCollection();
    File file = new File("EmployeeData.txt");

    public void writeToFile(){
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file,false))){
            fileWriter.write(employeeCollection.getEmployeesList().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))){
           String line = fileReader.readLine();
            while (line != null){
                System.out.println(line);
                line = fileReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
