/**
 * Class for parsing an xml for desired nodes. 
 * 
 * created by: Chee M. Lee 4/11/17.
 */
package utilities;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.DocumentBuilder;

public class DomParsing {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	private File folder;
	private File[] filesInsideFolder;
	
	//PUBLIC METHODS
	public DomParsing()
	{
		factory = DocumentBuilderFactory.newInstance();	
		
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public DomParsing(String fileLocation){
		factory = DocumentBuilderFactory.newInstance();
		
		try {
			builder = factory.newDocumentBuilder();
			this.setDocFile(fileLocation);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		//this.setDocFile(fileLocation);
	}
	
	public void printNodes(){
		NodeList tempNodeList = this.doc.getElementsByTagName("student");
		Element tempElement = (Element) tempNodeList.item(0);
		NamedNodeMap tempAttributes = tempElement.getAttributes();
		
		if(tempAttributes != null){
			System.out.println("NamdedNodeMap size: " + tempAttributes.getLength());
			
			for(int x = 0; x<tempAttributes.getLength();x++){
				Node currentNode = tempAttributes.item(x);
				System.out.println(currentNode.getNodeName() + " " + currentNode.getNodeValue());
			}
		}
		else{
			System.out.println("NodeList was null..");
		}
		
	}
	
	public void countDesiredChildNode(String desiredNodeName){
		NodeList tempNodeList = this.doc.getElementsByTagName(desiredNodeName);
		System.out.println("Total " + desiredNodeName + " entries: "+tempNodeList.getLength());
	}
	
	public void multiCountDesiredChildNode(){
		for(int x = 0; x < filesInsideFolder.length; x++){
			if(filesInsideFolder[x].getPath().contains("SCHED_")){
				System.out.print("Processing: "+filesInsideFolder[x].getName()+" >>> ");
				setDocFile(filesInsideFolder[x].getPath());
				countDesiredChildNode("schedule");
			}
		}
	}
	
	//PRIVATE METHODS
	
	//SETTERS AND GETTERS
	public void setFolder(String folderPath)
	{
		this.folder = new File(folderPath);
		this.filesInsideFolder = folder.listFiles();
	}
	
	public void setDocFile(String fileLocation){
		try{
			this.doc = builder.parse(fileLocation);
		}catch(IOException | SAXException e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		DomParsing domParser = new DomParsing("/Users/Kamikazeelee007/Documents/Gracenote/platformWrappers/SCHED_724266.xml");
		//domParser.printNodes();
		//domParser.countDesiredChildNode("schedule");
		domParser.setFolder("/Users/Kamikazeelee007/Documents/Gracenote/platformWrappers");
		domParser.multiCountDesiredChildNode();
		
	}
}
