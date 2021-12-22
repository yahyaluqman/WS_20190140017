/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service.assessment1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */

@Controller
public class DatabaseController {
    @RequestMapping("/datamahasiswa")
    @ResponseBody
    public List<Datamahasiswa> getDatamahasiswa(){
        
        List<Datamahasiswa> datamahasiswa = new ArrayList<>();
        
        DatamahasiswaJpaController controller = new DatamahasiswaJpaController();
        
        try {
            datamahasiswa = controller.findDatamahasiswaEntities();
        }
        catch (Exception ex){}
        
        return datamahasiswa;
    }
}