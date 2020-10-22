package com.xocop.mediaappbackend.model.prueba;

public class Engineer extends Employee implements ISalary{

    public Engineer(Integer idEmp,String name,String ssn, Double salary){
        super(idEmp,name,ssn,salary);
    }

    @Override
    public Double calcSalary() {
        return getSalary()*10;
    }
}
