import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empresas")
public class Empresas {

	ArrayList<Empresa> empresa;

	public Empresas(ArrayList<Empresa> empresa) {
		super();
		this.empresa = empresa;
	}
	public Empresas() {
		
	}

	public ArrayList<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(ArrayList<Empresa> empresa) {
		this.empresa = empresa;
	}
}
