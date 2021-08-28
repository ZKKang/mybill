package gui.service;

import gui.dao.CategoryDAO;
import gui.dao.RecordDAO;
import gui.entity.Category;
import gui.entity.Record;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.setSpend(spend);
        r.setCategoryId(c.getId());
        r.setComment(comment);
        r.setDate(date);
        recordDao.add(r);
    }

    public List<Record> list(){
        List<Record> records = recordDao.list();
        List<Category> categorys = categoryDAO.list();
        Map<Integer,String> categoryMap = new HashMap<>();
        for(Category category:categorys) {
            categoryMap.put(category.getId(),category.getName());
        }
        for(Record record : records) {
            record.setCategoryName(categoryMap.get(record.getCategoryId()));
        }
        return records;
    }

    public List<Record> listByCategoryId(Category category) {
        List<Record> records = recordDao.list(category.getId());
        return records;
    }

}
