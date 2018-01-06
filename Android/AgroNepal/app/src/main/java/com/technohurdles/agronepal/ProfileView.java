package com.technohurdles.agronepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.technohurdles.agronepal.model.Profile;

/**
 * Created by shakyas on 1/5/2018.
 */

public class ProfileView extends Activity {

    private TextView profile_name, profile_address, profile_heading, profile_descrption;

    private Server server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile);

        server = new Server();

        profile_name = (TextView) findViewById(R.id.profile_name);
        profile_address = (TextView) findViewById(R.id.profile_address);
        profile_heading = (TextView) findViewById(R.id.profile_heading);
        profile_descrption = (TextView) findViewById(R.id.profile_descrption);

        Intent intent = getIntent();
        long prof_id = intent.getLongExtra("id",0);
        Profile profile = server.getProfileById(prof_id);

        profile_name.setText(profile.getProfName());
        profile_address.setText(profile.getProfAddress());
        profile_heading.setText(profile.getTopic());
        profile_descrption.setText(profile.getProfDescription());

    }
}
