package vn.edu.vinaenter.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.bean.Category;
import vn.edu.vinaenter.model.bean.Land;
import vn.edu.vinaenter.model.dao.CategoryDAO;
import vn.edu.vinaenter.model.dao.LandDAO;
import vn.edu.vinaenter.util.FileUtil;

@Controller
@RequestMapping("admin/land")
public class AdminLandController {
	
	@Autowired
	private LandDAO landDao;
	
	@Autowired
	private CategoryDAO catDao;
	
	@Autowired
	ServletContext context;
	
	@GetMapping({"index/{page}", "index"})
	public String index(ModelMap modelMap, @PathVariable(name = "page", required = false) Integer page) {
		if (page == null) {
			page = 1;
		}
		int rowCount = Defines.ROW_COUNT;
		int totalLand = landDao.totalLand();
		int sumPage = (int) Math.ceil((float) totalLand / rowCount);
		int offset = (page - 1) * rowCount;
		List<Land> listLand = landDao.getItems(offset, rowCount);
		modelMap.addAttribute("listLand", listLand);
		modelMap.addAttribute("sumPage", sumPage);
		modelMap.addAttribute("page", page);
		return "cland.admin.land.index";
	}
	
	@GetMapping("add")
	public String add(ModelMap modelMap) {
		List<Category> listCat = catDao.getItems();
		modelMap.addAttribute("listCat", listCat);
		return "cland.admin.land.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("objLand") Land objLand, BindingResult br, 
			@RequestParam("hinhanh") CommonsMultipartFile cmf, RedirectAttributes ra) {
		
		if (br.hasErrors()) {
			return "cland.admin.land.add";
		}

		String fileName = FileUtil.rename(cmf.getOriginalFilename());
		objLand.setPicture(fileName);
		if(!"".equals(fileName)) {
			String dirPath = context.getRealPath("") + Defines.DIR_UPLOAD;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String pathName = dirPath + File.separator + fileName;
			System.out.println(pathName);
			try {
				cmf.transferTo(new File(pathName));
			} catch (IllegalStateException | IOException e) {
				System.out.println(e.getMessage());
				ra.addFlashAttribute("msg", Defines.MSG_ERROR);
				return "redirect:/admin/land/add";
			}
			
		}
		if (landDao.addItem(objLand) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/land/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/land/add";
		}
	}
	
	@GetMapping("edit/{lid}/{page}")
	public String edit(ModelMap modelMap, @PathVariable("lid") int lid, @PathVariable("page") int page) {
		Land objLand = landDao.getItem(lid);
		List<Category> listCat = catDao.getItems();
		
		modelMap.addAttribute("listCat", listCat);
		modelMap.addAttribute("objLand", objLand);
		modelMap.addAttribute("page", page);
		
		return "cland.admin.land.edit";
	}
	
	@PostMapping("edit/{lid}/{page}")
	public String edit(@Valid @ModelAttribute("objLand") Land objLand, BindingResult br,
			@PathVariable("lid") int lid, @PathVariable("page") int page, 
			@RequestParam("hinhanh") CommonsMultipartFile cmf, RedirectAttributes ra, 
			@RequestParam(value = "deleteImage", required = false) String deleteImage) {
		
		if (br.hasErrors()) {
			return "cland.admin.land.edit";
		}
		
		// lấy lại objLand cũ từ database
		Land objOldLand = landDao.getItem(lid);
		
		String fileName = FileUtil.rename(cmf.getOriginalFilename());
		objLand.setLid(lid);
		
		if(!"".equals(fileName)) {
			objLand.setPicture(fileName);
			String dirPath = context.getRealPath("") + Defines.DIR_UPLOAD;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			// nếu checkbox checked thì xóa file cũ
			if (deleteImage != null) {
				String oldFilePath = dirPath + File.separator + objOldLand.getPicture();
				File oldFile = new File(oldFilePath);
				if (oldFile.exists()) {
					oldFile.delete();
				}
			}
			
			String pathName = dirPath + File.separator + fileName;
			System.out.println(pathName);
			try {
				cmf.transferTo(new File(pathName));
			} catch (IllegalStateException | IOException e) {
				System.out.println(e.getMessage());
				ra.addFlashAttribute("msg", Defines.MSG_ERROR);
				return "redirect:/admin/land/edit/" + lid + "/" + page;
			}
			
		} else {
			objLand.setPicture(objOldLand.getPicture());
		}
		
		if (landDao.editItem(objLand) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/land/index/" + page;
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/land/edit/" + lid + "/" + page;
		}
	}
	
	@GetMapping("del/{lid}/{page}")
	public String del(ModelMap modelMap, @PathVariable("lid") int lid, @PathVariable("page") int page, RedirectAttributes ra) {
		if (landDao.delItem(lid) > 0) {
			ra.addAttribute("msg", Defines.MSG_DELETE_SUCCESS);
			return "redirect:/admin/land/index/" + page;
		} else {
			ra.addAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/land/index/" + page;
		}
	}
}
