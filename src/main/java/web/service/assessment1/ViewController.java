/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service.assessment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */

@Controller
public class ViewController {
    @RequestMapping("/search")
    public String getTabel(Model model, HttpServletRequest cari){

        String nama_barang_dicari = cari.getParameter("barang");
        String nama_ketemu = "";
        List<String> buffer = new ArrayList<>();

        
        ArrayList<List<String>> tabel_harga = new ArrayList<>();
        ArrayList<List<String>> tabel_baru = new ArrayList<>();
        
        tabel_harga.add(Arrays.asList("telur", "1000"));
        tabel_harga.add(Arrays.asList("mie", "2500"));
        tabel_harga.add(Arrays.asList("piring", "3000"));
        tabel_harga.add(Arrays.asList("pensil", "5000"));
        tabel_harga.add(Arrays.asList("pengaris", "5000"));
        
        for(int brs =0;brs<tabel_harga.size();brs++) {
            buffer = tabel_harga.get(brs);
            if(buffer.toString().contains(nama_barang_dicari)){  
                tabel_baru.add(tabel_harga.get(brs));
            } else {nama_ketemu="Tidak Ditemukan";}
        }
        
        model.addAttribute("tabel_baru",  tabel_baru);
        model.addAttribute("barangdicari", nama_ketemu);
        return "viewtabel";
    
    }
    
}
