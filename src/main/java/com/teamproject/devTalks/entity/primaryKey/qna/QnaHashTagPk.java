package com.teamproject.devTalks.entity.primaryKey.qna;

import javax.persistence.Column;
import java.io.Serializable;

public class QnaHashTagPk  implements Serializable {

    @Column(name = "qnaHashtag")
    private String hashtag;

    @Column(name = "qnaBoardNumber")
    private int qnaBoardNumber;

}