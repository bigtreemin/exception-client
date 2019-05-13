package bigtree.home.exception.service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Builder
public class User {

    @NotNull
    private String name;

    @Digits(integer = 2, fraction = 0)
    private int age;

    @Size(min = 1)
    private List<BigDecimal> money;

    private String detail;

    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("age") int age,
            @JsonProperty("money") List<BigDecimal> money, @JsonProperty("detail") String detail) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.detail = detail;
    }

}
