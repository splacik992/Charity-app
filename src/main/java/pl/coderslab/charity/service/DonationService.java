package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.dto.DonationDto;
import pl.coderslab.charity.mapper.donation.DonationDtoToDonationMapper;
import pl.coderslab.charity.repository.DonationRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final DonationDtoToDonationMapper donationDtoToDonationMapper;

    public DonationService(DonationRepository donationRepository,
                           DonationDtoToDonationMapper donationDtoToDonationMapper) {
        this.donationRepository = donationRepository;
        this.donationDtoToDonationMapper = donationDtoToDonationMapper;
    }

    @Transactional
    public Optional<Integer> getCountOfBags() {
        if (!donationRepository.countOfBagDonations().isPresent()) {
            return Optional.of(0);
        }
        return donationRepository.countOfBagDonations();
    }

    @Transactional
    public Optional<Integer> getSumOfGifts() {
        if (!donationRepository.counterOfGifts().isPresent()) {
            return Optional.of(0);
        }
        return donationRepository.counterOfGifts();
    }

    @Transactional
    public void saveDonation(DonationDto donation) {
        Donation donation1 = donationDtoToDonationMapper.donationDtoToDonation(donation);
        donationRepository.save(donation1);
    }
}
