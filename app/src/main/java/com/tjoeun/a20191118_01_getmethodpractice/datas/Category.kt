package com.tjoeun.a20191118_01_getmethodpractice.datas

import org.json.JSONObject

class Category {

    var title = ""
    var color = ""

    companion object {
        fun getCategoryFromJson(json:JSONObject) : Category {

            var category = Category()
            category.title = json.getString("title")
            category.color = json.getString("color")

            return category

        }
    }


}