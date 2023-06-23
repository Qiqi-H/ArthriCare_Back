package com.example.arthricare.mapper;

import com.example.arthricare.bean.Medication;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MedicationMapper {

    @Insert("INSERT INTO Medications (user_id, medication_type, medication_name, medication_category, frequency, dosage_unit, start_date, end_date, note) " +
            "VALUES (#{userId}, #{medicationType}, #{medicationName}, #{medicationCategory}, #{frequency}, #{dosageUnit}, #{startDate}, #{endDate}, #{note})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertMedication(Medication medication);

    @Update("UPDATE medications SET user_id = #{userId}, medication_type = #{medicationType}, medication_name = #{medicationName}, " +
            "medication_category = #{medicationCategory}, frequency = #{frequency}, dosage_unit = #{dosageUnit}, " +
            "start_date = #{startDate}, end_date = #{endDate} WHERE id = #{id}")
    void updateMedication(Medication medication);

    @Delete("DELETE FROM medications WHERE id = #{id}")
    void deleteMedication(Integer id);

    @Select("SELECT * FROM medications WHERE id = #{id}")
    @Results({
            @Result(property = "medicationType", column = "medication_type"),
            @Result(property = "medicationName", column = "medication_name"),
            @Result(property = "medicationCategory", column = "medication_category"),
            @Result(property = "dosageUnit", column = "dosage_unit"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date")
    })
    Medication findById(Integer id);

    @Select("SELECT * FROM medications")
    @Results({
            @Result(property = "medicationType", column = "medication_type"),
            @Result(property = "medicationName", column = "medication_name"),
            @Result(property = "medicationCategory", column = "medication_category"),
            @Result(property = "dosageUnit", column = "dosage_unit"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date")
    })
    List<Medication> findAll();


    @Select("SELECT * FROM Medications WHERE user_id = #{userId}")
    List<Medication> findMedicationByUserId(@Param("userId") int userId);
}

