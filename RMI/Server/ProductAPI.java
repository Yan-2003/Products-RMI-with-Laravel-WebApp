import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductAPI implements DB{
    
    MySql MyProduct = new MySql();

    ProductAPI(){
        MyProduct.setUser("root"); /* username of the database */
        MyProduct.setHost("localhost:3306");/* host name of the database */
        MyProduct.setDBname("product_db"); /* Database name */
        MyProduct.setPassword("Jul-092003"); /* Database Password */
    }

    @Override
    public ArrayList<Product> getQueryResult(String query) throws RemoteException {
        ArrayList<Product> list = new ArrayList<>();
        try {

            Class.forName(MyProduct.getDriver());
            Connection con = DriverManager.getConnection(
                    MyProduct.getConnectionDB(),MyProduct.getUser(),
                    MyProduct.getPassword()
                );
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Product object = new Product(
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getInt(4), 
                    rs.getDouble(5), 
                    rs.getDouble(6)
                );
                
                System.out.println("Query Successfull....");
                list.add(object);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void QueryBuild(String query) {
         try {

            Class.forName(MyProduct.getDriver());

            Connection con = DriverManager.getConnection(
                    MyProduct.getConnectionDB(),MyProduct.getUser(),
                    MyProduct.getPassword()
                );

            PreparedStatement statement = con.prepareStatement(query);
            statement.executeUpdate();
            statement.close();
            con.close();
            System.out.println("Query sucssesfully execute....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
}
