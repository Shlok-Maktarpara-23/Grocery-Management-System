import java.util.Scanner;

class GroceryManagementSystem {
	
    Scanner sc = new Scanner(System.in);

    String[] groceryItems = new String[25];
    double[] itemPrices = new double[25];
    int[] itemQuantities = new int[25];
    int itemCount = 0;

    void initializeItems()
	{
        groceryItems[0] = "CHEESE";
        itemPrices[0] = 56;
        itemQuantities[0] = 6;
        groceryItems[1] = "BUTTOR";
        itemPrices[1] = 78;
        itemQuantities[1] = 2;
        groceryItems[2] = "WHEAT";
        itemPrices[2] = 48;
        itemQuantities[2] = 7;
        groceryItems[3] = "RICE";
        itemPrices[3] = 25;
        itemQuantities[3] = 10;
		groceryItems[4] = "SUGAR";
        itemPrices[4] = 90;
        itemQuantities[4] = 5;
        itemCount = 5;
		
		for (int i = 0; i < itemCount - 1; i++)
		{
			for (int j = 0; j < itemCount - i - 1; j++) 
			{
                if (groceryItems[j].compareToIgnoreCase(groceryItems[j + 1]) > 0) 
				{
					String tempItem = groceryItems[j];
					groceryItems[j] = groceryItems[j + 1];
					groceryItems[j + 1] = tempItem;
	
					double tempPrice = itemPrices[j];
					itemPrices[j] = itemPrices[j + 1];
					itemPrices[j + 1] = tempPrice;

					int tempQuantity = itemQuantities[j];
					itemQuantities[j] = itemQuantities[j + 1];
					itemQuantities[j + 1] = tempQuantity;
                }
            }
        }
    }

    void printGroceryItems() 
	{
        if (itemCount == 0) 
		{
            System.out.println("No Items in the list.");
        } 
		else 
		{
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println(" Item No. \t\t Item Name \t\t   Price/Kg.  \t\t     Quantity");
            System.out.println("----------------------------------------------------------------------------------------------");

            for (int i = 0; i < itemCount; i++) {
                System.out.printf("    %d \t\t\t  %-25s $ %-25s  %-25s\n", (i + 1), groceryItems[i], itemPrices[i], itemQuantities[i]);
            }
        }
    }

    void addItem()
	{
        if (itemCount >= 10) {
            System.out.println("No more space available in Inventory");
            return;
        }

        System.out.print("Item name: ");
        String itemName = sc.nextLine();

        for (int i = 0; i < itemCount; i++) {
            if (groceryItems[i].equalsIgnoreCase(itemName)) {
                System.out.println("\nItem already present in Inventory");
                System.out.println("Please enter a different Item\n");
                return;
            }
        }

        System.out.print("Item price per Kg: $");
        double itemPrice = sc.nextDouble();
        System.out.print("Item quantity: ");
        int itemQuantity = sc.nextInt();
        sc.nextLine();

        groceryItems[itemCount] = itemName;
        itemPrices[itemCount] = itemPrice;
        itemQuantities[itemCount] = itemQuantity;
        itemCount++;

        System.out.println("\nItem added successfully!\n");
    }

