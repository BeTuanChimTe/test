package org.example;

import com.google.gson.Gson;
import org.example.impl.*;
import org.example.model.*;
import org.example.service.*;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Server {
    private static ChiTietDonHangService chiTietDonHangService;
    private static ChucVuService chucVuService;
    private static DanhMucService danhMucService;
    private static DonNhapHangService donNhapHangService;
    private static KhachHangService khachHangService;
    private static KichThuocService kichThuocService;
    private static MauSacService mauSacService;
    private static NhaCungCapService nhaCungCapService;
    private static NhanVienService nhanVienService;
    private static NuocSanXuatService nuocSanXuatService;
    private static PhieuKiemKeService phieuKiemKeService;
    private static QuanHuyenService quanHuyenService ;
    private static SanPhamService sanPhamService ;
    private static ThuongHieuService thuongHieuService ;
    private static TinhTPService tinhTPService;
    private static DonHangService donHangService;

    private static XaPhuongService xaPhuongService ;
    private static TaiKhoanService taiKhoanService ;
    private static VaiTroService vaiTroService ;
    private static NhomQuyenService nhomQuyenService ;
    private static QuyenService quyenService ;
    private static VaiTroNhomQuyenService vaiTroNhomQuyenService ;
    private static VaiTroQuyenService vaiTroQuyenService ;
    private  static IDService idService;
    private static final String RES = "rmi://localhost:1307/FashionShop/";





    public static void main(String[] args) {
        try {
            idService =new IDServiceImpl();
            taiKhoanService = new TaiKhoanServiceImpl();
            chiTietDonHangService = new ChiTietDonHangServiceImpl();
            chucVuService = new ChucVuServiceImpl();
            danhMucService = new DanhMucImpl();
            donNhapHangService = new DonNhapHangImpl();
            khachHangService = new KhachHangServiceImpl();
            kichThuocService = new KichThuocImpl();
            mauSacService = new MauSacImpl();
            nhaCungCapService = new NhaCungCapImpl();
donHangService = new DonHangServiceImpl();
            nhanVienService = new NhanVienServiceImpl();
            nuocSanXuatService = new NuocSanXuatImpl();
            phieuKiemKeService = new PhieuKiemKeImpl();
            nhomQuyenService = new NhomQuyenServiceImpl();
            quanHuyenService = new QuanHuyenServiceImpl();
            sanPhamService = new SanPhamImpl();
            thuongHieuService = new ThuongHieuImpl();
            tinhTPService = new TinhTPServiceImpl();
            xaPhuongService = new XaPhuongServiceImpl();
            vaiTroService = new VaiTroServiceImpl();
quyenService = new QuyenServiceImpl();
            vaiTroNhomQuyenService=  new VaiTroNhomQuyenServiceImpl();
            vaiTroQuyenService = new VaiTroQuyenServiceImpl();

            importDLTinhTPVietNam();
            importData();
            LocateRegistry.createRegistry(1307);
            Context context = new InitialContext();
            context.bind(RES + "IDService", idService);
            context.bind(RES + "ChiTietDonHangService", chiTietDonHangService);
            context.bind(RES + "ChucVuService", chucVuService);
            context.bind(RES + "DanhMucService", danhMucService);
            context.bind(RES + "DonNhapHangService", donNhapHangService);
            context.bind(RES + "KhachHangService", khachHangService);
            context.bind(RES + "KichThuocService", kichThuocService);
            context.bind(RES + "MauSacService", mauSacService);
            context.bind(RES + "NhaCungCapService", nhaCungCapService);
            context.bind(RES + "NhanVienService", nhanVienService);
            context.bind(RES + "NuocSanXuatService", nuocSanXuatService);
            context.bind(RES + "PhieuKiemKeService", phieuKiemKeService);
            context.bind(RES + "QuanHuyenService", quanHuyenService);
            context.bind(RES + "SanPhamService", sanPhamService);
            context.bind(RES + "ThuongHieuService", thuongHieuService);
            context.bind(RES + "TinhTPService", tinhTPService);
            context.bind(RES + "DonHangService", donHangService);
            context.bind(RES + "XaPhuongService", xaPhuongService);
            context.bind(RES + "TaiKhoanService", taiKhoanService);
            context.bind(RES + "VaiTroService", vaiTroService);
            context.bind(RES + "NhomQuyenService", nhomQuyenService);
            context.bind(RES + "QuyenService", quyenService);
            context.bind(RES + "VaiTroNhomQuyenService", vaiTroNhomQuyenService);
            context.bind(RES + "VaiTroQuyenService", vaiTroQuyenService);
            System.out.println("Server đã sẵn sàng...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private static void importData() {
        try {
            KhachHang khachHang1 = new KhachHang("Nguyễn Thị Thu Mơ", "0966002637", "thumo@gmail.com",
                    new DiaChi(
                            tinhTPService. getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang2 = new KhachHang("Nguyễn Thanh Tùng", "0398161252", "thanhtung@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang3 = new KhachHang("Trần Thị An", "0396010594", "antran@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));

            KhachHang khachHang4 = new KhachHang("Lê Minh Thư", "0338123511", "khoc@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang5 = new KhachHang("Hoài Thị Lan", "0378956218", "thoimeta@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang6 = new KhachHang("Trần Tuấn Anh", "0390942132", "tuânnanhtran@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang7 = new KhachHang("Nguyễn Lan Khuê", "0389102523", "khue921@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang8 = new KhachHang("Đồng Văn Ngợ", "03984201321", "ngo123@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang9 = new KhachHang("Lương Cao Trúc", "07891235215", "caobang@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            KhachHang khachHang10 = new KhachHang("Hồ Ngọc Hà", "02391234562", "ngohan@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ));
            List<KhachHang> dsKhachHang = Arrays.asList(
                    khachHang1, khachHang2, khachHang3, khachHang4, khachHang5, khachHang6, khachHang7, khachHang8, khachHang9, khachHang10
            );
            for(KhachHang kh : dsKhachHang)
            khachHangService.addCustomer(kh);

            NhomQuyen nhomQuyen1 = new NhomQuyen("EMPLOYEES_PERMISSION", "Quản lý nhân viên");
            NhomQuyen nhomQuyen2 = new NhomQuyen("SELL_PERMISSION", "Bán hàng");
            NhomQuyen nhomQuyen3 = new NhomQuyen("BILL_PERMISSION", "Quản lý hóa đơn");
            NhomQuyen nhomQuyen4 = new NhomQuyen("STATISTIC_PERMISSION", "Báo cáo thống kê");
            NhomQuyen nhomQuyen5 = new NhomQuyen("CUSTOMER_PERMISSION", "Quản lý khách hàng");
            NhomQuyen nhomQuyen6 = new NhomQuyen("PRODUCT_PERMISSION", "Quản lý sản phẩm");
            NhomQuyen nhomQuyen7 = new NhomQuyen("CATEGORY_PERMISSION", "Quản lý danh mục");
            NhomQuyen nhomQuyen8 = new NhomQuyen("ROLE_SETTING_PERMISSION", "Thiết lập vai trò");
            NhomQuyen nhomQuyen9 = new NhomQuyen("EMPLOYEES_SUPER_PERMISSION", "Nhân viên");
            NhomQuyen nhomQuyen10 = new NhomQuyen("POSITION_PERMISISON", "Quản lý chức vụ");
            NhomQuyen nhomQuyen11 = new NhomQuyen("INVENTORY_PERMISSION", "Kiểm kê");
            NhomQuyen nhomQuyen12 = new NhomQuyen("SUPPLIER_PERMISSION", "Quản lý nhà cung cấp");
            NhomQuyen nhomQuyen13 = new NhomQuyen("SELL_SUPER_PERMISSION", "Bán hàng");
            NhomQuyen nhomQuyen14 = new NhomQuyen("PRODUCT_SUPER_PERMISSION", "Sản phẩm");
            NhomQuyen nhomQuyen15 = new NhomQuyen("STORE_MANAGER_PERMISSION", "Quản lý cửa hàng");

            List<NhomQuyen> dsNhomQuuyen = Arrays.asList(
                    nhomQuyen1, nhomQuyen2, nhomQuyen3, nhomQuyen4, nhomQuyen5, nhomQuyen6, nhomQuyen7, nhomQuyen8,
                    nhomQuyen9, nhomQuyen10, nhomQuyen11, nhomQuyen12, nhomQuyen13, nhomQuyen14, nhomQuyen15
            );
            for(NhomQuyen nq : dsNhomQuuyen)
                nhomQuyenService.addNhomQuyen(nq);
            Quyen quyen1 = new Quyen("CREATE_CUSTOMER", "Thêm khách hàng", nhomQuyen5);
            Quyen quyen2 = new Quyen("CREATE_EMPLOYEE", "Thêm nhân viên", nhomQuyen1);
            Quyen quyen3 = new Quyen("CREATE_ORDER", "Tạo don hàng", nhomQuyen2);
            Quyen quyen4 = new Quyen("CREATE_PRODCUT", "Thêm sản phẩm", nhomQuyen6);
            Quyen quyen5 = new Quyen("DELETE_CUSTOMER", "Xóa khách hàng", nhomQuyen5);
            Quyen quyen6 = new Quyen("DELETE_EMPLOYEE", "Xóa nhân viên", nhomQuyen1);
            Quyen quyen7 = new Quyen("DELETE_PRODUCT", "Xóa sản phẩm", nhomQuyen6);
            Quyen quyen8 = new Quyen("READ_CUSTOMER", "Xem thông tin khách hàng", nhomQuyen5);
            Quyen quyen9 = new Quyen("READ_EMPLOYEE", "Xem thông tin nhân viên", nhomQuyen1);
            Quyen quyen10 = new Quyen("READ_ORDER", "Xem thông tin don hàng", nhomQuyen2);
            Quyen quyen11 = new Quyen("READ_PRODUCT", "Xem thông tin sản phẩm", nhomQuyen6);
            Quyen quyen12 = new Quyen("UPDATE_CUSTOMER", "Cập nhật thông tin khách hàng", nhomQuyen5);
            Quyen quyen13 = new Quyen("UPDATE_EMPLOYEE", "Cập nhật thông tin nhân viên", nhomQuyen1);
            Quyen quyen14 = new Quyen("UPDATE_PRODUCT", "Cập nhật thông tin sản phẩm", nhomQuyen6);
            Quyen quyen15 = new Quyen("INVENTORY", "Thực hiện kiểm kê", nhomQuyen11);
            Quyen quyen16 = new Quyen("CREATE_INVENTORY_SHEET", "Thêm phiếu kiểm kê", nhomQuyen11);
            Quyen quyen17 = new Quyen("UPDATE_INVENTORY_SHEET", "Cập nhật phiếu kiểm kê", nhomQuyen11);
            Quyen quyen18 = new Quyen("DELETE_INVENTORY_SHEET", "Xóa phiếu kiểm kê", nhomQuyen11);

            List<Quyen> dsQuyen = Arrays.asList(
                    quyen1, quyen2, quyen3, quyen4, quyen5, quyen6, quyen7, quyen8, quyen9, quyen10, quyen11,
                    quyen12, quyen13, quyen14, quyen15, quyen16, quyen17, quyen18
            );
            for(Quyen q : dsQuyen)
                quyenService.addQuyen(q);
            VaiTro vaiTro1 = new VaiTro("Chủ cửa hàng");
            VaiTro vaiTro2 = new VaiTro("Quản lý");
            VaiTro vaiTro3 = new VaiTro("Nhân viên bán hàng");

            List<VaiTro> dsVaiTro = Arrays.asList(vaiTro1, vaiTro2, vaiTro3);
            for(VaiTro vt : dsVaiTro)
                vaiTroService.addVaiTro(vt);


            VaiTroNhomQuyen vaiTroNhomQuyen101 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen1, true);
            VaiTroNhomQuyen vaiTroNhomQuyen102 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen2, true);
            VaiTroNhomQuyen vaiTroNhomQuyen103 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen3, true);
            VaiTroNhomQuyen vaiTroNhomQuyen104 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen4, true);
            VaiTroNhomQuyen vaiTroNhomQuyen105 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen5, true);
            VaiTroNhomQuyen vaiTroNhomQuyen106 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen6, true);
            VaiTroNhomQuyen vaiTroNhomQuyen107 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen7, true);
            VaiTroNhomQuyen vaiTroNhomQuyen108 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen8, true);
            VaiTroNhomQuyen vaiTroNhomQuyen109 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen9, true);
            VaiTroNhomQuyen vaiTroNhomQuyen110 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen10, true);
            VaiTroNhomQuyen vaiTroNhomQuyen111 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen11, true);
            VaiTroNhomQuyen vaiTroNhomQuyen112 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen12, true);
            VaiTroNhomQuyen vaiTroNhomQuyen113 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen13, true);
            VaiTroNhomQuyen vaiTroNhomQuyen114 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen14, true);
            VaiTroNhomQuyen vaiTroNhomQuyen115 = new VaiTroNhomQuyen(vaiTro1, nhomQuyen15, true);

            VaiTroNhomQuyen vaiTroNhomQuyen301 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen1, false);
            VaiTroNhomQuyen vaiTroNhomQuyen302 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen2, true);
            VaiTroNhomQuyen vaiTroNhomQuyen303 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen3, true);
            VaiTroNhomQuyen vaiTroNhomQuyen304 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen4, true);
            VaiTroNhomQuyen vaiTroNhomQuyen305 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen5, true);
            VaiTroNhomQuyen vaiTroNhomQuyen306 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen6, true);
            VaiTroNhomQuyen vaiTroNhomQuyen307 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen7, true);
            VaiTroNhomQuyen vaiTroNhomQuyen308 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen8, false);
            VaiTroNhomQuyen vaiTroNhomQuyen309 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen9, false);
            VaiTroNhomQuyen vaiTroNhomQuyen310 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen10, false);
            VaiTroNhomQuyen vaiTroNhomQuyen311 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen11, true);
            VaiTroNhomQuyen vaiTroNhomQuyen312 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen12, false);
            VaiTroNhomQuyen vaiTroNhomQuyen313 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen13, true);
            VaiTroNhomQuyen vaiTroNhomQuyen314 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen14, true);
            VaiTroNhomQuyen vaiTroNhomQuyen315 = new VaiTroNhomQuyen(vaiTro3, nhomQuyen15, false);

            List<VaiTroNhomQuyen> dsVaiTroNhomQuyen = Arrays.asList(
                    vaiTroNhomQuyen101, vaiTroNhomQuyen102, vaiTroNhomQuyen103, vaiTroNhomQuyen104, vaiTroNhomQuyen105,
                    vaiTroNhomQuyen106, vaiTroNhomQuyen107, vaiTroNhomQuyen108, vaiTroNhomQuyen109, vaiTroNhomQuyen110,
                    vaiTroNhomQuyen111, vaiTroNhomQuyen112, vaiTroNhomQuyen113, vaiTroNhomQuyen114, vaiTroNhomQuyen115,
                    vaiTroNhomQuyen301, vaiTroNhomQuyen302, vaiTroNhomQuyen303, vaiTroNhomQuyen304, vaiTroNhomQuyen305,
                    vaiTroNhomQuyen306, vaiTroNhomQuyen307, vaiTroNhomQuyen308, vaiTroNhomQuyen309, vaiTroNhomQuyen310,
                    vaiTroNhomQuyen311, vaiTroNhomQuyen312, vaiTroNhomQuyen313, vaiTroNhomQuyen314, vaiTroNhomQuyen315
            );
            for(VaiTroNhomQuyen vtnq : dsVaiTroNhomQuyen)
                vaiTroNhomQuyenService.mergeVaiTroNhomQuyen(vtnq);
            VaiTroQuyen vaiTroQuyen101 = new VaiTroQuyen(vaiTroNhomQuyen105, quyen1, true);
            VaiTroQuyen vaiTroQuyen102 = new VaiTroQuyen(vaiTroNhomQuyen101, quyen2, true);
            VaiTroQuyen vaiTroQuyen103 = new VaiTroQuyen(vaiTroNhomQuyen102, quyen3, true);
            VaiTroQuyen vaiTroQuyen104 = new VaiTroQuyen(vaiTroNhomQuyen106, quyen4, true);
            VaiTroQuyen vaiTroQuyen105 = new VaiTroQuyen(vaiTroNhomQuyen105, quyen5, true);
            VaiTroQuyen vaiTroQuyen106 = new VaiTroQuyen(vaiTroNhomQuyen101, quyen6, true);
            VaiTroQuyen vaiTroQuyen107 = new VaiTroQuyen(vaiTroNhomQuyen106, quyen7, true);
            VaiTroQuyen vaiTroQuyen108 = new VaiTroQuyen(vaiTroNhomQuyen105, quyen8, true);
            VaiTroQuyen vaiTroQuyen109 = new VaiTroQuyen(vaiTroNhomQuyen101, quyen9, true);
            VaiTroQuyen vaiTroQuyen110 = new VaiTroQuyen(vaiTroNhomQuyen102, quyen10, true);
            VaiTroQuyen vaiTroQuyen111 = new VaiTroQuyen(vaiTroNhomQuyen106, quyen11, true);
            VaiTroQuyen vaiTroQuyen112 = new VaiTroQuyen(vaiTroNhomQuyen105, quyen12, true);
            VaiTroQuyen vaiTroQuyen113 = new VaiTroQuyen(vaiTroNhomQuyen101, quyen13, true);
            VaiTroQuyen vaiTroQuyen114 = new VaiTroQuyen(vaiTroNhomQuyen106, quyen14, true);
            VaiTroQuyen vaiTroQuyen115 = new VaiTroQuyen(vaiTroNhomQuyen111, quyen15, true);
            VaiTroQuyen vaiTroQuyen116 = new VaiTroQuyen(vaiTroNhomQuyen111, quyen16, true);
            VaiTroQuyen vaiTroQuyen117 = new VaiTroQuyen(vaiTroNhomQuyen111, quyen17, true);
            VaiTroQuyen vaiTroQuyen118 = new VaiTroQuyen(vaiTroNhomQuyen111, quyen18, true);

            VaiTroQuyen vaiTroQuyen301 = new VaiTroQuyen(vaiTroNhomQuyen305, quyen1, true);
            VaiTroQuyen vaiTroQuyen302 = new VaiTroQuyen(vaiTroNhomQuyen301, quyen2, false);
            VaiTroQuyen vaiTroQuyen303 = new VaiTroQuyen(vaiTroNhomQuyen302, quyen3, true);
            VaiTroQuyen vaiTroQuyen304 = new VaiTroQuyen(vaiTroNhomQuyen306, quyen4, true);
            VaiTroQuyen vaiTroQuyen305 = new VaiTroQuyen(vaiTroNhomQuyen305, quyen5, true);
            VaiTroQuyen vaiTroQuyen306 = new VaiTroQuyen(vaiTroNhomQuyen301, quyen6, false);
            VaiTroQuyen vaiTroQuyen307 = new VaiTroQuyen(vaiTroNhomQuyen306, quyen7, true);
            VaiTroQuyen vaiTroQuyen308 = new VaiTroQuyen(vaiTroNhomQuyen305, quyen8, true);
            VaiTroQuyen vaiTroQuyen309 = new VaiTroQuyen(vaiTroNhomQuyen301, quyen9, false);
            VaiTroQuyen vaiTroQuyen310 = new VaiTroQuyen(vaiTroNhomQuyen302, quyen10, true);
            VaiTroQuyen vaiTroQuyen311 = new VaiTroQuyen(vaiTroNhomQuyen306, quyen11, true);
            VaiTroQuyen vaiTroQuyen312 = new VaiTroQuyen(vaiTroNhomQuyen305, quyen12, true);
            VaiTroQuyen vaiTroQuyen313 = new VaiTroQuyen(vaiTroNhomQuyen301, quyen13, false);
            VaiTroQuyen vaiTroQuyen314 = new VaiTroQuyen(vaiTroNhomQuyen306, quyen14, true);
            VaiTroQuyen vaiTroQuyen315 = new VaiTroQuyen(vaiTroNhomQuyen311, quyen15, true);
            VaiTroQuyen vaiTroQuyen316 = new VaiTroQuyen(vaiTroNhomQuyen311, quyen16, false);
            VaiTroQuyen vaiTroQuyen317 = new VaiTroQuyen(vaiTroNhomQuyen311, quyen17, false);
            VaiTroQuyen vaiTroQuyen318 = new VaiTroQuyen(vaiTroNhomQuyen311, quyen18, false);

            List<VaiTroQuyen> dsVaiTroQuyen = Arrays.asList(
                    vaiTroQuyen101, vaiTroQuyen102, vaiTroQuyen103, vaiTroQuyen104, vaiTroQuyen105, vaiTroQuyen106,
                    vaiTroQuyen107, vaiTroQuyen108, vaiTroQuyen109, vaiTroQuyen110, vaiTroQuyen111, vaiTroQuyen112,
                    vaiTroQuyen113, vaiTroQuyen114, vaiTroQuyen115, vaiTroQuyen116, vaiTroQuyen117, vaiTroQuyen118,
                    vaiTroQuyen301, vaiTroQuyen302, vaiTroQuyen303, vaiTroQuyen304, vaiTroQuyen305, vaiTroQuyen306,
                    vaiTroQuyen307, vaiTroQuyen308, vaiTroQuyen309, vaiTroQuyen310, vaiTroQuyen311, vaiTroQuyen312,
                    vaiTroQuyen313, vaiTroQuyen314, vaiTroQuyen315, vaiTroQuyen316, vaiTroQuyen317, vaiTroQuyen318
            );
            for(VaiTroQuyen vtq : dsVaiTroQuyen)
                vaiTroQuyenService.mergeVaiTroQuyen(vtq);
            ChucVu chucVu1 = new ChucVu("Chủ cửa hàng");
            ChucVu chucVu2 = new ChucVu("Quản lý");
            ChucVu chucVu3 = new ChucVu("Nhân viên");



            List<ChucVu> dsChucVu = Arrays.asList(chucVu1, chucVu2, chucVu3);
            NhanVien nhanVien1 = new NhanVien(
                    "1307",
                    "Nguyễn Văn A",
                    new Date(2022, 1, 1),
                    true,
                    "123456789012",
                    "1234567890",
                    "nguyenvana@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ),
                    "",
                    chucVu1
            );

            NhanVien nhanVien2 = new NhanVien(
                    "12345678",
                    "Vo Thi Cam Xuan",
                    new Date(2022, 1, 1),
                    false,
                    "123456789012",
                    "1234567890",
                    "nguyenthithumo@gmail.com",
                    new DiaChi(
                            tinhTPService.getTinhTPById("87"),
                            quanHuyenService.getQuanHuyenById("875"),
                            xaPhuongService.getXaPhuongById("30190"),
                            "4/10 Nguyễn Văn Bản"
                    ),
                    "",
                    chucVu3
            );
