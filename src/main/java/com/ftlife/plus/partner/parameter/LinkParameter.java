package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LinkParameter implements Comparable<LinkParameter>{
    private long linkId;
    private String url;
    private String status;
    private String linkEngName;
    private String linkChiName;
    private String linkSimName;

    private Date latestUpdate;
    @Override
    public int compareTo(LinkParameter other) {
        // Sort in descending order by latestUpdate
        return other.latestUpdate.compareTo(this.latestUpdate);
    }
}
