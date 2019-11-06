package projecteFitxersXML;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Classe implements Serializable{
	private Professor professor;
	private ArrayList<Alumne> alumnes =new ArrayList<>();
	private JSONObject aula = new JSONObject();
	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classe(Professor professor, ArrayList<Alumne> alumnes, JSONObject aula) {
		super();
		this.professor = professor;
		this.alumnes = alumnes;
		this.aula = aula;
	}
	
	@Override
	public String toString() {
		return "Classe [professor=" + professor + ", alumnes=" + alumnes + ", aula=" + aula + "]";
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public ArrayList<Alumne> getAlumnes() {
		return alumnes;
	}
	public void setAlumnes(ArrayList<Alumne> alumnes) {
		this.alumnes = alumnes;
	}
	public JSONObject getAula() {
		return aula;
	}
	public void setAula(JSONObject aula) {
		this.aula = aula;
	}
	
}
