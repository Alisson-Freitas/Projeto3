package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







import dao.ClasseDAO;
import model.Sensor;
import conexaojdbc.SingleConnection;


public class Banco {

	public void initBanco() {
		Sensor sensor = new Sensor();
		ClasseDAO classeDao = new ClasseDAO();
		
		
		sensor.setId(1);
		sensor.setNome("Forno");
		sensor.setTempo(30);
		
		sensor.setId(2);
		sensor.setNome("Fogão");
		sensor.setTempo(20);
		
		sensor.setId(3);
		sensor.setNome("Lampada");
		sensor.setTempo(10);
		
		
		
		classeDao.salvar(sensor);
	}
	
	public void initBuscar() {
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Sensor sensor = classeDao.buscar(1L);
			
			System.out.println(sensor.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public void initAtualizar () {
		
		try {
			ClasseDAO classeDao = new ClasseDAO();
			Sensor sensor = classeDao.buscar(5L);
			
			sensor.setNome("Microondas");
			
			classeDao.atualizar(sensor);
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}
	
public void initDeletar() {
	try {
		ClasseDAO classeDao = new ClasseDAO();
		classeDao.deletar(2L);
				
	} catch (Exception e) {
		e.printStackTrace();
	}	
}

public void initListar() {
	try {
		ClasseDAO classeDao = new ClasseDAO();
		List<Sensor> list = classeDao.listar();
		
		for(Sensor sensor : list) {
			System.out.println(sensor.toString());
			System.out.println("----------------");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
}




}
		
		
	 
		








