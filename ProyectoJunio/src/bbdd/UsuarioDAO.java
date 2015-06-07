/**
 * @author Diego Jesús Torres Peinado
 * @version 1.0
 * 
 */

package bbdd;

import java.util.List;

public interface UsuarioDAO {
	void actualizarUsuario(List<UsuarioDTO> listado, int fila, int columna);
	List<UsuarioDTO> getUsuario();
}