package com.myskills.demo.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {


  public static final String DD_MM_YYYY = "dd-mm-yyyy";

  public static String getStringFromDate(Date postedOn) {
    DateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY);
    return dateFormat.format(postedOn);
  }

  public static Date getDateFromString(String postedOn) {
    Date date;
    DateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY);
    try {
      date = dateFormat.parse(postedOn);
    } catch (Exception e) {
      date = new Date();
    }
    return date;
  }


}
