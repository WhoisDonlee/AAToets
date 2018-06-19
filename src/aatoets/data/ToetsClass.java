package aatoets.data;

import java.util.ArrayList;

public class ToetsClass {
    public static ArrayList<String[]> toetsList;
    private final ArrayList<String> mogelijkeVragen = new ArrayList<>();
    private final ArrayList<String> mogelijkeVragenOpAntwoord = new ArrayList<>();
    private final ArrayList<String> toetsVragen = new ArrayList<>();

    public ToetsClass() {
        getLijsten();
        for (String s : mogelijkeVragen) {
            if (mogelijkeVragenOpAntwoord.contains(s)) {
                if (!toetsVragen.contains(s)){
                    toetsVragen.add(s);
                }
            }
        }

        System.out.println(toetsVragen);
    }

    public void getLijsten() {

        for (String s : OptieClass.getSoortVragen()) {
            for (String i : Vragen.returnListByName(s, "vraag")) {
                mogelijkeVragen.add(i);
            }
        }
        for (String s : OptieClass.getSoortAntwoorden()) {

            for (String i : Vragen.returnListByName(s, "alsAntwoord")) {
                mogelijkeVragenOpAntwoord.add(i);
            }
        }
    }
}
