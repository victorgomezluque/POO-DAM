package gatos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="caixa")
public class Caixa {
	
	@Id
	@Column(name = "caixa_id")
   private int id;
	
	@Column(name = "marca")
   private String marca;
	
	@Column(name = "trencada")
   private boolean trencada; 
	
	
	//relacion manytoone. Aqui declaramos la llave foranea que basicamente es un objeto del tipo referenciado
	//en nuestro caso, de clase gato. Referenciamos su llave primaria pero ponemos el objeto entero.
	@ManyToOne
	@JoinColumn(name="gato_id", nullable=false)
	private GatoOTM gatoOTM;

	
	
	
	
	public Caixa() {
		super();
	}

	public Caixa(int id, String marca, boolean trencada) {
		super();
		this.id = id;
		this.marca = marca;
		this.trencada = trencada;
		this.gatoOTM = gatoOTM;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isTrencada() {
		return trencada;
	}

	public void setTrencada(boolean trencada) {
		this.trencada = trencada;
	}

	public GatoOTM getGatootm() {
		return gatoOTM;
	}

	public void setGatootm(GatoOTM gatootm) {
		this.gatoOTM = gatootm;
	}
	
	

}
