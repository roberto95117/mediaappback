package com.xocop.mediaappbackend.model.prueba2;

public class Fish extends Animal implements Pet{

    private Nameable nameable=new NameableImpl();


    public Fish(){
        super(0);
    }

    public Fish(int legs) {
        super(legs);
    }

    @Override
    public void eat() {
        System.out.println("Fish eat pond scum");
    }

    @Override
    public void play() {
        System.out.println("Just keep swimming");
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public String getName() {
        return nameable.getName();
    }
}
