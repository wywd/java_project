package com.wangyu.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class DateConverter
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/12 20:48
 **/
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String dateStr) {
        // 将日期字符串转换成日期对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
