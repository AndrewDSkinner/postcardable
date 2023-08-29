package com.postcardable.postcardable.repository;

import com.postcardable.postcardable.model.*;
import com.postcardable.postcardable.web.dto.request.PostcardType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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

        Map<String, Object> params = new HashMap<>();
        params.put("type", type.toString());
        params.put("finish", finish.toString());
        params.put("thickness", thickness);
        params.put("corners", corners.toString());

        int rowNumber = template.update(query, params);
        System.out.println(rowNumber + " row created");

        if (type.equals(HALFSHEET)) {
            return new HalfSheet(finish, thickness, corners);
        }

        if (type.equals(PostcardType.CARDSIZE)) {
            return new CardSize(finish, thickness, corners);
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
            return new HalfSheet( Finish.LINEN, .054, Corners.ROUNDED);
        }

        if (type == CARDSIZE) {
            return new CardSize( Finish.BAMBOO, .042, Corners.SQUARE);
        }

        return null;
    }
}
