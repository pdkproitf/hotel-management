/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan;

import Objects.Phong_Cls;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author naruto
 */
public class ShowPhong extends javax.swing.JFrame {

    /**
     * Creates new form ShowPhong
     */
    Phong_Cls phong;
    String loi = "ok";
    Phong_Cls newPhong;
    int index, idPhong;
    quanlykhachsan qlks;

    public ShowPhong(Phong_Cls p, quanlykhachsan qlks) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.qlks = qlks;
        if (p != null) {
            for (int i = 0; i < constant_Cls.phongAray.size(); i++) {
                if (constant_Cls.phongAray.get(i).getId() == p.getId()) {
                    this.phong = constant_Cls.phongAray.get(i);
                    this.index = i;
                    idPhong = this.phong.getId();
                    break;
                }
            }
            this.lbName.setText("                              " + phong.getLoai() + phong.getSo());
            this.tfGia.setText(phong.getGia() + "");
            this.TfSo.setText(phong.getSo() + "");
            this.TfLoai.setText(phong.getLoai());
            this.tfSucChua.setText(phong.getSucchua() + "");
            //
            switch (phong.getTinhtrang()) {
                case "con trong":
                    this.CBTinhTrang.addItem("còn trống");
                    this.CBTinhTrang.addItem("có khách");
                    this.CBTinhTrang.addItem("bảo trì");
                    break;
                case "bao tri":
                    this.CBTinhTrang.addItem("bảo trì");
                    this.CBTinhTrang.addItem("còn trống");
                    this.CBTinhTrang.addItem("có khách");
                    break;
                default:
                    this.CBTinhTrang.addItem("có khách");
                    this.CBTinhTrang.addItem("còn trống");
                    this.CBTinhTrang.addItem("bảo trì");
            }
            //
            this.CBTinhTrang.setSelectedItem(phong.getTinhtrang());
            this.TfnguoiThue.setText(phong.getTenKhach());
            this.TfNguoiO.setText(phong.getSoNguoiO() + "");
        } else {
            String data = constant_Cls.GetOneDB("select * from(select p_id from phong_tbl order by p_id desc) where rownum < 2");
            idPhong = Integer.parseInt(data) + 1;
            this.TfnguoiThue.setEditable(false);
            this.TfNguoiO.setEditable(false);
            this.CBTinhTrang.addItem("còn trống");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CBTinhTrang = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TfSo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TfLoai = new javax.swing.JTextField();
        LbNguoiThue = new javax.swing.JLabel();
        TfnguoiThue = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfSucChua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TfNguoiO = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        BtDichVu = new javax.swing.JButton();
        lbThongBao = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lbName.setFont(new java.awt.Font("Edwardian Script ITC", 1, 24)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 255));
        lbName.setText("               <User Code>");

        jLabel2.setText("Tinh Trạng:");

        jLabel3.setText("Giá:");

        tfGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGiaActionPerformed(evt);
            }
        });

        jLabel4.setText("Số:");

        TfSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfSoActionPerformed(evt);
            }
        });

        jLabel5.setText("Loại:");

        TfLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfLoaiActionPerformed(evt);
            }
        });

        LbNguoiThue.setText("Người Thuê:");

        jLabel7.setText("Sức Chứa:");

        tfSucChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSucChuaActionPerformed(evt);
            }
        });

        jLabel8.setText("Số Người Ở:");

        TfNguoiO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfNguoiOActionPerformed(evt);
            }
        });

        jLabel10.setText("Save:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1447284064_badge_save.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Dịch Vụ:");

        BtDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Diagram.png"))); // NOI18N
        BtDichVu.setText("Dịch Vụ");

        lbThongBao.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel5))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(TfNguoiO))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfGia, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(TfnguoiThue, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(TfLoai)))))
                                    .addComponent(LbNguoiThue))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TfSo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtDichVu))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfSucChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfnguoiThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbNguoiThue)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TfNguoiO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(BtDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newPhong = new Phong_Cls();
        newPhong.setId(idPhong);
        TfLoaiActionPerformed(evt);
        TfNguoiOActionPerformed(evt);
        TfSoActionPerformed(evt);
        tfGiaActionPerformed(evt);
        tfSucChuaActionPerformed(evt);
        if (!this.loi.equals("ok")) {
            this.lbThongBao.setText((this.loi));//sau khi thong bao loi thi cho this.loi lai = "" de tiep tuc tim loi
            this.loi = "ok";
        } else {
            switch (this.CBTinhTrang.getSelectedItem().toString()) {
                case "còn trống":
                    newPhong.setTinhtrang("con trong");
                    break;
                case "bảo trì":
                    newPhong.setTinhtrang("bao tri");
                default:
                    newPhong.setTinhtrang(this.CBTinhTrang.getSelectedItem().toString());
            }

            this.lbThongBao.setText(this.loi);
            if (this.phong != null) {
                newPhong.setId_nguoithue(phong.getId_nguoithue());
                newPhong.setTenKhach(this.TfnguoiThue.getText());
                newPhong.setSoNguoiO(Integer.parseInt(this.TfNguoiO.getText()));
                //uadate vao mang va sau lun trong array khachhang
                constant_Cls.phongAray.set(index, newPhong);

                for (int i = 0; i < constant_Cls.khachAray.size(); i++) {
                    if (constant_Cls.khachAray.get(i).getId() == this.phong.getId()) {
                        constant_Cls.khachAray.get(i).setTen(this.TfnguoiThue.getText());
                        constant_Cls.khachAray.get(i).setSoNguoi(Integer.parseInt(this.TfNguoiO.getText()));
                    }
                }
                this.qlks.ShowPnQLP();
                this.qlks.show();
            } else {
                System.out.println("them phong");
                constant_Cls.phongAray.add(newPhong);
                this.qlks.ShowPnQLP();
                this.qlks.show();
            }

            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGiaActionPerformed
        String data = this.tfGia.getText();
        boolean fg = true;
        try {
            for (int i = 0; i < data.length(); i++) {
                if (Character.isLetter(data.charAt(i))) {
                    this.loi = "định dạng giá lỗi";
                    fg = false;
                    break;
                }
            }
            if (fg) {
                this.newPhong.setGia(Integer.parseInt(this.tfGia.getText()));
            }
        } catch (Exception e) {
            this.loi = "định dạng giá lỗi";
        }
    }//GEN-LAST:event_tfGiaActionPerformed

    private void tfSucChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSucChuaActionPerformed
        String data = this.tfSucChua.getText();
        boolean fg = true;
        try {
            for (int i = 0; i < data.length(); i++) {
                if (Character.isLetter(data.charAt(i))) {
                    this.loi = "định dạng sức chứa lỗi";
                    fg = false;
                    break;
                }
            }
            if (fg) {
                this.newPhong.setSucchua(Integer.parseInt(this.tfSucChua.getText()));
            }
        } catch (Exception e) {
            this.loi = "định dạng sức chứa lỗi";
        }
    }//GEN-LAST:event_tfSucChuaActionPerformed

    private void TfLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfLoaiActionPerformed
        try {
            if (!((64 < this.TfLoai.getText().hashCode() && this.TfLoai.getText().hashCode() < 91)
              || (123 > this.TfLoai.getText().hashCode() && this.TfLoai.getText().hashCode() > 96))) {
                loi = "định dạng loại k hợp lý ";
            } else {
                newPhong.setLoai(this.TfLoai.getText());
            }
        } catch (Exception e) {
            this.loi = "định dạng loại k hợp lý ";
        }
    }//GEN-LAST:event_TfLoaiActionPerformed

    private void TfSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfSoActionPerformed
        String data = this.TfSo.getText();
        boolean fg = true;
        try {
            for (int i = 0; i < data.length(); i++) {
                if (Character.isLetter(data.charAt(i))) {
                    this.loi = "định dạng số lỗi";
                    fg = false;
                    break;
                }
            }
            if (fg) {
                try {
                    int demTrung = 0;
                    for (int i = 0; i < constant_Cls.HashPhanLoai.get(newPhong.getLoai()).size(); i++) {
                        System.out.println(" loai " + newPhong.getLoai() + " so " + constant_Cls.HashPhanLoai.get(newPhong.getLoai()).get(i).getSo());
                        if (((constant_Cls.HashPhanLoai.get(newPhong.getLoai()).get(i).getId() != newPhong.getId())&&
                          constant_Cls.HashPhanLoai.get(newPhong.getLoai()).get(i).getSo() == Integer.parseInt(this.TfSo.getText()))) {
                            demTrung++;
                        }
                    }
                    System.out.println("dem trung " + demTrung);
                    if (fg && demTrung < 1) {
                        newPhong.setSo(Integer.parseInt(this.TfSo.getText()));
                    } else {
                        loi = "trùng số";
                    }
                } catch (Exception e) {
                    loi = "trùng số";
                }
            }
        } catch (Exception e) {
            this.loi = "định dạng số lỗi ..";
        }
    }//GEN-LAST:event_TfSoActionPerformed

    private void TfNguoiOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfNguoiOActionPerformed
        if (this.phong != null) {
            String data = this.TfNguoiO.getText();
            boolean fg = true;
            try {
                for (int i = 0; i < data.length(); i++) {
                    if (Character.isLetter(data.charAt(i))) {
                        this.loi = "định dạng người ở lỗi";
                        fg = false;
                        break;
                    }
                }
                if (fg) {
                    newPhong.setSo(Integer.parseInt(this.TfSo.getText()));
                }
            } catch (Exception e) {
                this.loi = "định dạng người ở lỗi";
            }
        }
    }//GEN-LAST:event_TfNguoiOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtDichVu;
    private javax.swing.JComboBox CBTinhTrang;
    private javax.swing.JLabel LbNguoiThue;
    private javax.swing.JTextField TfLoai;
    private javax.swing.JTextField TfNguoiO;
    private javax.swing.JTextField TfSo;
    private javax.swing.JTextField TfnguoiThue;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfSucChua;
    // End of variables declaration//GEN-END:variables
}
