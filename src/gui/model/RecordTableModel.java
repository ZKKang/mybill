package gui.model;

import gui.entity.Category;
import gui.entity.Record;
import gui.panel.CategoryPanel;
import gui.service.CategoryService;
import gui.service.RecordService;
import gui.util.DateUtil;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class RecordTableModel implements TableModel {

    String[] columnNames = new String[]{"编号","消费金额","消费类型","备注","消费日期"};
    public List<Category> categories = new ArrayList<>();
    public List<Record> records = new ArrayList<>();
    public Category category= null;

    public RecordTableModel() {
        categories = new CategoryService().list();
        category = CategoryPanel.instance.getSelectedCategory();
        records = new RecordService().listByCategoryId(category);
    }

    @Override
    public int getRowCount() {
        return records.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record record = records.get(rowIndex);
        switch (columnIndex) {
            case 0 : return record.getId();
            case 1 : return record.getSpend();
            case 2 : return category.getName();
            case 3 : return record.getComment();
            case 4 : return record.getDate();
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Record record = records.get(rowIndex);
        switch (columnIndex) {
            case 0 : record.setId((int)aValue);
            case 1 : record.setSpend((int)aValue);
            case 2 : record.setCategoryName((String)aValue);
            case 3 : record.setComment((String)aValue);
            case 4 : ;
            default : ;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
