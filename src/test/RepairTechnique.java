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
import org.junit.runner.notification.Failure;

public class RepairTechnique {

	public File repair(String new_file, String old_URL, String new_URL, Failure failure) throws IOException{
		
		System.out.println("******************FAILURE PROFILE ESTABLISHED******************"); 
		System.out.println("OLD VERSION URL: "+old_URL); 
		System.out.println("NEW VERSION URL: "+new_URL);
		System.out.println("FAILURE DESCRIPTION: "+failure.toString());
		System.out.println("*****************************************************************"); 

		org.jsoup.nodes.Document doc = Jsoup.connect(old_URL).get();
		org.jsoup.nodes.Document doc2 = Jsoup.connect(new_URL).get();
		
		
		
		org.jsoup.nodes.Document docc = Jsoup.connect("http://cse.unl.edu/~mouna/WebApps/AddressBook/addressbookv1.2/").get();
    	Element link = docc.select("a").first();

    	String text = docc.body().text(); // "An example link"
    	System.out.println("heyyy"+text); 
    	String linkHref = link.attr("href"); // "http://example.com/"
    	System.out.println("hey2"+linkHref); 
    	String linkText = link.text(); // "example""
    	System.out.println("hey3"+linkText); 
    	String linkOuterH = link.outerHtml(); 
    	System.out.println("hey3  "+linkOuterH); 
    	    // "<a href="http://example.com"><b>example</b></a>"
    	String linkInnerH = link.html(); // "<b>example</b>"; 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
