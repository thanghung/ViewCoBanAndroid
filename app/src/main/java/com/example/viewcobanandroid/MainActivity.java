package com.example.viewcobanandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    CheckBox read, travel, code;
    RadioButton male, female;
    Spinner spinner;
    Switch _switch;
    Button _cancel, information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.tbemail);
        name = (EditText) findViewById(R.id.tbname);
        read = (CheckBox) findViewById(R.id.read);
        travel = (CheckBox) findViewById(R.id.travel);
        code = (CheckBox) findViewById(R.id.code);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        spinner = (Spinner) findViewById(R.id.spinner);
        _switch = (Switch) findViewById(R.id.switch1);
        _cancel = (Button) findViewById(R.id.cancel);
        information = (Button) findViewById(R.id.information);

        List<String> list = new ArrayList<>();
        list.add("Vietnamese");
        list.add("English");
        list.add("Korea");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);
    }

   public void Information_Click(View v){
       String msg = "My name: " + name.getText().toString() +
               System.getProperty("line.separator") +
               "Email: " + email.getText().toString();
       msg += System.getProperty("line.separator") + "My hobbies: ";
       if(code.isChecked())
           msg +=  code.getText().toString()+ ", ";
       if(read.isChecked())
           msg += read.getText().toString() + ", ";
       if(travel.isChecked())
           msg += travel.getText().toString()+ ", ";
       msg += System.getProperty("line.separator") + "My Sex: ";
       if(female.isChecked())
           msg += female.getText().toString();
       if(male.isChecked())
           msg += male.getText().toString();
       msg += System.getProperty("line.separator") + "My language: " + spinner.getSelectedItem().toString();
       msg += System.getProperty("line.separator") + "Do you have experience with Jave frameworks: ";
       if(_switch.isChecked())
           msg += "Yes";
       else
           msg += "No";
       info(v,msg);
       name.setText("");
       email.setText("");
       code.setChecked(false);
       read.setChecked(false);
       travel.setChecked(false);
       female.setChecked(false);
       male.setChecked(false);
   }

   public void  Cancel_Click(View v)
   {
      System.exit(0);
   }

    public void info(View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("My First App");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
