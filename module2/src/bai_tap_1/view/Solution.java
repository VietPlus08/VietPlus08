package bai_tap_1.view;

import bai_tap_1.controllers.ExProController;
import bai_tap_1.controllers.ImProController;
import bai_tap_1.models.ExportProduct;
import bai_tap_1.models.ImportProduct;
import bai_tap_1.utils.DisplayMenu;
import bai_tap_1.utils.DisplayScanner;
import bai_tap_1.utils.MainMenu;
import bai_tap_1.utils.ProductMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        while (true) {
            DisplayMenu.displayMainMenu(MainMenu.class);
            ExProController exProController = new ExProController();
            ImProController imProController = new ImProController();
            System.out.print("Input your choice: ");
            switch (scanner.nextInt()){
                case 1:
                    DisplayMenu.displayMainMenu(ProductMenu.class);
                    System.out.print("Input your choice: ");
                    String yourChoice = scanner.next();
                    if (yourChoice.equals("1")){
                        List<String> data = DisplayScanner.getDataFromConsole(ExportProduct.getInfo());
                        exProController.add(data);
                        break;
                    } else if (yourChoice.equals("2")){
                        List<String> data = DisplayScanner.getDataFromConsole(ImportProduct.getInfo());
                        imProController.add(data);
                    } else {
                        System.out.println("Not match");
                    }
                    break;
                case 2:
                    DisplayMenu.displayMainMenu(ProductMenu.class);
                    System.out.print("Input your choice: ");
                    if (scanner.next().equals("1")){
                        System.out.print("Input id you want to remove: ");
                        String id = scanner.next();
                        if (exProController.remove(id)){
                            System.out.println("Remove successfully");
                        };
                        break;
                    }
                    if (scanner.next().equals("2")){
                        System.out.print("Input id you want to remove: ");
                        String id = scanner.next();
                        if (imProController.remove(id)){
                            System.out.println("Remove successfully");
                        };
                    }break;
                case 3:
                    exProController.findAll().forEach(System.out::println);
                    imProController.findAll().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Input id/name you want to find: ");
                    String idOrName = scanner.next();
                    exProController.findById(idOrName).forEach(System.out::println);
                    imProController.findById(idOrName).forEach(System.out::println);
                    break;
                default:
                    break;
            }

        }
    }

}
