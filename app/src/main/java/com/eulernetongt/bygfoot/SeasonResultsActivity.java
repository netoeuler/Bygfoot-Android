package com.eulernetongt.bygfoot;

import android.app.Activity;
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
        for (String[] line : Calendar.seasonsResults){
            row = new TableRow(this);
            for (int i=0; i<line.length ; i++){
                tv = new TextView(this);
                tv.setText(line[i]);
                row.addView(tv);
            }
            table_seasonsresults.addView(row);
        }
    }
}