//            List<ChucVu> dsChucVu = Arrays.asList(chucVu1, chucVu2, chucVu3);
            for(ChucVu cv : dsChucVu)
                chucVuService.addChucVu(cv);
            List<NhanVien> dsNhanVien = Arrays.asList(nhanVien1, nhanVien2);
//            for(NhanVien nv : dsNhanVien)
//                nhanVienService.addNhanVien(nv);
            TaiKhoan taiKhoan1 = new TaiKhoan(
                    nhanVien1,
                    "5ec6a783e406acba60b60d914b9e00992e92ae289bf5a0f38ed2ce34ce304370",
                    "5509a9da-19fa-4334-90aa-e7312129652c",
                    true,
                    vaiTro1
            );

            TaiKhoan taiKhoan2 = new TaiKhoan(
                    nhanVien2,
                    "5ec6a783e406acba60b60d914b9e00992e92ae289bf5a0f38ed2ce34ce304370",
                    "5509a9da-19fa-4334-90aa-e7312129652c",
                    true,
                    vaiTro3
            );

            List<TaiKhoan> dsTaiKhoan = Arrays.asList(taiKhoan1, taiKhoan2);
            for(TaiKhoan tk : dsTaiKhoan)
                taiKhoanService.addTaiKhoan(tk);
//
//
//
            DanhMuc danhMuc1 = new DanhMuc("All", true);
            DanhMuc danhMuc2 = new DanhMuc("Nam", true);
            DanhMuc danhMuc3 = new DanhMuc("Nữ", true);
            DanhMuc danhMuc4 = new DanhMuc("Áo khoác", true);
            DanhMuc danhMuc5 = new DanhMuc("Áo thun", true);
            DanhMuc danhMuc6 = new DanhMuc("Áo sơ mi", true);
