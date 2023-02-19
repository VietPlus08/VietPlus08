package ss16.ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static void writeToFile(String path, List<String> list){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String string : list) {
                bw.write(string);
                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static List<String> readFromFile(String path){
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = null;
            while ((line = br.readLine()) != null){
                list.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
