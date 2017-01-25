package ua.ppadalka.webstore.profile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ppadalka.webstore.profile.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {}
