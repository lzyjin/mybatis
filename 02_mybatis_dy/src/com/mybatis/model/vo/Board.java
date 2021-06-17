package com.mybatis.model.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

	private int boardNo;
	private String boardTitle;
	private String boardWriter;// 사실은 private Member writer;
	private String boardContent;
	private Date boardDate;
	private List<Comment> comments;
	
}
