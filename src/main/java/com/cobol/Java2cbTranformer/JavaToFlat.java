package com.cobol.Java2cbTranformer;

import net.sf.JRecord.Common.AbstractRecord;
import net.sf.JRecord.Common.Constants;
import net.sf.JRecord.Common.IFieldDetail;
import net.sf.JRecord.Details.AbstractLine;
import net.sf.JRecord.Details.BaseLine;
import net.sf.JRecord.Details.LayoutDetail;
import net.sf.JRecord.Details.Line;
import net.sf.JRecord.Details.XmlLine;
import net.sf.JRecord.External.CobolCopybookLoader;
import net.sf.JRecord.External.CopybookLoader;
import net.sf.JRecord.External.ExternalRecord;
import net.sf.JRecord.External.ToLayoutDetail;
import net.sf.JRecord.IO.AbstractLineWriter;
import net.sf.JRecord.IO.LineIOProvider;

public class JavaToFlat {

	public void convert(){
		try {
			int fileStructure = Constants.IO_FIXED_LENGTH;
			AbstractLineWriter writer = LineIOProvider.getInstance().getLineWriter(fileStructure);
			writer.open("src/main/resources/out.flat");
			
			CopybookLoader loader = new CobolCopybookLoader();
			ExternalRecord extlayout = loader.loadCopyBook("src/main/resources/b.copybook", 0, 0, "", 0, 0, null);
			/*
			 * Converting from the interchange (ExternalRecord) format to
			 * LayoutDetail
			 */
			LayoutDetail layout = ToLayoutDetail.getInstance().getLayout(extlayout);
			AbstractLine saleRecord = new Line(layout);
			
			
			//AbstractLine saleRecord1=sub.
			
			saleRecord.getFieldValue("A").set("ABCDEF");
			saleRecord.getFieldValue("B").set("BCDE");
			saleRecord.getFieldValue("C").set(12345);
			saleRecord.getFieldValue("D").set("1234");
			
			IFieldDetail sube0=layout.getGroupField("SUB","E (0)");
			IFieldDetail subf0=layout.getGroupField("SUB","F (0)");
			saleRecord.getFieldValue(sube0).set("E");
			saleRecord.getFieldValue(subf0).set("FF");
			
			
			IFieldDetail sube=layout.getGroupField("SUB","E (1)");
			IFieldDetail subf=layout.getGroupField("SUB","F (1)");
			saleRecord.getFieldValue(sube).set("EEE");
			saleRecord.getFieldValue(subf).set("FFF");
			
			
			//https://sourceforge.net/p/jrecord/discussion/678634/thread/176dcea6/
			//http://www.3480-3590-data-conversion.com/article-reading-cobol-layouts-2.html
			
			writer.write(saleRecord);
			
			writer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
