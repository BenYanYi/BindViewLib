# BindView
## BindView注解封装
### 使用方法

module 下添加

    compile 'com.yanyi.benyanyi:viewbind:1.0.0'
    
### 使用方法

在Activity中添加
    
    ViewBind.bind(this);
    
在Fragment中添加

    ViewBind.bind(view, this);
    
绑定id
    
    @BindView(R.id.xxx)
    
添加点击方法

    @OnClick({R.id.xxx, R.id.xxx})
    
添加点击方法网络判断

    @ClickNet()
    其中存在两个参数，netErrorMsg默认值为“网络错误”,isCheckNet默认值为true(也就是说点击方法网络判断打开)
    
### 更新记录
* 2018/12/26 提交1.0.0版本


