package com.algorithm.sieveoferatosthenes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.algorithm.sieveoferatosthenes.R;

public class ContactActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView nameTV = (TextView)findViewById(R.id.name);
        TextView phoneTV = (TextView)findViewById(R.id.phone);
        TextView emailTV = (TextView)findViewById(R.id.email);
        TextView linkedInTV = (TextView)findViewById(R.id.linkedin);
        TextView githubTV = (TextView)findViewById(R.id.github);
        TextView creditTV = (TextView)findViewById(R.id.credit);
        TextView googleTV = (TextView)findViewById(R.id.google);
        TextView androidTV = (TextView)findViewById(R.id.android);
        TextView codeprojectTV = (TextView)findViewById(R.id.codeproject);
        TextView wikiTV = (TextView)findViewById(R.id.wiki);
        TextView stackOTV = (TextView)findViewById(R.id.stackoverflow);

        nameTV.setText("Sofia Hamrin");
        phoneTV.setText("(207) 749-4911");
        emailTV.setText("Sofia.Hamrin@gmail.com");

        linkedInTV.setClickable(true);
        linkedInTV.setMovementMethod(LinkMovementMethod.getInstance());
        String lText = "<a href='http://www.linkedin.com/in/sofiahamrin'> LinkedIn </a>";
        linkedInTV.setText(Html.fromHtml(lText));

        githubTV.setClickable(true);
        githubTV.setMovementMethod(LinkMovementMethod.getInstance());
        String ghText = "<a href='http://github.com/KSofia'> Github </a>";
        githubTV.setText(Html.fromHtml(ghText));

        creditTV.setText("This app was made with help by: ");

        googleTV.setClickable(true);
        googleTV.setMovementMethod(LinkMovementMethod.getInstance());
        String gText = "<a href='http://www.google.com'> Google </a>";
        googleTV.setText(Html.fromHtml(gText));

        androidTV.setClickable(true);
        androidTV.setMovementMethod(LinkMovementMethod.getInstance());
        String aText = "<a href='https://developer.android.com/develop/index.html'> Android </a>";
        androidTV.setText(Html.fromHtml(aText));

        codeprojectTV.setClickable(true);
        codeprojectTV.setMovementMethod(LinkMovementMethod.getInstance());
        String cText = "<a href='http://www.codeproject.com'> Code Project </a>";
        codeprojectTV.setText(Html.fromHtml(cText));

        wikiTV.setClickable(true);
        wikiTV.setMovementMethod(LinkMovementMethod.getInstance());
        String wText = "<a href='http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes'> Wikipedia </a>";
        wikiTV.setText(Html.fromHtml(wText));

        stackOTV.setClickable(true);
        stackOTV.setMovementMethod(LinkMovementMethod.getInstance());
        String soText = "<a href='http://stackoverflow.com/'> Stack Overflow </a>";
        stackOTV.setText(Html.fromHtml(soText));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
