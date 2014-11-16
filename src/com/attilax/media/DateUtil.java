    package com.attilax.media;  
      
    import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
      
    /** 
     * <p> 
     * Title:ʱ�乤���� 
     * </p> 
     *  
     * <p> 
     * Description: 
     * </p> 
     *  
     * <p> 
     *  * </p> 
     *  
     *  
     *  
     * @since��2007-12-10 ����11:22:56 
     *  
     * @version 1.0 
     */  
    public class DateUtil {  
    	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

		/** 
         * ���ַ���ת��ΪDATE 
         *  
         * @param dtFormat 
         *            ��ʽyyyy-MM-dd HH:mm:ss �� yyyy-MM-dd 
         * @param def 
         *            �����ʽ��ʧ�ܷ���null 
         * @return 
         */  
        /** 
         * ���ַ���ת��ΪDATE 
         *  
         * @param dtFormat 
         *            ��ʽyyyy-MM-dd HH:mm:ss �� yyyy-MM-dd�� yyyy-M-dd�� yyyy-M-d�� 
         *            yyyy-MM-d�� yyyy-M-dd 
         * @param def 
         *            �����ʽ��ʧ�ܷ���null 
         * @return 
         */  
        public static Date fmtStrToDate(String dtFormat) {  
            if (dtFormat == null  
                    || dtFormat.trim().equalsIgnoreCase(  
                            SafeUtil.getDateFormat().trim())) {  
                return null;  
            }  
            if (dtFormat == null)  
                return null;  
            try {  
                if (dtFormat.length() == 9 || dtFormat.length() == 8) {  
                    String[] dateStr = dtFormat.split("-");  
                    dtFormat = dateStr[0] + (dateStr[1].length() == 1 ? "-0" : "-")  
                            + dateStr[1] + (dateStr[2].length() == 1 ? "-0" : "-")  
                            + dateStr[2];  
                }  
                if (dtFormat.length() != 10 & dtFormat.length() != 19)  
                    return null;  
                if (dtFormat.length() == 10)  
                    dtFormat = dtFormat + " 00:00:00";  
                SimpleDateFormat dateFormat = new SimpleDateFormat(  
                        YYYY_MM_DD_HH_MM_SS);  
                return dateFormat.parse(dtFormat);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return null;  
            }  
        }  
      
        /** 
         *  
         * Description:��ʽ������,�����ʽ��ʧ�ܷ���def 
         *  
         * @param dtFormat 
         * @param def 
         * @return 
         * @author ���ڼ� 
         * @since��2008-2-15 ����05:01:37 
         */  
        public static Date fmtStrToDate(String dtFormat, Date def) {  
            Date d = fmtStrToDate(dtFormat);  
            if (d == null)  
                return def;  
            return d;  
        }  
      
        /** 
         * ���ص��ն������� 
         *  
         * @return 
         * @author ���ڼ� 
         * @since��2008-2-15 ����05:03:13 
         */  
        public static Date getToDay() {  
            return toShortDate(new Date());  
        }  
      
        /** 
         *  
         * Description:��ʽ������,String�ַ���ת��ΪDate 
         *  
         * @param date 
         * @param dtFormat 
         *            ����:yyyy-MM-dd HH:mm:ss yyyyMMdd 
         * @return 
         * @author ���ڼ� 
         * @since��2007-7-10 ����11:24:00 
         */  
        public static String fmtDateToStr(Date date, String dtFormat) {  
            if (date == null)  
                return "";  
            try {  
                SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);  
                return dateFormat.format(date);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return "";  
            }  
        }  
      
        /** 
         * Description:��ָ����ʽ ��ʽ������ 
         *  
         * @param date 
         * @param dtFormat 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-10 ����11:25:07 
         */  
        public static Date fmtStrToDate(String date, String dtFormat) {  
            try {  
                SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);  
                return dateFormat.parse(date);  
            } catch (Exception e) {  
                e.printStackTrace();  
                return null;  
            }  
        }  
      
        public static String fmtDateToYMDHM(Date date) {  
            return fmtDateToStr(date, "yyyy-MM-dd HH:mm");  
        }  
      
        public static String fmtDateToYMD(Date date) {  
            return fmtDateToStr(date, "yyyy-MM-dd");  
        }  
      
        public static String fmtDateToYM(Date date) {  
            return fmtDateToStr(date, "yyyy-MM");  
        }  
      
        public static String fmtDateToM(Date date) {  
            return fmtDateToStr(date, "MM");  
        }  
      
        /** 
         *  
         * Description:ֻ���������е������� 
         *  
         * @param date 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-10 ����11:25:50 
         */  
        public static Date toShortDate(Date date) {  
            String strD = fmtDateToStr(date, "yyyy-MM-dd");  
            return fmtStrToDate(strD);  
        }  
      
        /** 
         *  
         * Description:ֻ���������е������� 
         *  
         * @param date��ʽҪ��yyyy 
         *            -MM-dd���������������� 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-10 ����11:26:12 
         */  
        public static Date toShortDate(String date) {  
            if (date != null && date.length() >= 10) {  
                return fmtStrToDate(date.substring(0, 10));  
            } else  
                return fmtStrToDate(date);  
        }  
      
        /** 
         * ����� 
         *  
         * @param countMonth 
         *            :�·ݵĸ���(������) 
         * @param flag 
         *            :true ��ǰcountMonth���µĶ���:false ����countMonth���µĶ��� 
         * @return 
         */  
        public static Date getCounterglow(int countMonth, boolean before) {  
            Calendar ca = Calendar.getInstance();  
            return getCounterglow(ca.getTime(), before ? -countMonth : countMonth);  
        }  
      
        /** 
         *  
         * Description: ����� ������+ ������- 
         *  
         * @param date 
         * @param countMonth 
         * @return 
         * @since��2007-12-13 ����03:16:47 
         */  
        public static Date getCounterglow(Date date, int num) {  
            Calendar ca = Calendar.getInstance();  
            ca.setTime(date);  
            ca.add(Calendar.MONTH, num);  
            return ca.getTime();  
        }  
      
        /** 
         *  
         * Description:��һ�� 
         *  
         * @param date 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-13 ����02:57:38 
         */  
        public static Date addDay(Date date) {  
            Calendar cd = Calendar.getInstance();  
            cd.setTime(date);  
            cd.add(Calendar.DAY_OF_YEAR, 1);  
            return cd.getTime();  
        }  
      
        /** 
         *  
         * Description:�ж�һ�������Ƿ�Ϊ������(����������) 
         *  
         * @param date 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-13 ����03:01:35 
         */  
        public static boolean isWorkDay(Date date) {  
            Calendar cd = Calendar.getInstance();  
            cd.setTime(date);  
            int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);  
            if (dayOfWeek != Calendar.SUNDAY || dayOfWeek != Calendar.SATURDAY)  
                return false;  
            return true;  
        }  
      
        /** 
         *  
         * Description:ȡһ���µ����һ�� 
         *  
         * @param date1 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-13 ����03:28:21 
         */  
        public static Date getLastDayOfMonth(Date date1) {  
            Calendar date = Calendar.getInstance();  
            date.setTime(date1);  
            date.set(Calendar.DAY_OF_MONTH, 1);  
            date.add(Calendar.MONTH, 1);  
            date.add(Calendar.DAY_OF_YEAR, -1);  
            return toShortDate(date.getTime());  
        }  
      
        /** 
         * ��ʼ��������֮���������. 
         *  
         * @param d1 
         *            ��ʼ���� 
         * @param d2 
         *            �������� 
         * @return ����������� 
         */  
        public static int getDaysInterval(Date d1, Date d2) {  
            if (d1 == null || d2 == null)  
                return 0;  
            Date[] d = new Date[2];  
            d[0] = d1;  
            d[1] = d2;  
            Calendar[] cal = new Calendar[2];  
            for (int i = 0; i < cal.length; i++) {  
                cal[i] = Calendar.getInstance();  
                cal[i].setTime(d[i]);  
                cal[i].set(Calendar.HOUR_OF_DAY, 0);  
                cal[i].set(Calendar.MINUTE, 0);  
                cal[i].set(Calendar.SECOND, 0);  
            }  
            long m = cal[0].getTime().getTime();  
            long n = cal[1].getTime().getTime();  
            int ret = (int) Math.abs((m - n) / 1000 / 3600 / 24);  
            return ret;  
        }  
      
        public static String getDayOfWeek(Date date) {  
            Calendar cl = Calendar.getInstance();  
            cl.setTime(date);  
            return "��" + toChNumber(cl.get(Calendar.DAY_OF_WEEK) - 1);  
        }  
      
        /** 
         * ������תΪ���ġ� "0123456789"->"��һ�����������߰˾�" 
         *  
         * @param num 
         *            ����Ϊ1,'0'-'9'���ַ��� 
         * @return 
         */  
        private static String toChNumber(int num) {  
            final String str = "��һ�����������߰˾�";  
            return str.substring(num, num + 1);  
        }  
      
        /** 
         *  
         * Description:ָ�����ڼӻ��days�� 
         *  
         * @param date1���� 
         * @param days���� 
         * @return 
         * @author ���ڼ� 
         * @since��2007-12-17 ����03:47:12 
         */  
        public static Date addDay(Date date1, int days) {  
            Calendar date = Calendar.getInstance();  
            date.setTime(date1);  
            date.add(Calendar.DAY_OF_YEAR, days);  
            return date.getTime();  
        }  
      
        /** 
         *  
         * Description:ָ�����ڼӻ��months�� 
         *  
         * @param date1 
         * @param months 
         * @return 
         * @author ���ڼ� 
         * @since��2008-3-5 ����05:17:26 
         */  
        public static Date addMonth(Date date1, int months) {  
            Calendar date = Calendar.getInstance();  
            date.setTime(date1);  
            date.add(Calendar.MONTH, months);  
            return date.getTime();  
        }  
      
        /** 
         *  
         * Description:ָ�����ڼӻ��years�� 
         *  
         * @param date1 
         * @param years 
         * @return 
         */  
        public static Date addYear(Date date1, int years) {  
            Calendar date = Calendar.getInstance();  
            date.setTime(date1);  
            date.add(Calendar.YEAR, years);  
            return date.getTime();  
        }  
      
        /** 
         * ָ���ڼ�Ŀ�ʼ���� 
         *  
         * @param date 
         *            ָ������ 
         * @param type 
         *            �ڼ����� 
         * @param diff 
         *            ��ָ�����ڵķ�Χ 
         * @return 
         */  
        public static Date getPeriodStart(Calendar date, int type, int diff) {  
            date.add(type, diff * (-1));  
            return date.getTime();  
        }  
      
        /** 
         * ָ���ڼ�Ŀ�ʼ���� 
         *  
         * @param date 
         *            ָ������ 
         * @param type 
         *            �ڼ����� 
         * @param diff 
         *            ��ָ�����ڵķ�Χ 
         * @return 
         */  
        public static Date getPeriodStart(Date date, int type, int diff) {  
            return getPeriodStart(dateToCalendar(date), type, diff);  
        }  
      
        /** 
         * ָ���ڼ�Ľ������� 
         *  
         * @param date 
         *            ָ������ 
         * @param type 
         *            �ڼ����� 
         * @param diff 
         *            ��ָ�����ڵķ�Χ 
         * @return 
         */  
        public static Date getPeriodEnd(Calendar date, int type, int diff) {  
            date.add(type, diff);  
            return date.getTime();  
        }  
      
        /** 
         * ָ���ڼ�Ľ������� 
         *  
         * @param date 
         *            ָ������ 
         * @param type 
         *            �ڼ����� 
         * @param diff 
         *            ��ָ�����ڵķ�Χ 
         * @return 
         */  
        public static Date getPeriodEnd(Date date, int type, int diff) {  
            return getPeriodEnd(dateToCalendar(date), type, diff);  
        }  
      
        /** 
         * ָ�������������ڵĵ�һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getWeekStart(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            cdate.set(Calendar.DAY_OF_WEEK, 2);  
            return cdate.getTime();  
        }  
      
        /** 
         * ��java.util.Date����ת����java.util.Calendar���� 
         *  
         * @param date 
         * @return 
         */  
        public static Calendar dateToCalendar(Date date) {  
            Calendar cdate = Calendar.getInstance();  
            cdate.setTime(date);  
            return cdate;  
        }  
      
        /** 
         * ָ�����������µĵ�һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getMonthStart(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            cdate.set(Calendar.DAY_OF_MONTH, 1);  
            return toShortDate(cdate.getTime());  
        }  
      
        /** 
         * ָ�������������µĵ�һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getLastMonthStart(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            cdate.set(Calendar.DAY_OF_MONTH, 1);  
            cdate.add(Calendar.MONTH, -1);  
            return toShortDate(cdate.getTime());  
        }  
      
        /** 
         * ָ����������Ѯ�ĵ�һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getTenDaysStart(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            int day = cdate.get(Calendar.DAY_OF_MONTH) / 10 * 10 + 1;  
            if (cdate.get(Calendar.DAY_OF_MONTH) % 10 == 0 || day == 31)  
                day = day - 10;  
            cdate.set(Calendar.DAY_OF_MONTH, day);  
            return cdate.getTime();  
        }  
      
        /** 
         * ָ����������Ѯ�����һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getTenDaysEnd(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            if (cdate.get(Calendar.DAY_OF_MONTH) / 10 == 2  
                    && cdate.get(Calendar.DAY_OF_MONTH) != 20)  
                return getLastDayOfMonth(date);  
            else  
                return addDay(getTenDaysStart(addDay(date, 10)), -1);  
        }  
      
        /** 
         * ָ������������ĵ�һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getYearStart(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            cdate.set(Calendar.DAY_OF_YEAR, 1);  
            return cdate.getTime();  
        }  
      
        /** 
         * ָ���������ڼ��ȵĵ�һ�� 
         *  
         * @param date 
         * @return 
         */  
        public static Date getQuarterStart(Date date) {  
            Calendar cdate = dateToCalendar(date);  
            int month = (cdate.get(Calendar.MONTH) / 3) * 3;  
            cdate.set(Calendar.MONTH, month);  
            return getMonthStart(cdate.getTime());  
        }  
      
        /** 
         * ָ�����ڷ��ش����ĵ��ַ�����ĿǰΪ���������ͣ�֮�󲹳䣩 
         *  
         * @param date 
         * @param format 
         * @return 
         */  
        public static String dateToStringByChinese(String format, Date date) {  
            String dateString = fmtDateToStr(date, format);  
            String[] dateStringArray = dateString.split("-");  
            if ("yyyy-MM-dd".equals(format)) {  
                dateString = dateStringArray[0] + "��" + dateStringArray[1] + "��"  
                        + dateStringArray[2] + "��";  
            } else if ("yyyy-MM".equals(format)) {  
                dateString = dateStringArray[0] + "��" + dateStringArray[1] + "��";  
            }  
            return dateString;  
        }  
      
        public static Date getLastDayOfYear(Date date) {  
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");  
            String years = dateFormat.format(date);  
            years += "-12-31";  
            Date returnDate = fmtStrToDate(years);  
            return toShortDate(returnDate);  
        }  
      
        /** 
         * ������������֮���������� 
         *  
         * @param date1 
         * @param date2 
         * @return 
         */  
        public static int getMonths(Date date1, Date date2) {  
            int iMonth = 0;  
            int flag = 0;  
            try {  
                Calendar objCalendarDate1 = Calendar.getInstance();  
                objCalendarDate1.setTime(date1);  
      
                Calendar objCalendarDate2 = Calendar.getInstance();  
                objCalendarDate2.setTime(date2);  
      
                if (objCalendarDate2.equals(objCalendarDate1))  
                    return 0;  
                if (objCalendarDate1.after(objCalendarDate2)) {  
                    Calendar temp = objCalendarDate1;  
                    objCalendarDate1 = objCalendarDate2;  
                    objCalendarDate2 = temp;  
                }  
                if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1  
                        .get(Calendar.DAY_OF_MONTH))  
                    flag = 1;  
      
                if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1  
                        .get(Calendar.YEAR))  
                    iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1  
                            .get(Calendar.YEAR))  
                            * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)  
                            - objCalendarDate1.get(Calendar.MONTH);  
                else  
                    iMonth = objCalendarDate2.get(Calendar.MONTH)  
                            - objCalendarDate1.get(Calendar.MONTH) - flag;  
      
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return iMonth;  
        }  
      
        /** 
         * ָ��������һ��Ѯ�ĵ�һ�� 
         */  
        public static Date getLastTenStartDate(Date date) {  
            Date returnDate = DateUtil.toShortDate(date);  
            returnDate = DateUtil.getTenDaysStart(date);  
            returnDate = DateUtil.addDay(returnDate, -1);  
            returnDate = DateUtil.getTenDaysStart(returnDate);  
            return DateUtil.toShortDate(returnDate);  
        }  
      
        /** 
         * ָ��������һ��Ѯ�����һ�� 
         */  
        public static Date getLastTenEndDate(Date date) {  
            Date returnDate = DateUtil.toShortDate(date);  
            returnDate = DateUtil.getTenDaysStart(date);  
            returnDate = DateUtil.addDay(returnDate, -1);  
            return DateUtil.toShortDate(returnDate);  
        }  
      
        /** 
         * ָ�������ϸ��µ�һ�� 
         */  
        public static Date getLastMonthStartDate(Date date) {  
            Date returnDate = DateUtil.toShortDate(date);  
            returnDate = DateUtil.getLastMonthStart(date);  
            return DateUtil.toShortDate(returnDate);  
        }  
      
        /** 
         * ָ�������ϸ������һ�� 
         */  
        public static Date getLastMonthEndDate(Date date) {  
            Date returnDate = DateUtil.toShortDate(date);  
            returnDate = DateUtil.getMonthStart(date);  
            returnDate = DateUtil.addDay(returnDate, -1);  
            return DateUtil.toShortDate(returnDate);  
        }  
      
    }  