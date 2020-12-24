package com.leyou.item.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("spec")
public interface SpecApi {

    @GetMapping("cid")
    ResponseEntity<String> querySpecificationsBycid(@RequestParam("cid") Long cid);
}
