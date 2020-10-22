package com.xocop.mediaappbackend.model.prueba;

public class Admin extends Employee implements  ISalary{

    public Admin(Integer idEmp,String name,String ssn, Double salary){
        super(idEmp,name,ssn,salary);
    }

    @Override
    public Double calcSalary() {
        return this.getSalary()*9;
    }
}
