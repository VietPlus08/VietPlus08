package ss16.ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static List<Nation> readFromFile(String path){
        List<Nation> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = null;
            while ((line = br.readLine()) != null){
                list.add(new Nation(line.split(",")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
