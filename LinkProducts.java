 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LinkProducts.java
 *
 * Created on 22-Jun-2011, 14:14:04
 */
package proffittcenter;

import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dave
 */
public class LinkProducts extends javax.swing.JDialog {

    private int department;
    private String productSelection = "SELECT P.ID,P.Description,P.Price, "
            + "P.Sku AS SKK,"
            + "(SELECT Products.Description FROM Products,Skus WHERE Products.Sku=Skus.ID "
            + "AND Skus.ID=P.Sku "
            + "ORDER BY Products.WhenCreated LIMIT 1)AS LinkedTo "
            + "FROM Products AS P, Skus "
            + "WHERE P.Sku = Skus.ID AND Skus.Department=? "
            + "AND (((P.Description) LIKE ?)  "
            + "OR ((P.Description) LIKE ?)) "
            + "ORDER BY P.Sku,P.Description ";
    private JDBCTableModel jtm;
    private ResourceBundle bundle = ResourceBundle.getBundle("proffittcenter/resource/LinkProducts");

    ;
    private int firstSelection;
    private Integer firstSku=-1;
    private int secondSelection;
    private Integer secondSku=-1;
    private Long firstBarcode;
    private Long secondBarcode;
    private String alpha="";
    private String s1="%";
    private String s2="%";


    /** Creates new form LinkProducts */
    public LinkProducts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Main.mainHelpBroker.enableHelpKey(getRootPane(), "linkproducts", Main.mainHelpSet);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        linkToButton = new javax.swing.JButton();
        firstSkuTextField = new javax.swing.JTextField();
        linkFromButton = new javax.swing.JButton();
        secondSkuTextField = new javax.swing.JTextField();
        linkButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        alphaTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("proffittcenter/resource/LinkProducts"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setName("linkProducts"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        linkToButton.setText(bundle.getString("LinkProducts.linkToButton.text")); // NOI18N
        linkToButton.setName("linkToButton"); // NOI18N
        linkToButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkToButtonActionPerformed(evt);
            }
        });

        firstSkuTextField.setName("firstSkuTextField"); // NOI18N

        linkFromButton.setText(bundle.getString("LinkProducts.linkFromButton.text")); // NOI18N
        linkFromButton.setName("linkFromButton"); // NOI18N
        linkFromButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkFromButtonActionPerformed(evt);
            }
        });

        secondSkuTextField.setName("secondSkuTextField"); // NOI18N

        linkButton.setText(bundle.getString("LinkProducts.linkButton.text")); // NOI18N
        linkButton.setName("linkButton"); // NOI18N
        linkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(bundle.getString("LinkProducts.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        alphaTextField.setName("alphaTextField"); // NOI18N
        alphaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alphaTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(linkToButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstSkuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linkFromButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondSkuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linkButton)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alphaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkToButton)
                    .addComponent(firstSkuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linkFromButton)
                    .addComponent(secondSkuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linkButton)
                    .addComponent(jLabel1)
                    .addComponent(alphaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void linkToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkToButtonActionPerformed
        // get first selection
        firstSelection = jTable1.getSelectedRow();
        if(firstSelection<0){
            return;
        }
        firstSelection=jTable1.convertRowIndexToModel(firstSelection);
        firstSku=(Integer)jTable1.getModel().getValueAt(firstSelection, 3) ;
        firstSkuTextField.setText(firstSku.toString());
        firstBarcode=(Long)jTable1.getModel().getValueAt(firstSelection, 0) ;
        jTable1.clearSelection();
    }//GEN-LAST:event_linkToButtonActionPerformed

    private void linkFromButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkFromButtonActionPerformed
        // get first selection
        secondSelection = jTable1.getSelectedRow();
        if(secondSelection<0){
            return;
        }
        secondSelection=jTable1.convertRowIndexToModel(secondSelection);
        secondSku=(Integer)jTable1.getModel().getValueAt(secondSelection, 3) ;
        secondSkuTextField.setText(secondSku.toString());
        secondBarcode=(Long)jTable1.getModel().getValueAt(secondSelection, 0) ;
        jTable1.clearSelection();
    }//GEN-LAST:event_linkFromButtonActionPerformed

    private void linkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkButtonActionPerformed
        if(firstSku < 0 || secondSku < 0 || firstSku == secondSku) {//not selected yet or the same
            Audio.play("Ring");
            return;
        }
        Main.linkSkus.execute(firstSku, secondSku, firstBarcode, secondBarcode);
        try {
            //use typed characters to restrict selection
            PreparedStatement ps = Main.getConnection().prepareStatement(productSelection);
            ps.setInt(1, department);
            ps.setString(2, s1);
            ps.setString(3, s2);
            HashSet editable = new HashSet();
            editable.add(6);
            jtm = new JDBCTableModel(ps, bundle, jTable1, editable);
        } catch (SQLException ex) {
            Logger.getLogger(LinkProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_linkButtonActionPerformed

private void alphaTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alphaTextFieldKeyReleased
        try {
        //use typed characters to restrict selection
        alpha = alphaTextField.getText();
         s1=alpha +"%";
         s2="% "+ alpha +"%";
        PreparedStatement ps = Main.getConnection().prepareStatement(productSelection);
        ps.setInt(1, department);
        ps.setString(2, s1);
        ps.setString(3, s2);
        HashSet editable = new HashSet();
        editable.add(6);
        jtm = new JDBCTableModel(ps, bundle, jTable1, editable);
    } catch (SQLException ex) {
        Logger.getLogger(LinkProducts.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_alphaTextFieldKeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        //a cell has been selected
        
    }//GEN-LAST:event_jTable1KeyReleased


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LinkProducts dialog = new LinkProducts(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField alphaTextField;
    private javax.swing.JTextField firstSkuTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton linkButton;
    private javax.swing.JButton linkFromButton;
    private javax.swing.JButton linkToButton;
    private javax.swing.JTextField secondSkuTextField;
    // End of variables declaration//GEN-END:variables

    void execute(int department) {
        this.department = department;
        Audio.play("TaDa");
        firstSku=-1;
        secondSku=-1;
        firstSkuTextField.setText("");
        secondSkuTextField.setText("");
        alphaTextField.requestFocus();
        s1="%";
        s2="%";
        try {
            PreparedStatement ps = Main.getConnection().prepareStatement(productSelection);
            ps.setInt(1, department);
            ps.setString(2, s1);
            ps.setString(3, s2);
            HashSet editable = new HashSet();
            editable.add(6);
            jtm = new JDBCTableModel(ps, bundle, jTable1, editable);
            setVisible(true);
        } catch (SQLException ex) {
            Audio.play("Ring");
            Logger.getLogger(LinkProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
