/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan;

import Objects.KhachHang_cls;
import Objects.Phong_Cls;
import Objects.NhanVien_Cls;
import Objects.DichVu_cls;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author naruto
 */
public class quanlykhachsan extends javax.swing.JFrame {

    /**
     * Creates new form MainForm_cls
     */
    Vector<Vector> hang = new Vector<Vector>();//dung chua dữ liệu load lên bảng
    CardLayout cl;

    public quanlykhachsan() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);//không cho phóng to

        this.PnHienThi.setLayout(cl = new CardLayout());
        PnHienThi.add("QLNV", PnQLNV);
        PnHienThi.add("QLP", PnQLP);
        PnHienThi.add("QLKH", PNQLKH);
        PnHienThi.add("QLDV", PnQLDV);
        ShowPnQLDV();
        ShowPnQLKH();
        ShowPnQLP();
        ShowPnQLNV();
        constant_Cls.cfLoad = false;
        this.setVisible(true);
    }

    private void ShowPnQLNV() {
        this.cl.show(PnHienThi, "QLNV");
        if (constant_Cls.cfLoad) {
            constant_Cls.GetNhanvienDB();
        }
        Vector<Object> cl[] = new Vector[constant_Cls.nhanVienAray.size()];
        for (int i = 0; i < constant_Cls.nhanVienAray.size(); i++) {
            cl[i] = new Vector();
        }
        for (int i = 0; i < constant_Cls.nhanVienAray.size(); i++) {
            NhanVien_Cls nv = constant_Cls.nhanVienAray.get(i);
            cl[i].add(i + 1);
            cl[i].add(nv.getId());
            cl[i].add(nv.getTen());
            cl[i].add(nv.getGioiTinh());
            cl[i].add(constant_Cls.formatTime.format(nv.getNamSinh()));
            cl[i].add(nv.getSdt());
            cl[i].add(nv.getDiaChi());
            cl[i].add(nv.getCongViec());
        }
        hang.removeAllElements();
        for (int i = 0; i < constant_Cls.nhanVienAray.size(); i++) {
            hang.addElement(cl[i]);
        }
        hienThiThongTin(this.TbQLSV, constant_Cls.ColumNv());
    }

    private void ShowPnQLKH() {
        this.cl.show(PnHienThi, "QLKH");
        if (constant_Cls.cfLoad) {
            constant_Cls.GetKhachHangDB();
        }
        Vector<Object> cl[] = new Vector[constant_Cls.khachAray.size()];
        for (int i = 0; i < constant_Cls.khachAray.size(); i++) {
            cl[i] = new Vector();
        }
        for (int i = 0; i < constant_Cls.khachAray.size(); i++) {
            KhachHang_cls nv = constant_Cls.khachAray.get(i);
            cl[i].add(i + 1);
            cl[i].add(nv.getId());
            cl[i].add(nv.getTen());
            cl[i].add(nv.getGioiTinh());
            cl[i].add(nv.getCmnn());
            cl[i].add(nv.getDienthoai());
            cl[i].add(nv.getPhongThue());
            cl[i].add(nv.getSoNguoi());
            cl[i].add(nv.getNgayDen() != null ? constant_Cls.formatTime.format(nv.getNgayDen()) : null);
            cl[i].add(nv.getNgayDi() != null ? constant_Cls.formatTime.format(nv.getNgayDi()) : null);
            cl[i].add(nv.getTinhTrang());
            System.out.println("id  = " + nv.getId() + " size " + constant_Cls.khachAray.size());
        }
        hang.removeAllElements();//lam moi lai vector hang
        for (int i = 0; i < constant_Cls.khachAray.size(); i++) {
            hang.addElement(cl[i]);
        }
        hienThiThongTin(this.TbQLKH, constant_Cls.ColumKh());
    }

    private void ShowPnQLDV() {
        this.cl.show(PnHienThi, "QLDV");
        if (constant_Cls.cfLoad) {
            constant_Cls.GetDichVuDB();
        }
        Vector<Object> cl[] = new Vector[constant_Cls.dichVuAray.size()];
        for (int i = 0; i < constant_Cls.dichVuAray.size(); i++) {
            cl[i] = new Vector();
        }
        for (int i = 0; i < constant_Cls.dichVuAray.size(); i++) {
            DichVu_cls nv = constant_Cls.dichVuAray.get(i);
            cl[i].add(i + 1);
            cl[i].add(nv.getId());
            cl[i].add(nv.getTen());
            cl[i].add(nv.getKh_id());
            cl[i].add(nv.getP_id());
            cl[i].add(constant_Cls.formatTime.format(nv.getThoiGian()));
            cl[i].add(nv.getGia());
            cl[i].add(nv.getTinhTrang());
            System.out.println("id  = " + nv.getId() + " size " + constant_Cls.dichVuAray.size());
        }
        hang.removeAllElements();//lam moi lai vector hang
        for (int i = 0; i < constant_Cls.dichVuAray.size(); i++) {
            hang.addElement(cl[i]);
        }
        hienThiThongTin(this.TbQLDV, constant_Cls.ColumDv());
    }

    public void ShowPnQLP() {
        this.cl.show(PnHienThi, "QLP");
        this.PnHienThiNhieuPhong.removeAll();
        if (constant_Cls.cfLoad) {
            constant_Cls.GetPhongDB();
        }
        constant_Cls.HashPhanLoai.clear();;
        constant_Cls.loaiPhong.clear();;
        //tiến hành phân loại các phòng, dùng 1 mảng araylist chứa các loại phòng , và dùng hashMap chứa mảng các phòng cugf loại
        //tiến hành phân loại 
        for (int i = 0; i < constant_Cls.phongAray.size(); i++) {
            Phong_Cls p = constant_Cls.phongAray.get(i);
            if (!constant_Cls.HashPhanLoai.containsKey(p.getLoai())) {
                ArrayList<Phong_Cls> loai = new ArrayList<Phong_Cls>();
                loai.add(p);
                constant_Cls.HashPhanLoai.put(p.getLoai(), loai);//
                constant_Cls.loaiPhong.add(p);//tu dien để chứa các loại
            } else {
                ArrayList<Phong_Cls> loai = constant_Cls.HashPhanLoai.remove(p.getLoai());
                loai.add(p);
                constant_Cls.HashPhanLoai.put(p.getLoai(), loai);
            }
        }
        Collections.sort(constant_Cls.loaiPhong);
        int soHang = 0;
//        System.out.println("loai phong " + constant_Cls.loaiPhong.size());
        for (int i = 0; i < constant_Cls.loaiPhong.size(); i++) {
            ArrayList<Phong_Cls> MangPhong = constant_Cls.HashPhanLoai.get(constant_Cls.loaiPhong.get(i).getLoai());
            int c = (MangPhong.size() > 8) ? ((MangPhong.size() % 8) != 0 ? (MangPhong.size() / 8 + 1) : (MangPhong.size() / 8)) : 1;
            soHang += c;
        }
//        System.out.println("so hang " + soHang);
        this.PnHienThiNhieuPhong.setLayout(new GridLayout(soHang, 8, 5, 5));
        for (int i = 0; i < constant_Cls.loaiPhong.size(); i++) {
            ArrayList<Phong_Cls> mangTungLoai = constant_Cls.HashPhanLoai.get(constant_Cls.loaiPhong.get(i).getLoai());
            int count = 0;
            Color c = new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat());
            for (int j = 0; j < mangTungLoai.size(); j++) {
                this.PnHienThiNhieuPhong.add(new PnPhong(true, mangTungLoai.get(j), c, this));
                count++;
            }
            if (count % 8 != 0) {
                for (int j = 0; j < 8 - (count % 8); j++) {
                    this.PnHienThiNhieuPhong.add(new PnPhong(false, null, new Color(204, 255, 204), this));
                }
            }
        }
    }

    private void hienThiThongTin(JTable table, Vector colum) {
        table.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel(hang, colum);
        table.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenu3 = new javax.swing.JMenu();
        Pnbacground = new javax.swing.JPanel();
        PnTacVu = new javax.swing.JPanel();
        LbTacVu = new javax.swing.JLabel();
        BtQlnv = new javax.swing.JButton();
        BtQLP = new javax.swing.JButton();
        BtQlk = new javax.swing.JButton();
        BTQldv = new javax.swing.JButton();
        PnMatKhau = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        PnHienThi = new javax.swing.JPanel();
        PnQLNV = new javax.swing.JPanel();
        PnThongTin = new javax.swing.JPanel();
        LB_ten = new javax.swing.JLabel();
        LB_MatKhau = new javax.swing.JLabel();
        Jtf_Ten = new javax.swing.JTextField();
        Jtf_DienThoai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jtf_DiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        ScrQLSV = new javax.swing.JScrollPane();
        TbQLSV = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        PnQLP = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ScrollHienThiNhieuPhong = new javax.swing.JPanel();
        PnHienThiNhieuPhong = new javax.swing.JPanel();
        Bt_New = new javax.swing.JButton();
        Bt_TatCa = new javax.swing.JButton();
        Bt_CoKhach = new javax.swing.JButton();
        Bt_Trong = new javax.swing.JButton();
        Bt_BaoTri = new javax.swing.JButton();
        PNQLKH = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbQLKH = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        PnThongTin1 = new javax.swing.JPanel();
        LB_ten1 = new javax.swing.JLabel();
        LB_MatKhau1 = new javax.swing.JLabel();
        Jtf_Ten1 = new javax.swing.JTextField();
        Jtf_DienThoai1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Jtf_DiaChi1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        JCB_PhongThue = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        Jlb_ThanhToan = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        PnQLDV = new javax.swing.JPanel();
        PnThongTin2 = new javax.swing.JPanel();
        LB_ten2 = new javax.swing.JLabel();
        LB_MatKhau2 = new javax.swing.JLabel();
        Jtf_Ten2 = new javax.swing.JTextField();
        Jtf_DienThoai2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Jtf_DiaChi2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TbQLDV = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        Jtf_TimKiem = new javax.swing.JTextField();
        lbTimKiem = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(1116, 690));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Pnbacground.setBackground(new java.awt.Color(255, 153, 153));

        PnTacVu.setBackground(new java.awt.Color(51, 255, 102));
        PnTacVu.setBorder(new javax.swing.border.MatteBorder(null));
        PnTacVu.setPreferredSize(new java.awt.Dimension(575, 60));

        BtQlnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/User group.png"))); // NOI18N
        BtQlnv.setText("QlNhanvien");
        BtQlnv.setPreferredSize(new java.awt.Dimension(95, 25));
        BtQlnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtQlnvActionPerformed(evt);
            }
        });

        BtQLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home.png"))); // NOI18N
        BtQLP.setText("QlPhong");
        BtQLP.setPreferredSize(new java.awt.Dimension(95, 25));
        BtQLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtQLPActionPerformed(evt);
            }
        });

        BtQlk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/List.png"))); // NOI18N
        BtQlk.setText("QlKhach");
        BtQlk.setPreferredSize(new java.awt.Dimension(95, 25));
        BtQlk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtQlkActionPerformed(evt);
            }
        });

        BTQldv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Diagram.png"))); // NOI18N
        BTQldv.setText("QlDichVu");
        BTQldv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTQldvActionPerformed(evt);
            }
        });

        PnMatKhau.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/key.png"))); // NOI18N
        jLabel1.setText("Đổi Mật Khẩu");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1446744485_Log Out.png"))); // NOI18N
        jLabel21.setText("Đăng Xuất");

        jLabel22.setBackground(new java.awt.Color(102, 255, 102));
        jLabel22.setFont(new java.awt.Font("Algerian", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 204, 204));
        jLabel22.setText("Hoàng Lạc Thiên");

        jButton3.setText("Đổi Mật Khẩu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Change User");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton22.setText("Người Dùng");
        jButton22.setPreferredSize(new java.awt.Dimension(89, 20));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Boss.png"))); // NOI18N

        javax.swing.GroupLayout PnMatKhauLayout = new javax.swing.GroupLayout(PnMatKhau);
        PnMatKhau.setLayout(PnMatKhauLayout);
        PnMatKhauLayout.setHorizontalGroup(
            PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnMatKhauLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnMatKhauLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(69, 69, 69))
                    .addGroup(PnMatKhauLayout.createSequentialGroup()
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PnMatKhauLayout.setVerticalGroup(
            PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnMatKhauLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnMatKhauLayout.createSequentialGroup()
                .addGroup(PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout PnTacVuLayout = new javax.swing.GroupLayout(PnTacVu);
        PnTacVu.setLayout(PnTacVuLayout);
        PnTacVuLayout.setHorizontalGroup(
            PnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTacVuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(BtQlnv, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BtQLP, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtQlk, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTQldv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(PnMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbTacVu))
        );
        PnTacVuLayout.setVerticalGroup(
            PnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbTacVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BTQldv, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
            .addComponent(BtQlk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtQLP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtQlnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        PnHienThi.setBackground(new java.awt.Color(51, 0, 51));

        PnQLNV.setBackground(new java.awt.Color(204, 255, 204));
        PnQLNV.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        PnThongTin.setBackground(new java.awt.Color(204, 255, 204));
        PnThongTin.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        LB_ten.setText("Tên:");

        LB_MatKhau.setText("Giới Tính:");

        jLabel2.setText("Điện Thoại:");

        jLabel3.setText("Địa Chỉ:");

        jLabel6.setText("Công Việc:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ"}));

        jLabel5.setText("Ngày Sinh:");

        javax.swing.GroupLayout PnThongTinLayout = new javax.swing.GroupLayout(PnThongTin);
        PnThongTin.setLayout(PnThongTinLayout);
        PnThongTinLayout.setHorizontalGroup(
            PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongTinLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnThongTinLayout.createSequentialGroup()
                        .addComponent(LB_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jtf_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnThongTinLayout.createSequentialGroup()
                        .addComponent(LB_MatKhau)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jtf_DienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jtf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnThongTinLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2))
                    .addGroup(PnThongTinLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PnThongTinLayout.setVerticalGroup(
            PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Jtf_DienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jtf_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnThongTinLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(PnThongTinLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(PnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Jtf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tải xuống.png"))); // NOI18N
        jButton7.setText("THÊM");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync.png"))); // NOI18N
        jButton8.setText("UPDATE");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton9.setText("XÓA");
        jButton9.setPreferredSize(new java.awt.Dimension(95, 41));

        TbQLSV.setAutoCreateRowSorter(true);
        TbQLSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        TbQLSV.setInheritsPopupMenu(true);
        ScrQLSV.setViewportView(TbQLSV);

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Danh Sách Nhân Viên");

        javax.swing.GroupLayout PnQLNVLayout = new javax.swing.GroupLayout(PnQLNV);
        PnQLNV.setLayout(PnQLNVLayout);
        PnQLNVLayout.setHorizontalGroup(
            PnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnQLNVLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(72, 72, 72)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnQLNVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScrQLSV, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(PnQLNVLayout.createSequentialGroup()
                .addGroup(PnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnQLNVLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnQLNVLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(PnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnQLNVLayout.setVerticalGroup(
            PnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnQLNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(PnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrQLSV, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        PnQLP.setBackground(new java.awt.Color(204, 255, 204));
        PnQLP.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Danh Sách Các Phòng");

        jScrollPane3.setAutoscrolls(true);

        ScrollHienThiNhieuPhong.setBackground(new java.awt.Color(204, 255, 204));
        ScrollHienThiNhieuPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        ScrollHienThiNhieuPhong.setAlignmentX(5.0F);
        ScrollHienThiNhieuPhong.setAlignmentY(5.0F);
        ScrollHienThiNhieuPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PnHienThiNhieuPhong.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout PnHienThiNhieuPhongLayout = new javax.swing.GroupLayout(PnHienThiNhieuPhong);
        PnHienThiNhieuPhong.setLayout(PnHienThiNhieuPhongLayout);
        PnHienThiNhieuPhongLayout.setHorizontalGroup(
            PnHienThiNhieuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        PnHienThiNhieuPhongLayout.setVerticalGroup(
            PnHienThiNhieuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ScrollHienThiNhieuPhongLayout = new javax.swing.GroupLayout(ScrollHienThiNhieuPhong);
        ScrollHienThiNhieuPhong.setLayout(ScrollHienThiNhieuPhongLayout);
        ScrollHienThiNhieuPhongLayout.setHorizontalGroup(
            ScrollHienThiNhieuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrollHienThiNhieuPhongLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(PnHienThiNhieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        ScrollHienThiNhieuPhongLayout.setVerticalGroup(
            ScrollHienThiNhieuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrollHienThiNhieuPhongLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(PnHienThiNhieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(ScrollHienThiNhieuPhong);

        Bt_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/_new.png"))); // NOI18N
        Bt_New.setText("NEW");
        Bt_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_NewActionPerformed(evt);
            }
        });

        Bt_TatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1446721015_reload_all_tabs.png"))); // NOI18N
        Bt_TatCa.setText("TẤT CẢ");

        Bt_CoKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PEOPLE (1).png"))); // NOI18N
        Bt_CoKhach.setText("CÓ KHÁCH");

        Bt_Trong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1447355886_go-home.png"))); // NOI18N
        Bt_Trong.setText("TRỐNG");

        Bt_BaoTri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Warning (1).png"))); // NOI18N
        Bt_BaoTri.setText("BẢO TRÌ");

        javax.swing.GroupLayout PnQLPLayout = new javax.swing.GroupLayout(PnQLP);
        PnQLP.setLayout(PnQLPLayout);
        PnQLPLayout.setHorizontalGroup(
            PnQLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnQLPLayout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addGap(333, 333, 333))
            .addGroup(PnQLPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnQLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Bt_BaoTri, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bt_CoKhach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bt_TatCa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bt_New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bt_Trong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(118, 118, 118))
        );
        PnQLPLayout.setVerticalGroup(
            PnQLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnQLPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnQLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnQLPLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Bt_New)
                        .addGap(18, 18, 18)
                        .addComponent(Bt_TatCa)
                        .addGap(18, 18, 18)
                        .addComponent(Bt_CoKhach)
                        .addGap(18, 18, 18)
                        .addComponent(Bt_Trong)
                        .addGap(18, 18, 18)
                        .addComponent(Bt_BaoTri)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnQLPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        PNQLKH.setBackground(new java.awt.Color(204, 255, 204));
        PNQLKH.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tải xuống (2).png"))); // NOI18N
        jButton11.setText("THÊM");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync.png"))); // NOI18N
        jButton12.setText("UPDATE");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton13.setText("XÓA");
        jButton13.setPreferredSize(new java.awt.Dimension(95, 41));

        TbQLKH.setAutoCreateRowSorter(true);
        TbQLKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Giới Tính", "CMNN", "Điện Thoại", "Phòng Thuê", "Số Người", "Ngày Đến", "Ngày Đi", "Thanh Toán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TbQLKH);

        jLabel12.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Danh Sách Khách Hàng");

        PnThongTin1.setBackground(new java.awt.Color(204, 255, 204));
        PnThongTin1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        LB_ten1.setText("Tên:");

        LB_MatKhau1.setText("Giới Tính:");

        jLabel7.setText("Điện Thoại:");

        jLabel8.setText("CMNN:");

        jLabel9.setText("Phòng Thuê:");

        jLabel10.setText("Ngày Đến:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ"}));

        JCB_PhongThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Số Người:");

        jLabel14.setText("Ngày Đi:");

        jLabel15.setText("Dịch Vụ:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Jlb_ThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Jlb_ThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ok.png"))); // NOI18N

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1446738536_Purse.png"))); // NOI18N
        jButton14.setText("THANH TOÁN");

        javax.swing.GroupLayout PnThongTin1Layout = new javax.swing.GroupLayout(PnThongTin1);
        PnThongTin1.setLayout(PnThongTin1Layout);
        PnThongTin1Layout.setHorizontalGroup(
            PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongTin1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PnThongTin1Layout.createSequentialGroup()
                                .addComponent(LB_MatKhau1)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PnThongTin1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, 112, Short.MAX_VALUE)
                            .addComponent(Jtf_DiaChi1))
                        .addGap(24, 24, 24)
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)))
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addComponent(LB_ten1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(Jtf_Ten1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)))
                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCB_PhongThue, 0, 112, Short.MAX_VALUE)
                            .addComponent(jTextField6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnThongTin1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jtf_DienThoai1)))
                .addGap(18, 18, 18)
                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jlb_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton14)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        PnThongTin1Layout.setVerticalGroup(
            PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongTin1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LB_ten1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jtf_Ten1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Jtf_DienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnThongTin1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(JCB_PhongThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PnThongTin1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LB_MatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(PnThongTin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Jtf_DiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnThongTin1Layout.createSequentialGroup()
                        .addComponent(Jlb_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PNQLKHLayout = new javax.swing.GroupLayout(PNQLKH);
        PNQLKH.setLayout(PNQLKHLayout);
        PNQLKHLayout.setHorizontalGroup(
            PNQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNQLKHLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(PNQLKHLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(PNQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PNQLKHLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PnThongTin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(PNQLKHLayout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PNQLKHLayout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jButton11)
                .addGap(47, 47, 47)
                .addComponent(jButton12)
                .addGap(63, 63, 63)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PNQLKHLayout.setVerticalGroup(
            PNQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNQLKHLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnThongTin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PNQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PNQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PNQLKHLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PnQLDV.setBackground(new java.awt.Color(204, 255, 204));
        PnQLDV.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        PnThongTin2.setBackground(new java.awt.Color(204, 255, 204));
        PnThongTin2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        LB_ten2.setText("Tên DV:");

        LB_MatKhau2.setText("Thời Gian:");

        jLabel16.setText("Tên Khách:");

        jLabel17.setText("Giá:");

        jLabel18.setText("Phòng:");

        jLabel19.setText("Tình Trạng:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đã Thanh Toán", "Chưa Thanh Toán"}));

        javax.swing.GroupLayout PnThongTin2Layout = new javax.swing.GroupLayout(PnThongTin2);
        PnThongTin2.setLayout(PnThongTin2Layout);
        PnThongTin2Layout.setHorizontalGroup(
            PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongTin2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LB_ten2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LB_MatKhau2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jtf_Ten2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addGap(27, 27, 27)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jtf_DienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jtf_DiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3)
                    .addComponent(jComboBox4, 0, 121, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnThongTin2Layout.setVerticalGroup(
            PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnThongTin2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_ten2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(Jtf_DienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jtf_Ten2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(PnThongTin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Jtf_DiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LB_MatKhau2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tải xuống.png"))); // NOI18N
        jButton19.setText("THÊM");
        jButton19.setToolTipText("nói cho vui\n");

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sync.png"))); // NOI18N
        jButton20.setText("UPDATE");

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        jButton21.setText("XÓA");
        jButton21.setPreferredSize(new java.awt.Dimension(95, 41));

        TbQLDV.setAutoCreateRowSorter(true);
        TbQLDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Ngày Sinh", "Giới Tính", "Điện Thoại", "Địa Chỉ", "Công Việc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TbQLDV);

        jLabel20.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 255));
        jLabel20.setText("Danh Sách Dich Vu");

        javax.swing.GroupLayout PnQLDVLayout = new javax.swing.GroupLayout(PnQLDV);
        PnQLDV.setLayout(PnQLDVLayout);
        PnQLDVLayout.setHorizontalGroup(
            PnQLDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnQLDVLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addGap(72, 72, 72)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnQLDVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(PnQLDVLayout.createSequentialGroup()
                .addGroup(PnQLDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnQLDVLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnQLDVLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(PnThongTin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnQLDVLayout.setVerticalGroup(
            PnQLDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnQLDVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(4, 4, 4)
                .addComponent(PnThongTin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnQLDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout PnHienThiLayout = new javax.swing.GroupLayout(PnHienThi);
        PnHienThi.setLayout(PnHienThiLayout);
        PnHienThiLayout.setHorizontalGroup(
            PnHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnQLDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnHienThiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PnQLP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
            .addGroup(PnHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnHienThiLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PNQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PnHienThiLayout.setVerticalGroup(
            PnHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnHienThiLayout.createSequentialGroup()
                .addComponent(PnQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnQLDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 87, Short.MAX_VALUE))
            .addGroup(PnHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnHienThiLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(PnQLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(85, Short.MAX_VALUE)))
            .addGroup(PnHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnHienThiLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(PNQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        lbTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Search_1.png"))); // NOI18N
        lbTimKiem.setText("Tìm Kiếm:");

        javax.swing.GroupLayout PnbacgroundLayout = new javax.swing.GroupLayout(Pnbacground);
        Pnbacground.setLayout(PnbacgroundLayout);
        PnbacgroundLayout.setHorizontalGroup(
            PnbacgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnbacgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTimKiem)
                .addGap(39, 39, 39)
                .addComponent(Jtf_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(319, 319, 319))
            .addGroup(PnbacgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PnTacVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
        );
        PnbacgroundLayout.setVerticalGroup(
            PnbacgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnbacgroundLayout.createSequentialGroup()
                .addComponent(PnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnbacgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jtf_TimKiem)
                    .addComponent(lbTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Arrange");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Open");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("AboutUs");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnbacground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnbacground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        int choce = JOptionPane.showConfirmDialog(null, "Bạn có chắc không?", "exit",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choce == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void BtQlnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtQlnvActionPerformed
        ShowPnQLNV();

    }//GEN-LAST:event_BtQlnvActionPerformed

    private void BtQLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtQLPActionPerformed
        // TODO add your handling code here:
        ShowPnQLP();
    }//GEN-LAST:event_BtQLPActionPerformed

    private void BtQlkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtQlkActionPerformed
        ShowPnQLKH();
    }//GEN-LAST:event_BtQlkActionPerformed

    private void BTQldvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTQldvActionPerformed
        // TODO add your handling code here:
        ShowPnQLDV();
    }//GEN-LAST:event_BTQldvActionPerformed

    private void Jlb_DoiMatKhauMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlb_DoiMatKhauMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_Jlb_DoiMatKhauMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new ModifyUserFr().show();;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        new CreateUserFr().show();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new SignIn().show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Bt_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_NewActionPerformed
        // TODO add your handling code here:
        new ShowPhong(null, this).show();
    }//GEN-LAST:event_Bt_NewActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int choce = JOptionPane.showConfirmDialog(null, "Bạn có chắc  không ?", "title",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        System.out.println("choi = "+choce);
        if (choce == 0) {
            constant_Cls.SaveToDb();
            System.out.println("da up date xg");
            System.exit(0);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(quanlykhachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlykhachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlykhachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlykhachsan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new quanlykhachsan();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new quanlykhachsan();
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTQldv;
    private javax.swing.JButton BtQLP;
    private javax.swing.JButton BtQlk;
    private javax.swing.JButton BtQlnv;
    private javax.swing.JButton Bt_BaoTri;
    private javax.swing.JButton Bt_CoKhach;
    private javax.swing.JButton Bt_New;
    private javax.swing.JButton Bt_TatCa;
    private javax.swing.JButton Bt_Trong;
    private javax.swing.JComboBox JCB_PhongThue;
    private javax.swing.JLabel Jlb_ThanhToan;
    private javax.swing.JTextField Jtf_DiaChi;
    private javax.swing.JTextField Jtf_DiaChi1;
    private javax.swing.JTextField Jtf_DiaChi2;
    private javax.swing.JTextField Jtf_DienThoai;
    private javax.swing.JTextField Jtf_DienThoai1;
    private javax.swing.JTextField Jtf_DienThoai2;
    private javax.swing.JTextField Jtf_Ten;
    private javax.swing.JTextField Jtf_Ten1;
    private javax.swing.JTextField Jtf_Ten2;
    private javax.swing.JTextField Jtf_TimKiem;
    private javax.swing.JLabel LB_MatKhau;
    private javax.swing.JLabel LB_MatKhau1;
    private javax.swing.JLabel LB_MatKhau2;
    private javax.swing.JLabel LB_ten;
    private javax.swing.JLabel LB_ten1;
    private javax.swing.JLabel LB_ten2;
    private javax.swing.JLabel LbTacVu;
    private javax.swing.JPanel PNQLKH;
    private javax.swing.JPanel PnHienThi;
    private javax.swing.JPanel PnHienThiNhieuPhong;
    private javax.swing.JPanel PnMatKhau;
    private javax.swing.JPanel PnQLDV;
    private javax.swing.JPanel PnQLNV;
    private javax.swing.JPanel PnQLP;
    private javax.swing.JPanel PnTacVu;
    private javax.swing.JPanel PnThongTin;
    private javax.swing.JPanel PnThongTin1;
    private javax.swing.JPanel PnThongTin2;
    private javax.swing.JPanel Pnbacground;
    private javax.swing.JScrollPane ScrQLSV;
    private javax.swing.JPanel ScrollHienThiNhieuPhong;
    private javax.swing.JTable TbQLDV;
    private javax.swing.JTable TbQLKH;
    private javax.swing.JTable TbQLSV;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lbTimKiem;
    // End of variables declaration//GEN-END:variables
}
