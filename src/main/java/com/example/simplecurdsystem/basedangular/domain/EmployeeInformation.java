package com.example.simplecurdsystem.basedangular.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInformation extends BaseEntity{

    private String userName;

    private String phoneNumber;

    private String jobQualification;

    private String orgName;

}
