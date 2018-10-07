package app.superesenou.ru.cinema;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import app.superesenou.ru.cinema.models.AnswerKinoafisha;

public class Main3Activity extends AppCompatActivity {

    ImageView imgThree;
    TextView name,countries,age_Limit,actors,rejisers,dateOutput,vote,vote_Count,txtUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imgThree=(ImageView)findViewById(R.id.imgThree);
         name=(TextView)findViewById(R.id.TxtNameKinoS);
         countries=(TextView)findViewById(R.id.TxtCountriesKinoS);
         age_Limit=(TextView)findViewById(R.id.TxtAgeLimitKinoS);
         actors=(TextView)findViewById(R.id.TxtActorsKinoS);
         rejisers=(TextView)findViewById(R.id.TxtDataOutputKinoS);
         dateOutput=(TextView)findViewById(R.id.TxtDataOutputKinoS);
         vote=(TextView)findViewById(R.id.TxtVoteKinoS);
         vote_Count=(TextView)findViewById(R.id.TxtCountVoteKinoS);
         txtUrl=(TextView)findViewById(R.id.TxtUrlKinoS);

        name.setBackgroundResource(R.color.trans);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String json =bundle.getString("esen");
            AnswerKinoafisha.Result vh = new Gson().fromJson(json,AnswerKinoafisha.Result.class);
          //  name.setText(vh.getName());
            countries.setText("Cтрана :"+vh.getCountries());
            age_Limit.setText("Возраст :"+vh.getAge_limit());
            actors.setText("Актёры :"+ Html.fromHtml(vh.getActors()));
            rejisers.setText("Режиссёры :"+vh.getRejisser());
            dateOutput.setText("Дата выхода :"+vh.getPremier_ua());
            vote.setText("Оценка :"+vh.getVote());
            vote_Count.setText("Проголосовали :"+vh.getCount_vote());
            txtUrl.setText("Ccылка :"+"https://kinoafisha.ua/"+vh.getUrl());

            char  b[]=new char[vh.getImage().length()];
           String c=vh.getImage();
            for(int i=0;i<c.length();i++){
                    if(i<27) {
                        b[i] = c.charAt(i);
                    }
                    else if(i>29){
                        b[i]=c.charAt(i);
                    }
                    else{
                        continue;
                    }
            }
            String str = String.valueOf(b);
            countries.setText("https://kinoafisha.ua"+str);
            Picasso.get().load("https://kinoafisha.ua"+str).into(imgThree);


        }

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
