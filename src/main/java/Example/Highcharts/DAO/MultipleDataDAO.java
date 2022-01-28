package Example.Highcharts.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Example.Highcharts.models.MultipleData;

@Repository
public interface MultipleDataDAO extends JpaRepository<MultipleData, Integer> {

}