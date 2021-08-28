package gui.model;

import gui.entity.Category;
import gui.service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {

    public List<Category> cs = new ArrayList<>();
    Category c;

    public CategoryComboBoxModel(){
        cs = new CategoryService().list();
        if(!cs.isEmpty())
            c=cs.get(0);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof Integer) {
            for(Category category : cs) {
                if(category.getId() == (int)anItem){
                    c = category;
                    return;
                }
            }
        } else {
            c = (Category)anItem;
        }

    }

    @Override
    public Category getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
