package com.postcardable.postcardable.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.postcardable.postcardable.web.dto.request.CardSizeRequestDto;
import com.postcardable.postcardable.web.dto.request.HalfsheetRequestDto;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HalfsheetRequestDto.class, name = PostcardMixin.HalfsheetRequestDtoMixin.TYPE),
        @JsonSubTypes.Type(value = CardSizeRequestDto.class, name = PostcardMixin.CardSizeRequestDtoMixin.TYPE)
})
public class PostcardMixin {

    public abstract static class HalfsheetRequestDtoMixin {
        public static final String TYPE = "halfsheet";

        @JsonCreator
        protected HalfsheetRequestDtoMixin(
                @JsonProperty("finish") String finish,
                @JsonProperty("thickness") Double thickness,
                @JsonProperty("corners") String corners

        ) {}
    }

    public abstract static class CardSizeRequestDtoMixin {
        public static final String TYPE = "cardsize";

        @JsonCreator
        protected CardSizeRequestDtoMixin(
                @JsonProperty("finish") String finish,
                @JsonProperty("thickness") Double thickness,
                @JsonProperty("corners") String corners

        ) {}
    }
}
