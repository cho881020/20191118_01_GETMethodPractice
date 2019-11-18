package com.tjoeun.a20191118_01_getmethodpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191118_01_getmethodpractice.utils.ContextUtil
import com.tjoeun.a20191118_01_getmethodpractice.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValeus()
    }


    override fun setupEvents() {

        rememberIdCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->

//            연습문제.
//            각각의 결과를 저장하고 상황에 맞는 토스트를 띄우자.
//            앱을 다시 킬때 체크했던 결과를 이어서 보여주자.

            ContextUtil.setIdRemember(mContext, isChecked)
            if (isChecked) {
                Toast.makeText(mContext, "아이디를 저장하려 합니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(mContext, "아이디를 저장하지 않습니다.", Toast.LENGTH_SHORT).show()
            }

        }

        loginBtn.setOnClickListener {

            ServerUtil.postRequestLogin(mContext,
                idEdt.text.toString(),
                pwEdt.text.toString(),
                object : ServerUtil.JsonResponseHandler {
                    override fun onResponse(json: JSONObject) {
                        Log.d("로그인응답", json.toString())

                        val code = json.getInt("code")

                        if (code == 200) {

                            val data = json.getJSONObject("data")
                            val token = data.getString("token")
                            ContextUtil.setUserToken(mContext, token)

                            val intent = Intent(mContext, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        }
                        else {

                        }

                    }

                })

            if (rememberIdCheckBox.isChecked) {

                ContextUtil.setUserId(mContext, idEdt.text.toString())

                Toast.makeText(mContext, "아이디를 저장했습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(mContext, "아이디 저장 X", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun setValeus() {

//        저장되어있는 아이디가 뭔지?
        var savedId = ContextUtil.getUserId(mContext)
        idEdt.setText(savedId)

//        아이디를 기억한다고 했는지
        val needIdRemeber = ContextUtil.getIdRemember(mContext)
        rememberIdCheckBox.isChecked = needIdRemeber

    }


}
