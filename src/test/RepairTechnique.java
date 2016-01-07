package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.notification.Failure;

public class RepairTechnique {

	public File repair(String new_file, String old_URL, String new_URL, Failure failure) throws IOException{
		
		System.out.println("****************** FAILURE PROFILE ESTABLISHMENT ******************"); 
		System.out.println("OLD VERSION URL: "+old_URL); 
		System.out.println("NEW VERSION URL: "+new_URL);
		

		String fail=failure.toString(); 
		
		
		
		int start=fail.indexOf("{"); 
		int end=fail.indexOf("}"); 
		fail=fail.substring(start, end+1);
		
		
		String[] arr = fail.split(","); 
		String method=arr[0]; 
		String locator=arr[1];
		start=fail.indexOf(":\"");
		end=fail.indexOf("\","); 
		
		method=fail.substring(start, end); 
		method=method.replace(":\"", ""); 
		//System.out.println("METHOD==============>"+method); 
		start=locator.indexOf(":\"");
		end=locator.indexOf("\"}"); 
		locator=locator.substring(start, end); 
		locator=locator.replace(":\"", ""); 
		
		
		
		//System.out.println("LOCATOR==============>"+locator);  
		 
		System.out.println("FAILURE DESCRIPTION: Could not locate the element with locator====> \""+locator+ "\", using the technique"
				+ "====> \""+ method+"\"");
		System.out.println("---------------------------------------------------------------------"); 
		System.out.println("---------------------------------------------------------------------");
		
		org.jsoup.nodes.Document doc = Jsoup.connect(old_URL).get();
		
		if(method.equals("link text")){
			   Elements links = doc.getElementsByTag("a");
			    Element elem=null; 
			    for (Element link : links) {
			    	  String linkText = link.text();
			      if(linkText.equals(locator)){
			    	  elem=link; 
			      }
			    
			    
			    }
			   
	System.out.println("--------------------PROFILE ESTABLISHEMENT FOR UNLOCATED ELEMENT-----------------"); 
			    
			    	  String linkHref = elem.attr("href"); // "http://example.com/"
			     if(linkHref!=""){
						System.out.println("HREF ATTRIBUTE VALUE: "+linkHref); 
			    }
			     
			     //ID ATTRIBUTE
			     String id = elem.attr("id"); 
			     if(id!=""){
						System.out.println("ID ATTRIBUTE VALUE: "+id); 
			    }
			     //NAME ATTRIBUTE
			     String name = elem.attr("name"); 
			     if(name!=""){
						System.out.println("NAME ATTRIBUTE VALUE: "+name); 
			    }
			     
		}
		
		
		
		
		
		
		
		org.jsoup.nodes.Document doc2 = Jsoup.connect(new_URL).get();
		
		
		
//		org.jsoup.nodes.Document docc = Jsoup.connect("http://cse.unl.edu/~mouna/WebApps/AddressBook/addressbookv1.2/").get();
//    	Element link = docc.select("a").first();
//
//    	String text = docc.body().text(); // "An example link"
//    	System.out.println("heyyy"+text); 
//    	String linkHref = link.attr("href"); // "http://example.com/"
//    	System.out.println("hey2"+linkHref); 
//    	String linkText = link.text(); // "example""
//    	System.out.println("hey3"+linkText); 
//    	String linkOuterH = link.outerHtml(); 
//    	System.out.println("hey3  "+linkOuterH); 
//    	    // "<a href="http://example.com"><b>example</b></a>"
//    	String linkInnerH = link.html(); // "<b>example</b>"; 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		File file = new File(new_file); 
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(new_file), "utf-8"));
		    writer.write("Something");
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		return file; 
	}
	
	
	
}
