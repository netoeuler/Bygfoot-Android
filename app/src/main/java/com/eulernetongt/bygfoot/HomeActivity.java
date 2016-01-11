package com.eulernetongt.bygfoot;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.eulernetongt.definitions.GeneralDefinitions;
import com.eulernetongt.definitions.MailList;
import com.eulernetongt.definitions.TeamPlayers;
import com.eulernetongt.entities.Player;

public class HomeActivity extends Activity{
	
	private TableLayout playerList;
	private LinearLayout header;
	private LinearLayout posheader;
	private LinearLayout posheader2;
	private LinearLayout footer;	
	
	private PopupWindow popupSelected;
	private HashMap<String, PopupWindow> hashPopup;
	
	private HashMap<String, Class<? extends Activity>> activitiesList;
	
	private TableRow playerSelected;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setTitle(GeneralDefinitions.getTeam());
		
		playerSelected = null;
		popupSelected = null;
		hashPopup = new HashMap<String, PopupWindow>();
		activitiesList = new HashMap<String, Class<? extends Activity>>();
		
		playerList = (TableLayout) findViewById(R.id.tablePlayerList);
		header = (LinearLayout) findViewById(R.id.header);
		posheader = (LinearLayout) findViewById(R.id.posheader);
		posheader2 = (LinearLayout) findViewById(R.id.posheader2);
		footer = (LinearLayout) findViewById(R.id.footer);
		
