package com.example.mobilelele.repository;

import com.example.mobilelele.model.enitity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    @Query("SELECT b FROM BrandEntity b JOIN FETCH b.models ")
    List<BrandEntity> getAllBrands();
}
