package com.buserkapkiner.diyetonerim.ui.util
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PrivateSharedPreferences {



        companion object {

            private val ZAMAN = "zaman"
            private var sharedPreferences : SharedPreferences? = null


            @Volatile private var instance : PrivateSharedPreferences? = null
            private val lock = Any()
            operator fun invoke(context: Context) :PrivateSharedPreferences = instance ?: synchronized(lock) {
                instance ?: createToPrivateSharedPreferences(context).also {
                    instance = it
                }
            }

            private fun createToPrivateSharedPreferences(context: Context): PrivateSharedPreferences{
                sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
                return PrivateSharedPreferences()
            }


        }

        fun zamaniKaydet(zaman: Long){
            sharedPreferences?.edit(commit = true){
                putLong(ZAMAN,zaman)
            }
        }

        fun zamaniAl() = sharedPreferences?.getLong(ZAMAN,0)

    }
