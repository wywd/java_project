package jdbc;

import java.io.InputStream;
import java.util.Properties;

/**
 * class PropertyReader
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 11:39
 **/
public class PropertyReader {
    static private Properties ps;
    private String resolveName(String name) {
        if (!name.startsWith("/")) {
            Class<?> c = this.getClass();
            while (c.isArray()) {
                c = c.getComponentType();
            }
            String baseName = c.getPackageName();
            if (baseName != null && !baseName.isEmpty()) {
                name = baseName.replace('.', '/') + "/" + name;
            }
        } else {
            name = name.substring(1);
        }
        return name;
    }
    static {
        ps = new Properties();
        try {
            System.out.println(new PropertyReader().resolveName("/jdbc/db.conf"));
            InputStream in = PropertyReader.class.getResourceAsStream("/jdbc/db.conf");
            ps.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 读取特定属性
    public static String get(String key) {
        return (String)ps.get(key);
    }
}
