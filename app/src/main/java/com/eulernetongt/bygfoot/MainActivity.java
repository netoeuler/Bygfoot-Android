package com.eulernetongt.bygfoot;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    
    public void onClickMenu(View v){
    	Intent intent = null;
    	
    	switch (v.getId()){
    		case R.id.buttonNewGame:
    			intent = new Intent(this,NewGameActivity.class); 
    			break;
    		case R.id.buttonLoadGame:
    			//intent = new Intent(this,LoadGameActivity.class); 
    			break;
    		case R.id.buttonContribuitors:
    			//intent = new Intent(this,ContribuitorsActivity.class); 
    			break;
    		case R.id.buttonQuit:
    			//intent = new Intent(this,QuitActivity.class); 
    			break;
    	}
    	
    	if (intent != null)
    		startActivity(intent);
    }
    
}
