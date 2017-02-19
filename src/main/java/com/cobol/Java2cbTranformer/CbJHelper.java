package com.cobol.Java2cbTranformer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class CbJHelper {

	public void print(Map<String,Object> data){
		Map<String,Object> rootMap=data;
		if(data.containsKey("ROOT"))
			rootMap=(Map<String,Object>)data.get("ROOT");
		
	
		for(Entry<String, Object> e:rootMap.entrySet()){	
			if(rootMap.get(e.getKey()) instanceof List){
				List temp = (List)rootMap.get(e.getKey());
				for(int i=0;i<temp.size();i++){
					Map<String,Object> tempMap=(Map<String,Object>)temp.get(i);
					print(tempMap);
				}
			}else{
				System.out.println(e.getKey() +"=>"+ e.getValue().toString());
			}
		}
	}
}
