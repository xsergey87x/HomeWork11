package com.example.homework11

import android.content.Context
import android.graphics.Color.green
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.preference.PreferenceManager
import com.google.android.material.textfield.TextInputLayout


class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val textView = view?.findViewById<TextView>(R.id.textView1)
        val text1 = sharedPreferences?.getString("text1", "0")
        val textSize1 = sharedPreferences?.getString("fontSize1", "14")
        val fragmentColor1 = sharedPreferences?.getString("color1", "1")

        var colorFragment: Int? = 1
        when (fragmentColor1) {
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

        textView?.textSize = textSize1?.toFloat()!!
        textView?.text = text1.toString()
        this.view?.background = colorFragment?.toDrawable()

    }

    }
