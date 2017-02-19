package com.cobol.Java2cbTranformer;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import net.sf.cb2java.copybook.Copybook;
import net.sf.cb2java.copybook.CopybookParser;
import net.sf.cb2java.data.Record;

public class FlatToJava {

	CbJHelper helper=new CbJHelper();
	
	public void convert(){
		try{
		 Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("src/main/resources/b.copybook")));
	        List<Record> results = copybook.parseData(new FileInputStream(new File("src/main/resources/b.input.txt")));
	        Map<String,Object> record = results.get(0).toMap();
	        helper.print(record);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
