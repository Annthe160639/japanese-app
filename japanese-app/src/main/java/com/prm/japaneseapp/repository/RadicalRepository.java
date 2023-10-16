package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.RadicalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RadicalRepository extends BaseRepository<RadicalEntity, Long> {

//    @Query("select r from  RadicalEntity r where r.radicalCategory.id = 1")
    @Query(value = "select * from radical where radical_category_id = :categoryId", nativeQuery = true)
    List<RadicalEntity> findAllByRadicalCategory_Id(@Param("categoryId") Integer categoryId);
}
