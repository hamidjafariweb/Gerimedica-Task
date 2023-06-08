package com.gerimedica.task.repository;

import com.gerimedica.task.model.CSVData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSVDataRepository extends JpaRepository<CSVData, Long> {

}
