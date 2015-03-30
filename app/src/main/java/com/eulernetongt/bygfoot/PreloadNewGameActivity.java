package com.eulernetongt.bygfoot;

import java.util.ArrayList;

import com.eulernetongt.definitions.GeneralDefinitions;
import com.eulernetongt.definitions.TeamPlayers;
import com.eulernetongt.definitions.Teams;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PreloadNewGameActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preloadnewgame);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.preloadLayout);
		TextView textview = new TextView(this);
		layout.addView(textview);
		
		ArrayList<String> teams = Teams.getTeams(GeneralDefinitions.getCountry());
		
		for (String team : teams){
			textview.setText("Generating "+team);
			//TeamPlayers.generateTeamPlayersByTeam(team,	generalDefinitions.getCountry());
		}
		
	}

}
