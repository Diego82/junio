package bbdd;

import java.util.List;

public class TestBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDAOImp uImp = new UsuarioDAOImp();
		List<UsuarioDTO> lista = uImp.getUsuarios();
		System.out.println(lista.toString());
		Conexion.desconectar();

	}

}