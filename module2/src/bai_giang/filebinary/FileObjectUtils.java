package bai_giang.filebinary;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class FileObjectUtils {
    public static void writeObject(String path, List<Student> list) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))){
            stream.writeObject(list);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFileObject(String path) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path))){
            return (List<Student>)stream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
