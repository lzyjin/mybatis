package com.mybatis.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

//	private String empId;
//	private String empName;
//	private String empNo;
//	private String email;
//	private String phone;
//	private String deptCode;
//	private String jobCode;
//	private String salLevel;
//	private int salary;
//	private int bonus;
//	private String managerId;
//	private Date hireDate;
//	private Date entDate;
//	private String entYn;
	
	private String emp_id;
	private String emp_name;
	private String emp_no;
	private String email;
	private String phone;
	private Department dept;
	private String job_code;
	private String sal_level;
	private int salary;
	private int bonus;
	private String manager_id; // 사실 이것도 private Employee manager_id;
	private Date hire_date;
	private Date ent_date;
	private String ent_yn; 
	
}
