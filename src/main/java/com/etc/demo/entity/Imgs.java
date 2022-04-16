package com.etc.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * imgs
 *
 * @author
 */
@Data
public class Imgs implements Serializable {
    private Integer imgId;

    private String imgSrc;

    private Integer gId;

    private static final long serialVersionUID = 1L;
}