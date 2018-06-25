package aatoets.data;

import java.util.ArrayList;
import java.util.Arrays;

class Vragen {
    private static ArrayList<String> volledigeNaamVragen = new ArrayList<>(Arrays.asList(
            "Wat is de 1-lettercode van aminozuur %s?",
            "Wat is de 3-lettercode van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de zijketen van aminozuur %s"
    ));
    private static ArrayList<String> code1Vragen = new ArrayList<>(Arrays.asList(
            "Wat is de volledigenaam van aminozuur %s?",
            "Wat is de 3-lettercode van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de zijketen van aminozuur %s?"
    ));
    private static ArrayList<String> code3Vragen = new ArrayList<>(Arrays.asList(
            "Wat is de volledigenaam van aminozuur %s?",
            "Wat is de 1-lettercode van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de zijketen van aminozuur %s?"
    ));
    private static ArrayList<String> hydrofobiciteitVragen = new ArrayList<>(Arrays.asList(
            "Welk aminozuur is %s?",
            "Welk aminozuur is niet %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur met de volgende zijketen:"
    ));
    private static ArrayList<String> ladingVragen = new ArrayList<>(Arrays.asList(
            "Welk aminozuur is %s?",
            "Welk aminozuur is niet %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de lading van aminozuur met de volgende zijketen:"
    ));
    private static ArrayList<String> grootteVragen = new ArrayList<>(Arrays.asList(
            "Welk aminozuur is %s?",
            "Welk aminozuur is niet %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de grootte van aminozuur met de volgende zijketen:"
    ));
    private static ArrayList<String> voorkeur3DVragen = new ArrayList<>(Arrays.asList(
            "Welk aminozuur heeft een voorkeur voor <helix/turn/sheet>?",
            "Welk aminozuur heeft geen voorkeur voor een <helix/turn/sheet>?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur met de volgende zijketen:"
    ));
    private static ArrayList<String> zijketenVragen = new ArrayList<>(Arrays.asList(
            "Wat is de volledigenaam van het volgende aminozuur met zijketen:",
            "Wat is de 1-lettercode van het volgende aminozuur met zijketen:",
            "Wat is de hydrofobiciteit het volgende aminozuur met zijketen:",
            "Wat is de lading van het volgende aminozuur met zijketen:",
            "Wat is de grootte van het volgende aminozuur met zijketen:",
            "Wat is de 3D voorkeur van het volgende aminozuur met zijketen:"
    ));

