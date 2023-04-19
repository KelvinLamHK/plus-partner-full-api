package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TQuickLink")
public class TQuickLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="linkId")
    private Long linkId;

    @Column(name="linkEngName")
    private String linkEngName;

    @Column(name="linkChiName")
    private String linkChiName;

    @Column(name="linkSimName")
    private String linkSimName;

    @Column(name="url")
    private String url;

}
