package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollData {
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private  String note;
    private  String profilePic;
    private List<String> department;


    public EmployeePayrollData(){}

    public  EmployeePayrollData(int empId, EmployeePayrollDTO employeeParollDTO){
        this.empId =empId;
        this.name=employeeParollDTO.name;
        this.salary=employeeParollDTO.salary;
        this.gender=employeeParollDTO.gender;
        this.note=employeeParollDTO.note;
        this.startDate=employeeParollDTO.startDate;
        this.profilePic=employeeParollDTO.profilPic;
        this.department=employeeParollDTO.department;
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
