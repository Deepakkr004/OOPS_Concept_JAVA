import java.io.Serializable;
import java.util.Scanner;

public class Cars implements Utility, Serializable {
    private String carName;
    private String carColor;
    private String fuelType;
    private int carPrice;
    private String carType;
    private String transmission;

    @Override
    public void get_details() {
        System.out.println("Car Name: " + carName);
        System.out.println("Color: " + carColor);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Price: " + carPrice);
        System.out.println("Car Type: " + carType);
        System.out.println("Transmission: " + transmission);
    }

    @Override
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Enter Car Details =====");
        System.out.print("Car Name: ");
        this.carName = sc.nextLine();
        System.out.print("Car Color: ");
        this.carColor = sc.nextLine();
        System.out.print("Fuel Type (Petrol/Diesel): ");
        this.fuelType = sc.nextLine();
        System.out.print("Price: ");
        this.carPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("Car Type (Sedan/SUV/Hatchback): ");
        this.carType = sc.nextLine();
        System.out.print("Transmission (Automatic/Manual): ");
        this.transmission = sc.nextLine();
        sc.close();
    }
}