    private static ArrayList<String> volledigeNaamAlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de volledigenaam van aminozuur %s?",
            "Welk aminozuur is %s?",
            "Welk aminozuur is niet %s?",
            "Welk aminozuur heeft een voorkeur voor <helix/turn/sheet>?",
            "Welk aminozuur heeft geen voorkeur voor een <helix/turn/sheet>?",
            "Wat is de volledigenaam van het volgende aminozuur met zijketen:"
    ));

    private static ArrayList<String> code1AlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de 1-lettercode van %s?",
            "Wat is de 1-lettercode van aminozuur %s?",
            "Welk aminozuur is %s?",
            "Welk aminozuur is niet %s?",
            "Welk aminozuur heeft een voorkeur voor <helix/turn/sheet>?",
            "Welk aminozuur heeft geen voorkeur voor een <helix/turn/sheet>?",
            "Wat is de 1-lettercode van het volgende aminozuur met zijketen:"
    ));

    private static ArrayList<String> code3AlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de 3-lettercode van %s?",
            "Wat is de 3-lettercode van aminozuur %s?",
            "Welk aminozuur is %s?",
            "Welk aminozuur is niet %s?",
            "Welk aminozuur heeft een voorkeur voor <helix/turn/sheet>?",
            "Welk aminozuur heeft geen voorkeur voor een <helix/turn/sheet>?",
            "Wat is de 3-lettercode van het volgende aminozuur met zijketen:"
    ));

    private static ArrayList<String> hydrofobiciteitAlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur %s?",
            "Wat is de hydrofobiciteit van aminozuur met de volgende zijketen:"
    ));

    private static ArrayList<String> ladingAlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de lading van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de lading van aminozuur %s?",
            "Wat is de lading van aminozuur met de volgende zijketen:"
    ));

    private static ArrayList<String> grootteAlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de grootte van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de grootte van aminozuur %s?",
            "Wat is de grootte van aminozuur met de volgende zijketen:"
    ));

    private static ArrayList<String> voorkeur3DAlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur %s?",
            "Wat is de 3D voorkeur van aminozuur met de volgende zijketen:"
    ));

    private static ArrayList<String> zijketenAlsAntwoord = new ArrayList<>(Arrays.asList(
            "Wat is de zijketen van aminozuur %s?",
            "Wat is de zijketen van aminozuur %s?",
            "Wat is de zijketen van aminozuur %s?"
    ));

    private static ArrayList<String> getVolledigeNaamVragen() {
        return volledigeNaamVragen;
    }

    private static ArrayList<String> getCode1Vragen() {
        return code1Vragen;
    }

    private static ArrayList<String> getCode3Vragen() {
        return code3Vragen;
    }

    private static ArrayList<String> getHydrofobiciteitVragen() {
        return hydrofobiciteitVragen;
    }

    private static ArrayList<String> getLadingVragen() {
        return ladingVragen;
    }

    private static ArrayList<String> getGrootteVragen() {
        return grootteVragen;
    }

    private static ArrayList<String> getVoorkeur3DVragen() {
        return voorkeur3DVragen;
    }

    private static ArrayList<String> getZijketenVragen() {
        return zijketenVragen;
    }

    private static ArrayList<String> getVolledigeNaamAlsAntwoord() {
        return volledigeNaamAlsAntwoord;
    }

    private static ArrayList<String> getCode1AlsAntwoord() {
        return code1AlsAntwoord;
    }

    private static ArrayList<String> getCode3AlsAntwoord() {
        return code3AlsAntwoord;
    }

    private static ArrayList<String> getHydrofobiciteitAlsAntwoord() {
        return hydrofobiciteitAlsAntwoord;
    }

    private static ArrayList<String> getLadingAlsAntwoord() {
        return ladingAlsAntwoord;
    }

    private static ArrayList<String> getGrootteAlsAntwoord() {
        return grootteAlsAntwoord;
    }

    private static ArrayList<String> getVoorkeur3DAlsAntwoord() {
        return voorkeur3DAlsAntwoord;
    }

    private static ArrayList<String> getZijketenAlsAntwoord() {
        return zijketenAlsAntwoord;
    }

    static ArrayList<String> returnListByName(String lijstNaam, String type) {
        ArrayList<String> temp = new ArrayList<>();
        if (type.equals("vraag")) {
            switch (lijstNaam) {
                case "Volledige Naam":
                    temp = Vragen.getVolledigeNaamVragen();
                    break;
                case "1 lettercode":
                    temp = Vragen.getCode1Vragen();
                    break;
                case "3 lettercode":
                    temp = Vragen.getCode3Vragen();
                    break;
                case "Hydrofobiciteit":
                    temp = Vragen.getHydrofobiciteitVragen();
                    break;
                case "Lading":
                    temp = Vragen.getLadingVragen();
                    break;
                case "Grootte":
                    temp = Vragen.getGrootteVragen();
                    break;
                case "3D Voorkeur":
                    temp = Vragen.getVoorkeur3DVragen();
                    break;
                case "Structuur":
                    temp = Vragen.getZijketenVragen();
                    break;
            }

        } else if (type.equals("alsAntwoord")) {
            switch (lijstNaam) {
                case "Volledige Naam":
                    temp = Vragen.getVolledigeNaamAlsAntwoord();
                    break;
                case "1 lettercode":
                    temp = Vragen.getCode1AlsAntwoord();
                    break;
                case "3 lettercode":
                    temp = Vragen.getCode3AlsAntwoord();
                    break;
                case "Hydrofobiciteit":
                    temp = Vragen.getHydrofobiciteitAlsAntwoord();
                    break;
                case "Lading":
                    temp = Vragen.getLadingAlsAntwoord();
                    break;
                case "Grootte":
                    temp = Vragen.getGrootteAlsAntwoord();
                    break;
                case "3D Voorkeur":
                    temp = Vragen.getVoorkeur3DAlsAntwoord();
                    break;
                case "Structuur":
                    temp = Vragen.getZijketenAlsAntwoord();
                    break;
            }
        }
        return temp;
    }
}
