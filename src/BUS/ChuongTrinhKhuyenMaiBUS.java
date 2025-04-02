
package BUS;
import DTO.ChuongTrinhKhuyenMaiDTO;
import DAO.ChuongTrinhKhuyenMaiDAO;
import java.util.ArrayList;
public class ChuongTrinhKhuyenMaiBUS {
    public static ArrayList<ChuongTrinhKhuyenMaiDTO> ds;

    public ChuongTrinhKhuyenMaiBUS() {
    }
    public void docDSCTKM()
    {
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
            ds = data.docDSCTKM();
    }
    
    public void them(ChuongTrinhKhuyenMaiDTO ct)
    {
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
        data.them(ct);
//        ds.add(ct);

    }
    
    public void xoa(int ma)
    {
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
        data.xoa(ma);
        
    }
    
    public void sua(ChuongTrinhKhuyenMaiDTO ct)
    {
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
        data.sua(ct);
    }
    
    public ArrayList<ChuongTrinhKhuyenMaiDTO> timKiemThuong(String tim,int index)
    {
        if(ds == null)
        {
            docDSCTKM();
        }
        
        ArrayList<ChuongTrinhKhuyenMaiDTO> kq = new ArrayList<>();
        for(ChuongTrinhKhuyenMaiDTO ct : ds)
        {

            switch (index)
            {
                case 0:
                {
                    if(String.valueOf(ct.getMaCTKM()).contains(tim))
                    {
                        kq.add(ct);
                    }
                    break;
                }
                case 1:
                {
                    if(ct.getNgayBD().contains(tim))
                    {
                        kq.add(ct);
                    }
                    break;
                }
                case 2:
                {
                    if(ct.getNgayKT().contains(tim))
                    {
                        kq.add(ct);
                    }
                    break;
                }
            }
        }
        return kq;
    }
//    public boolean ktraMa(int ma)
//    {
//        if(ds == null)
//        {
//            docDSCTKM();
//        }
//        for(ChuongTrinhKhuyenMaiDTO ct : ds)
//        {
//            if(ct.getMaCTKM() == ma)
//            {
//                return true;
//            }
//        }
//        return false;
//    }
    
    public boolean ktraMa(int ma)
    {
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
        return data.ktraMa(ma);
    }
}
