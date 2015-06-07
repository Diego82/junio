/**
 * @author Diego Jesús Torres Peinado
 * @version 1.0
 * 
 */

package bbdd;

public class UsuarioDTO {
	private int id;
	private String establecimiento;
	private String actividad;
	private String direccion;
	private int telefono;
	/**
	 * @param establecimiento
	 * @param actividad
	 * @param direccion
	 * @param telefono
	 */
	public UsuarioDTO(int id, String establecimiento, String actividad,
			String direccion, int telefono) {
		this.id = id;
		this.establecimiento = establecimiento;
		this.actividad = actividad;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	/**
	 * @return the establecimiento
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param establecimiento the establecimiento to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the establecimiento
	 */
	public String getEstablecimiento() {
		return establecimiento;
	}
	/**
	 * @param establecimiento the establecimiento to set
	 */
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}
	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsuarioDTO id=" + id + ", establecimiento=" + establecimiento
				+ ", actividad=" + actividad + ", direccion=" + direccion
				+ ", telefono=" + telefono;
	}
	
}