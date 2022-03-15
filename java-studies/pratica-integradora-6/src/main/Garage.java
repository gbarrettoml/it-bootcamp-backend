package main;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private String id;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Garage(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles () {
        return this.vehicles;
    }
}
