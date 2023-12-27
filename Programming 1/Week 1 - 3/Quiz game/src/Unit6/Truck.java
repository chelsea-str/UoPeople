package Unit6;

class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}