package gui;

import bbdd.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MiTablaModel extends AbstractTableModel{
	
	private List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
	private String[] cabecera = {"Establecimiento","Actividad","Direccion","Telefono"};
	
	
	public MiTablaModel(List<UsuarioDTO> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cabecera.length;
	}

	public String getColumnName(int col) {
		return cabecera[col];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		UsuarioDTO p = lista.get(rowIndex);
		if (columnIndex==0) return p.getEstablecimiento();
		else if (columnIndex==1) return p.getActividad();
		else if (columnIndex==2) return p.getDireccion();
		else if (columnIndex==3) return p.getTelefono();
		else return "";
	}
	

}