package com.op.flow.manage.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;


/**
 * 配置文件读取类
 *
 * @author MengFanwei
 */
public class ConfigUtil {
    private static Logger logger = Logger.getLogger(ConfigUtil.class);
    private final static String CONF_DIR = "conf";

    private static ConfigUtil config = new ConfigUtil();
    /**
     * 所有配置
     */
    private HashMap<String, String> confMap = new HashMap<String, String>();

    /**
     * 构造方法
     */
    private ConfigUtil() {
        init();
    }

    /**
     * 单例
     */
    public synchronized static ConfigUtil getInstance() {
        return config;
    }

    /**
     * 初始化
     */
    private void init() {
        try {
            Properties prop = new Properties();
            String pathName = ConfigUtil.class.getClassLoader().getResource("").getPath() + CONF_DIR;
            pathName = pathName.replaceAll("%20", " ");
            File confdir = new File(pathName);
            if (confdir == null || confdir.exists() == false) {
                return;
            }
            String[] conffiles = confdir.list();
            if (conffiles != null && conffiles.length > 0) {
                for (int i = 0; i < conffiles.length; ++i) {
                    refleshConf(conffiles[i]);
                }
            }
        } catch (Exception e) {
            logger.error("load config error", e);
        }
    }

    /**
     * 单独从新载入某个文件
     *
     * @param conf
     */
    public void refleshConf(String conf) {
        logger.debug("refleshConf:" + conf);
        FileInputStream in = null;
        try {
            Properties prop = new Properties();
            String pathName = ConfigUtil.class.getClassLoader().getResource("").getPath() + CONF_DIR;
            pathName = pathName.replaceAll("%20", " ");
            in = new FileInputStream(pathName + "/" + conf);
            prop.load(in);
            addConf(prop, conf);
        } catch (Exception ee) {
            logger.error("!load file error!", ee);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param toadd
     * @param prestr
     */
    private void addConf(Properties toadd, String prestr) {
        if (toadd == null || prestr == null || prestr.length() == 0) {
            logger.error("error toadd/prestr in confcenter");
            return;
        }
        prestr = prestr.replace("properties", "");
        for (Object key : toadd.keySet()) {
            logger.info(prestr + key + ":" + toadd.getProperty(key.toString()));
            confMap.put(prestr + key, toadd.getProperty(key.toString()));
        }
        toadd.clear();
    }


    /**
     * 刷新全部配置文件
     */
    public void refleshAll() {
        logger.debug(" reflesh all");
        init();
    }

    /**
     * 获取数字类型配置的key
     *
     * @param key
     * @param def
     * @return
     */
    public Integer getIntByKey(String key, Integer def) {
        try {
            String resultstr = getByKey(key);
            if (resultstr == null) {
                return def;
            } else {
                return Integer.parseInt(resultstr);
            }
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 获取float类型配置的key
     *
     * @param key
     * @param def
     * @return
     */
    public Float getFloatByKey(String key, Float def) {
        try {
            String resultstr = getByKey(key);
            if (resultstr == null) {
                return def;
            } else {
                return Float.parseFloat(resultstr);
            }
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 获取指定配置文件下及前缀所有的键值
     *
     * @param fileName 配置文件名（不能为空）
     * @param prefix   key值前对（可以为空）
     * @return
     */
    public Map<String, String> getAllMap(String fileName, String prefix) {
        Map<String, String> map = new HashMap<String, String>();
        if (confMap == null || StringUtil.isEmpty(fileName)) {
            return map;
        }
        if (prefix == null) {
            fileName += ".";
        } else {
            fileName += "." + prefix;
        }
        Iterator<String> iter = confMap.keySet().iterator();
        String key = null;
        while (iter.hasNext()) {
            key = iter.next();
            if (key.startsWith(fileName)) {
                map.put(key.replace(fileName, ""), confMap.get(key));
            }
        }
        return map;
    }


    public String getByKey(String key) {
        if (key == null) {
            return null;
        }
        String srt = confMap.get(key);
        return srt;
    }

    public Boolean getBoolByKey(String key, Boolean def) {

        try {
            String resultstr = getByKey(key);
            if (resultstr == null) {
                return def;
            } else {
                return Boolean.parseBoolean(resultstr);
            }
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 获取字符型配置
     *
     * @param key   配置key
     * @param dfstr 默认值
     * @return
     */
    public String getStringByKey(String key, String dfstr) {
        try {
            String resultstr = getByKey(key);
            if (resultstr == null) {
                logger.debug(key + ":null====================");
                return dfstr;
            }
            return resultstr.trim();
        } catch (Exception e) {
            logger.error(key + ":not null=======================", e);
            return dfstr;
        }
    }

    /**
     * 获取某个语言下字符型配置,用于国际化
     *
     * @param key   配置key
     * @param dfstr 默认值
     * @param lan   语言,为空默认中文,_en结尾是英文
     * @return
     */
    public String getStringByKey(String key, String dfstr, String lan) {
        try {
            String resultstr = getByKey(key + "_" + lan);
            if (resultstr == null) {
                return dfstr;
            }
            return resultstr;
        } catch (Exception e) {
            return dfstr;
        }
    }


    public static void main(String[] args) {
        ConfigUtil configUtil = ConfigUtil.getInstance();
        //configUtil.refleshAll();
        configUtil.refleshConf("mailConf.properties");
    }
}
