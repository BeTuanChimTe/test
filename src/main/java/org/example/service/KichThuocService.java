package org.example.service;

//import com.example.fashionshop.model.KichThuoc;
//import javafx.collections.ObservableList;

import org.example.model.KichThuoc;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KichThuocService extends Remote {

    public List<KichThuoc> getAllKichThuoc()throws RemoteException;;

    public KichThuoc getKichThuoc(int sizeId)throws RemoteException;;

    boolean addKichThuoc(KichThuoc kichThuoc)throws RemoteException;;

    boolean updateKichThuoc(KichThuoc kichThuoc)throws RemoteException;;

    boolean deleteKichThuoc(KichThuoc kichThuoc)throws RemoteException;;
}
