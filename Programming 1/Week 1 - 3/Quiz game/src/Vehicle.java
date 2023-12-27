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

    public class Main {
        public static void main(String[] args) {
            Car car = new Car("Renault", "Duster", 2013);
            car.setNumDoors(4);
            car.setFuelType("Petrol");

            Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Fat Boy", 2023);
            motorcycle.setNumWheels(2);
            motorcycle.setMotorcycleType("Cruiser");

            Truck truck = new Truck("Iveco", "PowerStar", 2010);
            truck.setCargoCapacity(6.7);
            truck.setTransmissionType("Manual");

            displayVehicleDetails(car);
            displayVehicleDetails(motorcycle);
            displayVehicleDetails(truck);
        }

        private static void displayVehicleDetails(Vehicle vehicle) {
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Year: " + vehicle.getYear());

            switch (vehicle) {
                case CarVehicle car -> {
                    System.out.println("Number of Doors: " + car.getNumDoors());
                    System.out.println("Fuel Type: " + car.getFuelType());
                }
                case MotorVehicle motorcycle -> {
                    System.out.println("Number of Wheels: " + motorcycle.getNumWheels());
                    System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
                }
                case TruckVehicle truck -> {
                    System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
                    System.out.println("Transmission Type: " + truck.getTransmissionType());
                }
                case null, default -> {
                }
            }

            System.out.println("--------------------");
        }
    }
}
