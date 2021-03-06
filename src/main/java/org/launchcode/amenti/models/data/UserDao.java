package org.launchcode.amenti.models.data;


import org.launchcode.amenti.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository <User, Integer> {

    User findByUsernameAndPassword(String username, String password);

}
