package aatoets.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ToetsClass {
    public static ArrayList<String[]> toetsList;
    private final ArrayList<String> mogelijkeVragen = new ArrayList<>();
    private final ArrayList<String> mogelijkeVragenOpAntwoord = new ArrayList<>();
    private final ArrayList<String> mogelijkeToetsVragen = new ArrayList<>();
    private final ArrayList<String> toetsVragen = new ArrayList<>();

    public ToetsClass() {
        getLijsten();
        for (String s : mogelijkeVragen) {
            if (mogelijkeVragenOpAntwoord.contains(s)) {
                if (!mogelijkeToetsVragen.contains(s)){
                    mogelijkeToetsVragen.add(s);
                }
            }
        }
        genereerToetsVragen();
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

    private void genereerToetsVragen() {
        ArrayList<String> idList = new ArrayList<>(Arrays.asList(
                "Volledige Naam", "1 lettercode", "3 lettercode", "Structuur"
        ));
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();

        for (String s : OptieClass.getSoortVragen()) {
            if(idList.contains(s)) {
               temp.add(s);
            } else {
                temp2.add(s);
            }
        }


        for(int i = 0; i < OptieClass.getAantalVragen(); i++) {
            int rand = new Random().nextInt(mogelijkeToetsVragen.size());
            String vraag = mogelijkeToetsVragen.get(rand);
            Aminozuur az = AminozurenHandler.getRandomAminozuur();
            if(!temp.isEmpty()){
                int rand2 = new Random().nextInt(temp.size());
                String formatString = null;
                switch(temp.get(rand2)) {
                    case "Volledige Naam":
                        formatString = az.getNaam();
                        break;
                    case "1 lettercode":
                        formatString = az.getCode1();
                        break;
                    case "3 lettercode":
                        formatString = az.getCode3();
                        break;
                    case "Structuur":
                        formatString = az.getStructuur();
                        break;
                }

            System.out.println(String.format(vraag,formatString));
            } else {

                String formatString = null;
                if (vraag.contains("heeft")) {
                    formatString = az.getStructuur();
                } else {
                    int rand2 = new Random().nextInt(temp2.size());
                    switch(temp2.get(rand2)) {
                        case "Hydrofobiciteit":
                            formatString = az.getHydrofobiciteit();
                            if (vraag.contains("niet")) {
                                Aminozuur vartestgoedantwoord = AminozurenHandler.getAminozuurByAttribute("hydro", az.getHydrofobiciteit().toString(), false);
                                System.out.println(vartestgoedantwoord.getNaam() + " " + vartestgoedantwoord.getHydrofobiciteit());
                            } else {
                                System.out.println(az.getNaam() + " " + az.getHydrofobiciteit());
                            }
                            break;
                        case "Lading":
                            formatString = az.getLading();
                            vraag = vraag.replace("?", " geladen?");
                            if (vraag.contains("niet")) {
                                Aminozuur vartestgoedantwoord = AminozurenHandler.getAminozuurByAttribute("lading", az.getLading().toString(), false);
                                System.out.println(vartestgoedantwoord.getNaam() + " " + vartestgoedantwoord.getLading());
                            } else {
                                System.out.println(az.getNaam() + " " + az.getLading());
                            }
                            break;
                        case "Grootte":
                            formatString = az.getGrootte();
                            if (vraag.contains("niet")) {
                                Aminozuur vartestgoedantwoord = AminozurenHandler.getAminozuurByAttribute("grootte", az.getGrootte().toString(), false);
                                System.out.println(vartestgoedantwoord.getNaam() + " " + vartestgoedantwoord.getGrootte());
                            } else {
                                System.out.println(az.getNaam() + " " + az.getGrootte());
                            }
                            break;
                    }
                }
                System.out.println(String.format(vraag,formatString));

            }

        }

    }

}
