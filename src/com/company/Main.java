
package com.company;


import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;


public class Main {

public static PrintStream ps;

    public static void main(String[] args) throws Exception {
        final int TOTAL_CREW = 15;
        int  countMale = 0, countFemale = 0, prefix = 0, totalAtn;
        int[] seating = new int[TOTAL_CREW];
        ps = new PrintStream("Starfleet.txt");

        String[] name = new String[TOTAL_CREW];
        String first, last, mensNames, womenNames;
        Scanner sc = new Scanner(new File("name.txt"));

        for (int i = 0; i <= name.length - 1; i++) {
            first = sc.next();
            last = sc.next();
            String fullName = first + " " + last;
            seating[i] = sc.nextInt();
            prefix = sc.nextInt();
            switch (prefix) {
                case 1:
                    name[i] = "Mr. " + fullName;
                    countMale++;
                    break;
                case 2:
                    name[i] = "Mrs. " + fullName;//setting new val for that spot on array
                    countFemale++;
                    break;
                case 3:
                    name[i] = "Ms. " + fullName;
                    countFemale++;
                    break;
                case 4:
                    name[i] = "Miss " + fullName;
                    countFemale++;
                    break;
            }
        }

        totalAtn = countFemale + countMale;
        bubbleSort(name, seating);// sorting name and seating number
        print(name, seating);// print sorted seating

        ps.printf("%n%n%s","Male names:");
        containsMen(name);
        ps.printf("%n%n%s", "Female Names:");
        containsWomen(name);

        ps.printf("%n%nTotal males:\t\t %d%nTotal females:\t\t %d %nTotal guests:\t\t%d",
                countMale, countFemale, totalAtn);
    }

    public static String containsMen(String[] x) {
        String mensNames = "debug";
        for (int a = 0; a < x.length - 1; a++) {

            if ((x[a]).contains("Mr.")) {
                mensNames = x[a];
                ps.printf("%n%s", x[a]);
            }
        }
        return mensNames;
    }

    public static String containsWomen(String[] x) {
        String womenNames = "debug";
        for (int a = 0; a < x.length - 1; a++) {
            if ((x[a].contains("Miss") || x[a].contains("Mrs.") || x[a].contains("Ms."))) {
                womenNames += x[a];
                womenNames += "\n";
                ps.printf("%n%s", x[a]);
            }
        }
        return womenNames;
    }

    public static void print(String[] name, int[] seating) {
        for (int i = 0; i < seating.length; i++) {
            ps.printf(seating[i] + " \t" + name[i]);
            ps.println();}
    }


    public static void bubbleSort(String[] name, int[] seating) {
        int hold, j, pass; // need to hold a value to swap
        String tempString;
        boolean switched = true;
        for (pass = 0; pass < seating.length - 1 && switched; pass++) {
            // outer loop limits # passes
            switched = false; //no changes have happened yet,
            for (j = 0; j < seating.length - pass - 1; j++) {
                if (seating[j] > seating[j + 1]) {
                    switched = true; // condition met for switch to happen
                    hold = seating[j];
                    seating[j] = seating[j + 1];
                    seating[j + 1] = hold;
                    tempString = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = tempString;
                }
            }

        }

    }
}