//
            List<DanhMuc> dsDanhMuc = Arrays.asList(
                    danhMuc1, danhMuc2, danhMuc3, danhMuc4, danhMuc5, danhMuc6
            );
            for(DanhMuc dm : dsDanhMuc)
                danhMucService.addCategory(dm);
////
            MauSac mauSac1 = new MauSac("Đen", "#000000");
            MauSac mauSac2 = new MauSac("Trắng", "#FFFFFF");
            MauSac mauSac3 = new MauSac("Vàng", "#7BFF00");
            MauSac mauSac4 = new MauSac("Xanh", "#4C9CFF");
            MauSac mauSac5 = new MauSac("Xanh lục", "#889144");
            MauSac mauSac6 = new MauSac("Cam", "#CC8B11");
////
////
            List<MauSac> dsMauSac = Arrays.asList(
                    mauSac1, mauSac2, mauSac3, mauSac4, mauSac5, mauSac6
            );
            for(MauSac ms : dsMauSac)
                mauSacService.addMauSac(ms);
////
            KichThuoc kichThuoc1 = new KichThuoc("XS");
            KichThuoc kichThuoc2 = new KichThuoc("S");
            KichThuoc kichThuoc3 = new KichThuoc("M");
            KichThuoc kichThuoc4 = new KichThuoc("L");
            KichThuoc kichThuoc5 = new KichThuoc("XL");
            KichThuoc kichThuoc6 = new KichThuoc("XXL");

            List<KichThuoc> dsKichThuoc = Arrays.asList(
                    kichThuoc1, kichThuoc2, kichThuoc3, kichThuoc4, kichThuoc5, kichThuoc6
            );
            for(KichThuoc kt : dsKichThuoc)
                kichThuocService.addKichThuoc(kt);
