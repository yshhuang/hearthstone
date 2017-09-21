package com.huangyongsheng.hearthstone.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@RestController("FileController")
@RequestMapping(value = "/file")
public @Log4j class FileController {
	private final Path rootLocation = Paths.get("e:\\");;

	@RequestMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		System.out.println(file.getSize());

		try {
			if (file.isEmpty()) {
				System.out.println("Failed to store empty file " + file.getOriginalFilename());
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			System.out.println("Failed to store file " + file.getOriginalFilename() + e.getMessage());
		}

		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}

	@PostMapping(value = "/uploadFile")
	public String uploadFileHandler(HttpServletRequest request, HttpServletResponse response) {
		log.info("postfile");
		try {
			request.setCharacterEncoding("utf-8");
			if (!"OPTIONS".equalsIgnoreCase(request.getMethod()) && request.getParameter("errorCode") != null) {
				response.sendError(Integer.parseInt(request.getParameter("errorCode")),
						request.getParameter("errorMessage"));
				log.info("收到错误信息，上传终止");
				return null;
			}
			if (request.getHeader("Content-Type") != null
					&& request.getHeader("Content-Type").startsWith("multipart/form-data")) {
				ServletFileUpload upload = new ServletFileUpload();
				FileItemIterator iterator = upload.getItemIterator(request);
				System.out.println("===" + iterator.hasNext());
				while (iterator.hasNext()) {
					System.out.println(iterator.toString());
					FileItemStream item = iterator.next();
					System.out.println(item.getName() + item.getContentType() + item.toString());
					if (item.getName() == null) {
						System.out.println(item.toString());
					} else {
						String realPath = request.getServletContext().getRealPath("/file");
						File file = new File(realPath);
						if (!file.exists()) {
							file.mkdirs();
						}
						String filePath = realPath + File.separator + item.getName();

						int BUFSIZE = 100 * 1024 * 1024;
						FileChannel outChannel = null;

						try {
							log.info("正在输出到文件:" + filePath);
							outChannel = new FileOutputStream(filePath).getChannel();

							InputStream stream = item.openStream();
							ByteBuffer bb = ByteBuffer.allocate(BUFSIZE);
							byte[] b = new byte[BUFSIZE];
							int length = 0;
							while ((length = stream.read(b, 0, BUFSIZE)) != -1) {
								bb.put(b, 0, length);
								bb.flip();
								outChannel.write(bb);
								bb.clear();
							}

						} catch (IOException ioe) {
							ioe.printStackTrace();
						} finally {
							try {
								if (outChannel != null) {
									outChannel.close();
								}
							} catch (IOException ignore) {
							}
						}
						// }

						return filePath;
					}
				}
			} else {
				// 没有附带文件或者请求格式不正确
				log.info("没有附带文件或者请求格式不正确");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return null;
	}

}
