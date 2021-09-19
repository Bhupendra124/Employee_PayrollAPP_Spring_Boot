package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.ArrayList;
import java.util.List;



@org.springframework.stereotype.Service
public class Service implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream().filter(empData->empData.getEmpId()==empId)
                .findFirst()
                .orElseThrow(()-> new EmployeePayrollException("Employee not found "));
    }

    @Override
    public EmployeePayrollData getEmployeePayrollData(int empId) {
//
        return employeePayrollList.get(empId-1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
  employeePayrollList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {

    }
}
