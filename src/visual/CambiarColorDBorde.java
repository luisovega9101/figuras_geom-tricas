/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CambiarColorDBorde.java
 *
 * Created on 22-jun-2011, 19:49:10
 */

package visual;

import clases.EPosFueraRango;
import clases.cElipseGrafico;
import clases.cLienzo;
import clases.cRectanguloGrafico;
import clases.cTrianguloGrafico;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Luis Enrique
 */
public class CambiarColorDBorde extends javax.swing.JDialog {

    private cLienzo lienzo;
    private int pos;
    /** Creates new form CambiarColorDBorde */
    public CambiarColorDBorde(java.awt.Frame parent, boolean modal,cLienzo lienzo, int p) {
        super(parent, modal);
        initComponents();
        this.lienzo = lienzo;
        pos=p;
        setResizable(false);
    }

    private CambiarColorDBorde(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed1(evt);
            }
        });

        jButton1.setText("Cambiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed1
        dispose();
}//GEN-LAST:event_jButton2ActionPerformed1

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Color c= jColorChooser1.getColor();
        try {
            if (lienzo.getObjeto(pos) instanceof cRectanguloGrafico) {
                cRectanguloGrafico rect= (cRectanguloGrafico) lienzo.getObjeto(pos);
                rect.CambiarColorBorde(c);
            } else if(lienzo.getObjeto(pos) instanceof cElipseGrafico) {
                cElipseGrafico elip= (cElipseGrafico) lienzo.getObjeto(pos);
                elip.CambiarColorBorde(c);
            }
            if (lienzo.getObjeto(pos) instanceof cTrianguloGrafico) {
                cTrianguloGrafico trian= (cTrianguloGrafico) lienzo.getObjeto(pos);
                trian.CambiarColorBorde(c);
            }
        } catch (EPosFueraRango ex) {
            Logger.getLogger(CambiarColorDBorde.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
}//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CambiarColorDBorde dialog = new CambiarColorDBorde(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables

}
