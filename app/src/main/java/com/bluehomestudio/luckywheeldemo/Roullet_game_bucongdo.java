package com.bluehomestudio.luckywheeldemo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import java.util.ArrayList;
import java.util.List;
public class Roullet_game_bucongdo extends AppCompatActivity {
    private LuckyWheel lw;
    List<WheelItem> wheelItems ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roullet_game_bucongdo);
        generateWheelItems();
        lw = findViewById(R.id.lwv);
        lw.addWheelItems(wheelItems);
        lw.setTarget(1);
        lw.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                Toast.makeText(Roullet_game_bucongdo.this, "Target Reached", Toast.LENGTH_LONG).show();
            }
        });
        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lw.rotateWheelTo(1);
            }
        });
    }

    private void generateWheelItems() {
        wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(getResources(),
                R.drawable.chat) , "중식"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.pizza) , "피자"));
        wheelItems.add(new WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(getResources(),
                R.drawable.hamber), "패스트푸드"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.vcd), "양식"));
        wheelItems.add(new WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(getResources(),
                R.drawable.korea), "한식"));
        wheelItems.add(new WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(getResources(),
                R.drawable.abcd), "족발"));
    }
}
