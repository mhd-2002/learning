package com.example.learning_bugeto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.learning_bugeto.databinding.ActivityMain2Binding

const val RequestCode1 = 1

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding


    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        name = intent.getStringExtra("ok").toString()
        binding.tvTop.text = name

        listener()


    }

    fun listener() {

        binding.btContact.setOnClickListener {
            val contact = Intent(Intent.ACTION_PICK)
            contact.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivityForResult(contact, RequestCode1)
        }

        binding.btWeb.setOnClickListener {
            val web = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(web)
        }

        binding.btMap.setOnClickListener {
            val map = Intent(Intent.ACTION_VIEW, Uri.parse("geo:35:74433781,51.35067178"))
            startActivity(map)
        }

        binding.btMakeCall.setOnClickListener {
            val call = Intent(Intent.ACTION_DIAL, Uri.parse("tel:09137707200"))
            startActivity(call)
        }

        binding.btProgressBar.setOnClickListener {
            binding.progressbar.visibility = View.VISIBLE
            binding.progressHorizontal.visibility = View.VISIBLE
            binding.progressCircular.visibility = View.VISIBLE

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==RequestCode1){
                if (resultCode== RESULT_OK){
                    Toast.makeText(this, "با موفقیت انجام شد.($data",Toast.LENGTH_SHORT).show()
                }
        }
    }
}