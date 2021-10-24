package com.tracom.officeplanner.Services;

import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceService {

        @Autowired
        private ResourceRepository resourceRepository;

        //Save Resource
        public void saveResource(Resource resource){
                resourceRepository.save(resource);
        }
        //List Resources
        public List<Resource> listResources(){
                return resourceRepository.findAll();
        }
        //Deleting a resource
        public void deleteResource(Long rsc_id){
                resourceRepository.deleteById(rsc_id);
        }
        //Editing
        public Resource editResource(long rsc_id)
        {
                return resourceRepository.getResourceById(rsc_id);
        }
}
