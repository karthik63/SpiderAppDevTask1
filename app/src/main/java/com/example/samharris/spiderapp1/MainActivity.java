package com.example.samharris.spiderapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String studentName;

    EditText name;
    EditText rollNo;
    Spinner depts;
    Button submit;
    CheckBox appDev;
    CheckBox webDev;
    CheckBox algos;
    CheckBox tronix;

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.btSubmit);

        name  = (EditText)findViewById(R.id.etName);

        rollNo = (EditText)findViewById(R.id.etRollNo);

        depts=(Spinner)findViewById(R.id.spDepts);

        appDev=(CheckBox)findViewById(R.id.cbApp);

        webDev=(CheckBox)findViewById(R.id.cbWeb);

        algos=(CheckBox)findViewById(R.id.cbAlgos);

        tronix=(CheckBox)findViewById(R.id.cbTronix);

        ArrayAdapter arDept = ArrayAdapter.createFromResource(this,R.array.departments,R.layout.support_simple_spinner_dropdown_item);

        depts.setAdapter(arDept);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean k1,k2,k3;   k1=k2=k3=true;
                if(isEmpty(name))
                {
                    Toast noName = Toast.makeText(MainActivity.this,"Please enter your name to proceed",Toast.LENGTH_SHORT);
                    noName.setGravity(Gravity.BOTTOM,0,500);
                    noName.show();
                    k1=false;
                }
                if(isEmpty(rollNo))
                {
                    Toast noName = Toast.makeText(MainActivity.this,"Please enter your roll no to proceed",Toast.LENGTH_SHORT);
                    noName.setGravity(Gravity.BOTTOM,0,500);
                    noName.show();
                    k2=false;
                }
                if(!(algos.isChecked()||tronix.isChecked()||appDev.isChecked()||webDev.isActivated()))
                {
                    Toast noName = Toast.makeText(MainActivity.this,"Please enter profile(s) to proceed",Toast.LENGTH_SHORT);
                    noName.setGravity(Gravity.BOTTOM,0,500);
                    noName.show();
                    k3=false;
                }

                if(k1&&k2&&k3)
                {
                    studentName = name.getText().toString();

                    Intent i = new Intent(MainActivity.this,Submission.class);
                    i.putExtra("KEY",studentName);
                    startActivity(i);
                }
            }
        });
    }

}
