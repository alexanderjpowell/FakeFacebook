package com.social.alexanderpowell.fakefacebook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nameTextView, statusTextView;
    //EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setIcon(R.drawable.action_bar_full);
        }

        nameTextView = findViewById(R.id.nameTextView);
        statusTextView = findViewById(R.id.statusTextView);

        //nameEditText = viewfindViewById(R.id.nameEditText);

        nameTextView.setOnClickListener(this);
        statusTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        final Context context = builder.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View vieww = inflater.inflate(R.layout.dialog_name, null, false);

        if (view.getId() == R.id.nameTextView) {

            builder.setView(R.layout.dialog_name);
            builder.setTitle("Title");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                            EditText et = vieww.findViewById(R.id.nameEditText);
                            showToast(et.getText().toString());
                            nameTextView.setText(et.getText().toString());
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.show();
        } else if (view.getId() == R.id.statusTextView) {

        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