//
            ThuongHieu thuongHieu1 = new ThuongHieu("No Brand");
            ThuongHieu thuongHieu2 = new ThuongHieu("UNIQLO");
            ThuongHieu thuongHieu3 = new ThuongHieu("Adidas");
            ThuongHieu thuongHieu4 = new ThuongHieu("Owen");

            List<ThuongHieu> dsThuongHieu = Arrays.asList(
                    thuongHieu1, thuongHieu2, thuongHieu3, thuongHieu4
            );
            for(ThuongHieu th : dsThuongHieu)
                thuongHieuService.addThuongHieu(th);
//
            SanPham sanPham1 = new SanPham(
                    "Áo Parka Blocktech (3D Cut)",
                    1471000,
                    1500000,
                    "Mô tả",
                    "https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/433063/item/goods_69_433063.jpg?width=1600&impolicy=quality_75",
                    3,
                    danhMuc4,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu2
            );

            SanPham sanPham2 = new SanPham(
                    "AIRism Áo Polo Ngắn Tay",
                    489000,
                    500000,
                    "Mô tả",
                    "https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/441604/item/goods_00_441604.jpg?width=1600&impolicy=quality_75",
                    5,
                    danhMuc5,
                    mauSac1,
                    kichThuoc2,
                    thuongHieu2
            );

            SanPham sanPham3 = new SanPham(
                    "Áo Sơ Mi Không Cần Ủi Slim Fit Dài Tay",
                    686000,
                    700000,
                    "Mô tả",
                    "https://image.uniqlo.com/UQ/ST3/AsianCommon/imagesgoods/427168/item/goods_60_427168.jpg?width=1600&impolicy=quality_75",
                    2,
                    danhMuc6,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu2
            );

            SanPham sanPham4 = new SanPham(
                    "Áo thun nam nữ tay lỡ unisex oversize áo phông form rộng basic tee",
                    99000,
                    170000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fshopee.vn%2FBST-%25C3%25A1o-thun-m%25C3%25B9a-h%25C3%25A8-th%25E1%25BB%259Di-trang-nam-cotton-v%25E1%25BA%25A3i-d%25C3%25A0y-m%25E1%25BB%258Bn-i.58845938.11356997243&psig=AOvVaw1UMUCjekMY7MKGo6B6FHJM&ust=1667361085463000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCPDko5yKjPsCFQAAAAAdAAAAABAE",
                    10,
                    danhMuc2,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu2
            );
            SanPham sanPham5 = new SanPham(
                    "Tee Generation – Black",
                    100000,
                    130000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://hidanz.com/wp-content/uploads/2021/01/ao-nam-dep.jpg",
                    25,
                    danhMuc3,
                    mauSac3,
                    kichThuoc2,
                    thuongHieu2
            );
            SanPham sanPham6 = new SanPham(
                    "Tee Hidanz Smile – Cream",
                    170000,
                    300000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://hidanz.com/wp-content/uploads/2022/08/Dm7-be-1-300x400.jpg",
                    10,
                    danhMuc5,
                    mauSac2,
                    kichThuoc2,
                    thuongHieu3
            );
            SanPham sanPham7 = new SanPham(
                    "Tee Meomeo – White",
                    290000,
                    350000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://hidanz.com/wp-content/uploads/2022/09/White1-1-300x400.jpg",
                    10,
                    danhMuc3,
                    mauSac2,
                    kichThuoc3,
                    thuongHieu4
            );
            SanPham sanPham8 = new SanPham(
                    "Tee Rainbow – White",
                    250000,
                    400000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://hidanz.com/wp-content/uploads/2022/08/Dm3-trang-3-300x400.jpg",
                    10,
                    danhMuc5,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu2
            );
            SanPham sanPham9 = new SanPham(
                    "Áo Sơ Mi Tay Dài Sợi Modal Tối Giản M11",
                    230000,
                    370000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://cdn2.yame.vn/pimg/so-mi-nam-no-style-td-km18-0018246/31aadf2f-485f-0200-f8e0-001823d06909.jpg?w=540&h=756",
                    3,
                    danhMuc6,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu2
            );
            SanPham sanPham10 = new SanPham(
                    "Quần Baggy Nữ Quần Tây Công Sở Lưng Cao 2 Cúc Ngang Minxinh Chất Vải Tuyết Mưa",
                    290000,
                    330000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://cf.shopee.vn/file/8cec0751ff253299ba9cf80ca8e8a0f8",
                    10,
                    danhMuc3,
                    mauSac4,
                    kichThuoc1,
                    thuongHieu2
            );
            SanPham sanPham11 = new SanPham(
                    "Quần Short nữ",
                    90000,
                    900000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://product.hstatic.net/200000560555/product/quan-sort-nu._a3e36a9e67e44cf3a86dbb805e4bbb66_1024x1024.png",
                    5,
                    danhMuc3,
                    mauSac1,
                    kichThuoc1,
                    thuongHieu4
            );
            SanPham sanPham12 = new SanPham(
                    "Áo Khoác Nấm Degrey Đỏ - AKND Đỏ",
                    99000,
                    170000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://product.hstatic.net/1000281824/product/1985_caba01a0b5464c4baed6f7609c8e7540_master.jpg",
                    4,
                    danhMuc4,
                    mauSac2,
                    kichThuoc4,
                    thuongHieu4
            );
            SanPham sanPham13 = new SanPham(
                    "Áo khoác rất mát",
                    99000,
                    170000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://salt.tikicdn.com/cache/w1200/ts/product/be/c9/37/39d811ed127638a6ec0d66c9e806e64d.jpg",
                    2,
                    danhMuc4,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu2
            );
            SanPham sanPham14 = new SanPham(
                    "Váy Tennis",
                    500000,
                    650000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://salt.tikicdn.com/cache/550x550/ts/product/89/74/27/50d3fbe70192e98bdef3232843e73290.jpg",
                    10,
                    danhMuc3,
                    mauSac1,
                    kichThuoc3,
                    thuongHieu3
            );
            SanPham sanPham15 = new SanPham(
                    "",
                    450000,
                    630000,
                    "Vải thun mỏng nhưng thoáng mát",
                    "https://vn-test-11.slatic.net/p/beb978cd27b77ca94f752a825a70dd01.jpg",
                    15,
                    danhMuc5,
                    mauSac2,
                    kichThuoc3,
                    thuongHieu2
            );

            List<SanPham> dsSanPham = Arrays.asList(
                    sanPham1, sanPham2, sanPham3, sanPham4, sanPham5, sanPham6, sanPham7, sanPham8, sanPham9, sanPham10, sanPham11,
                    sanPham12,sanPham13, sanPham14, sanPham15
            );
            for(SanPham sp : dsSanPham)
                sanPhamService.mergeSanPham(sp);
            NhaCungCap nhaCungCap1 = new NhaCungCap("UNIQLO VIETNAM CO., LTD", "0315304731", "uniqlo@gmail.com", "Địa chỉ trụ sở doanh nghiệp: Tầng 26, Tòa nhà Trụ Sở Điều Hành Và Trung Tâm Thương Mại Viettel, 285 Cách Mạng Tháng Tám, Phường 12, Quận 10, Thành phố Hồ Chí Minh");
            NhaCungCap nhaCungCap2 = new NhaCungCap("CÔNG TY CỔ PHẦN THỜI TRANG KOWIL VIỆT NAM", "1900 8079", "owen@gmail.com", "186A Nam Kỳ Khởi Nghĩa, Phường Võ Thị Sáu, Quận 3, TP.HCM");

            List<NhaCungCap> dsNhaCungCap = Arrays.asList(
                    nhaCungCap1, nhaCungCap2
            );
            for(NhaCungCap ncc : dsNhaCungCap)
                nhaCungCapService.addNhaCungCap(ncc);
