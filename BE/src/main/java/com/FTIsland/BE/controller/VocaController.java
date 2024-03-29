package com.FTIsland.BE.controller;

import com.FTIsland.BE.dto.*;
import com.FTIsland.BE.entity.UserVocaEntity;
import com.FTIsland.BE.service.VocaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VocaController {
    private final VocaService vocaService;

    @RequestMapping("/saveVoca")
    public void saveVoca() {vocaService.saveVoca();}

    @PostMapping("/voca")
    public ResponseEntity<UserVocaEntity> createdUserVoca(@RequestBody VocaDTO vocaDTO){
        UserVocaEntity savedVoca = vocaService.save(vocaDTO.getUserId(), vocaDTO.getVocaId());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(("/{id}"))
                .buildAndExpand(savedVoca.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/voca")
    public void deleteUserVoca(@RequestBody VocaDTO vocaDTO){
        vocaService.deleteUserVoca(vocaDTO.getUserId(), vocaDTO.getVocaId());
    }

    @PostMapping("/voca/list")
    public List<VocaDTO> getVocaList(@RequestBody VocaDTO vocaDTO){
        return vocaService.getVocaList(vocaDTO.getUserId()); // 해당 id의 동화 내용 list
    }

    @PostMapping("/voca/star")
    public VocaStarDTO isStar(@RequestBody VocaStarDTO vocaStarDTO){
        return vocaService.isStar(vocaStarDTO); // 해당 id의 동화 내용 list
    }

    @GetMapping("/book/voca/description")
    public BookVocaDescriptionDTO getBookVocaDescription(@RequestParam Integer vocaId, @RequestParam String lan) {
        return vocaService.getBookVocaDescription(vocaId, lan);
    }

    @GetMapping("/voca/description")
    public List<VocaDescriptionDTO> getVocaDescription(@RequestParam Integer vocaId, @RequestParam String mainLan, @RequestParam String subLan) {
        return vocaService.getVocaDescription(vocaId, mainLan, subLan);
    }

}
