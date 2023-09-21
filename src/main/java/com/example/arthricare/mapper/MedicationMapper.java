package com.example.arthricare.mapper;

import com.example.arthricare.bean.Medication;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface MedicationMapper {

    @Insert("INSERT INTO Medications (user_id, medication_type, medication_name, medication_category, frequency, dosage_unit, start_date, end_date, note) " +
            "VALUES (#{userId}, #{medicationType}, #{medicationName}, #{medicationCategory}, #{frequency}, #{dosageUnit}, #{startDate}, #{endDate}, #{note})")
    @Options(useGeneratedKeys = true, keyProperty = "medicationId", keyColumn = "medication_id")
    void insertMedication(Medication medication);

    @Update("UPDATE medications SET user_id = #{userId}, medication_type = #{medicationType}, medication_name = #{medicationName}, " +
            "medication_category = #{medicationCategory}, frequency = #{frequency}, dosage_unit = #{dosageUnit}, " +
            "start_date = #{startDate}, end_date = #{endDate}, note = #{note} WHERE medication_id = #{medicationId}")
    void updateMedication(Medication medication);

    @Delete("DELETE FROM medications WHERE id = #{id}")
    void deleteMedication(int id);

    @Select("SELECT * FROM medications WHERE medication_id = #{medication_id}")
    @Results({
            @Result(property = "medicationType", column = "medication_type"),
            @Result(property = "medicationName", column = "medication_name"),
            @Result(property = "medicationCategory", column = "medication_category"),
            @Result(property = "dosageUnit", column = "dosage_unit"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "medicationExpiration", column = "medicationExpiration"),
            @Result(property = "note", column = "note")
    })
    Medication findById(int medication_id);

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
    @Results({
            @Result(property = "medicationType", column = "medication_type"),
            @Result(property = "medicationName", column = "medication_name"),
            @Result(property = "medicationCategory", column = "medication_category"),
            @Result(property = "dosageUnit", column = "dosage_unit"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "medicationExpiration", column = "medicationExpiration")
    })
    List<Medication> findMedicationByUserId(@Param("userId") int userId);

    @Select("SELECT reminder_id FROM reminders WHERE medication_id IN (SELECT medication_id FROM medications WHERE user_id = #{userId}) AND date = #{date}")
    List<Long> findReminderIdsByUserIdAndDate(@Param("userId") int userId, @Param("date") Date date);


    @Update("UPDATE medications SET medicationExpiration = #{statue} WHERE medication_id = #{medicationId}")
    void updateMedicationExpiration(@Param("medicationId") int medicationId, @Param("statue") boolean statue);

}

