/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.gudang.lapar.chicken;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author habib
 */
public class transaksi extends javax.swing.JFrame {
DefaultTableModel model;
SimpleDateFormat tglFormat = new SimpleDateFormat("yyyy-MM-dd");
private Map<String, String> satuanBarangMap = new HashMap<>();
private String idBarangResult;

    public transaksi() {
    initComponents();
    loadComboBarang();
    loadComboPemasok();

        String[] judul = {"Id_transaksi","id_barang","id_pemasok", "jumlah", "satuan_barang", "jenis_transaksi", "waktu_transaksi"};
        model = new DefaultTableModel(judul, 0);
        jTable1.setModel(model);
        tampilkan();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelMouseClicked(evt);
        }

            private void tabelMouseClicked(MouseEvent evt) {
                int selectedRow = jTable1.getSelectedRow();

    if (selectedRow != -1) {
        // Mengambil nilai dari tabel yang diklik
        String idTransaksi = jTable1.getValueAt(selectedRow, 0).toString();
        String idBarang = jTable1.getValueAt(selectedRow, 1).toString();
        String idPemasok = jTable1.getValueAt(selectedRow, 2).toString();
        String jumlah = jTable1.getValueAt(selectedRow, 3).toString();
        String satuan = jTable1.getValueAt(selectedRow, 4).toString();
        String jenisTransaksi = jTable1.getValueAt(selectedRow, 5).toString();
        String waktuTransaksi = jTable1.getValueAt(selectedRow, 6).toString();

        // Mengisi formulir input dengan nilai dari tabel yang diklik
        comboBarang.setSelectedItem(idBarang);
        comboPemasok.setSelectedItem(idPemasok);
        comboMK.setSelectedItem(jenisTransaksi);
        textJumlah.setText(jumlah);
        textSatuan.setText(satuan);
        textIdBarang.setText(idBarang);
        textIdPemasok.setText(idPemasok);

        // Mengubah format tanggal dari String ke java.util.Date
        try {
            java.util.Date date = tglFormat.parse(waktuTransaksi);
            dateTransaksi.setDate(date);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
    });
    
        comboBarang.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboBarangActionPerformed(evt);
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonSimpan = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        comboMK = new javax.swing.JComboBox<>();
        textJumlah = new javax.swing.JTextField();
        dateTransaksi = new com.toedter.calendar.JDateChooser();
        buttonHapus = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();
        textSatuan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBarang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelBarang = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboPemasok = new javax.swing.JComboBox<>();
        textIdBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textIdPemasok = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Halaman Transaksi Masuk Keluar Barang");

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        comboMK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masuk", "Keluar" }));
        comboMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMKActionPerformed(evt);
            }
        });

        textJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJumlahActionPerformed(evt);
            }
        });

        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonKeluar.setText("Keluar");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        textSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSatuanActionPerformed(evt);
            }
        });

        jLabel2.setText("Jenis Transaksi");

        jLabel3.setText("Jumlah");

        comboBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBarangActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Satuan Barang");

        jLabel6.setText("Tanggal");

        labelBarang.setText("Id_Barang");

        jLabel7.setText("Nama Pemasok");

        comboPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPemasokActionPerformed(evt);
            }
        });

        jLabel8.setText("Id_Pemasok");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(comboMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comboBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelBarang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textIdPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(buttonKeluar)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(comboPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(dateTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEdit)
                        .addGap(18, 18, 18)
                        .addComponent(buttonHapus)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textIdPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBarang)
                            .addComponent(textIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSimpan)
                            .addComponent(buttonEdit)
                            .addComponent(buttonHapus)
                            .addComponent(buttonKeluar))
                        .addGap(0, 15, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textJumlahActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
    new beranda().setVisible(true);//membuka kembali halaman utama
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
    try {
    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gudang_lapar", "root", "");

    // Mendapatkan nilai dari form
    String idBarang = comboBarang.getSelectedItem().toString();
    String jenisTransaksi = comboMK.getSelectedItem().toString();
    int jumlah = Integer.parseInt(textJumlah.getText());
    String satuan = textSatuan.getText();
    
    String tanggal = tglFormat.format(dateTransaksi.getDate());

    // Query untuk mendapatkan id_barang dan id_pemasok berdasarkan nama_barang dan nama_pemasok
    String queryBarang = "SELECT id_barang FROM tbarang WHERE nama_barang=?";
    String queryPemasok = "SELECT id_pemasok FROM tpemasok WHERE nama_pemasok=?";
    
    try (PreparedStatement psBarang = cn.prepareStatement(queryBarang);
         PreparedStatement psPemasok = cn.prepareStatement(queryPemasok)) {

        // Mendapatkan id_barang
        psBarang.setString(1, idBarang);
        ResultSet rsBarang = psBarang.executeQuery();

        if (rsBarang.next()) {
            String idBarangResult = rsBarang.getString("id_barang");

            // Mendapatkan id_pemasok
            psPemasok.setString(1, comboPemasok.getSelectedItem().toString());
            ResultSet rsPemasok = psPemasok.executeQuery();

            if (rsPemasok.next()) {
                String idPemasok = rsPemasok.getString("id_pemasok");

                // Query untuk menyimpan data transaksi
                String querySimpan = "INSERT INTO ttransaksi (id_barang, id_pemasok, jumlah, satuan_barang, jenis_transaksi, waktu_transaksi) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement psSimpan = cn.prepareStatement(querySimpan)) {
                    psSimpan.setString(1, idBarangResult);
                    psSimpan.setString(2, idPemasok);
                    psSimpan.setInt(3, jumlah);
                    psSimpan.setString(4, satuan);
                    psSimpan.setString(5, jenisTransaksi);
                    psSimpan.setString(6, tanggal);

                    // Melakukan penyimpanan data transaksi
                    int hasilSimpan = psSimpan.executeUpdate();

                    if (hasilSimpan > 0) {
                        JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan");
                        tampilkan(); // Memperbarui tampilan tabel
                    } else {
                        JOptionPane.showMessageDialog(this, "Data transaksi gagal disimpan");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Data pemasok tidak ditemukan");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data barang tidak ditemukan");
        }
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + ex.getMessage());
    Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
    int selectedRow = jTable1.getSelectedRow();

    if (selectedRow != -1) {
        // Mendapatkan nilai dari tabel yang dipilih
        String idTransaksi = jTable1.getValueAt(selectedRow, 0).toString();
        String idBarang = textIdBarang.getText(); // Menggunakan idBarang dari textfield
        String idPemasok = textIdPemasok.getText(); // Menggunakan idPemasok dari textfield
        String jumlah = textJumlah.getText();
        String satuan = textSatuan.getText();
        String jenisTransaksi = comboMK.getSelectedItem().toString();
        String tanggal = tglFormat.format(dateTransaksi.getDate());

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gudang_lapar", "root", "");

            // Query untuk update data transaksi
            String queryUpdate = "UPDATE ttransaksi SET id_barang=?, id_pemasok=?, jumlah=?, satuan_barang=?, jenis_transaksi=?, waktu_transaksi=? WHERE id_transaksi=?";
            try (PreparedStatement psUpdate = cn.prepareStatement(queryUpdate)) {
                psUpdate.setString(1, idBarang);
                psUpdate.setString(2, idPemasok);
                psUpdate.setInt(3, Integer.parseInt(jumlah));
                psUpdate.setString(4, satuan);
                psUpdate.setString(5, jenisTransaksi);
                psUpdate.setString(6, tanggal);
                psUpdate.setString(7, idTransaksi);

                // Melakukan update data transaksi
                int hasilUpdate = psUpdate.executeUpdate();

                if (hasilUpdate > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate");
                    tampilkan(); // Memperbarui tampilan tabel
                    resetForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Data transaksi gagal diupdate");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + ex.getMessage());
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan diedit");
    }    // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
    int selectedRow = jTable1.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String idTransaksi = jTable1.getValueAt(selectedRow, 0).toString();

            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gudang_lapar", "root", "");
                
                // Query untuk menghapus data transaksi berdasarkan id_transaksi
                String queryHapus = "DELETE FROM ttransaksi WHERE id_transaksi=?";
                try (PreparedStatement psHapus = cn.prepareStatement(queryHapus)) {
                    psHapus.setString(1, idTransaksi);
                    
                    // Melakukan penghapusan data transaksi
                    int hasilHapus = psHapus.executeUpdate();

                    if (hasilHapus > 0) {
                        JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus");
                        tampilkan(); // Memperbarui tampilan tabel
                        resetForm();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data transaksi gagal dihapus");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + ex.getMessage());
                Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
    }    // TODO add your handling code here:
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void comboBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBarangActionPerformed
    String selectedBarang = comboBarang.getSelectedItem().toString();
    if (satuanBarangMap.containsKey(selectedBarang)) {
        textSatuan.setText(satuanBarangMap.get(selectedBarang));

        // Mengisi textIdBarang berdasarkan nama_barang yang dipilih
        fillIdBarang(selectedBarang);
    }
    }//GEN-LAST:event_comboBarangActionPerformed

    private void comboMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMKActionPerformed

    private void comboPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPemasokActionPerformed
    String selectedPemasok = comboPemasok.getSelectedItem().toString();
    fillIdPemasok(selectedPemasok);
    // TODO add your handling code here:
    }//GEN-LAST:event_comboPemasokActionPerformed

    private void textSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSatuanActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboBarang;
    private javax.swing.JComboBox<String> comboMK;
    private javax.swing.JComboBox<String> comboPemasok;
    private com.toedter.calendar.JDateChooser dateTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelBarang;
    private javax.swing.JTextField textIdBarang;
    private javax.swing.JTextField textIdPemasok;
    private javax.swing.JTextField textJumlah;
    private javax.swing.JTextField textSatuan;
    // End of variables declaration//GEN-END:variables
private void tampilkan() {
try {
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gudang_lapar", "root", "");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Menghapus baris yang sudah ada

        ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM ttransaksi");

        while (rs.next()) {
            String data[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
            model.addRow(data);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + ex.getMessage());
        Logger.getLogger(barang.class.getName()).log(Level.SEVERE, null, ex);
    }
}
private void loadComboBarang () {
     try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gudang_lapar", "root", "");
        String query = "SELECT nama_barang, satuan_barang FROM tbarang";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String namaBarang = resultSet.getString("nama_barang");
                String satuanBarang = resultSet.getString("satuan_barang");
                comboBarang.addItem(namaBarang);
                satuanBarangMap.put(namaBarang, satuanBarang);
            }

            // Close resources
            resultSet.close();
        }

        // Close resources
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
 private void loadComboPemasok() {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gudang_lapar", "root", "");
        String query = "SELECT nama_pemasok FROM tpemasok";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String namaPemasok = resultSet.getString("nama_pemasok");
                comboPemasok.addItem(namaPemasok);
                // Tambahkan data ke dalam peta untuk mengakses ID pemasok jika diperlukan
                // Contoh: pemasokMap.put(namaPemasok, idPemasok);
            }

            // Close resources
            resultSet.close();
        }

        // Close resources
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
 private void fillIdBarang(String namaBarang) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gudang_lapar", "root", "");
        String query = "SELECT id_barang FROM tbarang WHERE nama_barang=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaBarang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String idBarang = resultSet.getString("id_barang");
                textIdBarang.setText(idBarang);
            }

            // Close resources
            resultSet.close();
        }

        // Close resources
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void fillIdPemasok(String namaPemasok) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gudang_lapar", "root", "");
        String query = "SELECT id_pemasok FROM tpemasok WHERE nama_pemasok=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaPemasok);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String idPemasok = resultSet.getString("id_pemasok");
                textIdPemasok.setText(idPemasok);
            }

            // Close resources
            resultSet.close();
        }

        // Close resources
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void resetForm() {
    textIdBarang.setText("");
    textIdPemasok.setText("");
    textJumlah.setText("");
    textSatuan.setText("");
    comboMK.setSelectedIndex(0);
    dateTransaksi.setDate(null);
}
}
