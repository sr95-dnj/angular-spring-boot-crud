package com.example.simplecurdsystem.basedangular.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoResponse {

    private String id;

    private String userName;

    private String phoneNumber;

    private String jobQualification;

    private String orgName;

}
