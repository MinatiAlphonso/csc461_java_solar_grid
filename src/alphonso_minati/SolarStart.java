/*
* Program: OOP Java
* File: SolarStart.java
* Author: Minati Alphonso
* Class: CSC 461
* Section: MT1
* Date: October 1, 2020
* Language: Java
* Compiler: IntelliJ IDEA Community Edition 2020.2.1
*
* Description:
*
* This program implements the concept of Object Oriented Programming (OOP) to
* create and customize a 5x5 solar grid which contains empty spaces (⛶),
* solar panels (⊞), greenspace (❦), and light bulbs (✦).
*
* The user can either start with a blank grid or update to a default setup.
* Afterwards, the user can change an individual area (add/remove an object),
* count the number of each type of object, light up bulbs, and change the
* color of a type of object (default is BLACK).
*
* The count, color and light up operations use the 'Visitor Pattern'. The
* Visitor pattern basically makes it possible to work with collections of
* different types of objects and do type-specific operations in a type-safe
* way.
*
* Additionally, a try-catch block is used for input validation.
*
 */
package alphonso_minati;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SolarStart {

    public static Scanner cin; //intentionally public for ease of use

    public static void main(String[] args) {
        Grid gg = new Grid();
        cin = new Scanner(System.in);
        String menu = "\n1) Set Area\n" +
                      "2) Remove Area\n" +
                      "3) Make Default Grid\n" +
                      "4) Count Types\n" +
                      "5) Set Type Color\n" +
                      "6) Light Up Bulbs\n" +
                      "0) Quit\n" +
                      "Choice: ";
        System.out.println("\n");
        System.out.println(gg.solarGrid()); //print default empty grid
        int x, y;
        int input = -1;
        while (input != 0)
        {
            try
            {
                System.out.print(menu); //print main menu
                input = cin.nextInt();//takes in user input
                switch (input)
                {
                    case 1:
                        System.out.print("Input area type 1) greenspace 2) light 3) panel #) empty: ");
                        input = cin.nextInt();
                        System.out.print("Input location (x y): ");
                        x = cin.nextInt();
                        y = cin.nextInt();
                        if(x < 0 || x > 4 || y < 0 || y > 4) {
                            System.out.println("Invalid option");
                            System.out.println(gg.solarGrid());
                        }
                        else
                        {
                            gg.setX(x);//x-coordinate
                            gg.setY(y);//y-coordinate
                            System.out.println();
                            if (input == 1)//greenspace
                            {
                                System.out.println(gg.getType("g"));
                            }
                            else if (input == 2)//light
                            {
                                System.out.println(gg.getType("l"));
                            }
                            else if (input == 3)//panel
                            {
                                System.out.println(gg.getType("p"));
                            }
                            else//empty
                            {
                                System.out.println(gg.getType("e"));
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Input location (x y): ");
                        x = cin.nextInt();
                        y = cin.nextInt();
                        if(x < 0 || x > 4 || y < 0 || y > 4) {
                            System.out.println("Invalid option");
                            System.out.println(gg.solarGrid());
                        }
                        else
                        {
                            System.out.println();
                            System.out.println(gg.remove(x,y));
                        }
                        break;
                    case 3:
                        gg.changeToDef();
                        System.out.println();
                        System.out.println(gg.solarGrid());
                        break;
                    case 4:
                        gg.countElements();
                        System.out.println();
                        System.out.println(gg.solarGrid());
                        break;
                    case 5:
                        System.out.print("Input area type 1) greenspace 2) light 3) panel #) empty: ");
                        input = cin.nextInt();
                        char type;
                        if(input == 1){type = '❦';}
                        else if(input == 2){type = '✦';}
                        else if(input == 3){type = '⊞';}
                        else{type = '⛶';}
                        System.out.print("Input color 1) red 2) yellow 3) blue 4) green #) black: ");
                        int color = cin.nextInt();
                        System.out.println();
                        System.out.println(gg.changeColor(color, type));
                        break;
                    case 6:
                        System.out.println();
                        System.out.println(gg.lightItUp());
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("\nUnknown menu option");

                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid option");
                cin.next();
                System.out.println(gg.solarGrid()); //print grid
            }
        }
    }
}
