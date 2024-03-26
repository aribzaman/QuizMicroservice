package com.arib.quizservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response implements Comparable<Response> {

	Integer id;
	String response;

	@Override
	public int compareTo(Response o) {
		if(this.getId() == o.getId()) return 0;
		return this.getId() > o.getId() ? 1 : -1;
	}
}
