package com.service.provider.comm.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.service.provider.comm.utils.JsonMapper;

public class Test {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		String string="{\"TEST_ID\":[{\"ID\":\"123456789\"}]}";
		//有坑
		JsonMapper map=JsonMapper.nonDefaultMapper();
		TestJackSon test=map.toObjct(string, TestJackSon.class);
		//TestJackSon test=new TestJackSon();
		//Dto dto=new Dto(); dto.setId("123456789");
		//List<Dto> list=new ArrayList<Dto>();
		//list.add(dto);
		//test.setTestId(list);
		System.out.println(string);
		System.out.println(map.toJson(test));
		
		TestJackSon2 test2=new TestJackSon2();
		//bug 
		org.springframework.beans.BeanUtils.copyProperties(test, test2);
		System.out.println(":"+map.toJson(test2));*/
		Dto dto=new Dto(); 
		dto.setId("123456789");
		dto.setPrice1(new BigDecimal(1.1));
		dto.setPrice(new BigDecimal(1.19999));
		dto.setDate(new Date());
		JsonMapper map=JsonMapper.nonDefaultMapper();
		System.out.println(map.toJson(dto));
		
		//String dateString="{\"price\":1.19999,\"price1\":1.19999,\"id\":\"123456789\",\"DATE\":\"2018-01-19 17:05:49\"}";
		String dateString="{\"price1\":1.19999,\"id\":\"123456789\",\"DATE\":\"2018-01-19 17:05:49\"}";

	
		Dto dto1=map.toObjct(dateString, Dto.class);
		System.out.println(map.toJson(dto1)+"=="+dto1.getPrice()+":"+dto1.getPrice1());
	
	}

}
