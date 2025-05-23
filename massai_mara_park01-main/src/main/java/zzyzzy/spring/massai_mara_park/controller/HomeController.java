package zzyzzy.spring.massai_mara_park.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zzyzzy.spring.massai_mara_park.mapper.ImageMapper;
import zzyzzy.spring.massai_mara_park.model.Image;
import zzyzzy.spring.massai_mara_park.model.Image2;
import zzyzzy.spring.massai_mara_park.repository.ImageRepository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<h1>마사이 마라 국립 야생 동물원</h1>";
    }

    @GetMapping("/images")
    @ResponseBody
    public Map<String, List<Image>> getAllImages() {
        return Map.of("info", imageMapper.findAll());
    }

    @GetMapping("/images2")
    @ResponseBody
    public Map<String, List<Image2>> getAllImages2() {
        return Map.of("info", imageRepository.findAll());
    }

    @GetMapping("/animal")
    public String getRandomAnimal(Model model) throws UnknownHostException {
        long randomId = (long) (Math.random() * 12 + 1);
        Image image = imageMapper.findById(randomId);

        model.addAttribute("url", image.getUrl());
        model.addAttribute("hostname", InetAddress.getLocalHost().getHostName());

        return "index";
    }

    @GetMapping("/animal2")
    public String getRandomAnimal2(Model model) throws UnknownHostException {
        long randomId = (long) (Math.random() * 12 + 1);
        Optional<Image2> image = imageRepository.findById(randomId);

        model.addAttribute("url", image.get().getUrl());
        model.addAttribute("hostname", InetAddress.getLocalHost().getHostName());

        //log.info("{} {} {} {}", randomId, image.get().getUrl(), image.get().getDescription(), image.get().getImageId());

        return "index";
    }

}
