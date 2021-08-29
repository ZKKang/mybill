package gui.util;

import java.io.*;

public class MySqlUtil {
    public static void backup(String mysqlPath, String backupfile) throws IOException {
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%s %s -r \"%s\"";

        String command = String.format(commandFormat, mysqlPath, DBUtil.getValue("username"), DBUtil.getValue("password"), DBUtil.getValue("port"),
                DBUtil.getValue("database"), backupfile);
        Runtime.getRuntime().exec(command);
    }

    public static void recover(String mysqlPath, String recoverfile) {
        try {
            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
            String command = String.format(commandFormat, mysqlPath, DBUtil.getValue("username"), DBUtil.getValue("password"),
                    DBUtil.getValue("database"));

            Process p = Runtime.getRuntime().exec(command);
            OutputStream out = p.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
