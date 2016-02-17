package com.eulernetongt.bygfoot;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.eulernetongt.definitions.Calendar;
import com.eulernetongt.definitions.Table;
import com.eulernetongt.entities.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by netoeuler on 1/10/16.
 */
public class SeasonResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonresults);

        TableLayout table_seasonsresults = (TableLayout)findViewById(R.id.table_seasonresults);
        table_seasonsresults.setOrientation(TableLayout.VERTICAL);

        TableRow row;
        TextView tv;
        for (Integer week : Calendar.seasonsResults.keySet()){
            String[] line = Calendar.seasonsResults.get(week);
            row = new TableRow(this);

            tv = new TextView(this);
            tv.setText(String.format("%d",week));
            row.addView(tv);

            for (int i=0; i<line.length-1 ; i++){
                tv = new TextView(this);
                tv.setText(line[i]);
                if (i==2 && (line[line.length-1]).charAt(0) == Match.AWAY_TEAM)
                    tv.setBackgroundColor(Color.GRAY);
                row.addView(tv);
            }
            table_seasonsresults.addView(row);
        }

    }
}
