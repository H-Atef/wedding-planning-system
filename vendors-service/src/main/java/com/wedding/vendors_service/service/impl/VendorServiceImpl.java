package com.wedding.vendors_service.service.impl;


import com.wedding.vendors_service.dto.VendorRequest;
import com.wedding.vendors_service.dto.VendorResponse;
import com.wedding.vendors_service.dto.mapper.VendorMapper;
import com.wedding.vendors_service.model.VendorInfo;
import com.wedding.vendors_service.repository.VendorRepository;
import com.wedding.vendors_service.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    @Override
    public List<VendorResponse> getAllVendors() {
        return vendorRepository.findAll().stream()
                .map(vendorMapper::toVendorResponse).toList();
    }

    @Override
    public List<VendorResponse> getVendorsByCategory(String category) {
        List<VendorInfo> vendors = vendorRepository.findByVendorCategory(category);
        return vendors.stream().map(vendorMapper::toVendorResponse).toList();
    }

    @Override
    public VendorResponse createVendor(VendorRequest vendorRequest) {
        VendorInfo vendorInfo = vendorMapper.toVendorInfo(vendorRequest);
        VendorInfo savedVendor = vendorRepository.save(vendorInfo);
        return vendorMapper.toVendorResponse(savedVendor);
    }

    @Override
    public void updateVendor(String vendorName, VendorRequest vendorRequest) {
        VendorInfo existingVendor = vendorRepository.findByVendorName(vendorName);
        if (existingVendor!=null) {
            VendorInfo vendorInfo = vendorMapper.toVendorInfo(vendorRequest);
            vendorInfo.setId(existingVendor.getId()); // Keep the original ID for the update
            vendorRepository.save(vendorInfo);

        }

    }

    @Override
    public void deleteVendorByName(String vendorName) {
        VendorInfo vendor = vendorRepository.findByVendorName(vendorName);
        if (vendor!=null) {vendorRepository.delete(vendor);}
    }



    // for testing the required fields and fixing any problem related to Model fields or Response-object class attributes
    @Override
    public List<VendorResponse> getAllScrapedVendors() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<VendorResponse[]> responseEntity = restTemplate.exchange(
                "http://localhost:8000/vendors/all-vendor-info/",
                HttpMethod.GET, null, VendorResponse[].class);

        return Arrays.stream(Objects.requireNonNull(responseEntity.getBody()))
                .toList();
    }
}
