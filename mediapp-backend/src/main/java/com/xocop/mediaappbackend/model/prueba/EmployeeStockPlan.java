package com.xocop.mediaappbackend.model.prueba;

public class EmployeeStockPlan {
    private final int employeeShares=10;
    private final int managerShare=100;
    private final int directorShare=1000;
    public  int grantStock(Employee emp){
        if (emp instanceof  Director){
            return directorShare;
        }
        if(emp instanceof  Manager){
            return managerShare;
        }
        return employeeShares;
    }
}
