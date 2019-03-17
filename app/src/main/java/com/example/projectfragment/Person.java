package com.example.projectfragment;

public class Person {
    private String name;
    private String TelNr;

    public Person(String name, String telNr) {
        this.name = name;
        TelNr = telNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNr() {
        return TelNr;
    }

    public void setTelNr(String telNr) {
        TelNr = telNr;
    }
}
