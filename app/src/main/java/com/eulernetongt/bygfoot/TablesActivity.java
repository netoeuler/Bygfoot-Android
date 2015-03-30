package com.eulernetongt.bygfoot;

import java.util.Collection;
import java.util.Collections;

import com.eulernetongt.definitions.Calendar;
import com.eulernetongt.definitions.GeneralDefinitions;
import com.eulernetongt.entities.TeamTable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TablesActivity extends Activity{
	
	private TableLayout tableLayout;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tables);
		
		tableLayout = (TableLayout) findViewById(R.id.tableComp);
		
		TableRow row1 = new TableRow(this);
		TableRow.LayoutParams lp1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
	    row1.setLayoutParams(lp1);
	    
	    TextView linha0;
	    String[] linhaText = new String[] {" ", " ", "Team", " PL ", " W ", " DW ", " L ", " GF ", 
	    		" GA ", " GD ", " PTS "};
	    
	    for (int i=0 ; i<linhaText.length; i++){
	    	linha0 = new TextView(this);
		    linha0.setText(linhaText[i]);
		    row1.addView(linha0);
	    }
	    
	    tableLayout.addView(row1);
	    
	    Collections.sort(Calendar.tableClassification);
	    
	    int pos=0;
	    
	    for (TeamTable tt : Calendar.tableClassification){
	    	row1 = new TableRow(this);
	    	pos++;
	    	
	    	linhaText = new String[] {" ", " ", tt.getTeamName(), " "+tt.getPL()+" ", 
	    			" "+tt.getW()+" ", " "+tt.getDW()+" ", " "+tt.getL()+" ", 
	    			" "+tt.getGF()+" ", " "+tt.getGA()+" ", " "+tt.getGD()+" ",
	    			" "+tt.getPTS()+" "};
	    	
	    	for (int i=0 ; i<linhaText.length; i++){
		    	linha0 = new TextView(this);
			    linha0.setText(linhaText[i]);
			    row1.addView(linha0);
		    }
	    	
	    	if (GeneralDefinitions.getTeam().equals(tt.getTeamName()))
	    		row1.setBackgroundColor(Color.rgb(0, 0, 150));
	    	else if (pos == 1)
	    		row1.setBackgroundColor(Color.rgb(200, 20, 20));
	    	else if (pos >= 2 && pos <= 4)
	    		row1.setBackgroundColor(Color.rgb(0, 50, 200));
	    	else if (pos >= 17 && pos <= 20)
	    		row1.setBackgroundColor(Color.rgb(100, 255, 100));	    	
		    
		    tableLayout.addView(row1);
	    }
	}

}
