/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;
import java.util.*;
/**
 *
 * @author huyle
 */

public class DSNhanVien{
    static int cnt = 1;
    private DSAccount dsAccount;
    private DSLuong dsLuong;
    private ArrayList<NhanVien> dsNhanVien;
    
    public DSNhanVien(DSAccount dsAccount, DSLuong dsLuong){
        this.dsNhanVien = new ArrayList<>();
        this.dsAccount =  dsAccount;
        this.dsLuong = dsLuong;
    }
    
    public ArrayList<NhanVien> getDSNhanVien(){
        return this.dsNhanVien;
    }
    
    public void addDSNhanVien(NhanVien nhanVien){
        this.dsNhanVien.add(nhanVien);
        dsAccount.addAccount(new Account(nhanVien.getMaNV()));
        dsLuong.addLuong(new Luong(nhanVien));
    }
    
    public void removeDSNhanVien(NhanVien nhanVien){
        this.dsNhanVien.remove(nhanVien);
        for(Account x:dsAccount.getDSAccount()){
            if(x.getUsername().equals(nhanVien.getMaNV())){
                dsAccount.removeAccount(x);
                break;
            }
        }
        
        for(Luong x:dsLuong.getDSLuong()){
            if(x.getMaNV().equals(nhanVien.getMaNV())){
                dsLuong.removeLuong(x);
                break;
            }
        }
    }
}
