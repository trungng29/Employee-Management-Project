import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DuAn {    
    static Scanner in = new Scanner(System.in); //biến scanner để nhập giữ liệu từ bàn phím
    static int cnt = 1; //Biến đếm tĩnh, dùng để tạo mã dự án (MaDA) tự động tăng dần.
    private String MaDA, TenDA, NgayThucHien;  //các thuộc tính: mã dự án, tên dự án, ngày thực hiện
    
    //Constructor không tham số: khởi tạo các thuộc tính bán đầu là rỗng
    public DuAn(){
        this.MaDA = this.TenDA = this.NgayThucHien = "";
    }
    
    //Constructor có tham số, khởi tạo mã dự án tăng dần theo mẫu, tên dự án và ngày thực hiện theo dữ liệu vào
    public DuAn(String tenDa, String ngayThucHien){
        this.MaDA = String.format("DA%02d", cnt++);  //mã dự án tự động tăng dần
        this.setTenDA(tenDa);     //tên dự án được chuẩn hóa
        this.setNgayThucHien(ngayThucHien);  //dữ liệu ngày tháng được kiểm tra, đảm bảo chuẩn dd/mm/yyyy
    }
    
    //phương thức trả về mã dự án
    public String getMaDA(){ 
        return this.MaDA;
    }
    
    //phương thức thiết lập tên dự án
    public void setTenDA(String newName){ 
        this.TenDA = formatName(newName);
    }
    
    //phương thức trả về tên dự án
    public String getTenDA(){
        return this.TenDA;
    }
    
    //phương thức thiết lập ngày thực hiện
    public void setNgayThucHien(String newDate){
        while(!checkDate(newDate)){  //những dữ liệu nhập vào không đạt chuẩn dd/mm/yyyy phải nhập lại
            System.out.println("Invalid date format! Please enter again:");
            newDate = in.next();
        }
        this.NgayThucHien = newDate; //thiết lập với những dữ liệu đã đạt chuẩn
    }
    
    //phương thức trả về ngày thực hiện
    public String getNgayThucHien(){ 
        return this.NgayThucHien;
    }
    
    //phương thức chuẩn hóa tên dự án
    public String formatName(String n){
        StringBuilder formatedName = new StringBuilder();
        for(String x:n.trim().toLowerCase().split("\\s+")){ //chuẩn hóa để các từ cách nhau 1 ô trống
            formatedName.append(x+" ");
        }
        //các kí tự trong tên viết thường ngoại trừ kí tự đầu tiên in hoa
        formatedName.replace(0, 1, Character.toString(formatedName.charAt(0)).toUpperCase());
        return formatedName.toString().trim();
    }
    
    //phương thức kiểm tra chuẩn ngày tháng của 1 xâu nhập vào
    public boolean checkDate(String n){  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //thư viện để phân tích các xâu có dạng dd/MM/yyyy tương ứng với ngày/tháng/năm
        sdf.setLenient(false); //hàm để không cho phép gán vào sdf các xâu không đạt chuẩn ngày tháng
        try {
            Date ngay = sdf.parse(n); //nếu phân tích xâu nhập vào mà có lỗi -> không đạt chuẩn
            String[] arr = n.split("/");
            //các phần ngày, tháng phải đủ 2 chữ số, phần năm phải đủ 4 chữ số và phần năm phải lớn hơn 1979, nhỏ hơn 2051
            if(arr[0].length()==2 && arr[1].length()==2 && arr[2].length()==4 && Integer.parseInt(arr[2])>=1980 && Integer.parseInt(arr[2]) <= 2050){
                return true;
            }else return false;
        } catch (ParseException e) { //các xâu có lỗi khi phân tích sẽ không đạt chuẩn
            return false;
        }
    }
    
    //phương thức trả về thông tin của dự án theo dạng chuỗi
    @Override
    public String toString(){
        return this.MaDA+" "+this.TenDA+" "+this.NgayThucHien;
    }
}
