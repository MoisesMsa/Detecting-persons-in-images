package sample;

import java.io.FileReader;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;

public class Dataset {
    private
        final String path = "teste";
        List<String> data;


    public void readFile() throws IOException {
        int i = 0;
        String row = null;

        BufferedReader csv = new BufferedReader(new FileReader(this.getPath()));
        while ((row = csv.readLine()) != null) {
            String[] r = row.split(",");
            this.data.add(i++, r);
        }
        csv.close();
    }

    public String getPath() {
        return path;
    }

    public List<String> getData() {
        return data;
    }
}
