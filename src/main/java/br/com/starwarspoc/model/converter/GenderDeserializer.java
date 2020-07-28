package br.com.starwarspoc.model.converter;

import br.com.starwarspoc.model.enumeration.Gender;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class GenderDeserializer extends StdDeserializer<String> {

    protected GenderDeserializer(Class vc) {
        super(vc);
    }

    public GenderDeserializer() {
        this(null);
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return Gender.getfromString(jsonParser.getValueAsString());
    }
}
