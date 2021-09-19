package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

@Data
public class EmployeePayrollData {
    private int empId;
    private String name;
    private long salary;

    public EmployeePayrollData(int empId, EmployeePayrollData empPayrollDTO){}

    public  EmployeePayrollData(int empId, EmployeePayrollDTO employeeParollDTO){
        this.empId =empId;
        this.name=employeeParollDTO.name;
        this.salary=employeeParollDTO.salary;
    }



//    public int getEmpId(){
//        return empId;
//    }
//    public void setEmpId(int empId){
//        this.empId = empId;
//    }
    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public long getSalary() {
//        return salary;
//    }
//
//    public void setSalary(long salary) {
//        this.salary = salary;
//    }

}
