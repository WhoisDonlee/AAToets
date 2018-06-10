package aatoets.data;

import java.util.ArrayList;
import java.util.List;

public class AminozurenHandler {

    private final ArrayList<Aminozuur> aminoObjectList;

    public AminozurenHandler() {
        this.aminoObjectList = new ArrayList<>();
    }

    public void initAminozuren() {
        List<String[]> aminoList;
        XMLreader xmlReader = new XMLreader("src/aatoets/data/amino.xml");
        aminoList = xmlReader.getByTag();

        for (String[] aa : aminoList) {
            this.aminoObjectList.add(new Aminozuur(aa[0], aa[1], aa[2], aa[3], aa[4], aa[5], aa[6]));
        }
    }
}
