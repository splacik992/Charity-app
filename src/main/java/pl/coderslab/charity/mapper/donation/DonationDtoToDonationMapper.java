package pl.coderslab.charity.mapper.donation;

import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.dto.DonationDto;
import pl.coderslab.charity.entity.user_security.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class DonationDtoToDonationMapper {

    public Donation donationDtoToDonation(DonationDto donationDto) {

        Integer quantity = donationDto.getQuantity();
        String street = donationDto.getStreet();
        String city = donationDto.getCity();
        LocalDate pickUpDate = donationDto.getPickUpDate();
        LocalTime pickUpTime = donationDto.getPickUpTime();
        String pickUpComment = donationDto.getPickUpComment();
        List<Category> categoryList = donationDto.getCategories();
        Organization organization = donationDto.getOrganization();
        String zipCode = donationDto.getZipCode();
        User user = donationDto.getUser();

        return new Donation(quantity, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment, categoryList, organization,user);

    }
}
