package net.winnerawan.ibod.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import net.winnerawan.ibod.movie.Movie;
import net.winnerawan.ibod.util.BaseResponse;
import net.winnerawan.ibod.util.Msg;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import spark.Response;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by winnerawan
 * on 2/3/17.
 */
public class JdbcDAO implements DAO {

    private static MysqlDataSource dataSource;
    private BaseResponse response = new BaseResponse();
    QueryRunner run = new QueryRunner(dataSource);

    static {
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("toor");
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("ibod");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public BaseResponse getAllMovie() {
        try {
            ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
            List<Movie> movies = run.query("SELECT * FROM movies", h);
            if (movies.size() >= 1) {
                response.setStatus(200);
                response.setMessage(Msg.OK());
                response.setResult(movies);
                return response;
            } else {
                response.setStatus(404);
                response.setMessage(Msg.NotFound());
                response.setResult(null);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Problem guys", sqle);
        }
        return null;
    }

    @Override
    public BaseResponse getSemiMovie() {
        try {
            ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
            List<Movie> semi = run.query("SELECT * FROM movies WHERE movies.category = 4", h);
            if (semi.size() >= 1) {
                response.setStatus(200);
                response.setMessage(Msg.OK());
                response.setResult(semi);
                return response;
            } else {
                response.setStatus(404);
                response.setMessage(Msg.NotFound());
                response.setResult(null);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Problem guys", sqle);
        }
        return null;
    }


    @Override
    public BaseResponse getIGO() {
        try {
            ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
            List<Movie> semi = run.query("SELECT * FROM movies WHERE movies.category = 1", h);
            if (semi.size() >= 1) {
                response.setStatus(200);
                response.setMessage(Msg.OK());
                response.setResult(semi);
                return response;
            } else {
                response.setStatus(404);
                response.setMessage(Msg.NotFound());
                response.setResult(null);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Problem guys", sqle);
        }
        return null;
    }

    @Override
    public BaseResponse getHentai() {
        try {
            ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
            List<Movie> semi = run.query("SELECT * FROM movies WHERE movies.category = 5", h);
            if (semi.size() >= 1) {
                response.setStatus(200);
                response.setMessage(Msg.OK());
                response.setResult(semi);
                return response;
            } else {
                response.setStatus(404);
                response.setMessage(Msg.NotFound());
                response.setResult(null);
            }
        } catch (SQLException sqle) {
            throw new RuntimeException("Problem guys", sqle);
        }
        return null;
    }
}
