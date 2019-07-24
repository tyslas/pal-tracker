package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;

    public EnvController(@Value("${PORT:8675}") String port,
                         @Value("${MEMORY_LIMIT:12G}") String memory_limit,
                         @Value("${CF_INSTANCE_INDEX:34}") String cf_instance_index,
                         @Value("${CF_INSTANCE_ADDR:123.sesame.street}") String cf_instance_address) {
        this.PORT = port;
        this.MEMORY_LIMIT = memory_limit;
        this.CF_INSTANCE_INDEX = cf_instance_index;
        this.CF_INSTANCE_ADDR = cf_instance_address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();
        env.put("PORT", PORT);
        env.put("MEMORY_LIMIT", MEMORY_LIMIT);
        env.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        env.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);
        return env;
    }
}
