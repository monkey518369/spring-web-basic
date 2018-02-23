package com.monkey.service;

import com.monkey.entity.Donor;

import java.util.List;

public interface DonorService {

    List<Donor> findDonor(Donor donor);
}
