public abstract class SQLDATA implements SQLModule{
    protected String host;
    protected String dbname;
    protected String password;
    protected String user;

    public String getDriver(){
        return "com.mysql.jdbc.Driver";
    }

    public String getConnectionDB(){
        return "jdbc:mysql://"+this.host+"/"+this.dbname+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    public abstract String getUser();
    public abstract String getPassword();
}
