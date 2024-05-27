
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EREN
 */
public class vericekme extends javax.swing.JFrame {

    /**
     * Creates new form vericekme
     */
    public vericekme() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        jMenuItem1.setText("SİL");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Tüm verileri listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Dersten geçenleri listele");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cinsiyete göre lislele");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Erkek");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Kadın");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Connection baglantiGetir()
    {
        Connection con;
        con = null;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Bağlantı nesnesi
            String strdatabase = "jdbc:ucanaccess://C:\\Users\\EREN\\Documents\\NetBeansProjects\\veritabani\\Database2.accdb"; //veritabanının ismi
            con = DriverManager.getConnection(strdatabase); //Access-java bağlantısnı sağlayan jdbc sürücüsü ile bağlantı oluşturuluyor
            System.out.println(con);
        }
        catch(Exception e)
        {        
            System.out.println("bağlantı hatası");
            JOptionPane.showMessageDialog(null, e.toString(), "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
        }
		return con;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            Connection con=baglantiGetir();
            Statement stmt =con.createStatement();
            
            ResultSet rs= stmt.executeQuery("SELECT COUNT(*) AS satirsayi FROM KISILER");
            rs.next();
            
            int icount = rs.getInt("satirsayi");
            
            rs.close();
            
            rs=stmt.executeQuery("SELECT * FROM KISILER");
            
            con.close();
            stmt.close();
            
            Object[][] obj = new Object[icount][4];
            
            int sayac=0;
            while(rs.next()){
                obj[sayac][0]=rs.getString("AD");
                obj[sayac][1]= rs.getString("SOYAD");
                obj[sayac][2]= rs.getString("CINSIYET");
                obj[sayac][3]= rs.getString("ORTALAMA");
                sayac++;
            }
            
            String[] tablobaslik= new String[]{"AD","SOYAD","CINSIYET","ORTALAMA"};
            jTable1.setModel(new DefaultTableModel(obj,tablobaslik));
            
                   
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex.toString());
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            Connection con = baglantiGetir();
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS satirsayi FROM KISILER where ORTALAMA >"+50);
            
            rs.next();
            
            int icount= rs.getInt("satirsayi");
            rs.close();
            
            rs=stmt.executeQuery("SELECT * FROM KISILER where ORTALAMA >"+50);
            con.close();
            //stmt.close();
            
            
            Object[][] obj = new Object[icount][4];
            int sayac=0;
            while(rs.next()){
                obj[sayac][0]=rs.getString("AD");
                obj[sayac][1]= rs.getString("SOYAD");
                obj[sayac][2]= rs.getString("CINSIYET");
                obj[sayac][3]= rs.getString("ORTALAMA");
                sayac++;
            }
            
            String[] tablobaslik= new String[]{"AD","SOYAD","CINSIYET","ORTALAMA"};
            jTable1.setModel(new DefaultTableModel(obj,tablobaslik));
        } catch (SQLException ex) {
            Logger.getLogger(vericekme.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Connection con = baglantiGetir();
            Statement stmt = con.createStatement();
            
            String cinsiyetFiltrele ;
            if(jRadioButton1.isSelected()){
                cinsiyetFiltrele="Erkek";
            }
            else{
                cinsiyetFiltrele="Kadın";
            }
            
            ResultSet rs= stmt.executeQuery("SELECT COUNT(*) AS satirsayi FROM KISILER where CINSIYET = '"+cinsiyetFiltrele +"'");
            
            rs.next();
            
            int icount = rs.getInt("satirsayi");
            rs.close();
            
            rs=stmt.executeQuery("SELECT * FROM KISILER where CINSIYET ='"+cinsiyetFiltrele+"'");
            
            Object[][] obj = new Object[icount][4];
            int sayac=0;
            while(rs.next()){
                obj[sayac][0]=rs.getString("AD");
                obj[sayac][1]= rs.getString("SOYAD");
                obj[sayac][2]= rs.getString("CINSIYET");
                obj[sayac][3]= rs.getString("ORTALAMA");
                sayac++;
            }
            String []tabloBaslik = new String[]{"AD","SOYAD","CINSIYET","ORTALAMA"};
            jTable1.setModel(new  DefaultTableModel(obj,tabloBaslik));
            
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(vericekme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vericekme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vericekme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vericekme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vericekme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vericekme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
