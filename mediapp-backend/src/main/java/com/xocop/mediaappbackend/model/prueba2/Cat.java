package com.xocop.mediaappbackend.model.prueba2;

public class Cat extends  Animal implements  Pet{

    private Ambulatory ambulatory;
    private Nameable nameable=new NameableImpl();

    public Cat(String name) {
        super(4);
        ambulatory=new AmbulatoryImpl(4);
    }

    public Cat(){
        this("Fuflly");
    }

    @Override
    public void eat() {
        System.out.println(" Cats like to eat spiders and fish");
    }


    @Override
    public void play() {
        System.out.println(" likes to play with strings");
    }

    @Override
    public void setName(String name) {
        this.nameable.setName(name);
    }

    @Override
    public String getName() {return this.nameable.getName();
    }

    public void walk() {
        this.ambulatory.walk();
    }
}
