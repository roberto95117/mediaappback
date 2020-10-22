package com.xocop.mediaappbackend.model.prueba2;

public class AmbulatoryImpl implements Ambulatory{

    private Integer legs;
    @Override
    public void walk() {
        System.out.println("This animal walks on "+ legs+ " legs");
    }

    public AmbulatoryImpl(Integer legs){this.legs=legs;}
}
