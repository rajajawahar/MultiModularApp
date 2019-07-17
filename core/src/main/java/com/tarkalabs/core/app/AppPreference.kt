package com.tarkalabs.core.app

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.Collections

class AppPreference {

    private val PREF_PERSON_ID = "PERSON_ID"
    private val PREF_USER_NAME = "USER_NAME"
    private val PREF_USER_ID = "USER_ID"
    private val PREF_IS_LOGGED_IN = "IS_LOGGED_IN"
    private val PREF_SESSTOKEN = "SESS_TOKEN"

    private val PREF_FOODSESSION = "FOOD_SESSION"
    private val PREF_DISHCUISINE = "DISH_CUISINE"

    private var mSharedPreferences: SharedPreferences? = null
    private val PREF_USER_SITE = "USER_SITE"
    private var context: Context? = null

    constructor(context: Context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun getUserName(): String? {
        return mSharedPreferences!!.getString(PREF_USER_NAME, null)
    }

    fun setUserName(userName: String?) {
        mSharedPreferences!!.edit().putString(PREF_USER_NAME, userName).apply()
    }

    fun getUserId(): Int {
        return mSharedPreferences!!.getInt(PREF_USER_ID, 0)
    }

    fun setUserId(userId: Int) {
        mSharedPreferences!!.edit().putInt(PREF_USER_ID, userId).apply()
    }

    fun getToken(): String {
        return "Bearer " + mSharedPreferences!!.getString(PREF_SESSTOKEN, null)
    }

    fun setToken(sessionToken: String) {
        mSharedPreferences!!.edit().putString(PREF_SESSTOKEN, sessionToken).apply()
    }

    fun isUserLoggedIn(): Boolean {
        return mSharedPreferences!!.getBoolean(PREF_IS_LOGGED_IN, false)
    }

    fun setLoginStatus(status: Boolean) {
        mSharedPreferences!!.edit().putBoolean(PREF_IS_LOGGED_IN, status).apply()
    }

    fun clearAll() {

        mSharedPreferences!!.edit().clear().apply()
    }

    fun getFoodSession(): MutableList<String>? {
        val stringSet = mSharedPreferences!!.getStringSet(PREF_FOODSESSION, Collections.emptySet())
        return stringSet?.toMutableList()
    }

    fun setFoodSession(foodSession: MutableList<String>?) {
        val hashList: HashSet<String> = HashSet()
        if (foodSession != null)
            hashList.addAll(foodSession)
        mSharedPreferences!!.edit().putStringSet(PREF_FOODSESSION, hashList).apply()
    }

    fun getDishCuisine(): MutableList<String>? {
        val stringSet = mSharedPreferences!!.getStringSet(PREF_DISHCUISINE, Collections.emptySet())
        return stringSet?.toMutableList()
    }

    fun setDishCuisine(dishCuisine: MutableList<String>?) {
        val hashList: HashSet<String> = HashSet()
        if (dishCuisine != null)
            hashList.addAll(dishCuisine)
        mSharedPreferences!!.edit().putStringSet(PREF_DISHCUISINE, hashList).apply()
    }
}