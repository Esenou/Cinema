# Cinema 
project-cinema-base
A simple android application about movies

Use Api key from the URL="https://kinoafisha.ua"
    @GET("/ajax/kinoteatrs_load")
    Call<Answer>GetDate();

    @GET("/ajax/kinoafisha_load")
    Call<AnswerKinoafisha>GetDateKinoafisha();

    @GET("/ajax/skoro_load")
    Call<AnswerKinoAnons> GetDateKinoAnanos();
