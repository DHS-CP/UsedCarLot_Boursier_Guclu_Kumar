import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.*;
import java.lang.Math;
import java.lang.Double;
/*
 * Gorkem Guclu
 * Micah Boursier
 * Sankalp Kumar
 * AP CSA
 * Kaehms Period 2
 * UsedCarLot Project
 */
public abstract class Car{
    List<int[]> list = new ArrayList<int[]>();
    int[] anArray;
    private int price;
    private String model;
    private String make;
    private String color;
    private int year;
    private String trans;
    private String vinNumber;
    private int x;

    public Car(){
        price=0;
        model="undef";
        year = 0;
        vinNumber = newVinNumber();
    }

    public Car (int p, int y, String mod, String c, String t, String v,String m){
        price=p;
        model=mod;
        year=y;
        color=c;
        trans=t;
        vinNumber=v;
        make=m;
    }
    
    public Car (int p, String m) {
        price=p;
        model=m;
        year = 1900;
        color="undef";
        trans="auto";
        vinNumber=newVinNumber();
        make="undef";
    }
    
    public String newVinNumber() {
        /*for(int i=0; i<=17; i++) {
            anArray[i] = (int)(Math.random());
            while((anArray[i] < 0) && (anArray[i] > 9)){
                anArray[i] = (int)Math.random();
            }
            System.out.println(anArray[i]);
        }*/  
        vinNumber = "";
        for(int i=1; i<17; i++) {
            int a = (int)(Math.random() * 10);
            while((a < 0) && (a > 9)){
                a = (int)Math.random() * 10;
            }
            String newNumber = Integer.toString(a);
            vinNumber = vinNumber + newNumber;  
        }
        //System.out.println(vinNumber);
        return vinNumber;
    }
    public void setPrice(int p){
        if(p<0){
            System.out.println("Could not set value less than 0");
            System.out.println(p);
        }
        else {
            price=p;
        }
    }      

    public int getPrice(){
        return  price;
    }

    public void setModel(String m){
        model=m;
    }

    public String getModel(){
        return  model;
    }

    public void setColor(String c){
        color=c;
    }

    public String getColor() {
        return color;
    }

    public void setTrans(String t) {
        t.toLowerCase();
        if(t.equals("auto") || t.equals("manual")) {
            trans=t;
        }
        else {
            System.out.println("Error, unrecognized car type");
        }
    }   

    public String getTrans() {
        return trans;
    }
    
    public void setVinNumber(String v) {
        vinNumber = v;
    }

    public String getVinNumber(){
        return vinNumber;
    }

    public void setYear(int y){
        year = y;
    }

    public int getYear() {
        return year;
    }
    
    public void setMake(String m){
        make = m;
    }
    
    public String getMake() {
        return make;
    }
    
    public String toString () {
        return model + ", Transmission: " + trans + ", $" + price + ", Vin: " + vinNumber;
    }
}