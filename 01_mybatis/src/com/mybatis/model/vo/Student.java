package com.mybatis.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
@Data // getter, setter, 기본생성자, toString, hashcode, equals override 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
		
//	private int student_No;
//	private String student_Name;
//	private String student_Tel;
//	private String student_Email;
//	private String student_Addr;
//	private Date reg_Date;
	
	private int studentNo;
	private String studentName;
	private String studentTel;
	private String studentEmail;
	private String studentAddr;
	private Date regDate;

}
