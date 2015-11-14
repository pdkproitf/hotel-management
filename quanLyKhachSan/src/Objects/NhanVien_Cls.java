/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;
import quanlykhachsan.constant_Cls;

/**
 *
 * @author naruto
 */
public class NhanVien_Cls {

    String ten, gioiTinh, DiaChi, CongViec;
    Date NgayVao, NgayDi, NamSinh;
    int id;
    int Sdt;

    public NhanVien_Cls() {

    }

    public NhanVien_Cls(String ten, String gioiTinh,String NamSinh,String diaChi,int sdt, String congViec) {
        try {
            this.ten = ten;
            this.Sdt = sdt;
            this.gioiTinh = gioiTinh;
            this.DiaChi = diaChi;
            this.CongViec = congViec;
            this.NamSinh = constant_Cls.formatTime.parse(NamSinh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCongViec() {
        return CongViec;
    }

    public void setCongViec(String CongVie) {
        this.CongViec = CongVie;
    }

    public Date getNgayVao() {
        return NgayVao;
    }

    public void setNgayVao(Date NgayVao) {
        this.NgayVao = NgayVao;
    }

    public Date getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(Date NgayDi) {
        this.NgayDi = NgayDi;
    }

    public Date getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(Date NamSinh) {
        this.NamSinh = NamSinh;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
