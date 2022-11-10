package org.example.service;

//import org.example.fashionshop.model.ChiTietDonHang;

import org.example.model.ChiTietDonHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTietDonHangService extends Remote {

    public boolean addChiTietDonHang(ChiTietDonHang chiTietDonHang) throws RemoteException;;
    public boolean addAllChiTietDonHang(List<ChiTietDonHang> chiTietDonHangs) throws RemoteException;;
    public boolean mergerChiTietDonHang(ChiTietDonHang chiTietDonHang) throws RemoteException;;

}
