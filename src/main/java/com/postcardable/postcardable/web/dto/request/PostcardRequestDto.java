package com.postcardable.postcardable.web.dto.request;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import jakarta.validation.ValidationException;

import java.util.Objects;

public abstract class PostcardRequestDto {
    private final Finish finish;
    private final Double thickness;
    private final Corners corners;

    public PostcardRequestDto(Finish finish, Double thickness, Corners corners) {
        validateProperties(finish, thickness, corners);
        this.finish = finish;
        this.thickness = thickness;
        this.corners = corners;
    }

    public Finish getFinish() {
        return finish;
    }

    public Double getThickness() {
        return thickness;
    }

    public Corners getCorners() {
        return corners;
    }

    public abstract PostcardType getType();

    private void validateProperties(Finish finish, Double thickness, Corners corners) {
        if (finish == null || thickness == null || corners == null) {
            throw new ValidationException("Finish, thickness, corners, and type properties are required");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostcardRequestDto that = (PostcardRequestDto) o;
        return finish == that.finish && Objects.equals(thickness, that.thickness) && corners == that.corners;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finish, thickness, corners);
    }
}
