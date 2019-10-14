package com.narkevich.bsuirlab;

import java.text.DateFormat;
import java.util.List;

public class Nurse {
    private String name;
    private DateFormat birthDate;
    private String position;

    public Nurse(String name, DateFormat birthDate, String position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }
}
