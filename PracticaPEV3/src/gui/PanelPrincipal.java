package gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

import algoritmoGenetico.AlgoritmoGenetico;

@SuppressWarnings("serial")
public class PanelPrincipal extends javax.swing.JFrame implements ObservadorAlgoritmo {

	 private AlgoritmoGenetico algoritmo;
	 
    public PanelPrincipal() {
    	this.algoritmo = new AlgoritmoGenetico();
    	this.algoritmo.addObservador(this);
        initComponents();
        this.setLocationRelativeTo(null);
       
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	
    	jLabel1 = new javax.swing.JLabel();
        jTextFieldTamPoblacion = new javax.swing.JTextField();
        jLabelNumGeneraciones = new javax.swing.JLabel();
        jTextFieldNumGeneraciones = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSeleccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTamTorneos = new javax.swing.JTextField();
        jLabelEscogerMejor = new javax.swing.JLabel();
        jTextFieldEscogerMejor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxMutacion = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMutacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTipoCruce = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCruce = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoCreacion = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldMaxProfundidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxTipoLimitacion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldLimitacion = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldElite = new javax.swing.JTextField();
        jButtonResetear = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldSolucion = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBoxNumProblema = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanelGrafica = new javax.swing.JPanel();
        jButtonEjecutar = new javax.swing.JButton();
        jPanelEvaluacion = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipoEvaluacion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNumHebras = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        this.grafica = new Plot2DPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        final String[] columnas = { "Generación", "Mejor", "Media nodos", "Media fitness" };
        this.jTable1 = new JTable(new ModeloTablaAlgoritmo(columnas, this.algoritmo));
        this.jTable1.setFocusable(false);
        this.jTable1.setRowSelectionAllowed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tamaño Población");

        jTextFieldTamPoblacion.setText("200");

        jLabelNumGeneraciones.setText("Número de generaciones");

        jTextFieldNumGeneraciones.setText("200");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección"));

        jLabel3.setText("Tipo de selección");

        jComboBoxSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Seleccion Torneos Deterministico", "Seleccion Ruleta", "Seleccion Torneos Probabilistico", "Seleccion Estocastica", "Seleccion Truncamiento", "Seleccion Restos", "Seleccion Ranking" }));
        jComboBoxSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeleccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Tamaño torneos");

        jTextFieldTamTorneos.setText("3");

        jLabelEscogerMejor.setText("% Escoger mejor");

        jTextFieldEscogerMejor.setText("50.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSeleccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldEscogerMejor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelEscogerMejor))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldTamTorneos))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTamTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEscogerMejor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEscogerMejor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mutación"));

        jLabel4.setText("Tipo de mutación");

        jComboBoxMutacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mutacion terminal simple", "Mutacion funcional simple", "Mutacion permutacion", "Mutacion hoist", "Mutacion expansion", "Mutacion contraccion", "Mutacion subarbol" }));

        jLabel6.setText("% Mutación");

