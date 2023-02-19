package bai_giang.filebinary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileBinaryDemo {
    public static void main(String[] args) {
//        try (FileOutputStream stream = new FileOutputStream(".\\src\\filecharacter\\test.dat")) {
//            stream.write(65);
//            stream.write(48);
//            stream.write(57);
//            stream.write("Hello world".getBytes());
//            stream.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileInputStream stream = new FileInputStream(".\\src\\filecharacter\\test.dat")){
            int result;
            while ((result = stream.read()) != -1) {
                System.out.print((char)result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
