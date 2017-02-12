package ua.ppadalka.webstore.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.account.model.Account;
import ua.ppadalka.webstore.profile.dto.ProfileDto;
import ua.ppadalka.webstore.profile.model.Profile;
import ua.ppadalka.webstore.profile.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(ProfileDto profileDto, Account account) {
        Profile profile = new Profile();

        profile.setFirstName(profileDto.getFirstName());
        profile.setLastName(profileDto.getLastName());
        profile.setAddress(profileDto.getAddress());
        profile.setPhoneNumber(profileDto.getPhoneNumber());
        profile.setAccount(account);

        return profileRepository.save(profile);
    }
}
