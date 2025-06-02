package com.vista;

import com.modelo.batalla.Batalla;
import com.modelo.personajes.bestias.Bestias;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.bestias.Trasgos;
import com.modelo.personajes.heroes.Elfo;
import com.modelo.personajes.heroes.Heroes;
import com.modelo.personajes.heroes.Hobbits;
import com.modelo.personajes.heroes.Humanos;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal de la interfaz grafica del juego "El Señor de los Anillos"
 * con Swing. Esta clase representa una ventana Swing con tres secciones:
 * 1.Formulario para añadir heroes y bestias (con validación de entrada).
 * 2.Listas visuales para mostrar y eliminar personajes agregados. 3.Zona
 * inferior que contiene un boton para iniciar la batalla y un area de texto
 * para mostrar los resultados.
 * 
 * La logica de combate esta delegada a la clase
 * {@link com.modelo.batalla.Batalla}, y la salida de los resultados se maneja
 * mediante {@link com.vista.SalidaSwing}.
 * 
 * @author Ana Avalos
 */
public class BatallaSwingVista extends JFrame {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<String> modeloHeroes;
	private DefaultListModel<String> modeloBestias;

	private List<Heroes> listaHeroesReales = new ArrayList<>();
	private List<Bestias> listaBestiasReales = new ArrayList<>();

	private JList<String> listaHeroes;
	private JList<String> listaBestias;
	private JButton btnLuchar;
	private JTextArea areaResultados;

	// Componentes para héroes
	private JTextField nombreHeroe;
	private JTextField vidaHeroe;
	private JTextField armaduraHeroe;
	private JComboBox<String> tipoHeroe;
	private JButton btnAgregarHeroe;

	// Componentes para bestias
	private JTextField nombreBestia;
	private JTextField vidaBestia;
	private JTextField armaduraBestia;
	private JComboBox<String> tipoBestia;
	private JButton btnAgregarBestia;

