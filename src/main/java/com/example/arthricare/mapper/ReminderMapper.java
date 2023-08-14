package com.example.arthricare.mapper;

import com.example.arthricare.bean.Reminder;
import org.apache.ibatis.annotations.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface ReminderMapper {

    @Insert("INSERT INTO reminders (medication_id, reminder_time, date) VALUES (#{reminder.medicationId}, #{reminder.reminderTime}, #{reminder.date})")
    @Options(useGeneratedKeys = true, keyProperty = "reminderId", keyColumn = "reminder_id")
    void createReminder(@Param("reminder") Reminder reminder);

    @Update("UPDATE reminders SET reminder_datetime = CONCAT(DATE_FORMAT(date, '%Y-%m-%d'), ' ', reminder_time) where reminder_id = #{reminder_id}")
    void updateDateTime(long reminder_id);

    @Select("SELECT * FROM reminders WHERE reminder_id = #{reminderId}")
    @Results({
            @Result(property = "reminderId", column = "reminder_id"),
            @Result(property = "medicationId", column = "medication_id"),
            @Result(property = "reminderTime", column = "reminder_time"),
            @Result(property = "date", column = "date"),
            @Result(property = "alreadyTakeMedication", column = "alreadyTakeMedication"),
            @Result(property = "takeMedTime", column = "takeMed_time")
    })
    Reminder findReminderByReminderId(long reminder_id);

    @Select("SELECT * FROM reminders WHERE medication_id = #{medication_id}")
    @Results({
            @Result(property = "reminderId", column = "reminder_id"),
            @Result(property = "medicationId", column = "medication_id"),
            @Result(property = "reminderTime", column = "reminder_time"),
            @Result(property = "date", column = "date"),
            @Result(property = "alreadyTakeMedication", column = "alreadyTakeMedication"),
            @Result(property = "takeMedTime", column = "takeMed_time"),
            @Result(property = "reminderDateTime", column = "reminder_datetime")
    })
    List<Reminder> findReminderByMedicationId(long medication_id);

    @Update("UPDATE reminders SET takeMed_time = #{takeMed_time}, alreadyTakeMedication = true WHERE reminder_id = #{reminder_id}")
    void takeMedication(@Param("reminder_id") long reminder_id, @Param("takeMed_time") String takeMed_time);


    @Select("SELECT COUNT(*) from reminders WHERE medication_id = #{medication_id}")
    int checkMedicationScheduleTakeTime(long medication_id);

    @Select("SELECT COUNT(*) from reminders WHERE medication_id = #{medication_id} And alreadyTakeMedication = true")
    int checkMedicationRealTakeTime(long medication_id);

;

    @Select("SELECT DISTINCT reminder_time from reminders WHERE medication_id = #{medication_id} ORDER BY reminder_time;")
    List<Time>findUniqueReminderTimeByMedicationId(long medication_id);

    @Delete("Delete from reminders WHERE medication_id = #{medication_id}")
    void deleteReminderByMedicationId(long medication_id);
}
