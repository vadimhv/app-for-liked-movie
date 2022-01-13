package com.example.filmprojectkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class ChangeAuthorData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_author_data);

        btnsInit();
    }

    fun btnsInit() {
        val saveAuthorDataBtn = findViewById<Button>(R.id.saveAuthorDataBtn);

        saveAuthorDataBtn.setOnClickListener(btnListeners);
    }

    val btnListeners: View.OnClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.saveAuthorDataBtn -> {
                returnData();
            }
        }
    }

    private fun returnData() {
        val intent = Intent();

        val nameInput = findViewById<TextInputLayout>(R.id.saveAuthorDataName);
        val universityInput = findViewById<TextInputLayout>(R.id.saveAuthorDataUniversity);
        val facultyInput = findViewById<TextInputLayout>(R.id.saveAuthorDataFaculty);

        if(nameInput.editText?.text.toString().isEmpty() || universityInput.editText?.text.toString()
                .isEmpty() || facultyInput.editText?.text.toString().isEmpty()
        ) {
            setResult(RESULT_CANCELED, intent)
        } else {
            intent.putExtra("name", nameInput.editText?.text.toString());
            intent.putExtra("university", universityInput.editText?.text.toString());
            intent.putExtra("faculty", facultyInput.editText?.text.toString());
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}