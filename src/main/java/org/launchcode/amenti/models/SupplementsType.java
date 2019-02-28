package org.launchcode.amenti.models;

public enum SupplementsType {

    DAILY ("Everyday Use"),
    HEART ("Heart Health"),
    BRAIN ("Brain Health"),
    IMMUNE ("Immune Support"),
    PRENATAL ("Prenatal"),
    DIET ("Weight Loss"),
    MISC ("Miscellaneous");

    public boolean isDaily() {
        return this == DAILY;
    }

    public boolean isHeart() {
        return this == HEART;
    }

    public boolean isBrain() {
        return this == BRAIN;
    }

    public boolean isImmune() {
        return this == IMMUNE;
    }

    public boolean isPrenatal() {
        return this == PRENATAL;
    }

    public boolean isDiet() {
        return this == DIET;
    }

    public boolean isMisc() {
        return this == MISC;
    }

    private final String name;

    SupplementsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
