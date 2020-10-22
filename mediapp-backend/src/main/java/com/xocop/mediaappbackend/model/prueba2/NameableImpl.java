package com.xocop.mediaappbackend.model.prueba2;

public class NameableImpl implements Nameable{

    private String name;

    @Override
    public void setName(String name) {
        if (name.toCharArray().length>20){
            System.out.println("Too long value for name");
        }else{
            this.name=name;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
