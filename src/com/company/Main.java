package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static String datacheck ="";


    public static boolean validateFirstName(String firstName) {
        boolean status = true;
        if (firstName.length() < 2) {
            datacheck = datacheck + "The first name must be at least 2 characters long.\n";
            status = false;
        }
        if (firstName.length() == 0) {
            datacheck = datacheck + "The first name must be filled in.\n";
            status = false;
        }
        return status;
    }

    public static boolean validateLastName(String lastName) {
        boolean status = true;
        if (lastName.length() < 2) {
            datacheck = datacheck + "The last name must be at least 2 characters long.\n";
            status = false;
        }
        if (lastName.length() == 0) {
            System.out.println("The last name must be filled in.");
            status = false;
        }
        return status;
    }

    // This method validate zip
    public static boolean validateZipCode(String zip) {
        boolean status = true;
        try {
            int number = Integer.parseInt(zip);
            if (zip.length() != 5) {
                datacheck = datacheck + "The zipcode must be a 5 digit number.\n";
                status = false;
            }
        } catch (Exception e) {
            datacheck = datacheck + "The zipcode must be a 5 digit number.\n";
            status = false;
        }
        return status;
    }


    public static boolean validateEmployeeID(String employeeID) {
        String pattern = "[a-zA-Z]{2}[-]{1}[0-9]{4}";
        if (!Pattern.matches(pattern, employeeID)) {
            datacheck = datacheck + "The employee ID must be in the format of AA-1234.\n";
            return false;
        }
        return true;
    }

    public static void validateInput(String firstName, String lastName, String zip, String employeeID) {
        boolean first = validateFirstName(firstName);
        boolean last = validateLastName(lastName);
        boolean idFlag = validateEmployeeID(employeeID);
        boolean zipFlag = validateZipCode(zip);
        if (first && last && zipFlag && idFlag) {
            datacheck = "There were no errors found.";
        }
        System.out.println(datacheck);
    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the first name: ");
        String fName = scan.nextLine();
        System.out.print("Enter the last name: ");
        String lName = scan.nextLine();
        System.out.print("Enter the ZIP code: ");
        String zip = scan.nextLine();
        System.out.print("Enter the employee ID: ");
        String empID = scan.nextLine();


        validateInput(fName, lName, zip, empID);

    }
}
