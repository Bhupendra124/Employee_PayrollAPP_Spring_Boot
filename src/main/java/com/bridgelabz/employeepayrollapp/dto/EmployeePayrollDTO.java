package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public @ToString
class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name can't null ")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name Invalid")
    public  String name;


    @Min(value = 500, message = "Min Wage Should be More than 500")
    public  long salary;


    public  String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date should not be Empty")
    @PastOrPresent(message = "Start Date should be past date or today's date")
    public LocalDate startDate;


    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilPic;

    @NotBlank(message = "department should Not be Empty")
    public List<String> department;



    public EmployeePayrollDTO(String name, long salary) {
        this.name=name;
        this.salary=salary;

    }
    @Override
    public String toString(){
        return "name="+name+":salary="+salary;
    }
}
