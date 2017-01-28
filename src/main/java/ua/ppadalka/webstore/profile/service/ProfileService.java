package ua.ppadalka.webstore.profile.service;

import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.account.model.Account;
import ua.ppadalka.webstore.profile.dto.ProfileDTO;
import ua.ppadalka.webstore.profile.model.Profile;

@Service
public interface ProfileService {

    Profile create(ProfileDTO profileDTO, Account account);

//    Profile createAnonymous(ProfileDTO profileDTO);
}
