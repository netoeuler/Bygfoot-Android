package com.eulernetongt.bygfoot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.eulernetongt.definitions.Calendar;
import com.eulernetongt.definitions.GeneralDefinitions;
import com.eulernetongt.entities.Match;
import com.eulernetongt.definitions.Table;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FixturesActivity extends Activity{
	
	private LinearLayout fixturesTable;
	private LinearLayout fixturesHeader;	
	
	private int currentWeek=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fixtures);
		
		fixturesTable = (LinearLayout) findViewById(R.id.fixturesList);
		fixturesHeader= (LinearLayout) findViewById(R.id.fixturesHeader);
		
		Button bt; 
		bt = new Button(this);
		bt.setText("<");
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (currentWeek > 1){
					currentWeek--;
					generateFixturesTable();
				}
			}
		});
		fixturesHeader.addView(bt);
		
		bt = new Button(this);
		bt.setText(">");
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (currentWeek < 38){
					currentWeek++;
					generateFixturesTable();
				}					
			}
		});
		fixturesHeader.addView(bt);
		
		//TODO: Delete this later
		/*calendar = new Calendar();
		calendar.generateByCountry(generalDefinitions.getCountry());*/	
		
		generateFixturesTable();
	}
	
	private void generateFixturesTable(){
		fixturesTable.removeAllViews();
		
		for (Table tb : Calendar.tableList){
			HashMap<Integer, List<Match>> matches = tb.getMatchesByWeek();
			
			List<Match> listMatch = matches.get(currentWeek);
			
			Collections.shuffle(listMatch);
			
			for (Match m : listMatch){
				TextView textview = new TextView(this);
				textview.setText(m.toString());
				if (m.getHome().equals(GeneralDefinitions.getTeam()) || m.getAway().equals(GeneralDefinitions.getTeam()))
						textview.setBackgroundColor(Color.rgb(0, 0, 250));
				fixturesTable.addView(textview);
			}
			
		}
	}

}
