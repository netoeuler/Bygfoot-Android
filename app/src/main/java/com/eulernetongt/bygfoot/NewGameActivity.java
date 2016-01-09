package com.eulernetongt.bygfoot;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.eulernetongt.definitions.Calendar;
import com.eulernetongt.definitions.Countries;
import com.eulernetongt.definitions.GeneralDefinitions;
import com.eulernetongt.definitions.TeamPlayers;
import com.eulernetongt.definitions.Teams;

public class NewGameActivity extends Activity{
	
	private Spinner spinnerCountries;
	private Spinner spinnerTeams;
	private String selectedTeam;
	private String selectedCountry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newgame);
		
		spinnerCountries = (Spinner) findViewById(R.id.spinnerCountry);
		spinnerTeams= (Spinner) findViewById(R.id.spinnerTeam);
		
		ArrayList<String> listCountries = new ArrayList<String>();
		listCountries.add("");
		listCountries.addAll(Countries.getCountries());
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
        	(this, android.R.layout.simple_spinner_dropdown_item,listCountries);		         
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		         
		spinnerCountries.setAdapter(dataAdapter);
		
		spinnerCountries.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				selectedCountry = arg0.getItemAtPosition(arg2).toString();
				generateTeams(arg0.getItemAtPosition(arg2).toString());
				selectedTeam = "";
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});				
	}
	
	private void generateTeams(String country){
		ArrayList<String> teams;
		if (country.equals("")){
			teams = new ArrayList<String>();
			teams.add("");
		}
		else
			teams = Teams.getTeams(country);
		
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
		(this, android.R.layout.simple_spinner_dropdown_item,teams);		         
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		         
		spinnerTeams.setAdapter(dataAdapter2);
		
		spinnerTeams.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				selectedTeam = arg0.getItemAtPosition(arg2).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {				
			}
			
		});
	}
	
	public void clickStartGame(View v){
		String name = ((TextView) findViewById(R.id.textName)).getText().toString();
		String errorMessage = "";
		if (name.length() == 0)
			errorMessage += "Choose your name";
		if (selectedTeam.equals("")){
			if (errorMessage.length() > 0)
				errorMessage += " and ";
			errorMessage += "Choose your team";
		}
		
		if (errorMessage.length() > 0)
			Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
		else{
			Intent i = new Intent(this,PreloadNewGameActivity.class);
			//Intent i = new Intent(this,HomeActivity.class);
			//Intent i = new Intent(this,LiveGameActivity.class);
			
			/*
			Calendar.generateByCountry(selectedCountry);
			TeamPlayers.generateTeamPlayersByCountry(selectedCountry);
			GeneralDefinitions.generate(name, selectedTeam,	selectedCountry);
			*/
			i.putExtra("selectedCountry",selectedCountry);
			i.putExtra("name",name);
			i.putExtra("selectedTeam",selectedTeam);
			
			startActivity(i);
		}
	}

}
