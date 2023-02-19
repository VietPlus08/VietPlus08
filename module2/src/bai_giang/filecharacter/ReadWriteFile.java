package bai_giang.filecharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static final String BLANK = "";
    public static final String DELIMITER = ",";

    // using buffered
    public static void writeToFile(String path, List<Student> studentList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            for (Student st: studentList) {
                writer.write(st.toStringFile());
                writer.write("\n");
            }
            // writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                Student student = new Student(result);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}