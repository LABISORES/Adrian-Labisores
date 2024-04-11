import java.util.Scanner;
import java.util.ArrayList;

public class VehicleManagement {
   public static void main(String[] args) {
      ArrayList<Vehicle> vehicleList = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
   
      int choice;
      do {
         System.out.println("Menu:");
         System.out.println("1. Add a vehicle");
         System.out.println("2. Display a list of vehicle details");
         System.out.println("3. Delete a vehicle");
         System.out.println("4. Sort vehicle list by age");
         System.out.println("5. Quit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();
         scanner.nextLine();
      
         switch (choice) {
            case 1:
                    // Add vehicle
               System.out.print("Enter registration number: ");
               String regNo = scanner.nextLine();
               System.out.print("Enter make: ");
               String make = scanner.nextLine();
               System.out.print("Enter year of manufacture: ");
               int year = scanner.nextInt();
               System.out.print("Enter value: ");
               double value = scanner.nextDouble();
               scanner.nextLine();
               vehicleList.add(new Vehicle(regNo, make, year, value));
               System.out.println("Vehicle added successfully!");
               break;
            case 2:
                    // Display vehicle list
               System.out.println("List of vehicle details:");
               for (Vehicle v : vehicleList) {
                  System.out.println(v);
               }
               break;
            case 3:
            // Delete vehicle
               System.out.print("Enter the index of the vehicle to delete: ");
               int indexToDelete = scanner.nextInt();
               scanner.nextLine(); // consume newline
               if (indexToDelete >= 1 && indexToDelete <= vehicleList.size()) {
                  vehicleList.remove(indexToDelete - 1); // Adjust index to start from 0
                  System.out.println("Vehicle deleted successfully!");
               // Adjusting indexes for display
                  for (int i = indexToDelete - 1; i < vehicleList.size(); i++) {
                     Vehicle vehicle = vehicleList.get(i);        }
               } else {
                  System.out.println("Invalid index!");
               }
               break;
            case 4:
               int sortChoice;
               do {
                  System.out.println("Sort Menu:");
                  System.out.println("1. Sort by age (ascending)");
                  System.out.println("2. Sort by age (descending)");
                  System.out.println("3. Back to main menu");
                  System.out.print("Enter your choice: ");
                  sortChoice = scanner.nextInt();
                  scanner.nextLine(); // consume newline
               
                  switch (sortChoice) {
                     case 1:
                     // Sort by age (ascending)
                        for (int i = 0; i < vehicleList.size() - 1; i++) {
                           for (int j = 0; j < vehicleList.size() - i - 1; j++) {
                              if (vehicleList.get(j).calculateAge(2024) < vehicleList.get(j + 1).calculateAge(2024)) {
                                 Vehicle temp = vehicleList.get(j);
                                 vehicleList.set(j, vehicleList.get(j + 1));
                                 vehicleList.set(j + 1, temp);
                              }
                           }
                        }
                        System.out.println("List of vehicle details sorted by age (ascending):");
                        for (Vehicle v : vehicleList) {
                           System.out.println(v);
                        }
                        System.out.print("\n");
                        break;
                     case 2:
                     // Sort by age (descending)
                        for (int i = 0; i < vehicleList.size() - 1; i++) {
                           for (int j = 0; j < vehicleList.size() - i - 1; j++) {
                              if (vehicleList.get(j).calculateAge(2024) > vehicleList.get(j + 1).calculateAge(2024)) {
                                 Vehicle temp = vehicleList.get(j);
                                 vehicleList.set(j, vehicleList.get(j + 1));
                                 vehicleList.set(j + 1, temp);
                              }
                           }
                        }
                        System.out.println("List of vehicle details sorted by age (descending):");
                        for (Vehicle v : vehicleList) {
                           System.out.println(v);

                        }
                        System.out.print("\n");
                        break;
                     case 3:
                        System.out.println("Returning to main menu...");
                        break;
                     default:
                        System.out.println("Invalid choice. Please try again.");
                  }
                  
               } while (sortChoice != 3);
               break;
            case 5:
               System.out.println("Exiting program...");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
            
         System.out.print("\n");
      } while (choice != 5);
   
      scanner.close();
   }
   
}