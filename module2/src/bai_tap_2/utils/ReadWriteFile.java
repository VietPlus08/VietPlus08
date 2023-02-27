package bai_tap_2.utils;

import bai_tap_2.models.ATM;
import bai_tap_2.models.Card;
import bai_tap_2.models.CreditCard;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWriteFile {
    private static final String BLANK = "";
    private static final String DELIMITER = ",";
    private static final String PATH = ".\\src\\bai_tap_2\\card.csv";

    // using buffered
    public static void writeATMToFile(ATM item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(item.toStringFile());
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCreditCardToFile(CreditCard item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(item.toStringFile());
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> List<E> readFromFile(String card) {
        List<E> list = new ArrayList<>();
        List<ATM> atmList = new ArrayList<>();
        List<CreditCard> creditCardList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(BLANK)) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                if (result.length == 5) {
                    ATM item = new ATM(Arrays.asList(result));
                    atmList.add(item);
                } else {
                    CreditCard item = new CreditCard(Arrays.asList(result));
                    creditCardList.add(item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (card.equals("ATM")){
            return (List<E>) atmList;
        } else {
            return (List<E>) creditCardList;
        }
    }
}
