package aatoets.data;

import java.util.ArrayList;
import java.util.List;

public class AminozurenHandler {
    /*
    * Hanteert de aminozuur objecten.
    * */

    private final ArrayList<Aminozuur> aminoObjectList;

    public AminozurenHandler() {
        this.aminoObjectList = new ArrayList<>();
    }

    /*
    * Haalt de data van aminozuren uit de XML file.
    * Deze data wordt omgezet in een Aminozuur object en toegevoegd in een ArrayList<Aminozuur>
    * */
    public void initAminozuren() {
        List<String[]> aminoList;
        XMLreader xmlReader = new XMLreader("src/aatoets/data/amino.xml");
        aminoList = xmlReader.getByTag();

        for (String[] aa : aminoList) {
            this.aminoObjectList.add(new Aminozuur(aa[0], aa[1], aa[2], aa[3], aa[4], aa[5], aa[6]));
        }
    }

    /*
    * Geeft het Aminozuur object dmv de naam mee te geven als parameter
    *
    * e.g. getAminozuurByName("histidine")
    * */
    public Aminozuur getAminozuurByName(String naam) {
        for (Aminozuur aa : this.aminoObjectList) {
            if (aa.getNaam().equals(naam)) {
                return aa;
            }
        }
        return null;
    }
}
