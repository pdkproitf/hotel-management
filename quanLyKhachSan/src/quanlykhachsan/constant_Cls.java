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
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author naruto
 */
public class constant_Cls {

    public static String path = "properties.properties";
    //cho ket noi db
    public static String drive = getValue("drive");
    public static String url = getValue("url");
    public static String user = getValue("user");
    public static String pass = getValue("pass");
    //
    //co load du lieu
    public static boolean cfLoad = true;//co bang true thi cho phep load

    //
    public static HashMap<String, ArrayList<Phong_Cls>> HashPhanLoai = new HashMap<String, ArrayList<Phong_Cls>>();
    public static ArrayList<Phong_Cls> loaiPhong = new ArrayList<Phong_Cls>();

    public static Vector<String> colum = new Vector();
    //cach format kieu date
    public static SimpleDateFormat formatTime = new SimpleDateFormat("DD/MM/yyyy");
    //cac mảng để chứa data khi load lên và lấy làm việc
    public static ArrayList<NhanVien_Cls> nhanVienAray = new ArrayList<NhanVien_Cls>();
    public static ArrayList<Phong_Cls> phongAray = new ArrayList<Phong_Cls>();
    public static ArrayList<DichVu_cls> dichVuAray = new ArrayList<DichVu_cls>();
    public static ArrayList<KhachHang_cls> khachAray = new ArrayList<KhachHang_cls>();
    //
    private static ArrayList<NhanVien_Cls> nhanVienArayClone;
    private static ArrayList<Phong_Cls> phongArayClone;
    private static ArrayList<DichVu_cls> dichVuArayClone;
    private static ArrayList<KhachHang_cls> khachArayClone;
    //
    
    public static Vector ColumNv() {
        colum.removeAllElements();
        colum.add("STT");
        colum.addElement("ID");
        colum.addElement("TÊN");
        colum.addElement("GIỚI TÍNH");
        colum.addElement("NĂM SINH");
        colum.addElement("SĐT");
        colum.addElement("ĐỊA CHỈ");
        colum.addElement("CÔNG VIỆC");
        return colum;
    }

    public static Vector ColumKh() {
        colum.removeAllElements();
        colum.add("STT");
        colum.addElement("ID");
        colum.addElement("TÊN");
        colum.addElement("GIỚI TÍNH");
        colum.addElement("CMDD");
        colum.addElement("SĐT");
        colum.addElement("PHÒNG THUÊ");
        colum.addElement("SỐ NGƯỜI");
        colum.addElement("NGÀY ĐẾN");
        colum.addElement("NGÀY ĐI");
        colum.addElement("TÌNH TRẠNG");
        return colum;
    }

    public static Vector ColumDv() {
        colum.removeAllElements();
        colum.add("STT");
        colum.addElement("ID");
        colum.addElement("TÊN");
        colum.addElement("KHÁCH");
        colum.addElement("PHÒNG");
        colum.addElement("THỜI GIAN");
        colum.addElement("GIÁ");
        colum.addElement("TÌNH TRẠNG");
        return colum;
    }

