package com.swivel.mapper;

import com.swivel.dto.OrganizationDTO;
import com.swivel.model.Organization;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-18T22:09:21-0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class OrganizationToOrganizationDTOMapperImpl implements OrganizationToOrganizationDTOMapper {

    @Override
    public OrganizationDTO organizationToOrganizationDTO(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDTO organizationDTO = new OrganizationDTO();

        organizationDTO.set_id( organization.get_id() );
        organizationDTO.setUrl( organization.getUrl() );
        organizationDTO.setExternal_id( organization.getExternal_id() );
        organizationDTO.setName( organization.getName() );
        List<String> list = organization.getDomain_names();
        if ( list != null ) {
            organizationDTO.setDomain_names( new ArrayList<String>( list ) );
        }
        organizationDTO.setCreated_at( organization.getCreated_at() );
        organizationDTO.setDetails( organization.getDetails() );
        organizationDTO.setShared_tickets( organization.getShared_tickets() );
        List<String> list1 = organization.getTags();
        if ( list1 != null ) {
            organizationDTO.setTags( new ArrayList<String>( list1 ) );
        }

        return organizationDTO;
    }
}
