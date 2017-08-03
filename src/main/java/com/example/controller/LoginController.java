package com.example.controller;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.bean.InputFormBean;
import com.example.bean.LEVEL;
import com.example.bean.OutData;
import com.example.model.InputTxn;
import com.example.model.InputTxnLevelMapping;
import com.example.model.OrderRequest;
import com.example.model.Role;
import com.example.model.User;
import com.example.model.Warehouse;
import com.example.repository.PageWrapper;
import com.example.service.IExcelService;
import com.example.service.IInputTxnLevelMappingService;
import com.example.service.IOrderRequestService;
import com.example.service.IInputTxnService;
import com.example.service.IUserService;
import com.example.service.WarehouseServiceImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Autowired
	private IInputTxnService inputTxnService;

	@Autowired
	private IInputTxnLevelMappingService inputTxnLevelMappingService;

	@RequestMapping(value = {  "/login" }, method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	/*
	 * @RequestMapping(value = { "/fileUpload" }, method = RequestMethod.GET)
	 * public ModelAndView excelFileTodb() { ModelAndView modelAndView = new
	 * ModelAndView();
	 * 
	 * modelAndView.addObject("inputFormBean", new InputFormBean());
	 * modelAndView.setViewName("excel-upload"); return modelAndView; }
	 */

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
	public String createNewUser(User user, BindingResult bindingResult)
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
			Role role = new Role();
			role.setRole("ADMIN");
			role.setId(1);
			Set<Role> roleSet = new HashSet<Role>();
			roleSet.add(role);

			user.setRoles(roleSet);
			userService.saveUser(user);
			return "redirect:/users/listing";
		}
		return "redirect:/registration";
	}

	@RequestMapping(value = "/users/listing", method = RequestMethod.GET)
	public ModelAndView usersListing()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.findAllUsers();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("usersListing");
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

	@RequestMapping(value = "create/view/orderRequest", method = RequestMethod.GET)
	public ModelAndView orderRequest()
	{
		ModelAndView modelAndView = new ModelAndView();
		Warehouse warehouse = new Warehouse();
		modelAndView.addObject("user", warehouse);
		modelAndView.setViewName("warehouse");
		return modelAndView;
	}

	@RequestMapping(value = "create/orderRequest/form", method = RequestMethod.GET)
	public ModelAndView creatOrderRequest()
	{
		ModelAndView modelAndView = new ModelAndView();
		OrderRequest orderRequest = new OrderRequest();
		modelAndView.addObject("orderRequest", orderRequest);
		modelAndView.setViewName("orderRequest");
		return modelAndView;
	}

	@RequestMapping(value = "create/data/orderRequest", method = RequestMethod.POST)
	public String createNewWareHouse(@Valid OrderRequest orderRequest, BindingResult bindingResult)
	{

		orderRequestService.saveOrderRequest(orderRequest);

		return "redirect:/search";

	}

	@RequestMapping(value = "/out/data/request", method = RequestMethod.GET)
	public ModelAndView createOutRequest(String query, Integer pageSize)
	{
		ModelAndView modelAndView = new ModelAndView();

		if (pageSize == null)
		{
			pageSize = new Integer(10);
		}
		List<String> levels = new ArrayList<String>();
		levels.add(LEVEL.LEVEL1.name());
		levels.add(LEVEL.LEVEL2.name());
		levels.add(LEVEL.LEVEL3.name());
		modelAndView.addObject("levelOptions", levels);
		PageRequest pageable = new PageRequest(0, pageSize);
		Page<InputTxn> paginated = inputTxnService.getAllWithPagination(pageable);

		PageWrapper<InputTxn> page = new PageWrapper<InputTxn>(paginated, "/inputTxn/paginated/listing");
		modelAndView.addObject("products", page.getContent());
		modelAndView.addObject("page", page);
		modelAndView.addObject("newWorkerValue", paginated.getContent());
		modelAndView.addObject("totalPages", page.getTotalPages());
		modelAndView.addObject("outData", new OutData());
		modelAndView.addObject("psize", pageSize);
		modelAndView.setViewName("outData");
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

	@RequestMapping(value ={"/", "/warehouse/listing"}, method = RequestMethod.GET)
	public ModelAndView viewWareHouses()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<Warehouse> wareHouses = warehouseService.findWarehouses();
		modelAndView.addObject("wareHouses", wareHouses);
		modelAndView.setViewName("warehouseListing");
		return modelAndView;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchPost(String query, Integer pageSize)
	{
		ModelAndView modelAndView = new ModelAndView();

		if (pageSize == null)
		{
			pageSize = new Integer(10);
		}

		PageRequest pageable = new PageRequest(0, pageSize);
		Page<OrderRequest> paginated = orderRequestService.getAllOrderRequestWithPagination(pageable);

		PageWrapper<OrderRequest> page = new PageWrapper<OrderRequest>(paginated, "/orderRequest/paginated/listing");
		modelAndView.addObject("products", page.getContent());
		modelAndView.addObject("page", page);
		modelAndView.addObject("newWorkerValue", paginated.getContent());
		modelAndView.addObject("totalPages", page.getTotalPages());

		modelAndView.addObject("psize", pageSize);
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

				List<InputTxn> savedInputTxns = inputTxnService.readFromExcelAndReturnAfterSaveToDb(inputFormBean,
						fileAbsolutePath);
				inputTxnLevelMappingService.readFromExcelAndSaveToDb(inputFormBean, fileAbsolutePath, savedInputTxns);
				// excelService.readFromExcelAndSaveToDb(fileAbsolutePath);
				System.out.println("\n\n\n  DATA SAVED SUCCESSFULLY TO DB \n\n\n ");

			}

			catch (Exception e)
			{
				e.printStackTrace();

			}

		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("successFormSubmission");
		return modelAndView;

	}

	@RequestMapping(value = "students", method = RequestMethod.GET)
	public ModelAndView showStudentBySurname(@RequestParam(value = "search", required = false) String search,
			Model model)
	{
		Iterable<OrderRequest> orderRequests = orderRequestService.listByCustomerID(search);
		model.addAttribute("orderRequests", orderRequests);
		ModelAndView modelv = new ModelAndView();
		modelv.setViewName("OrderRequestListing");
		return modelv;
	}

	@RequestMapping(value = "/searchFragment", method = RequestMethod.GET)
	public ModelAndView fragment()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchFragment");
		return modelAndView;
	}

	@RequestMapping(value = "/guests/{surname}", method = RequestMethod.GET)
	public String showGuestList(Model model, @PathVariable("surname") String surname)
	{
		model.addAttribute("guests", orderRequestService.listByCustomerID(surname));
		return "results :: resultsList";
	}

	@RequestMapping(value = "/guests", method = RequestMethod.GET)
	public String showGuestList(Model model)
	{
		model.addAttribute("guests", orderRequestService.findAllOrderRequest());
		return "results :: resultsList";
	}

	@RequestMapping(value = "/mergeForm", method = RequestMethod.GET)
	public ModelAndView id(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "customerId", required = false) String customerId,
			@RequestParam(value = "warehouseID", required = false) String warehouseID,
			@RequestParam(value = "orderID", required = false) String orderID)
	{

		ModelAndView modelAndView = new ModelAndView();
		InputFormBean inputFormBean = new InputFormBean();
		inputFormBean.setCustomerID(customerId);
		inputFormBean.setOrderID(orderID);
		inputFormBean.setWarehouseID(warehouseID);
		modelAndView.addObject("inputFormBean", inputFormBean);
		modelAndView.setViewName("excel-upload");
		return modelAndView;

	}

	@RequestMapping(value = "/orderRequest/paginated/listing", method = RequestMethod.GET)
	public String list(Model model, int page, int size)
	{
		PageRequest pageable = new PageRequest(page, size);
		Page<OrderRequest> paginated = orderRequestService.getAllOrderRequestWithPagination(pageable);
		model.addAttribute("orderRequests", paginated.getContent());
		return "OrderRequestListing :: resultsList";
	}

	@RequestMapping(value = "/inputTxn/paginated/listing", method = RequestMethod.GET)
	public String inputTxnListing(Model model, int page, int size)
	{
		PageRequest pageable = new PageRequest(page, size);
		Page<InputTxn> paginated = inputTxnService.getAllWithPagination(pageable);
		model.addAttribute("users", paginated.getContent());
		return "inputTransactionListing :: resultsList";

	}

	@RequestMapping(value = "/inputTransactions/listing", method = RequestMethod.GET)
	public ModelAndView inputTransactions(@RequestParam(value = "search", required = false) String search)
	{

		ModelAndView modelAndView = new ModelAndView();
		List<InputTxn> inputTransactions = inputTxnService.findInputTransactions();

		modelAndView.addObject("users", inputTransactions);
		modelAndView.setViewName("inputTransactionListing");
		return modelAndView;
	}

	@RequestMapping(value = "/outDataRequest", method = RequestMethod.POST)
	public String addNewPost(@Valid OutData outData, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "outData";
		}

		PageRequest pageable = new PageRequest(0, 1000);
		
		List<InputTxn> paginated = inputTxnService.findInputTransactions();
		String levelName = outData.getLevelName();
		String levelValue = outData.getLevelValue();
		int levelNo = 0;
		if(outData.getLevelCat().equals(LEVEL.LEVEL1.name())){
		  levelNo=1;
		}else if(outData.getLevelCat().equals(LEVEL.LEVEL2.name())){
		  levelNo=2;
		}else if(outData.getLevelCat().equals(LEVEL.LEVEL3.name())){
		  levelNo=3;
		}
		System.out.println(outData.getLevelCat());
		System.out.println(levelNo);
		List<InputTxnLevelMapping> inputTxnLevelMappings =  inputTxnLevelMappingService.findByLevelNameAndLevelValue(levelNo, levelName, levelValue);
		System.out.println(inputTxnLevelMappings);
		model.addAttribute("users", inputTxnLevelMappings);
		return "inputTransactionListing :: resultsList";

	}

	@RequestMapping(value = "/saveAndGetInputTxns", method = RequestMethod.POST)
	public String saveAndGetInputTxns(@RequestParam(value = "levelTxn[]") Integer[] levelTxn,@RequestParam(value = "inputTxn[]") Integer[] inputTxn)
	{

		PageRequest pageable = new PageRequest(0, 1000);
		List<InputTxn> paginated = inputTxnService.findInputTransactions();
		
		System.out.println(inputTxn + "\n" + levelTxn);
		List<Integer> inputTxnIds = Arrays.asList(inputTxn);
		for(Integer id : inputTxnIds){
		  System.out.println(id);
		}
		List<Integer> inputTxnLevelMappingIds = Arrays.asList(levelTxn);
        for(Integer id : inputTxnLevelMappingIds){
          System.out.println(id);
        }
		
		inputTxnLevelMappingService.markCorrespondingInputTxnLevelMappingsAsOutFromIds(inputTxnLevelMappingIds);
		inputTxnLevelMappingService.markCorrespondingInputTxnsAsOutFromIds(inputTxnIds);
		return "inputTransactionListing :: resultsList";

	}
	
	
	@RequestMapping(value = "/saveAndGetInputTxns/final", method = RequestMethod.POST)
	public String saveAndGetInputTxns(@RequestParam(value="levelTxn[]") String levelTxn)
	{  
		JSONObject jsnobject = new JSONObject(levelTxn);
		System.out.println(jsnobject.toString());
		//TODO add corresponding api 
	/*	PageRequest pageable = new PageRequest(0, 1000);
		List<InputTxn> paginated = inputTxnService.findInputTransactions();
		
		System.out.println(inputTxn + "\n" + levelTxn);
		List<Integer> inputTxnIds = Arrays.asList(inputTxn);
		for(Integer id : inputTxnIds){
		  System.out.println(id);
		}
		List<Integer> inputTxnLevelMappingIds = Arrays.asList(levelTxn);
        for(Integer id : inputTxnLevelMappingIds){
          System.out.println(id);
        }
		
		inputTxnLevelMappingService.markCorrespondingInputTxnLevelMappingsAsOutFromIds(inputTxnLevelMappingIds);
		inputTxnLevelMappingService.markCorrespondingInputTxnsAsOutFromIds(inputTxnIds);*/
		return "inputTransactionListing :: resultsList";

	}

}
