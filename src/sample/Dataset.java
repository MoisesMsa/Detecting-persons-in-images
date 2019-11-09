package sample;

import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;

public class Dataset{
    private
        final String path = "/home/moita/IdeaProjects/lp2/dataset/dataset.csv";
        List<String[]> data = new <String[]> ArrayList();

    public Dataset(){
        try{
            this.readFile();
        }catch(Exception e){
            System.out.println("Error reading the file.");
        }
    }

    public void readFile() throws IOException {
        String row;

        BufferedReader csv = new BufferedReader(new FileReader(this.getPath()));
        while ((row = csv.readLine()) != null) {
            String[] r = row.split(",");
            this.data.add(r);
        }
        csv.close();
    }

    public String getPath() {
        return path;
    }

    public List<String[]> getData() {
        return data;
    }
}
