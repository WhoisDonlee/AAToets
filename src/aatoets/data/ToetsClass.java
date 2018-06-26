package aatoets.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ToetsClass {
    public static ArrayList<String[]> toetsList;
    private final ArrayList<String[]> mogelijkeVragen = new ArrayList<>();
    private final ArrayList<String[]> mogelijkeVragenOpAntwoord = new ArrayList<>();
    private final ArrayList<String[]> mogelijkeToetsVragen = new ArrayList<>();
    private final ArrayList<String> toetsVragen = new ArrayList<>();

    public ToetsClass() {
        getLijsten();
//        System.out.println(mogelijkeVragen);
//        for (String[] s : mogelijkeVragenOpAntwoord) {
//            if (mogelijkeVragen.contains(s[0])) {
//                mogelijkeToetsVragen.add(new String[] {s[0], s[1]});
//            }
//        }
        for (String[] mvoa : mogelijkeVragenOpAntwoord) {
            for (String[] mv : mogelijkeVragen) {
                if (mvoa[0].equals(mv[0])) {
                    if (!mvoa[1].equals(mv[1])) {
                        mogelijkeToetsVragen.add(new String[] {mvoa[0], mvoa[1], mv[1]});
                    }
                }
            }
        }
//        genereerToetsVragen();
    }

    private void getLijsten() {
//        for (String s : OptieClass.getSoortVragen()) {
//            mogelijkeVragen.addAll(Vragen.returnListByName(s, "vraag"));
//        }
        for (String s : OptieClass.getSoortVragen()) {
            for (String i : Vragen.returnListByName(s, "vraag")) {
                mogelijkeVragen.add(new String[] {i, s});
            }
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


    public ArrayList<String> genereerVraag() {

        ArrayList<String> returnVraagEnAntwoorden = new ArrayList<>();
        Object[] soortVragenIDLists = getUsedIDs(OptieClass.getSoortVragen());
        Object[] soortAntwoordenIDList = getUsedIDs(OptieClass.getSoortAntwoorden());

        ArrayList<String> soortVragenIDList = (ArrayList<String>) soortVragenIDLists[0];

        int randomVraag = new Random().nextInt(mogelijkeToetsVragen.size());
        Aminozuur az = AminozurenHandler.getRandomAminozuur();
        String[] vraagEnAntwoordSoort = mogelijkeToetsVragen.get(randomVraag);
        String vraag = vraagEnAntwoordSoort[0];
        String vraagFormat = AminozurenHandler.getAminoAttribute(az, vraagEnAntwoordSoort[2]);
        String antwoord = null;
        ArrayList<String> antwoordMogelijkheden = new ArrayList<>();

        if (vraag.contains("niet")) {
            az = AminozurenHandler.getRandAminozuurByAttribute(vraagEnAntwoordSoort[2], vraagFormat, false);
            for (int i = 0; i < 2; i++) {
                Aminozuur aztemp = AminozurenHandler.getRandAminozuurByAttribute(vraagEnAntwoordSoort[2], vraagFormat, true);
                antwoordMogelijkheden.add(AminozurenHandler.getAminoAttribute(aztemp, vraagEnAntwoordSoort[1]));
            }
        } else {
            for (int i = 0; i < 2; i++) {
                Aminozuur aztemp = AminozurenHandler.getRandAminozuurByAttribute(vraagEnAntwoordSoort[2], vraagFormat, false);
                antwoordMogelijkheden.add(AminozurenHandler.getAminoAttribute(aztemp, vraagEnAntwoordSoort[1]));
            }
        }

        antwoord = AminozurenHandler.getAminoAttribute(az, vraagEnAntwoordSoort[1]);

        returnVraagEnAntwoorden.add(String.format(vraag, vraagFormat));
        returnVraagEnAntwoorden.add(antwoord);
        returnVraagEnAntwoorden.addAll(antwoordMogelijkheden);
        System.out.println(returnVraagEnAntwoorden);

        return returnVraagEnAntwoorden;
    }
}
