package org.example.service;

//import com.example.fashionshop.model.DanhMuc;
//import javafx.collections.ObservableList;

import org.example.model.DanhMuc;
import org.example.model.TaiKhoan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaiKhoanService extends Remote {

    public List<TaiKhoan> getAllTaiKhoan() throws RemoteException;;

    public boolean addTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;;

    public boolean updateTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;;

    public boolean removeTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;;

    public TaiKhoan getTaiKhoanById(String maNhanVien)throws RemoteException;;
    public boolean mergeTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;;


}
