package com.example.homework11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.preference.PreferenceManager

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val textView2 = view?.findViewById<TextView>(R.id.textView2)
        val text2 = sharedPreferences?.getString("text2", "0")
        val textSize2 = sharedPreferences?.getString("fontSize2", "14")
        val fragmentColor2 = sharedPreferences?.getString("color2", "1")

        var colorFragment: Int? = 1
        when (fragmentColor2) {
            "1" -> {
                colorFragment = context?.let { ContextCompat.getColor(it, R.color.Red) }
            }
            "2" -> {
                colorFragment = context?.let { ContextCompat.getColor(it, R.color.Green) }
            }
            "3" -> {
                colorFragment = context?.let { ContextCompat.getColor(it, R.color.Blue) }
            }
        }

        textView2?.textSize = textSize2?.toFloat()!!
        textView2?.text = text2.toString()
        this.view?.background = colorFragment?.toDrawable()

    }
}
