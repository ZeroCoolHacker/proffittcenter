/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StartingStockEntry1.java
 *
 * Created on 17-Mar-2009, 18:15:21
 */
package proffittcenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP_Owner
 */
public class StartingStockEntry extends EscapeDialog {

    private static ResourceBundle bundle = ResourceBundle.getBundle("proffittcenter/resource/StartingStockEntry");
    private Long product;
    private String shortenedProduct;
    private String productExistsString = "SELECT ID FROM Products WHERE ID=? AND Encoded=0 "
            + " OR SUBSTRING(ID FROM 1 FOR 7)=SUBSTRING(? FROM 1 FOR 7) AND (Encoded=1 OR Encoded=2)"//parity
            + " OR SUBSTRING(ID FROM 1 FOR 8)=SUBSTRING(? FROM 1 FOR 8) "
            + " AND (Encoded=3 OR Encoded=4)"
            + " OR SUBSTRING(ID FROM 1 FOR 6)=SUBSTRING(? FROM 1 FOR 6) "
            + " AND (Encoded=5 OR Encoded=6)";//5 digit price
    PreparedStatement productExists;
    private int encoded;
    private int pack;
    private int packSupplier;
    private int quantity;
    private boolean tenThousand=false;
    private String barcode;

    /** Creates new form StartingStockEntry1
     * @param parent
     * @param modal  
     */
    public StartingStockEntry(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Main.mainHelpBroker.enableHelpKey(getRootPane(), "Startingstock", Main.mainHelpSet);
        getRootPane().setDefaultButton(okButton);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        j10000Code = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Starting stock");
        setName("StartingStockEntry"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("proffittcenter/resource/StartingStockEntry"); // NOI18N
        jLabel1.setText(bundle.getString("jLabel1")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.setNextFocusableComponent(okButton);

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proffittcenter/resource/OK.png"))); // NOI18N
        okButton.setToolTipText(bundle.getString("okButton")); // NOI18N
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                okButtonFocusGained(evt);
            }
        });

