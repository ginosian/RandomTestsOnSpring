package com.mefis.controller;

import com.google.gson.Gson;
import com.mefis.dto.AjaxTestUser;
import com.mefis.dto.ImageDTO;
import com.mefis.dto.ProfileDTO;
import com.mefis.service.ImageService;
import com.mefis.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Lion on 7/28/16.
 */
@Controller
public class MainController {

    static boolean a;

    @Autowired
    ProfileService profileService;
    @Autowired
    ImageService imageService;


    Gson gson = new Gson();


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String uploadImage(@RequestParam("name") String name,
                                            @RequestParam("image") MultipartFile image) {

        if (!image.isEmpty()) {
            try {
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImageBytes(image.getBytes());
                imageDTO.setName(name);
                imageDTO.setType(image.getContentType());
                imageService.addImage(imageDTO);
                return "Your image is successfully uploaded!";
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return "File was empty.";
        }
        return "FATAL ERROR!";
    }
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadImageView() {
        return new ModelAndView("ImageUpload");
    }
    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public void downloadImage(@PathVariable("id") String id, HttpServletResponse response) throws IOException {

        handleDownload(id, response);
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void downloadImage2(@RequestParam("id") String id,
                               HttpServletResponse response) throws IOException {

        handleDownload(id, response);
    }
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView downloadImageView() throws IOException {
        return new ModelAndView("ImageDownload");
    }
    @RequestMapping(value = "/newTab", method = RequestMethod.GET)
    public ModelAndView newTab() {
        return new ModelAndView("test");
    }
    private void handleDownload(String id, HttpServletResponse response) throws IOException {
        ImageDTO image = imageService.getImage(Long.parseLong(id));
        response.setContentType(image.getType());
        response.setContentLength(image.getImageBytes().length);

//        String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename=\"%s\"", image.getName());
//        response.setHeader(headerKey, headerValue);

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(image.getImageBytes());
        outputStream.close();
    }






    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public @ResponseBody String ajaxTest() throws InterruptedException {
        return gson.toJson(users);
    }
    @RequestMapping(value = "/ajax/time", method = RequestMethod.GET)
    public @ResponseBody String checkTime() {
        return gson.toJson(AjaxTestUser.generateCheckTime());
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {
        return new ModelAndView("testajax");
    }
    @RequestMapping(value = "/testik", method = RequestMethod.GET)
    public ModelAndView testik() {
        ModelAndView m = new ModelAndView("testmest");
        m.addObject("vle", "Laylaylay lalam! ! !");
        return m;
    }

    @RequestMapping("/")
    public ModelAndView foo1() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "Hello Friend!");
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView createProfile() {
        ModelAndView modelAndView = new ModelAndView("hello");
        if (a) {
            modelAndView.addObject("message", "Already done");
        } else {
            profileService.initDefaultProfiles();
            modelAndView.addObject("message", "Creation completed");
            a = true;
        }
        return modelAndView;
    }

    @RequestMapping("/get/{id}")
    public ModelAndView getProfileCheck(@PathVariable("id") String id) {
        ProfileDTO profileDTO = profileService.getProfile(Long.parseLong(id));

        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", profileDTO);
        return modelAndView;
    }

    @RequestMapping("/get")
    public ModelAndView getAllProfiles() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", profileService.getAllProfiles().toString());
        return modelAndView;
    }

    public static Random random = new Random();
    AjaxTestUser[] users = {
            new AjaxTestUser("Vle", "Vleyan", 34, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Ashot", "Xulyan", 22, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Ananaya", "Annasunyan", 14, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Janik", "Shampuryan", 16, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Valod", "Tuftyan", 25, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Antaktik", "Albertyan", 66, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Alla", "Annanasyan", 45, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Pavlik", "Panteonyan", 31, AjaxTestUser.generateCheckTime()),
            new AjaxTestUser("Vaxarshak", "Vayquarayan", 1, AjaxTestUser.generateCheckTime())
    };






}
