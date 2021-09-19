package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeePayrollController {



    @Autowired
    private IEmployeePayrollService employeePayrollService;
    /**
     * Post-----call
     * localhost:9090/emp/get
     * @return{
     *     "message": "Get call sucess",
     *     "data": {
     *         "employeeId": 1,
     *         "name": "Bhupendra",
     *         "salary": 3000
     *     }
     * }
     */
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> employeePayrollList=null;
        employeePayrollList=employeePayrollService.getEmployeePayrollData();
//        EmployeePayrollData employeePayrollData=null;
//        employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Bhupendra",3000));
   //     ResponseDTO respDTO=new ResponseDTO("Get call sucess",employeePayrollData);
        ResponseDTO respDTO=new ResponseDTO("Get call sucess",employeePayrollList);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Get ----call OK
     *localhost:9090/emp/get/1
     * @param empId
     * @return{
     *     "message": "Get Call For ID Successfull ",
     *     "data": {
     *         "empId": 1,
     *         "name": "Bhupendra",
     *         "salary": 3000
     *     }
     * }
     */
    @GetMapping("/get/{empId}")
    public  ResponseEntity<ResponseDTO> getEmployeePayrolldata(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData=employeePayrollService.getEmployeePayrollDataById(empId);
//        employeePayrollData =new EmployeePayrollData(empId,new EmployeePayrollDTO("Bhupendra", 3000));
        ResponseDTO respDTO=new ResponseDTO("Get Call For ID Successfull ",employeePayrollData);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * post call--localhost:9090/emp/create
     *@param empPayrollDTO
     * @return
     *{
     *     "name":"bhupi",
     *     "salary":2000
     * }
     */
    @PostMapping("/create")
    public  ResponseEntity<ResponseDTO> addEmployeePayrollData(
         @Valid @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData=employeePayrollService.createEmployeePayrollData(empPayrollDTO);
//        employeePayrollData=new EmployeePayrollData(1,empPayrollDTO);
        ResponseDTO respDTO=new ResponseDTO("Created Employee Data Sucessfully",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO ,HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
       @Valid     @RequestBody EmployeePayrollDTO empPayrollDTO)
    {EmployeePayrollData employeePayrollData=null;
       employeePayrollData =employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
//        employeePayrollData=new EmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO=new ResponseDTO("Updated Employee Payroll Data Sucessfully",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO=new ResponseDTO("Deleted sucessfuly ","deleted id "+empId);
        return  new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
