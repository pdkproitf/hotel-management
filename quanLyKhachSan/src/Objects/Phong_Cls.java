/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;

/**
 *
 * @author naruto
 */
public class Phong_Cls implements Comparable<Phong_Cls>{
    int id,so,succhua,gia,id_nguoithue,soNguoiO;
    String loai,tenKhach;
    String tinhtrang;
    public int getId() {
        return id;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getLoai() {
        return loai;
    }

    public int getSoNguoiO() {
        return soNguoiO;
    }

    public void setSoNguoiO(int soNguoiO) {
        this.soNguoiO = soNguoiO;
    }

    public void setLoai(String loai) {
        this.loai = loai.toUpperCase();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getSucchua() {
        return succhua;
    }

    public void setSucchua(int succhua) {
        this.succhua = succhua;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getId_nguoithue() {
        return id_nguoithue;
    }

    public void setId_nguoithue(int id_nguoithue) {
        this.id_nguoithue = id_nguoithue;
    }

    @Override
    public int compareTo(Phong_Cls o) {
        return this.getGia() >= o.getGia() ? -1:1;
    }
    
}
