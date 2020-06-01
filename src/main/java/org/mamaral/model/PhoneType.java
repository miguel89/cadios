package org.mamaral.model;

public enum PhoneType {
    MOBILE ("Celular"),
    LANDLINE ("Fixo");

    private PhoneType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
