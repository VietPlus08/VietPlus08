package ss12;

import java.util.Scanner;

public class Test {
    static ProductRepo repo = new ProductRepo();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("Input 1. find all - 2. add - 3. update - 4. remove - 5. find by name ");
            System.out.print("6. Arrange list decrease by price - 7. Arrange list increase by price: ");
            switch (scan.nextLine().trim()) {
                case "1":
                    repo.findAll();
                    break;
                case "2":
                case "3":
                    add();
                    break;
                case "4":
                    remove();
                    break;
                case "5":
                    findByName();
                    break;
                case "6":
                    findAllSortByPriceIncrease();
                    break;
                case "7":
                    findAllSortByPriceDecrease();
                    break;
                default:
                    break;
            }
        }
    }

    private static void findByName() {
        System.out.print("Input name: ");
        String name = scan.next();
        repo.findByName(name);
    }

    private static void remove() {
        System.out.print("Input id: ");
        int id = Integer.parseInt(scan.next());
        String result = repo.removeById(id) ? "Remove sucessfully": "Remove unsucessfully";
        System.out.println(result);
    }

    private static void add() {
        System.out.print("Input id: ");
        int id = Integer.parseInt(scan.next());
        String result = repo.getById(id) == null ? "Add new product": "Update product";
        System.out.println(result);
        System.out.print("Input name: ");
        String name = scan.next();
        System.out.print("Input quantity: ");
        int quantity = Integer.parseInt(scan.next());
        System.out.print("Input price: ");
        int price = Integer.parseInt(scan.next());
        repo.add(new Product(id, name, quantity, price));
    }

    public static void findAllSortByPriceIncrease(){
        repo.findAllSortByPriceIncrease();
    }

    private static void findAllSortByPriceDecrease() {
        repo.findAllSortByPriceDecrease();
    }
}
