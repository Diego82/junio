/**
 * @author Diego Jesús Torres Peinado
 * @version 1.0
 * 
 */
package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioDAOImp implements UsuarioDAO {
	//obtenemos la conexión como un atributo de la clase
	Connection conexion = Conexion.getConexion();
	@Override
	public List<UsuarioDTO> getUsuario() {
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		UsuarioDTO usuario =null;
		//sentencia sql a ejecutar
		String sql = "select * from datosComercio";
		try {
			Statement s =  conexion.createStatement();
			ResultSet r = s.executeQuery(sql);
			while(r.next()){
				int id = r.getInt("id");
				String establecimiento = r.getString("establecimiento");
				String actividad = r.getString("actividad");
				String direccion = r.getString("direccion");
				int telefono = r.getInt("telefono");
				usuario = new UsuarioDTO(id, establecimiento, actividad, direccion, telefono);
				lista.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public void actualizarUsuario(List<UsuarioDTO> listado, int fila, int columna) {
		// TODO Auto-generated method stub
		switch (columna) {
		case 1:
			try {
				String sql = "UPDATE comercio set establecimiento=? where id=?";
				PreparedStatement s = conexion.prepareStatement(sql);
				s.setString(1,listado.get(fila).getEstablecimiento());
				s.setInt(2, listado.get(fila).getId());
				s.executeUpdate();
				JOptionPane.showMessageDialog(null, "El campo establecimiento con id: "+listado.get(fila).getId()+" ha sido actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				String sql = "UPDATE comercio set actividad=? where id=?";
				PreparedStatement s = conexion.prepareStatement(sql);
				s.setString(1,listado.get(fila).getActividad());
				s.setInt(2, listado.get(fila).getId());
				s.executeUpdate();
				JOptionPane.showMessageDialog(null, "El campo actividad con id: "+listado.get(fila).getId()+" ha sido actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				String sql = "UPDATE comercio set direccion=? where id=?";
				PreparedStatement s = conexion.prepareStatement(sql);
				s.setString(1,listado.get(fila).getDireccion());
				s.setInt(2, listado.get(fila).getId());
				s.executeUpdate();
				JOptionPane.showMessageDialog(null, "El campo direccion con id: "+listado.get(fila).getId()+" ha sido actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				String sql = "UPDATE comercio set telefono=? where id=?";
				PreparedStatement s = conexion.prepareStatement(sql);
				s.setInt(1,listado.get(fila).getTelefono());
				s.setInt(2, listado.get(fila).getId());
				s.executeUpdate();
				JOptionPane.showMessageDialog(null, "El campo telefono con id: "+listado.get(fila).getId()+" ha sido actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}