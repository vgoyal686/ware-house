package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bean.InputFormBean;
import com.example.model.Gif;
import com.example.model.OrderRequest;
import com.example.model.User;
import com.example.model.Warehouse;
import com.example.repository.PageWrapper;
import com.example.service.IExcelService;
import com.example.service.IOrderRequestService;
import com.example.service.IUserService;
import com.example.service.WarehouseServiceImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class LoginController
{

	@Autowired
	private IUserService userService;
	@Autowired
	private WarehouseServiceImpl warehouseService;
	@Autowired
	private IExcelService excelService;

	@Autowired
	private IOrderRequestService orderRequestService;

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

		modelAndView.addObject("inputFormBean", new InputFormBean());
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

		}

		List<Warehouse> wareHouses = warehouseService.findWarehouses();
		modelAndView.addObject("wareHouses", wareHouses);
		modelAndView.setViewName("warehouseListing");
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
	public String index()
	{
		return "upload";
	}

	@RequestMapping(value = "/warehouse/listing", method = RequestMethod.GET)
	public ModelAndView viewWareHouses()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<Warehouse> wareHouses = warehouseService.findWarehouses();
		modelAndView.addObject("wareHouses", wareHouses);
		modelAndView.setViewName("warehouseListing");
		return modelAndView;
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes)
	{

		ModelAndView modelAndView = new ModelAndView();

		String message = "test";

		String name = file.getName();
		String originalName = file.getOriginalFilename();

		if (!file.isEmpty())
		{
			try
			{
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				long timestamp = System.currentTimeMillis() / 1000;
				File dir = new File(rootPath + File.separator + "tmpFiles/" + timestamp);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + originalName);
				String fileAbsolutePath = serverFile.getAbsolutePath();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				excelService.readFromExcelAndSaveToDb(fileAbsolutePath);
				System.out.println("\n\n\n  DATA SAVED SUCCESSFULLY TO DB \n\n\n ");
				message = "File uploaded successfully";
			}
			catch (Exception e)
			{
				message = "You failed to upload " + name + " => " + e.getMessage();

			}

		}
		else
		{
			message = "You failed to upload " + name + " because the file was empty.";

		}
		modelAndView.addObject("message", message);

		modelAndView.setViewName("result");
		return modelAndView;

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPost(String query)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("header");
		return modelAndView;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("inputFormBean") InputFormBean inputFormBean, BindingResult result,
			ModelMap model, final @RequestParam("file") MultipartFile file)
	{

		String originalName = file.getOriginalFilename();

		if (!file.isEmpty())
		{
			try
			{
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				long timestamp = System.currentTimeMillis() / 1000;
				File dir = new File(rootPath + File.separator + "tmpFiles/" + timestamp);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + originalName);
				String fileAbsolutePath = serverFile.getAbsolutePath();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				excelService.readFromExcelAndSaveToDb(fileAbsolutePath);
				System.out.println("\n\n\n  DATA SAVED SUCCESSFULLY TO DB \n\n\n ");

			}
			catch (Exception e)
			{

			}

		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("header");
		return modelAndView;

	}

	@RequestMapping(value = "students", method = RequestMethod.GET)
	public String showStudentBySurname(@RequestParam(value = "search", required = false) String search, Model model)
	{
		Iterable<OrderRequest> orderRequests = orderRequestService.listByCustomerID(search);
		model.addAttribute("search", orderRequests);
		return "students";
	}

	/*@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(Model uiModel, Pageable pageable)
	{
		PageWrapper<OrderRequest> page = new PageWrapper<OrderRequest>(
				orderRequestService.getAllOrderRequestWithPagination(pageable), "/blog");
		uiModel.addAttribute("page", page);

		return "blog";
	}*/

	@RequestMapping(value = "/orderRequest/listing", method = RequestMethod.GET)
	public ModelAndView blog(Pageable pageable)
	{

		ModelAndView m = new ModelAndView();
		m.addObject("orderRequests", orderRequestService.findAllOrderRequest());
		m.setViewName("orderRequest");
		return m;
	}
	

}
