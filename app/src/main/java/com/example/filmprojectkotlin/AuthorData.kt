package com.example.filmprojectkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AuthorData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_data)

        btnInits();
    }

    fun btnInits() {
        val changeDataBtn = findViewById<Button>(R.id.changeAuthorDataBtn);

        changeDataBtn.setOnClickListener(btnListeners);
    }

    val btnListeners: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.changeAuthorDataBtn -> {
                val i = Intent(this, ChangeAuthorData::class.java);
                startActivityForResult(i, 1);
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        var nameValue: String = "";
        var universityValue: String = "";
        var facultyValue: String = "";

        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                if(data!!.getStringExtra("name")!!.isNotEmpty()) {
                    nameValue = data.getStringExtra("name")!!;
                } else {
                    nameValue = "No name"
                }
                if(data.getStringExtra("university")!!.isNotEmpty()) {
                    universityValue = data.getStringExtra("university")!!;
                } else {
                    universityValue = "No university"
                }
                if(data.getStringExtra("faculty")!!.isNotEmpty()) {
                    facultyValue = data.getStringExtra("faculty")!!
                } else {
                    facultyValue = "No faculty"
                }
            }
        }

        val name = findViewById<TextView>(R.id.changeAuthorDataName);
        val university = findViewById<TextView>(R.id.changeAuthorDataUniversity);
        val faculty = findViewById<TextView>(R.id.changeAuthorDataFaculty);

        name.text = nameValue;
        university.text = universityValue;
        faculty.text = facultyValue;
    }
}