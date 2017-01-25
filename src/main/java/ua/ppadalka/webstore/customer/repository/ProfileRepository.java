package ua.ppadalka.webstore.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ppadalka.webstore.customer.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {}