//
            PhieuKiemKe phieuKiemKe1 = new PhieuKiemKe(
                    LocalDateTime.now(),
                    PhieuKiemKeStatus.TAO_MOI_CHO_KIEM_KE,
                    nhanVien1
            );

            List<PhieuKiemKe> dsPhieuKiemKe = Arrays.asList(phieuKiemKe1);

//
            ChiTietPhieuKiem chiTietPhieuKiem2 = new ChiTietPhieuKiem(phieuKiemKe1, sanPham2);
            chiTietPhieuKiem2.setSoLuongThucTe(chiTietPhieuKiem2.getSoLuongHeThong());
            ChiTietPhieuKiem chiTietPhieuKiem3 = new ChiTietPhieuKiem(phieuKiemKe1, sanPham3);
            chiTietPhieuKiem3.setSoLuongThucTe(chiTietPhieuKiem3.getSoLuongHeThong());

            List<ChiTietPhieuKiem> dsChiTietPhieuKiem = Arrays.asList(
                    chiTietPhieuKiem2, chiTietPhieuKiem3
            );
//            for(ChiTietPhieuKiem cttpkk : dsChiTietPhieuKiem)
//                chi.addPhieuKiemKe(pkk);
//
            phieuKiemKe1.setChiTietPhieuKiems(
                    chiTietPhieuKiem2, chiTietPhieuKiem3
            );
            for(PhieuKiemKe pkk : dsPhieuKiemKe)
                phieuKiemKeService.addPhieuKiemKe(pkk);
