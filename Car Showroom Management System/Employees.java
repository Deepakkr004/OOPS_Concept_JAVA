import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

public class Employees implements Utility, Serializable {
    private String empId;
    private String empName;
    private int empAge;
    private String empDepartment;

    @Override
    public void get_details() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Age: " + empAge);
        System.out.println("Department: " + empDepartment);
    }

    @Override
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        this.empId = UUID.randomUUID().toString();
        System.out.println("\n===== Enter Employee Details =====");
        System.out.print("Name: ");
        this.empName = sc.nextLine();
        System.out.print("Age: ");
        this.empAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Department: ");
        this.empDepartment = sc.nextLine();
        sc.close();
    }
}
