package org.xutils.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/9/21.
 */
public class MockServer {

    protected static MockServer mockServer;
    protected static String DEFAULT_MOCK_DIRECTORY = "mock";

    protected Context context;

    private MockServer() {
    }

    public static MockServer getInstance() {
        if (null == mockServer) {
            synchronized (MockServer.class) {
                if (null == mockServer) {
                    mockServer = new MockServer();
                }
            }
        }
        return mockServer;
    }

    public String obtainMock(Context context, String fileName) {
        if (null == context) return null;
        if (null == fileName || "".equals(fileName)) return null;
        String content = null;
        AssetManager assets = context.getAssets();
        try {
            InputStream inputStream = assets.open(fileName, AssetManager.ACCESS_BUFFER);
            int size = inputStream.available();
            char[] buffer = new char[size];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), size);
            bufferedReader.read(buffer);
            inputStream.close();
            bufferedReader.close();
            content = new String(buffer);
            if (content.contains("\r\n"))
                content = content.replace("\r\n", "");
            content = content.trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public final String obtainMockFile(Context context, String path, String fileName) {
        if (null == path || "".equals(path)) return null;
        return obtainMock(context, path + File.separator + fileName);
    }

    public final String obtainDefaultMock(Context context, String fileName) {
        return obtainMock(context, DEFAULT_MOCK_DIRECTORY + File.separator + fileName);
    }

    public String getDefaultMockDirectory() {
        return DEFAULT_MOCK_DIRECTORY;
    }

    public void setDefaultMockDirectory(String defaultMockDirectory) {
        DEFAULT_MOCK_DIRECTORY = defaultMockDirectory;
    }

    public Context getContext() {
        return context;
    }

    public void init(Context context) {
        this.context = context;
    }
}
