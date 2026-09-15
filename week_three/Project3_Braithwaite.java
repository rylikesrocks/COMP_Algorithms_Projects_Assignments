import java.util.ArrayList;

public class Project3_Braithwaite {
    static class Vehicle{
        String make;
        String model;
        String year;
        int currentSpeed;

        public Vehicle(){
            make = null;
            model = null;
            year = null;
            currentSpeed = 0;
        }

        public Vehicle(String make, String model, String year, int currentSpeed){
            this.make = make;
            this.model = model;
            this.year = year;
            this.currentSpeed = currentSpeed;
        }

        public void accelerate(int amount){
            currentSpeed = currentSpeed + amount;
        }

        public void brake(int amount){
            currentSpeed = currentSpeed - amount;
        }

        @Override 
        public String toString(){
            return "\nMake: " + make + " Model: " + model + " Year: " + year + " Current Speed: " + currentSpeed + "\n\n";
        }

    }
    static class Car extends Vehicle{
        int numberOfDoors;

        public Car(){
            numberOfDoors = 0;
        }

        public Car(int numberOfDoors){
            this.numberOfDoors = numberOfDoors;
        }

        public Car(int numberOfDoors, String make, String model, String year, int currentSpeed){
            super(make, model, year, currentSpeed);
            this.numberOfDoors = numberOfDoors;
        }

        @Override
        public void accelerate(int amount){
            currentSpeed = currentSpeed + amount;
        }

        @Override
        public String toString(){
            return "\nNumber of doors: " + numberOfDoors + " Make: " + make + " Model: " + model + " Year: " + year + " Current Speed: " + currentSpeed + "\n\n";
        }


    }

    static class Truck extends Vehicle{
        double payloadCapacity;
        double totalWeight;

        public Truck(){
            payloadCapacity = 0;
            totalWeight = 0;
        }

        public Truck(double payloadCapacity, double totalWeight, String make, String model, String year, int currentSpeed){
            super(make, model, year, currentSpeed);
            this.payloadCapacity = payloadCapacity;
            this.totalWeight = totalWeight;
        }

        public void loadCargo(double weight){
            if((weight + totalWeight) > payloadCapacity){
                throw new IllegalArgumentException("Weight Added Exceeds Capacity!!");
            } else {
                this.totalWeight = weight;
            }
        }

        @Override
        public String toString(){
            return "\nCurrent Weight: " + totalWeight + " Payload Capacity: " + payloadCapacity + " Make: " + make + " Model: " + model + " Year: " + year + " Current Speed: " + currentSpeed + "\n\n";
        }
            
    }

    static class ElectricCar extends Car{
        int batteryCapacity;
        int currentCharge;

        public ElectricCar(){
            batteryCapacity = 0;
            currentCharge = 0;
        }

        public ElectricCar(int batteryCapacity, int currentCharge, int numberOfDoors, String make, String model, String year, int currentSpeed){
            super(numberOfDoors, make, model, year, currentSpeed);
            this.batteryCapacity = batteryCapacity;
            this.currentCharge = currentCharge;
        }

        @Override 
        public void accelerate(int amount){
            int discharge = (amount / currentSpeed) * 2;
            if(currentCharge < discharge){
                throw new IllegalArgumentException("You are accelerating too fast! Your vehicle will run out of power!");
            }else{
                currentCharge = currentCharge - discharge;
                currentSpeed = currentSpeed + amount;
            }
        }

        @Override 
        public String toString(){
            return "\nMake: " + make + " Model: " + model + " Battery Capacity: " + batteryCapacity + " Current Charge: " + currentCharge + " Year: " + year + " Current Speed: " + currentSpeed + "\n\n";
        }
        public void charge(int amountKwh){
            if(amountKwh > batteryCapacity){
                throw new IllegalArgumentException("If you keep charging your car like this, you will overload the battery!");
            }else{
                currentCharge = currentCharge + amountKwh;
            }
        }    
    }
    static ArrayList<Vehicle> fleet = new ArrayList<>();
    public static void printFleetStatus(){
        System.out.println("Here is the current status of out fleet:");
        System.out.print(fleet);
    }

    public static void main(String[] args) {
        Truck semi = new Truck(5, 1, "Peterbilt", "579", "2012", 5);
        Vehicle superCar = new Vehicle("Toyota", "Supra GR", "2026", 45);
        Car regularCar = new Car(4, "Honda", "Civc", "2012", 30);
        ElectricCar electricCar = new ElectricCar(70, 35, 4, "Tesla", "Model S", "2024", 70);

        fleet.add(semi);
        fleet.add(superCar);
        fleet.add(regularCar);
        fleet.add(electricCar);

        printFleetStatus();
    }

}




/*
Analysis:

The reason ElectricCar extends car and not vehicle is because a car is a certain type of vehicle, and an electric car is a certain type of car.
You could inherit only vehicle and that would be fine, but from a code design standpoint it would make much more sense to inherit Car and its methods, constructors, variables, and attributes.

If you wanted to have a hybrid car that implements both Car and Electric Car, you would need to implement something called interfaces.
Interfaces are a way of combining multiple class attributes together, by creating a contract defining what, for example, a vehicle is.
Imagine you had two interfaces which defined what both a Car and Electric Car is. It establishes their differences by creating two methods defining gasCapacity and batteryCapacity.
Now is when the interface comes in, as you could take those two defining methods and combine them using a simple comma when declaring the HybridCar class.
Then you would be able to see the batteryCapacity and gasCapacity of your hybrid car.
An interface is just like a blueprint for classes.


*/
