// Nguyễn Quang Trung - B22DCDT321

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class NhanVien {

    public static Scanner scanner1 = new Scanner(System.in);
    public static int COUNT = 1;

    private String MaNV;
    private String TenNV;
    private String GioiTinh;
    private String Email;
    private String SDT;
    private String NgaySinh;
    private String NgayBatDau;

    NhanVien() {
        this.MaNV = null;
        this.TenNV = null;
        this.GioiTinh = null;
        this.Email = null;
        this.SDT = null;
        this.NgaySinh = null;
        this.NgayBatDau = null;
    }

    NhanVien(
            String TenNV,
            String GioiTinh,
            String Email,
            String SDT,
            String NgaySinh,
            String NgayBatDau
    ) {

        // Mã nhân viên tự động tăng.

        this.MaNV = "NV" + String.format("%02d",COUNT++);

        // Kiểm tra tên đã đúng format chưa? Nếu đúng gán giá trị cho thuộc tính, nếu chưa yêu cầu nhập lại.

        if ( checkName(TenNV) )
            this.TenNV = formatName(TenNV);

        else {

            System.out.println("Invalid name format! Please enter again: ");
            String tmpSetName;

            do {

                tmpSetName = scanner1.nextLine(); // Lấy input trực tiếp

                if (!checkName(tmpSetName))
                    System.out.println("Invalid name format! Please enter again: ");

                else
                    this.TenNV = formatName(tmpSetName); // Nếu hợp lệ, gán giá trị

            } while (!checkName(tmpSetName)); // Kiểm tra điều kiện không hợp lệ

        }

        // Kiểm tra giới tính đã đúng format chưa? Nếu đúng gán giá trị cho thuộc tính, nếu chưa yêu cầu nhập lại.

        if ( checkName(GioiTinh) )
            this.GioiTinh = formatName(GioiTinh);

        else {

            System.out.println("Invalid gender format! Please enter again: ");
            String tmpSetGender;

            do {

                tmpSetGender = scanner1.nextLine(); // Lấy input trực tiếp

                if (!checkName(tmpSetGender))
                    System.out.println("Invalid name format! Please enter again: ");

                else
                    this.TenNV = formatName(tmpSetGender); // Nếu hợp lệ, gán giá trị

            } while (!checkName(tmpSetGender)); // Kiểm tra điều kiện không hợp lệ

        }

        // Kiểm tra email đã đúng format chưa ("example@test.com")? Nếu đúng gán giá trị cho thuộc tính, nếu chưa yêu cầu nhập lại.

        if (checkEmail(Email))
            this.Email = Email;

        else {

            System.out.println("Invalid email format! Please enter again: ");
            String tmpSetEmail;

            do {

                tmpSetEmail = scanner1.nextLine(); // Lấy input trực tiếp

                if (!checkEmail(tmpSetEmail))
                    System.out.println("Invalid email format! Please enter again: ");

                else
                    this.Email = tmpSetEmail; // Nếu hợp lệ, gán giá trị

            } while (!checkEmail(tmpSetEmail)); // Kiểm tra điều kiện không hợp lệ

        }

        // Kiểm tra sđt đã đúng format chưa? Nếu đúng gán giá trị cho thuộc tính, nếu chưa yêu cầu nhập lại.

        if (checkSDT(SDT))
            this.SDT = SDT;

        else {

            System.out.println("Invalid number format! Please enter again: ");
            String tmpSetSDT;

            do {

                tmpSetSDT = scanner1.nextLine(); // Lấy input trực tiếp

                if (!checkSDT(tmpSetSDT))
                    System.out.println("Invalid number format! Please enter again: ");

                else
                    this.SDT = tmpSetSDT; // Nếu hợp lệ, gán giá trị

            } while (!checkSDT(tmpSetSDT)); // Kiểm tra điều kiện không hợp lệ

        }

        // Kiểm tra ngày sinh đã đúng format chưa? Nếu đúng gán giá trị cho thuộc tính, nếu chưa yêu cầu nhập lại.

        if (checkDob(NgaySinh))
            this.NgaySinh = NgaySinh;

        else {

            System.out.println("Invalid date of birth format (dd/mm/yyyy)! Please enter again: ");
            String tmpSetNgaySinh;

            do {

                tmpSetNgaySinh = scanner1.nextLine(); // Lấy input trực tiếp

                if (!checkDob(tmpSetNgaySinh))
                    System.out.println("Invalid date of birth format (dd/mm/yyyy)! Please enter again: ");

                else
                    this.NgaySinh = tmpSetNgaySinh; // Nếu hợp lệ, gán giá trị

            } while (!checkDob(tmpSetNgaySinh)); // Kiểm tra điều kiện không hợp lệ

        }

        // Kiểm tra ngày bắt đầu đã đúng format chưa? Nếu đúng gán giá trị cho thuộc tính, nếu chưa yêu cầu nhập lại.

        if (checkD(NgayBatDau))
            this.NgayBatDau = NgayBatDau;

        else {

            System.out.println("Invalid date format (dd/mm/yyyy)! Please enter again: ");
            String tmpSetNgayBatDau;

            do {

                tmpSetNgayBatDau = scanner1.nextLine(); // Lấy input trực tiếp

                if (!checkD(tmpSetNgayBatDau))
                    System.out.println("Invalid date format (dd/mm/yyyy)! Please enter again: ");

                else
                    this.NgayBatDau = tmpSetNgayBatDau; // Nếu hợp lệ, gán giá trị

            } while (!checkD(tmpSetNgayBatDau)); // Kiểm tra điều kiện không hợp lệ

        }

    }

    // setter và getter cho các thuộc tính

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setMaNV(String maNV) {
        this.MaNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.TenNV = tenNV;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public void setNgayBatDau(String ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    // Kiểm tra format họ và tên.

    public boolean checkName ( String tmpName ) {

        String invalidCharacters = "@#$%^&*()+=[]{};:'\",.<>?/|~`0123456789";

        for ( int i = 0; i < tmpName.length(); i++ )

            for ( int j = 0; j < invalidCharacters.length(); j++ )

                if ( tmpName.charAt(i) == invalidCharacters.charAt(j) )
                    return false;

        return true;

    }

    // Chuẩn hóa họ và tên.

    public String formatName( String tmpName ) {

        StringBuilder formattedName = new StringBuilder();

        String[] tmpList = tmpName.trim().split("\\s+");

        for ( int i = 0; i < tmpList.length; i++ ) {
            tmpList[i] = tmpList[i].substring(0, 1).toUpperCase() + tmpList[i].substring(1).toLowerCase();
            formattedName.append(tmpList[i]).append(" ");
        }

        return formattedName.toString().trim();

    }

    // Kiểm tra đầu vào Số điện thoại. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.

    public boolean checkSDT ( String tmpSDT ) {

        if ( tmpSDT.length() != 10 )
            return false;

        String NUMBER_REGEX = "^\\d{10}$";

        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(tmpSDT);

        return matcher.matches();

    }

    // Kiểm tra đầu vào email. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.

    public boolean checkEmail ( String tmpEmail ) {

        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(tmpEmail);

        return matcher.matches();

    }

    // Kiểm tra đầu vào ngày tháng năm sinh, format dd/mm/yyyy. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.

    public boolean checkDob( String tmpDob ) {

        String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$";

        if ( !Pattern.matches(DATE_REGEX, tmpDob) )
            return false;

        int tmpNamSinh = Integer.parseInt( tmpDob.substring(tmpDob.length() - 4) );
        int tmpThangSinh = Integer.parseInt( tmpDob.substring(3, 5) );
        int tmpNgaySinh = Integer.parseInt( tmpDob.substring(0, 2) );

        return tmpNamSinh > 1960 && tmpNamSinh <= 2006 && tmpThangSinh < 13 && tmpThangSinh > 0 && tmpNgaySinh < 32 && tmpNgaySinh > 0;

    }

    // Kiểm tra đầu vào ngày tháng năm, format dd/mm/yyyy. Sử dụng biểu thức chính quy (Regex) để kiểm tra format.

    public boolean checkD( String tmpD ) {

        String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$";

        if ( !Pattern.matches(DATE_REGEX, tmpD) )
            return false;

        int tmpNamSinh = Integer.parseInt( tmpD.substring(tmpD.length() - 4) );
        int tmpThangSinh = Integer.parseInt( tmpD.substring(3, 5) );
        int tmpNgaySinh = Integer.parseInt( tmpD.substring(0, 2) );

        return tmpThangSinh < 13 && tmpThangSinh > 0 && tmpNgaySinh < 32 && tmpNgaySinh > 0;

    }

    // Ghi đè lại phương thức toString để kiểm tra code có hoạt động đúng không.

    @Override
    public String toString() {
        return MaNV + " " + TenNV + " " + GioiTinh + " " + Email + " " + SDT + " " + NgaySinh + " " + NgayBatDau;
    }

}
