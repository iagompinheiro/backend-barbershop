package com.iagompinheiro.backend.BarberShop.service;

import com.iagompinheiro.backend.BarberShop.domain.domainActivity.Activity;
import com.iagompinheiro.backend.BarberShop.dto.ActivityDto;
import com.iagompinheiro.backend.BarberShop.exceptions.ActivityException;
import com.iagompinheiro.backend.BarberShop.repositories.ActivityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity create(ActivityDto activityDto) throws ActivityException {
        try {
            Activity newActivity = new Activity(activityDto);
            switch (newActivity.getActivityType()) {
                case LOWFADE:
                    newActivity.setValueType(30.0);
                    break;
                case MIDFADE:
                    newActivity.setValueType(35.0);
                    break;
                case AMERICAN:
                    newActivity.setValueType(40.0);
                    break;
                case HIGHFADE:
                    newActivity.setValueType(25.0);
                default:
                    break;
            }
            return activityRepository.save(newActivity);
        } catch (Exception e) {
            throw new ActivityException("Não foi possível criar uma atividade, data e horário já utilizados.");
        }
    }

    public List<Activity> getAll() throws ActivityException {
        try {
            return activityRepository.findAll();
        } catch (Exception e) {
            throw new ActivityException("Não foi possível listar as ativiades.");
        }
    }

    public Activity activityById(Long id) throws ActivityException {
        try {
            return activityRepository.findById(id).get();
        } catch (Exception e) {
            throw new ActivityException("Não foi possível encontrar atividade.");
        }
    }

    public Activity update(Long id, ActivityDto activityDto) throws ActivityException {
        try {
            Activity updateActivity = activityById(id);
            updateActivity.setActivityType(activityDto.activityType());
            updateActivity.setDateTime(activityDto.dateTime());
            switch (updateActivity.getActivityType()) {
                case LOWFADE:
                    updateActivity.setValueType(30.0);
                    break;
                case MIDFADE:
                    updateActivity.setValueType(35.0);
                    break;
                case AMERICAN:
                    updateActivity.setValueType(40.0);
                    break;
                case HIGHFADE:
                    updateActivity.setValueType(25.0);
                default:
                    break;
            }
            activityRepository.save(updateActivity);
            return updateActivity;
        } catch (Exception e) {
            throw new ActivityException("Atividade não encontrada.");
        }
    }

    public void deleteById(Long id) throws ActivityException {
        try {
            activityRepository.deleteById(id);
        } catch (Exception e) {
            throw new ActivityException("Atividade não encontrada.");
        }
    }


}
