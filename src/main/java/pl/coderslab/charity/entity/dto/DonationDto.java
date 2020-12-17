package pl.coderslab.charity.entity.dto;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Organization;
import pl.coderslab.charity.entity.user_security.CurrentUser;
import pl.coderslab.charity.entity.user_security.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DonationDto {

    private Long id;
    private Integer quantity;
    private String street;
    private String city;
    private String zipCode;
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

    private List<Category> categories;

    private Organization organization;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public DonationDto(Integer quantity, String street, String city, String zipCode, LocalDate pickUpDate,
                       LocalTime pickUpTime, String pickUpComment, List<Category> categories, Organization organization) {
        this.quantity = quantity;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
        this.categories = categories;
        this.organization = organization;
    }
}
