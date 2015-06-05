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
	public void actualizarUsuario(UsuarioDTO u) {
		// TODO Auto-generated method stub
		String sql = "UPDATE datosComercio set nombre=? where id=?";
		try {
			PreparedStatement s = conexion.prepareStatement(sql);
			s.setString(1, u.getEstablecimiento());
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	@Override
	public UsuarioDTO getUsuarioDTO(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioDTO> getComercios() {
		// TODO Auto-generated method stub
		return null;
	}

}