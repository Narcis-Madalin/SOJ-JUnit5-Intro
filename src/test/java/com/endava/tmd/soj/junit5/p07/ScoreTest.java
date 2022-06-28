package com.endava.tmd.soj.junit5.p07;


import com.sun.source.tree.AssertTree;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    private Score score;

    @BeforeAll
    static void formatCheck(){
        Locale.setDefault(Locale.US);
        //Locale.setDefault(Locale.FRANCE);
    }

    @BeforeEach
    void newScore(){
        score = new Score();
    }

    @Test
    void allAreCorrect(){
        score.addCorrectAnswer();
        score.addCorrectAnswer();
        score.addCorrectAnswer();
        score.addCorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("100.0");
    }

    @Test
    void allAreWrong(){
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("0.0");
    }

    @Test
    void halfAreWrong(){
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        score.addCorrectAnswer();
        score.addCorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("50.0");
    }

    @Test
    void mostAreWrong(){
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        score.addCorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("33.3");
    }

    @Test
    void mostAreCorrect(){
        score.addIncorrectAnswer();
        score.addCorrectAnswer();
        score.addCorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("66.7");
    }

    @Test
    void noAnswer(){
        assertThat(score.getPercent()).isEqualTo("100.0");
    }

}
