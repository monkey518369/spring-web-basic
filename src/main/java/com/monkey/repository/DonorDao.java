package com.monkey.repository;

import com.monkey.entity.Donor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorDao {

    List<Donor> findDonor(Donor donor);
}
