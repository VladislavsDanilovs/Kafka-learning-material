package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.WikimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaEntity, Long> {
}
