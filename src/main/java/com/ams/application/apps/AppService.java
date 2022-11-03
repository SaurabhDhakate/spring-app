package com.ams.application.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class AppService {

    @Autowired
    public AppRepository appRepository;

    public List<AppModel> getAllUser() {
        return this.appRepository.findAll();
    }

    public AppModel getUserById(UUID id) {
        return this.appRepository.findById(id).orElseThrow();
    }

    public AppModel saveApp (AppModel app) {
        return this.appRepository.save(app);
    }

    public AppModel updateApp (AppModel appModel, UUID appId) {
        AppModel apps = this.appRepository.findById(appId).orElseThrow();
        apps.setAmount(appModel.getAmount());
        apps.setInterest(appModel.getInterest());
        apps.setTenure(appModel.getTenure());
        return this.appRepository.save(apps);
    }


    public void deleteUser(@PathVariable UUID appId){
        boolean exist = this.appRepository.existsById(appId);
        if(exist) {
            this.appRepository.deleteById(appId);
        }
    }
}
