package com.rafa.SpringLocalstack.infra.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponseDataDTO {
    private Object data;
}
