package org.example.service;

//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.model.VaiTroQuyen;
//import javafx.collections.ObservableList;

import org.example.model.DanhMuc;
import org.example.model.VaiTroQuyen;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VaiTroQuyenService extends Remote {

    public List<VaiTroQuyen> getAllVaiTroQuyen()throws RemoteException;;

    public VaiTroQuyen getVaiTroQuyen(String maVaiTroQuyen)throws RemoteException;;

    public boolean addVaiTroQuyen(VaiTroQuyen vaiTroQuyen)throws RemoteException;;

    public boolean updateVaiTroQuyen(VaiTroQuyen vaiTroQuyen)throws RemoteException;;

    public boolean removeVaiTroQuyen(VaiTroQuyen vaiTroQuyen)throws RemoteException;;

//    public List<VaiTroQuyen> getAllVaiTroQuyenFromDanhMuc(DanhMuc danhMuc, int top)throws RemoteException;;
//
//    public List<VaiTroQuyen> getAllVaiTroQuyenFromDanhMuc(DanhMuc danhMuc)throws RemoteException;;
    public  boolean mergeVaiTroQuyen(VaiTroQuyen vaiTroQuyen)throws RemoteException;;

}