        jTextFieldMutacion.setText("15.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMutacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldMutacion))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cruce"));

        jLabel7.setText("Tipo de cruce");

        jComboBoxTipoCruce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cruce simple" }));

        jLabel8.setText("% Cruce");

        jTextFieldCruce.setText("60.0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoCruce, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldCruce))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Crontrol de Bloating"));

        jLabel9.setText("Tipo de creación");

        jComboBoxTipoCreacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicializacion completa", "Inicializacion creciente", "Inicializacion ramped & half" }));

        jLabel10.setText("Máxima profundidad inicial");

        jTextFieldMaxProfundidad.setText("4");

        jLabel11.setText("Tipo de limitación");

        jComboBoxTipoLimitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin limite", "Metodo Tarpeian", "Penalizacion bien fundamentada" }));
        jComboBoxTipoLimitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoLimitacionActionPerformed(evt);
            }
        });

        jLabel12.setText("% Limitación");

        jTextFieldLimitacion.setText("5.0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoCreacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldMaxProfundidad)
                    .addComponent(jComboBoxTipoLimitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldLimitacion))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMaxProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoLimitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jTextFieldLimitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Elitismo"));

        jLabel13.setText("% Élite");

        jTextFieldElite.setText("0.0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTextFieldElite)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldElite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButtonResetear.setText("Resetear");
        jButtonResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetearActionPerformed(evt);
            }
        });

        jLabel14.setText("Solución: ");

        jCheckBox1.setText("Graficar presión selectiva");

        jComboBoxNumProblema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3" }));

        jLabel15.setText("Problema");

        jCheckBox2.setText("Usar IF");

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
        
        jPanelEvaluacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluación"));

        jLabel5.setText("Tipo de evaluación");

        jComboBoxTipoEvaluacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evaluacion lineal", "Evaluacion concurrente" }));
        jComboBoxTipoEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoEvaluacionActionPerformed(evt);
            }

			private void jComboBoxTipoEvaluacionActionPerformed(ActionEvent evt) {
				if(jComboBoxTipoEvaluacion.getSelectedIndex() == 0) {
					jLabel16.setVisible(false);
					jTextFieldNumHebras.setVisible(false);
				}
				else {
					jLabel16.setVisible(true);
					jTextFieldNumHebras.setVisible(true);
				}
			}
        });

        jLabel16.setText("Número de hebras");

        jTextFieldNumHebras.setText("2");

        javax.swing.GroupLayout jPanelEvaluacionLayout = new javax.swing.GroupLayout(jPanelEvaluacion);
        jPanelEvaluacion.setLayout(jPanelEvaluacionLayout);
        jPanelEvaluacionLayout.setHorizontalGroup(
            jPanelEvaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEvaluacionLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelEvaluacionLayout.createSequentialGroup()
                .addGroup(jPanelEvaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoEvaluacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelEvaluacionLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldNumHebras))
                .addContainerGap())
        );
        jPanelEvaluacionLayout.setVerticalGroup(
            jPanelEvaluacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEvaluacionLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNumHebras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumGeneraciones, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTamPoblacion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNumGeneraciones, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonResetear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEjecutar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelEvaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jCheckBox1)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jCheckBox2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(jComboBoxNumProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldTamPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumGeneraciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumGeneraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonResetear)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEjecutar))
                .addContainerGap())
        );
        
        this.jPanelGrafica.setLayout(new BoxLayout(this.jPanelGrafica, BoxLayout.Y_AXIS));
        this.jPanelGrafica.add(this.grafica);
        BaseLabel titulo = new BaseLabel("Gráfica de evolución", Color.BLACK, 0.5, 1.1);
        titulo.setFont(new Font("Courier", Font.BOLD, 20));
        this.grafica.addPlotable(titulo);
        this.grafica.setAxisLabel(1, "Valor de la función");
        this.grafica.setAxisLabel(0, "Generación");
        this.grafica.setLegendOrientation("SOUTH");
        this.setTitle("Practica PEV - 3");

        pack();
        
        this.jTextFieldTamPoblacion.setText("200");
        this.jTextFieldNumGeneraciones.setText("200");
        this.jComboBoxSeleccion.setSelectedIndex(0);
        this.jComboBoxTipoCruce.setSelectedIndex(0);
        this.jTextFieldCruce.setText("60.0");
        this.jComboBoxMutacion.setSelectedIndex(0);
        this.jTextFieldMutacion.setText("15.0");
        this.jTextFieldElite.setText("1.0");
        this.jComboBoxNumProblema.setSelectedIndex(1);
        this.jComboBoxMutacion.setSelectedIndex(0);
        this.jComboBoxSeleccion.setSelectedIndex(0);
        this.jComboBoxTipoCreacion.setSelectedIndex(0);
        this.jComboBoxTipoCruce.setSelectedIndex(0);
        this.jComboBoxTipoEvaluacion.setSelectedIndex(0);
        this.jComboBoxTipoLimitacion.setSelectedIndex(0);
        this.jTextFieldNumHebras.setText("2");
        this.jTextFieldMaxProfundidad.setText("4");
        this.jCheckBox2.setSelected(true);
        
    }// </editor-fold>                        

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

    private void jButtonResetearActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	this.jTextFieldTamPoblacion.setText("200");
        this.jTextFieldNumGeneraciones.setText("200");
        this.jComboBoxSeleccion.setSelectedIndex(0);
        this.jComboBoxTipoCruce.setSelectedIndex(0);
        this.jTextFieldCruce.setText("60.0");
        this.jComboBoxMutacion.setSelectedIndex(0);
        this.jTextFieldMutacion.setText("15.0");
        this.jTextFieldElite.setText("1.0");
        this.jComboBoxNumProblema.setSelectedIndex(1);
        this.jComboBoxMutacion.setSelectedIndex(0);
        this.jComboBoxSeleccion.setSelectedIndex(0);
        this.jComboBoxTipoCreacion.setSelectedIndex(0);
        this.jComboBoxTipoCruce.setSelectedIndex(0);
        this.jComboBoxTipoEvaluacion.setSelectedIndex(0);
        this.jComboBoxTipoLimitacion.setSelectedIndex(0);
        this.jTextFieldNumHebras.setText("2");
        this.jTextFieldMaxProfundidad.setText("4");
        this.jCheckBox2.setSelected(true);
        
    }                                               

    private void jComboBoxTipoLimitacionActionPerformed(java.awt.event.ActionEvent evt) {
    	if(this.jComboBoxTipoLimitacion.getSelectedIndex() == 1) {
    		this.jLabel12.setVisible(true);
            this.jTextFieldLimitacion.setVisible(true);
            this.jTextFieldNumHebras.setText("2");
    	}
    	else {
    		this.jLabel12.setVisible(false);
            this.jTextFieldLimitacion.setVisible(false);
    	}
    }                                                       

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {
    	new Thread() {
		     public void run() {
					try {
						algoritmo.runAlgoritmo(Integer.parseInt(jTextFieldTamPoblacion.getText()),
						         Integer.parseInt(jTextFieldNumGeneraciones.getText()),
						         Double.parseDouble(jTextFieldCruce.getText()),
						         Double.parseDouble(jTextFieldMutacion.getText()),
						         Double.parseDouble(jTextFieldElite.getText()),
						         Integer.parseInt(jComboBoxNumProblema.getSelectedItem().toString()),
						         Double.parseDouble(jTextFieldEscogerMejor.getText()),
						         isInteger(jTextFieldTamTorneos.getText()) ? Integer.parseInt(jTextFieldTamTorneos.getText()) : 3,
						         isDouble(jTextFieldTamTorneos.getText()) ? Double.parseDouble(jTextFieldTamTorneos.getText()) : 50.0,
						         jCheckBox1.isSelected(),
						         jComboBoxSeleccion.getSelectedItem().toString(),
						         jComboBoxTipoCruce.getSelectedItem().toString(),
						         jComboBoxMutacion.getSelectedItem().toString(),
						         jComboBoxTipoCreacion.getSelectedItem().toString(),
						         jComboBoxTipoLimitacion.getSelectedItem().toString(),
						         isDouble(jTextFieldLimitacion.getText()) ? Double.parseDouble(jTextFieldLimitacion.getText()) : 5.0,
						         isInteger(jTextFieldMaxProfundidad.getText()) ? Integer.parseInt(jTextFieldMaxProfundidad.getText()) : 4,
						         jCheckBox2.isSelected(),
						         jComboBoxTipoEvaluacion.getSelectedItem().toString(),
						         isInteger(jTextFieldNumHebras.getText()) ? Integer.parseInt(jTextFieldNumHebras.getText()) : 2);
					} catch (NumberFormatException | FileNotFoundException e) {
						e.printStackTrace();
					}
		     }
		 }.start();
    }     
    
    public void runGraph() {
    	this.grafica.removeAllPlots();
    	double[] X = this.createDatasetX(this.algoritmo.getGrafica().getMejorGeneracion());
    	this.grafica.addLinePlot("Media generación", X, this.createDatasetMediaGeneracion());
    	this.grafica.addLinePlot("Mejor generación", X, this.createDatasetMejorGeneracion());
    	this.grafica.addLinePlot("Mejor absoluto", X, this.createDatasetMejorAbsoluto());
    	if(this.jCheckBox1.isSelected()) this.grafica.addLinePlot("Presión selectiva generación", X, this.createDatasetPresionSelectivaGeneracion());
    	
    }
    
    public double[] createDatasetX(ArrayList<Double> arrayList) {
    	double[] X = new double[arrayList.size()];
    	for(int i = 0; i < arrayList.size(); i++) X[i] = i + 1;
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
    
    @Override
	public void inicia() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jProgressBar1.setValue(0);
				jProgressBar1.setVisible(true);
				jButtonEjecutar.setEnabled(false);
				jButtonResetear.setEnabled(false);
			}
		});
		
	}

	@Override
	public void actualiza(int generacionActual, int maxGeneraciones, DatosTabla datos) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jProgressBar1.setValue((generacionActual * 100) / maxGeneraciones);
				jTextFieldSolucion.setText(algoritmo.getMejorSolucionString());
				jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount() -1, 0, true));
			}
		});
	}

	@Override
	public void finaliza() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jProgressBar1.setVisible(false);
				runGraph();
				jTextFieldSolucion.setText(algoritmo.getMejorSolucionString());
				jButtonEjecutar.setEnabled(true);
				jButtonResetear.setEnabled(true);
				}
			});
	}
	
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonResetear;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBoxMutacion;
    private javax.swing.JComboBox<String> jComboBoxNumProblema;
    private javax.swing.JComboBox<String> jComboBoxSeleccion;
    private javax.swing.JComboBox<String> jComboBoxTipoCreacion;
    private javax.swing.JComboBox<String> jComboBoxTipoCruce;
    private javax.swing.JComboBox<String> jComboBoxTipoEvaluacion;
    private javax.swing.JComboBox<String> jComboBoxTipoLimitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEscogerMejor;
    private javax.swing.JLabel jLabelNumGeneraciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelGrafica;
    private javax.swing.JTextField jTextFieldCruce;
    private javax.swing.JTextField jTextFieldElite;
    private javax.swing.JTextField jTextFieldEscogerMejor;
    private javax.swing.JTextField jTextFieldLimitacion;
    private javax.swing.JTextField jTextFieldMaxProfundidad;
    private javax.swing.JTextField jTextFieldMutacion;
    private javax.swing.JTextField jTextFieldNumGeneraciones;
    private javax.swing.JTextField jTextFieldNumHebras;
    private javax.swing.JTextField jTextFieldSolucion;
    private javax.swing.JTextField jTextFieldTamPoblacion;
    private javax.swing.JTextField jTextFieldTamTorneos;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private Plot2DPanel grafica;
    private javax.swing.JPanel jPanelEvaluacion;
    // End of variables declaration                   

	
}
