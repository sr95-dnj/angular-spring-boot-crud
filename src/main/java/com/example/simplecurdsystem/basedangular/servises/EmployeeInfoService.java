package com.example.simplecurdsystem.basedangular.servises;

import com.example.simplecurdsystem.basedangular.domain.EmployeeInformation;
import com.example.simplecurdsystem.basedangular.dto.request.EmployeeDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.EmployeeDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.repository.EmployeeRepository;
import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeInfoService {

    private final EmployeeRepository employeeRepository;

    private final UuidUtil uuidUtil;


    public IdentificationResponse createEmployee(EmployeeDtoRequest employeeDtoRequest) {

        String id = uuidUtil.getUuidUtil();

        EmployeeInformation employeeInformation = new EmployeeInformation();

        employeeInformation.setId(id);
        employeeInformation.setUserName(employeeDtoRequest.getUserName());
        employeeInformation.setPhoneNumber(employeeDtoRequest.getPhoneNumber());
        employeeInformation.setJobQualification(employeeDtoRequest.getJobQualification());
        employeeInformation.setOrgName(employeeDtoRequest.getOrgName());

        employeeRepository.saveAndFlush(employeeInformation);

        return new IdentificationResponse(id);

    }


    public List<EmployeeDtoResponse> getAllEmployeeList() {

        List<EmployeeInformation> employeeInformationList = employeeRepository.findAll();

        List<EmployeeDtoResponse> employeeDtoResponseList = new ArrayList<>();

        for (EmployeeInformation employeeInformation : employeeInformationList) {

            EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();

            employeeDtoResponse.setId(employeeInformation.getId());
            employeeDtoResponse.setUserName(employeeInformation.getUserName());
            employeeDtoResponse.setPhoneNumber(employeeInformation.getPhoneNumber());
            employeeDtoResponse.setJobQualification(employeeInformation.getJobQualification());
            employeeDtoResponse.setOrgName(employeeInformation.getOrgName());

            employeeDtoResponseList.add(employeeDtoResponse);
        }
        return employeeDtoResponseList;
    }
    
    
    public EmployeeDtoResponse getEmployeeById(String id){

        Optional<EmployeeInformation> employeeInformationOptional = employeeRepository.findAllById(id);

        if (!employeeInformationOptional.isPresent()){

            throw new RuntimeException("Employee Not Found");
        }

        EmployeeInformation employeeInformation = employeeInformationOptional.get();

        EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();

        employeeDtoResponse.setId(employeeInformation.getId());
        employeeDtoResponse.setUserName(employeeInformation.getUserName());
        employeeDtoResponse.setPhoneNumber(employeeInformation.getPhoneNumber());
        employeeDtoResponse.setJobQualification(employeeInformation.getJobQualification());
        employeeDtoResponse.setOrgName(employeeInformation.getOrgName());

        return employeeDtoResponse;
    }


    public void updateEmployee(EmployeeDtoRequest employeeDtoRequest,String id){

        Optional<EmployeeInformation> employeeInformationOptional = employeeRepository.findAllById(id);

        if (!employeeInformationOptional.isPresent()){
            throw new RuntimeException("Employee Not Found");
        }

        EmployeeInformation employeeInformation = employeeInformationOptional.get();

        employeeInformation.setUserName(employeeDtoRequest.getUserName());
        employeeInformation.setPhoneNumber(employeeDtoRequest.getPhoneNumber());
        employeeInformation.setJobQualification(employeeDtoRequest.getJobQualification());
        employeeInformation.setOrgName(employeeDtoRequest.getOrgName());

        employeeRepository.save(employeeInformation);

    }


    public void deleteEmployee(String id){

        Optional<EmployeeInformation> employeeInformationOptional = employeeRepository.findAllById(id);

        if (!employeeInformationOptional.isPresent()){
            throw new RuntimeException("Employee Not Found");
        }
        EmployeeInformation employeeInformation = employeeInformationOptional.get();

        employeeRepository.delete(employeeInformation);

    }

}
