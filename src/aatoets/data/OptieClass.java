package aatoets.data;

import java.util.ArrayList;

public class OptieClass {
    private static String naam;
    private static int aantalVragen;
    private static ArrayList<String> soortVragen;
    private static ArrayList<String> soortAntwoorden;
    private static boolean tijd;
    private static int aantalSeconden;

    public static String getNaam() {
        return naam;
    }

    public static void setNaam(String naam) {
        OptieClass.naam = naam;
    }

    public static int getAantalVragen() {
        return aantalVragen;
    }

    public static void setAantalVragen(int aantalVragen) {
        OptieClass.aantalVragen = aantalVragen;
    }

    public static ArrayList<String> getSoortVragen() {
        return soortVragen;
    }

    public static void setSoortVragen(ArrayList<String> soortVragen) {
        OptieClass.soortVragen = soortVragen;
    }

    public static ArrayList<String> getSoortAntwoorden() {
        return soortAntwoorden;
    }

    public static void setSoortAntwoorden(ArrayList<String> soortAntwoorden) {
        OptieClass.soortAntwoorden = soortAntwoorden;
    }

    public static boolean isTijd() {
        return tijd;
    }

    public static void setTijd(boolean tijd) {
        OptieClass.tijd = tijd;
    }

    public static int getAantalSeconden() {
        return aantalSeconden;
    }

    public static void setAantalSeconden(int aantalSeconden) {
        OptieClass.aantalSeconden = aantalSeconden;
    }
}
