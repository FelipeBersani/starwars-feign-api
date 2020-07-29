package br.com.starwarspoc.repository.cache;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@Data
@EqualsAndHashCode(of = {"key"})
public abstract class AbstractCache implements Serializable {

    @Id
    @JsonIgnore
    private String key;

    @TimeToLive
    @JsonIgnore
    private Long expiration = 14400L;

}
