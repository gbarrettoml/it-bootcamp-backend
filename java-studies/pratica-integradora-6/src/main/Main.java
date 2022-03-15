package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Garage garage = new Garage("1");
        garage.addVehicle(new Vehicle("Ford", "Fiesta", new BigDecimal(1000)));
        garage.addVehicle(new Vehicle("Ford", "Focus", new BigDecimal(1200)));
        garage.addVehicle(new Vehicle("Ford", "Explores", new BigDecimal(2500)));
        garage.addVehicle(new Vehicle("Fiat", "Uno", new BigDecimal(500)));
        garage.addVehicle(new Vehicle("Fiat", "Cronos", new BigDecimal(1000)));
        garage.addVehicle(new Vehicle("Fiat", "Torino", new BigDecimal(1250)));
        garage.addVehicle(new Vehicle("Chevrolet", "Aveo", new BigDecimal(1250)));
        garage.addVehicle(new Vehicle("Chevrolet", "Spin", new BigDecimal(2500)));
        garage.addVehicle(new Vehicle("Toyota", "Corola", new BigDecimal(1200)));
        garage.addVehicle(new Vehicle("Toyota", "Fortuner", new BigDecimal(3000)));
        garage.addVehicle(new Vehicle("Renault", "Logan", new BigDecimal(950)));

        System.out.println("Sorted by price");
        List<Vehicle> listSortedForPrice = garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getPrice))
                .collect(Collectors.toList());

        listSortedForPrice.forEach(System.out::println);

        System.out.println("Sorted by brand");
        List<Vehicle> listSortedForBrand = garage.getVehicles().stream()
                .sorted(Comparator.comparing(vehicle -> vehicle.getBrand().charAt(0)))
                .collect(Collectors.toList());

        listSortedForBrand.forEach(System.out::println);

        System.out.println("Vehicles below 1000");

        List<Vehicle> listedVehiclesBelowThousand = garage.getVehicles().stream()
                .filter(vehicle -> {
                    int result = vehicle.getPrice().compareTo(new BigDecimal(1000));
                    return result == -1;
                })
                .collect(Collectors.toList());

        listedVehiclesBelowThousand.forEach(System.out::println);

        System.out.println("Vehicles equal or above 1000");

        List<Vehicle> listedVehiclesAboveThousand = garage.getVehicles().stream()
                .filter( vehicle -> {
                    int result = vehicle.getPrice().compareTo(new BigDecimal(1000));
                    return result >= 0;
                })
                .collect(Collectors.toList());

        listedVehiclesAboveThousand.forEach(System.out::println);

        System.out.println("Median price for all vehicles");

        List<BigDecimal> allPrices = garage.getVehicles().stream()
                        .map(vehicle -> vehicle.getPrice())
                        .collect(Collectors.toList());

        BigDecimal totalPrice = allPrices.stream()
                        .reduce(BigDecimal::add)
                                .get();

        System.out.println("Median: $" + totalPrice.divide(new BigDecimal(
                garage.getVehicles().size()
        ), 2, RoundingMode.HALF_UP));





    }
}
