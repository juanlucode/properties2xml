package io.github.juanlucode.properties2xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class properties2xml {
    public static void main(String[] args) throws Exception {

	    Properties props = new Properties();
	    
	    InputStream is = new FileInputStream("/home/juanluis/Descargas/build.properties");
	    props.load(is);
	    OutputStream os = new FileOutputStream("/home/juanluis/Descargas/build.xml");
	
	    for (Enumeration e = props.keys(); e.hasMoreElements() ; ) {
	        // Obtenemos el objeto
	        Object obj = e.nextElement();
	        StringBuilder linea = new StringBuilder();
	        linea.append("<");
	        linea.append(obj.toString());
	        linea.append(">");
	        linea.append(props.getProperty(obj.toString()));
	        linea.append("</");
	        linea.append(obj.toString());
	        linea.append(">");
	        linea.append("\n");
	        os.write(linea.toString().getBytes());
	        System.out.println(linea.toString());
	    }
	    
	    os.flush();
	    os.close();
    }
}
