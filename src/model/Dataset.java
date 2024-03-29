package model;

import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Dataset{

    public Dataset() {
        try{
            this.readFile();
        }catch(Exception e){
            System.out.println("Error reading the file.");
        }
    }

    public void readFile() throws IOException {

        String row;
        int countLine = 0;

        BufferedReader csv = new BufferedReader(new FileReader(this.getPath()));

        while ((row = csv.readLine()) != null) {
            if(countLine > 0) {
                String[] r = row.split(",");
                this.data.add(r);
            }
            countLine++;
        }

        csv.close();
    }

    public String getPath() {
        return this.path;
    }

    public List<String[]> getData() {
        return this.data;
    }

    private
        final String path = System.getProperty("user.dir")+"/dataset/dataset_2019_1.csv";
        List<String[]> data = new <String[]> ArrayList();
}
