import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Showroom implements Utility, Serializable {
    private String showroomName;
    private String showroomAddress;
    private String managerName;

    private ArrayList<Employees> employees = new ArrayList<>();
    private ArrayList<Cars> cars = new ArrayList<>();

    @Override
    public void get_details() {
        System.out.println("\n===== Showroom Details =====");
        System.out.println("Name: " + showroomName);
        System.out.println("Address: " + showroomAddress);
        System.out.println("Manager: " + managerName);
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Cars in Stock: " + cars.size());
    }

    @Override
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Enter Showroom Details =====");
        System.out.print("Showroom Name: ");
        this.showroomName = sc.nextLine();
        System.out.print("Address: ");
        this.showroomAddress = sc.nextLine();
        System.out.print("Manager Name: ");
        this.managerName = sc.nextLine();
        sc.close();
    }

    public void addEmployee(Employees e) { employees.add(e); }
    public void addCar(Cars c) { cars.add(c); }

    public ArrayList<Employees> getEmployees() { return employees; }
    public ArrayList<Cars> getCars() { return cars; }
}
