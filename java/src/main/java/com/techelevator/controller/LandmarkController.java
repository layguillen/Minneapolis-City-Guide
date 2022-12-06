package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class LandmarkController {

    private LandmarkDao landmarkDao;

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @RequestMapping(path="/landmark/list", method= RequestMethod.GET)
    public List<Landmark> getAllLandmarks(){
        return landmarkDao.listLandmarks();
    }

    @RequestMapping(path="/landmark/{id}", method= RequestMethod.GET)
    public Landmark getLandmarks(@Valid @PathVariable("id") int landmarkId){
        Landmark result = landmarkDao.getLandmark(landmarkId);
        if(result == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Landmark not found", null);
        }
        return result;
    }

    //used to update likes count (int)
    @RequestMapping(path = "/landmark/{id}", method= RequestMethod.PUT)
    public Landmark updateLandmark(@Valid @RequestBody Landmark landmark, @PathVariable("id") int landmarkId){
        Landmark result = landmarkDao.updateLandmark(landmark);
        if(result == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Landmark not found", null);
        }
        return result;
    }

    @RequestMapping(path= "/landmark/new", method= RequestMethod.POST)
    public Landmark newLandmark(@Valid @RequestBody Landmark landmark){
        boolean success = landmarkDao.createLandmark(landmark);
        if(!success){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Landmark to be added was not found", null);
        }

        return landmark;
    }
}
