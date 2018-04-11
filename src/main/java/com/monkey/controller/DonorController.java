package com.monkey.controller;

import com.monkey.entity.Donor;
import com.monkey.service.DonorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("donor")
public class DonorController {

    private static final String PATH = "donor/";

    private static final Logger LOGGER = LoggerFactory.getLogger(DonorController.class);

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
        long begin  = Calendar.getInstance().getTime().getTime();
        for(int i=0;i<100;i++){
            LOGGER.info("测试placeholder： {}",this.getClass().getName());
        }
        LOGGER.error(Calendar.getInstance().getTime().getTime()-begin+"=========");

        return PATH + result;
    }

}
