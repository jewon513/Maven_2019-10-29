package com.biz.sec.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class IolistDTO {

	private long IO_SEQ;//	NUMBER
	private String IO_DATE;//	VARCHAR2(10 BYTE)
	private String IO_INOUT;//	NVARCHAR2(2 CHAR)
	private int IO_QTY;//	NUMBER
	private int IO_TOTAL;//	NUMBER
	private int IO_PRICE;//	NUMBER
	private String IO_PCODE;//	VARCHAR2(5 BYTE)
	private String IO_DCODE;//	VARCHAR2(5 BYTE)
	
}
