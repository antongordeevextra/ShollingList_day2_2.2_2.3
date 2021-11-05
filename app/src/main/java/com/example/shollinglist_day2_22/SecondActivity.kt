package com.example.shollinglist_day2_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.forEach
import com.example.shollinglist_day2_22.databinding.ActivityMainBinding
import com.example.shollinglist_day2_22.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.root.forEach {
            if (it is Button) it.setOnClickListener(universalButtonListener)
        }
    }

    private val universalButtonListener = View.OnClickListener {
        when (it.id) {
            R.id.item1 -> sendBack("item1", binding.item1.text.toString())
            R.id.item2 -> sendBack("item2", binding.item2.text.toString())
            R.id.item3 -> sendBack("item3", binding.item3.text.toString())
            R.id.item4 -> sendBack("item4", binding.item4.text.toString())
            R.id.item5 -> sendBack("item5", binding.item5.text.toString())
            else -> Unit
        }
    }

    private fun sendBack(key: String, value: String) {
        val intent = Intent()
        intent.putExtra(key, value)
        setResult(RESULT_OK, intent)
        finish()
    }

}
