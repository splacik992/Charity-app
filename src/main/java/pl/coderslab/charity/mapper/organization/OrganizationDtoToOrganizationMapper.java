package pl.coderslab.charity.mapper.organization;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.OrganizationDto;

@Component
public class OrganizationDtoToOrganizationMapper {

    public Organization organizationDtoToOrganization(OrganizationDto organizationDto) {
        String name = organizationDto.getName();
        String description = organizationDto.getDescription();
        return new Organization(name,description);
    }
}
