package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT COUNT(quantity) FROM donation;" , nativeQuery=true)
    Optional<Integer> countOfBagDonations();

    @Query(value = "SELECT SUM(quantity) FROM donation;" , nativeQuery=true)
    Optional<Integer> counterOfGifts();

}