	public BatallaSwingVista() {
		setTitle("Batalla - El Señor de los Anillos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Panel principal del formulario
		JPanel formularioPanel = new JPanel(new GridLayout(2, 1));

		formularioPanel.add(crearPanelHeroe());
		formularioPanel.add(crearPanelBestia());

		add(formularioPanel, BorderLayout.NORTH);
		add(crearPanelListas(), BorderLayout.CENTER);
		add(crearPanelResultado(), BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Crea el panel del formulario para agregar heroes al ejercito.
	 *
	 * Incluye campos para el nombre, tipo (desplegable), vida y armadura. Al pulsar
	 * el boton, valida los datos e instancia el heroe correspondiente.
	 * 
	 * @return JPanel con los componentes para agregar heroes.
	 */
	private JPanel crearPanelHeroe() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createTitledBorder("Añadir Héroe"));

		nombreHeroe = new JTextField(10);
		vidaHeroe = new JTextField(5);
		armaduraHeroe = new JTextField(5);
		tipoHeroe = new JComboBox<>(new String[] { "Elfo", "Humano", "Hobbit" });

		btnAgregarHeroe = new JButton("Añadir Héroe");

		panel.add(new JLabel("Nombre:"));
		panel.add(nombreHeroe);
		panel.add(new JLabel("Tipo:"));
		panel.add(tipoHeroe);
		panel.add(new JLabel("Vida:"));
		panel.add(vidaHeroe);
		panel.add(new JLabel("Armadura:"));
		panel.add(armaduraHeroe);
		panel.add(btnAgregarHeroe);

		btnAgregarHeroe.addActionListener(e -> {
			String nombre = nombreHeroe.getText().trim();
			String vidaTexto = vidaHeroe.getText().trim();
			String armaduraTexto = armaduraHeroe.getText().trim();
			String tipo = (String) tipoHeroe.getSelectedItem();

			if (nombre.isEmpty() || vidaTexto.isEmpty() || armaduraTexto.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos del héroe.",
						"Campos incompletos", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int vida, armadura;
			try {
				vida = Integer.parseInt(vidaTexto);
				armadura = Integer.parseInt(armaduraTexto);

				if (vida <= 0 || armadura < 0) {
					JOptionPane.showMessageDialog(this,
							"La vida debe ser mayor a 0 y la armadura no puede ser negativa.", "Valores inválidos",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Vida y armadura deben ser números enteros válidos.",
						"Error de formato", JOptionPane.ERROR_MESSAGE);
				return;
			}

			Heroes nuevoHeroe = switch (tipo) {
			case "Humano" -> new Humanos(nombre, vida, armadura);
			case "Elfo" -> new Elfo(nombre, vida, armadura);
			case "Hobbit" -> new Hobbits(nombre, vida, armadura);
			default -> null;
			};

			if (nuevoHeroe != null) {
				listaHeroesReales.add(nuevoHeroe);
				modeloHeroes.addElement(nombre + " (" + tipo + ") - Vida: " + vida + ", Armadura: " + armadura);
			}

			nombreHeroe.setText("");
			vidaHeroe.setText("");
			armaduraHeroe.setText("");
		});

		return panel;
	}

	/**
	 * Crea el panel del formulario para agregar bestias al ejercito. Incluye campos
	 * para el nombre, tipo (desplegable), vida y armadura. Valida la entrada y
	 * añade la bestia a la lista y vista si es valida.
	 * 
	 * @return JPanel con los componentes para agregar bestias.
	 */
	private JPanel crearPanelBestia() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createTitledBorder("Añadir Bestia"));

		nombreBestia = new JTextField(10);
		vidaBestia = new JTextField(5);
		armaduraBestia = new JTextField(5);
		tipoBestia = new JComboBox<>(new String[] { "Orco", "Trasgo" });

		btnAgregarBestia = new JButton("Añadir Bestia");

		panel.add(new JLabel("Nombre:"));
		panel.add(nombreBestia);
		panel.add(new JLabel("Tipo:"));
		panel.add(tipoBestia);
		panel.add(new JLabel("Vida:"));
		panel.add(vidaBestia);
		panel.add(new JLabel("Armadura:"));
		panel.add(armaduraBestia);
		panel.add(btnAgregarBestia);

		btnAgregarBestia.addActionListener(e -> {
			String nombre = nombreBestia.getText().trim();
			String vidaTexto = vidaBestia.getText().trim();
			String armaduraTexto = armaduraBestia.getText().trim();
			String tipo = (String) tipoBestia.getSelectedItem();

			if (nombre.isEmpty() || vidaTexto.isEmpty() || armaduraTexto.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos de la bestia.",
						"Campos incompletos", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int vida, armadura;
			try {
				vida = Integer.parseInt(vidaTexto);
				armadura = Integer.parseInt(armaduraTexto);

				if (vida <= 0 || armadura < 0) {
					JOptionPane.showMessageDialog(this,
							"La vida debe ser mayor a 0 y la armadura no puede ser negativa.", "Valores inválidos",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Vida y armadura deben ser números enteros válidos.",
						"Error de formato", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Bestias nuevaBestia = switch (tipo) {
			case "Orco" -> new Orco(nombre, vida, armadura);
			case "Trasgo" -> new Trasgos(nombre, vida, armadura);
			default -> null;
			};

			if (nuevaBestia != null) {
				listaBestiasReales.add(nuevaBestia);
				modeloBestias.addElement(nombre + " (" + tipo + ") - Vida: " + vida + ", Armadura: " + armadura);
			}

			nombreBestia.setText("");
			vidaBestia.setText("");
			armaduraBestia.setText("");
		});

		return panel;
	}

	/**
	 * Crea el panel central que contiene dos listas: una para heroes y otra para
	 * bestias. Permite eliminar personajes seleccionados de ambas listas..
	 * 
	 * @return JPanel que organiza las listas de personajes y los botones de
	 *         eliminacion.
	 */
	private JPanel crearPanelListas() {
		JPanel panel = new JPanel(new GridLayout(1, 2));

		// Panel Héroes
		JPanel panelHeroes = new JPanel(new BorderLayout());
		modeloHeroes = new DefaultListModel<>();
		listaHeroes = new JList<>(modeloHeroes);
		JScrollPane scrollHeroes = new JScrollPane(listaHeroes);
		scrollHeroes.setBorder(BorderFactory.createTitledBorder("Ejército de Héroes"));
		panelHeroes.add(scrollHeroes, BorderLayout.CENTER);

		JButton btnEliminarHeroe = new JButton("Eliminar Héroe");
		btnEliminarHeroe.addActionListener(e -> {
			int index = listaHeroes.getSelectedIndex();
			if (index != -1) {
				modeloHeroes.remove(index);
				listaHeroesReales.remove(index);
			}
		});

		panelHeroes.add(btnEliminarHeroe, BorderLayout.SOUTH);

		// Panel Bestias
		JPanel panelBestias = new JPanel(new BorderLayout());
		modeloBestias = new DefaultListModel<>();
		listaBestias = new JList<>(modeloBestias);
		JScrollPane scrollBestias = new JScrollPane(listaBestias);
		scrollBestias.setBorder(BorderFactory.createTitledBorder("Ejército de Bestias"));
		panelBestias.add(scrollBestias, BorderLayout.CENTER);

		JButton btnEliminarBestia = new JButton("Eliminar Bestia");
		btnEliminarBestia.addActionListener(e -> {
			int index = listaBestias.getSelectedIndex();
			if (index != -1) {
				modeloBestias.remove(index);
				listaBestiasReales.remove(index);
			}
		});

		panelBestias.add(btnEliminarBestia, BorderLayout.SOUTH);

		// Agregar ambos al panel principal
		panel.add(panelHeroes);
		panel.add(panelBestias);

		return panel;
	}

	/**
	 * Crea el panel inferior con el boton "Luchar" y el area de texto para mostrar
	 * resultados.
	 * 
	 * @return JPanel con boton de accion y salida visual de la simulacion de
	 *         batalla.
	 */
	private JPanel crearPanelResultado() {
		JPanel panel = new JPanel(new BorderLayout());

		btnLuchar = new JButton("Luchar");

		areaResultados = new JTextArea(12, 60);
		areaResultados.setEditable(false);
		JScrollPane scrollArea = new JScrollPane(areaResultados);
		scrollArea.setBorder(BorderFactory.createTitledBorder("Resultado de la batalla"));

		btnLuchar.addActionListener(e -> ejecutarSimulacionBatalla());

		panel.add(btnLuchar, BorderLayout.NORTH);
		panel.add(scrollArea, BorderLayout.CENTER);

		return panel;
	}

	/**
	 * Lanza la simulacion de la batalla utilizando los personajes agregados por el
	 * usuario.
	 * 
	 * Verifica que haya al menos un heroe y una bestia. Si es asi, crea una
	 * instancia de {@link com.modelo.batalla.Batalla} y ejecuta el combate,
	 * redirigiendo la salida a la interfaz grafica.
	 */

	private void ejecutarSimulacionBatalla() {

		areaResultados.setText(""); // Limpiar

		if (listaHeroesReales.isEmpty() || listaBestiasReales.isEmpty()) {
			areaResultados.setText("⚠️ Debes agregar al menos un heroe y una bestia para luchar.");
			return;
		}

		// Redirigir salida a JTextArea
		SalidaSwing salidaSwing = new SalidaSwing(areaResultados);
		Batalla batalla = new Batalla(listaHeroesReales, listaBestiasReales, salidaSwing);
		batalla.iniciar();

	}

}
