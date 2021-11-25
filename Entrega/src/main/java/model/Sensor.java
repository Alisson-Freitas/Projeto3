package model;

public class Sensor {

   private long id; 
   private String nome; 
   private long tempo; 


public Long getId() {
	return id;
}

 public void setId(long id) {
	 this.id =id;
 }

public String getNome() {
	return nome; 
}

public void setNome (String nome) {
	this.nome=nome; 
}

public Long getTempo() {
	return tempo; 
}

public void setTempo(long tempo) {
	this.tempo= tempo;
}

    @Override
    public String toString() {
    	return "Sensor(id=" +id + ", nome=" + nome + ", tempo=" + tempo+ ")"; 
    	
    }
    


}
