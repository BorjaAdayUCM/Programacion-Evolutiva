package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

import algoritmoGenetico.*;
/**
 *
 * @author borja
 */
@SuppressWarnings("serial")
public class PanelPrincipal extends javax.swing.JFrame {

    private AlgoritmoGenetico algoritmo;
    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
        this.algoritmo = new AlgoritmoGenetico();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        jTextFieldTamPoblacion = new javax.swing.JTextField();
        jLabelNumGeneraciones = new javax.swing.JLabel();
        jLabelTamPoblacion = new javax.swing.JLabel();
        jTextFieldNumGeneraciones = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelTipoSeleccion = new javax.swing.JLabel();
        jComboBoxSeleccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTamTorneos = new javax.swing.JTextField();
        jLabelEscogerMejor = new javax.swing.JLabel();
        jTextFieldEscogerMejor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelTipoCruce = new javax.swing.JLabel();
        jComboBoxTipoCruce = new javax.swing.JComboBox<>();
        jLabelCruce = new javax.swing.JLabel();
        jTextFieldCruce = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxMutacion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldMutacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldElite = new javax.swing.JTextField();
        jPanelGrafica = new javax.swing.JPanel();
        jButtonEjecutar = new javax.swing.JButton();
        jButtonResetear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSolucion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxNumProblema = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldValorN = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        this.grafica = new Plot2DPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldTamPoblacion.setText("100");

        jLabelNumGeneraciones.setText("Número de generaciones");

        jLabelTamPoblacion.setText("Tamaño población");

        jTextFieldNumGeneraciones.setText("100");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección"));

        jLabelTipoSeleccion.setText("Tipo de selección");

        jComboBoxSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion Ruleta", "Seleccion Torneos Deterministico", "Seleccion Torneos Probabilistico", "Seleccion Estocastica", "Seleccion Truncamiento", "Seleccion Restos", "Seleccion Ranking" }));
        jComboBoxSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeleccionActionPerformed(evt);
            }
        });
        
        jLabel2.setText("Tamaño Torneos");

        jTextFieldTamTorneos.setText("3");

        jLabelEscogerMejor.setText("% Escoger mejor");

        jTextFieldEscogerMejor.setText("50.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTipoSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jLabelEscogerMejor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSeleccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldTamTorneos)
                    .addComponent(jTextFieldEscogerMejor))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTipoSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTamTorneos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEscogerMejor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEscogerMejor))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cruce"));

        jLabelTipoCruce.setText("Tipo de cruce");

        jComboBoxTipoCruce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Cruce PMX", "Cruce OX", "Cruce OX-PP", "Cruce CO", "Cruce ERX", "Cruce CX"}));

        jLabelCruce.setText("% Cruce");

        jTextFieldCruce.setText("60.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipoCruce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCruce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)))
                .addGap(86, 86, 86))
            .addComponent(jComboBoxTipoCruce, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextFieldCruce)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelTipoCruce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoCruce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCruce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCruce))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Mutación"));

        jLabel6.setText("Tipo de mutación");

        jComboBoxMutacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mutacion Insercion", "Mutacion Intercambio", "Mutacion Inversion", "Mutacion Heuristica"}));

        jLabel9.setText("% Mutación");

        jTextFieldMutacion.setText("5.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)))
                .addGap(69, 69, 69))
            .addComponent(jComboBoxMutacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextFieldMutacion)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMutacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMutacion))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Élite"));

        jLabel7.setText("% Élite");

        jTextFieldElite.setText("0.0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(116, 116, 116))
            .addComponent(jTextFieldElite)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldElite))
        );

        jPanelGrafica.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfica"));

        javax.swing.GroupLayout jPanelGraficaLayout = new javax.swing.GroupLayout(jPanelGrafica);
        jPanelGrafica.setLayout(jPanelGraficaLayout);
        jPanelGraficaLayout.setHorizontalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelGraficaLayout.setVerticalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonEjecutar.setText("Ejecutar");
        jButtonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEjecutarActionPerformed(evt);
            }
        });

        jButtonResetear.setText("Resetear");
        jButtonResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetearActionPerformed(evt);
            }
        });

        jLabel8.setText("Solución:");

        jLabel11.setText("Problema");

        jComboBoxNumProblema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6"}));

        jLabel12.setText("Variable n: ");

        jTextFieldValorN.setText("1");
        
        jCheckBox1.setText("Graficar Presión Selectiva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTamPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNumGeneraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldTamPoblacion)
                            .addComponent(jTextFieldNumGeneraciones)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonResetear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(151, 151, 151)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEjecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValorN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(613, 613, 613))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jComboBoxNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldValorN))
                            .addGap(4, 4, 4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelTamPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldTamPoblacion)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelNumGeneraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldNumGeneraciones)
                            .addGap(18, 18, 18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jTextFieldSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonEjecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addComponent(jButtonResetear))
                    .addGap(19, 19, 19))
            );
        

        this.jPanelGrafica.setLayout(new BoxLayout(this.jPanelGrafica, BoxLayout.Y_AXIS));
        this.jPanelGrafica.add(this.grafica);
        BaseLabel titulo = new BaseLabel("Gráfica de evolución", Color.BLACK, 0.5, 1.1);
        titulo.setFont(new Font("Courier", Font.BOLD, 20));
        this.grafica.addPlotable(titulo);
        this.grafica.setAxisLabel(1, "Valor de la función");
        this.grafica.setAxisLabel(0, "Generación");
        this.grafica.setLegendOrientation("SOUTH");
        this.setTitle("Practica PEV - 2");
        
        pack();
        
      //PROPIO
        this.jLabel12.setVisible(false);
        this.jTextFieldValorN.setVisible(false);
        this.jLabel2.setVisible(false);
        this.jTextFieldTamTorneos.setVisible(false);
        this.jLabelEscogerMejor.setVisible(false);
        this.jTextFieldEscogerMejor.setVisible(false);
        this.jTextFieldSolucion.setEditable(false);
    }

     private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {
    	 try {
    		 this.algoritmo.runAlgoritmo(Integer.parseInt(this.jTextFieldTamPoblacion.getText()),
                     Integer.parseInt(this.jTextFieldNumGeneraciones.getText()),
                     Double.parseDouble(this.jTextFieldCruce.getText()),
                     Double.parseDouble(this.jTextFieldMutacion.getText()),
                     Double.parseDouble(this.jTextFieldElite.getText()),
                     Integer.parseInt(this.jComboBoxNumProblema.getSelectedItem().toString()),
                     Double.parseDouble(this.jTextFieldEscogerMejor.getText()),
                     this.isInteger(this.jTextFieldTamTorneos.getText()) ? Integer.parseInt(this.jTextFieldTamTorneos.getText()) : 3,
                     this.isDouble(this.jTextFieldTamTorneos.getText()) ? Double.parseDouble(this.jTextFieldTamTorneos.getText()) : 50.0,
                     this.jCheckBox1.isSelected(),
                     this.jComboBoxSeleccion.getSelectedItem().toString(),
                     this.jComboBoxTipoCruce.getSelectedItem().toString(),
                     this.jComboBoxMutacion.getSelectedItem().toString());
    		 	this.runGraph();
        	 	this.jTextFieldSolucion.setText(this.algoritmo.getMejorIndividuo().toString());
    	 }
    	 catch (Exception e) {
    		 e.printStackTrace();
    		 JOptionPane.showMessageDialog(null, "Existe algún parámetro incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
    	 }
    	 
    }                                               

    private void jButtonResetearActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	this.jTextFieldTamPoblacion.setText("100");
        this.jTextFieldNumGeneraciones.setText("100");
        this.jComboBoxSeleccion.setSelectedIndex(0);
        this.jComboBoxTipoCruce.setSelectedIndex(0);
        this.jTextFieldCruce.setText("60.0");
        this.jComboBoxMutacion.setSelectedIndex(0);
        this.jTextFieldMutacion.setText("5.0");
        this.jTextFieldElite.setText("0.0");
    }
    
    private void jComboBoxSeleccionActionPerformed(java.awt.event.ActionEvent evt) {
    	if(this.jComboBoxSeleccion.getSelectedIndex() == 1) {
    		this.jLabel2.setText("Tamaño torneos");
    		this.jLabel2.setVisible(true);
    		this.jTextFieldTamTorneos.setText("3");
    		this.jTextFieldTamTorneos.setVisible(true);
    		this.jLabelEscogerMejor.setVisible(false);
    		this.jTextFieldEscogerMejor.setVisible(false);
    	}
    	else if(this.jComboBoxSeleccion.getSelectedIndex() == 2) {
    		this.jLabel2.setText("Tamaño torneos");
    		this.jLabel2.setVisible(true);
    		this.jTextFieldTamTorneos.setText("3");
    		this.jTextFieldTamTorneos.setVisible(true);
    		this.jLabelEscogerMejor.setVisible(true);
    		this.jTextFieldEscogerMejor.setText("50.0");
    		this.jTextFieldEscogerMejor.setVisible(true);
    	}
    	else if(this.jComboBoxSeleccion.getSelectedIndex() == 4) {
    		this.jLabel2.setText("% Truncamiento");
    		this.jLabel2.setVisible(true);
    		this.jTextFieldTamTorneos.setVisible(true);
    		this.jTextFieldTamTorneos.setText("50.0");
    		this.jLabelEscogerMejor.setVisible(false);
    		this.jTextFieldEscogerMejor.setVisible(false);
    	}
    	else {
    		this.jLabel2.setVisible(false);
    		this.jTextFieldTamTorneos.setVisible(false);
    		this.jLabelEscogerMejor.setVisible(false);
    		this.jTextFieldEscogerMejor.setVisible(false);
    	}
    }
    
    public void runGraph() {
    	this.grafica.removeAllPlots();
    	double[] X = this.createDatasetX(this.algoritmo.getGrafica().getMejorGeneracion());
    	this.grafica.addLinePlot("Media generación", X, this.createDatasetMediaGeneracion());
    	this.grafica.addLinePlot("Mejor generación", X, this.createDatasetMejorGeneracion());
    	this.grafica.addLinePlot("Mejor absoluto", X, this.createDatasetMejorAbsoluto());
    	if(this.jCheckBox1.isSelected()) this.grafica.addLinePlot("Presión selectiva generación", X, this.createDatasetPresionSelectivaGeneracion());
    	
    }
    
    public double[] createDatasetX(ArrayList<Integer> array) {
    	double[] X = new double[array.size()];
    	for(int i = 0; i < array.size(); i++) X[i] = i + 1;
    	return X;
    }
    
    public double[] createDatasetMejorAbsoluto() {
    	double X[] = new double[this.algoritmo.getGrafica().getMejorAbsoluto().size()];
        for(int i = 0; i < this.algoritmo.getGrafica().getMejorAbsoluto().size(); i++) X[i] = this.algoritmo.getGrafica().getMejorAbsoluto().get(i);
        return X;
    }
    
    public double[] createDatasetMejorGeneracion() {
    	double X[] = new double[this.algoritmo.getGrafica().getMejorGeneracion().size()];
        for(int i = 0; i < this.algoritmo.getGrafica().getMejorGeneracion().size(); i++) X[i] = this.algoritmo.getGrafica().getMejorGeneracion().get(i);
        return X;
    }
    
    public double[] createDatasetMediaGeneracion() {
    	double X[] = new double[this.algoritmo.getGrafica().getMediaGeneracion().size()];
        for(int i = 0; i < this.algoritmo.getGrafica().getMediaGeneracion().size(); i++) X[i] = this.algoritmo.getGrafica().getMediaGeneracion().get(i);
        return X;
    }
    
    public double[] createDatasetPresionSelectivaGeneracion() {
    	double X[] = new double[this.algoritmo.getGrafica().getPresionSelectivaGeneracion().size()];
        for(int i = 0; i < this.algoritmo.getGrafica().getPresionSelectivaGeneracion().size(); i++) X[i] = this.algoritmo.getGrafica().getPresionSelectivaGeneracion().get(i);
        return X;
    }
    
    public double[] createDatasetDesviacion() {
    	double X[] = new double[this.algoritmo.getGrafica().getDesviacionTipicaGeneracion().size()];
        for(int i = 0; i < this.algoritmo.getGrafica().getDesviacionTipicaGeneracion().size(); i++) 
        	X[i] = this.algoritmo.getGrafica().getDesviacionTipicaGeneracion().get(i) * this.algoritmo.getMejorIndividuo().getFitness();
        return X;
    }
    
    private boolean isInteger(String num) {
    	try {
    		Integer.parseInt(num);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    private boolean isDouble(String num) {
    	try {
    		Double.parseDouble(num);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }

    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonResetear;
    private javax.swing.JComboBox<String> jComboBoxMutacion;
    private javax.swing.JComboBox<String> jComboBoxNumProblema;
    private javax.swing.JComboBox<String> jComboBoxSeleccion;
    private javax.swing.JComboBox<String> jComboBoxTipoCruce;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCruce;
    private javax.swing.JLabel jLabelEscogerMejor;
    private javax.swing.JLabel jLabelNumGeneraciones;
    private javax.swing.JLabel jLabelTamPoblacion;
    private javax.swing.JLabel jLabelTipoCruce;
    private javax.swing.JLabel jLabelTipoSeleccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Plot2DPanel grafica;
    private JPanel jPanelGrafica;
    private javax.swing.JTextField jTextFieldCruce;
    private javax.swing.JTextField jTextFieldElite;
    private javax.swing.JTextField jTextFieldEscogerMejor;
    private javax.swing.JTextField jTextFieldMutacion;
    private javax.swing.JTextField jTextFieldNumGeneraciones;
    private javax.swing.JTextField jTextFieldSolucion;
    private javax.swing.JTextField jTextFieldTamPoblacion;
    private javax.swing.JTextField jTextFieldTamTorneos;
    private javax.swing.JTextField jTextFieldValorN;
    private javax.swing.JCheckBox jCheckBox1;
}
