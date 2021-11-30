package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Organization;
import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    //Save
    public void saveOrganization(Organization organization){
        organizationRepository.save(organization);
    }

    //List
    public List<Organization> listOrganizations(){
        return organizationRepository.findAll();
    }

    //Delete
    public void deleteOrganization(Long org_id){
        organizationRepository.deleteById(org_id);
    }

    //Editing
    public Organization editOrganization(long org_id){
        return organizationRepository.getOrganizationById(org_id);
    }

    public Organization getOrganizationById(long org_id){
        Organization organization = organizationRepository.getOrganizationById(org_id);
        return organization;
    }
}
