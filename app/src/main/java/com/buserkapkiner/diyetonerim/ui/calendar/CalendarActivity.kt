package com.buserkapkiner.diyetonerim.ui.calendar

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import com.buserkapkiner.diyetonerim.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var txt_calendar :TextView
    private lateinit var btn_calendar :MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        txt_calendar = findViewById(R.id.txt_calendar)
        btn_calendar = findViewById(R.id.btn_calendar)
        btn_calendar.setOnClickListener{
            val datePickerRange =MaterialDatePicker.Builder.dateRangePicker()
                .setTitleText("Select Date")
                .setSelection(
                    Pair(MaterialDatePicker.thisMonthInUtcMilliseconds(),
                    MaterialDatePicker.todayInUtcMilliseconds())
                )
                .build()
            datePickerRange.show(supportFragmentManager,"date_picker")
            datePickerRange.addOnPositiveButtonClickListener {
                val simleDateFormat =SimpleDateFormat("dd-MM-yyy", Locale.getDefault())
                txt_calendar.text = "${simleDateFormat.format(it.first)} s/d ${simleDateFormat.format(it.second)}"
            }
        }
}
}