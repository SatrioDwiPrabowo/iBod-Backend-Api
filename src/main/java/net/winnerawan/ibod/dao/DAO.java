package net.winnerawan.ibod.dao;

import com.sun.tools.internal.ws.processor.model.Model;
import net.winnerawan.ibod.movie.Movie;
import net.winnerawan.ibod.util.BaseResponse;
import spark.Response;

import java.util.List;

/**
 * Created by winnerawan
 * on 2/3/17.
 */
public interface DAO {

    BaseResponse getAllMovie();

    BaseResponse getSemiMovie();

    BaseResponse getIGO();

    BaseResponse getHentai();


}
