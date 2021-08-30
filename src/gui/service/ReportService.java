package gui.service;

import gui.dao.RecordDAO;
import gui.entity.Record;
import gui.util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportService {

    /**
     * 获取某一天的消费金额
     * @param d
     * @param monthRawData
     * @return
     */
    public double getDaySpend(Date d, List<Record> monthRawData){
        double daySpend = 0;
        for (Record record : monthRawData) {
            if(record.getDate().equals(d))
                daySpend+=record.getSpend();
        }
        return daySpend;
    }

    /**
     * 获取一个月的消费记录集合
     * @return
     */
    public List<Record> listThisMonthRecords() {
        RecordDAO dao= new RecordDAO();
        List<Record> monthRawData= dao.listThisMonth();
        List<Record> result= new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record r = new Record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth=c.getTime() ;
            double daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            r.setSpend(daySpend);
            result.add(r);
        }
        return result;

    }
}
