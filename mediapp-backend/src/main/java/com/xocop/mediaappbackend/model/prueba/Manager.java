package com.xocop.mediaappbackend.model.prueba;

import java.util.ArrayList;

public class Manager extends  Employee {
    private String deptName;
    private ArrayList<Employee> staff;
    private Integer employeeCount=0;

    public Manager(Integer empId,String name,String ssn,Double salary,String  deptName){
        super(empId,name,ssn,salary);
        this.deptName=deptName;
        this.staff=new ArrayList<>(20);
    }

    public Boolean findEmployee(Employee obj){
        for (Employee employee : staff) {
            if(employee.getName().toLowerCase().equals(obj.getName().toLowerCase())) return true;
        }
        return  false;
    }

    public Boolean addEmployee(Employee obj){
        if(employeeCount==20) return  false;
        if (findEmployee(obj)) return false;
        this.staff.add(obj);
        this.employeeCount+=1;
        return true;
    }

    public Boolean removeEmployee(Integer id){
        for (Employee employee : staff) {
            if (employee.getEmployeeId()==id){
                staff.remove(employee);
                employeeCount-=1;
                return true;
            }
        }
        return false;
    }

    public void printStaffDetails(){
        System.out.println(this.toString());
        System.out.println("Staff info: ");
        for (Employee employee : staff) {
            System.out.println(employee.toString());
        }
    }

    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public String toString() {
        return "Manager info: " + super.toString()+ "Dept. Name: " + getDeptName();
    }
}
