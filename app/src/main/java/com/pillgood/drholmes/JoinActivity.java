package com.pillgood.drholmes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button join, del;
        View.OnClickListener cl;

        join = (Button) findViewById(R.id.btn_join);
        del = (Button) findViewById(R.id.delete);

    }
}
