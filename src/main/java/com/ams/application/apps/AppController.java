package com.ams.application.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/app")
public class AppController {
    @Autowired
    private AppRepository appRepository;

    @Autowired
    private AppService appService;

    @GetMapping()
    public @ResponseBody List<AppModel> getApps() {
        return this.appService.getAllUser();
    }

    @GetMapping("{appId}")
    public @ResponseBody AppModel getApp(@PathVariable("appId") UUID appId) {
        return this.appService.getUserById(appId);
    }

    @PostMapping()
    public @ResponseBody AppModel addUser(@RequestBody AppModel app) {
        return this.appService.saveApp(app);
    }

    @PutMapping("{appId}")
    public @ResponseBody AppModel updateApp(@PathVariable("appId") UUID appId, @RequestBody AppModel appModel) {
        return this.appService.updateApp(appModel, appId);
    }

    @DeleteMapping("{appId}")
    public void deleteUser(@PathVariable UUID appId){
        this.appService.deleteUser(appId);
    }
}
