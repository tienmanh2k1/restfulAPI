package spring.io.restfulAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.io.restfulAPI.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
