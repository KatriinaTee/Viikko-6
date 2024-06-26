package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 /**
    Tehdään kerran alussa:
        1. git init
        2. git remote add origin .... (kopioi GitHub repositoryn sivulta)
        3. git branch -M main

    Tehdään aina kun halutaan tallentaa lokaalit muutokset GitHubiin:
        1.  git add .
        2.  git commit -m "VIESTI_TÄHÄN"
        3.  git push origin main   
   */

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        boolean exit = false;
        while(!exit) {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot, 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                    System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
                    int vehicle = Integer.parseInt(sc.nextLine());                        
                    System.out.println("Anna kulkuneuvon valmistaja:");
                    String manufacturer = sc.nextLine();
                    System.out.println("Anna kulkuneuvon malli:");
                    String model = sc.nextLine();
                    System.out.println("Anna kulkuneuvon huippunopeus:");
                    int power = Integer.parseInt(sc.nextLine());

                    if (vehicle == 1) {     
                        Car car = new Car(manufacturer, model, power);
                        vehicles.add(car);          

                    }else if (vehicle == 2) {
                        Plane plane = new Plane(manufacturer, model, power);
                        vehicles.add(plane);

                    }else if (vehicle == 3) {
                        Ship ship = new Ship(manufacturer, model, power);
                        vehicles.add(ship);
                    }   
                    break;

                    case 2:

                    for (int j = 0; j < vehicles.size(); j++) {
                        Vehicle vehicle2 = vehicles.get(j);
                        if (vehicle2 instanceof Car) {
                            System.out.println("Auto: "+ vehicle2.getManufacturer() + " " + vehicle2.getModel());                            
                        }else if (vehicle2 instanceof Plane) {
                            System.out.println("Lentokone: "+ vehicle2.getManufacturer() + " " + vehicle2.getModel());                            
                        }else if (vehicle2 instanceof Ship) {
                            System.out.println("Laiva: " + vehicle2.getManufacturer() + " " + vehicle2.getModel());
                        }

                        System.out.println("Moottori: " + vehicle2.getEngine().getName() + " " + vehicle2.getEngine().getPower() + "kW");
                        System.out.println("Huippunopeus: " + vehicle2.getMaxSpeed() + "km/h");
                        System.out.println(" ");
                    }
                    break;

                    case 3:
                    for (int j = 0; j < vehicles.size(); j++) {
                        Vehicle vehicle3 = vehicles.get(j);
                        if (vehicle3 instanceof Car) {
                            Car c = (Car) vehicle3;
                            c.drive();
                        }
                    }
                            break;

                    case 4:
                    for (int j = 0; j < vehicles.size(); j++) {
                        Vehicle vehicle4 = vehicles.get(j);
                        if (vehicle4 instanceof Plane) {
                            Plane p = (Plane) vehicle4;
                            p.fly();
                        }
                    }
                            break;

                    case 5:
                    for (int j = 0; j < vehicles.size(); j++) {
                        Vehicle vehicle5 = vehicles.get(j);
                        if (vehicle5 instanceof Ship) {
                            Ship s = (Ship) vehicle5;
                            s.sail();
                        }
                    }
                            break;

                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                 }        
            }

        }
        sc.close();
    }
}
