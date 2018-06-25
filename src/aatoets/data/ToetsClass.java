package aatoets.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ToetsClass {
    public static ArrayList<String[]> toetsList;
    private final ArrayList<String> mogelijkeVragen = new ArrayList<>();
    private final ArrayList<String[]> mogelijkeVragenOpAntwoord = new ArrayList<>();
    private final ArrayList<String[]> mogelijkeToetsVragen = new ArrayList<>();
    private final ArrayList<String> toetsVragen = new ArrayList<>();

    public ToetsClass() {
        getLijsten();
        System.out.println(mogelijkeVragen);
        for (String[] s : mogelijkeVragenOpAntwoord) {
            if (mogelijkeVragen.contains(s[0])) {
                mogelijkeToetsVragen.add(new String[] {s[0], s[1]});
            }
        }
//        genereerToetsVragen();
    }

    private void getLijsten() {
        for (String s : OptieClass.getSoortVragen()) {
            mogelijkeVragen.addAll(Vragen.returnListByName(s, "vraag"));
        }
        for (String s : OptieClass.getSoortAntwoorden()) {
            for (String i : Vragen.returnListByName(s, "alsAntwoord")) {
                mogelijkeVragenOpAntwoord.add(new String[] {i, s});
            }
        }
    }

    private Object[] getUsedIDs(ArrayList<String> aList) {
        ArrayList<String> idList = new ArrayList<>(Arrays.asList(
                "Volledige Naam", "1 lettercode", "3 lettercode", "Structuur"
        ));
        ArrayList<String> usedIDList = new ArrayList<>();
        ArrayList<String> usedNonIDList = new ArrayList<>();

        for (String s : aList) {
           if(idList.contains(s)) {
               usedIDList.add(s);
           } else {
               usedNonIDList.add(s);
           }
        }
        return new Object[] {usedIDList, usedNonIDList};
    }


    public String[] genereerVraag() {

        Object[] soortVragenIDLists = getUsedIDs(OptieClass.getSoortVragen());
        Object[] soortAntwoordenIDList = getUsedIDs(OptieClass.getSoortAntwoorden());

        ArrayList<String> soortVragenIDList = (ArrayList<String>) soortVragenIDLists[0];
        System.out.println(soortVragenIDLists[0]);
        System.out.println(soortVragenIDLists[1]);

        int randomVraag = new Random().nextInt(mogelijkeToetsVragen.size());
        Aminozuur az = AminozurenHandler.getRandomAminozuur();
        String[] vraagEnAntwoordSoort = mogelijkeToetsVragen.get(randomVraag);
        String vraag = vraagEnAntwoordSoort[0];
        String antwoord = AminozurenHandler.getAminoAttribute(az, vraagEnAntwoordSoort[1]);
        String vraagFormat = null;

        System.out.println(soortVragenIDList);
        for (String s : (ArrayList<String>) soortVragenIDLists[0]) {
            System.out.println(s);
        }

        System.out.println(vraag + " + " + antwoord);

//        for (String[] s : mogelijkeToetsVragen) {
//            System.out.println(s[0] + " : " + s[1]);
//        }
        return new String[] {vraag, antwoord};
    }
}
