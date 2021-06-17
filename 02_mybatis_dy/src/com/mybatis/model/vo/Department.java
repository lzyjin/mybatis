package com.mybatis.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	private String dept_id;
	private String dept_title;
	private String location_id; //  사실은 private Location location_id;
	
}
