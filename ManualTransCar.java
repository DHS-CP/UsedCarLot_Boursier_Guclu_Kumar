/*
 * Gorkem Guclu
 * Micah Boursier
 * Sankalp Kumar
 * AP CSA
 * Kaehms Period 2
 * UsedCarLot Project
 * Has a method to set the number of gears
 * Uses super to instantiate its variables
 * Has a getter and setter for numGears
 */
public class ManualTransCar extends Car{
private int numGears;

public ManualTransCar(){
  super();
  setNumGears(5);
}

public  ManualTransCar( int p,String m, int  ng){
   super(p,m);
   setNumGears(5);
}

public void setNumGears(int ng){
    
    if (3<ng && ng <=6){
  
         numGears=ng;
  }
  else {
       numGears=5;
  }
}

public int getNumGears(){
  return numGears;
}

}
