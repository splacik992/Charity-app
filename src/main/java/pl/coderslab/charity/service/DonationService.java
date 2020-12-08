package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.mapper.donation.DonationDtoToDonationMapper;
import pl.coderslab.charity.mapper.donation.DonationToDonationDtoMapper;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.Optional;
@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final DonationDtoToDonationMapper donationDtoToDonationMapper;
    private final DonationToDonationDtoMapper donationToDonationDtoMapper;

    public DonationService(DonationRepository donationRepository, DonationDtoToDonationMapper donationDtoToDonationMapper,
                           DonationToDonationDtoMapper donationToDonationDtoMapper) {
        this.donationRepository = donationRepository;
        this.donationDtoToDonationMapper = donationDtoToDonationMapper;
        this.donationToDonationDtoMapper = donationToDonationDtoMapper;
    }

    public Optional<Integer> getCountOfBags(){
        if(!donationRepository.countOfBagDonations().isPresent()){
            return Optional.of(0);
        }
        return donationRepository.countOfBagDonations();
    }

    public Optional<Integer> getSumOfGifts(){
        if(!donationRepository.counterOfGifts().isPresent()){
            return Optional.of(0);
        }
        return donationRepository.counterOfGifts();
    }
}
