package com.xocop.mediaappbackend.model.prueba;

import java.text.NumberFormat;

public class Employee {
    private  Integer employeeId;
    private  String name;
    private  String ssn;
    private  Double salary;

    public void raiseSalary(double increase){
        this.salary+=increase;
    }
    public Employee() {

    }

    public Employee(Integer employeeId, String name, String ssn, Double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", salary=" + NumberFormat.getCurrencyInstance().format(salary) +
                '}';
    }
}
