package com.op.flow.manage.odps;

import com.op.flow.manage.util.ConfigUtil;

/**
 * Created by 孟凡伟 on 2017/5/5.
 */
public class Resource {
    public static String ODPS_PROJECT_NAME = ConfigUtil.getInstance().getStringByKey("db.ODPS_PROJECT_NAME", "");
    public static String ODPS_ACCESSID = ConfigUtil.getInstance().getStringByKey("db.ODPS_ACCESSID", "");
    public static String ODPS_ACCESSKEY = ConfigUtil.getInstance().getStringByKey("db.ODPS_ACCESSKEY", "");
    public static String ODPS_URL = ConfigUtil.getInstance().getStringByKey("db.ODPS_URL", "");
}
