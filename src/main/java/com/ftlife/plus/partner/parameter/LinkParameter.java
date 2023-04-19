package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class LinkParameter {
    private long linkId;
    private String url;
    private String status;
    private String linkEngName;
    private String linkChiName;
    private String linkSimName;
}
