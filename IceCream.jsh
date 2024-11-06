import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

int vanillaPrice = 96;    
int chocolatePrice = 40;  
int strawberryPrice = 80; 

System.out.println("Would you like (v)anilla, (c)hocolate or (s)trawberry?");
String flavour = null;
if (scanner.hasNextLine()) {
    flavour = scanner.nextLine().trim().toLowerCase();
} else {
    System.out.println("No input provided for flavour. Exiting.");
}

int pricePerScoop = 0;
boolean validFlavour = true;

if (flavour != null) {
    switch (flavour) {
        case "v":
            pricePerScoop = vanillaPrice;
            break;
        case "c":
            pricePerScoop = chocolatePrice;
            break;
        case "s":
            pricePerScoop = strawberryPrice;
            break;
        default:
            System.out.println("We don't have that flavour.");
            validFlavour = false;
    }
    
    if (validFlavour) {
        System.out.println("How many scoops would you like?");
        int numberOfScoops = -1;
        if (scanner.hasNextLine()) {
            try {
                numberOfScoops = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } else {
            System.out.println("No input provided for number of scoops. Exiting.");
        }
        
        if (numberOfScoops >= 1 && numberOfScoops <= 3) {
            int conePrice = 100;
            int totalPriceInPence = conePrice + (pricePerScoop * numberOfScoops);
            int pounds = totalPriceInPence / 100;
            int pence = totalPriceInPence % 100;
            System.out.printf("That will be %d.%02d please.%n", pounds, pence);
        } else if (numberOfScoops < 1) {
            System.out.println("We don't sell just a cone.");
        } else if (numberOfScoops > 3) {
            System.out.println("That's too many scoops to fit in a cone.");
        }
    }
}
