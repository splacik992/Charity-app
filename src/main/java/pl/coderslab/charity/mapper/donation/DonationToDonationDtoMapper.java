package pl.coderslab.charity.mapper.donation;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.DonationDto;
import pl.coderslab.charity.entity.dto.OrganizationDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DonationToDonationDtoMapper {

    public DonationDto donationToDonationDto(Donation donation) {
        Integer quantity = donation.getQuantity();
        String street = donation.getStreet();
        String city = donation.getCity();
        String zipcode = donation.getZipCode();
        LocalDate pickUpDate = donation.getPickUpDate();
        LocalTime pickUpTime = donation.getPickUpTime();
        String pickUpComment = donation.getPickUpComment();
        List<Category> categories = donation.getCategories();
        Organization organization = donation.getOrganization();
        return new DonationDto(quantity, street, city, zipcode, pickUpDate, pickUpTime, pickUpComment,
                categories, organization);
    }

    public List<DonationDto> donationListToDonationDto(List<Donation> donations){
        List<DonationDto> donationList = new ArrayList<>();

        for (Donation donation : donations) {
            DonationDto donationDto = donationToDonationDto(donation);
            donationList.add(donationDto);
        }
        return donationList;
    }
}