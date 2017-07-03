package org.xutils.utils;

import android.content.Context;


/**
 * Created by Administrator on 2016/11/7.
 */
public class DebugUtils {

    public static String hook(Context context, String name) {
        return MockServer.getInstance().obtainDefaultMock(context, name);
    }

    public static String hook(Context context, String path, String fileName) {
        return MockServer.getInstance().obtainMockFile(context, path, fileName);
    }
}
