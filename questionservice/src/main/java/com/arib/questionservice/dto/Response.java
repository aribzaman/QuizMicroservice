package com.arib.questionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Comparable<Response> {

	int id;
	String response;

	@Override
	public int compareTo(Response o) {
		if(this.getId() == o.getId()) return 0;
		return this.getId() > o.getId() ? 1 : -1;
	}
}
