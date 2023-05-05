package testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.ClassLoader;

class FeatureEnvy {

    public static void main(String[] args) throws IOException {
    	Address address1 = new Address("John", "350 Main St.", "Seattle", "WA", 98002, 999);
		Address address2 = new Address("Peter", "4200 Broadway Ave.", "Portland", "OR", 97125, 4100);
		
		System.out.println(Resident.getFullAddress(address1, address2));
	    System.out.println("");
		Resident.test(); 		
   
	 
	
	}
}

class Resident {
	
	
    public static String getFullAddress(Address address1, Address address2) {
        //Address address1 = new Address("John", "350 Main St.", "Seattle", "WA", 98002, 306);
		//Address address2 = new Address("Peter", "4200 Broadway Ave.", "Portland", "OR", 97125, 4100); 
		
    	String ad1 = address1.getStreetAddress() + " " + address1.getCityName() + " " + address1.getStateName() + " " + address1.getPostalCode() + " " + address1.getApptNo(); 
        String ad2 = address2.getStreetAddress() + " " + address2.getCityName() + " " + address2.getStateName() + " " + address2.getPostalCode()  + " " + address2.getApptNo();
		
        //return (address1.personName + "'s adress is: " + ad1 + "\n" + address2.personName + "'s adress is: " + ad2) ;
        return (address1.getPersonName() + "'s address is: " + ad1 + "\n" + address2.getPersonName() + "'s address is: " + ad2);
    }
    public static void test() {
		Address address1 = new Address("John", "350 Main St.", "Seattle", "WA", 98002, 306);
		Address address2 = new Address("Peter", "4200 Broadway Ave.", "Portland", "OR", 97125, 4100);
        if (Math.abs(address1.postalCode - address2.postalCode) >50)
		System.out.println(address1.personName + " and " + address2.personName + " do not live in same city");	
    }
}

class Address {
    String personName;
	String streetAddress;
    String cityName;
    String stateName;
    int postalCode;
    int apptNo;
	
    public Address(String personName, String streetAddress, String cityName, String stateName, int postalCode, int apptNo) {
        this.personName = personName;
		this.streetAddress = streetAddress;
        this.cityName = cityName;
        this.stateName = stateName;
        this.postalCode = postalCode;
        this.apptNo = apptNo;
    }
	
    public String getPersonName() {
        return personName;
    }
	public String getStreetAddress() {
        return streetAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getApptNo() {
        return apptNo;
    }
	
    public static void test() {
       System.out.println("Test method is called");
    }
}
