package gui;

import bbdd.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Formulario {

	private JFrame frame;
	private JTable tabla;
	private ArrayList<UsuarioDTO> listado;
	private ArrayList<UsuarioDTO> listadoTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario window = new Formulario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAnterior = new JButton("Anterior");
		panelSur.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		panelSur.add(btnSiguiente);
		
		JPanel panelCentral = new JPanel();
		frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCargaBBDD = new JMenuItem("Cargar base de datos");
		mntmCargaBBDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UsuarioDAOImp uImp = new UsuarioDAOImp();
				listado = (ArrayList<UsuarioDTO>) uImp.getUsuarios();
				
				listadoTabla = (ArrayList<UsuarioDTO>) cargarDatosTabla(listado, 0, 10);
				System.out.println("lista inicial.................");
				System.out.println(listado);
				System.out.println("longitud de la lista"+listado.size());
				System.out.println("lista final...................");
				System.out.println(listadoTabla);
				System.out.println("longitud de la lista"+listadoTabla.size());
												
				MiTablaModel modelo = new MiTablaModel(listado);
				
				tabla = new JTable(modelo);
				panelCentral.add(tabla);
			}
		});
		mnArchivo.add(mntmCargaBBDD);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar base de datos");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
		mnArchivo.add(mntmSalir);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Creado por Diego Jesus Torres Peinado", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAyuda.add(mntmAcercaDe);
	}
	public List<UsuarioDTO> cargarDatosTabla(ArrayList<UsuarioDTO> listado, int inicio, int fin){
		ArrayList<UsuarioDTO> listaAux = new ArrayList<UsuarioDTO>();
		for(int i = inicio ; i < fin ; i++){
			listaAux.add(listado.get(i));
		}
		return listaAux;
	}
	
	
	
	
	
	
	
	
	
	
}
