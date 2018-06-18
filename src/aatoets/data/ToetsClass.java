package aatoets.data;

import java.util.ArrayList;
import java.util.Random;

public class ToetsClass {
    public static ArrayList<String[]> toetsList;

    public ToetsClass() {
    }

    public String[] genereerVraag() {
        String soortVraag, soortAntwoord, antwoord, vraagzin, vraag;

        int indexVragen = new Random().nextInt(OptieClass.getSoortVragen().size());
        int indexAntwoorden = new Random().nextInt(OptieClass.getSoortAntwoorden().size());

        while(OptieClass.getSoortVragen().get(indexVragen) == OptieClass.getSoortAntwoorden().get(indexAntwoorden)) {
            indexAntwoorden = new Random().nextInt(OptieClass.getSoortAntwoorden().size());
        }

        soortVraag = OptieClass.getSoortVragen().get(indexVragen);
        soortAntwoord = OptieClass.getSoortAntwoorden().get(indexAntwoorden);

        String[] vraagEnAntwoord = getVraagEnAntwoord(soortVraag, soortAntwoord);
        vraag = vraagEnAntwoord[0];
        antwoord = vraagEnAntwoord[1];

        vraagzin = String.format("Wat is de %s van %s", soortAntwoord, vraag);

        return new String[]{vraagzin, antwoord, vraag, soortVraag, soortAntwoord};
    }

    private String[] getVraagEnAntwoord(String soortVraag, String soortAntwoord) {
        Aminozuur tempAminozuur = AminozurenHandler.getRandomAminozuur();
        return new String[] { getAttribuut(soortVraag, tempAminozuur), getAttribuut(soortAntwoord, tempAminozuur) };
    }

    private String getAttribuut(String soortAttribuut, Aminozuur tempAminozuur) {
        String attribuut = null;
        switch (soortAttribuut) {
            case "Volledige Naam":
                attribuut = tempAminozuur.getNaam();
                break;
            case "1 lettercode":
                attribuut = tempAminozuur.getCode1();
                break;
            case "3 lettercode":
                attribuut = tempAminozuur.getCode3();
                break;
            case "Hydrofobiciteit":
                attribuut = tempAminozuur.getHydrofobiciteit();
                break;
            case "Lading":
                attribuut = tempAminozuur.getLading();
                break;
            case "Grootte":
                attribuut = tempAminozuur.getGrootte();
                break;
            case "3D Voorkeur":
                attribuut = tempAminozuur.getStructuur();
                break;
            case "Structuur":
                attribuut = tempAminozuur.getNaam();
                break;
        }
        return attribuut;
    }

}
