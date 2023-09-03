package com.sparta.myselectshop.controller;


import com.sparta.myselectshop.dto.FolderRequestDto;
import com.sparta.myselectshop.dto.FolderResponseDto;
import com.sparta.myselectshop.security.UserDetailsImpl;
import com.sparta.myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
@RequestMapping("/api")//api로 시작하는 요청은 이 컨트롤러에서 받습니다.
@RequiredArgsConstructor // 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성합니다.
public class FolderController {
        private final FolderService folderService;
        @PostMapping("/folders")
        public void addFolder(@RequestBody FolderRequestDto folderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
            List<String> folderNames = folderRequestDto.getFolderNames();//폴더 이름들을 가져옵니다.
            folderService.addFolders(folderNames, userDetails.getUser());//폴더 이름들을 추가합니다.

        }
        @GetMapping("/folders")
        public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails){
            return folderService.getFolders(userDetails.getUser());
        }


}
