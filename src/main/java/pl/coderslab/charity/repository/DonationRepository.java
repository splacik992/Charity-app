package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.dto.DonationDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT COUNT(quantity) FROM donation where user_id = :id" , nativeQuery=true)
    Optional<Integer> countOfUserBagDonations(@Param("id") Long id);

    @Query(value = "SELECT SUM(quantity) FROM donation where user_id = :id" , nativeQuery=true)
    Optional<Integer> sumOfUserGifts(@Param("id") Long id);

    @Query(value = "SELECT COUNT(quantity) FROM donation;" , nativeQuery=true)
    Optional<Integer> countOfBagDonations();

    @Query(value = "SELECT SUM(quantity) FROM donation;" , nativeQuery=true)
    Optional<Integer> counterOfGifts();

    @Query(value = "SELECT * FROM donation GROUP BY pick_up_date where user_id = :id",nativeQuery = true)
    List<Donation> findAllDonationsByPickUpDate();
}