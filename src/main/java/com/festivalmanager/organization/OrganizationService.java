package com.festivalmanager.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRestRepository organizationRestRepository;

    public Organization save(Organization organization) {
        if(organization.getOrganizationName() == null || organization.getOrganizationName().isEmpty()) {
            throw new IllegalArgumentException("Organization name cannot be null or empty");
        }
        return organizationRestRepository.save(organization);
    }
}
