package com.postcardable.postcardable.repository;

import com.postcardable.postcardable.model.*;
import com.postcardable.postcardable.model.PostcardType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.postcardable.postcardable.model.PostcardType.CARDSIZE;
import static com.postcardable.postcardable.model.PostcardType.HALFSHEET;

@Repository
public class JdbcPostcardRepository implements PostcardRepository{

    private final NamedParameterJdbcTemplate template;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public JdbcPostcardRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Postcard savePostcard(PostcardType type, Finish finish, Double thickness, Corners corners) {
        logger.info("Creating postcard with type: {} finish: {} thickness: {} corners: {}", type, finish, thickness, corners);

        String query = "INSERT INTO postcard (type, finish, thickness, corners) " +
                        "VALUES (:type, :finish, :thickness, :corners) ";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("type", type.toString());
        params.addValue("finish", finish.toString());
        params.addValue("thickness", thickness);
        params.addValue("corners", corners.toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(query, params, keyHolder, new String[]{"id"});

        Long generatedId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        if (type.equals(HALFSHEET)) {
            return new HalfSheet(generatedId,finish, thickness, corners);
        }

        if (type.equals(PostcardType.CARDSIZE)) {
            return new CardSize(generatedId,finish, thickness, corners);
        }
        return null;
    }

    @Override
    public Postcard getPostcardById(Long id) {
        logger.info("Retrieving postcard with id: {}", id);

        String query =
                "SELECT * " +
                "FROM postcard "+
                "WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        Map<String, Object> row = template.queryForMap(query, params);
        PostcardType type = PostcardType.valueOf((String) row.get("type"));
        Finish finish =  Finish.valueOf((String) row.get("finish"));
        Double thickness = (Double) row.get("thickness");
        Corners corners = Corners.valueOf((String) row.get("corners"));
        Long resultId = (Long) row.get("id");

        if (type == HALFSHEET) {
            return new HalfSheet( resultId,finish, thickness, corners);
        }

        if (type == CARDSIZE) {
            return new CardSize( resultId,finish, thickness, corners);
        }

        return null;
    }

    @Override
    public List<Postcard> findPostcardsByType(PostcardType type) {
        logger.info("Retrieving postcards of type: {}", type);
        String query =
                        "SELECT * " +
                        "FROM postcard " +
                        "WHERE type = :type";
        Map<String, Object> params = new HashMap<>();
        params.put("type", type.toString());

        if (type == HALFSHEET) {
            return template.query(query, params, (rs, rowNum) -> new HalfSheet(
                    rs.getLong("id"),
                    Finish.valueOf(rs.getString("finish")),
                    rs.getDouble("thickness"),
                    Corners.valueOf(rs.getString("corners"))
            ));
        }

        if (type == CARDSIZE) {
            return template.query(query, params, (rs, rowNum) -> new CardSize(
                    rs.getLong("id"),
                    Finish.valueOf(rs.getString("finish")),
                    rs.getDouble("thickness"),
                    Corners.valueOf(rs.getString("corners"))
            ));
        }

        return null;
    }
}
