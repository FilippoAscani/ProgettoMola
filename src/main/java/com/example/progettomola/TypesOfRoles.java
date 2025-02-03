package com.example.progettomola;

public enum TypesOfRoles {

    USER(0),       // vale 0
    ARTIST(1),
    SPONSOR(2);

    private final int id;

    TypesOfRoles(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TypesOfRoles fromId(int id) {
        for (TypesOfRoles role : TypesOfRoles.values()) {
            if (role.getId() == id) {
                return role;
            }

        }
        return null;
    }

}
