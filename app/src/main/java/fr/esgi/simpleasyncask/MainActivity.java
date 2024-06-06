package fr.esgi.simpleasyncask;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private TaskViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
        mViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        mViewModel.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTextView.setText(s);
            }
        });
    }

    public void startTask(View view) {
        mTextView.setText("Travail en cours...");
        mViewModel.startTask();
    }
}
