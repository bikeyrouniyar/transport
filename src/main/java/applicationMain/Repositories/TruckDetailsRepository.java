package applicationMain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import applicationMain.Models.TruckDetailsModel;

@Repository
public interface TruckDetailsRepository extends JpaRepository<TruckDetailsModel, Long> {

}
