## xUtils3 ORM 简介
* xUtils 的子模块只包含了orm,并且特性强大,方便扩展:
  - 基于高效稳定的`orm`工具.

#### 使用Gradle构建时添加一下依赖即可:
```javascript
compile 'org.xutils.db:xutils:3.5.2'
```
##### 混淆配置参考示例项目sample的配置
#### 说明
- 该项目基于xUtils3 `v3.5.0`来进行删减操作
- 数据库配置：
```
#文件地址 assets/db/database.json

{
  "directory": "test", //数据库目录，／data/data/app_package/databases/
  "name": "test.db", //数据库名字，／data/data/app_package/databases/test/test.db
  "version": 2 //数据库版本
}
```

#### 使用前配置
##### 需要的权限
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
##### 初始化
```java
// 在application的onCreate中初始化
@Override
public void onCreate() {
    super.onCreate();
    x.Ext.init(this);
    x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    ...
}
```

### 使用数据库(更多示例参考sample项目)
```java
Parent test = db.selector(Parent.class).where("id", "in", new int[]{1, 3, 6}).findFirst();
long count = db.selector(Parent.class).where("name", "LIKE", "w%").and("age", ">", 32).count();
List<Parent> testList = db.selector(Parent.class).where("id", "between", new String[]{"1", "5"}).findAll();
```

----
### 关于作者
* Email： <wyouflf@qq.com>, <wyouflf@gmail.com>
* 有任何建议或者使用中遇到问题都可以给我发邮件, 你也可以加入QQ群：330445659(已满), 275967695, 257323060,
384426013, 176778777, 169852490, 261053948, 330108003, 技术交流，idea分享 *_*
