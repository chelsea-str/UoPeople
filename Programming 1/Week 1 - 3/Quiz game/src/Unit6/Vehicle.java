package Unit6;
import java.util.Scanner;

public interface Vehicle {
    /*/
    methods for retrieving
    the vehicle's make, model, and year of manufacture
     */
    String getMake();

    String getModel();

    int getYear();
}

interface CarVehicle extends Vehicle {
    void setNumDoors(int numDoors);

    int getNumDoors();

    void setFuelType(String fuelType);

    String getFuelType();
}

interface MotorVehicle extends Vehicle {
    void setNumWheels(int numWheels);

    int getNumWheels();

    void setMotorcycleType(String motorcycleType);

    String getMotorcycleType();
}

interface TruckVehicle extends Vehicle {
    /*/
        methods for setting and retrieving the cargo capacity (in tons)
        and the transmission type (manual or automatic).
     */
    void setCargoCapacity(double cargoCapacity);

    double getCargoCapacity();

    void setTransmissionType(String transmissionType);

    String getTransmissionType();

    class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Create different types of vehicles
            Vehicle vehicle = createVehicle(scanner);

            // Display vehicle details
            displayVehicleDetails(vehicle);

            // Close the scanner
            scanner.close();
        }

        private static Vehicle createVehicle(Scanner scanner) {
            System.out.println("Choose a vehicle type\n 1. Car\n 2. Motorcycle\n 3. Truck");
            int choice = scanner.nextInt();

            return switch (choice) {
                case 1 -> createCar(scanner);
                case 2 -> createMotorcycle(scanner);
                case 3 -> createTruck(scanner);
                default -> {
                    System.out.println("Invalid choice. Defaulting to Car.");
                    yield createCar(scanner);
                }
            };
        }

        private static Car createCar(Scanner scanner) {
            System.out.println("Enter information for the car");
            System.out.print("Make: ");
            String make = scanner.next();
            System.out.print("Model: ");
            String model = scanner.next();
            System.out.print("Year: ");
            int year = scanner.nextInt();

            Car car = new Car(make, model, year);

            System.out.print("Number of Doors: ");
            int numDoors = scanner.nextInt();
            car.setNumDoors(numDoors);

            // Use a try-catch block to handle potential exceptions for fuel type input
            try {
                System.out.print("Enter fuel type (Petrol, Diesel or Electric): ");
                String fuelTypeInput = scanner.next().toUpperCase();
                car.setFuelType(fuelTypeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid fuel type, enter Petrol, Diesel or Electric");
            }

            return car;
        }

        private static Motorcycle createMotorcycle(Scanner scanner) {
            System.out.println("Enter information for the motorcycle");
            System.out.print("Make: ");
            String make = scanner.next();
            System.out.print("Model: ");
            String model = scanner.next();
            System.out.print("Year: ");
            int year = scanner.nextInt();

            Motorcycle motorcycle = new Motorcycle(make, model, year);

            try {
                System.out.print("Number of Wheels: ");
                int numWheels = scanner.nextInt();
                motorcycle.setNumWheels(numWheels);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid, enter a number");
            }

            try {
                System.out.print("Enter motorcycle type (Sport, Cruiser or Off-road): ");
                String motorcycleType = scanner.next();
                motorcycle.setMotorcycleType(motorcycleType);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid, enter Sport, Cruiser or Off-road");
            }


            return motorcycle;
        }

        private static Truck createTruck(Scanner scanner) {
            System.out.println("Enter information for the truck");
            System.out.print("Make: ");
            String make = scanner.next();
            System.out.print("Model: ");
            String model = scanner.next();
            System.out.print("Year: ");
            int year = scanner.nextInt();

            Truck truck = new Truck(make, model, year);

            try {
                System.out.print("Cargo Capacity (in tons): ");
                double cargoCapacity = scanner.nextDouble();
                truck.setCargoCapacity(cargoCapacity);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid, enter cargo capacity in tons");
            }

            try {
                System.out.print("Enter transmission type (Manual or Automatic): ");
                String transmissionType = scanner.next();
                truck.setTransmissionType(transmissionType);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid, enter either Manual or Automatic");
            }

            return truck;
        }

        private static void displayVehicleDetails(Vehicle vehicle) {
            // Display vehicle details as before
            // ...
        }
    }
}
