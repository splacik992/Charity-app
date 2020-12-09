package pl.coderslab.charity.mapper.organization;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.OrganizationDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationToOrganizationDtoMapper {
    public static OrganizationDto organizationToOrganizationDto(Organization organization){

        Long id = organization.getId();
        String name = organization.getName();
        String description = organization.getDescription();
        return new OrganizationDto(id,name,description);
    }

    public List<OrganizationDto> organizationListToDto(List<Organization> organizations){
        List<OrganizationDto> organizationDtoList = new ArrayList<>();
        for (Organization organization : organizations) {
            OrganizationDto organizationDto = organizationToOrganizationDto(organization);
            organizationDtoList.add(organizationDto);
        }
        return organizationDtoList;
    }
}
