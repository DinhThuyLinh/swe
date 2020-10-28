/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controller.DoctorController;
import Entity.DoctorEntity;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        while (true) {
            System.out.println("1. Create doctor");
            System.out.println("2. Edit doctor");
            System.out.println("3. Delete doctor");
            System.out.println("4. Search doctor");
            System.out.println("5. Sort doctor");
            System.out.println("0. Exit");
            System.out.println("Choose funciton");
            int numberChoose = 0;
            try {
                numberChoose = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Number is not right");
                continue;
            }
            if (numberChoose < 0 || numberChoose > 5) {
                System.out.println("Number is not in 0-5");
                continue;
            }

            if (numberChoose == 0) {
                break;
            }
            switch (numberChoose) {
                case 1:
                    addDoctor(sc);
                    break;
                case 2:
                    editDoctor(sc);
                    break;
                case 3:
                    deleteDoctor(sc);
                    break;
                case 4:
                    searchDoctor(sc);
                    break;
                case 5:
                    sortDoctor(sc);
                    break;

            }
        }

    }

    private static void addDoctor(Scanner sc) {
        System.out.print("Enter name: ");
        String inName = sc.nextLine();
        System.out.print("Enter Date of birth: ");
        String inDateOfBirth = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String inSpecialization = sc.nextLine();
        System.out.print("Enter Availability: ");
        String inAvailability = sc.nextLine();
        System.out.print("Enter Email: ");
        String inEmail = sc.nextLine();
        System.out.print("Enter Mobile: ");
        String inMobile = sc.nextLine();
        int result = DoctorController.addDoctor(inName, inDateOfBirth, inSpecialization, inAvailability, inEmail, inMobile);
        switch (result) {
            case 0:
                System.out.println("Add success");
                break;
            case 1:
                System.out.println("update fail");
                break;
            case 2:
                System.out.println("Name in not valid");
                break;
            case 3:
                System.out.println("Date of birth is nof valid");
                break;
            case 4:
                System.out.println("specialization is nof valid");
                break;
            case 5:
                System.out.println("avalibility is nof valid");
                break;
            case 6:
                System.out.println("email is nof valid");
                break;
            case 7:
                System.out.println("mobile is nof valid");
                break;
            case -1:
                System.out.println("Sql error");
                break;
        }

    }

    private static void displayList(ArrayList<DoctorEntity> list) {
        for (DoctorEntity de : list) {
            System.out.println(de);
        }
    }

    private static void editDoctor(Scanner sc) {
        ArrayList<DoctorEntity> listDoctor = DoctorController.sortDoctor();
        if (listDoctor.size() == 0) {
            System.out.println("No doctor in db");
            return;
        } else {
            displayList(listDoctor);
        }
        System.out.print("Enter id: ");
        int inId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String inName = sc.nextLine();
        System.out.print("Enter Date of birth: ");
        String inDateOfBirth = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String inSpecialization = sc.nextLine();
        System.out.print("Enter Availability: ");
        String inAvailability = sc.nextLine();
        System.out.print("Enter Email: ");
        String inEmail = sc.nextLine();
        System.out.print("Enter Mobile: ");
        String inMobile = sc.nextLine();
        int result = DoctorController.editDoctor(inId, inName, inDateOfBirth, inSpecialization, inAvailability, inEmail, inMobile);
        switch (result) {
            case 0:
                System.out.println("Add success");
                break;
            case 1:
                System.out.println("update fail");
                break;
            case 2:
                System.out.println("Name in not valid");
                break;
            case 3:
                System.out.println("Date of birth is nof valid");
                break;
            case 4:
                System.out.println("specialization is nof valid");
                break;
            case 5:
                System.out.println("avalibility is nof valid");
                break;
            case 6:
                System.out.println("email is nof valid");
                break;
            case 7:
                System.out.println("mobile is nof valid");
                break;
            case 8:
                System.out.println("no doctor found");
                break;
            case -1:
                System.out.println("Sql error");
                break;
        }
    }

    private static void deleteDoctor(Scanner sc) {
        System.out.print("Enter id: ");
        int inId = Integer.parseInt(sc.nextLine());
        int result = DoctorController.deleteDoctor(inId);
        if (result == 0) {
            System.out.println("Delete successful");

        } else {
            System.out.println("Sql error");

        }
    }

    private static void searchDoctor(Scanner sc) {
        System.out.print("Enter string to find: ");
        String findString = sc.nextLine();
        ArrayList<DoctorEntity> listDoctor = DoctorController.searchDoctor(findString);
        if (listDoctor.size() > 0) {
            displayList(listDoctor);
        } else {
            System.out.println("No doctor found");
        }
    }

    private static void sortDoctor(Scanner sc) {
        ArrayList<DoctorEntity> listDoctor = DoctorController.sortDoctor();
        if (listDoctor.size() > 0) {
            displayList(listDoctor);
        } else {
            System.out.println("No doctor found");
        }
    }

}
