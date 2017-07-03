package org.xutils.bean;


/**
 * Created by ROOTS on 2017/6/15.
 */
public class DBBean extends BaseBean {

    protected String directory;
    protected String name;
    protected int version;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
