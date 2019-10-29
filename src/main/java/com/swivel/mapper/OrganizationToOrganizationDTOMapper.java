package com.swivel.mapper;

import com.swivel.dto.OrganizationDTO;
import com.swivel.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationToOrganizationDTOMapper {

    OrganizationToOrganizationDTOMapper INSTANCE = Mappers.getMapper(OrganizationToOrganizationDTOMapper.class);
    OrganizationDTO organizationToOrganizationDTO(Organization organization);
}
