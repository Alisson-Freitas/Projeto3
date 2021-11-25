package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
public class SingleConnection {

  private static String url= "jdbc:postgresql://localhost5434/Entrega" ; 
  private static String password = "17300"; 
  private static String user = "postgres"; 
  
  private static Connection connection = null; 

  public SingleConnection() {
	  conectar();
	  
  }
  
  static {
	  conectar();
  }
  
  
private static void conectar () {
      try {
    	   if (connection== null) {
    		   Class.forName("org.postgresql.Driver");
    		   connection = DriverManager.getConnection(url, user, password);
               connection.setAutoCommit(false);    	   
    	       System.out.println("Conectado com sucesso ao banco de dados:");
    	   }
      
      
      }catch (Exception e) {
    	  e.printStackTrace();
      }
  }




public static Connection getConnection() {
	return connection;
}


}
