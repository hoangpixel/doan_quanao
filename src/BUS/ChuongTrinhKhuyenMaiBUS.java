
package BUS;
import DTO.ChuongTrinhKhuyenMaiDTO;
import DAO.ChuongTrinhKhuyenMaiDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class ChuongTrinhKhuyenMaiBUS {
    public static ArrayList<ChuongTrinhKhuyenMaiDTO> ds;

    public ChuongTrinhKhuyenMaiBUS() {
    }
    public void docDSCTKM()
    {
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
        if(ds == null)
        {
            ds = new ArrayList<ChuongTrinhKhuyenMaiDTO>();
            ds = data.docDSCTKM();
        }
    }
    
    public void them(ChuongTrinhKhuyenMaiDTO ct)
    {
        
        ChuongTrinhKhuyenMaiDAO data = new ChuongTrinhKhuyenMaiDAO();
        data.them(ct);
        ds.add(ct);

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
}
