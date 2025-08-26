import java.io.*;
import java.util.*;

public class Main {

    static void mainMenu() {
        System.out.println("\n===== Showroom Management System =====");
        System.out.println("1. Add Showroom");
        System.out.println("2. Add Employee to Showroom");
        System.out.println("3. Add Car to Showroom");
        System.out.println("4. View Showrooms");
        System.out.println("5. View Employees of a Showroom");
        System.out.println("6. View Cars of a Showroom");
        System.out.println("7. Save Data");
        System.out.println("8. Load Data");
        System.out.println("0. Exit");
        System.out.print("Enter Choice: ");
    }

    // Save data to file
    static void saveData(ArrayList<Showroom> showrooms) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("showrooms.dat"))) {
            oos.writeObject(showrooms);
            System.out.println("✅ Data saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    // Load data from file
static ArrayList<Showroom> loadData() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("showrooms.dat"))) {
        @SuppressWarnings("unchecked")
        ArrayList<Showroom> data = (ArrayList<Showroom>) ois.readObject();
        System.out.println("✅ Data loaded successfully!");
        return data;
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("⚠️ No saved data found. Starting fresh.");
        return new ArrayList<>();
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Showroom> showrooms = loadData();  // Load data on startup
        int choice;

        do {
            mainMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    Showroom showroom = new Showroom();
                    showroom.set_details(sc);
                    showrooms.add(showroom);
                    break;
                }
                case 2: {
                    if (showrooms.isEmpty()) {
                        System.out.println("No Showroom exists! Add a showroom first.");
                        break;
                    }
                    System.out.println("Select Showroom (0 to " + (showrooms.size()-1) + "): ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index < showrooms.size()) {
                        Employees emp = new Employees();
                        emp.set_details();
                        showrooms.get(index).addEmployee(emp);
                    } else {
                        System.out.println("Invalid showroom index.");
                    }
                    break;
                }
                case 3: {
                    if (showrooms.isEmpty()) {
                        System.out.println("No Showroom exists! Add a showroom first.");
                        break;
                    }
                    System.out.println("Select Showroom (0 to " + (showrooms.size()-1) + "): ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index < showrooms.size()) {
                        Cars car = new Cars();
                        car.set_details();
                        showrooms.get(index).addCar(car);
                    } else {
                        System.out.println("Invalid showroom index.");
                    }
                    break;
                }
                case 4: {
                    for (int i = 0; i < showrooms.size(); i++) {
                        System.out.println("Index: " + i);
                        showrooms.get(i).get_details();
                    }
                    break;
                }
                case 5: {
                    if (showrooms.isEmpty()) {
                        System.out.println("No Showroom exists!");
                        break;
                    }
                    System.out.println("Select Showroom index: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    if (idx >= 0 && idx < showrooms.size()) {
                        for (Employees e : showrooms.get(idx).getEmployees()) {
                            e.get_details();
                        }
                    }
                    break;
                }
                case 6: {
                    if (showrooms.isEmpty()) {
                        System.out.println("No Showroom exists!");
                        break;
                    }
                    System.out.println("Select Showroom index: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    if (idx >= 0 && idx < showrooms.size()) {
                        for (Cars c : showrooms.get(idx).getCars()) {
                            c.get_details();
                        }
                    }
                    break;
                }
                case 7:
                    saveData(showrooms);
                    break;
                case 8:
                    showrooms = loadData();
                    break;
                case 0:
                    saveData(showrooms); // Auto-save on exit
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        sc.close();
    }
}
