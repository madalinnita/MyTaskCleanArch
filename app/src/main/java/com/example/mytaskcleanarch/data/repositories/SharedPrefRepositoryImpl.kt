package com.example.mytaskcleanarch.data.repositories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.Album
import repositories.SharedPrefRepository
import util.Constants
import java.lang.reflect.Type


class SharedPrefRepositoryImpl(private val context: Context): SharedPrefRepository {
    private val sharedPref =
        context.getSharedPreferences(Constants.SHARED_PREF_FILE, Context.MODE_PRIVATE)

    override fun saveAllAlbums(albums: List<Album>) {
        val editor = sharedPref.edit()

        val gson = Gson()
        val json = gson.toJson(albums)

        editor.putString(Constants.LIST_OF_ALBUMS, json);
        editor.commit();
    }

    override fun getAllAlbums(): List<Album?>? {
        val serializedObject: String = sharedPref.getString(Constants.LIST_OF_ALBUMS, "")!!
        val gson = Gson()
        val type: Type = object : TypeToken<List<Album?>?>() {}.type
        return gson.fromJson(serializedObject, type)
    }

}