    public static String getValue(String name) {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream(new File(path)));
            return p.getProperty(name);
        } catch (Exception e) {
            System.out.println("loi doc file properties");
            e.printStackTrace();
            return null;
        }
    }

    public static Connection openConnect() {
        try {
            Class.forName(drive);//load drive
            Connection con = DriverManager.getConnection(url, user, pass);//lay ket noi
            return con;
        } catch (Exception e) {
            System.out.println("loi tao ket noi");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnect(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("loi dong ket noi");
        }
    }

    //dong result
    public static void closeConnect(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("loi dong ket noi result set");
        }
    }

    //dong statment
    public static void closeConnect(Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (Exception e) {
            System.out.println("loi dong ket noi result set");
        }
    }

    public static void closeConnect(PreparedStatement pstm) {
        try {
            if (pstm != null) {
                pstm.close();
            }
        } catch (Exception e) {
            System.out.println("loi dong ket noi result set");
        }
    }

    public static boolean CheckDB(String sql) {
        try {
            System.out.println(sql);
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                System.out.println("sql  = " + sql);
                if (rs.next()) {
                    closeConnect(con);
                    closeConnect(stm);
                    System.out.println("check thanh cong");
                    return true;
                }
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
            }
            return false;
        } catch (Exception e) {
            System.out.println("loi checkDB");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean SerDB(String table_colums, String values) {
        try {
            Connection con = openConnect();
            if (con != null) {
                String sql = "insert into " + table_colums + " values (" + values + ")";
                System.out.println(sql);
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                //
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                //
                return true;
            } else {
                System.out.println("dua vao db KHONG thanh cong 1");
                return false;
            }
        } catch (Exception e) {
            System.out.println("dua vao db KHONG thanh cong");
            e.printStackTrace();
        }
        return false;
    }

    public static String GetOneDB(String sql) {
        try {
            System.out.println(sql);
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {
                    String dara = rs.getString(1);
                    closeConnect(con);
                    closeConnect(stm);
                    closeConnect(rs);
                    return dara;
                }
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
            }
        } catch (Exception e) {
            System.out.println("loi get db");
            e.printStackTrace();
        }
        System.out.println("khong co du lieu");
        return null;
    }

    public static boolean GetNhanvienDB() {
        String sql = "select * from nhanVien_tbl";
        try {
            System.out.println(sql);
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                nhanVienAray.clear();
                while (rs.next()) {
                    NhanVien_Cls nv = new NhanVien_Cls();
                    nv.setId(rs.getInt(1));
                    nv.setTen(rs.getString("nv_ten"));
                    nv.setNamSinh(rs.getString("nv_ngaysinh") != null ? formatTime.parse(rs.getString("nv_ngaysinh")) : null);
                    nv.setGioiTinh(rs.getString("nv_gioiTinh"));
                    nv.setDiaChi(rs.getString("nv_diachi"));
                    nv.setSdt(Integer.parseInt(rs.getString("nv_dienthoai")));
                    nv.setCongViec(rs.getString("nv_congviec"));
                    nhanVienAray.add(nv);
                }
                nhanVienArayClone= (ArrayList<NhanVien_Cls>) nhanVienAray.clone();
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                System.out.println("nhan vien lay duoc " + nhanVienAray.size());
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi get db nhan vien");
            e.printStackTrace();
            return false;
        }
        System.out.println("loi lay db nhan vien");
        return false;
    }

    public static boolean GetKhachHangDB() {
        String sql = "select * from khachHang_tbl";
        try {
            System.out.println(sql);
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                khachAray.clear();
                while (rs.next()) {
                    KhachHang_cls nv = new KhachHang_cls();
                    nv.setId(rs.getInt(1));
                    nv.setTen(rs.getString("kh_ten"));
                    nv.setGioiTinh(rs.getString("kh_gioiTinh"));
                    nv.setCmnn(Integer.parseInt(rs.getString("KH_CMNd")));
                    nv.setDienthoai(Integer.parseInt(rs.getString("kh_dienthoai")));
                    nv.setPhongThue("A101");
                    nv.setSoNguoi(4);
                    nv.setNgayDen(new SimpleDateFormat("MM-dd-yyyy").parse("1-1-2011"));
                    nv.setNgayDi(null);
                    nv.setTinhTrang(rs.getString("kh_tinhTrang"));
                    khachAray.add(nv);
                }
                khachArayClone = (ArrayList<KhachHang_cls>) khachAray.clone();
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                System.out.println("khach hang lay dc " + khachAray.size());
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi get db nhan vien");
            e.printStackTrace();
            return false;
        }
        System.out.println("loi lay db nhan vien");
        return false;
    }

    public static boolean GetPhongDB() {
        String sql = "select * from phong_tbl";
        try {
            System.out.println(sql);
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                phongAray.clear();
                while (rs.next()) {
                    Phong_Cls nv = new Phong_Cls();
                    nv.setId(rs.getInt(1));
                    nv.setGia(Integer.parseInt(rs.getString("p_gia")));
                    nv.setSo(Integer.parseInt(rs.getString("p_so")));
                    nv.setLoai(rs.getString("p_loai"));
                    nv.setSucchua(Integer.parseInt(rs.getString("P_SUCCHUA")));
                    nv.setTinhtrang(rs.getString("P_TINHTRANG"));
                    String id_nguoithue = GetOneDB("select kh_id from khachhang_tbl where kh_p_id = " + nv.getId() + " and kh_tinhtrang = 'chưa thanh toán'");
                    if (id_nguoithue != null) {
                        nv.setId_nguoithue(Integer.parseInt(id_nguoithue));
                        String tenKhach = constant_Cls.GetOneDB("select kh_ten from khachhang_tbl where kh_id=" + nv.getId_nguoithue());
                        String soNguoiO = constant_Cls.GetOneDB("select kh_songuoidicung from khachhang_tbl where kh_id =" + nv.getId_nguoithue());
                        nv.setTenKhach(tenKhach);
                        nv.setSoNguoiO(soNguoiO != null ? Integer.parseInt(soNguoiO) : 0);
                    }
                    phongAray.add(nv);
                }
                phongArayClone = (ArrayList<Phong_Cls>) phongAray.clone();
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                System.out.println("lay duoc phong " + phongAray.size());
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi get db nhan vien");
            e.printStackTrace();
            return false;
        }
        System.out.println("loi lay db nhan vien");
        return false;
    }

    public static boolean GetDichVuDB() {
        String sql = "select * from dichvu_tbl";
        try {
            System.out.println(sql);
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                dichVuAray.clear();
                while (rs.next()) {
                    DichVu_cls nv = new DichVu_cls();
                    nv.setId(rs.getInt(1));
                    nv.setTen(rs.getString("dv_ten"));
                    nv.setKh_id(Integer.parseInt(rs.getString("dv_kh_id")));
                    nv.setP_id(Integer.parseInt(rs.getString("dv_p_id")));
                    nv.setThoiGian(formatTime.parse(rs.getString("dv_thoiGian")));
                    nv.setGia(Integer.parseInt(rs.getString("dv_gia")));
                    nv.setTinhTrang(rs.getString("dv_tinhtrang"));
                    dichVuAray.add(nv);
                }
                dichVuArayClone = (ArrayList<DichVu_cls>) dichVuAray.clone();
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                System.out.println("dich vu lay duoc " + dichVuAray.size());
                return true;
            }
        } catch (Exception e) {
            System.out.println("loi get db nhan vien");
            e.printStackTrace();
            return false;
        }
        System.out.println("loi lay db nhan vien");
        return false;
    }

    public static boolean upDate(String table, String colums_values, String dieuKien) {
        try {
            Connection con = openConnect();
            if (con != null) {
                String sql = "update " + table + " set " + colums_values + " where " + dieuKien;
                System.out.println(sql);
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                return true;
            } else {
                System.out.println("update vao db KHONG thanh cong 1");
                return false;
            }
        } catch (Exception e) {
            System.out.println("update vao db KHONG thanh cong");
            e.printStackTrace();
            return false;
        }
    }

    public static void Commit() {
        try {
            Connection con = openConnect();
            if (con != null) {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("commit");
                //
                closeConnect(con);
                closeConnect(stm);
                closeConnect(rs);
                //
            } else {
                System.out.println("dua vao db KHONG thanh cong 1");
            }
        } catch (Exception e) {
            System.out.println("dua vao db KHONG thanh cong");
            e.printStackTrace();
        }
    }

    public static void SaveToDb() {
        SavePhong();
        SaveKhachhang();
        SaveDichVu();
        SaveNhanVien();
    }

    public static void SavePhong() {
        try {
            Connection con = openConnect();
            if (con != null) {
                PreparedStatement update = con.prepareStatement("update phong_tbl set p_gia=?,p_succhua = ?,P_loai=?"
                  + ",p_so = ?,p_tinhtrang = ? where p_id=?");

                PreparedStatement insert = con.prepareStatement("insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang)"
                  + "values(?,?,?,?,?,?)");
                phongAray.removeAll(phongArayClone);
                for (int i = 0; i < phongAray.size(); i++) {
                    Phong_Cls nv = phongAray.get(i);
                    if (CheckDB("select * from phong_tbl where p_id = " + nv.getId())) {
                        update.setInt(1, nv.getGia());
                        update.setInt(2, nv.getSucchua());
                        update.setString(3, nv.getLoai());
                        update.setInt(4, nv.getSo());
                        update.setString(5, nv.getTinhtrang());
                        update.setInt(6, nv.getId());
                        System.out.println(" i = " + i + " size = " + phongAray.size());
                        update.addBatch();
                    } else {
                        insert.setInt(1, nv.getId());
                        insert.setInt(2, nv.getSo());
                        insert.setString(3, nv.getLoai() + "");
                        insert.setInt(4, nv.getGia());
                        insert.setInt(5, nv.getSucchua());
                        insert.setString(6, nv.getTinhtrang());
                        insert.addBatch();
                    }
                }

                update.executeBatch();
                insert.executeBatch();
                System.out.println("SAVE PHONG => "+phongAray.size());
                con.commit();
                closeConnect(update);
                closeConnect(insert);
                closeConnect(con);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SaveKhachhang() {
        //luu nhan vien
        try {
            Connection con = openConnect();
            if (con != null) {
                PreparedStatement update = con.prepareStatement("update khachhang_tbl set kh_ten = ?,kh_gioitinh = ?,kh_ngayden ="
                  + "?,kh_ngaydi = ?,kh_dienthoai = ?,kh_p_id = ?,kh_tinhtrang = ?,kh_songuoidicung = ?"
                  + ",kh_cmnn = ? where dv_id = ?");

                PreparedStatement insert = con.prepareStatement("insert into khachhang_tbl (kh_id,kh_ten,kh_gioitinh,kh_cmnd,"
                  + "kh_dienthoai,kh_tinhtrang,kh_p_id,kh_songuoidicung,kh_ngayden,kh_ngaydi)" + "values(?,?,?,?,?,?,?,?,?,?)");

                khachAray.removeAll(khachArayClone);
                for (int i = 0; i < khachAray.size(); i++) {
                    KhachHang_cls nv = khachAray.get(i);
                    if (CheckDB("select * from nhanvien_tbl where kh_id = " + nv.getId())) {
                        update.setString(1, nv.getTen());
                        update.setString(2, nv.getGioiTinh());
                        update.setString(3, formatTime.format(nv.getNgayDen()));
                        update.setString(4, formatTime.format(nv.getNgayDi()));
                        update.setInt(5, nv.getDienthoai());
                        update.setInt(6, nv.getP_id());
                        update.setString(7, nv.getTinhTrang());
                        update.setInt(8, nv.getSoNguoi());
                        update.setInt(9, nv.getCmnn());
                        update.setInt(10, nv.getId());
                        update.addBatch();
                    } else {
                        insert.setInt(1, nv.getId());
                        insert.setString(2, nv.getTen());
                        insert.setString(3, nv.getGioiTinh() + "");
                        insert.setInt(4, nv.getCmnn());
                        insert.setInt(5, nv.getDienthoai());
                        insert.setString(6, nv.getTinhTrang());
                        insert.setInt(7, nv.getP_id());
                        insert.setInt(8, nv.getSoNguoi());
                        insert.setString(9, formatTime.format(nv.getNgayDen()));
                        insert.setString(10, formatTime.format(nv.getNgayDi()));

                        insert.addBatch();
                    }
                }
                update.executeBatch();
                insert.executeBatch();
                con.commit();
                System.out.println("SAVE KHACH HANG => "+khachAray.size());
                closeConnect(update);
                closeConnect(insert);
                closeConnect(con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SaveDichVu() {
        //luu nhan vien
        try {
            Connection con = openConnect();
            if (con != null) {
                PreparedStatement update = con.prepareStatement("update dichvu_tbl set dv_ten = ?,dv_gia = ?,dv_thoigian ="
                  + "?,dv_kh_id = ?,dv_p_id = ?,dv_tinhtrang = ? where dv_id = ?");

                PreparedStatement insert = con.prepareStatement("insert into dichvu_tbl (dv_id,dv_ten,dv_gia,"
                  + "dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)" + "values(?,?,?,?,?,?,?)");
                
                dichVuAray.removeAll(dichVuArayClone);
                for (int i = 0; i < dichVuAray.size(); i++) {
                    DichVu_cls nv = dichVuAray.get(i);
                    if (CheckDB("select * from nhanvien_tbl where dv_id = " + nv.getId())) {
                        update.setString(1, nv.getTen());
                        update.setFloat(2, nv.getGia());
                        update.setString(3, formatTime.format(nv.getThoiGian()));
                        update.setInt(4, nv.getKh_id());
                        update.setInt(5, nv.getP_id());
                        update.setString(6, nv.getTinhTrang());
                        update.setInt(7, nv.getId());
                        update.addBatch();
                    } else {
                        insert.setInt(1, nv.getId());
                        insert.setString(2, nv.getTen());
                        insert.setFloat(3, nv.getGia());
                        insert.setString(4, formatTime.format(nv.getThoiGian()));
                        insert.setInt(5, nv.getKh_id());
                        insert.setInt(6, nv.getP_id());
                        insert.setString(7, nv.getTinhTrang());
                        insert.addBatch();
                    }
                }
                update.executeBatch();
                insert.executeBatch();
                con.commit();
                System.out.println("SAVE DICH VU => "+dichVuAray.size());
                closeConnect(update);
                closeConnect(insert);
                closeConnect(con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SaveNhanVien() {
        //luu nhan vien
        try {
            Connection con = openConnect();
            if (con != null) {
                PreparedStatement updateNV = con.prepareStatement("update nhanvien_tbl set nv_ten = ?,nv_ngaysinh = ?,nv_gioitinh ="
                  + "?,nv_diachi = ?,nv_dienthoai = ?,nv_congviec = ? where nv_id = ?");

                PreparedStatement insertNV = con.prepareStatement("insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,"
                  + "nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)" + "values(?,?,?,?,?,?,?)");
                
                nhanVienAray.removeAll(nhanVienArayClone);
                for (int i = 0; i < nhanVienAray.size(); i++) {
                    NhanVien_Cls nv = nhanVienAray.get(i);
                    if (CheckDB("select * from nhanvien_tbl where nv_id = " + nv.getId())) {
                        updateNV.setString(1, nv.getTen());
                        updateNV.setString(2, formatTime.format(nv.getNamSinh()));
                        updateNV.setString(3, nv.getGioiTinh());
                        updateNV.setString(4, nv.getDiaChi());
                        updateNV.setInt(5, nv.getSdt());
                        updateNV.setString(6, nv.getCongViec());
                        updateNV.setInt(7, nv.getId());
                        updateNV.addBatch();
                    } else {
                        insertNV.setInt(1, nv.getId());
                        insertNV.setString(2, nv.getTen());
                        insertNV.setString(3, formatTime.format(nv.getNamSinh()));
                        insertNV.setString(4, nv.getGioiTinh());
                        insertNV.setString(5, nv.getDiaChi());
                        insertNV.setInt(6, nv.getSdt());
                        insertNV.setString(7, nv.getCongViec());
                        insertNV.addBatch();
                    }
                }
                updateNV.executeBatch();
                insertNV.executeBatch();
                con.commit();
                System.out.println("SAVE NHAN VIEN => "+nhanVienAray.size());
                closeConnect(insertNV);
                closeConnect(updateNV);
                closeConnect(con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
