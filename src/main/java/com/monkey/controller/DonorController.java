package com.monkey.controller;

import com.monkey.entity.Donor;
import com.monkey.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("donor")
public class DonorController {

    private static final String PATH = "donor/";

    @Autowired
    private DonorService donorService;

    @RequestMapping("index")
    public String index(){
        String result = "index";
        Donor donor = new Donor();
        List<Donor> donors = donorService.findDonor(donor);
        donors.forEach(item->{
            System.out.println(item);
        });
        return PATH + result;
    }

}