		generatePlayerList();
		generateHeader();
		generatePosHeader();
		generateFooter();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		footer.removeAllViews();
		generateFooter();
	}

	@Override
	public void onBackPressed() {
		return;
	}

	private void generatePlayerList(){
		int curNum=0;
		
		TableRow row1 = new TableRow(this);
		TableRow.LayoutParams lp1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
	    row1.setLayoutParams(lp1);
	    
	    //I removed "Status" after "Go"
		String[] texts = {" ", "Name", "Pos", "Sk ", "Fit ", "Go ", "Age ", "Etal"};
	    TextView linha0;
	    
	    for (String tx : texts){
	    	linha0 = new TextView(this);
	    	linha0.setText(tx);
		    row1.addView(linha0);
	    }	    
	    
	    playerList.addView(row1);
	    
	    ArrayList<Player> team = TeamPlayers.getTable().get(GeneralDefinitions.getTeam());
	    int i=-1;
		
	    for(Player player : team){
			TableRow row = new TableRow(this);
			TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
		    row.setLayoutParams(lp);
		    i++;
		    
		    //Blank line to separate starters and reserves
			if (i == 11){
		    	TextView linha = new TextView(this);
			    linha.setText(" ");
			    row.addView(linha);
			    playerList.addView(row);
			    continue;
		    }
		    
		    TextView linhaPlayer = new TextView(this);
		    linhaPlayer.setText(String.format("%d ", ++curNum));
		    row.addView(linhaPlayer);		    
		    linhaPlayer = new TextView(this);
		    linhaPlayer.setText(player.getName().concat(" "));		    
		    row.addView(linhaPlayer);
		    
		    linhaPlayer = new TextView(this);
		    if (player.getPosition() == Player.Position.GOALKEEPER){
		    	linhaPlayer.setText(" G ");
		    	linhaPlayer.setBackgroundColor(Color.BLACK);
		    	linhaPlayer.setTextColor(Color.WHITE);
		    }
		    else if (player.getPosition() == Player.Position.DEFENDER){
		    	linhaPlayer.setText(" D ");
		    	linhaPlayer.setBackgroundColor(Color.rgb(0, 200, 0));
		    	linhaPlayer.setTextColor(Color.WHITE);
		    }
		    else if (player.getPosition() == Player.Position.MIDFIELD){
		    	linhaPlayer.setText(" M ");
		    	linhaPlayer.setBackgroundColor(Color.BLUE);
		    	linhaPlayer.setTextColor(Color.WHITE);
		    }
		    else if (player.getPosition() == Player.Position.FOWARD){
		    	linhaPlayer.setText(" F ");
		    	linhaPlayer.setBackgroundColor(Color.rgb(200, 0, 0));
		    	linhaPlayer.setTextColor(Color.WHITE);
		    }		    
		    row.addView(linhaPlayer);		    
		    
		    //I removed "OK" after "0"
			texts = new String[] {String.format("%d ", player.getSkill()), String.format("%d ", player.getFitness()), "0",
					String.format("%d ", player.getAge())};
		    
		    for (String tx : texts){
		    	linhaPlayer = new TextView(this);
			    linhaPlayer.setText(tx);		    
			    row.addView(linhaPlayer);
		    }
		    
		   row.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int numSelected=-1;
					TableRow oldPlayerSelected = null;
					if (playerSelected != null){
						//TODO: Change to default background color
						playerSelected.setBackgroundColor(Color.WHITE);
						oldPlayerSelected = playerSelected;
						TextView tx = ((TextView)playerSelected.getChildAt(0));
						numSelected = Integer.parseInt(tx.getText().toString().trim());
					}						
					
					TableRow newPlayerSelected = (TableRow) v;
					TextView tx = ((TextView)newPlayerSelected.getChildAt(0));
					int newNum = Integer.parseInt(tx.getText().toString().trim());
					
					//TODO: reorganize team by positions (Ex: currently, playerList can be DDDMD...)
					if (numSelected > 0 && numSelected <= 11 && newNum >= 12){
						newNum++;
						TableRow aux = (TableRow) playerList.getChildAt(newNum);
						playerList.removeViewAt(newNum);
						playerList.removeViewAt(numSelected);
						
						((TextView)oldPlayerSelected.getChildAt(0)).setText(String.format("%d ", newNum - 1));
						((TextView)aux.getChildAt(0)).setText(String.format("%d ", numSelected));
						
						playerList.addView(oldPlayerSelected, newNum-1);
						playerList.addView(aux, numSelected);
						
						playerSelected = null;
					}
					else{
						playerSelected = newPlayerSelected;
						playerSelected.setBackgroundColor(Color.rgb(255, 102, 0));
					}
				}				
				
			});
		    
		    row.setOnLongClickListener(new View.OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {
					//onClickPlayerStats(v);
					TextView tv = (TextView)((TableRow) v).getChildAt(1);
					String playerName =  tv.getText().toString();
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
					alertDialogBuilder.setTitle(playerName);
					alertDialogBuilder.setMessage("Status: OK");
					alertDialogBuilder.setCancelable(false);

					final View dialogView = getLayoutInflater().inflate(R.layout.long_press_player, null);
					alertDialogBuilder.setView(dialogView);

					alertDialogBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
					
					AlertDialog alertDialog = alertDialogBuilder.create();
					alertDialog.show();
					return false;
				}
			});
		    
		    playerList.addView(row);
		}		
	}
	
	private void generateHeader(){
		String[] lista;
		Button bt;
		
		bt = new Button(this);
		bt.setText("Figures");
		lista = new String[] {"Fixtures (week)", "Fixtures (competitions)", "Tables", 
				"My league results", "Season results"};
		feedActiviesList(bt.getText().toString(), lista);
		popupByButton(bt, lista);
		header.addView(bt);
		
		bt = new Button(this);
		bt.setText("Team");
		lista = new String[] {"Training camp", "Browse teams"};
		popupByButton(bt, lista);
		header.addView(bt);
		
		/*bt = new Button(this);
		bt.setText("User");
		header.addView(bt);*/
		
		bt = new Button(this);
		bt.setText("FinStad");
		lista = new String[] {"Show finances", "Show stadium", "Betting"};
		popupByButton(bt, lista);
		header.addView(bt);
		
		bt = new Button(this);
		bt.setText("Stats");
		lista = new String[] {"News", "League stats", "Season history", "User history"};
		popupByButton(bt, lista);
		header.addView(bt);
		
		/*bt = new Button(this);
		bt.setText("Help");
		header.addView(bt);*/		
	}
	
	private void generatePosHeader(){
		TextView text;
		ImageButton ibt;
		
		String[] texts = new String[] {GeneralDefinitions.getName().concat(" "), "Season ", "Week ",
				"Round "};
		
		for (String tx : texts){
			text = new TextView(this);
			text.setText(tx);
			posheader.addView(text);
		}
		
		ibt = new ImageButton(this);
		ibt.setBackgroundResource(R.drawable.style_bal);
		ibt.setMinimumWidth(50);
		ibt.setMinimumHeight(50);
		ibt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//onClickStyle(v);
				final ImageButton ibt = (ImageButton) v;

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
				alertDialogBuilder.setTitle("Select style");

				String[] items = new String[]{"All defense", "Defense", "Normal", "Attack", "All attack"};

				alertDialogBuilder
						.setItems(items, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								if (arg1 == 0)
									ibt.setBackgroundResource(R.drawable.style_all_def);
								else if (arg1 == 1)
									ibt.setBackgroundResource(R.drawable.style_def);
								else if (arg1 == 2)
									ibt.setBackgroundResource(R.drawable.style_bal);
								else if (arg1 == 3)
									ibt.setBackgroundResource(R.drawable.style_atk);
								else
									ibt.setBackgroundResource(R.drawable.style_all_atk);
							}
						});

				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
		});
		posheader.addView(ibt);
		
		ibt = new ImageButton(this);
		ibt.setBackgroundResource(R.drawable.boost_off);
		ibt.setMinimumWidth(50);
		ibt.setMinimumHeight(50);
		ibt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//onClickBoost(v);
				final ImageButton ibt = (ImageButton) v;
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
				alertDialogBuilder.setTitle("Select boost");
				
				String[] items = new String[] {"Anti", "Off", "On"};
				
				alertDialogBuilder
					.setItems(items, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							if (arg1 == 0)
								ibt.setBackgroundResource(R.drawable.boost_anti);
							else if (arg1 == 1)
								ibt.setBackgroundResource(R.drawable.boost_off);
							else
								ibt.setBackgroundResource(R.drawable.boost_on);
						}
					});
				
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
		});
		posheader.addView(ibt);
		
		/*text = new TextView(this);
		text.setText("Av. Skills: ");
		posheader.addView(text);*/
		
		texts = new String[] {"Competition ", "Rank ", String.format("Money: %d ", GeneralDefinitions.getMoney())};
		
		for (String tx : texts){
			text = new TextView(this);
			text.setText(tx);
			posheader2.addView(text);
		}
		
	}
	
	private void generateFooter(){
		Button bt;
		EditText edt;

		bt = new Button(this);
		bt.setBackgroundResource(R.drawable.mail);
		bt.setText(String.format("%d", MailList.getUnreadMessages()));
		bt.setTextColor(Color.RED);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(HomeActivity.this, MailScreenActivity.class));
			}
		});

		footer.addView(bt);
		
		edt = new EditText(this);
		edt.setEnabled(false);
		edt.setSelected(false);
		edt.setWidth(250);
		//TODO: match parent
		footer.addView(edt);
		
		bt = new Button(this);
		bt.setBackgroundResource(R.drawable.new_week);
        bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(HomeActivity.this, LiveGameActivity.class));
			}
		});

		footer.addView(bt);
	}
	
	private void popupByButton(Button bt, String[] lista){
		LinearLayout popupLayout;
		PopupWindow popupMessage;
				
		popupLayout = new LinearLayout(this);
		popupLayout.setOrientation(LinearLayout.VERTICAL);
		
		for (int i=0 ; i<lista.length; i++){
			TextView text = new TextView(this);
			text.setText(lista[i]);
			//TODO: Think in a not ugly color 
			text.setBackgroundColor(Color.MAGENTA);
			clickListenerPopupItem(text);
			popupLayout.addView(text);
		}
		
		popupMessage = new PopupWindow(popupLayout, LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		popupMessage.setContentView(popupLayout);
		
		hashPopup.put(bt.getText().toString(), popupMessage);
		
		bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (popupSelected != null)
					popupSelected.dismiss();

				Button bt = (Button) v;

				if (popupSelected == hashPopup.get(bt.getText().toString()))
					return;

				popupSelected = hashPopup.get(bt.getText().toString());

				popupSelected.showAsDropDown(bt, 0, 0);
			}
		});
	}
	
	private void clickListenerPopupItem(TextView text){
		/*if (activitiesList == null){
			activitiesList = new HashMap<String, Class<? extends Activity>>();
		}
		
		if (text.getText().toString().equals("Tables"))
			activitiesList.put(text.getText().toString(), TablesActivity.class);
		else if (text.getText().toString().equals("Fixtures (week)"))
			activitiesList.put(text.getText().toString(), FixturesActivity.class);*/
		
		text.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				popupSelected.dismiss();

				TextView tx = (TextView) arg0;
				if (activitiesList.get(tx.getText().toString()) == null)
					return;

				Intent i = new Intent(HomeActivity.this, activitiesList.get(tx.getText().toString()));
				
				startActivity(i);
			}
		});
	}

	private void feedActiviesList(String txbutton, String[] lista){
		int i;
		Class actclass = null;

		if (txbutton.equals("Figures")){
			for (i=0 ; i<lista.length; i++){
				if (i==0) actclass = FixturesActivity.class;
				else if (i==2) actclass = TablesActivity.class;
                else if (i==4) actclass = SeasonResultsActivity.class;
				else continue;

				activitiesList.put(lista[i], actclass);
			}
		}
		else if (txbutton.equals("Team")){

		}
		else if (txbutton.equals("FinStad")){

		}
		else if (txbutton.equals("Stats")){

		}
	}

}
