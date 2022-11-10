package org.example.service;

//import org.example.fashionshop.model.ChiTietDonHang;

//import org.example.model.ChiTietDonHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
//import java.util.List;

public interface IDService extends Remote {

    public String createMaSanPham() throws RemoteException;;
    public String createMaDanhMuc() throws RemoteException;;
    public String createMaPhieuKiemKe() throws RemoteException;;
    public String createMaDonNhapHang() throws RemoteException;;
    public  String createMaPhieuNhapHang() throws RemoteException;;
    public  String createMaDonHang() throws RemoteException;;
    public  String createMaNhanVien() throws RemoteException;;

}
