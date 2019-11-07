package com.biz.sec.persistence;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DetailDTO {

	private long d_seq;
	private long d_m_seq; // Master Table과 연계를 수행하는 FOREIN KEY
	private String d_subject;
	private String d_ok;
	
}
