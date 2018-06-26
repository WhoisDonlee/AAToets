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

    static String getAminoAttribute(Aminozuur aminozuur, String soortAttribuut) {
        String attribuut = null;
        switch (soortAttribuut) {
            case "Volledige Naam":
                attribuut = aminozuur.getNaam();
                break;
            case "1 lettercode":
                attribuut = aminozuur.getCode1();
                break;
            case "3 lettercode":
                attribuut = aminozuur.getCode3();
                break;
            case "Hydrofobiciteit":
                attribuut = aminozuur.getHydrofobiciteit();
                break;
            case "Lading":
                attribuut = aminozuur.getLading();
                break;
            case "Grootte":
                attribuut = aminozuur.getGrootte();
                break;
            case "3D Voorkeur":
                attribuut = aminozuur.getVoorkeur3D();
                break;
            case "Structuur":
                /*TODO
                 * Plaatje uit XML laden*/
                attribuut = "IMAGE.JPG";
                break;
        }
        return attribuut;
    }

    public static Aminozuur getRandAminozuurByAttribute(String att, String value, boolean gelijkAanValue) {
        Aminozuur aa = null;
        String attWaarde = null;

        if(gelijkAanValue) {
            do {
                aa = getRandomAminozuur();
                switch (att) {
                    case "Hydrofobiciteit":
                        attWaarde = aa.getHydrofobiciteit();
                        break;
                    case "Lading":
                        attWaarde = aa.getLading();
                        break;
                    case "Grootte":
                        attWaarde = aa.getGrootte();
                        break;
                }
            } while (!value.equals(attWaarde));
        } else {
            do {
                aa = getRandomAminozuur();
                switch (att) {
                    case "Hydrofobiciteit":
                        attWaarde = aa.getHydrofobiciteit();
                        break;
                    case "Lading":
                        attWaarde = aa.getLading();
                        break;
                    case "Grootte":
                        attWaarde = aa.getGrootte();
                        break;
                }
            } while (value.equals(attWaarde));
        }
        return aa;
    }

    static Aminozuur getRandomAminozuur() {
        return aminoObjectList.get(new Random().nextInt(aminoObjectList.size()));
    }
}
