package org.jspider.springmvccrud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mobile {
    private String modelName;
    private String companyName;
    private double modelPrice;
}
