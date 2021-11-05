package com.example.shollinglist_day2_22

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.core.view.isVisible
import com.example.shollinglist_day2_22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.fab.setOnClickListener {
            startActivityForResult(Intent(this, SecondActivity::class.java), REQUEST_CODE)
        }

        binding.buttonMap.setOnClickListener {
            val shop = binding.editText.toString()
            val locShop = Uri.parse("geo:0,0?q=$shop")
            val intent = Intent(Intent.ACTION_VIEW, locShop)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            data?.let {
                val name1 = data.getStringExtra("item1")
                val name2 = data.getStringExtra("item2")
                val name3 = data.getStringExtra("item3")
                val name4 = data.getStringExtra("item4")
                val name5 = data.getStringExtra("item5")

                val list = listOf(name1, name2, name3, name4, name5)

                list.forEach {
                    if (it != null) {
                        when(list.indexOf(it)) {
                            0 -> {
                                binding.id1.text = it
                                binding.id1.isVisible = true
                            }
                            1 -> {
                                binding.id2.text = it
                                binding.id2.isVisible = true
                            }
                            2 -> {
                                binding.id3.text = it
                                binding.id3.isVisible = true
                            }
                            3 -> {
                                binding.id4.text = it
                                binding.id4.isVisible = true
                            }
                            4 -> {
                                binding.id5.text = it
                                binding.id5.isVisible = true
                            }
                            else -> Unit
                        }
                    }
                }
            }
        }
    }
}