package com.cobol.Java2cbTranformer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Cobol translator sample" );
        FlatToJava f2j=new FlatToJava();
        f2j.convert();
        JavaToFlat j2f=new JavaToFlat();
        j2f.convert();
    }
}
