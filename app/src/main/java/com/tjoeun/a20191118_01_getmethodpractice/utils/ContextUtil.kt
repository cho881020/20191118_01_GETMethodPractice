package com.tjoeun.a20191118_01_getmethodpractice.utils

import android.content.Context

class ContextUtil {

    companion object {

//        메모장의 파일 이름에 대응되는 개념.
        val prefName = "PracticePrefference"

//        사용자의 아이디를 저장하는 항목 이름
        val USER_ID = "USER_ID"
//        아이디 기억 여부 저장 항목 이름
        val ID_REMEMBER = "ID_REMEMBER"

//        사용자 아이디를 저장해주는 func => setter
        fun setUserId(context:Context, userId:String) {

//          메모장(파일이름 : PracticePrefference) 을 실제로 여는 동작
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

//          내용을 작성하고 SAVE 버튼 누름.
            pref.edit().putString(USER_ID, userId).apply()
        }

        fun getUserId(context: Context) : String {

//          메모장(파일이름 : PracticePrefference) 을 실제로 여는 동작
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return pref.getString(USER_ID, "")!!

        }

        fun setIdRemember(context:Context, isRemember:Boolean) {

            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putBoolean(ID_REMEMBER, isRemember).apply()
        }

        fun getIdRemember(context: Context) : Boolean {

            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getBoolean(ID_REMEMBER, false)!!

        }

    }

}