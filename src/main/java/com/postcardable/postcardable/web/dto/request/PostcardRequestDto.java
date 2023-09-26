package com.postcardable.postcardable.web.dto.request;

import com.postcardable.postcardable.model.Corners;
import com.postcardable.postcardable.model.Finish;
import com.postcardable.postcardable.model.PostcardType;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public abstract class PostcardRequestDto {
    @NotNull(message = "Finish cannot be null")
    private final Finish finish;

    @NotNull(message = "Thickness cannot be null")
    private final Double thickness;

    @NotNull(message = "Corners cannot be null")
    private final Corners corners;

    public PostcardRequestDto(Finish finish, Double thickness, Corners corners) {
       validateThickness(thickness);
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

    private void validateThickness(Double thickness) {

        if (thickness == null || thickness < .007 || thickness > .016) {
            throw new ValidationException("Thickness must be at least .007 inches and no more than .016 inches.");
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
