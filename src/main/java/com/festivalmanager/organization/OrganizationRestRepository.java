package com.festivalmanager.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRestRepository extends JpaRepository<Organization, Long> {


}
