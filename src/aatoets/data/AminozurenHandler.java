package aatoets.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AminozurenHandler {
    /*
    * Hanteert de aminozuur objecten.
    * */

    private static ArrayList<Aminozuur> aminoObjectList = new ArrayList<>();

    /*
    * Haalt de data van aminozuren uit de XML file.
    * Deze data wordt omgezet in een Aminozuur object en toegevoegd in een ArrayList<Aminozuur>
    * */
    public static void initAminozuren() {
        List<String[]> aminoList;
        XMLreader xmlReader = new XMLreader("src/aatoets/data/amino.xml");
        aminoList = xmlReader.getByTag();

        for (String[] aa : aminoList) {
            aminoObjectList.add(new Aminozuur(aa[0], aa[1], aa[2], aa[3], aa[4], aa[5], aa[6]));
        }
    }

    /*
    * Geeft de lijst met aminozuren terug
    * */
    public static ArrayList<Aminozuur> getAminozuren() {
        return aminoObjectList;
    }

    /*
    * Geeft het Aminozuur object dmv de naam mee te geven als parameter
    *
    * e.g. getAminozuurByName("histidine")
    * */
    public static Aminozuur getAminozuurByName(String naam) {
        for (Aminozuur aa : aminoObjectList) {
            if (aa.getNaam().equals(naam)) {
                return aa;
            }
        }
        return null;
    }

    public static Aminozuur getAminozuurByAttribute(String att, String val, boolean niet) {
        Aminozuur aa = null;
        String attWaarde = val;

        if(niet) {
            while(!attWaarde.equals(val)) {
                aa = getRandomAminozuur();
                switch (att) {
                    case "hydro":
                        attWaarde = aa.getHydrofobiciteit();
                        break;
                    case "lading":
                        attWaarde = aa.getLading();
                        break;
                    case "grootte":
                        attWaarde = aa.getGrootte();
                        break;
                }
            }
        } else {
            while(attWaarde.equals(val)) {
                aa = getRandomAminozuur();
                switch (att) {
                    case "hydro":
                        attWaarde = aa.getHydrofobiciteit();
                        break;
                    case "lading":
                        attWaarde = aa.getLading();
                        break;
                    case "grootte":
                        attWaarde = aa.getGrootte();
                        break;
                }
            }
        }
        return aa;
    }

    public static Aminozuur getRandomAminozuur() {
        return aminoObjectList.get(new Random().nextInt(aminoObjectList.size()));
    }
}
