package com.huangyongsheng.hearthstone.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RestController("FileController")
@RequestMapping(value = "/file")
public @Log4j class FileController {
	private final Path rootLocation = Paths.get("e:\\");;

	public FileController() throws InstantiationException, IllegalAccessException {
		String dir = "/tmp";
		System.out.println("===========" + dir);
		File temp = new File(dir);
		if (!temp.exists()) {
			temp.mkdirs();
		}
		System.out.println("===========" + temp.getAbsolutePath());
	}

	@PostMapping
	public String handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
		log.info("file/post");

		try {
			if (file.isEmpty()) {
				throw new Exception("Failed to store empty file " + file.getOriginalFilename());
				// System.out.println("Failed to store empty file " +
				// file.getOriginalFilename());
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			throw new Exception("Failed to store file " + file.getOriginalFilename() + e.getMessage());
		}

		return "ok";
	}

	@GetMapping("/{filename:.+}")
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws Exception {
		log.info("get" + filename);
		Resource file = loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	public Resource loadAsResource(String filename) throws Exception {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new Exception("Could not read file: " + filename);

			}
		} catch (MalformedURLException e) {
			throw new Exception("Could not read file: " + filename, e);
		}
	}
}
