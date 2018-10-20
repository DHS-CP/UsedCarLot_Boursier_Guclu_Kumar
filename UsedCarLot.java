import java.util.List;
import java.util.ArrayList; 
import java.util.Scanner;
/*
 * Gorkem Guclu
 * Micah Boursier
 * Sankalp Kumar
 * AP CSA
 * Kaehms Period 2
 * UsedCarLot Project
 */
public class UsedCarLot
{
  // this is a brute force method of creating various car instance variables
  // How could we simplify this using a list?
 
  int totalValue;
  Scanner in = new Scanner(System.in);
  private List<Car> cars = new ArrayList<Car>();
  
 public UsedCarLot(){
     cars.add((Car) new AutoTransCar(2500,"VW Bug", false));
     cars.add((Car) new AutoTransCar(5000,"Ford Mustang", false));
     cars.add((Car) new ManualTransCar(12000,"Honda Fit", 5));
     
     /* Note Cannot instantiate c4 below.  Why?
     c4= (Car) new Car(12000,"Honda Fit");
     totalValue+=c4.getPrice();
     */
    
    prompt();
    
     // This is how you would have to determin number of gears of a manual trans
     // car.  Why?
     //System.out.println("c3 num gears = " + ((ManualTransCar)c3).getNumGears());
     
}

    public Car addCar(int p, String m, String carType, int ng){
         if (carType.equals("auto")){
             Car c=(Car) new AutoTransCar(p,m, false);
             cars.add(c);
             totalValue+=c.getPrice();
             System.out.println("Added Car: " + c);
             return c;
         }
            if (carType.equals("manual")) {
              Car c= (Car) new ManualTransCar(p,m, ng);
              cars.add(c);
              totalValue+=c.getPrice();  
              System.out.println("Added Car: " + c);
              return c;
            }
            System.out.println("AddCar: Incorrect car type passed to addCar method!");
            return null;
        }
    
    /**
     * removeCar takes a Car variable as a param, and returns a null pointer,
     * thus setting the Car that you are trying to remove to null.  Why can't
     * we do this inside the method?
     * To call: c=removeCar(c);
     * @param c the car that you want to remove
     */
   /* public void removeCar(Car c){
        totalValue-=c.getPrice();
        return null;
        // you could call System.gc() to force garbage collection
    }*/

