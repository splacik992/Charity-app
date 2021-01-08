package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.OrganizationDto;
import pl.coderslab.charity.mapper.organization.OrganizationDtoToOrganizationMapper;
import pl.coderslab.charity.mapper.organization.OrganizationToOrganizationDtoMapper;
import pl.coderslab.charity.repository.OrganizationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationToOrganizationDtoMapper organizationToOrganizationDtoMapper;
    private final OrganizationDtoToOrganizationMapper organizationDtoToOrganizationMapper;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository,
                               OrganizationToOrganizationDtoMapper organizationToOrganizationDtoMapper,
                               OrganizationDtoToOrganizationMapper organizationDtoToOrganizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationToOrganizationDtoMapper = organizationToOrganizationDtoMapper;
        this.organizationDtoToOrganizationMapper = organizationDtoToOrganizationMapper;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        organizationRepository.save(new Organization("Fundacja 'Dbam O Zdrowie'", "Cel i misja: Pomoc dzieciom z ubogich rodzin"));
        organizationRepository.save(new Organization("Fundacja 'A kogo'", "Cel i misja: Pomoc wybudzaniu dzici ze śpiączki"));
        organizationRepository.save(new Organization("Fundacja 'Dla dzieci'", "Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej"));
        organizationRepository.save(new Organization("Fundacja 'Bez domu'", "Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania"));
    }

    @Transactional
    public List<OrganizationDto> getAllOrganizations() {
        List<Organization> organization = organizationRepository.findAll();
        return organizationToOrganizationDtoMapper.organizationListToDto(organization);
    }

    @Transactional
    public Organization getOrganizationByName(String name){
        return organizationRepository.getOrganizationByName(name);
    }

    @Transactional
    public void saveOrganization(OrganizationDto organizationDto){
        Organization organization = organizationDtoToOrganizationMapper.organizationDtoToOrganization(organizationDto);
        organizationRepository.save(organization);
    }

}
