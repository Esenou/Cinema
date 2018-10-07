package app.superesenou.ru.cinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import app.superesenou.ru.cinema.adapter.Adapter;
import app.superesenou.ru.cinema.adapter.AdapterKino;
import app.superesenou.ru.cinema.api.ApiService;
import app.superesenou.ru.cinema.api.RetroClient;
import app.superesenou.ru.cinema.models.Answer;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static app.superesenou.ru.cinema.adapter.Adapter.NameKino;
import static java.util.Calendar.LONG;

public class MainActivity extends AppCompatActivity {





    Adapter adapter;
    ListView listMain;
    private ArrayList<Answer.Unmain> list;
    ArrayList<Answer.Unmain>listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listMain=(ListView)findViewById(R.id.listMain);
        Cinema();

       listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              Intent intent=new Intent(MainActivity.this,Main2Activity.class);
              startActivity(intent);

          }
      });


    }

    public void Cinema(){
        ApiService api = RetroClient.getApiService();
        Call<Answer>call=api.GetDate();
        call.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                list=response.body().getResult().getUnmain();
                adapter=new Adapter(MainActivity.this,list);
                listMain.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {

            }
        });
    }


}