    /**
     * Just a test method to allow testing through Bluej
     * @param n the car (c1,c2...) that you want to remove
     */
    /*public  void testRemove(int n){
        if (n==1) { c1=removeCar(c1);}
        if (n==2) { c2=removeCar(c2);}
        if (n==3) { c3=removeCar(c3);}
    }*/
        
    
public void removeCars (String by, String s, int n){
    System.out.println("Are you sure? (Y/N)");
    String userChoice = in.nextLine();
    if (userChoice.equals("Y") || userChoice.equals("Yes") || userChoice.equals("y") || userChoice.equals("yes")) {
        int j = cars.size();
        for(int i=0; i < j; i++) {
            if (by.equals("model")) {
                if (cars.get(i).getModel().equals(s)) {
                    cars.remove(cars.get(i));
                    j = cars.size();
                    i--;
                }
            }
            if (by.equals("vin")) {
                if (cars.get(i).getVinNumber().equals(s)) {
                    cars.remove(cars.get(i));
                    j = cars.size();
                    i--;
                }
            }
            if (by.equals("color")) {
                if (cars.get(i).getColor().equals(s)) {
                    cars.remove(cars.get(i));
                    j = cars.size();
                    i--;
                }
            }
            if (by.equals("trans")) {
                if (cars.get(i).getTrans().equals(s)) {
                    cars.remove(cars.get(i));
                    j = cars.size();
                    i--;
                }
            }
            if (by.equals("price")) {
                if (cars.get(i).getPrice() <= n) {
                    cars.remove(cars.get(i));
                    j = cars.size();
                    i--;
                }
            }
            if (by.equals("year")) {
                if (cars.get(i).getYear() >= n) {
                    cars.remove(cars.get(i));
                    j = cars.size();
                    i--;
                }
            }
        }
            System.out.println("Removed cars");
    } else {
            System.out.println("The cars remain in the lot.");
        }
}

public void changePrice (String by, String s, int n) {
        System.out.println("What price should they be set to?");
        int newP = Integer.parseInt(in.nextLine());
        for (Car i : cars) {
            if (by.equals("model")) {
                if (i.getModel().equals(s)) {
                    i.setPrice(newP);
                }
            }
            if (by.equals("vin")) {
                if (i.getVinNumber().equals(s)) {
                    i.setPrice(newP);
                }
            }
            if (by.equals("price")) {
                if (i.getPrice() <= n) {
                    i.setPrice(newP);
                }
            }
            if (by.equals("year")) {
                if (i.getYear() >= n) {
                    i.setPrice(newP);
                }
            }
            if (by.equals("color")) {
                if (i.getColor().equals(s)) {
                    i.setPrice(newP);
                }
            }
            if (by.equals("trans")) {
                if (i.getTrans().equals(s)) {
                    i.setPrice(newP);
                }
            }
        }
            System.out.println("changed price to " + newP + " dollars.");

}  

public void listCars () {
    for (Car i : cars) {
        System.out.println(i);
    }
}

public void prompt () {
    boolean repeat = true;
    System.out.println("What would you like to do? (add, search, list all, stop)");
    String userChoice = in.nextLine();
    if (userChoice.contains("search") || userChoice.contains("Search") || userChoice.contains("look up") || userChoice.contains("Look up")) {
        System.out.println("What will you search for cars by? (Model, Vin, Price, Color, Year, etc.)");
        userChoice = in.nextLine();
        if (userChoice.contains("Model") || userChoice.contains("model")) {
            System.out.println("What model are you looking for?");
            String u = in.nextLine();
            //removeCarByModel(userChoice);
            for (Car i : cars) {
                if (i.getModel().equals(u)) {
                    System.out.println(i);
                }
            }
            System.out.println("What would you like to do with the cars you searched for? (remove or set price or nothing)");
            String e = in.nextLine();
            if (e.contains("remove") || e.contains("Remove") || e.contains("delete") || e.contains("Delete")){
                removeCars("model", u, 0);
            }
            if (e.contains("price") || e.contains("Price") || e.contains("cost") || e.contains("Cost")){
                changePrice("model", u, 0);
            }
        }
        if (userChoice.contains("Vin") || userChoice.contains("vin")) {
            System.out.println("What vin number are you looking for?");
            String u = in.nextLine();
            //removeCarByVin(userChoice);
            for (Car i : cars) {
                if (i.getVinNumber().equals(u)) {
                    System.out.println(i);
                }
            }
            System.out.println("What would you like to do with the cars you searched for? (remove or set price or nothing)");
            String e = in.nextLine();
            if (e.contains("remove") || e.contains("Remove") || e.contains("delete") || e.contains("Delete")){
                removeCars("vin", u, 0);
            }
            if (e.contains("price") || e.contains("Price") || e.contains("cost") || e.contains("Cost")){
                changePrice("vin", u, 0);
            }
        }
        if (userChoice.contains("Price") || userChoice.contains("price")) {
            System.out.println("What max price range are you looking for? (no commas or dollar signs)");
            int cost = Integer.parseInt(in.nextLine());
            //removeCarByPrice(cost);
            for (Car i : cars) {
                if (i.getPrice() == cost) {
                    System.out.println(i);
                }
            }
            System.out.println("What would you like to do with the cars you searched for? (remove or set price or nothing)");
            String e = in.nextLine();
            if (e.contains("remove") || e.contains("Remove") || e.contains("delete") || e.contains("Delete")){
                removeCars("price", "", cost);
            }
            if (e.contains("price") || e.contains("Price") || e.contains("cost") || e.contains("Cost")){
                changePrice("price", "", cost);
            }
        }
        if (userChoice.contains("Color") || userChoice.contains("color")) {
            System.out.println("What color are you looking for?");
            String u = in.nextLine();
            //removeCarByColor(userChoice);
            for (Car i : cars) {
                if (i.getColor().equals(u)) {
                    System.out.println(i);
                }
            }
            System.out.println("What would you like to do with the cars you searched for? (remove or set price or nothing)");
            String e = in.nextLine();
            if (e.contains("remove") || e.contains("Remove") || e.contains("delete") || e.contains("Delete")){
                removeCars("color", u, 0);
            }
            if (e.contains("price") || e.contains("Price") || e.contains("cost") || e.contains("Cost")){
                changePrice("color", u, 0);
            }
        }
        if (userChoice.contains("trans") || userChoice.contains("Trans")) {
            System.out.println("What type of transmission are you looking for?");
            String u = in.nextLine();
            if (u.equals("auto") || u.equals("Auto")) {
                u = "auto";
            } else {
                if (u.equals("manual") || u.equals("Manual")) {
                    u = "manual";
                } else {
                    u = "auto";
                }
            }
            //removeCarByColor(userChoice);
            for (Car i : cars) {
                if (i.getTrans().equals(u)) {
                    System.out.println(i);
                }
            }
            System.out.println("What would you like to do with the cars you searched for? (remove or set price or nothing)");
            String e = in.nextLine();
            if (e.contains("remove") || e.contains("Remove") || e.contains("delete") || e.contains("Delete")){
                removeCars("trans", u, 0);
            }
            if (e.contains("price") || e.contains("Price") || e.contains("cost") || e.contains("Cost")){
                changePrice("trans", u, 0);
            }
        }
        if (userChoice.contains("Year") || userChoice.contains("year")) {
            System.out.println("What minimum year are you looking for? (only numbers)");
            int y = Integer.parseInt(in.nextLine());
            //removeCarByPrice(cost);
            for (Car i : cars) {
                if (i.getYear() == y) {
                    System.out.println(i);
                }
            }
            System.out.println("What would you like to do with the cars you searched for? (remove or set price or nothing)");
            String e = in.nextLine();
            if (e.contains("remove") || e.contains("Remove") || e.contains("delete") || e.contains("Delete")){
                removeCars("year", "", y);
            }
            if (e.contains("price") || e.contains("Price") || e.contains("cost") || e.contains("Cost")){
                changePrice("year", "", y);
            }
        }
    } else {
        if (userChoice.contains("add") || userChoice.contains("Add") || userChoice.contains("create") || userChoice.contains("Create")) {
            System.out.println("What model car are you adding?");
            String m = in.nextLine();
            System.out.println("How much does the car cost? (no commas or dollar signs)");
            int p = Integer.parseInt(in.nextLine());
            System.out.println("What type of transmission does it have? (auto, manual)");
            String type = in.nextLine();
            int ng = 0;
            if (type.equals("manual")) {
                System.out.println("How many gears does it have?");
                ng = Integer.parseInt(in.nextLine());
            } else {
                ng = 0;
            }
            addCar(p, m, type, ng);
        } else {
            if (userChoice.contains("show") || userChoice.contains("Show") || userChoice.contains("list") || userChoice.contains("List")) {
                listCars();
            } else {
                if (userChoice.contains("stop") || userChoice.contains("Stop") || userChoice.contains("quit") || userChoice.contains("Quit")) {
                    repeat = false;
                }
            }
        }
    }
    
    if (repeat) {prompt();}
}

}
