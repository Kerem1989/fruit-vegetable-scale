import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Product> allFruitsandVegetables = new ArrayList<Product>();

    static String [] menyOptions = {"\n1. Add a product.",
                                    "2. Search the catalog.",
                                    "3. Browse the catalog.",
                                    "4. Remove a product.",
                                    "5. Exit the program"};
    static String [] catalogOptions = { "1. Browse the catalog.",
                                        "2. Search the catalog.",
                                        "3. Go back to the main menu."};


    public static void main(String[] args) {

        System.out.println("Welcome to the Fruit and Vegetable program.");
        System.out.print("Please enter any key to continue to the meny.");
        boolean quitProgram= false;
        String employeeInput = input.nextLine();

        do {
            for (String listOfOptions : menyOptions){
                System.out.println(listOfOptions);
            }
            System.out.print("Enter one of the following numbers to continue: ");

            try {

                int employeeInput2 = input.nextInt();
                input.nextLine();

                switch (employeeInput2){
                    case 1 -> createFruitOrVegetable();
                    case 2 -> searchTheCatalog();
                    case 3 -> browseTheCatalog();
                    case 4 -> removeProduct();
                    case 5 -> quitProgram = true;
                    default -> System.out.println("\nThe input is not valid, please try again");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nThe input is not valid, please enter a valid number between 1-6.");
                input.nextLine();
            }

        } while (quitProgram == false);
        System.out.println("\nThank you for using the Fruit and Vegetable program.");
        System.out.println("All credit goes to Kerem Incorporated.");

    }

    public static void createFruitOrVegetable (){
        System.out.print("Please enter the name of the product: ");
        String userSetFruit = input.nextLine();
        System.out.print("Please enter a price: ");
        int userSetPrice = input.nextInt();
        input.nextLine();
        System.out.print("Please enter if product is a fruit or vegetable: ");
        String userSetFruitOrVegetable = input.nextLine();
        if (userSetFruitOrVegetable.equalsIgnoreCase("Fruit") || userSetFruitOrVegetable.equalsIgnoreCase("Vegetable")){
            System.out.print("Please enter the producttype: ");
            String userSetProductType = input.nextLine();
            Product createdUserProduct = new Product(userSetFruit, userSetPrice, userSetFruitOrVegetable, userSetProductType);
            System.out.println("\nYou created the following product:");
            System.out.println(createdUserProduct.toString());
            allFruitsandVegetables.add(createdUserProduct);
        }
        else {
            System.out.println("Wrong input, you have to label your product a fruit or a vegetable.");
        }
    }

    public static void searchTheCatalog() {
        System.out.print("Please enter a keyword: ");
        String searchTerm = input.nextLine();
        for (Product catalog : allFruitsandVegetables) {
            if (catalog.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(catalog.toString());
                System.out.println("Do you want to calculate price for the product?");
                System.out.print("Please enter yes or no: ");
                String userChoiceYesOrNo = input.nextLine();
                if (userChoiceYesOrNo.equals("Yes")){
                    System.out.println("Please enter quantity: ");
                    int userChoicePrice = input.nextInt();
                    input.nextLine();
                    double sumOfPrice = userChoicePrice * catalog.getPrice();
                    System.out.println("The total price will be: " + sumOfPrice + " kr.");
                }
            }
        }
    }

    public static void browseTheCatalog () {
        boolean quitCatalog = false;
        System.out.println("Welcome to the product catalog, do you want to:");
        do {
            for (String browsingCatalog : catalogOptions){
                System.out.println(browsingCatalog);
            }
            System.out.print("Please enter a number: ");
            int userCatalogChoice = input.nextInt();
            input.nextLine();
            if (userCatalogChoice == 1) {
                for (Product primaryTypes : allFruitsandVegetables) {
                    System.out.println(primaryTypes.getFruitOrVegetable());
                }
                System.out.print("Choose a primarytype to continue: ");
                String userCatalogChoice2 = input.nextLine();
                for (Product secondaryTypes : allFruitsandVegetables) {
                    if (secondaryTypes.getFruitOrVegetable().toLowerCase().contains(userCatalogChoice2.toLowerCase())) {
                        System.out.println(secondaryTypes.getProductType());
                    }
                    System.out.print("Choose a producttype to continue: ");
                    String userCatalogChoice3 = input.nextLine();
                    for (Product producttype : allFruitsandVegetables) {
                        if (producttype.getProductType().toLowerCase().contains(userCatalogChoice2.toLowerCase())) {
                            System.out.println(producttype.toString());
                        }
                    }

                }
            }
            else if (userCatalogChoice == 3) {
                quitCatalog = true;
            }

        } while (quitCatalog == false);
    }

    public static void removeProduct(){
        System.out.println("Please enter the name of the product you want to remove: ");
        String userChoice = input.nextLine();
        for(int i = 0; i < allFruitsandVegetables.size(); i++){
            if(allFruitsandVegetables.get(i).getName().equals(userChoice)){
                allFruitsandVegetables.remove(i);
                break;
            }
        }
        System.out.println("The input is wrong or the product does not exist.");
    }

}