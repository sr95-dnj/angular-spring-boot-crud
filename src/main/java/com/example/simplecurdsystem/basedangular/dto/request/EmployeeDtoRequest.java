package com.example.simplecurdsystem.basedangular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoRequest {

    private String userName;

    private String phoneNumber;

    private String jobQualification;

    private String orgName;

}
