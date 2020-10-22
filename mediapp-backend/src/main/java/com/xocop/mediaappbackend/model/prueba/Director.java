package com.xocop.mediaappbackend.model.prueba;

public class Director extends Manager implements ISalary{

    private Double budget;

    public Director(Integer empId, String name, String ssn, Double salary, String deptName,Double budget) {
        super(empId, name, ssn, salary, deptName);
        this.budget=budget;
    }


    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Override
    public Double calcSalary() {
        return getSalary()*8;
    }

    @Override
    public String toString(){
        return "Director info: " + super.toString()+ "Budget: " + getBudget();
    }
}
