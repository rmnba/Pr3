package vista;

import javax.swing.*;
import org.math.plot.Plot2DPanel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JRadioButton;

import java.awt.Font;

public class Ventana {

	private JFrame frmProgramacinEvolutiva;
	private JPanel panelTorneo;
	private JLabel labelTorneo;
	private JTabbedPane grafPanel;
	private int numberofgrafs=0;
	private Button lanzaButton;
	private Button relanzaButton;
	private Button eliminaButton;
	private JRadioButton elitismoRadio;
	private JRadioButton IFRadio;
	private JComboBox<String> seleccionCB;
	private JComboBox<String> mutationCB;
	private JComboBox<String> inicializacionCB;
	private JComboBox<String> bloatingCB;
	private JComboBox<String> calcTamCB;
	private JTextField poblacionTextField;
	private JTextField iteracionesTextField;
	private JTextField crucesTextField;
	private JTextField mutacionTextField;
	private JTextField semillaTextField;
	private JTextField mejorTextField;
	private JTextField entreTextField;
	private JTextField profundidadTextField;
	private JLabel lblMejorAbsoluto;
	private JLabel lblProfundidadMax;
	private JLabel calcTam;
	private JTextArea cromosomaFinal;

	
	public Ventana() {
		initialize();
		frmProgramacinEvolutiva.setVisible(true);
	}

	
	private void initialize() {
		frmProgramacinEvolutiva = new JFrame();
		frmProgramacinEvolutiva.setBackground(Color.WHITE);
		frmProgramacinEvolutiva.setTitle("Programacion evolutiva");
		frmProgramacinEvolutiva.getContentPane().setPreferredSize(new Dimension(600, 400));
		frmProgramacinEvolutiva.setBounds(100, 100, 11500, 695);
		frmProgramacinEvolutiva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1362, 640);
		panel.setPreferredSize(new Dimension(40, 40));
		panel.setMaximumSize(new Dimension(50000, 50000));

		JLabel lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setBounds(10, 99, 102, 14);

		poblacionTextField = new JTextField();
		poblacionTextField.setText("50");
		poblacionTextField.setBounds(122, 96, 189, 20);
		poblacionTextField.setColumns(10);

		JLabel lblIteraciones = new JLabel("Iteraciones");
		lblIteraciones.setBounds(10, 190, 83, 14);

		iteracionesTextField = new JTextField();
		iteracionesTextField.setText("100");
		iteracionesTextField.setBounds(122, 187, 189, 20);
		iteracionesTextField.setColumns(10);

		JLabel lblCruces = new JLabel("% Cruces");
		lblCruces.setBounds(10, 215, 83, 14);

		crucesTextField = new JTextField();
		crucesTextField.setText("70");
		crucesTextField.setBounds(122, 212, 189, 20);
		crucesTextField.setColumns(10);

		JLabel lblMutation = new JLabel("% Mutacion");
		lblMutation.setBounds(10, 271, 83, 14);

		mutacionTextField = new JTextField();
		mutacionTextField.setText("10");
		mutacionTextField.setBounds(122, 268, 189, 20);
		mutacionTextField.setColumns(10);

		JLabel lblSemilla = new JLabel("Semilla");
		lblSemilla.setBounds(10, 296, 68, 14);

		semillaTextField = new JTextField();
		semillaTextField.setText("0");
		semillaTextField.setBounds(122, 293, 189, 20);
		semillaTextField.setColumns(10);

