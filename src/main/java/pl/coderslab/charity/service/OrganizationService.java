package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.mapper.organization.OrganizationDtoToOrganizationMapper;
import pl.coderslab.charity.mapper.organization.OrganizationToOrganizationDtoMapper;
import pl.coderslab.charity.repository.OrganizationRepository;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationToOrganizationDtoMapper organizationToOrganizationDtoMapper;
    private final OrganizationDtoToOrganizationMapper organizationDtoToOrganizationMapper;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, OrganizationToOrganizationDtoMapper organizationToOrganizationDtoMapper,
                               OrganizationDtoToOrganizationMapper organizationDtoToOrganizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationToOrganizationDtoMapper = organizationToOrganizationDtoMapper;
        this.organizationDtoToOrganizationMapper = organizationDtoToOrganizationMapper;
    }
}
