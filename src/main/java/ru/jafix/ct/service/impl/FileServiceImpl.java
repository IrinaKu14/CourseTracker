package ru.jafix.ct.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.jafix.ct.service.FileService;

import java.io.*;

@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Override
    public void save(MultipartFile multipartFile) throws IOException {
        String path = "/Users/User/Documents/coursetracker/files/" + multipartFile.getOriginalFilename();
        try (OutputStream fos = new FileOutputStream(path)) {
            fos.write(multipartFile.getBytes());
        } catch (Exception e) {
            log.error("Ошибка сохранения файла : {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public byte[] receive(String filename) throws IOException {
        String path = "/Users/User/Documents/coursetracker/files/" + filename;
        try (InputStream is = new FileInputStream(path)) {
            return is.readAllBytes();
        } catch (Exception e) {
            log.error("Ошибка получения файла : {}", e.getMessage());
            throw e;
        }
    }
}