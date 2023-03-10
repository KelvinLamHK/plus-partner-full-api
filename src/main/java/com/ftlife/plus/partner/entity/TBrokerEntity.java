package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.DocumentParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name = "TBroker")
@Getter
@Setter
public class TBrokerEntity extends  TBrokerCommon{


}
