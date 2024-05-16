import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Client {
    public static void main(String[] args){
        String extract = "";

        Scanner scan = new Scanner(System.in);


       
        System.out.print("Do you want to extract the xml and send it to the server? (y) Yes (n) No : ");
        extract = scan.next();

        if(extract.equals("y")){
            System.out.println("Extracting....");

            try {
                    File xmlFile = new File("XML/product.xml");
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse(xmlFile);
                    doc.getDocumentElement().normalize();


                    NodeList list = doc.getElementsByTagName("product");

                    for(int i = 0; i < list.getLength(); i++){
                        Node nNode =  list.item(i);

                        if(nNode.getNodeType() == Node.ELEMENT_NODE){
                            Element element = (Element) nNode;
                            Product xmlProduct = new Product(
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                element.getElementsByTagName("description").item(0).getTextContent(),
                                Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("retailPrice").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("storePrice").item(0).getTextContent())
                            );
                            System.out.println("Product ID: " + element.getAttribute("id"));
                            System.out.println("    Product Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                            System.out.println("    Product Description: " + element.getElementsByTagName("description").item(0).getTextContent());
                            System.out.println("    Product quantity: " + element.getElementsByTagName("quantity").item(0).getTextContent());
                            System.out.println("    Product retailPrice: " + element.getElementsByTagName("retailPrice").item(0).getTextContent());
                            System.out.println("    Product storePrice: " + element.getElementsByTagName("storePrice").item(0).getTextContent());

                            try {
                                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
                                DB student = (DB) registry.lookup("d");
                                student.QueryBuild("INSERT INTO product_db (name, description, quantity, retailPrice, storePrice) VALUES ('"+ xmlProduct.getName()+"', '"+xmlProduct.getDescription()+"', "+xmlProduct.getQuantiy()+", "+xmlProduct.getRetailPrice()+", "+xmlProduct.getStorePrice()+")");
                                System.out.println("Data is Successfully Migrated.........");
                            } catch (Exception c) {

                                c.printStackTrace();
                            }
                    
                        }
                        
                    }
                    System.out.println("XML Extracting done.........");
                    
                    
                } catch (Exception b) {
                    
                    b.printStackTrace();
                }




        }else{
            System.out.println("Client Closing....");
        }
       


    }
}
