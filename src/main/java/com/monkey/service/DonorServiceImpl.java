package com.monkey.service;

import com.monkey.entity.Donor;
import com.monkey.repository.DonorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorDao donorDao;


    @Override
    public List<Donor> findDonor(Donor donor) {
        return donorDao.findDonor(donor);
    }
}
