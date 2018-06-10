package aatoets.data;

import java.util.ArrayList;

public class Aminozuur {

    private final String naam;
    private final String code1;
    private final String code3;
    private final String hydrofobiciteit;
    private final String lading;
    private final String grootte;
    private final String structuur;

    Aminozuur(String naam, String code1, String code3,
              String hydro, String lading, String grootte, String structuur) {

        this.naam = naam;
        this.code1 = code1;
        this.code3 = code3;
        this.hydrofobiciteit = hydro;
        this.lading = lading;
        this.grootte = grootte;
        this.structuur = structuur;
    }

    public String getNaam() {
        return this.naam;
    }

    public String getCode1() {
        return this.code1;
    }

    public String getCode3() {
        return this.code3;
    }

    public String getHydrofobiciteit() {
        return this.hydrofobiciteit;
    }

    public String getLading() {
        return this.lading;
    }

    public String getGrootte() {
        return this.grootte;
    }

    public String getStructuur() {
        return this.structuur;
    }
}
