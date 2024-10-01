package com.enigma;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    Vehicle[] slots;
    int capacity;

    public ParkingLot(int capacity) {
        this.slots = new Vehicle[capacity];
        this.capacity = capacity;
    }

    public int park(Vehicle vehicle){
        for (int i =0; i < capacity; i++){
            if (slots[i] == null){
                slots[i] = vehicle;
                return  i + 1;
            }
        }
        return -1;
    }

    public boolean leave(int slotNumber){
        if (slotNumber > 0 && slotNumber <= capacity && slots[slotNumber - 1] != null) {
            slots[slotNumber -1] = null;
            return true;
        }
        return false;
    }

    public void status(){
        System.out.println("Slot\tNo.\t\tType\tRegistration No\tColour");
        for (int i = 0; i < capacity; i++){
            if (slots[i] != null){
                Vehicle vehicle = slots[i];
                System.out.println((i + 1)+"\t" + vehicle.getRegistrationNumber());
            }
        }
    }

    public List<String> findRegNumByOddEvenPlate(boolean isOdd){
        List<String> regNumbers = new ArrayList<>();
        for (Vehicle vehicle : slots){
            if (vehicle != null && vehicle.isOddPlate() == isOdd){
                regNumbers.add(vehicle.getRegistrationNumber());
            }
        }
        return regNumbers;
    }

    public List<String> findRegNumByColour(String colour){
        List<String> regNumbers = new ArrayList<>();
        for (Vehicle vehicle : slots){
            if (vehicle != null && vehicle.getColour().equalsIgnoreCase(colour)){
                regNumbers.add(vehicle.getRegistrationNumber());
            }
        }
        return regNumbers;
    }

    public List<Integer> findSlotNumByColour(String colour){
        List<Integer> slotNumbers = new ArrayList<>();
        for (int i = 0; i < capacity; i++){
            if (slots[i] != null && slots[i].getColour().equalsIgnoreCase(colour)) {
                slotNumbers.add(i + 1);
            }
        }
        return slotNumbers;
    }

    public Integer findSlotNumByRegNumber(String regNumber){
        for (int i = 0; i < capacity; i++){
            if (slots[i] != null && slots[i].getRegistrationNumber().equalsIgnoreCase(regNumber)){
                return i+1;
            }
        }
        return null;
    }

    public int countByVehicleType(String type){
        int count = 0;
        for (Vehicle vehicle : slots){
            if (vehicle != null && vehicle.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        return count;
    }
}
