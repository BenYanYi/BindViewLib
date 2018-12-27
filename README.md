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

    @ClickNet(使用默认值,其中存在两个参数，netErrorMsg默认值为“网络错误”,isCheckNet默认值为true(也就是说点击方法网络判断打开))
    @ClickNet(netErrorMsg = "请检查您的网络")(更改点击事件提示问题)
    @ClickNet(isCheckNet = false)(关闭点击事件网络监听)
    
    
### 更新记录
* 2018/12/26 提交1.0.0版本

<br/>
若在使用过程中出现什么问题，可以联系作者<br/>
作者：演绎<br/>
QQ：1541612424<br/>
email： work@yanyi.red<br/>
微信公众号：benyanyi(演绎未来)&nbsp;&nbsp;&nbsp;将会不定期的更新关于android的一些文章


