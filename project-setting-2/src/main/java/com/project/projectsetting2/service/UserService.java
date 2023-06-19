package com.project.projectsetting2.service;

import com.project.projectsetting2.dto.*;
import com.project.projectsetting2.entity.Board;
import com.project.projectsetting2.entity.Member;
import com.project.projectsetting2.entity.Role;
import com.project.projectsetting2.repository.BoardRepository;
import com.project.projectsetting2.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;

    private final PasswordEncoder passwordEncoder;

    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public void join(MemberJoinDto dto) {
        if (dto.getPassword().equals(dto.getPasswordCheck())) {
            Member member = Member.builder()
                    .nickname(dto.getNickname())
                    .username(dto.getUsername())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .phoneNumber(dto.getPhoneNumber())
                    .birth(dto.getYear() + dto.getMonth() + dto.getDay())
                    .role(Role.USER.getKey())
                    .build();

            memberRepository.save(member);
        }
    }

    public void writeBoard(BoardWriteDto dto, Principal principal) {
        boardRepository.save(
                Board.builder()
                        .writer(memberRepository.findByUsername(principal.getName()).get())
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .updateKey(dto.getUpdateKey())
                        .view(0)
                        .createAt(LocalDateTime.now())
                        .build()
        );
    }

    public void deleteBoard(BoardDeleteDto dto) {
        Board board = boardRepository.findById(dto.getBoardId()).get();

        if (board.getUpdateKey().equals(dto.getUpdateKey())) {
            boardRepository.delete(board);
        }
    }

    public List<Board> getBaordByKeword(String keyword) {
        return boardRepository.findAllByTitle(keyword);
    }

    public void changeNickname(ChangeNicknameDto dto, Principal principal) {
        Member user = memberRepository.findByUsername(principal.getName()).get();

        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            user.setNickname(dto.getNickname());
            memberRepository.save(user);
        }
    }

    public boolean changePassword(ChangePasswordDto dto, Principal principal) {
        Member user = memberRepository.findByUsername(principal.getName()).get();

        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
            memberRepository.save(user);

            return true;
        }
        return false;
    }

}
