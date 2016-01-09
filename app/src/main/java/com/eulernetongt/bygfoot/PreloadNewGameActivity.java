package com.eulernetongt.bygfoot;

import java.util.ArrayList;

import com.eulernetongt.definitions.Calendar;
import com.eulernetongt.definitions.GeneralDefinitions;
import com.eulernetongt.definitions.MailList;
import com.eulernetongt.definitions.TeamPlayers;
import com.eulernetongt.definitions.Teams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PreloadNewGameActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preloadnewgame);
		
		Intent prevIntent = getIntent();
		LinearLayout layout = (LinearLayout) findViewById(R.id.preloadLayout);
		TextView textview;

		textview = new TextView(this);
		textview.setText("Generating calendar...");
		layout.addView(textview);
		Calendar.generateByCountry(prevIntent.getStringExtra("selectedTeam"));

		textview = new TextView(this);
		textview.setText("Generating players...");
		layout.addView(textview);
		TeamPlayers.generateTeamPlayersByCountry(prevIntent.getStringExtra("selectedCountry"));

		textview = new TextView(this);
		textview.setText("Setting general definitions...");
		layout.addView(textview);
		GeneralDefinitions.generate(prevIntent.getStringExtra("name"), prevIntent.getStringExtra("selectedTeam"),
				prevIntent.getStringExtra("selectedCountry"));

		textview = new TextView(this);
		textview.setText("Setting mail list...");
		MailList.generate();
		MailList.addMessage(String.format("Welcome to %s", prevIntent.getStringExtra("selectedTeam")));
		layout.addView(textview);
		
		/*ArrayList<String> teams = Teams.getTeams(GeneralDefinitions.getCountry());
		textview.setText("Generating teams");
		for (String team : teams){
			//textview.setText("Generating "+team);
			//TeamPlayers.generateTeamPlayersByTeam(team,	GeneralDefinitions.getCountry());
		}*/

		startActivity(new Intent(this,HomeActivity.class));
		
	}

}
