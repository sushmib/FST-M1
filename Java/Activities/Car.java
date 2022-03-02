package activities;

public class Car {
        String color;
        String transmission;
        int make;
        int tyres;
        int doors;

        Car(){
            tyres = 4;
            doors = 4;
        }
        public void displayCharacteristics(){
            System.out.println("This displays the values of all the variables");
            System.out.println("Car color: " +color);
            System.out.println("Car transmission: " +transmission);
            System.out.println("Car make: " +make);
            System.out.println("Car tyres: " +tyres);
            System.out.println("Car doors: " +doors);

        }
        public void accelarate(){
            System.out.println("Car is moving forward.");
        }
        public void brake(){
            System.out.println("Car has stopped.");
        }
    }

