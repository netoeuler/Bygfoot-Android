package com.eulernetongt.bygfoot;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.eulernetongt.definitions.MailList;
import com.eulernetongt.definitions.MailMessage;

/**
 * Created by netoeuler on 1/9/16.
 */
public class MailMessageScreenActivity extends Activity {

    private MailMessage mailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailmessagescreen);

        String title = getIntent().getStringExtra("title");

        for (MailMessage mm : MailList.getList()){
            if (mm.getTitle().equals(title)){
                if (!mm.isReaded()){
                    mm.setReaded(true);
                    MailList.subtractUnreadMessages();
                }
                mailMessage = mm;
                break;
            }
        }

        TextView tv_msgtitle = (TextView)findViewById(R.id.msg_title);
        tv_msgtitle.setText(mailMessage.getTitle());
        TextView tv_msgtext = (TextView)findViewById(R.id.msg_text);
        tv_msgtext.setText(mailMessage.getMessage());

    }
}
