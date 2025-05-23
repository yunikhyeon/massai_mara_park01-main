package zzyzzy.spring.massai_mara_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zzyzzy.spring.massai_mara_park.model.Image2;

@Repository
public interface ImageRepository extends JpaRepository<Image2, Long> {

}
