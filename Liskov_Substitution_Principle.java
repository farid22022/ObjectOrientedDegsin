
/* 
______________________________________________________________________________________________________________________________________________________
                                    Title: Demonstrating the Liskov Substitution Principle (LSP)  
                                                    Student : Md. Farid Hossen Rehad
                                                     Computer Science & Engineering 
                                                             Discipline
                                                        From Khulna University 
_______________________________________________________________________________________________________________________________________________________

*/


/**
 * Represents a vehicle with a method to accelerate.
 */
interface Vehicle {
    /**
     * Accelerates the vehicle.
     */
    void accelerate();
}

/**
 * Represents a car, a type of vehicle.
 */
class Car implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Car accelerating");
    }
}

/**
 * Represents an electric car, a special case of a car.
 */
class ElectricCar extends Car {
    /**
     * Accelerates the electric car.
     * This method overrides the accelerate method in the parent class.
     */
    @Override
    public void accelerate() {
        System.out.println("Electric car accelerating silently");
    }
}

/**
 * Represents a race car, a special case of a car.
 */
class RaceCar extends Car {
    /**
     * Accelerates the race car.
     * This method overrides the accelerate method in the parent class.
     */
    @Override
    public void accelerate() {
        System.out.println("Race car accelerating loudly");
    }
}

/**
 * Simulates a race scenario with different types of cars.
 */
class RaceSimulation {
    /**
     * Accelerates a vehicle.
     *
     * @param vehicle The vehicle to accelerate.
     */
    public void simulateRace(Vehicle vehicle) {
        vehicle.accelerate();
    }
}

/**
 * Demonstrates the usage of different types of cars in a race simulation.
 */
class LSPExample {
    public static void main(String[] args) {
        RaceSimulation raceSimulation = new RaceSimulation();

        Car regularCar = new Car();
        ElectricCar electricCar = new ElectricCar();
        RaceCar raceCar = new RaceCar();

        // Simulate race with different types of cars
        raceSimulation.simulateRace(regularCar);
        raceSimulation.simulateRace(electricCar);
        raceSimulation.simulateRace(raceCar);
    }
}

/**
 * In the above program, ElectricCar and RaceCar classes are special cases of the Car class.
 * The LSP is maintained because instances of ElectricCar and RaceCar can be substituted
 * for a Car without affecting the correctness of the program.
 */
