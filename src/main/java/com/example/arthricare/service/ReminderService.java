package com.example.arthricare.service;

import com.example.arthricare.bean.Medication;
import com.example.arthricare.bean.Reminder;
import com.example.arthricare.bean.valueObject.MyMedPageReminderData;
import com.example.arthricare.mapper.ReminderMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReminderService {

    private final ReminderMapper reminderMapper;

    public ReminderService(ReminderMapper reminderMapper) {
        this.reminderMapper = reminderMapper;
    }

    public void createIntermittentReminders(String reminderTimesJson, int medicationId,String dateValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        try {
            String[] reminderDateArray = objectMapper.readValue(dateValue, String[].class);
            String[] reminderTimesArray = objectMapper.readValue(reminderTimesJson, String[].class);

            for (String reminderDate : reminderDateArray) {
                Date parsedDate = dateFormat.parse(reminderDate);

                for (String reminderTime : reminderTimesArray) {
                    // Combine the date and time
                    Date parsedTime = timeFormat.parse(reminderTime);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parsedDate);
                    Calendar timeCalendar = Calendar.getInstance();
                    timeCalendar.setTime(parsedTime);

                    calendar.set(Calendar.HOUR_OF_DAY, timeCalendar.get(Calendar.HOUR_OF_DAY));
                    calendar.set(Calendar.MINUTE, timeCalendar.get(Calendar.MINUTE));

                    // Create a Reminder object for each combination
                    Reminder reminder = new Reminder();
                    reminder.setMedicationId(medicationId);
                    reminder.setReminderTime(new java.sql.Time(calendar.getTime().getTime())); // Set the java.sql.Time object
                    reminder.setDate(new java.sql.Date(calendar.getTime().getTime())); // Set the java.sql.Date object

                    //System.out.println(reminder);
                    reminderMapper.createReminder(reminder);
                    reminderMapper.updateDateTime(reminder.getReminderId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing JSON or other exceptions
        }
    }

    public void createDailyReminders(String reminderTimesJson, int medicationId, Date startDate, Date endDate) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 将JSON字符串解析成数组
            String[] reminderTimesArray = objectMapper.readValue(reminderTimesJson, String[].class);
            // 示例：假设你使用JdbcTemplate来操作数据库
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (!calendar.getTime().after(endDate) || isSameDay(calendar.getTime(), endDate)) {
                // 对于每天的开始时间和结束时间，创建不同的提醒时间
                for (String reminderTime : reminderTimesArray) {
                    try {
                        // 将字符串转换为java.util.Date对象
                        Date date = sdf.parse(reminderTime);

                        // 设置提醒的小时和分钟
                        calendar.set(Calendar.HOUR_OF_DAY, date.getHours());
                        calendar.set(Calendar.MINUTE, date.getMinutes());

                        // 将java.util.Date对象转换为java.sql.Time对象
                        Time time = new Time(calendar.getTime().getTime());

                        // 创建Reminder对象并设置属性
                        Reminder reminder = new Reminder();
                        reminder.setMedicationId(medicationId);
                        reminder.setReminderTime(time);
                        reminder.setDate(new java.sql.Date(calendar.getTime().getTime())); // Set the java.sql.Date object

                        //System.out.println(reminder);
                        // 将提醒时间插入到数据库中
                        reminderMapper.createReminder(reminder);
                        reminderMapper.updateDateTime(reminder.getReminderId());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                // 每次循环后增加一天
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 处理解析JSON异常
        }

        // 在这里继续处理其他Medication属性，将药物信息插入到数据库等操作
    }

    public void updateReminder(Medication m)
    {
        deleteReminderByMedicationId(m.getMedicationId());

        if(m.getFrequency().equals("Daily medication"))
        {   System.out.println("Daily medication");
            createDailyReminders(m.getReminderTimes(),m.getMedicationId(),m.getStartDate(),m.getEndDate());
        }else if(m.getFrequency().equals("Intermittent medication"))
        {
            System.out.println("Intermittent medication");
            createIntermittentReminders(m.getReminderTimes(),m.getMedicationId(),m.getReminderDate());
        }
    }

    public void deleteReminderByMedicationId(int medicationId)
    {
        reminderMapper.deleteReminderByMedicationId(medicationId);
    }

    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }


    public MyMedPageReminderData findNextReminderTime(long medicationId) {
        List<Reminder> reminderList = reminderMapper.findReminderByMedicationId(medicationId);

        // Sort the list based on reminderDateTime
        Collections.sort(reminderList, new Comparator<Reminder>() {
            @Override
            public int compare(Reminder r1, Reminder r2) {
                return r1.getReminderDateTime().compareTo(r2.getReminderDateTime());
            }
        });

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, MMM d");

        MyMedPageReminderData data = new MyMedPageReminderData();
        // Find the first reminderDateTime that is after the current time
        for (Reminder r : reminderList) {
            if (r.getReminderDateTime().after(currentDate)) {
                data.setReminderDate(r.getReminderDateTime());
                data.setReminderMessage(formatDateString(r.getReminderDateTime(),r.getReminderTime()));
                return data;
            }
        }

        data.setReminderDate(reminderList.get(0).getReminderDateTime());
        data.setReminderMessage(formatDateString(reminderList.get(0).getReminderDateTime(),reminderList.get(0).getReminderTime()));
        // If no reminderDateTime is after the current time, return the first reminderDateTime (cycling)
        return data;
    }

    private String formatDateString(Date date, Time time) {
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        if (dateFormat.format(date).equals(dateFormat.format(today))) {
            return "Today, " + timeFormat.format(time);
        } else if (dateFormat.format(date).equals(dateFormat.format(tomorrow))) {
            return "Tomorrow, " + timeFormat.format(time);
        } else {
            long diffInMillis = date.getTime() - today.getTime();
            long daysDiff = (long) Math.ceil((double) diffInMillis / (1000 * 60 * 60 * 24));
            return "In " + daysDiff + " days, " + timeFormat.format(time);
        }
    }



    public boolean checkMedicationExpiration(long medicationId)
    {

        List<Reminder> reminderList = reminderMapper.findReminderByMedicationId(medicationId);
        Date currentDate =  new Date();
        for(Reminder r: reminderList)
        {
            if (r.getReminderDateTime().after(currentDate)) {
                return false;
            }
        }
        return true;
    }



    public List<Time> findUniqueReminderTimeByMedicationId(Long medicationId)
    {
        return reminderMapper.findUniqueReminderTimeByMedicationId(medicationId);
    }

    public Reminder findReminderByReminderId(long reminderId)
    {
        return  reminderMapper.findReminderByReminderId(reminderId);
    }

    public void takeMedication(long reminderId,Date date)
    {
        Date dateProperty = new Date();

        // 选择日期时间格式，这里使用 ISO 8601 标准格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 将日期属性转换为字符串
        String dateString = formatter.format(date);
        reminderMapper.takeMedication(reminderId,dateString);

    }

    public String checkMedicationTakeTime(long medicationId)
    {
        int scheduleNum = reminderMapper.checkMedicationScheduleTakeTime(medicationId);
        int realNum = reminderMapper.checkMedicationRealTakeTime(medicationId);
        String result = realNum + "/" + scheduleNum +" times";
        return result;
    }

}
