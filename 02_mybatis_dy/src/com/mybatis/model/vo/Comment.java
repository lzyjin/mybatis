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
public class Comment {

	private int commentNo;
	private String commentContent;
	private String commentWriter;
	private Date commentDate;
	private int commentLevel;
}
