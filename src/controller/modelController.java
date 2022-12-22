/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import tampilan.view;
import Connection.KoneksiDatabase;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import login.NewJFrame;



/**
 *
 * @author sarna
 */
public class modelController extends connection {
    private connection model;
    view input = new view();
    KoneksiDatabase conn = new KoneksiDatabase();
    public void setLogin(connection model) {
        this.model = model;
    }
    
    public void cek(NewJFrame tenjo) throws SQLException{
        String username = tenjo.getGetUser().getText();
        String pass = tenjo.getGetPass().getText();
        String query = "SELECT * FROM admin WHERE username = '" + username + "'";

        conn.statement = conn.connection.createStatement();
        ResultSet rs = conn.statement.executeQuery(query);

        if (rs.next()) {
            if (username.equals(rs.getString("username")) && pass.equals(rs.getString("Password"))) {
                JOptionPane.showMessageDialog(tenjo, "Login berhasil");               
                input.dispose();
                view J = new view();
                J.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(tenjo, "Email atau password salah");
            }
        }
    
    }
    
    public void cekLogin(NewJFrame view) throws SQLException {
        try {
            String email = view.getGetUser().getText();
            String pass = view.getGetPass().getText();

            if (email.trim().equals("") || pass.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Email atau Password tidak boleh kosong");
            } else {
                cek(view);
            }
        } catch (HeadlessException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
}