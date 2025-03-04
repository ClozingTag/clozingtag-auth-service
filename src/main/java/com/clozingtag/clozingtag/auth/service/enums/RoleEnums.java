package com.clozingtag.clozingtag.auth.service.enums;

public enum RoleEnums {
    Admin("ROLE_ADMIN"),

    User("ROLE_USER");

    private final String value;

    RoleEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}