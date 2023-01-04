package com.example.hanghaedemomemo.service;

import com.example.hanghaedemomemo.dto.MemoRequestDto;
import com.example.hanghaedemomemo.entity.Memo;
import com.example.hanghaedemomemo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    //데이터베이스에 연결을해서 저장을 하려면 메모 클래스를 인스턴스로 만들어서 그값을 사용 해서 저장
    // 메모 객체를 만들어주고
    @Transactional
    public Memo createMemo(MemoRequestDto requestDto){
    Memo memo = new Memo(requestDto);
    memoRepository.save(memo);
    return memo;
    }

    @Transactional
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifedAtDesc();
    }

    //수정
    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo =memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이다가 없습니다")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
