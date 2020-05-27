/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvtelecom10.sotore.frames;

import java.sql.*;
import br.com.mvtelecom10.sotore.conection.ConnectionModule;
import java.awt.Container;
import javax.swing.JOptionPane;

/**
 *
 * @author mv
 */
public class UserScreen extends javax.swing.JInternalFrame {

    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Creates new form UserScreen
     */
    public UserScreen() {
        initComponents();
        c = ConnectionModule.connection();
    }

    private void search() {
        String sql = "SELECT * FROM tbusers WHERE idtbusuarios = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txt_userscreen_id.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txt_userscreen_name.setText(rs.getString(2));
                txt_userscreen_fone.setText(rs.getString(3));
                txt_userscreen_login.setText(rs.getString(4));
                txt_userscreen_password.setText(rs.getString(5));
                cbo_userscreen_profile.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                txt_userscreen_name.setText(null);
                txt_userscreen_fone.setText(null);
                txt_userscreen_login.setText(null);
                txt_userscreen_password.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void add_user() {
        String sql = "INSERT INTO `tbusers` (`idtbusuarios`, `usuario`, `fone`, `login`, `password`, `user_profile`) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txt_userscreen_id.getText());
            ps.setString(2, txt_userscreen_name.getText());
            ps.setString(3, txt_userscreen_fone.getText());
            ps.setString(4, txt_userscreen_login.getText());
            ps.setString(5, txt_userscreen_password.getText());
            ps.setString(6, cbo_userscreen_profile.getSelectedItem().toString());
            int add_user = ps.executeUpdate();
            if (add_user > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                txt_userscreen_name.setText(null);
                txt_userscreen_fone.setText(null);
                txt_userscreen_login.setText(null);
                txt_userscreen_password.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void edit() {
        String sql = "UPDATE `tbusers` SET `usuario` = ?, `fone` = ?, `login` = ?, `password` = ?, `user_profile` = ? WHERE `tbusers`.`idtbusuarios` = ?;";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txt_userscreen_name.getText());
            ps.setString(2, txt_userscreen_fone.getText());
            ps.setString(3, txt_userscreen_login.getText());
            ps.setString(4, txt_userscreen_password.getText());
            ps.setString(5, cbo_userscreen_profile.getSelectedItem().toString());
            ps.setString(6, txt_userscreen_id.getText());
            System.out.println(ps);
            int edit_user = ps.executeUpdate();
            if (edit_user > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                txt_userscreen_name.setText(null);
                txt_userscreen_fone.setText(null);
                txt_userscreen_login.setText(null);
                txt_userscreen_password.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void delete_user() {
        int delete = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (delete == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM `tbusers` WHERE `tbusers`.`idtbusuarios` = ?";
            try {
                ps = c.prepareStatement(sql);

                ps.setString(1, txt_userscreen_id.getText());
                int edit_user = ps.executeUpdate();
                if (edit_user > 0) {
                    JOptionPane.showMessageDialog(null, "Removido com sucesso");
                    txt_userscreen_name.setText(null);
                    txt_userscreen_fone.setText(null);
                    txt_userscreen_login.setText(null);
                    txt_userscreen_password.setText(null);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_userscreen_name = new javax.swing.JTextField();
        txt_userscreen_login = new javax.swing.JTextField();
        cbo_userscreen_profile = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_userscreen_fone = new javax.swing.JTextField();
        btn_userscreen_add = new javax.swing.JButton();
        btn_userscreen_search = new javax.swing.JButton();
        btn_userscreen_edit = new javax.swing.JButton();
        btn_userscreen_delete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_userscreen_id = new javax.swing.JTextField();
        txt_userscreen_password = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setText("Nome");

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        jLabel4.setText("Perfil");

        cbo_userscreen_profile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "adm", "user" }));

        jLabel5.setText("Fone");

        btn_userscreen_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mvtelecom10/sotore/icons/add64.png"))); // NOI18N
        btn_userscreen_add.setToolTipText("Adicionar");
        btn_userscreen_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_userscreen_add.setPreferredSize(new java.awt.Dimension(80, 80));
        btn_userscreen_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userscreen_addActionPerformed(evt);
            }
        });

        btn_userscreen_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mvtelecom10/sotore/icons/search64.png"))); // NOI18N
        btn_userscreen_search.setToolTipText("Consultar");
        btn_userscreen_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_userscreen_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userscreen_searchActionPerformed(evt);
            }
        });

        btn_userscreen_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mvtelecom10/sotore/icons/edit64.png"))); // NOI18N
        btn_userscreen_edit.setToolTipText("Editar");
        btn_userscreen_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_userscreen_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userscreen_editActionPerformed(evt);
            }
        });

        btn_userscreen_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mvtelecom10/sotore/icons/delet64.png"))); // NOI18N
        btn_userscreen_delete.setToolTipText("Deletar");
        btn_userscreen_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_userscreen_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userscreen_deleteActionPerformed(evt);
            }
        });

        jLabel6.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btn_userscreen_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btn_userscreen_search)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_userscreen_login))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbo_userscreen_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_userscreen_edit)
                                        .addGap(44, 44, 44)
                                        .addComponent(btn_userscreen_delete)))
                                .addGap(0, 187, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_userscreen_name)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_userscreen_password, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_userscreen_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(txt_userscreen_fone, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(157, 157, 157))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_userscreen_add, btn_userscreen_delete, btn_userscreen_edit, btn_userscreen_search});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_userscreen_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_userscreen_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_userscreen_fone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_userscreen_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cbo_userscreen_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_userscreen_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_userscreen_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_userscreen_search)
                    .addComponent(btn_userscreen_edit)
                    .addComponent(btn_userscreen_delete))
                .addGap(26, 26, 26))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_userscreen_add, btn_userscreen_delete, btn_userscreen_edit, btn_userscreen_search});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_userscreen_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userscreen_searchActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_btn_userscreen_searchActionPerformed

    private void btn_userscreen_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userscreen_addActionPerformed
        // TODO add your handling code here:
        add_user();

    }//GEN-LAST:event_btn_userscreen_addActionPerformed

    private void btn_userscreen_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userscreen_editActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_btn_userscreen_editActionPerformed

    private void btn_userscreen_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userscreen_deleteActionPerformed
        // TODO add your handling code here:
        delete_user();
    }//GEN-LAST:event_btn_userscreen_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_userscreen_add;
    private javax.swing.JButton btn_userscreen_delete;
    private javax.swing.JButton btn_userscreen_edit;
    private javax.swing.JButton btn_userscreen_search;
    private javax.swing.JComboBox<String> cbo_userscreen_profile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_userscreen_fone;
    private javax.swing.JTextField txt_userscreen_id;
    private javax.swing.JTextField txt_userscreen_login;
    private javax.swing.JTextField txt_userscreen_name;
    private javax.swing.JTextField txt_userscreen_password;
    // End of variables declaration//GEN-END:variables
}
