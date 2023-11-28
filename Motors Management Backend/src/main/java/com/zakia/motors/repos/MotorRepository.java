package com.zakia.motors.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zakia.motors.entities.Motor;
import com.zakia.motors.entities.Type;
@RepositoryRestResource (path="rest")
public interface MotorRepository extends JpaRepository<Motor, Long> {
	List<Motor> findByNomMotors(String nom);
	List<Motor> findByNomMotorsContains(String nom);
	
	@Query("select m from Motor m where m.nomMotors like %:nom and m.prixMotors > :prix")
	List<Motor> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select m from Motor m where m.type = ?1")
	List<Motor> findByType (Type type);
	List<Motor> findByTypeIdTyp(Long id);
	
	List<Motor> findByOrderByNomMotorsAsc();
	
	@Query("select m from Motor m order by m.nomMotors ASC, m.prixMotors DESC")
	List<Motor> trierMotorsNomsPrix();
	




}
