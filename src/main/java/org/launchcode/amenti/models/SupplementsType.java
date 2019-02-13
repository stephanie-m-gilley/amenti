package org.launchcode.amenti.models;

public enum SupplementsType {

    DAILY ("Everyday Use"),
    HEART ("Heart Health"),
    BRAIN ("Brain Health"),
    IMMUNE ("Immune Support"),
    PRENATAL ("Prenatal"),
    DIET ("Weight Loss"),
    MISC ("Miscellaneous");

    private final String name;

    SupplementsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
