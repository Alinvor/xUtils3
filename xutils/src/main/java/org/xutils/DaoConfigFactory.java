package org.xutils;


import android.content.Context;

import org.xutils.bean.DBBean;
import org.xutils.utils.DebugUtils;
import org.xutils.utils.JsonUtils;

/**
 * Created by ROOTS on 2017/6/15.
 */
public class DaoConfigFactory {


    private static DbManager.DaoConfig daoConfig;

    public static DbManager.DaoConfig obtainConfig(Context context) {
        if (null == daoConfig) {
            synchronized (DaoConfigFactory.class) {
                if (null == daoConfig) {
                    DBBean dbBean = getDbBean(context, "database.json");
                    if (null != dbBean) {
                        daoConfig = obtainDaoConfig();
                        daoConfig.setDbName(dbBean.getName()).setDbDir(context.getDatabasePath(dbBean.getDirectory())).setDbVersion(dbBean.getVersion()).setDbOpenListener(new DbManager.DbOpenListener() {
                            @Override
                            public void onDbOpened(DbManager db) {
                                db.getDatabase().enableWriteAheadLogging();
                            }
                        });
                    }
                }
            }
        }
        return daoConfig;
    }

    public static DBBean getDbBean(Context context, String name) {
        return JsonUtils.json2Obj(DebugUtils.hook(context, "db", name), DBBean.class);
    }

    public static DbManager.DaoConfig obtainDaoConfig() {
        return new DbManager.DaoConfig();
    }

}
