package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name can't null ")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name Invalid")
    public  String name;


    @Min(value = 500, message = "Min Wage Should be More than 500")
    public  long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name=name;
        this.salary=salary;

    }
    @Override
    public String toString(){
        return "name="+name+":salary="+salary;
    }
}
