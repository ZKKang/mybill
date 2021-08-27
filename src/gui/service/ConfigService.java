package gui.service;

import gui.dao.ConfigDAO;
import gui.entity.Config;

public class ConfigService {

    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO dao= new ConfigDAO();
    static{
        init();
    }
    public static void init(){
        init(budget, default_budget);
        init(mysqlPath, "");
    }
    private static void init(String code, String value) {

        Config config= dao.getByCode(code);
        if(config==null){
            Config c = new Config();
            c.setCode(code);
            c.setValue(value);
            dao.add(c);
        }
    }

    public String get(String key) {
        Config config= dao.getByCode(key);
        return config.getValue();
    }

    public void update(String key, String value){
        Config config= dao.getByCode(key);
        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
}
