/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipd.com.mange;


import ipd.com.models.Beds;
import ipd.com.respository.BedsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    
    @Autowired
    BedsRepository beds;
    
    @GetMapping("/getbeds")
    public List<Beds> hello(){
        return this.beds.findAll();
    }
}