//
            DonNhapHang donNhapHang1 = new DonNhapHang(
                    LocalDateTime.now(),
                    DonNhapHangStatus.TAO_MOI,
                    nhanVien1,
                    nhaCungCap1
            );

            List<DonNhapHang> dsDonNhapHang = Arrays.asList(
                    donNhapHang1
            );

//
            ChiTietDonNhapHang chiTietDonNhapHang1 = new ChiTietDonNhapHang(donNhapHang1, sanPham1, 2);
            ChiTietDonNhapHang chiTietDonNhapHang2 = new ChiTietDonNhapHang(donNhapHang1, sanPham2, 5);
            ChiTietDonNhapHang chiTietDonNhapHang3 = new ChiTietDonNhapHang(donNhapHang1, sanPham3, 1);

            List<ChiTietDonNhapHang> dsChiTietDonNhapHang = Arrays.asList(
                    chiTietDonNhapHang1, chiTietDonNhapHang2, chiTietDonNhapHang3
            );

            donNhapHang1.setChiTietDonNhapHangs(
                    chiTietDonNhapHang1, chiTietDonNhapHang2, chiTietDonNhapHang3
            );
            for(DonNhapHang dnh : dsDonNhapHang)
                donNhapHangService.addDonNhapHang(dnh);
//
//
            DonHang donHang1 = new DonHang(
                    "12345",
                    LocalDateTime.of(2022, 10, 27, 13, 10),
                    "Upppppppp",
                    nhanVien1,
                    khachHang1
            );
            ChiTietDonHang chiTietDonHang1 = new ChiTietDonHang(
                    donHang1,
                    sanPham1,
                    sanPham1.getGiaBan(),
                    2
            );
            ChiTietDonHang chiTietDonHang2 = new ChiTietDonHang(
                    donHang1,
                    sanPham2,
                    sanPham2.getGiaBan(),
                    1
            );
            List<ChiTietDonHang> dsChiTietDonHang = Arrays.asList(
                    chiTietDonHang1,
                    chiTietDonHang2
            );

