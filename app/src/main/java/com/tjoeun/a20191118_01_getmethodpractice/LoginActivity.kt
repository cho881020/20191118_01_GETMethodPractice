package com.tjoeun.a20191118_01_getmethodpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tjoeun.a20191118_01_getmethodpractice.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_login.*

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
