package org.example.service;

//import com.example.fashionshop.model.Quyen;
//import javafx.collections.ObservableList;

import org.example.model.Quyen;
import org.example.model.SanPham;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuyenService extends Remote {

    public List<Quyen> getAllQuyen()throws RemoteException;;

//    public Quyen getQuyen(int brandId)throws RemoteException;;

    public  boolean addQuyen(Quyen quyen)throws RemoteException;;

    public boolean updateQuyen(Quyen quyen)throws RemoteException;;

    public boolean deleteQuyen(Quyen quyen)throws RemoteException;;

    public  boolean mergeQuyen(Quyen quyen)throws RemoteException;;
}
