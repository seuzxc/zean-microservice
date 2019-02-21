package com.vvm.zeanutil.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String FMT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String FMT_YYYYMMDD = "yyyyMMdd";

    public static final String FMT_DDMMYYYY = "dd/MM/yyyy";

    public static final String FMT_MMYYYY = "MM/yyyy";

    public static final String FMT_YYYY_MM_DD_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public static String currentDateStr(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
