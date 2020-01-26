package applicationMain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import applicationMain.Models.DriverDetailsModel;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetailsModel, Long> {

}
