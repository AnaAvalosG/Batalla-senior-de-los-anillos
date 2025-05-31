package com.vista;

import com.controlador.JuegoElSenorDeLosAnillos;
import com.modelo.batalla.Batalla;
import com.modelo.personajes.bestias.Bestias;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.bestias.Trasgos;
import com.modelo.personajes.heroes.Elfo;
import com.modelo.personajes.heroes.Heroes;
import com.modelo.personajes.heroes.Hobbits;
import com.modelo.personajes.heroes.Humanos;
import com.utilidades.SalidaBatalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

public class BatallaSwingVista extends JFrame {
	
	
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



        // Por ahora solo mostramos la parte superior
        setVisible(true);
    }

    private JPanel crearPanelHeroe() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Añadir Héroe"));

        nombreHeroe = new JTextField(10);
        vidaHeroe = new JTextField(5);
        armaduraHeroe = new JTextField(5);
        tipoHeroe = new JComboBox<>(new String[]{"Elfo", "Humano", "Hobbit"});

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
            String nombre = nombreHeroe.getText();
            String tipo = (String) tipoHeroe.getSelectedItem();
            int vida = Integer.parseInt(vidaHeroe.getText());
            int armadura = Integer.parseInt(armaduraHeroe.getText());

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

    private JPanel crearPanelBestia() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Añadir Bestia"));

        nombreBestia = new JTextField(10);
        vidaBestia = new JTextField(5);
        armaduraBestia = new JTextField(5);
        tipoBestia = new JComboBox<>(new String[]{"Orco", "Trasgo"});

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
            String nombre = nombreBestia.getText();
            String tipo = (String) tipoBestia.getSelectedItem();
            int vida = Integer.parseInt(vidaBestia.getText());
            int armadura = Integer.parseInt(armaduraBestia.getText());

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
    private void ejecutarSimulacionBatalla() {
    	System.out.println("▶️ Luchando con " + listaHeroesReales.size() + " héroes y " + listaBestiasReales.size() + " bestias.");

        areaResultados.setText(""); // Limpiar

        if (listaHeroesReales.isEmpty() || listaBestiasReales.isEmpty()) {
            areaResultados.setText("⚠️ Debes agregar al menos un héroe y una bestia para luchar.\n");
            return;
        }

        // Redirigir salida a JTextArea
        SalidaSwing salidaSwing = new SalidaSwing(areaResultados);
        Batalla batalla = new Batalla(listaHeroesReales, listaBestiasReales, salidaSwing);
        batalla.iniciar();
        System.out.println("Héroes cargados: " + listaHeroesReales.size());
        System.out.println("Bestias cargadas: " + listaBestiasReales.size());

       
    }

}
