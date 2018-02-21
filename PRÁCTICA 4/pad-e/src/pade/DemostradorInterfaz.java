package pade;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.PanelLogin;

public class DemostradorInterfaz {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Login");
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		JPanel panel = new PanelLogin();
		contenedor.add(panel);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(350, 200);
		ventana.setVisible(true);
	}
}
