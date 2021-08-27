package gui.model;

import gui.entity.Category;
import gui.service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel  implements TableModel {

    String[] columnNames = new String[]{"分类名称","消费次数"};
    public List<Category> cs = new ArrayList<>();

    public CategoryTableModel() {
        CategoryService categoryService = new CategoryService();
        cs = categoryService.list();
    }

    @Override
    public int getRowCount() {
        return cs.size();
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
        Category category = cs.get(rowIndex);
        if(columnIndex == 0) {
            return category.getName();
        }
        if(columnIndex == 1) {
            return category.getRecordNumber();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
