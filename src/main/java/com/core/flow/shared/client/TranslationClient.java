package com.core.flow.shared.client;

import com.dgcash.common.core.data.dtos.translation.MessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "TRANSLATION-SERVICE")
public interface TranslationClient {
    @GetMapping("/messages/{locale}/{messageCode}")
    MessageDto getMessage(@PathVariable("locale") String locale,
                          @PathVariable("messageCode") String messageCode,
                          @RequestParam Map<String, String> queryParameters);
}
