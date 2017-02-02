package net.winnerawan.ibod.util;

import net.winnerawan.ibod.dao.DAO;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

/**
 * Created by winnerawan
 * on 2/3/17.
 */
public class Controller {

    private DAO dao;

    ObjectMapper mapper =  JsonFactory.create(); // 1


    public Controller() { }

    public Controller(DAO dao) {

        super();

        this.dao = dao;

    }

    public String loadAllMovies(String body) {

        return mapper.toJson(dao.getAllMovie());

    }
}
