package app.superesenou.ru.cinema.api;

import app.superesenou.ru.cinema.models.AnswerKinoAnons;
import app.superesenou.ru.cinema.models.Answer;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/ajax/kinoteatrs_load")
    Call<Answer>GetDate();

    @GET("/ajax/kinoafisha_load")
    Call<AnswerKinoafisha>GetDateKinoafisha();

    @GET("/ajax/skoro_load")
    Call<AnswerKinoAnons> GetDateKinoAnanos();
}
