package usuario;

import java.io.Serializable;

import sistema.Sistema;

/**
* Contiene los atributos y métodos de la clase Usuario
*
* @author Miguel García Moya y Lucía Colmenarejo Pérez
*
*/

public abstract class Usuario implements Serializable{
	private String usuario;
	private String contraseña;
	
	public Usuario(String usuario, String contraseña) {	
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	/**
	*Devuelve el usuario.
	*
	*Este método devuelve la cadena del ususario sobre el que se aplica.
	*
	*@return la cadena del usuario. 
	*/
	
	public String getUsuario() {
		return this.usuario;
	}
	
	/**
	 * Modifica el usuario.
	 * 
	 * Este método modifica la cadena del usuario sobre el que se aplica.
	 * 
	 * @param usuario nuevo que queremos que se guarde.
	 */

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Devuelve la contraseña.
	 * 
	 * Este método devuelve la contraseña del usuario sobre el que se aplica.
	 * 
	 * @return La contraseña del usuario.
	 */

	public String getContraseña() {
		return this.contraseña;
	}

	/**
	 * Modifica la contraseña
	 * 
	 * Este método modifica la contraseña del usuario sobre el que se aplica.
	 * 
	 * @param contraseña nueva que queremos que se guarde.
	 */
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	/**
	 * Permite hacer login de nuestra sistema.
	 * 
	 * Este método permite al usuario acceder al sistema y convertirse en el usuario actual.
	 * 
	 * @param usuario La cadena del usuario que quiere acceder al sistema.
	 * @param contraseña La contraseña del usurio que quiere acceder al sistema.
	 */
	
	public void hacerLogin(String usuario, String contraseña){
		if(usuario == this.usuario && contraseña == this.contraseña) {
			Sistema.getSistema().setUserActual(this);
		}
	}
	
	/**
	 *Permite hacer logout de nuestro sistema. 
	 *
	 *Este método permite al usuario, siempre que sea el actual, a salir del sistema.
	 *
	 */
	
	public void hacerLogout(){
		if(this == Sistema.getSistema().getUserActual()) {
			Sistema.getSistema().setUserActual(null);
		}
	}
	
}
