package activities;

public class Activity1 {
        public static void main(String args[]) {
            Car toyota = new Car();
            toyota.make = 2014;
            toyota.color = "black";
            toyota.transmission = "manual";

            toyota.displayCharacteristics();
            toyota.accelarate();
            toyota.brake();
        }
    }

