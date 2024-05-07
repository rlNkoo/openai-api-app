package pl.rlnkoo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        ChatGptHelper chatGptHelper = new ChatGptHelper();

        while (true) {
            System.out.println();
            System.out.println("Select an option:");
            System.out.println("1. Display products");
            System.out.println("2. Add products");
            System.out.println("3. Delete products");
            System.out.println("4. Generate 3 ideas for breakfast");
            System.out.println("5. Generate 3 ideas for dinner");
            System.out.println("6. Recommend healthy products I can buy");
            System.out.println("7. Finish");
            System.out.println();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Products: ");
                    productManager.getAllProducts().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("What product do you want to add?");
                    String product = scanner.nextLine();
                    productManager.addProduct(product);
                }
                case 3 -> {
                    System.out.println("What product do you want to remove?");
                    String product = scanner.nextLine();
                    productManager.deleteProduct(product);
                }
                case 4 -> {
                    System.out.println("ChatGPT ideas for breakfast:");
                    String breakfastIdea = chatGptHelper.getBreakfastIdea(productManager.getAllProducts());
                    System.out.println(breakfastIdea);
                }
                case 5 -> {
                    System.out.println("ChatGPT ideas for dinner:");
                    String dinnerIdea = chatGptHelper.getDinnerfastIdea(productManager.getAllProducts());
                    System.out.println(dinnerIdea);
                }
                case 6 -> {
                    System.out.println("ChatGPT recommended products");
                    String healthyProducts = chatGptHelper.getHealthyProductsRecomendation(productManager.getAllProducts());
                    System.out.println(healthyProducts);
                }
                case 7 -> {
                    System.out.println("Thank You, bye! :)");
                    System.exit(0);
                }
            }
        }
    }
}