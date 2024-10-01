package com.enigma;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (true){
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter the number of parking slots: ");
                    int size = scanner.nextInt();
                    parkingLot = new ParkingLot(size);
                    System.out.println("Created a parking lot with " + size + " slot");
                    break;
                case 2:
                    if (parkingLot != null){
                        System.out.println("Enter Registration Number : ");
                        String registrationNumber = scanner.next();
                        System.out.println("Enter Colour : ");
                        String colour = scanner.next();
                        System.out.println("Enter Type (Mobil/Motor) : ");
                        String type = scanner.next();
                        if (!type.equalsIgnoreCase("Mobil") && !type.equalsIgnoreCase("Motor")){
                            System.out.println("Only Mobil and Motor are allowed");
                        } else {
                            Vehicle vehicle = new Vehicle(registrationNumber,colour,type);
                            int slotNumber = parkingLot.park(vehicle);
                            if (slotNumber != -1){
                                System.out.println("Allocated slot number : "+slotNumber);
                            } else {
                                System.out.println("Sorry, parking lot is full");
                            }
                        }
                    } else {
                        System.out.println("Parking lot is not created yet.");
                    }
                    break;
                case 3:
                    if (parkingLot != null){
                        System.out.println("Enter slot number to free : ");
                        int slotNumber = scanner.nextInt();
                        boolean success = parkingLot.leave(slotNumber);
                        if (success){
                            System.out.println("Slot number "+ slotNumber +" is free");
                        } else {
                            System.out.println("Slot number "+ slotNumber +" is invalid or already free");
                        }
                    }
                    break;
                case 4:
                    if (parkingLot != null){
                        parkingLot.status();
                    }
                    break;
                case 5:
                    if (parkingLot != null){
                        System.out.println("Enter vehicle type (Mobil/Motor) : ");
                        String type = scanner.next();
                        int count = parkingLot.countByVehicleType(type);
                        System.out.println("Number of "+type+": "+count);
                    }
                    break;
                case 6:
                   if (parkingLot != null){
                       List<String> oddPlate = parkingLot.findRegNumByOddEvenPlate(true);
                       System.out.println("Odd plate numbers : "+String.join(", ", oddPlate));
                   }
                   break;
                case 7:
                    if (parkingLot != null){
                        List<String> evenPlate = parkingLot.findRegNumByOddEvenPlate(false);
                        System.out.println("Even plate numbers : "+String.join(", ", evenPlate));
                    }
                    break;
                case 8:
                   if (parkingLot != null){
                       System.out.println("Enter vehicle colour : ");
                       String colour = scanner.next();
                       List<String> vehicleByColour = parkingLot.findRegNumByColour(colour);
                       System.out.println("Vehicles with colour : "+String.join(", ", vehicleByColour));
                   }
                   break;
                case 9:
                    if (parkingLot != null){
                        System.out.println("Enter vehicle colour : ");
                        String colour = scanner.next();
                        List<Integer> slotByColour = parkingLot.findSlotNumByColour(colour);
                        System.out.println("Slot numbers with colour "+colour+": "+slotByColour.toString().replaceAll("[\\[\\]]", ""));
                    }
                    break;
                case 10:
                    if (parkingLot != null){
                        System.out.println("Enter Registration Number: ");
                        String regNumber = scanner.next();
                        Integer slotNumber = parkingLot.findSlotNumByRegNumber(regNumber);
                        if (slotNumber != null){
                            System.out.println("Slot number: "+slotNumber);
                        } else {
                            System.out.println("Not Found");
                        }
                    }
                    break;

                case 11:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("===== Parking System Menu =====");
        System.out.println("1. Create Parking Lot");
        System.out.println("2. Park Vehicle");
        System.out.println("3. Leave Slot");
        System.out.println("4. Parking Status");
        System.out.println("5. Count Vehicles by Type");
        System.out.println("6. Find Registration Numbers with Odd Plates");
        System.out.println("7. Find Registration Numbers with Even Plates");
        System.out.println("8. Find Vehicles by Colour");
        System.out.println("9. Find Slot Numbers by Colour");
        System.out.println("10. Find Slot by Registration Number");
        System.out.println("11. Exit");
        System.out.println("Enter your choice : ");
    }
}
