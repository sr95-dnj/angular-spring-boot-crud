package com.example.simplecurdsystem.basedangular.controller;

import com.example.simplecurdsystem.basedangular.dto.request.EmployeeDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.EmployeeDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.servises.EmployeeInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeInfoService employeeInfoService;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createEmployee(

            @RequestBody @Valid EmployeeDtoRequest employeeDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(employeeInfoService.createEmployee(employeeDtoRequest), HttpStatus.CREATED);
    }



    @GetMapping("/show/all/list")
    public ResponseEntity<EmployeeDtoResponse> getAllEmployee() {

        return new ResponseEntity(employeeInfoService.getAllEmployeeList(), HttpStatus.OK);
    }

    @GetMapping("/show/list/by/{id}")
    public ResponseEntity<EmployeeDtoResponse> getAllEmployeeById(@PathVariable String id) {

        return new ResponseEntity(employeeInfoService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/update/employee/by/{id}")
    public void updateEmployeeList(@RequestBody EmployeeDtoRequest employeeDtoRequest,@PathVariable String id) {
        employeeInfoService.updateEmployee(employeeDtoRequest,id);
    }

    @DeleteMapping("/delete/employeeList/by/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeInfoService.deleteEmployee(id);
    }
}
