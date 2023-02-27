package bai_tap_2.view;


import bai_tap_2.utils.DisplayEnum;
import bai_tap_2.utils.DisplayScanner;
import bai_tap_2.controllers.ATMController;
import bai_tap_2.controllers.CreditCardController;
import bai_tap_2.models.ATM;
import bai_tap_2.models.CreditCard;
import bai_tap_2.utils.CardMenu;
import bai_tap_2.utils.DisplayEnum;
import bai_tap_2.utils.MainMenu;

import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        ATMController atmController = new ATMController();
        CreditCardController creditCardController = new CreditCardController();
        while (true){
            DisplayEnum.displayMainMenu(MainMenu.class);
            System.out.print("Input your choice: ");
            switch (scanner.nextInt()){
                case 1:
                    DisplayEnum.displayMainMenu(CardMenu.class);
                    System.out.print("Input your choice: ");
                    String yourChoice = scanner.next();
                    if (yourChoice.equals("1")){
                        List<String> data = DisplayScanner.getDataFromConsole(ATM.getInfo());
                        atmController.add(data);
                        break;
                    } else if (yourChoice.equals("2")){
                        List<String> data = DisplayScanner.getDataFromConsole(CreditCard.getInfo());
                        creditCardController.add(data);
                    } else {
                        System.out.println("Not match");
                    }
                    break;
                case 2:
                    DisplayEnum.displayMainMenu(CardMenu.class);
                    System.out.print("Input your choice: ");
                    if (scanner.next().equals("1")){
                        System.out.print("Input id you want to remove: ");
                        String id = scanner.next();
                        if (atmController.remove(id)){
                            System.out.println("Remove successfully");
                        };
                        break;
                    }
                    if (scanner.next().equals("2")){
                        System.out.print("Input id you want to remove: ");
                        String id = scanner.next();
                        if (creditCardController.remove(id)){
                            System.out.println("Remove successfully");
                        };
                    }
                    break;
                case 3:
                    atmController.findAll().forEach(System.out::println);
                    creditCardController.findAll().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Input id/name you want to find: ");
                    String idOrName = scanner.next();
                    System.out.println(atmController.findByCode(idOrName));
                    System.out.println(creditCardController.findByCode(idOrName));
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }
    }
}
