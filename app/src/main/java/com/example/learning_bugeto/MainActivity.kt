package com.example.learning_bugeto

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.learning_bugeto.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var nameOfSearchView =
        arrayOf("ali", "mahdi", "akbar", "mohammad", "amir", "amirAli", "amirAbas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        toastSnackBar()
        onClick(binding.root)
        editText(this)
        nextActivity()
        alertDialog()
        customDialog()

    }

    private fun toastSnackBar() {
        binding.toast.setOnLongClickListener {
            Toast.makeText(this, "on long click of Toast", Toast.LENGTH_LONG).show()
            true
        }

        binding.toast.setOnClickListener {

            Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show()
        }

        binding.snackBar.setOnLongClickListener {
            Toast.makeText(this, "on long click of snackBar", Toast.LENGTH_LONG).show()
            true
        }

        binding.snackBar.setOnClickListener {

            Snackbar.make(binding.ly, "Hello World SnackBar", Snackbar.LENGTH_LONG)
                .setAction("click") {
                    Toast.makeText(this, "click clicked", Toast.LENGTH_SHORT).show()
                }.setActionTextColor(resources.getColor(R.color.blue))
                .setDuration(4000)
                .setBackgroundTint(resources.getColor(R.color.teal_200))
                .show()
        }
    }

    private fun setData() {

        val adapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, nameOfSearchView)
        binding.etSearch.threshold = 2
        binding.etSearch.setAdapter(adapter)

    }

    fun onClick(view: View) {

        if (view is RadioButton) {

            val checked = view.isChecked

            when (view.getId()) {
                R.id.rb_one ->
                    if (checked) {
                        Toast.makeText(this, "radioButton one clicked", Toast.LENGTH_SHORT).show()
                    }
                R.id.rb_two ->
                    if (checked) {
                        Toast.makeText(this, "radioButton two clicked", Toast.LENGTH_SHORT).show()
                    }
                R.id.rb_three -> {
                    if (checked) {
                        Toast.makeText(this, "radioButton three clicked", Toast.LENGTH_SHORT).show()
                    }

                }
                R.id.rb_four -> {
                    if (checked) {
                        Toast.makeText(this, "radioButton four clicked", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.rb_select -> {
                    if (checked) {
                        Toast.makeText(this, "radioButton check clicked", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox -> {
                    if (checked) {
                        Toast.makeText(this, "CheckBox is on", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "CheckBox is off", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        if (view is ToggleButton) {
            val checked: Boolean = view.isChecked

            if (checked) {
                Toast.makeText(this, "ToggleButton is on", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ToggleButton is off", Toast.LENGTH_SHORT).show()
            }
        }
        if(view is FloatingActionButton){
            Toast.makeText(this,"FloatingActionButton clicked",Toast.LENGTH_SHORT).show()
        }
    }

    private fun editText(context: Context) {

        binding.etName.addTextChangedListener(object : TextWatcher {
            @SuppressLint("SetTextI18n")
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(context, "before texting", Toast.LENGTH_LONG).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isNotEmpty()) {
                    binding.tw.text = p0.toString()
                }
            }

            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(p0: Editable?) {
                Toast.makeText(context, "finished", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun nextActivity() {

        binding.btNextActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("ok", "hello world")
            startActivity(intent)
        }

        binding.btWeb.setOnClickListener {
            val intent = Intent(this,WebView::class.java)
            startActivity(intent)
        }

    }

    private fun alertDialog() {

        binding.btDialog.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("update dialog")
                .setMessage("Are you sure ?")
                .setCancelable(false)
                .setPositiveButton("yes") { _, _ ->
                    Toast.makeText(
                        this,
                        "updating in progress",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .setNegativeButton("No") { dialog, _ ->
                    Toast.makeText(this, "updating canceled", Toast.LENGTH_LONG).show()
                    dialog.cancel()
                }.show()
        }
    }

    private fun customDialog() {
        binding.btCustomDialog.setOnClickListener {

            val dialog = Dialog(this)
            dialog.setTitle("")
            dialog.setContentView(R.layout.custom_dialog)

            val tv_dialog: TextView = dialog.findViewById(R.id.tv_dialog)
            val btCancel: Button = dialog.findViewById(R.id.bt_dialog)

           btCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.show()
        }
    }

}
