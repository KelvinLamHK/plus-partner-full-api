package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TQuickLink")
public class TQuickLinkEntity implements Comparable<TQuickLinkEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "linkId")
    private Long linkId;

    @Column(name = "linkEngName")
    private String linkEngName;

    @Column(name = "linkChiName")
    private String linkChiName;

    @Column(name = "linkSimName")
    private String linkSimName;

    @Column(name = "url")
    private String url;

    @Column(name = "latestUpdate")
    private Date latestUpdate;

    @Override
    public int compareTo(TQuickLinkEntity other) {
        // Sort in descending order by latestUpdate
        return other.latestUpdate.compareTo(this.latestUpdate);
    }

}
