package com.eulernetongt.bygfoot;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TableRow;
import android.widget.Toast;

public class LiveGameActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livegame);

        ProgressBar pg = (ProgressBar)findViewById(R.id.progressBarTime);
        pg.setEnabled(false);
        pg.setProgress(45);

        TabHost tabhost = (TabHost)findViewById(R.id.tabhostmatch);
        tabhost.setup();

        TabHost.TabSpec descriptor;

        descriptor = tabhost.newTabSpec("abaCommentary");
        descriptor.setContent(R.id.tabCommentary);
        descriptor.setIndicator(getString(R.string.lg_commentary));
        tabhost.addTab(descriptor);

        descriptor = tabhost.newTabSpec("abaStatistics");
        descriptor.setContent(R.id.tabStatistics);
        descriptor.setIndicator(getString(R.string.lg_statistics));
        tabhost.addTab(descriptor);

        descriptor = tabhost.newTabSpec("abaOpponent");
        descriptor.setContent(R.id.tabOpponent);
        descriptor.setIndicator(getString(R.string.lg_opponent));
        tabhost.addTab(descriptor);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBarBallPossession);
        seekBar.setProgress(50);
        seekBar.setEnabled(false);

        TableRow row1 = new TableRow(this);
		TableRow.LayoutParams lp1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
	    row1.setLayoutParams(lp1);
	}

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this, "Have a match in progress", Toast.LENGTH_LONG).show();
    }
}