//
            donHang1.setChiTietDonHangs(dsChiTietDonHang);

            List<DonHang> dsDonHang = Arrays.asList(
                    donHang1
            );
            for(DonHang dh : dsDonHang)
                donHangService.addDonHang(dh);
            for(ChiTietDonHang ctdh : dsChiTietDonHang)
                chiTietDonHangService.mergerChiTietDonHang(ctdh);
//
            Session session = HibernateUtlis.getSession();
            Transaction transaction = session.getTransaction();
            try {
                transaction.begin();

                for (NhomQuyen nhomQuyen : dsNhomQuuyen) {
                    session.persist(nhomQuyen);
                }

//                for(Quyen quyen : dsQuyen) {
//                    session.persist(quyen);
//                }
//
//                for(VaiTro vaiTro : dsVaiTro) {
//                    session.persist(vaiTro);
//                }
//
//                for(VaiTroNhomQuyen vaiTroNhomQuyen : dsVaiTroNhomQuyen) {
//                    session.persist(vaiTroNhomQuyen);
//                }
//
//                for(VaiTroQuyen vaiTroQuyen : dsVaiTroQuyen) {
//                    session.persist(vaiTroQuyen);
//                }
//
//                for(ChucVu chucVu : dsChucVu) {
//                    session.persist(chucVu);
//                }
//
//                for (NhanVien nhanVien : dsNhanVien) {
//                    session.persist(nhanVien);
//                }
//
//                for (TaiKhoan taiKhoan : dsTaiKhoan) {
//                    session.persist(taiKhoan);
//                }
//
//                for (MauSac mauSac : dsMauSac) {
//                    session.persist(mauSac);
//                }
//
//                for(KichThuoc kichThuoc : dsKichThuoc) {
//                    session.persist(kichThuoc);
//                }
//
//                for (ThuongHieu thuongHieu : dsThuongHieu) {
//                    session.persist(thuongHieu);
//                }
//
//                for (KhachHang khachHang : dsKhachHang) {
//                    session.persist(khachHang);
//                }
//
//                for (NhaCungCap nhaCungCap : dsNhaCungCap) {
//                    session.persist(nhaCungCap);
//                }
//
//                transaction.commit();
//
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }












        }
        catch (Exception exception){
            exception.printStackTrace();
        };

    }
    private static void importDLTinhTPVietNam() {
        List<TinhTP> dsTinhTP = new ArrayList<>();
        List<QuanHuyen> dsQuanHuyen = new ArrayList<>();
        List<XaPhuong> dsXaPhuong = new ArrayList<>();

        try {
            JsonParser parser = Json.createParser(new FileInputStream("data/tinh_tp.json"));

            Gson gson = new Gson();

            String key = null;
            while(parser.hasNext()) {
                JsonParser.Event event = parser.next();
                if(event == JsonParser.Event.KEY_NAME) {
                    key = parser.getString();
                }
                if(event == JsonParser.Event.START_OBJECT && key != null) {
                    JsonObject jsonObject = parser.getObject();
                    TinhTP tinhTP = gson.fromJson(jsonObject.toString(), TinhTP.class);
                    dsTinhTP.add(tinhTP);
                }
            }

            JsonParser parser1 = Json.createParser(new FileInputStream("data/quan_huyen.json"));
            String key1 = null;
//            System.out.println(dsTinhTP);
            while(parser1.hasNext()) {
                JsonParser.Event event = parser1.next();
                if(event == JsonParser.Event.KEY_NAME) {
                    key1 = parser1.getString();
                }
                if(event == JsonParser.Event.START_OBJECT && key1 != null) {
                    JsonObject jsonObject = parser1.getObject();
                    QuanHuyen quanHuyen = gson.fromJson(jsonObject.toString(), QuanHuyen.class);
                    String parentCode = jsonObject.getString("parent_code");
                    TinhTP tinhTP = dsTinhTP.get(dsTinhTP.indexOf(new TinhTP(parentCode)));
                    quanHuyen.setTinhTP(tinhTP);
                    tinhTP.getDsQuanHuyen().add(quanHuyen);
                    dsQuanHuyen.add(quanHuyen);
                }
            }


            JsonParser parser2 = Json.createParser(new FileInputStream("data/xa_phuong.json"));
            String key2 = null;
            while(parser2.hasNext()) {
                JsonParser.Event event = parser2.next();
                if(event == JsonParser.Event.KEY_NAME) {
                    key2 = parser2.getString();
                }
                if(event == JsonParser.Event.START_OBJECT && key2 != null) {
                    JsonObject jsonObject = parser2.getObject();
                    XaPhuong xaPhuong = gson.fromJson(jsonObject.toString(), XaPhuong.class);
                    String parentCode = jsonObject.getString("parent_code");
                    QuanHuyen quanHuyen = dsQuanHuyen.get(dsQuanHuyen.indexOf(new QuanHuyen(parentCode)));
                    xaPhuong.setQuanHuyen(quanHuyen);
                    quanHuyen.getDsXaPhuong().add(xaPhuong);
                    dsXaPhuong.add(xaPhuong);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            for(TinhTP tinhTP : dsTinhTP) tinhTPService.addTinhTP(tinhTP);
            for(QuanHuyen quanHuyen : dsQuanHuyen) quanHuyenService.addQuanHuyen(quanHuyen);
            for(XaPhuong xaPhuong : dsXaPhuong) xaPhuongService.addXaPhuong(xaPhuong);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}