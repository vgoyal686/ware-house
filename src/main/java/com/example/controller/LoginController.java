package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.User;
import com.example.model.Warehouse;
import com.example.service.IExcelService;
import com.example.service.UserService;
import com.example.service.WarehouseServiceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class LoginController
{

	@Autowired
	private UserService userService;
	@Autowired
	private WarehouseServiceImpl warehouseService;
	@Autowired
	private IExcelService excelService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	
	
	
	@RequestMapping(value = { "/fileUpload" }, method = RequestMethod.GET)
	public ModelAndView excelFileTodb()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("excel-upload");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration/1", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult)
	{
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null)
		{
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors())
		{
			modelAndView.setViewName("registration");
		}
		else
		{
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "warehouse/view/registration", method = RequestMethod.GET)
	public ModelAndView warehouseRegistationView()
	{
		ModelAndView modelAndView = new ModelAndView();
		Warehouse warehouse = new Warehouse();
		modelAndView.addObject("user", warehouse);
		modelAndView.setViewName("warehouse");
		return modelAndView;
	}

	@RequestMapping(value = "warehouse/registration", method = RequestMethod.POST)
	public ModelAndView createNewWareHouse(@Valid Warehouse user, BindingResult bindingResult)
	{
		ModelAndView modelAndView = new ModelAndView();
		Warehouse userExists = warehouseService.findWarehouseByEmail(user.getEmail());
		if (userExists != null)
		{
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors())
		{
			modelAndView.setViewName("registration");
		}
		else
		{
			warehouseService.saveWarehouse(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	
	
	


    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

      
        
        
        String message = "" ;
        
        String name = file.getName();
		String originalName = file.getOriginalFilename();
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				long timestamp = System.currentTimeMillis() / 1000;
				File dir = new File(rootPath + File.separator + "tmpFiles/" + timestamp);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + originalName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				
			} catch (Exception e) {
				message= "You failed to upload " + name + " => " + e.getMessage();
				
			}
		} else {
			message= "You failed to upload " + name + " because the file was empty.";
			
		}
		
		return message;
		
    }

   


}
