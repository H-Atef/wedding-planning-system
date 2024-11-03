package com.wedding.vendors_service.dto.mapper;

import com.wedding.vendors_service.dto.VendorRequest;
import com.wedding.vendors_service.dto.VendorResponse;
import com.wedding.vendors_service.model.VendorInfo;
import org.springframework.stereotype.Component;

@Component
public class VendorMapper {

    // Method to convert VendorRequest to VendorInfo
    public VendorInfo toVendorInfo(VendorRequest vendorRequest) {
        if (vendorRequest == null) {
            return null;
        }

        return VendorInfo.builder()
                .vendorName(vendorRequest.getVendorName())
                .vendorLink(vendorRequest.getVendorLink())
                .vendorDescription(vendorRequest.getVendorDescription())
                .vendorCategory(vendorRequest.getVendorCategory())
                .vendorLocations(vendorRequest.getVendorLocations())
                .vendorPrice(vendorRequest.getVendorPrice())
                .vendorPhoneNumbers(vendorRequest.getVendorPhoneNumbers())
                .vendorFollowersNum(vendorRequest.getVendorFollowersNum())
                .vendorFollowingNum(vendorRequest.getVendorFollowingNum())
                .build();
    }

    // Method to convert VendorInfo to VendorResponse
    public VendorResponse toVendorResponse(VendorInfo vendorInfo) {
        if (vendorInfo == null) {
            return null;
        }

        return VendorResponse.builder()
                .vendorName(vendorInfo.getVendorName())
                .vendorLink(vendorInfo.getVendorLink())
                .vendorDescription(vendorInfo.getVendorDescription())
                .vendorCategory(vendorInfo.getVendorCategory())
                .vendorLocations(vendorInfo.getVendorLocations())
                .vendorPrice(vendorInfo.getVendorPrice())
                .vendorPhoneNumbers(vendorInfo.getVendorPhoneNumbers())
                .vendorFollowersNum(vendorInfo.getVendorFollowersNum())
                .vendorFollowingNum(vendorInfo.getVendorFollowingNum())
                .build();
    }
}
