/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vahiculos.acdat.Vista;

/**
 *
 * @author Nitro
 */
public class PanelAcercaDe extends javax.swing.JPanel {

    /**
     * Creates new form PanelAcercaDe
     */
    
    private VentanaPrincipal ventana;
    
    public PanelAcercaDe(VentanaPrincipal ventana) {
        initComponents();
        this.ventana = ventana;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNewLabel = new javax.swing.JLabel();

        lblNewLabel.setFont(new java.awt.Font("Tahoma", 0, 29)); // NOI18N
        lblNewLabel.setForeground(java.awt.Color.blue);
        lblNewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewLabel.setText("Aplicación con modelo vista y controlador");
        lblNewLabel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblNewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblNewLabel;
    // End of variables declaration//GEN-END:variables
}
