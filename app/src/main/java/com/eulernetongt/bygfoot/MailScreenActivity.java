package com.eulernetongt.bygfoot;

import android.app.Activity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailscreen);

        LinearLayout mailListLayout = (LinearLayout) findViewById(R.id.mail_list);

        TextView tv;
        for (int i=9 ; i>=0; i--){
            if (MailList.getList()[i] == null)
                continue;

            tv = new TextView(this);
            tv.setText(MailList.getList()[i].getMessage());

            if (MailList.getList()[i].isReaded())
                tv.setBackgroundColor(Color.WHITE);
            else
                tv.setBackgroundColor(Color.GRAY);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //MailList.getList()[index].setReaded(true);
                }
            });

            mailListLayout.addView(tv);
        }

    }

}
