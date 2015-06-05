/**
 * @author Diego Jesús Torres Peinado
 * @version 1.0
 * 
 */

package bbdd;

import java.util.List;

public interface UsuarioDAO {
	List<UsuarioDTO> getComercios();
	void actualizarUsuario(UsuarioDTO u);
	UsuarioDTO getUsuarioDTO(String id);
	List<UsuarioDTO> getUsuario();
}