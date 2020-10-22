package com.xocop.mediaappbackend.model.prueba;

import java.util.ArrayList;

public interface EmployeeDAO {
    public void add(Employee emp);
    public void update(Employee emp);
    public Employee findById(int id);
    public ArrayList<Employee> getAll();
}
