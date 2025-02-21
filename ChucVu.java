public class ChucVu {
    public String MaCV;
    public String TenCV;
    // Constructor không tham số, khởi tạo các biến về 0.
    public ChucVu() {
        MaCV = TenCV = "";
    }
    // Constructor với tham số là tên chức vụ.
    public ChucVu(String TenCV){
        this.MaCV = chuan_hoa(TenCV);
        this.TenCV = TenCV;
    }
    // Phương pháp chuẩn hóa để khởi tạo MaCV
    public String chuan_hoa (String z){
        String[] s = z.split("\\s+"); //Tách từng từ
        String a = "";
        for (int i = 0; i < s.length; i++){
            a += s[i].substring(0,1).toUpperCase(); // Lấy chữ cái đầu rồi viết hoa
        }
        return a;
    }
    // Phương thức thiết lập mã chức vụ
    public void setMa_ChucVu(String ma_ChucVu) {
        this.MaCV = ma_ChucVu;
    }
    // Phương thức trả về mã chức vụ
    public String getMa_ChucVu() {
        return MaCV;
    }

    // Phương thức thiết lập tên chức vụ
    public void setTen_ChucVu(String ten_ChucVu) {
        this.TenCV = ten_ChucVu;
    }
    // Phương thức trả về tên chức vụ
    public String getTen_ChucVu() {
        return TenCV;
    }
    @Override
    public String toString() {
        return MaCV + " " + TenCV;
    }
}