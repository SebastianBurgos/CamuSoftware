package application.model;

import java.util.ArrayList;

public class Constructora {
	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	//TODO

	public Constructora() {
		super();
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
