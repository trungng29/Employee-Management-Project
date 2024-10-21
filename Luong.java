import java.util.Scanner;

public class Luong {
    private static int cnt = 1; // Biến đếm tĩnh, dùng để tạo mã hóa đơn (MaHD) tự động tăng dần.
    private ChucVu chucvu; // Biến để lưu chức vụ của nhân viên (thuộc class ChucVu).
    private String MaHD; // Mã hóa đơn của nhân viên, tự động tạo dựa trên cnt.
    private int LuongCB, NgayCong, PhuCap, TienThuong; // Các biến lưu lương cơ bản, số ngày công, phụ cấp, tiền thưởng.
    // Constructor không tham số, khởi tạo mã hóa đơn và thiết lập các biến về 0.
    public Luong() {
        MaHD = String.format("L%02d", cnt++); // Tạo mã hóa đơn tự động tăng dần, ví dụ L01, L02...
        LuongCB = NgayCong = PhuCap = TienThuong = 0; // Khởi tạo lương cơ bản, số ngày công, phụ cấp và tiền thưởng về 0.
    }
    // Phương thức thiết lập mã hóa đơn
    public String getMaHD() {
        return MaHD;
    }
    // Phương thức gán chức vụ cho nhân viên.
    public void setChucvu(ChucVu chucvu) {
        this.chucvu = chucvu;
    }
    // Phương thức thiết lập lương cơ bản dựa trên chức vụ.
    public void setLuongCB() {
        // Dựa vào mã chức vụ để thiết lập lương cơ bản.
        switch (chucvu.getMa_ChucVu()) {
            case "TP": // Nếu là trưởng phòng
                this.LuongCB = 1363636;
                break;
            case "PP": // Nếu là phó phòng
                this.LuongCB = 1136364;
                break;
            default: // Nếu là nhân viên
                this.LuongCB = 545454;
                break;
        }
    }
    // Phương thức trả về lương cơ bản.
    public int getLuongCB() {
        return LuongCB;
    }
    // Phương thức thiết lập số ngày công.
    public void setNgayCong() {
        Scanner sc = new Scanner(System.in);
        do {
            int NgayCong = sc.nextInt();
            if (NgayCong >= 1 && NgayCong <= 26) {
                this.NgayCong = NgayCong;
                break;
            } else {
                System.out.println("Please enter again:");
            }
        } while (true);
    }
    // Phương thức trả về số ngày công.
    public int getNgayCong() {
        return NgayCong;
    }
    // Phương thức thiết lập phụ cấp dựa trên chức vụ.
    public void setPhuCap() {
        // Dựa vào mã chức vụ để thiết lập phụ cấp.
        switch (chucvu.getMa_ChucVu()) {
            case "TP": // Nếu là trưởng phòng
                this.PhuCap = 300000;
                break;
            case "PP": // Nếu là phó phòng
                this.PhuCap = 250000;
                break;
            default: // Nếu là nhân viên
                this.PhuCap = 150000;
                break;
        }
    }
    // Phương thức trả về phụ cấp.
    public int getPhuCap() {
        return PhuCap;
    }
    // Phương thức thiết lập tiền thưởng dựa trên số ngày công.
    public void setTienThuong() {
        // Nếu ngày công >= 25 thì thưởng 20% của tổng lương.
        if (NgayCong >= 25) {
            this.TienThuong = (int) (LuongCB * NgayCong * 0.2);
        } 
        // Nếu ngày công >= 22 nhưng < 25 thì thưởng 10%.
        else if (NgayCong >= 22) {
            this.TienThuong = (int) (LuongCB * NgayCong * 0.1);
        } 
        // Nếu ít hơn 22 ngày công thì không thưởng.
        else {
            this.TienThuong = 0;
        }
    }
    // Phương thức trả về tiền thưởng.
    public int getTienThuong() {
        return TienThuong;
    }
    // Phương thức tính tổng lương = LươngCB * NgayCong + PhuCap + TienThuong.
    public long TinhTongLuong() {
        return LuongCB * NgayCong + PhuCap + TienThuong;
    }
    // Phương thức trả về thông tin của nhân viên theo dạng chuỗi.
    @Override
    public String toString() {
        return MaHD + " " + LuongCB + " " + NgayCong + " " + PhuCap + " " + TienThuong + " " + TinhTongLuong();
    }
}