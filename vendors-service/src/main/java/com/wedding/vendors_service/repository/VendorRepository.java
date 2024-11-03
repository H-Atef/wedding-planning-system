package com.wedding.vendors_service.repository;

import com.wedding.vendors_service.model.VendorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VendorRepository extends MongoRepository<VendorInfo,String> {
    List<VendorInfo> findByVendorCategory(String category);
    VendorInfo findByVendorName(String vendorName);
}
