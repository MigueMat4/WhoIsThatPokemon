/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.*;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Matul <https://github.com/MigueMat4>
 */
public class frmMain extends javax.swing.JFrame {
    
    Pokemon whoIsThatPokemon1; // objeto 1 de la clase Pokemon que hará match con lo descargado de la API
    Pokemon whoIsThatPokemon2; // objeto 2 de la clase Pokemon que hará match con lo descargado de la API
    Pokemon whoIsThatPokemon3; // objeto 3 de la clase Pokemon que hará match con lo descargado de la API
    Pokemon whoIsThatPokemon4; // objeto 4 de la clase Pokemon que hará match con lo descargado de la API
    Pokemon chosen_pokemon; // Pokemon elegido por el juego
    Pokedex dexter = new Pokedex(); // clase que conecta a la API
    PokeViewer visor = new PokeViewer(); // hilo que mostrará los sprites del Pokemon
    Reloj horaActual = new Reloj(); // hilo que muestra la hora del sistema
    Organizer myThread; // hilo que se encargará de buscar al Pokemon en la API pública

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        btnPokemon1.setEnabled(false);
        btnPokemon2.setEnabled(false);
        btnPokemon3.setEnabled(false);
        btnPokemon4.setEnabled(false);
        horaActual.start();
        visor.start();
    }
    
    public class PokeViewer extends Thread{
        
        @Override
        public void run() {
            while (true) {
                if (chosen_pokemon != null){
                    try {
                        while(true) {
                            lblSprite.setText("");
                            // obtengo la url del listado de cada uno de los sprites que me dio la API
                            URL url = new URL(chosen_pokemon.getSprites().get("front_default").toString());
                            Image img = ImageIO.read(url);
                            lblSprite.setIcon(new ImageIcon(img));
                            // 1 segundo para cada cambio de sprite
                            Thread.sleep(1000);
                        
                            url = new URL(chosen_pokemon.getSprites().get("back_default").toString());
                            img = ImageIO.read(url);
                            lblSprite.setIcon(new ImageIcon(img));
                            Thread.sleep(1000);
                        }
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException | IOException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    lblSprite.setText("?");
                    btnPokemon1.setText("???");
                    btnPokemon2.setText("???");
                    btnPokemon3.setText("???");
                    btnPokemon4.setText("???");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public class Organizer extends Thread {
        
        @Override
        public void run() {
            btnJugar.setEnabled(false);
            try {
                // obtener los 4 pokemon de la API
                whoIsThatPokemon1 = dexter.buscarPokemon();
                whoIsThatPokemon2 = dexter.buscarPokemon();
                whoIsThatPokemon3 = dexter.buscarPokemon();
                whoIsThatPokemon4 = dexter.buscarPokemon();
                btnPokemon1.setText(whoIsThatPokemon1.getName());
                btnPokemon2.setText(whoIsThatPokemon2.getName());
                btnPokemon3.setText(whoIsThatPokemon3.getName());
                btnPokemon4.setText(whoIsThatPokemon4.getName());
                // elegir aleatoriamente un pokemon de los 4
                chosen_pokemon = new Pokemon();
                int random = (int)(Math.random() * 4 + 1);
                switch (random) {
                    case 1:
                        chosen_pokemon = whoIsThatPokemon1;
                        break;
                    case 2:
                        chosen_pokemon = whoIsThatPokemon2;
                        break;
                    case 3:
                        chosen_pokemon = whoIsThatPokemon3;
                        break;
                    default:
                        chosen_pokemon = whoIsThatPokemon4;
                        break;
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnPokemon1.setEnabled(true);
            btnPokemon2.setEnabled(true);
            btnPokemon3.setEnabled(true);
            btnPokemon4.setEnabled(true);
            btnJugar.setEnabled(true);
            btnJugar.setText("Jugar de nuevo");
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

        lblSprite = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPokemon1 = new javax.swing.JButton();
        btnPokemon2 = new javax.swing.JButton();
        btnPokemon3 = new javax.swing.JButton();
        btnPokemon4 = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        lblHoraSistema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSprite.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblSprite.setText("?");

        btnPokemon1.setText("???");
        btnPokemon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon1ActionPerformed(evt);
            }
        });

        btnPokemon2.setText("???");
        btnPokemon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon2ActionPerformed(evt);
            }
        });

        btnPokemon3.setText("???");
        btnPokemon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon3ActionPerformed(evt);
            }
        });

        btnPokemon4.setText("???");
        btnPokemon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokemon4ActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        lblHoraSistema.setText("Hora sistema");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPokemon4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPokemon3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPokemon2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHoraSistema)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSprite)
                                .addGap(148, 148, 148)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHoraSistema)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSprite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPokemon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPokemon2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPokemon3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPokemon4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        myThread = new Organizer();
        myThread.start();
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnPokemon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon1ActionPerformed
        // Si adivina el Pokemon:
        if (chosen_pokemon.getName().equals(btnPokemon1.getText()))
            JOptionPane.showMessageDialog(null, "Felicidades, ¡Ganaste!");
        else
            JOptionPane.showMessageDialog(null, "Incorrecto :(");
        btnPokemon1.setEnabled(false);
        btnPokemon2.setEnabled(false);
        btnPokemon3.setEnabled(false);
        btnPokemon4.setEnabled(false);
    }//GEN-LAST:event_btnPokemon1ActionPerformed

    private void btnPokemon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon2ActionPerformed
        // TODO add your handling code here:
        if (chosen_pokemon.getName().equals(btnPokemon2.getText()))
            JOptionPane.showMessageDialog(null, "Felicidades, ¡Ganaste!");
        else
            JOptionPane.showMessageDialog(null, "Incorrecto :(");
        btnPokemon1.setEnabled(false);
        btnPokemon2.setEnabled(false);
        btnPokemon3.setEnabled(false);
        btnPokemon4.setEnabled(false);
    }//GEN-LAST:event_btnPokemon2ActionPerformed

    private void btnPokemon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon3ActionPerformed
        // TODO add your handling code here:
        if (chosen_pokemon.getName().equals(btnPokemon3.getText()))
            JOptionPane.showMessageDialog(null, "Felicidades, ¡Ganaste!");
        else
            JOptionPane.showMessageDialog(null, "Incorrecto :(");
        btnPokemon1.setEnabled(false);
        btnPokemon2.setEnabled(false);
        btnPokemon3.setEnabled(false);
        btnPokemon4.setEnabled(false);
    }//GEN-LAST:event_btnPokemon3ActionPerformed

    private void btnPokemon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokemon4ActionPerformed
        // TODO add your handling code here:
        if (chosen_pokemon.getName().equals(btnPokemon4.getText()))
            JOptionPane.showMessageDialog(null, "Felicidades, ¡Ganaste!");
        else
            JOptionPane.showMessageDialog(null, "Incorrecto :(");
        btnPokemon1.setEnabled(false);
        btnPokemon2.setEnabled(false);
        btnPokemon3.setEnabled(false);
        btnPokemon4.setEnabled(false);
    }//GEN-LAST:event_btnPokemon4ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    
    // clase para la hora del sistema. ¡No modificar!
    public class Reloj extends Thread {
        Calendar calendario;
        
        @Override
        public void run() {
            while (true) {
                String horaSistema = "";
                calendario = Calendar.getInstance();
                if (calendario.get(Calendar.HOUR_OF_DAY)<10)
                    horaSistema += String.valueOf("0"+calendario.get(Calendar.HOUR_OF_DAY)) + ":";
                else
                    horaSistema += String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)) + ":";
                if (calendario.get(Calendar.MINUTE)<10)
                    horaSistema += String.valueOf("0"+calendario.get(Calendar.MINUTE)) + ":";
                else
                    horaSistema += String.valueOf(calendario.get(Calendar.MINUTE)) + ":";
                if (calendario.get(Calendar.SECOND)<10)
                    horaSistema += String.valueOf("0"+calendario.get(Calendar.SECOND)) + ":";
                else
                    horaSistema += String.valueOf(calendario.get(Calendar.SECOND)) + ":";
                horaSistema += String.valueOf(calendario.get(Calendar.MILLISECOND)) + " hrs";
                lblHoraSistema.setText(horaSistema);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnPokemon1;
    private javax.swing.JButton btnPokemon2;
    private javax.swing.JButton btnPokemon3;
    private javax.swing.JButton btnPokemon4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHoraSistema;
    private javax.swing.JLabel lblSprite;
    // End of variables declaration//GEN-END:variables
}