    void modifyItem() {
    System.out.print("Enter the Item number to modify: ");
    int itemNumber = sc.nextInt();
    System.out.println();

    if (itemNumber >= 1 && itemNumber <= itemCount) {
		System.out.println("Item at position " + itemNumber + " is: " + groceryItems[itemNumber-1]);
		System.out.println();

        boolean exitModify = false;
        while (!exitModify) {
            System.out.println("What would you like to change in the item?");
            System.out.println("1 -> Item name");
            System.out.println("2 -> Item price");
            System.out.println("3 -> Item quantity");
            System.out.println("4 -> Exit modification");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the new item name: ");
                    groceryItems[itemNumber - 1] = sc.nextLine().toUpperCase();
                    System.out.println("\nItem name modified successfully!\n");
                    break;
                case 2:
                    System.out.print("Enter the new item price: $");
                    itemPrices[itemNumber - 1] = sc.nextDouble();
                    System.out.println("\nItem price modified successfully!\n");
                    break;
                case 3:
                    System.out.print("Enter the new item quantity: ");
                    itemQuantities[itemNumber - 1] = sc.nextInt();
                    System.out.println("\nItem quantity modified successfully!\n");
                    break;
                case 4:
                    exitModify = true;
                    System.out.println("Modification successfully completed!");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice!\n");
                    break;
            }  
        }
    } else {
        System.out.println("Invalid Item number!\n");
    }
}


    void removeItem() 
	{
        System.out.print("Enter the Item number to remove: ");
        int itemNumber = sc.nextInt(); 
        System.out.println();

        if (itemNumber >= 1 && itemNumber <= itemCount) {
            System.out.println("Item at position " + itemNumber + " is: " + groceryItems[itemNumber - 1] + " removed successfully!\n");
			
            for (int i = itemNumber - 1; i < itemCount - 1; i++) {
                groceryItems[i] = groceryItems[i + 1];
                itemPrices[i] = itemPrices[i + 1];
                itemQuantities[i] = itemQuantities[i + 1];
            }
            itemCount--;
        } else {
            System.out.println("Invalid Item number!");
			System.out.println();
        }
    }

    void searchItem() 
	{
        System.out.print("Enter the Item name to search: ");
        String itemToSearch = sc.nextLine();
        System.out.println();

        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (groceryItems[i].equalsIgnoreCase(itemToSearch)) {
                System.out.println("Item " + itemToSearch.toUpperCase() + " found at position " + (i + 1));
                System.out.println("Price: $" + itemPrices[i]);
                System.out.println("Quantity: " + itemQuantities[i]);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found!");
			System.out.println();
        }
    }
	
	void detailInventoryItem() 
	{
		int totalItems = 0;
		double totalPrice = 0;
		int totalQuantity = 0;
		
        for (int i = 0; i < itemCount; i++) 
		{
            totalItems++;
        }
        System.out.println("Total Grocery Items in Inventory: " + totalItems);
		System.out.println();
		
		for (int i = 0; i < itemCount; i++) 
		{
            totalPrice += itemPrices[i] * itemQuantities[i];
        }
        System.out.println("Total Price of Items in Inventory: $" + totalPrice);
		System.out.println();
		
		for (int i = 0; i < itemCount; i++) 
		{
            totalQuantity += itemQuantities[i];
        }
        System.out.println("Total Quantity of Items in Inventory: " + totalQuantity);
		System.out.println();
    }
}

class GroceryItem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GroceryManagementSystem gms = new GroceryManagementSystem();
        gms.initializeItems(); 

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("                     *** Welcome to Grocery Management System ***");
        System.out.println("--------------------------------------------------------------------------------------\n");

        int choice;
        do {
            System.out.println("Press: ");
            System.out.println("1 -> Print the list of grocery items");
            System.out.println("2 -> Add an item to the list");
            System.out.println("3 -> Modify an item in the list");
            System.out.println("4 -> Remove an item from the list");
            System.out.println("5 -> Search for an item from the list");
            System.out.println("6 -> Print Inventory Details");
            System.out.println("7 -> Exit\n");

            System.out.print("Which section would you like to explore? (Enter the corresponding number): ");
            choice = sc.nextInt();
            sc.nextLine(); 
            System.out.println();

            switch (choice) {
                case 1:
					System.out.println();
					System.out.println("                                 ***** Grocery Items Inventory *****");
					System.out.println();
                    gms.printGroceryItems();
                    System.out.println();
                    break;
                case 2:
					System.out.println();
					System.out.println("                                 ***** Adding Items Section *****");
					System.out.println();
                    System.out.println("Enter details of new Items:- ");
					System.out.println();
                    gms.addItem();
                    break;
                case 3:
					System.out.println();
					System.out.println("                                 ***** Modification Items Section *****");
					System.out.println();	
                    gms.modifyItem();
                    break;
                case 4:
					System.out.println("                                 ***** Removing Items Section *****");
					System.out.println();
                    gms.removeItem();
                    break;
                case 5:
					System.out.println();
					System.out.println();
					System.out.println("                                 ***** Searching Items Section *****");
					System.out.println();
                    gms.searchItem();
                    break;
				case 6:
					System.out.println();
					System.out.println("                                 ***** Inventory Details *****");
					System.out.println();
					gms.detailInventoryItem();
					break;
                case 7:
                    System.out.println("Exiting the program...\n");
					System.out.println("                                 ***** Thank You *****");
                    break;
                default:
                    System.out.println("Please Enter a Valid Choice!");
                    System.out.println();
            }
        } while (choice != 7);
        sc.close();
    }
}