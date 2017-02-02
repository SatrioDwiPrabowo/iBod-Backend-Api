package net.winnerawan.ibod;

import net.winnerawan.ibod.dao.JdbcDAO;
import net.winnerawan.ibod.movie.MovieService;
import net.winnerawan.ibod.util.BaseResponse;
import net.winnerawan.ibod.util.Controller;
import net.winnerawan.ibod.util.JsonUtil;
import net.winnerawan.ibod.util.Msg;

import static net.winnerawan.ibod.util.JsonUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by winnerawan
 * on 2/3/17.
 */
public class Api {

    private Api() {

        new JdbcDAO();
        Controller controller = new Controller();

        port(4567);
        after(((request, response) -> response.type(JsonUtil.JSON())));
        get("/", (request, response) -> new BaseResponse(200, Msg.Congratulations()), json());
        get("/allMovies", (request, response) -> new JdbcDAO().getAllMovie(), json());
        get("/semiMovies", (request, response) -> new JdbcDAO().getSemiMovie(), json());
        get("/igoMovies", (request, response) -> new JdbcDAO().getIGO(), json());
        get("/hentaiMovies", (request, response) -> new JdbcDAO().getHentai(), json());
    }

    public static void main(String[] args) {
        new Api();
    }
}
