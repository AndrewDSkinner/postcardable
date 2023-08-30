package com.postcardable.postcardable.repository;

import com.postcardable.postcardable.model.*;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.postcardable.postcardable.web.dto.request.PostcardType.CARDSIZE;
import static com.postcardable.postcardable.web.dto.request.PostcardType.HALFSHEET;

@Repository
public class JdbcPostcardRepository implements PostcardRepository{

    private final NamedParameterJdbcTemplate template;

    public JdbcPostcardRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Postcard savePostcard(PostcardType type, Finish finish, Double thickness, Corners corners) {

        String query = "INSERT INTO postcard (type, finish, thickness, corners) " +
                        "VALUES (:type, :finish, :thickness, :corners) ";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("type", type.toString());
        params.addValue("finish", finish.toString());
        params.addValue("thickness", thickness);
        params.addValue("corners", corners.toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(query, params, keyHolder, new String[]{"id"});

        Long generateId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        if (type.equals(HALFSHEET)) {
            return new HalfSheet(generateId,finish, thickness, corners);
        }

        if (type.equals(PostcardType.CARDSIZE)) {
            return new CardSize(generateId,finish, thickness, corners);
        }
        return null;
    }

    @Override
    public Postcard getPostcardById(Long id) {
        String query = "SELECT * " +
                "FROM postcard "+
                "WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        Map<String, Object> row = template.queryForMap(query, params);
        PostcardType type = PostcardType.valueOf((String) row.get("type"));

        if (type == HALFSHEET) {
            return new HalfSheet( 1L,Finish.LINEN, .054, Corners.ROUNDED);
        }

        if (type == CARDSIZE) {
            return new CardSize( 2L,Finish.LINEN, .042, Corners.SQUARE);
        }

        return null;
    }
}
