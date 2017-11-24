package com.smart.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
* 文件工具类
* @author xiaobai
* @date 2017/10/29 15:02
**/

public class FileUtil {

	private static final Logger logger = Logger.getLogger(FileUtil.class);

	public static String getRootRealPath() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String path = request.getSession().getServletContext().getRealPath("/");
		return path;
	}

	public static String getDateDir(Date date) {
		String year = DateFormatUtils.format(date, "yyyy");
		String month = DateFormatUtils.format(date, "MM");
		String day = DateFormatUtils.format(date, "dd");
		String hour = DateFormatUtils.format(date, "HH");
		return year + "/" + month + "/" + day + "/" + hour;
	}

	public static String getCurrentDateDir() {
		return getDateDir(new Date());
	}

	/**
	 * 日期加随机数组成的文件名
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateFilename(Date date) {
		return DateFormatUtils.format(date, "yyyyMMddHHmmss") + new Random().nextInt(1000);
	}

	public static String getCurrentDateFilename() {
		return getDateFilename(new Date());
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFileExt(String filename) {
		String fileExt = null;
		if (StringUtils.isNotBlank(filename)) {
			fileExt = filename.substring(filename.lastIndexOf(".")).toLowerCase();
		}
		return fileExt;
	}

	/**
	 * 判断路径是否存在，不存在则创建目录
	 * 
	 * @return
	 */
	public static boolean mkdirs(String filepath) {
		boolean result = true;
		if (StringUtils.isBlank(filepath)) {
			result = false;
		} else {
			File dirFile = new File(filepath);
			if (!dirFile.exists()) {
				result = dirFile.mkdirs();
			}
		}
		return result;
	}

	/**
	 * 删除文件
	 * 
	 * @param filepath
	 * @return
	 */
	public static boolean removeFile(String filepath) {
		boolean result = true;
		if (StringUtils.isNotBlank(filepath)) {
			File file = new File(filepath);
			if (file.exists()) {
				result = file.delete();
			}
		}
		return result;
	}

	/**
	 * 文件上传
	 * 
	 * @param mpFile
	 * @param newFilename
	 * @return
	 */
	public static boolean uploadFile(MultipartFile mpFile, String newFilename) {
		File file = new File(newFilename);
		try {
			mpFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
			return  false;
		}
		return true;
	}

	public static String uploadFileByType(MultipartFile mpFile, String type) {
		String rootRealPath = FileUtil.getRootRealPath();
		rootRealPath = new File(rootRealPath).getParentFile().getAbsolutePath();
		String newFilepath = type + "/" + FileUtil.getCurrentDateDir();
		String newFilename = FileUtil.getCurrentDateFilename() + FileUtil.getFileExt(mpFile.getOriginalFilename());
		FileUtil.mkdirs(rootRealPath + "/upload/" + newFilepath);
		if (uploadFile(mpFile, rootRealPath + "/upload/" + newFilepath + "/" + newFilename)) {
			return newFilepath + "/" + newFilename;
		}
		return null;
	}
}
