/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import quanlykhachsan.constant_Cls;

/**
 *
 * @author naruto
 */
public class setdb {
    //setdb tu showPhong vao
//               if (this.phong != null) {
//                
//                constant_Cls.upDate("phong_tbl", "p_gia = " + Float.parseFloat(this.tfGia.getText())
//                  + ",p_succhua = " + Integer.parseInt((!this.tfSucChua.getText().equals("")) ? this.tfSucChua.getText() : "0") + ",P_loai = '" + this.TfLoai.getText()
//                  + "',p_so = " + Integer.parseInt((!this.TfSo.getText().equals("")) ? this.TfSo.getText() : "0") + ",p_tinhtrang = '" + this.CBTinhTrang.getSelectedItem()
//                  + "'", "p_id = " + this.phong.getId());
//                //update cho bang khachhang
//                constant_Cls.upDate("khachhang_tbl", "kh_ten = '" + this.TfnguoiThue.getText()
//                  + "', KH_SONGUOIDICUNG = " + Integer.parseInt((!this.TfNguoiO.getText().equals("")) ? this.TfNguoiO.getText() : "0"), "kh_id = " + this.phong.getId_nguoithue());
//                constant_Cls.Commit();
//                constant_Cls.phongAray.set(constant_Cls.phongAray.indexOf(this.phong), newPhong);
//            } else {
//                String idS = constant_Cls.GetOneDB("select * from(select p_id from phong_tbl order by p_id desc) where rownum < 2");
//                int id = Integer.parseInt(idS) + 1;
//                constant_Cls.SerDB("phong_tbl(p_id,p_loai,p_so,p_gia,p_succhua,p_tinhTrang)", id + ",'" + this.TfLoai.getText().toUpperCase()
//                  + "'," + Integer.parseInt(this.TfSo.getText()) + "," + Integer.parseInt(this.tfGia.getText()) + ","
//                  + Integer.parseInt((!this.tfSucChua.getText().equals("") ? this.tfSucChua.getText() : "0")) + ",'" + this.CBTinhTrang.getSelectedItem() + "'");
//                constant_Cls.phongAray.add(newPhong);
//            }
}
/*
    public static void SaveToDb() {
        //luu phong
        for (int i = 0; i < phongAray.size(); i++) {
            Phong_Cls phong = phongAray.get(i);
            if (CheckDB("select * from phong_tbl where p_id = " + phong.getId())) {//kiem tra neu da co du lieu nay trong db thi update
                upDate("phong_tbl", "p_gia = " + phong.getGia() + ",p_succhua = "
                  + phong.getSucchua() + ",P_loai = '" + phong.getLoai() + "',p_so = " + phong.getSo()
                  + ",p_tinhtrang = '" + phong.getTinhtrang() + "'", "p_id = " + phong.getId());
            } else {//neu chua co thi tao moi
                SerDB("phong_tbl(p_id,p_loai,p_so,p_gia,p_succhua,p_tinhTrang)", phong.getId() + ",'" + phong.getLoai()
                  + "'," + phong.getSo() + "," + phong.getGia() + "," + phong.getSucchua() + ",'" + phong.getTinhtrang() + "'");
            }
        }
        //luu khach hang
        for (int i = 0; i < khachAray.size(); i++) {
            KhachHang_cls khach = khachAray.get(i);
            if (CheckDB("select * from khachhang_tbl where kh_id = " + khach.getId())) {
                upDate("khachhang_tbl", "kh_ten = '" + khach.getTen() + "',kh_gioitinh = '" + khach.getGioiTinh() + "',kh_dienthoai = "
                  + khach.getDienthoai() + ",kh_tinhtrang = '" + khach.getTinhTrang() + "',kh_p_id = " + khach.getP_id() + ",kh_ngayden = '"
                  + formatTime.format(khach.getNgayDen()) + "',kh_ngaydi = '" + (khach.getNgayDi() != null ? formatTime.format(khach.getNgayDi()) : null)
                  + "',kh_songuoidicung=" + khach.getSoNguoi() + ",kh_cmnn = " + khach.getCmnn(), "kh_id = " + khach.getId());
            } else {
                SerDB("khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id,kh_songuoidicung,kh_ngayden,kh_ngaydi)",
                  khach.getId() + ",'" + khach.getTen() + "','" + khach.getGioiTinh() + "'," + khach.getCmnn() + "," + khach.getDienthoai()
                  + "'," + khach.getTinhTrang() + "'," + khach.getP_id() + "," + khach.getSoNguoi() + ",'" + formatTime.format(khach.getNgayDen())
                  + "','" + (khach.getNgayDi() != null ? formatTime.format(khach.getNgayDi()) : null));
            }
        }
        //luu dich vu
        for (int i = 0; i < dichVuAray.size(); i++) {
            DichVu_cls dv = dichVuAray.get(i);
            if (CheckDB("select * from dichvu_tbl where dv_id = " + dv.getId())) {
                upDate("dichvu_tbl", "dv_ten = '" + dv.getTen() + "',dv_gia = " + dv.getGia() + ",dv_thoigian = '"
                  + formatTime.format(dv.getThoiGian()) + "',dv_kh_id = " + dv.getKh_id() + ",dv_p_id = " + dv.getP_id()
                  + ",dv_tinhtrang = '" + dv.getTinhTrang() + "'", "dv_id = " + dv.getId());
            } else {
                SerDB("dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)", dv.getId() + ",'"
                  + dv.getTen() + "'," + dv.getGia() + ",'" + formatTime.format(dv.getThoiGian()) + "'," + dv.getKh_id()
                  + "," + dv.getP_id() + ",'" + dv.getTinhTrang() + "'");
            }
        }

    }
*/