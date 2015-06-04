package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO {
	//obtenemos la conexión como un atributo de la clase
	Connection conexion = Conexion.getConexion();
	@Override
	public List<UsuarioDTO> getUsuarios() {
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		UsuarioDTO usuario =null;
		//sentencia sql a ejecutar
		String sql = "select * from datosComercio";
		try {
			Statement s =  conexion.createStatement();
			ResultSet r = s.executeQuery(sql);
			while(r.next()){
				String establecimiento = r.getString("establecimiento");
				String actividad = r.getString("actividad");
				String direccion = r.getString("direccion");
				int telefono = r.getInt("telefono");
				usuario = new UsuarioDTO(establecimiento, actividad, direccion, telefono);
				lista.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	@Override
	public void addUsuario(UsuarioDTO u) {
		//sentencia sql a ejecutar
				String sql = "insert into datosComercio (establecimiento, actividad, direccion, telefono) values (? ,?, ?, ?)";
				try {
					PreparedStatement s = conexion.prepareStatement(sql);
					s.setString(1, u.getEstablecimiento());
					s.setString(2, u.getActividad());
					s.setString(3, u.getDireccion());
					s.setInt(4, u.getTelefono());
					s.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	/*
	@Override
	public void eliminarUsuario(UsuarioDTO u) {
		String sql = "delete from USUARIO where dni= ?";
		try {
			PreparedStatement s = conexion.prepareStatement(sql);
			s.setString(1, u.getDni());
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarUsuario(UsuarioDTO u) {
		// TODO Auto-generated method stub
		String sql = "UPDATE USUARIO set nombre=? where dni=?";
		try {
			PreparedStatement s = conexion.prepareStatement(sql);
			s.setString(1, u.getNombre());
			s.setString(2, u.getDni());
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}*/

	@Override
	public UsuarioDTO getUsuarioDTO(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}