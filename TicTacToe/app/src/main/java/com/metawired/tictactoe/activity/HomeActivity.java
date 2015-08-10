package com.metawired.tictactoe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.metawired.tictactoe.R;

/**
 * Activity used for choosing game type
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button playSimple = (Button) this.findViewById(R.id.button);
        playSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GameActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
        Button playAi = (Button) this.findViewById(R.id.button2);
        playAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AiGameActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
        Button playMultiplayer = (Button) this.findViewById(R.id.button3);
        playMultiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MultiplayerGameActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
    }

}
