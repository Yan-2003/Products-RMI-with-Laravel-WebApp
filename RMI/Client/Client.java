import java.util.Scanner;


public class Client {
    public static void main(String[] args){
        String extract = "";

        Scanner scan = new Scanner(System.in);


       
        System.out.print("Do you want to extract the xml and send it to the server? (y) Yes (n) No : ");
        extract = scan.next();

        if(extract.equals("y")){
            System.out.println("Extracting....");


            XMLParser productDOM = new XMLParser();
            
            XMLQuery xmlquery = new XMLQuery();

            productDOM.xmlFile("XML/product.xml");
            xmlquery.xmlList(productDOM.parse());
            xmlquery.migrate();


        }else{
            System.out.println("Client Closing....");
        }
        scan.close();


    }
}
