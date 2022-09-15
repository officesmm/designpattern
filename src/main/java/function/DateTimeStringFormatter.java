package function;

import java.time.LocalDateTime;

public class DateTimeStringFormatter {

    private LocalDateTime localDateTime;
    private int year;
    private int month;
    private int dayOfMonth;
    private int hour;
    private int minute;
    private int second;
    private int milliSecond;

    private char[] dateTimeChArr;

    public DateTimeStringFormatter(String dateTimeString) {
        dateTimeChArr = new char[dateTimeString.length()];
        for (int i = 0; i < dateTimeString.length(); i++) {
            dateTimeChArr[i] = dateTimeString.charAt(i);
        }
        year = Integer.parseInt(Character.toString(dateTimeChArr[0]) + dateTimeChArr[1] + dateTimeChArr[2] + dateTimeChArr[3]);
        month = Integer.parseInt(Character.toString(dateTimeChArr[4]) + dateTimeChArr[5]);
        dayOfMonth = Integer.parseInt(Character.toString(dateTimeChArr[6]) + dateTimeChArr[7]);
        hour = Integer.parseInt(Character.toString(dateTimeChArr[8]) + dateTimeChArr[9]);
        minute = Integer.parseInt(Character.toString(dateTimeChArr[10]) + dateTimeChArr[11]);
        second = Integer.parseInt(Character.toString(dateTimeChArr[12]) + dateTimeChArr[13]);
        milliSecond = Integer.parseInt(Character.toString(dateTimeChArr[14]) + dateTimeChArr[15] + dateTimeChArr[16]);
        localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
    }

    public String ReadableFormat() {
        String str = "";
        str += Character.toString(dateTimeChArr[0]) + dateTimeChArr[1] + dateTimeChArr[2] + dateTimeChArr[3];
        str += "/";
        str += Character.toString(dateTimeChArr[4]) + dateTimeChArr[5];
        str += "/";
        str += Character.toString(dateTimeChArr[6]) + dateTimeChArr[7];
        str += " ";
        str += Character.toString(dateTimeChArr[8]) + dateTimeChArr[9];
        str += ":";
        str += Character.toString(dateTimeChArr[10]) + dateTimeChArr[11];
        str += ":";
        str += Character.toString(dateTimeChArr[12]) + dateTimeChArr[13];
        return str;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMilliSecond() {
        return milliSecond;
    }

    public void setMilliSecond(int milliSecond) {
        this.milliSecond = milliSecond;
    }
}
