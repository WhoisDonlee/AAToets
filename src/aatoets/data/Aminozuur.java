package aatoets.data;

class Aminozuur {

    private final String naam;
    private final String code1;
    private final String code3;
    private final String hydrofobiciteit;
    private final String lading;
    private final String grootte;
    private final String voorkeur3D;

    Aminozuur(String naam, String code1, String code3,
              String hydro, String lading, String grootte, String  voorkeur3D) {

        this.naam = naam;
        this.code1 = code1;
        this.code3 = code3;
        this.hydrofobiciteit = hydro;
        this.lading = lading;
        this.grootte = grootte;
        this.voorkeur3D = voorkeur3D;
    }

    String getNaam() {
        return this.naam;
    }

    String getCode1() {
        return this.code1;
    }

    String getCode3() {
        return this.code3;
    }

    String getHydrofobiciteit() {
        return this.hydrofobiciteit;
    }

    String getLading() {
        return this.lading;
    }

    String getGrootte() {
        return this.grootte;
    }

    String getVoorkeur3D() {
        return this.voorkeur3D;
    }
}
