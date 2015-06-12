package gui;

import bbdd.*;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class MiTablaModel extends AbstractTableModel {

	private List<UsuarioDTO> listadoAux;
	private String[] cabecera = {"Id", "Establecimiento", "Actividad", "Direccion", "Telefono"};
	private int numerodefilas=10;
	private int indice=0;
	private UsuarioDAOImp usuarioDAO;
	
	
	public MiTablaModel(List<UsuarioDTO> lista, UsuarioDAOImp dao){
		this.listadoAux = lista;
		this.usuarioDAO = dao;
	}
	
	public void incrementa(){
		if (indice+numerodefilas<listadoAux.size()) {
			indice+=numerodefilas;
			fireTableChanged(null);
		}
	}
	
	public void decrementa(){
		if (indice-numerodefilas>=0){
			indice-=numerodefilas;
			fireTableChanged(null);
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		int resto = listadoAux.size()-indice;
		if (resto>numerodefilas) {
			return numerodefilas;
		}
		else
			return resto;
	}
	
	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return cabecera[col];
	}
	
	@Override
	public void setValueAt(Object usuario, int fila, int columna) {
		// TODO Auto-generated method stub
		UsuarioDTO aux = listadoAux.get(fila+indice);
		String celda = (String) usuario;
		
		switch (columna) {
		case 0:
			JOptionPane.showMessageDialog(null, "Esta columna no es modificable", "Error", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 1:
			aux.setEstablecimiento(celda);
			usuarioDAO.actualizarUsuario(listadoAux, (fila+indice), columna);
			break;
		case 2:
			aux.setActividad(celda);
			usuarioDAO.actualizarUsuario(listadoAux, (fila+indice), columna);
			break;
		case 3:
			aux.setDireccion(celda);
			usuarioDAO.actualizarUsuario(listadoAux, (fila+indice), columna);
			break;
		case 4:
			try {
				if(celda.matches(".*[0-9].*") && Integer.parseInt(celda)>0){
					aux.setTelefono(Integer.parseInt(celda));
					usuarioDAO.actualizarUsuario(listadoAux, (fila+indice), columna);
					break;	
				}
				
			} catch (Exception ex){
				ex.printStackTrace();
			}	
		default:
		}
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		// TODO Auto-generated method stub
		UsuarioDTO aux = listadoAux.get(fila+indice);
		switch (columna) {
		case 0:
			return aux.getId();
		case 1:
			return aux.getEstablecimiento();
		case 2:
			return aux.getActividad();
		case 3:
			return aux.getDireccion();
		case 4:
			return aux.getTelefono();
		default:
			return "";
		}
	}
	
	@Override
	public boolean isCellEditable(int fila, int columna) {
		// TODO Auto-generated method stub
		return true;
	}
	
}