package com.carresearch.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortlistRequest {

    @NotEmpty
    private List<Long> carIds;
}
