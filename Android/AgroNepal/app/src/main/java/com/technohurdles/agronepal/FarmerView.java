package com.technohurdles.agronepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technohurdles.agronepal.model.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shakyas on 1/5/2018.
 */

public class FarmerView extends Activity{

    private TextView user1_name, user1_heading;
    private TextView user2_name, user2_heading;
    private TextView user3_name, user3_heading;
    private TextView user4_name, user4_heading;
    private TextView user5_name, user5_heading;

    private RelativeLayout user1, user2, user3, user4, user5;

    private Server server;

    private Profile profile1;
    private Profile profile2;
    private Profile profile3;
    private Profile profile4;
    private Profile profile5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.farmer);

        server = new Server();

        user1 = (RelativeLayout) findViewById(R.id.user1);
        user1_name = (TextView) findViewById(R.id.user1_name);
        user1_heading = (TextView) findViewById(R.id.user1_heading);

        user2 = (RelativeLayout) findViewById(R.id.user2);
        user2_name = (TextView) findViewById(R.id.user2_name);
        user2_heading = (TextView) findViewById(R.id.user2_heading);

        user3 = (RelativeLayout) findViewById(R.id.user3);
        user3_name = (TextView) findViewById(R.id.user3_name);
        user3_heading = (TextView) findViewById(R.id.user3_heading);

        user4 = (RelativeLayout) findViewById(R.id.user4);
        user4_name = (TextView) findViewById(R.id.user4_name);
        user4_heading = (TextView) findViewById(R.id.user4_heading);

        user5 = (RelativeLayout) findViewById(R.id.user5);
        user5_name = (TextView) findViewById(R.id.user5_name);
        user5_heading = (TextView) findViewById(R.id.user5_heading);


        List<Profile> profileList = server.getProfiles();
        profile1 = profileList.get(0);
        profile2 = profileList.get(1);
        profile3 = profileList.get(2);
        profile4 = profileList.get(3);
        profile5 = profileList.get(4);

        user1_name.setText(profile1.getProfName());
        user1_heading.setText(profile1.getTopic());
        user2_name.setText(profile2.getProfName());
        user2_heading.setText(profile2.getTopic());
        user3_name.setText(profile3.getProfName());
        user3_heading.setText(profile3.getTopic());
        user4_name.setText(profile4.getProfName());
        user4_heading.setText(profile4.getTopic());
        user5_name.setText(profile5.getProfName());
        user5_heading.setText(profile5.getTopic());


        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerView.this, ProfileView.class);
                intent.putExtra("id", profile1.getProfId());
                startActivity(intent);
            }
        });

        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerView.this, ProfileView.class);
                intent.putExtra("id", profile2.getProfId());
                startActivity(intent);
            }
        });

        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerView.this, ProfileView.class);
                intent.putExtra("id", profile3.getProfId());
                startActivity(intent);
            }
        });

        user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerView.this, ProfileView.class);
                intent.putExtra("id", profile4.getProfId());
                startActivity(intent);
            }
        });

        user5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerView.this, ProfileView.class);
                intent.putExtra("id", profile5.getProfId());
                startActivity(intent);
            }
        });
    }
}
