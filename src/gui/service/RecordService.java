package gui.service;

import gui.dao.RecordDAO;
import gui.entity.Category;
import gui.entity.Record;

import java.util.Date;

public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.setSpend(spend);
        r.setCategoryId(c.getId());
        r.setComment(comment);
        r.setDate(date);
        recordDao.add(r);
    }
}
