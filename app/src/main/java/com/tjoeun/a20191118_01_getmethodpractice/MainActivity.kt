package com.tjoeun.a20191118_01_getmethodpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191118_01_getmethodpractice.datas.User
import com.tjoeun.a20191118_01_getmethodpractice.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValeus()
    }

    override fun setupEvents() {

    }

    override fun setValeus() {

        ServerUtil.getRequestMyInfo(mContext, object : ServerUtil.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {
                Log.d("내정보응답", json.toString())

                val data = json.getJSONObject("data")
                val user = data.getJSONObject("user")

                var me = User.getUserFromJson(user)

                runOnUiThread {
                    nameTxt.text = me.name
                    phoneNumTxt.text = me.phone
                    loginIdTxt.text = me.login_id
                    categoryTxt.text = me.category.title
                }
            }

        })

    }

}
