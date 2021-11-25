package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import banco.Banco;
import conexaojdbc.SingleConnection;
import model.Sensor;

public class ClasseDAO {

  private Connection connection; 

 public ClasseDAO() {
	 connection= SingleConnection.getConnection();
 }

  public void salvar(Sensor sensor) {
	  try {
		  String sql = "Insert into sensorjdbc(id, nome, tempo) values(?,?,?)"; 
		  PreparedStatement statement = connection.prepareStatement(sql); 
		  
		  statement.setLong(1, sensor.getId());
		  statement.setString(2,sensor.getNome()); 
		  statement.setLong(3,sensor.getTempo());
		  
	     
	      statement.execute(); 
	      connection.commit();
	  
	  }catch (Exception e) {
		  try {
			  connection.rollback();
			  
		  }catch (SQLException e1) {
			  
			  e1.printStackTrace();
			  
		  }
	        e.printStackTrace(); 
	  }
  }
    
   public List<Sensor> listar() throws Exception {
	    List<Sensor> list = new ArrayList<Sensor>();
	    
	    String sql = "select * from sensorjdbc"; 
	    
	    PreparedStatement statement = null;
		ResultSet resultado = statement.executeQuery(); 
	    
	    while (resultado.next()) {
	    	Sensor sensor = new Sensor();
	    	sensor.setId(resultado.getLong("id"));
	    	sensor.setNome(resultado.getString("nome"));
	    	sensor.setTempo(resultado.getLong("tempo"));
	    	
	    	list.add(sensor); 
	    }
	return list;    
  

   }


   public Sensor buscar(Long id) throws Exception {
		Sensor sensor = new Sensor();

		String sql = "select * from sensorjdbc where id =" + id;

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {
			sensor.setId(resultado.getLong("id"));
			sensor.setNome(resultado.getString("nome"));
			sensor.setTempo(resultado.getLong("tempo"));

		}

		return sensor;

   }


   public void atualizar(Sensor sensor) {

		try {
			String sql = "update sensorjdbc set nome = ? where id = " + sensor.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, sensor.getNome());
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

   public void deletar(Long id) {
		try {
			String sql = "delete from sensorjdbc where id = "+id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
	}



}
