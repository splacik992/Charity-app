package pl.coderslab.charity.mapper.organization;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.OrganizationDto;

@Component
public class OrganizationToOrganizationDtoMapper {

    public OrganizationDto organizationToOrganizationDto(Organization organization){
        String name = organization.getName();
        String description = organization.getDescription();
        return new OrganizationDto(name,description);
    }
}
