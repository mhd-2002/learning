package com.example.learning_bugeto

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.learning_bugeto.databinding.ActivitySharedBinding

class SharedActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedBinding
    lateinit var shares: SharedPreferences
    val nameKey = "nameKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shares = getSharedPreferences("Preferences", MODE_PRIVATE)
        save()
        show()

    }
private fun show (){

    binding.btShow.setOnClickListener {

        showMessage(shares.getString(nameKey, null).toString())

    }
}
    private fun save() {

        binding.btSave.setOnClickListener {
            val name = binding.etName.text.toString()

            val editor: SharedPreferences.Editor = shares.edit()
            editor.putString(nameKey, name)
            editor.apply()
            showMessage("successfully added", Toast.LENGTH_SHORT)

        }
    }

    private fun showMessage(message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

}
