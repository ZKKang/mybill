package gui.service;

import gui.dao.RecordDAO;
import gui.entity.Record;
import gui.page.SpendPage;
import gui.util.DateUtil;

import java.util.List;

public class SpendService {
    public SpendPage getSpendPage() {
        RecordDAO dao = new RecordDAO();
        // 本月数据
        List<Record> thisMonthRecords = dao.listThisMonth();
        // 今日数据
        List<Record> toDayRecords = dao.listToday();
        // 本月总天数
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        double monthSpend = 0;
        double todaySpend = 0;
        double avgSpendPerDay = 0;
        double monthAvailable = 0;
        double dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        // 预算
        double monthBudget = new ConfigService().getIntBudget();

        // 统计本月消费
        for (Record record : thisMonthRecords) {
            monthSpend += record.getSpend();
        }

        // 统计今日消费
        for (Record record : toDayRecords) {
            todaySpend += record.getSpend();
        }
        // 计算日均消费
        avgSpendPerDay = (double)Math.round((monthSpend / thisMonthTotalDay)*100)/100;
        // 计算本月剩余
        monthAvailable = monthBudget - monthSpend;

        // 距离月末
        monthLeftDay = DateUtil.thisMonthLeftDay();

        // 计算日均可用
        dayAvgAvailable = (double)Math.round((monthAvailable / monthLeftDay)*100)/100;

        // 计算使用比例
        usagePercentage = new Double(monthSpend * 100/ monthBudget).intValue();

        // 根据这些信息，生成SpendPage对象
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
                usagePercentage);
    }
}
