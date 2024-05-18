import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLQuery extends DOM {

    public void xmlList(NodeList list){
        super.list = list;
    }

    public void migrate(){
        try {

                for(int i = 0; i < super.list.getLength(); i++){
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
                            DB productDb = (DB) registry.lookup("d");
                            productDb.QueryBuild("INSERT INTO Products (name, description, quantity, retailPrice, storePrice) VALUES ('"+ xmlProduct.getName()+"', '"+xmlProduct.getDescription()+"', "+xmlProduct.getQuantiy()+", "+xmlProduct.getRetailPrice()+", "+xmlProduct.getStorePrice()+")");
                            System.out.println("Data is Successfully Migrated.........");
                        } catch (Exception c) {

                            c.printStackTrace();
                        }
                
                    }
                    
                }
                System.out.println("XML Extracting done.........");

            

        } catch (Exception e) {
            System.out.println();
            // TODO: handle exception
        }
    }
    
}
