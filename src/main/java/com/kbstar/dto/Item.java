package com.kbstar.dto;

import lombok.*;

import javax.sound.midi.Sequence;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    private int id;
    private String name;
    private int price;
    private String imgname;
    private Date regdate;

}
