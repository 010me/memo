package com.example.hanghaedemomemo.controller;

import com.example.hanghaedemomemo.dto.MemoRequestDto;
import com.example.hanghaedemomemo.entity.Memo;
import com.example.hanghaedemomemo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;


    @GetMapping("/prac")
    public String prac() {
        return "Hello test 동작확인, 다시햣한번확인";
    }

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    //메모 생성
    @PostMapping("/api/memos") //메모를 바로 반환
        public Memo createMemo(@RequestBody MemoRequestDto requestDto ){
        return memoService.createMemo(requestDto);
        }//데이터를 로직 작성, 데이터베이스완 연결하는 부분인 서비스

    @GetMapping("/api/memos")
    public List<Memo>getMemos() {
        return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.updateMemo(id, requestDto);

    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable long id){
    return memoService.deleteMemo(id);
    }
}
