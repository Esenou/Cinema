package app.superesenou.ru.cinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import app.superesenou.ru.cinema.adapter.Helper;
import app.superesenou.ru.cinema.models.AnswerKinoAnons;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;

public class Main4Activity extends AppCompatActivity {

    ImageView imageView;
    TextView txtName,txtUrl,txtCountries,txtActors,txtRejisser,txtBefore,txtEntered,txtAge_limit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView=(ImageView)findViewById(R.id.imgAnonsF);
        txtName=(TextView)findViewById(R.id.txtNameAnonsF);
        txtUrl=(TextView)findViewById(R.id.txtUrlAnonsF);
        txtCountries=(TextView)findViewById(R.id.txtCountriesAnonsF);
        txtActors=(TextView)findViewById(R.id.txtActorsAnonsF);
        txtRejisser=(TextView)findViewById(R.id.txtRejissorAnonsF);
        txtBefore=(TextView)findViewById(R.id.txtBeforeAnonsF);
        txtEntered=(TextView)findViewById(R.id.txtEnteredF);
        txtAge_limit=(TextView)findViewById(R.id.txtAgeLimitAnonsF);

        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String json =bundle.getString("esen");
            AnswerKinoAnons.Result vh = new Gson().fromJson(json,AnswerKinoAnons.Result.class);

            txtName.setText(vh.getName());
            txtCountries.setText("Cтрана :"+vh.getCountries());
            txtAge_limit.setText("Возраст :"+vh.getAge_limit());
            txtActors.setText("Актёры :"+ Html.fromHtml(vh.getActors()));
            txtRejisser.setText("Режиссёры :"+Html.fromHtml(vh.getRejisser()));
            txtBefore.setText("Дата выхода :"+Html.fromHtml(vh.getBefore()));
            txtEntered.setText(vh.getEntered());
            txtUrl.setText("Ccылка :"+"https://kinoafisha.ua/"+vh.getUrl());

            Helper url=new Helper();
            Picasso.get().load("https://kinoafisha.ua/"+url.makeImageBetter(vh.getImage())).into(imageView);


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
