package com.sgut.android.nationalfootballleague.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.sgut.android.nationalfootballleague.R

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, context.getText(R.string.cancel), Toast.LENGTH_SHORT).show()
    }
}