        j10000Code.setText(bundle.getString("StartingStockEntry.j10000Code")); // NOI18N
        j10000Code.setContentAreaFilled(false);
        j10000Code.setName("j10000Code"); // NOI18N
        j10000Code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j10000CodeActionPerformed(evt);
            }
        });

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proffittcenter/resource/Close24.png"))); // NOI18N
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("StartingStockEntry.jLabel1.text_1")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(j10000Code)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(j10000Code, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_closeButtonActionPerformed

    private void j10000CodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j10000CodeActionPerformed
        tenThousand=true;
        Long thousandCode;
        ResultSet rs;
        try {
            productExists = Main.getConnection().prepareStatement(productExistsString);
            for (long i = 1; i < 10000; i++) {
                thousandCode = 100000000L + i;
                productExists.setLong(1, thousandCode);
                productExists.setLong(2, thousandCode);//never encoded
                productExists.setLong(3, thousandCode);//never encoded
                productExists.setLong(4, thousandCode);//
                rs = productExists.executeQuery();
                if (!rs.first()) { //product does not exist
                    jTextField1.setText(""+thousandCode);
                    lastProduct=thousandCode;
                    //save a new product
                    rs.close();
//                    thousandCode = Main.newProduct.execute(thousandCode, true);
                    if (thousandCode == 0L) {
                        Audio.play("Ring");
                    } else {
//                        Audio.play("Beep");//not needed as TaDa
                    }
//                    jTextField1.setText("");
                    jTextField1.requestFocus();
                    break;
                }
                rs.close();
            }
            productExists.close();
            ok();
        } catch (SQLException ex) {
            Logger.getLogger(StartingStockEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_j10000CodeActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
       if(!ok()){
            jTextField1.requestFocus();
           return;
       } else {
           Audio.play("Beep");
       }
    }//GEN-LAST:event_okButtonActionPerformed

    private void okButtonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_okButtonFocusGained
        ok();
    }//GEN-LAST:event_okButtonFocusGained

    public void execute() {
        Audio.play("Tada");
        jLabel2.setVisible(false);
        jTextField1.setText("");
        jTextField1.requestFocus();
        lastProduct = 0l;
        tenThousand=false;
        setVisible(true);
    }

    /**
     * @param args the  command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                StartingStockEntry dialog = new StartingStockEntry(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton j10000Code;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private long lastProduct = 0l;

    private boolean ok() {
         //long product;
        jLabel2.setVisible(false);
        String s = jTextField1.getText().toUpperCase().trim();
        if(s.isEmpty()){
            jTextField1.setText("");
            jTextField1.requestFocus();
            return false;
        }
        if(s.isEmpty()){
            return false;
        }
        if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
            //must be a hotkey
            char c = s.charAt(0);
            product = c - 64 + 1000000l;
        } else {
            //must be a barcode
            s = StringOps.maxLength(s);
            if (s.isEmpty()) {
                return false;
            }
            product = Long.parseLong(s);
        }
        //now see if exists
        try {
            //now need to check till/product table
            productExists = Main.getConnection().prepareStatement(productExistsString);
            String data = "" + product;
            productExists.setString(1, data);
            String shortenedData6 = NewProduct.shortenForEncoded6(data);
            String shortenedData7 = NewProduct.shortenForEncoded7(data);
            String shortenedData8 = NewProduct.shortenForEncoded8(data);
            productExists.setString(2, shortenedData7);
            productExists.setString(3, shortenedData8);
            productExists.setString(4, shortenedData6);
            ResultSet rs = productExists.executeQuery();
           if (rs.first()) {//product exists
                //try again
                jLabel2.setVisible(false);
                rs.close();
                Audio.play("Ring");
                jLabel2.setText(bundle.getString("ProductExists"));//Scan code twice:
                jLabel2.setVisible(true);
                jTextField1.setText("");
                jTextField1.requestFocus();
            } else {//does not exist
                if (product == lastProduct) {//scanned twice
                    lastProduct = 0l;
                    //save a new product
                    rs.close();
                    if (NewProduct.couldBeEncoded("" + product)) {
                        encoded = Main.selectEncoded.execute();
                        if(encoded<0){
                            Audio.play("Ring");
                            return false;
                        }
                        if (encoded != NewProduct.NOTENCODE) {
                            //need to handle encoded product
                            if(encoded == NewProduct.ENCODEBYPRICEPARITY || encoded == NewProduct.ENCODEBYWEIGHTPARITY){
                                barcode = NewProduct.shortenForEncoded7(""+product);
                            } else if(encoded == NewProduct.ENCODEBYPRICENOPARITY || encoded == NewProduct.ENCODEBYWEIGHTNOPARITY){
                                barcode = NewProduct.shortenForEncoded8(""+product);
                            } else if(encoded == NewProduct.ENCODEBYPRICE5 || encoded == NewProduct.ENCODEBYWEIGHT5){
                                barcode = NewProduct.shortenForEncoded6(""+product);
                            } 
                                //create new pack, new packSupplier and new product
                            product = Main.newProduct.execute(Long.parseLong(barcode), encoded,true);
                            if(product==0L){
                                lastProduct=0L;
                                jTextField1.setText("");
                                jTextField1.requestFocus();
                               return false;
                            }
                            jTextField1.setText("");
                            jTextField1.requestFocus();
                            return true;
                        }
                    }
                    //normal new product
                    product = Main.newProduct.execute(product, true);
                    if(product==0L){
                        lastProduct=0L;
                        jTextField1.setText("");
                        jTextField1.requestFocus();
                        return false;
                    }
                    if (product == -1L) {//rejected by escape or close
                        jLabel2.setVisible(false);
                        Audio.play("Ring");
                    } else {//accepted
//                        Audio.play("Beep");
                    }
                    jTextField1.setText("");
                    jTextField1.requestFocus();
                } else {//request second scan
                    rs.close();
                    lastProduct = product;
                    jTextField1.setText("");
                    jLabel2.setText(bundle.getString("ScanTwice"));
                    jLabel2.setVisible(true);
                    jTextField1.requestFocus();
                    Audio.play("Ring");
                }
            }
            return true;
        } catch (SQLException ex) {
            Audio.play("Ring");
            Logger.getLogger(StartingStockEntry.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}