package com.gmail.adam.zawadka.sudoku.API.controller;

import com.gmail.adam.zawadka.sudoku.API.model.Score;
import com.gmail.adam.zawadka.sudoku.API.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    ScoreRepository scoreRepository;

//    @GetMapping("/getsudoku")
//    public Sudoku getSudoku(){
//
//    }

    @RequestMapping(value = "/score/post", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String setScore(@RequestBody Score score) throws Exception {
        String test = score.getNick();
        scoreRepository.save(score);
        return test;
    }
}
