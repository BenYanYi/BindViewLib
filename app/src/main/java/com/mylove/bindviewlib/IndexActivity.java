package com.mylove.bindviewlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.mylove.viewbind.OnClick;
import com.mylove.viewbind.ViewBind;

/**
 * @author YanYi
 * @date 2019/3/1 17:27
 * @email ben@yanyi.red
 * @overview
 */
public class IndexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ViewBind.bind(this);
    }

    @OnClick({R.id.but})
    public void onClick() {
        Log.v("测试", "点击");
        Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
    }
}
