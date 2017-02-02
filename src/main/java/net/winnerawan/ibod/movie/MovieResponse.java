package net.winnerawan.ibod.movie;

import net.winnerawan.ibod.util.BaseResponse;

import java.util.List;

/**
 * Created by winnerawan
 * on 2/3/17.
 */
public class MovieResponse {

    private BaseResponse response;
    private Boolean error;
    private List<Movie> movies = null;


    public BaseResponse getResponse() {
        return response;
    }

    public void setResponse(BaseResponse response) {
        this.response = response;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


}
