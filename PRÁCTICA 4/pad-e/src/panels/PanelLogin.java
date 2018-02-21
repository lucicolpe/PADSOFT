package panels;

import sistema.Sistema;
import usuario.Estudiante;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelLogin extends JPanel{

	public PanelLogin(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JLabel etiqueta1 = new JLabel("Usuario:");
		JLabel etiqueta2 = new JLabel("Contraseña:");
		
		final JTextField campousuario = new JTextField(20);
		final JPasswordField campocontraseña = new JPasswordField(20);
		
		JButton boton = new JButton ("Login");
		
		boton.addActionListener(
				new ActionListener() {
					public void	actionPerformed(ActionEvent e) {
						String user = campousuario.getText();
						if (user.equals("admin")){
							Sistema.getSistema().getP().hacerLogin("admin", String.valueOf(campocontraseña.getPassword()));						
						}
						else{
							for (Estudiante estudiante: Sistema.getSistema().getEstudiantes()){
								if (estudiante.getUsuario().equals(user)){
									estudiante.hacerLogin(user, String.valueOf(campocontraseña.getPassword()));
								}
							}
						}
					}
					
				}
		);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta1, 50, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, etiqueta1, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, etiqueta2, 0, SpringLayout.EAST, etiqueta1);
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 5, SpringLayout.SOUTH, etiqueta1);
		layout.putConstraint(SpringLayout.WEST, campousuario, 5, SpringLayout.EAST, etiqueta1);
		layout.putConstraint(SpringLayout.NORTH, campousuario, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, campocontraseña, 5, SpringLayout.EAST, etiqueta2);
		layout.putConstraint(SpringLayout.NORTH, campocontraseña, 5, SpringLayout.SOUTH, campousuario);
		
		layout.putConstraint(SpringLayout.WEST, boton, 125, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, boton, 30, SpringLayout.SOUTH, campocontraseña);

		
		this.add(etiqueta1);
		this.add(etiqueta2);
		this.add(campousuario);
		this.add(campocontraseña);
		this.add(boton);
		this.setPreferredSize(new Dimension(350,250));
		this.setVisible(true);
		

		
	}
	
	
}

