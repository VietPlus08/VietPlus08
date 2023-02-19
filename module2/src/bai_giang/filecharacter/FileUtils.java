package bai_giang.filecharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String BLANK = "";
    public static final String DELIMITER = ",";

    public void writeToFile(String path, List<Student> studentList) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path, true);
            for (Student st: studentList) {
                writer.write(st.toStringFile());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // using try with resource
    public void writeToFile2(String path, List<Student> studentList) {
        try (FileWriter writer = new FileWriter(path, true)){
            for (Student st: studentList) {
                writer.write(st.toStringFile());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // using buffered
    public void writeToFile3(String path, List<Student> studentList) {
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

    public List<Student> readFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                Student student = new Student(
                        Integer.parseInt(result[0]),
                        result[1],
                        Float.parseFloat(result[2]));
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