		seleccionCB = new JComboBox<String>();
		seleccionCB.setBounds(122, 318, 189, 20);
		seleccionCB.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Torneo Probabilistico", "Torneo Deterministico",
				"Universal Estocastico", "Ruleta" }));
		seleccionCB.setSelectedIndex(3);

		JLabel lblSeleccion = new JLabel("Seleccion ");
		lblSeleccion.setBounds(11, 321, 82, 14);

		labelTorneo = new JLabel("Torneo Prob.");
		labelTorneo.setOpaque(true);
		labelTorneo.setBounds(10, 340, 83, 14);

		panelTorneo = new JPanel();
		panelTorneo.setOpaque(false);
		panelTorneo.setBounds(10, 349, 301, 63);
		frmProgramacinEvolutiva.getContentPane().setLayout(null);
		panelTorneo.setLayout(null);

		JLabel lblmejor = new JLabel("%Mejor");
		lblmejor.setBounds(10, 15, 46, 14);
		panelTorneo.add(lblmejor);

		JLabel lblNewLabel = new JLabel("Entre");
		lblNewLabel.setBounds(10, 38, 70, 14);
		panelTorneo.add(lblNewLabel);

		mejorTextField = new JTextField();
		mejorTextField.setText("60.0");
		mejorTextField.setBounds(112, 12, 179, 20);
		panelTorneo.add(mejorTextField);
		mejorTextField.setColumns(10);

		entreTextField = new JTextField();
		entreTextField.setText("3");
		entreTextField.setBounds(112, 35, 179, 20);
		panelTorneo.add(entreTextField);
		entreTextField.setColumns(10);

		lanzaButton = new Button("Iniciar");
		lanzaButton.setBounds(38, 531, 273, 31);

		relanzaButton = new Button("Reiniciar");
		relanzaButton.setBounds(38, 568, 273, 34);
		relanzaButton.setVisible(false);

		eliminaButton = new Button("Eliminar");
		eliminaButton.setBounds(38, 608, 273, 32);
		panel.setLayout(null);
		panel.add(lblPoblacion);
		panel.add(poblacionTextField);
		panel.add(lblIteraciones);
		panel.add(iteracionesTextField);
		panel.add(lblCruces);
		panel.add(crucesTextField);
		panel.add(lblMutation);
		panel.add(mutacionTextField);
		panel.add(lblSemilla);
		panel.add(semillaTextField);
		panel.add(seleccionCB);
		panel.add(lblSeleccion);
		panel.add(labelTorneo);
		panel.add(panelTorneo);
		panel.add(lanzaButton);
		panel.add(relanzaButton);
		panel.add(eliminaButton);
		frmProgramacinEvolutiva.getContentPane().add(panel);

		JLabel lblElitismo = new JLabel("Elitismo");
		lblElitismo.setBounds(10, 48, 102, 14);
		panel.add(lblElitismo);

		elitismoRadio = new JRadioButton("");
		elitismoRadio.setBounds(189, 48, 38, 23);
		panel.add(elitismoRadio);

		grafPanel = new JTabbedPane(JTabbedPane.TOP);
		grafPanel.setBounds(438, 53, 886, 509);
		panel.add(grafPanel);
		
		JLabel lblMutacin = new JLabel("Mutaci\u00F3n");
		lblMutacin.setBounds(10, 240, 80, 14);
		panel.add(lblMutacin);
		
		mutationCB = new JComboBox<String>();
		mutationCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Terminal simple", "Funcional simple", "Mutacion de arbol", "Permutacion"}));
		mutationCB.setSelectedIndex(1);
		mutationCB.setBounds(122, 237, 189, 20);
		panel.add(mutationCB);
						
		
		JLabel lblInicializacin = new JLabel("Inicializaci\u00F3n");
		lblInicializacin.setBounds(10, 74, 102, 14);
		panel.add(lblInicializacin);
		
		inicializacionCB= new JComboBox<String>();
		inicializacionCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Inicializacion completa", "Inicializacion creciente", "Ramped and half"}));
		inicializacionCB.setSelectedIndex(2);
		inicializacionCB.setBounds(122, 71, 189, 20);
		panel.add(inicializacionCB);
		  
		
		JLabel lblBloating = new JLabel("Bloating");
		lblBloating.setBounds(10, 423, 83, 14);
		panel.add(lblBloating);
		
		bloatingCB = new JComboBox<String>();
		bloatingCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Metodo Tarpeian", "Penalizacion bien fundamentada"}));
		bloatingCB.setBounds(122, 420, 189, 20);
		panel.add(bloatingCB);
		
		lblProfundidadMax = new JLabel("Profundidad max");
		lblProfundidadMax.setBounds(10, 124, 102, 14);
		panel.add(lblProfundidadMax);
		
		profundidadTextField = new JTextField();
		profundidadTextField.setText("6");
		profundidadTextField.setBounds(122, 121, 190, 20);
		panel.add(profundidadTextField);
		profundidadTextField.setColumns(10);
		
		JLabel lblUsarIf = new JLabel("Usar IF");
		lblUsarIf.setBounds(10, 149, 83, 14);
		panel.add(lblUsarIf);
		
		IFRadio = new JRadioButton("");
		IFRadio.setBounds(189, 148, 109, 23);
		panel.add(IFRadio);
		
		JLabel lblMejorCromosoma = new JLabel("Salida");
		lblMejorCromosoma.setBounds(438, 559, 258, 31);
		panel.add(lblMejorCromosoma);
		
		
		cromosomaFinal = new JTextArea();
		cromosomaFinal.setBounds(438, 596, 886, 50);
		panel.add(cromosomaFinal);
		
		
		calcTam = new JLabel("Calculo tam.");
		calcTam.setBounds(10, 448, 83, 14);
		panel.add(calcTam);
		
		calcTamCB = new JComboBox<String>();
		calcTamCB.setModel(new DefaultComboBoxModel<String>(new String[] {"Profundidad", "Num. nodos"}));
		calcTamCB.setBounds(122, 445, 189, 20);
		panel.add(calcTamCB);
	}

	public void addGraphPanel(double ejeGeneracion [],double[] mediait, double[] mejorit,double[] mejorabsoluto,String best) {
		
		Plot2DPanel plot = new Plot2DPanel();
		plot.setPreferredSize(new Dimension(800,600));
		plot.setAxisLabel(0, "Generacion");
		plot.setAxisLabel(1, "Valor");
		plot.setLegendOrientation("SOUTH");
		
		plot.addLinePlot("Media Poblacion", Color.GREEN, ejeGeneracion, mediait);
		plot.addLinePlot("Mejor Generacion", Color.RED, ejeGeneracion, mejorit);
		plot.addLinePlot("Mejor Absoluto", Color.BLUE, ejeGeneracion, mejorabsoluto);
		
		
		best += "\n=========================================================================\n";
		best += "Aptitud MEJOR : "+ Double.toString(mejorabsoluto[mejorabsoluto.length-1]) +"\n";
		cromosomaFinal.setText(best);
		numberofgrafs++;
		grafPanel.addTab( "AG"+numberofgrafs, null, plot, "");
		grafPanel.setSelectedIndex(numberofgrafs-1);
	}

	
	public void borrarGrafActivo(){
		if(grafPanel.getSelectedIndex()>=0){
			grafPanel.removeTabAt(grafPanel.getSelectedIndex());
			numberofgrafs--;
		}
	}

	public void setVisibilityTorneo(boolean visible) {
		panelTorneo.setVisible(visible);
		labelTorneo.setVisible(visible);
	}
	
	public int getPoblacionText() {
		return Integer.parseInt(poblacionTextField.getText());
	}
	
	public int getProfundidadText() {
		return Integer.parseInt(profundidadTextField.getText());
	}

	public int getIteracionesText() {
		return Integer.parseInt(iteracionesTextField.getText());
	}

	public Double getCrucesText() {
		return Double.parseDouble(crucesTextField.getText()) / 100;
	}

	public Double getMutacionText() {
		return Double.parseDouble(mutacionTextField.getText()) / 100;
	}

	public int getSemillaText() {
		return Integer.parseInt(semillaTextField.getText());
	}

	public Double getMejorTextField() {
		return Double.parseDouble(mejorTextField.getText()) / 100;
	}

	public int getEntreTextField() {
		return Integer.parseInt(entreTextField.getText());
	}
	
	public String getInitializationTextField() {
		return (String) inicializacionCB.getSelectedItem();
	}

	public boolean getElitismoButton() {
		return elitismoRadio.isSelected();
	}
	
	public boolean getIFButton() {
		return IFRadio.isSelected();
	}

	public int getSeleccionCBIndex() {
		return seleccionCB.getSelectedIndex();
	}
	
	public int getMutationCBIndex() {
		return mutationCB.getSelectedIndex();
	}
	
	public int getBloatingCBIndex() {
		return bloatingCB.getSelectedIndex();
	}
	
	public int getCalcTamCBIndex() {
		return calcTamCB.getSelectedIndex();
	}

	public void setSeleccionCBListener(ActionListener a) {
		seleccionCB.addActionListener(a);
	}
	
	public void setLanzaButtonListener(ActionListener a) {
		lanzaButton.addActionListener(a);
	}

	public void setRelanzaButtonListener(ActionListener a) {
		relanzaButton.addActionListener(a);
	}

	public void setEliminaButtonListener(ActionListener a) {
		eliminaButton.addActionListener(a);
	}
	
	public void setVisibilityRelanza(boolean b) {
		relanzaButton.setVisible(b);
		
	}
	
}