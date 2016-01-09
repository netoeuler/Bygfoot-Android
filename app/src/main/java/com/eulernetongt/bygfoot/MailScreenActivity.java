package com.eulernetongt.bygfoot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eulernetongt.definitions.MailList;
import com.eulernetongt.definitions.MailMessage;

/**
 * Created by netoeuler on 1/8/16.
 */
public class MailScreenActivity extends Activity {

    private LinearLayout mailListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailscreen);
        mailListLayout = (LinearLayout) findViewById(R.id.mail_list);
        generateMailList();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mailListLayout.removeAllViews();
        generateMailList();
    }

    private void generateMailList(){
        TextView tv;
        for (MailMessage mm : MailList.getList()){
            tv = new TextView(this);
            tv.setHeight(70);
            tv.setText(mm.getTitle());

            if (mm.isReaded())
                tv.setBackgroundColor(Color.WHITE);
            else
                tv.setBackgroundColor(Color.GRAY);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = ((TextView) v).getText().toString();
                    MailMessage mm = MailList.getByTitle(title);
                    Intent i = new Intent(MailScreenActivity.this, MailMessageScreenActivity.class);
                    i.putExtra("title",mm.getTitle());
                    startActivity(i);
                }
            });

            mailListLayout.addView(tv);
        }
    }
}
